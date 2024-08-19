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

├── pom.xml                            # Maven configuration file
├── downloads
│   ├── D-S006VT_-.pdf
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── example
│   │   │           ├── api           # Base classes for API tests
│   │   │           │   ├── BaseAPI.java
│   │   │           │   └── UserAPI.java
│   │   │           ├── selenium      # Base classes for UI tests
│   │   │           │   ├── BaseTest.java
│   │   │           │   ├── SearchPage.java
│   │   │           │   └── TechDocsPage.java
│   │   │           └── utils         # Utility classes and constants
│   │   │               └── Constants.java
│   └── test
│       ├── java
│       │   └── com
│       │       └── example
│       │           └── tests         # Test classes
│       │               ├── DocumentTest.java
│       │               ├── SearchTest.java
│       │               └── UserAPITest.java
└── testng.xml                         # TestNG configuration file


## Setup Instructions

Clone the Repository:
git clone https://github.com/kullaniciadi/test-automation.git
cd test-automation
Install Dependencies:
mvn clean install

## Running Tests

mvn test