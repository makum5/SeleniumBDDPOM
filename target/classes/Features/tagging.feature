@FunctionalTest
Feature: CRM Application 

@SmokeTest @RegressionTest
Scenario: Login Test with correct credentials 
	Given This is a valid login test 

@RegressionTest
Scenario: Login Test with incorrect credentials 
	Given This is a invalid login test 	

@SmokeTest @RegressionTest
Scenario: create a contact test
	Given This is a create contact test 

@SmokeTest	
Scenario: create a deal test
	Given This is a create deal test

@RegressionTest @End2EndTest
Scenario: create a task test
	Given This is a create task test 	 	

@RegressionTest @End2EndTest
Scenario: search a task test
	Given This is a search task test 	