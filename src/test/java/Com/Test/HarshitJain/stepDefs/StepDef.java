package Com.Test.HarshitJain.stepDefs;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;		
import io.cucumber.java.en.Then;		
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import org.testng.Assert;

import Com.Test.HarshitJain.pageObjects.TestSessionInitiator;
import Com.Test.HarshitJain.utilities.PropFileHandler;		

public class StepDef {
	//String storeFirstItemText;
	//String getText;
	//String firstItemText;
	String message;
	String text;
	String detail;
	String orderDetails;
	String baseApiURL = PropFileHandler.readProperty("apiURL");
	int statusCode=0;
	Response response;

	@Given("^I am on application home page$")
	public void i_am_on_application_home_page() {
		TestSessionInitiator.homePage.launchURL();
	}

	@When("^I select sign in link from top header$")				
	public void i_select_sign_in_link() {		
		TestSessionInitiator.homePage.selectSignIn();		
	}	

	@When("^I login with valid credentials$")				
	public void login_with_valid_credentials(DataTable usercredentials) throws Throwable{		
		TestSessionInitiator.authenticationPage.submitCredentials(usercredentials);	
	}

	@Then("^I navigated to My Account Page$")				
	public void navigated_to_my_account_page(){		
		TestSessionInitiator.myAccountPage.userIsOnMyAccountPage();
	}

	@When("^I navigate to home page on selecting 'Home' from botton navigation menu$")				
	public void select_home(){		
		TestSessionInitiator.myAccountPage.userIsOnMyAccountPage();
	}

	@When("^I select 'TSHIRTS' tab from top navigation bar$")				
	public void select_tshirts_tab(){		
		TestSessionInitiator.homePage.selectTshirtsTab();
	}

	@When("^I hover on first TShirt appearing on search result$")				
	public void hover_on_TShirt(){
		TestSessionInitiator.searchProductPage.hoverOnTshirts();
	}

	@When("^I select 'Add to Cart' button$")				
	public void select_add_to_cart(){
		TestSessionInitiator.searchProductPage.selectAddToCart();
	}

	@When("^I select 'Proceed to Checkout' button on popup$")				
	public void proceed_to_checkout(){		
		TestSessionInitiator.searchProductPage.selectAddToCart();
	}

	@When("^I select 'Proceed to Checkout' button on 'SHOPPING-CART SUMMARY' page$")				
	public void proceed_to_checkout_shopping_cart(){
		TestSessionInitiator.checkoutPage.selectProceedToCheckout();
	}

	@When("^I select 'Proceed to Checkout' button on 'ADDRESSES' page keeping default selection$")				
	public void proceed_to_checkout_addresses(){		
		TestSessionInitiator.checkoutPage.selectProceedToCheckout();
		TestSessionInitiator.checkoutPage.selectProceedToCheckout();

	}

	@When("^I agree to Terms of service checkbox$")				
	public void check_terms_of_service(){		
		TestSessionInitiator.checkoutPage.selectTermsOfServiceCheckbox();
	}

	@When("^I select 'Proceed to Checkout' button on 'SHIPPING' page keeping default selection$")				
	public void proceed_to_checkout_shipping(){		
		TestSessionInitiator.checkoutPage.selectProceedToCheckout();
	}

	@When("^I select 'Pay by check' option on payment method page$")				
	public void select_pay_by_check(){		
		TestSessionInitiator.checkoutPage.selectPayByCheck();
	}

	@When("^I select 'I confirm my order' button on 'Check Payment' page$")				
	public void select_i_confirm_my_order(){		
		TestSessionInitiator.checkoutPage.selectIConfirmMyOrderButton();
	}

	@Then("^The following alert message should be displayed$")					
	public void verifyAlertMsg(String successMsg) throws Throwable 							
	{    		
		TestSessionInitiator.checkoutPage.successMsgIsDisplayed(successMsg);				
	}

	@When("^I get the order details present on 'ORDER CONFIRMATION' page$")				
	public void get_order_details(){		
		orderDetails = TestSessionInitiator.checkoutPage.getOrderDetails(); 
	}

	@When("^I select 'Back to orders' on 'ORDER CONFIRMATION' page$")				
	public void select_back_to_orders(){		
		TestSessionInitiator.checkoutPage.selectBackToOrders();
	}

	@Then("^I navigate to Order History Page$")					
	public void i_navigate_to_order_history_page(){    		
		TestSessionInitiator.orderHistory.userIsOnOrderHistoryPage();				
	}

	@Then("^I validate the latest order details$")					
	public void i_verify_the_latest_order_details(){    		
		TestSessionInitiator.orderHistory.verifyOrderDetails(orderDetails);				
	}

