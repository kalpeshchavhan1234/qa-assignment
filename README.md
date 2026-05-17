# QA Assignment

I have completed the QA assignment successfully.

## Manual Testing
- Created detailed test cases for Login, Cart, and Checkout modules.
- Added bug reports with proper steps, expected result, actual result, and severity.
- Included screenshots for identified issues.

## Project Structure
The project contains the following files/folders:

1. Excel file containing:
   - Bug Document sheet
   - Test Cases sheet

2. Screenshots folder
   - Bug , mobile testing, and API testing screenshots

3. Automation Code
   - Selenium automation scripts in src/test/java SauceDemoTest.java
  
4. Postman API Testing
   - QA assignment collection JSON file
## Automation Testing
- Automated important scenarios using Selenium WebDriver.
- Covered:
  - Successful Login
  - Add Product to Cart
  - Checkout Flow
- Implemented cross-browser testing.

## Responsive / Mobile Testing
- Performed responsive testing using browser developer tools/mobile view.
- Verified application behavior on mobile screen sizes.
- Identified one UI issue where excessive spacing was displayed between product details and product price in mobile view.
- Attached screenshots for the observed issue.

## API Testing
- Performed API testing using JSONPlaceholder dummy APIs.
- Tested multiple HTTP methods:
  - GET
  - POST
  - PUT
  - DELETE
- Attached API testing screenshots in the screenshots folder.
 


## Prerequisites

Make sure the following are installed:

- Java
- Maven
- Chrome Browser
- Selenium and TestNG dependencies

All required dependencies are available in the `pom.xml` file.

## How to Run the Project

1. Clone the repository

git clone <https://github.com/kalpeshchavhan1234/qa-assignment.git>

2. Open the project in Eclipse or IntelliJ IDEA

3. Run the project using terminal/cmd:

```bash
mvn test
```
Or run SauceDemoTest.java directly from the IDE.
