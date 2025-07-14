# Practo Automation Testing

This repository contains automated test cases for Practo's hospital and diagnostics search functionalities. The tests are designed to validate various aspects of the Practo platform, including hospital listings, diagnostics, and UI elements, using Selenium WebDriver and TestNG.

## Features

- Automated UI tests for Practo hospital and diagnostic search
- Generates detailed HTML reports using ExtentReports
- Captures screenshots on test success and failure
- Supports cross-browser testing (configurable via TestNG parameters)
- Modular test structure for easy maintenance and scalability

## Technologies Used

- **Java**
- **Selenium WebDriver**
- **TestNG**
- *Cucumber BDD*
- **ExtentReports** (for reporting)
- **Maven** (for dependency management)

## Project Structure

```
.
├── src
│   └── test
│       ├── java
│       │   ├── TestCases/              # Test case classes
│       │   └── Utills/                 # Utilities (e.g., ExtentsReports.java)
│       └── resources                   # Test resources (e.g., testng.xml)
├── Reports/                            # Generated ExtentReports HTML reports
├── test-output/                        # TestNG generated reports
└── pom.xml                             # Maven configuration
```

## Getting Started

### Prerequisites

- Java JDK 8 or higher
- Eclipse
- Maven
- ChromeDriver, EdgeDriver, or other WebDriver binaries (ensure they are in your PATH)

### Installation

1. **Clone the repository:**
   ```sh
   git clone https://github.com/BhavanaPolnidi/Practo-automation-testing.git
   cd Practo-automation-testing
   ```


### Running Tests

1. **Configure browsers and other parameters** in your `testng.xml` or as system properties.

2. **Run the tests using testng.xml**
   

3. **View the reports:**
   - ExtentReports HTML: Open `Reports/HospitalsReport.html` or files in the `ExtentReports/` directory.
   - TestNG HTML reports: See the `test-output/` directory.

## How It Works

- Test execution is managed by TestNG.
- The listener `ExtentsReports` (in `src/test/java/Utills/ExtentsReports.java`) hooks into test events to log results and generate rich HTML reports.
- On test completion, reports are automatically opened for review.
- System info, environment, and browser details are added to the reports for traceability.

## Contributors

- Polnidi Bhavana

## License

This project is for educational and demonstration purposes.

---

*Happy Testing!*
