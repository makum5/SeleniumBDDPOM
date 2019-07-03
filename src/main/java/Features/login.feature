Feature: Free CRM 
#Scenario: Login test 
#
#	Given user is already on login page 
#	When title of login page is CRM 
#	Then user enters "manish.singh322906@gmail.com" and "Tondak%#@12345" 
#	Then user clicks on login button 
#	And  user redirected to home page
	
	
Scenario Outline: Login test 

	Given user is already on login page 
	When title of login page is CRM 
	Then user enters "<username>" and "<password>" 
	Then user clicks on login button 
	And  user redirected to home page
	
Examples:
|        username            |password|
|manish.singh322906@gmail.com|Tondak%#@12345|	
	