	@When("^I hit get request$")			
	public void send_get_request(){	
		statusCode = TestSessionInitiator.homePage.getStatusCode(baseApiURL+"posts/1");
		System.out.println("Status code is  >>  " + response.getStatusCode());
	}

	@Then("^I get response code as \"(.*)\"$")					
	public void verify_get_request(String code){
		Assert.assertEquals(statusCode, Integer.parseInt(code));
	}

	@When("^I hit post request to create a post$")			
	public void send_post_request(){	
		response = TestSessionInitiator.homePage.postRequest(baseApiURL+"posts",TestSessionInitiator.homePage.createBody("harshit","This is sample post request",2));
		statusCode = response.getStatusCode();
		System.out.println("Post status code is  >>  " + response.getStatusCode());
	}

	@When("^I hit post request with invalid body$")
	public void send_invalid_post_request(){	
		response = TestSessionInitiator.homePage.postRequest(baseApiURL+"posts","invalid body");
		statusCode = response.getStatusCode();
		System.out.println("Post status code is  >>  " + response.getStatusCode());
	}
	@When("I select to 'Contact us' button")
	public void contactUs() {
		TestSessionInitiator.contactUsPage.contactButton();
	}
	@Then("I navigated to my contact page")
	public void i_navigated_to_my_contact_page() {
		System.out.println("On contact page");
	}
	@When("I select 'Subject Heading' box")
	public void selectSubjectBox() {
		TestSessionInitiator.contactUsPage.subjectHeading();
	} 
	@When("I select 'Order reference' box")
	public void selectOrderReferenceBox() {
		TestSessionInitiator.contactUsPage.orderReference();
	}
	@And("I add file in 'Attach File' box")
	public void selectAttachFile() {
		TestSessionInitiator.contactUsPage.attachFile();
	}
	@When("I write message in 'Message' box")
	public void selectMessageBox() {
		TestSessionInitiator.contactUsPage.messageBox();
	}
	@When("I click on 'Send' button")
	public void selectSendBox() {
		TestSessionInitiator.contactUsPage.sendButton();
	}
	@Then("I verify message after success 'Contact us details'")
	public void verifyContactUsDetail() {
		TestSessionInitiator.contactUsPage.verifyContactUsDetails(detail);		
	}
	@When ("I search a  product")
	public void iSearchProduct() {
		TestSessionInitiator.searchProduct.textToBeSearched();
	}
	@Then("I verify searched product")
	public void verifySearchedText() {

		TestSessionInitiator.searchProduct.verifySearchText(text);
	}
	@When("I get first product name")
	public void getFistProductName()
	{
		TestSessionInitiator.searchProduct.getFirstProductName();
	}
	@When("I select first product")
	public void selectFirstProduct() {
		TestSessionInitiator.searchProduct. selectFirstProduct(); 
	}
	@Then("I get product name after select first product")
	public  void iGetProductNameAfteClick() {
		TestSessionInitiator.searchProduct.getProductNameAfterClick();
	}
	@When("I verify product name")
	public void iVerifyProductName() {
		TestSessionInitiator.searchProduct.verifyProductName();
	}
	@When("I verify page title")
	public void iVerifyPageTitle()
	{
		TestSessionInitiator.searchProduct.verifyTitle();

	}@When("I check follow us text present in global footer or not")

	public void textIsPresentOrNot() {
		TestSessionInitiator.presentOrNot.checkTextPresentInGlobalFooter();
	}
	@When("I click fb link from global footer")
	public void clickOnfblogo() {
		TestSessionInitiator.presentOrNot.clickOnFb();
		
	}@When("I click  twitter link from global footer")
	public void clickOnTwitterLogo() {
		TestSessionInitiator.presentOrNot.clickOnTwitter();
		
	}@When("I click prestashop link from global footer")
	public void clickOnPrestashop() {
		TestSessionInitiator.presentOrNot.clickOnPrestaShop();
	}
	@When("I click google link from global footer")
	public void clickOnGoogle() {
		TestSessionInitiator.presentOrNot.clickOnGoogle();
		
	}@And("I Check  Enter your e-mail placeholder is present or not")
	public void checkNewLetterTextplaceholder() {
		TestSessionInitiator.presentOrNot.checkTextNewsletterPresentInGlobalFooter();
	}
	 @And("I Check Newsletter text is present in Global footer or not")
	public void  iCheckletterTextPresentOrNot (){
		TestSessionInitiator.presentOrNot.checkEnterYourEmailText();
	}@Then("I verify subscribe message")
	public void verifySubcribeMsg() {
		TestSessionInitiator.presentOrNot.verifyNewsletterPlaceholder(message);
		
	}
	 
}