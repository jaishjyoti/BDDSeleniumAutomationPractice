Feature: Web Automation Task for Interview
		Need to automate couple of scenarios mentioned in Codility assignment
  

Background: User should be able to launch application url
	Given I am on application home page
	When I select sign in link from top header
	And I login with valid credentials
	|harshitjain.qait@gmail.com|Qait@123|

  Scenario: I am able to successfully place an order of T-Shirt
	Then I navigated to My Account Page
	And I navigate to home page on selecting 'Home' from botton navigation menu
	And I select 'TSHIRTS' tab from top navigation bar
	And I hover on first TShirt appearing on search result
	And I select 'Add to Cart' button
	And I select 'Proceed to Checkout' button on popup
	And I select 'Proceed to Checkout' button on 'SHOPPING-CART SUMMARY' page
	And I select 'Proceed to Checkout' button on 'ADDRESSES' page keeping default selection
	And I agree to Terms of service checkbox 
	And I select 'Proceed to Checkout' button on 'SHIPPING' page keeping default selection
	And I select 'Pay by check' option on payment method page
	And I select 'I confirm my order' button on 'Check Payment' page
	Then The following alert message should be displayed
	"""
	Your order on My Store is complete.
	"""
	When I get the order details present on 'ORDER CONFIRMATION' page
	And I select 'Back to orders' on 'ORDER CONFIRMATION' page
	Then I navigate to Order History Page
	And I validate the latest order details
	
  Scenario: I am able to update personal information in My Account Page	
  	Then I navigated to My Account Page
  	When I select 'My Personal Information' button
  	And I update the first name in 'First Name' field
  	Then The following alert message should be displayed
	"""
	Your personal information has been successfully updated.
	"""
	Then The account name of the user contains the updated first name	 
  	
