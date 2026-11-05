package org.betamc
import io.ktor.http.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.apache.commons.text.StringEscapeUtils.escapeXml10

private val BASE_URL: String = System.getenv("BASE_URL")
    ?: throw IllegalStateException("BASE_URL environment variable is required")

fun Routing.sitemap() {
    val root = this as RoutingNode

    get("/sitemap.xml") {
        val paths = root.getAllRoutes()
            .asSequence()
            .filter { it.selector == HttpMethodRouteSelector(HttpMethod.Get) }
            .map { route ->
                val segments = generateSequence(route) { it.parent }
                    .toList()
                    .asReversed()
                    .mapNotNull {
                        when (val selector = it.selector) {
                            is RootRouteSelector -> null
                            is HttpMethodRouteSelector -> null
                            is PathSegmentConstantRouteSelector -> selector.value
                            else -> return@mapNotNull null
                        }
                    }

                "/" + segments.joinToString("/")
            }
            .filterNot {
                it.startsWith("/static/") ||
                    it == "/sitemap.xml" ||
                    it == "/robots.txt"
            }
            .distinct()
            .sorted()
            .toList()

        val xml = buildString {
            appendLine("""<?xml version="1.0" encoding="UTF-8"?>""")
            appendLine("""<urlset xmlns="http://www.sitemaps.org/schemas/sitemap/0.9">""")

            paths.forEach {
                appendLine("  <url><loc>${escapeXml10(BASE_URL + it)}</loc></url>")
            }

            appendLine("</urlset>")
        }

        call.respondText(xml, ContentType.Application.Xml)
    }
}
