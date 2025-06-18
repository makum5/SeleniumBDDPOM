Feature: Free CRM with Map data 
Scenario: Login test 

	Given user is already on login page 
	When title of login page is CRM 
	Then user enters username and password 
		|username|password|
		|user|pass| 
	Then user clicks on login button 
	And  user redirected to home page 
	Then close the browser
