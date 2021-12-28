Feature: API Automation Task for Interview

Scenario: I am able to hit get request successfully

	Given I hit get request
	Then I got response code as "200"
	
Scenario: I am able to hit post request successfully

	Given I hit post request to create a post
	Then I got response code as "201" 
	
Scenario: I hit post request with invalid body

	Given I hit post request with invalid body
	Then I got response code as "500" 