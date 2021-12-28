Feature: Web Automation Task for Interview
		Need to automate scenarios mentioned in coding assignment
  

Background: I should be able to launch application url
	Given I am on application home page
	When I select sign in link from top header
	And I login with valid credentials
	|harshitjain.qait@gmail.com|Qait@123|
	Scenario: I am able to check global header and global footer
	  When I check follow us text present in global footer or not
	  When I click fb link from global footer
	  When I click  twitter link from global footer
	  When I click prestashop link from global footer
	  When I click google link from global footer
	  And I Check  Enter your e-mail placeholder is present or not 
	  And I Check Newsletter text is present in Global footer or not 
	  Then I verify subscribe message 