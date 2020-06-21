## Selendroid Test App
<br />
<br />

![alt text](https://images.g2crowd.com/uploads/product/image/social_landscape/social_landscape_195436b4987a33e5a9310f2f19d267f3/selendroid.png) 
##

## Introduction

`Selendroid Test App` is an Android App and it's purpose is to run the basic functionality of any mobile app

## Test Automation Framework

> ###### Setting Up The Environment `Windows` 💻

- `Java` as the programming language
- `TestNG` as the assertion framework
- `Maven` as the build tool for creating maven modules in this project to organize the structure of our Test Automation Framework.
- `Appium Driver` as the Mobile Automation Tool
- `IntelliJ` as an IDE
- `Nexus_5X_API_28` as an Emulator 
- `Appium` as an Automation Framework
- `GIT` as the Source Control
> ###### Project Structure
`java`
- `Base` repository comprises of Base Variable and WebDriver's
- `DataProvider` provides essential data 
- `Features` repository comprises of test cases and scenarios that deals twith the functionality of an app 
- `Pages` repository comprises components and locators of each webpage
- `Runner` repository comprises classes of ngTestListeners and TestRunner
- `Steps` repository comprises mapping of features to the POM
- `Utilities` repository comprises classes of  Hook, ReadExcel and etc.

`resources`
- `APKLocation` Repository comprises the path of the APK
- `Configuration` Repository comprises Config.properties
- `ExcelFiles` Repository comprises of Worksheet (Excel/CSV)

> ###### Testing Approach
Automated test scripts are designed in `BDD` fashioned and is based on data-driven development approach. 
The data that should be entered into input fields during an automated test is usually stored in an external file.
This data might be read from a data source like worksheet `(Excel/CSV File)`
> ###### Test Cases to Automate

> ###### Reporting Mechanism


Working of the Test Cases:
	This script runs the Registration Process for a new user 
