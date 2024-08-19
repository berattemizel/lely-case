# Lely Test Automation Suite

This project is an automation test suite for **Lely**. The project includes both API and UI tests, utilizing `TestNG` as the test framework. This README provides instructions on setting up, configuring, and running the tests in the suite.

## Table of Contents

- [Project Overview](#project-overview)
- [Prerequisites](#Prerequisites)
- [Dependencies](#Dependencies)
- [Project Structure](#project-structure)
- [Setup Instructions](#setup-instructions)
- [Running Tests](#running-tests)


## Project Overview

The **Lely Test Automation Suite** is designed to validate the functionality of both API endpoints and UI interactions. API tests ensure the correctness of RESTful API responses, while UI tests automate user interactions on the Lely website.


## Prerequisites

To run this project, you need to have the following installed:

- Java 17
- Maven 3.x
- A modern web browser (e.g., Chrome)


## Dependencies

This project uses the following dependencies, managed via Maven:

- **REST-Assured** for API testing
- **Selenium WebDriver** for UI testing
- **TestNG** as the testing framework
- **WebDriverManager** to manage browser drivers
- **SLF4J** and **Logback** for logging
- **JSON** for handling JSON data


## Project Structure

- **src/main/java/com/example/api**
  - `BaseAPI.java` : Base class for API testing, containing common methods and setup.
  - `UserAPI.java` : Class containing specific API tests related to user endpoints.

- **src/main/java/com/example/selenium**
  - `BaseTest.java` : The parent class for all Selenium-based tests, containing common setup and teardown methods.
  - `SearchPage.java` : Page Object Model (POM) class for search page-related actions.
  - `TechDocsPage.java` : POM class for tech documents page-related actions.

- **src/main/java/com/example/utils**
  - `Constants.java` : Defines constants used throughout the project, such as URLs and paths.

- **src/test/java/com/example/tests**
  - `DocumentTest.java` : Test class for verifying document-related functionalities on the Lely website.
  - `SearchTest.java` : Test class for verifying search functionalities on the Lely website.
  - `UserAPITest.java` : Test class for validating user-related API endpoints.

- **downloads**
  - Contains downloaded files from test cases (e.g., `D-S006VT_-.pdf`).

- **testng.xml**
  - Configuration file for TestNG, specifying the test suites and test cases to be executed.

- **pom.xml**
  - Maven project configuration file, managing project dependencies, plugins, and build configurations.


## Setup Instructions

1. Clone the repository:
```bash
git clone https://github.com/berattemizel/lely-case.git
```
2. Navigate to the project directory:
```bash
cd test-automation
```
3. Install dependencies:
```bash
mvn clean install
```

## Running Tests
```bash
mvn test
```
