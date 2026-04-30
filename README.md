# Selenium Test Automation Framework

 UI test automation framework using **Java**, **Selenium WebDriver**, **TestNG**, **Maven**, and the **Page Object Model (POM)** pattern.

This project is designed to demonstrate practical skills for Software Engineer / SDET / Test Automation roles, including reusable page objects, dynamic XPath selectors, browser configuration, and CI execution with GitHub Actions.

## Tech Stack

- Java 17
- Selenium WebDriver
- TestNG
- Maven
- WebDriverManager
- GitHub Actions

## What This Framework Demonstrates

- UI automation with Selenium WebDriver
- TestNG-based test execution
- Page Object Model for maintainable test structure
- Dynamic XPath usage for reliable element targeting
- Driver setup through a reusable factory class
- Headless browser execution for CI/CD
- GitHub Actions workflow for automated test runs

## Project Structure

```text
selenium-test-framework/
├── .github/workflows/selenium-tests.yml
├── src/test/java/com/mrasmussen/
│   ├── pages/
│   │   ├── LoginPage.java
│   │   └── SecureAreaPage.java
│   ├── tests/
│   │   └── LoginTest.java
│   └── utils/
│       ├── BaseTest.java
│       └── DriverFactory.java
├── pom.xml
├── testng.xml
└── README.md
```

## Prerequisites

Install:

- Java 17+
- Maven
- Chrome or Firefox

Verify your setup:

```bash
java -version
mvn -version
```

## Run Tests Locally

Run tests in Chrome:

```bash
mvn clean test
```

Run tests in headless Chrome:

```bash
mvn clean test -Dheadless=true
```

Run tests in Firefox:

```bash
mvn clean test -Dbrowser=firefox
```

Run tests in headless Firefox:

```bash
mvn clean test -Dbrowser=firefox -Dheadless=true
```

## Demo Application Under Test

This starter project tests the login page from:

```text
https://the-internet.herokuapp.com/login
```

Valid credentials used by the test:

```text
Username: tomsmith
Password: SuperSecretPassword!
```

## Resume Bullet You Can Use

Built a Selenium WebDriver test automation framework using Java, TestNG, Maven, and Page Object Model, implementing reusable page objects, dynamic XPath selectors, and CI-based test execution through GitHub Actions.

## Future Enhancements

- Add negative login test coverage
- Add screenshot capture on failure
- Add REST API validation tests
- Add parallel test execution
- Add Cucumber BDD scenarios
- Add test reports through Allure or ExtentReports
