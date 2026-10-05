package stepDefinitions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import com.pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;	
import io.cucumber.java.en.When;

public class LoginPageSteps{

    private static final Logger log =
            LoggerFactory.getLogger(LoginPageSteps.class);


    static String title;
	
	private LoginPage lPage = new LoginPage(DriverFactory.getDriver());
	
@Given("user is on login page")
public void user_is_on_login_page() {
    log.info("User is on login page");

    // Write code here that turns the phrase above into concrete actions
	
	DriverFactory.getDriver().get("https://pretix.eu/control/login");

	Assert.assertEquals(
			DriverFactory.getDriver().getCurrentUrl(),
			"https://pretix.eu/control/login",
			"Incorrect URL loaded.");


}

@When("user gets the title of the page")
public void user_gets_the_title_of_the_page() {
    // Write code here that turns the phrase above into concrete actions
	 title = lPage.getPageTitle();
	System.out.println("Title of login page" + title);
}

@Then("page title should be {string}")
public void page_title_should_be(String expectedTitle) {
    // Write code here that turns the phrase above into concrete actions
	Assert.assertEquals(title, expectedTitle);}


@Then("forgot your password link should be displayed")
public void forgot_your_password_link_should_be_displayed() {
    // Write code here that turns the phrase above into concrete actions
	Assert.assertTrue(lPage.isLostPassDisplayed());
	
}

@When("user enters username {string}")
public void user_enters_username(String username) {
    // Write code here that turns the phrase above into concrete actions
	lPage.enterEmail(username);
}

@When("user enters password {string}")
public void user_enters_password(String password) {
    // Write code here that turns the phrase above into concrete actions
	lPage.enterPass(password);
}

@When("user clicks on login button")
public void user_clicks_on_login_button() {
    // Write code here that turns the phrase above into concrete actions
	lPage.clickLogfin();
}



}