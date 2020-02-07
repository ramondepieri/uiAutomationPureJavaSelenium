# Challenge automation pure java selenium

# Environment
  - Java 8
  - maven
  - some IDE
  - linux, windows or mac
  - broswer

# Drivers

The drivers are prepared to work with chrome 79 version and firefox > 60. Each operation system has your own driver. In necessity of update the driver the name should be kept. Example:
![alt text](https://raw.githubusercontent.com/ramondepieri/uiAutomationPureJavaSelenium/master/documentation/drivers.PNG)

# Run the automation

You can do this in 2 ways.

##### 1 - Using IDE:

For example, using intelliJ IDEA by JetBrains, 
* Right click on file testng.xml
* Run
Example:
![alt text](https://raw.githubusercontent.com/ramondepieri/uiAutomationPureJavaSelenium/master/documentation/run_ide.png)

##### 2 - Using maven:
```sh
$ mvn test -f pom.xml
```

# Test results

The test report can be found in folder project TestReport. This report has a natural language with the tests steps, screenshots, trhow exceptions etc...
![alt text](https://raw.githubusercontent.com/ramondepieri/uiAutomationPureJavaSelenium/master/documentation/report1.PNG)

###### Report example:
![alt text](https://raw.githubusercontent.com/ramondepieri/uiAutomationPureJavaSelenium/master/documentation/report2.PNG)

# Configuration:

All automation config are made in testng.xml file.

#### automation config:
 * thread-count -> you should specify a number to run parallel tests.
 * url-base -> to change the url that will be tested.
 * browser -> change de broswer
 * generate-test-evidence -> "N" or "Y". By default, the screenshots working only when the test fail. But if this option be equals "Y" the test that successed will take a screenshot to evidence the test.

#### test data config:
 * product-name -> you can choose the product by name
 * product-size -> you can choose the product size. Options: 1, 2 or 3.
 * product-color -> name of color

Example:
![alt text](https://raw.githubusercontent.com/ramondepieri/uiAutomationPureJavaSelenium/master/documentation/testng_config.PNG)

# Project structure

The java and files are organized in this way:
 * core/driver -> Driver factory and manager
 * core/report -> extent report factory and manager
 * core/suite -> base test and testng listener
 * core/utils -> random data and others utils
 * page -> all pages of automation. The project is using PageObject pattern
 * testcase -> the project tests
 * resources -> drivers
 * 
Example:
![alt text](https://raw.githubusercontent.com/ramondepieri/uiAutomationPureJavaSelenium/master/documentation/project_structure.PNG)