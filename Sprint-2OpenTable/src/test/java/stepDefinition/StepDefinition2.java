package stepDefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinition2 
{
	 	@When("^user bring up the login dialog$")
	    public void user_bring_up_the_login_dialog() throws Throwable 
	 	{
	        System.out.println("^user bring up the login dialog$");
	    }

	    @Then("^user should be successfully logged into the site$")
	    public void user_should_be_successfully_logged_into_the_site() throws Throwable 
	    {
	        System.out.println("^user should be successfully logged into the site$");
	    }

	    @And("^user enter a valid username $")
	    public void user_enter_a_valid_username() throws Throwable 
	    {
	        System.out.println("^user enter a valid username $");
	    }

	    @And("^user enter a valid password$")
	    public void user_enter_a_valid_password() throws Throwable 
	    {
	        System.out.println("^user enter a valid password$");
	    }

	    @And("^user click signin$")
	    public void user_click_signin() throws Throwable 
	    {
	        System.out.println("^user click signin$");
	    }

}
