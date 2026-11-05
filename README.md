# BetaMC.org Website

TODO:
- GitHub CI with push of prod image to registry, so we dont have to deploy the entire repo, will need its own deploy repo with traefic integration

## Local development

- `cp .env.example .env`
- `docker compose up -d --build`
- Grab a tea, maybe a beer, wait for a few minutes for Gradle to warm up
- Go to http://localhost:8080
