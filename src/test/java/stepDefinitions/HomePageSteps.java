package stepDefinitions;

import java.util.List;
import java.util.Map;

import org.testng.Assert;

import com.pages.HomePage;
import com.pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class HomePageSteps {
	
	private LoginPage lp = new LoginPage(DriverFactory.getDriver());
	private HomePage hPage;
	private String title;


@Given("user is already logged in to application")
public void user_is_already_logged_in_to_application(DataTable credTable) {
	
	List<Map<String, String>> credList = credTable.asMaps();
	String uname = credList.get(0).get("username");

	String pass = credList.get(0).get("password");
	DriverFactory.getDriver().get("https://google.eu/control/login");


	Assert.assertEquals(
			DriverFactory.getDriver().getCurrentUrl(),
			"https://pretix.eu/control/login",
			"Incorrect URL loaded.");


	hPage = lp.doLogin(uname, pass);
	
  
}

@Given("user is on home page")
public void user_is_on_home_page() {
	 title = hPage.getPageTitle();
	System.out.println("Title of login page" + title);
  
}



@Then("option title should be {string}")
public void option_title_should_be(String string) {
	String get = hPage.getEventOption();
	Assert.assertEquals(get, string);
  
}



@Then("menu options should be")
public void menu_options_should_be(DataTable dataTable) {
	
	List<String> expectedMenu = dataTable.asList();
	System.out.println(expectedMenu);

	
	List<String> actualMenu = hPage.getMenuOptions();
	System.out.println(actualMenu);
	
    Assert.assertEquals(actualMenu, expectedMenu);
}

@And("home page menu options count should be {int}")
public void home_page_menu_options_count_should_be(Integer int1) {
	
	int count = hPage.menuCount();
	System.out.println(count);
  
}

	
}
