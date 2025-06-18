Feature: Free CRM 
#Scenario: Login test 
#
#	Given user is already on login page 
#	When title of login page is CRM 
#	Then user enters "user" and "pass" 
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
|user|password|	
	
