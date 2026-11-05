# website

This project was created using the [Ktor Project Generator](https://start.ktor.io).

Here are some useful links to get you started:
 * [Ktor Documentation](https://ktor.io/docs/home.html)
 * [Ktor GitHub page](https://github.com/ktorio/ktor)
 * [Ktor Slack chat](https://app.slack.com/client/T09229ZC6/C0A974TJ9). [Request an invite](https://surveys.jetbrains.com/s3/kotlin-slack-sign-up).


## Features
Here's a list of features included in this project:

| Name | Description |
|------|-------------|
| [Default Headers](https://start.ktor.io/p/io.ktor/server-default-headers) | Adds a default set of headers to HTTP responses |
| [AutoHeadResponse](https://start.ktor.io/p/io.ktor/server-auto-head-response) | Provides automatic responses for HEAD requests |
| [Caching Headers](https://start.ktor.io/p/io.ktor/server-caching-headers) | Provides options for responding with standard cache-control headers |
| [Conditional Headers](https://start.ktor.io/p/io.ktor/server-conditional-headers) | Skips response body, depending on ETag and LastModified headers |
| [Static Content](https://start.ktor.io/p/io.ktor/server-static-content) | Serves static files from defined locations |
| [Status Pages](https://start.ktor.io/p/io.ktor/server-status-pages) | Provides exception handling for routes |
| [Call Logging](https://start.ktor.io/p/io.ktor/server-call-logging) | Logs client requests |
| [Compression](https://start.ktor.io/p/io.ktor/server-compression) | Compresses responses using encoding algorithms like GZIP |
| [Pebble](https://start.ktor.io/p/io.ktor/server-pebble) | Allows you to use Pebble templates as views within your application |


## Building & Running
To build or run the project, use one of the following tasks:


| Task | Description |
|------|-------------|
| `./gradlew test`    | Run the tests     |
| `./gradlew build`   | Build the project |
| `./gradlew run`     | Run the server    |

If the server starts successfully, you'll see the following output:
```
2024-12-04 14:32:45.584 [main] INFO  Application - Application started in 0.303 seconds.
2024-12-04 14:32:45.682 [main] INFO  Application - Responding at http://0.0.0.0:8080
```
a
