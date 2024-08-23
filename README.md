# UniversitySearchAPI

UniversitySearchAPI is a Spring Boot-based RESTful web service that allows users to search for universities around the world. The API supports querying universities by country, as well as retrieving a complete list of all universities from an external public API.

## Table of Contents

- [Features](#features)
- [Architecture](#architecture)
- [Installation](#installation)
- [Configuration](#configuration)
- [Usage](#usage)
- [API Endpoints](#api-endpoints)
- [Testing](#testing)
- [Deployment](#deployment)
- [Contributing](#contributing)
- [License](#license)

## Features

- **Search Universities by Country**: Fetch a list of universities based on the country name provided.
- **Retrieve All Universities**: Get a complete list of all universities.
- **RESTful API**: Designed using RESTful principles.
- **External API Integration**: Integrates with [Hipolabs University API](http://universities.hipolabs.com) for real-time data.

## Architecture

The application is built using the following components:
- **Spring Boot**: Framework used for building the RESTful API.
- **RestTemplate**: Used for making HTTP requests to the external API.
- **Maven**: Dependency management and build tool.
- **Java**: Language used to develop the application.

## Installation

### Prerequisites

- Java 17 or higher
- Maven 3.6.0 or higher
- Git (optional, for cloning the repository)