# Project 24

## 🚀 FastTrackIT
**👤 Student:** Alexandru Ratiu  
**🌐 Website:** [Ecommerce Playground by LambdaTest](https://ecommerce-playground.lambdatest.io/)

---

## 🛠 Technologies Used
- **Programming Language:** Java
- **IDE:** IntelliJ IDEA
- **Web Testing Framework:** Selenium WebDriver
- **Build Automation:** Maven
- **Test Framework:** TestNG
- **Version Control Software:** Git
- **Repository Service:** GitHub

---

## 📄 Description

**Project 24** comprises 10 test classes containing a total of 30 tests, specifically tailored for various pages of the [Ecommerce Playground](https://ecommerce-playground.lambdatest.io/) website by LambdaTest. 

### Setup Procedure

1. **Download Selenium Client for Java:** Initial configuration for the project.
2. **Framework Support with Maven:** Set up as the build system.
3. **Dependencies:** Added necessary dependencies in `pom.xml` for:
   - Selenium Java
   - Selenium ChromeDriver
   - TestNG

### Project Structure

Each page is represented by a class with attributes and methods to facilitate individual tests. The `BasePage` class was created to declare the `WebDriver` variable, serving as the superclass in the project hierarchy. All other classes inherit from this superclass. Each page class has a constructor with the parameter `driver`, designed to store the `WebDriver` instance. The `TestUtil` class, part of the utility package, contains methods to streamline and structure tests (e.g., random email generation) and efficiently utilize locators across various website sections.

### 🧩 Test Class Structure

- **Driver Declaration:** Establishes interaction with web pages during tests, including pages necessary for testing.
- **Initialization:**
  - `@BeforeClass`: Executes `SetUp()`, initializing the `WebDriver`, creating a new `ChromeDriver` instance, and maximizing the browser window.
  - `@BeforeMethod`: Executes before each test method, navigating the `driver` to the specified URL and initializing page objects.

### 🔍 Test Execution

- **Test Methods (`@Test`):** Names suggest scenarios, calling methods from page classes to execute test steps.
- **Validation:** Ensures each step on the respective page is verified against the chosen scenario using TestNG assertions.
- **Delays:** Intentional delays ensure successful page loads and prevent potential errors.
- **Automation Handling:** Utilizes methods such as `ExecuteScript()` via `JavascriptExecutor` for scrolling and checkbox interactions.

### 📝 Utility Methods

- **Organization:** Methods like `registerProcess()` or `fullOrderMethod()` organize tests within the test class, ensuring accuracy before execution.
- **Cleanup:** The `tearDown()` method, annotated with `@AfterTest`, closes the browser session with `driver.quit()` after each test.

---

