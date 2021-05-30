package Com.Test.HarshitJain.stepDefs;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;		
import io.cucumber.java.en.Then;		
import io.cucumber.java.en.When;
import Com.Test.HarshitJain.pageObjects.TestSessionInitiator;		

public class StepDef {	
	String orderDetails;

	@Given("I am on application home page")
	public void i_am_on_application_home_page() {
		TestSessionInitiator.homePage.launchURL();
	}
	
	@When("I select sign in link from top header")				
    public void i_select_sign_in_link() {		
    	TestSessionInitiator.homePage.selectSignIn();		
    }	
	
	@When("I login with valid credentials")				
    public void login_with_valid_credentials(DataTable usercredentials) throws Throwable{		
    	TestSessionInitiator.authenticationPage.submitCredentials(usercredentials);	
    }
	
	@Then("I navigated to My Account Page")				
    public void navigated_to_my_account_page(){		
    	TestSessionInitiator.myAccountPage.userIsOnMyAccountPage();
    }
	
	@When("I navigate to home page on selecting 'Home' from botton navigation menu")				
    public void select_home(){		
    	TestSessionInitiator.myAccountPage.userIsOnMyAccountPage();
    }
	
	@When("I select 'TSHIRTS' tab from top navigation bar")				
    public void select_tshirts_tab(){		
    	TestSessionInitiator.homePage.selectTshirtsTab();
    }
	
	@When("I hover on first TShirt appearing on search result")				
    public void hover_on_TShirt(){		
    	TestSessionInitiator.searchProductPage.hoverOnTshirts();
    }
	
	@When("I select 'Add to Cart' button")				
    public void select_add_to_cart(){		
    	TestSessionInitiator.searchProductPage.selectAddToCart();
    }
	
	@When("I select 'Proceed to Checkout' button on popup")				
    public void proceed_to_checkout(){		
    	TestSessionInitiator.searchProductPage.selectAddToCart();
    }
	
	@When("I select 'Proceed to Checkout' button on 'SHOPPING-CART SUMMARY' page")				
    public void proceed_to_checkout_shopping_cart(){
    	TestSessionInitiator.checkoutPage.selectProceedToCheckout();
    }
	
	@When("I select 'Proceed to Checkout' button on 'ADDRESSES' page keeping default selection")				
    public void proceed_to_checkout_addresses(){		
    	TestSessionInitiator.checkoutPage.selectProceedToCheckout();
    	TestSessionInitiator.checkoutPage.selectProceedToCheckout();
    }
	
	@When("I agree to Terms of service checkbox")				
    public void check_terms_of_service(){		
    	TestSessionInitiator.checkoutPage.selectTermsOfServiceCheckbox();
    }
	
	@When("I select 'Proceed to Checkout' button on 'SHIPPING' page keeping default selection")				
    public void proceed_to_checkout_shipping(){		
    	TestSessionInitiator.checkoutPage.selectProceedToCheckout();
    }
	
	@When("I select 'Pay by check' option on payment method page")				
    public void select_pay_by_check(){		
    	TestSessionInitiator.checkoutPage.selectPayByCheck();
    }
	
	@When("I select 'I confirm my order' button on 'Check Payment' page")				
    public void select_i_confirm_my_order(){		
    	TestSessionInitiator.checkoutPage.selectIConfirmMyOrderButton();
    }
	
	@Then("The following alert message should be displayed")					
    public void verifyAlertMsg(String successMsg) throws Throwable 							
    {    		
		TestSessionInitiator.checkoutPage.successMsgIsDisplayed(successMsg);				
    }
	
	@When("I get the order details present on 'ORDER CONFIRMATION' page")				
    public void get_order_details(){		
		orderDetails = TestSessionInitiator.checkoutPage.getOrderDetails();
    }
	
	@When("I select 'Back to orders' on 'ORDER CONFIRMATION' page")				
    public void select_back_to_orders(){		
    	TestSessionInitiator.checkoutPage.selectBackToOrders();
    }
	
	@Then("I navigate to Order History Page")					
    public void i_navigate_to_order_history_page(){    		
		TestSessionInitiator.orderHistory.userIsOnOrderHistoryPage();				
    }
	
	@Then("I validate the latest order details")					
    public void i_verify_the_latest_order_details(){    		
		TestSessionInitiator.orderHistory.verifyOrderDetails(orderDetails);				
    }
	
	@When("I select 'My Personal Information' button")				
    public void select_my_personal_info_button(){		
    	TestSessionInitiator.myAccountPage.selectMyPersonalInformation();
    }
	
	@When("I update the first name in 'First Name' field")				
    public void update_first_name(){		
    	TestSessionInitiator.myAccountPage.updateFirstName();
    }
	
	@Then("The account name of the user contains the updated first name")					
    public void verify_first_name_updated_successfully(){    		
		TestSessionInitiator.myAccountPage.verifyFirstNameIsUpdated();				
    }	

}