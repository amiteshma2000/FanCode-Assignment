
![Logo](https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT1naYJPWoG7nzRH8s32xPtFRd4BfnV80gL2kwyTPeY&s)
# Fancode SDET Assignment Solution 📒

This is a small automation framework for ensuring that the users in Fancode city 🏙️ have completed more than 50% of their tasks📜 based on their ToDos.

## Prerequisites
Before using this framework, ensure that you have following installed on you machine:

* Java Development Kit (JDK) ☕
* Maven Build tool
* Eclipse or IntelliJ any Integrated Development Environment (IDE) 💻

## Getting Started ▶️

1. Clone the repository on local machine
  ```console
git clone https://github.com/Anic10x3/FancodeAssignmentTest.git
  ```
2. Open the project in your preferred IDE

3. Build the project using Maven to resolve the dependencies

## Running Test 🏃
To run the automted test, follow these steps

4. Right click on the testng.xml file and Click Run as Testng suite 

5. Test results will be displayed in the console along with users in FanCode city with their Todos completion percentage

6. ExtentReport will be generated for the result 

## About the framework

### Test Configurations 🛠️
src\test\resources\features :
  * folder contains feature files the describes a behavior of the feature
src\test\java\stepdefinitions
  * contains stepdefs that have steps to performs the actions specified in the scenarios
src\test\java\utilities
  * includes ExtentReportManager file that handles the configuration and creation of Extent Reports
src\test\java\runners
  * contains TestRunner file that helps organizing and running the test cases efficiently
    
### Test API Endpoints 🔗
 src\test\java\endpoints :
  * Endpoints file contains the Response get method, we can implement more methods further
  * Routes cotains the setUp method to set the BASE_URI

### Test Results 🚀
  * Test results will be displayed in the console as well as Extent Report will be generated in Reports folder

## Tools and Technologies used 💻
  * Java
  * Rest Assured
  * Cucumber
  * TestNG
  * Maven
  * Extent Reports
  * Eclipse

