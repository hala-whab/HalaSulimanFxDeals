# Default target
.PHONY: runApp
runApp: buildJar dockerBuild dockerUp

# Build the application
.PHONY: buildJar
buildJar:
	mvn clean package


# Run tests
.PHONY: test
test:
	mvn test

.PHONY: dockerBuild
dockerBuild:
	docker-compose build

.PHONY: dockerUp
dockerUp:
	docker-compose up

# Help menu
.PHONY: help
help:
	@echo "Usage:"
	@echo "  make runApp      - run the application "
	@echo "  make buildJar    - build jar with maven"
	@echo "  make dockerBuild - build image"
	@echo "  make dockerUp    - Start Container "
	@echo "  make test        - run mvn tests"
