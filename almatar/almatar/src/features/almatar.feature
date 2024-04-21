@designer-navven-Kumar
@author-shridhara
@almatar
Feature: Amazon sceanrios 
  
Scenario: verifying the user able to book hotel 
	Given user login to "amazon" web admin portal 
	And user enter the "Monitor" to "Search" field 
	And user click on "Search" button on home page 
	Then user select '1' item in the result list 
	And user click on "add curt item" button on home page 
	And user switch to add cart window 
	And user fetch the product price into "price" varibale 
	And user verify the price is identical to the product page price "price"
	And user verify sub total price is identical to the product page "price"
	
Scenario: verifying the user able to book hotel 
	Given user login to "amazon" web admin portal 
	And user enter the "Monitor" to "Search" field 
	And user click on "Search" button on home page 
	Then user select '' item in the result list 
	And user click on "add curt item" button on home page 
	And user switch to add cart window 
	And user fetch the product price into "price" varibale 
	And user verify the price is identical to the product page price "price"
	And user verify sub total price is identical to the product page "price"
	
	
Scenario: verifying the user able to book hotel 
	Given user login to "amazon" web admin portal 
	And user enter the "Monitor" to "Search" field 
	And user click on "Search" button on home page 
	Then user select '' item in the result list 
	And user click on "add curt item" button on home page 
	And user switch to add cart window 
	And user fetch the product price into "price" varibale 
	And user verify the price is identical to the product page price "price"
	And user verify sub total price is identical to the product page "price"
	
    
