# MOBIQUITY QA CODE CHALLENGE

## Task
For this task, imagine you are a part of the team that performs quality assurance for a user blog. T
he frontend design is not yet developed, but the API has already been published here: https://jsonplaceholder.typicode.com/. 
If the service is not available or you prefer to have it on your local machine follow the instructions described in the 
section “Start the service locally” below. You can help the developers on your team make the feature more robust, 
by helping them write tests for some workflows that they might break while making progress with developing business logic. 
The task is: 
  
   ● To create a test automation framework skeleton.

   ● To perform the validations for the comments for the post made by a specific user.

## Flow to be tested
   ● Search for the user with username “Delphine”. 

   ● Use the details fetched to make a search for the posts written by the user. 

   ● For each post, fetch the comments and validate if the emails in the comment section are in the proper format. 

   ● Think of various scenarios for the test workflow, all the things that can go wrong. Add them to test coverage.

## Start the service locally
   ● Clone the repository https://github.com/typicode/jsonplaceholder 

   ● Install NodeJS(The Latest LTS version should be sufficient)

   ● Open the terminal in the root of the cloned repository 

   ● Run the command npm install 

   ● Run command node index.js 

   ● The services will start at address: http://localhost:3000/

## Project Requirements:
   ● Clone the repository https://github.com/ErDmYLmZ/MobiquityCodeChallenge.git

   ● Be sure that the http://localhost:3000/ up and running

## Test Cases
   ● To reach the testcases go to "testCases/Mobiquity QA CodingChallenge Test Cases.xlsx"

## Usage
   ● To run all the tests via TestRunner class, go to "src/test/java/runners/TestRunner.java" and click on the "Run" button.

   ● To run all the tests via Terminal, type "mvn clean verify" and hit enter.

   ● To run all the tests via Maven tab, click on Maven tab then double-click on "verify".

   ● To run a single test, go to "src/test/resources/features" file select the regarding feature file and click on the "Run" button.

## Test Reports
   ● To see the "ExtentPdf" reports go to "testReports/pdfReport/ExtentPdf.pdf" and double-click.
  
   ● To see the detailed "Spark" reports go to "testReports/sparkReport/Spark.html" and right click/Open In/Browser/Chrome
  
   ● To reach out the test reports via "Circle CI" commit and push to gitlab repository, it will automatically trigger the Circle Ci then go to "https://app.circleci.com/pipelines/github/ErDmYLmZ/MobiquityCodeChallenge", click on success link, click on "built-and-test" link, click on "ARTIFACTS" and click on the "~/test-results/junit/Spark.html" link. 

## Postman Collection
   ● Postman collection is ready as Json format in the "PostmanCollection" directory. It can be imported to postman.

### Dependencies
   ● io.rest-assured/rest-assured/5.2.0

   ● io.cucumber/cucumber-java/7.8.1

   ● io.cucumber/cucumber-junit/7.8.1

   ● commons-validator/commons-validator/1.7

   ● org.json/json/20220924

   ● org.slf4j/slf4j-simple/2.0.3

   ● tech.grasshopper/extentreports-cucumber7-adapter/1.7.0

   ● net.masterthought/cucumber-reporting/5.0.0

### Plugins
   ● org.apache.maven.plugins/maven-surefire-plugin/2.22.2

   ● net.masterthought/maven-cucumber-reporting/5.0.0

##Help
   In case of any support/question please contact  "erdemyilmaz4@gmail.com".



































