Automation design:
1. as I can see the test steps in test cases they all are same. Except the output will be different.
2. I will be executing the same test case with multiple test data for this I used data provider
3. I will be writing one test script for this 13 test cases each test case will get test data from data
provider
4. Able to cover 13 test cases where 12 passed and 1 fail.  
5. If we want to test with other data all we need to do is add the test data to json file
6. Tests execution with testng.xml files
7. Have Automated 13 Test cases 12 passed and 1 failed please refer to the Excel sheet on the same.

Test Automation folders:
8. Have created base, pages and tests packages
BaseTest:
9. Have created BaseTest class in Base such that it is responsible for the initialising and quiting the driver
10. Have used before and after method for intializing and quiting the driver so for every test case the driver 
is initialized and quit after the test case
11. create explicit wait method "waitForElementToDisplay" to use it across all the elements.
HomePage:
12. In home page have created locators and action methods using page factory and intialized using method
initelements. Have followed pom model
Tests:
13. In UrlTest class have created one test case with multiple test data such that all the tests will be executed.
14. some test cases expected results are "site can't be reached" but selenium throws exception for the expected
results. For all those test case I have handled the exception and made test pass.
15. selenium throws different exception for different browsers. will update accordingly as of now handled chrome
exceptions.
TestNg.xml:
16. To execute the tests please use testngCHROME.xml.
Test Executions:
17. Have run tests on multiple browsers as of now chrome, firefox and opera
18. In executions folder use appropriate xml file to run the tests.
19. if any chrome driver version exception occur please update the chrome the browser with the latest version 
and run again.