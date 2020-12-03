
Feature: Sign in to the website
 
Scenario: succesfully login to the Home page
	When user bring up the login dialog
	And user enter a valid username 
	And user enter a valid password
	And user click signin
	Then user should be successfully logged into the site