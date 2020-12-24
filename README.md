# AmazonShopping



MotorolaSolutions Group Web Page Testing Exercise / Instructions
Codes and Tests Prepared by: Murat Zeybek

- Build Tool: Maven 
- Dependencies : Selenium-Java ,Bonigarcia-WebDriverManager, Cucumber J-Unit, testNG, Cucumber Java, Surefire, Cucumber Reporting

- Test Framework: Cucumber BBD (with JUnit Assertions) based on Page Object Model(POM)

WebPage URL :
https://www.amazon.co.uk/


QA Task:
Write and automate E2E test scenarios which satisfy below 5 conditions:

1: Users should be able to select "Books" options from drop down and search for the book named Harry Potter and the Philosopher's Stone
2: Check if Book is a "Best Seller" or Not?
3: Verify other author and book related information from the search page
4: Check if Book is available in the format of an Kindle Edition?
5: Select the book and proceed towards Check Out. Select "Create Your Amazon Account" if user do not have an account and verify all fields available on "Create Your Amazon Account" page  

Acceptance Criteria:
● Validate search functionality on homepage
● Validate the sought product is filtered list
● Validate the Best Seller functianality
● Validate the info is related to the product 
● Validate the advertised product are related and available
● Validate the checkout process is working correctly
● Validate the create new account page elements in place

System Requirements:
Java 8+ SDK
Test RUN by using JUnit



Cucumber Test Feature Scenarios:

  @wip
  Scenario: Searching a product from menu, verify the features and the check out
  
    Given Users should be able to select "Books" options from drop down
    And Search for the book named "Harry Potter and the Philosopher's Stone"
    Then Check if Book is a "Best Seller" or Not
    And Verify other "author" and "book" related information from the search page
    Then Check if Book is available in the format of an "Kindle Edition"?
    And Select the book and "proceed towards Check Out"
    Then Select Create Your Amazon Account if user do not have an account
    And verify all fields available on Create Your Amazon Account page
   


### To run this file from CommanLine and IDE as Intellij from high level.

Clonning a repository using the command line: Please click the below link on GitHub and navigate to the main page of the repository.

https://github.com/gm-zeybek/AmazonShopping

Above the list of files, there is a green button named please click on that.

To clone the repository using HTTPS, under "Clone with HTTPS", please click on the square on the right of the Https link, it will copy the link.

Please go to the Terminal.

Change the current working directory to the location where you want the cloned directory.

Type git clone, and then paste the URL you copied earlier, it will show like below;

$_git clone https://github.com/gm-zeybek/AmazonShopping.git Press to create your local clone.

To run the program from commandLine please type followings:

$_ mvn test

$_ mvn clean test

$_ mvn clean compile test

To run our file on one of IDE, I prefer IntellijIDE for this file.

Running a clonned programme from Intellij Please open the intellijIDE.

Navigate the file and click to open.

It should open the file in the IDE.
