# CloudStackWeConnectProject - Login Page Test Automation
This project automates the testing of the WeConnect login page. The test data is sourced from Excel files and TestNG is used for the integration of test execution. Extent Reports is integrated for generating interactive test reports. The automation framework is designed to enhance the automation testing for the WeConnect login feature.


## Project Overview
This project automates the testing process for the **WeConnect** login page using Selenium WebDriver, TestNG, and Extent Reports. The goal is to validate various login scenarios such as valid login, invalid credentials, using a data-driven testing approach with Excel files.

## Features
- **Automated Login Tests**: Automates the login functionality of the WeConnect web application.
- **Data-Driven Testing**: Fetching test data (username, password) from an Excel file.
- **TestNG Execution**: Managing test execution using TestNG.
- **Reports**: Generating test execution reports using Extent Reports.
- **Modular Framework**: Utilizes the Page Object Model (POM) design pattern for better code maintainability and scalability.

## Prerequisites
Before you can run this project, make sure you have the following installed on your system:
- **Java Development Kit (JDK) 8** or higher
- **Maven** (for managing dependencies and building the project)
- **TestNG** (for structuring and executing tests)
- **Edge Browser** (latest version)
- **EdgeDriver** (compatible with your Edge version)

## Project Structure
The project follows a modular structure to ensure clean separation of test logic and page interactions:
- `src/test/java/com/weconnect/TestCases`: Contains the TestNG test scripts.
- `src/main/java/com/weconnect/pageObjects`: Page classes that interact with UI elements of the Login page (Page Object Model).
- `testData`: Contains the Excel file.
- `reports`: Generated test reports (Extent Reports).

## Installation
### 1. Clone the Repository
To get started, clone the project repository from GitHub:
git clone https://github.com/yourusername/weconnect-login-automation.git
cd CloudStackWeConnectProject.

## Instructions

  ### 1. Reviewing the Test Code
  - The test scripts are located in `src/test/java/com/weconnect/tests`.
  - Main test script: `LoginPageTest.java` — This file contains the test cases for login functionality, including tests for valid and invalid login scenarios

  ### 2. Data-Driven Testing
  - After the **WeConnect Login Page** loads, the test data for the login (username and password) is dynamically fetched from an Excel file.
  - The test data is stored in the `testData` folder, and the project uses **Apache POI** to read the test data from the Excel sheet during execution.
  
  ### 3. Handling reCAPTCHA
  - The login page contains a **reCAPTCHA** checkbox labeled **"I am not a robot"**.
  - While the **reCAPTCHA checkbox** is automated and can be clicked programmatically, if image verification is required (where the page asks to click specific images), this step must be done manually because **Google's reCAPTCHA is designed to block automation bots**.
  - To allow time for manual interaction:
    - I have implemented **explicit waits** and a **Java thread sleep** to pause the test execution, giving time to complete the reCAPTCHA image selection manually.
    - Once the reCAPTCHA verification is completed, the automation script will resume and complete the login process automatically.
  
  ### 4. Running the Tests
  - Ensure that the **reCAPTCHA** step is handled manually during the test execution.
  - After solving the reCAPTCHA manually, the script will proceed with testing login functionality automatically, including verifying success and failure scenarios.
  
  ### 5. Viewing the Test Reports
  - After running the tests, open the **Extent Report** located in the `reports` folder to view the detailed test results, including screenshots and logs.





