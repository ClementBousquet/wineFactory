# wineFactory
Energie vin

# To do before setting up your development environment

- install Java [https://jdk.java.net/java-se-ri/20]()
- install Docker [https://docs.docker.com/engine/install/]()
- install Docker Compose [https://docs.docker.com/compose/install/]()
- install your favorite IDE (IntelliJ, Eclipse, Visual Source Code...). This documentation assume you are a JetBrains
  user.

# How to setup your local development environment

## Setting up docker

- run [docker-compose.yml](docker-compose.yml)

## Setting up wine factory

- run `mvn clean install`

# Run the application in local

- use your IDE to create a run configuration
  from [WineApplication.java]
- use VM options `--add-opens java.base/java.lang=ALL-UNNAMED` to use proxy beans in spring configuration classes
- use profile `local`

# Enhancement proposal

- Security strategy
- Integration tests
- Unitary test overage
- Client/Server parts
