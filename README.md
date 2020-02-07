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
![alt text](https://raw.githubusercontent.com/ramondepieri/uiAutomationPureJavaSelenium/master/documentation/report1.png)

###### Report example:
![alt text](https://raw.githubusercontent.com/ramondepieri/uiAutomationPureJavaSelenium/master/documentation/report2.PNG)