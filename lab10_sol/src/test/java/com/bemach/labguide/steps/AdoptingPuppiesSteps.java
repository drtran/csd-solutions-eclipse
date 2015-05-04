package com.bemach.labguide.steps;

import com.bemach.labguide.common.Hook;
import com.bemach.labguide.common.PaymentInfo;
import com.bemach.labguide.pages.AdoptMePage;
import com.bemach.labguide.pages.OrderPage;
import com.bemach.labguide.pages.PuppiesMainPage;
import com.bemach.labguide.pages.ViewDetailsPage;
import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static junit.framework.Assert.assertTrue;

/**
 * Created by ktran on 4/26/2015.
 */
public class AdoptingPuppiesSteps {

    private WebDriver driver;
    private PuppiesMainPage main;
    private ViewDetailsPage viewDetails;
    private AdoptMePage adoptMe;
    private OrderPage order;

    @Before
    public void setUp() {
        driver = Hook.getWebDriver(ChromeDriver.class);
        main = PageFactory.initElements(driver, PuppiesMainPage.class);
    }

    @Given("^I am on the puppy adoption site \"([^\"]*)\"$")
    public void I_am_on_the_puppy_adoption_site(String url) throws Throwable {
        main.setPageUrl(url);
        assertTrue("Not at Puppy Adoption Home Page!", main.locationIsVerified());
    }

    @When("^I complete the adoption using this information \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
    public void I_complete_the_adoption_using_this_information_(String name, String address,
                                                                String email, String paymentType) throws Throwable {
        PaymentInfo paymentInfo = new PaymentInfo();
        paymentInfo.orderAddress = address;
        paymentInfo.orderEmail = email;
        paymentInfo.orderName = name;
        paymentInfo.orderPaymentType = paymentType;
        order.completeOrder(paymentInfo);
    }

    @When("^I click the View Details button for \"([^\"]*)\"$")
    public void I_click_the_View_Details_button_for(String petName) throws Throwable {
        viewDetails = main.getViewDetailsPage(petName);
        assertTrue("Not at View Details Page!", viewDetails.locationIsVerified());
    }

    @And("^I click the Adopt Me! button$")
    public void I_click_the_Adopt_Me_button() throws Throwable {
        adoptMe = viewDetails.adoptMe();
        assertTrue("Not at Adopt Me Page!", adoptMe.locationIsVerified());
    }

    @And("^I click the Complete the Adoption button$")
    public void I_click_the_Complete_the_Adoption_button() throws Throwable {
        order = adoptMe.completeTheAdoption();
        PaymentInfo paymentInfo = new PaymentInfo();

    }

    @When("^I click on Adopt Another Puppy$")
    public void I_click_on_Adopt_Another_Puppy() throws Throwable {
        order = adoptMe.adoptAnotherPuppy();
        PaymentInfo paymentInfo = new PaymentInfo();
    }

    @When("^I complete the adoption with:$")
    public void I_complete_the_adoption_with(List<PaymentInfo> paymentInfos) throws Throwable {
        order.completeOrder(paymentInfos.get(0));
    }

    @When("^I complete the adoption with \"([^\"]*)\":$")
    public void I_complete_the_adoption_with_(String paymentType, List<PaymentInfo> paymentInfos) throws Throwable {
        for (PaymentInfo paymentInfo : paymentInfos) {
            if (paymentType.equals(paymentInfo.orderPaymentType)) {
                order.completeOrder(paymentInfo);
            }
        }
    }

    @Then("^I should see \"([^\"]*)\"$")
    public void I_should_see(String expectedMessage) throws Throwable {
        Assert.assertTrue(expectedMessage, order.lastOrderWasSuccessful());
    }

    @When("^I complete adopting these puppies:$")
    public void I_complete_adopting_these_puppies(List<String> puppies) throws Throwable {
        adoptingSeveralPuppies(puppies);
    }

    private void adoptingSeveralPuppies(List<String> puppies) throws Throwable {
        for (int index = 1; index <= puppies.size(); index++) {
            I_click_the_View_Details_button_for(puppies.get(index-1));
            I_click_the_Adopt_Me_button();
            if (index < puppies.size()) {
                I_click_on_Adopt_Another_Puppy();
            } else {
                I_click_the_Complete_the_Adoption_button();
            }
        }
    }

    @When("^I click the Change your mind button and accept OK$")
    public void I_click_the_Change_your_mind_button_and_accept_OK() throws Throwable {
        main = adoptMe.changeYourMind();
    }

    @Then("^I should be back on the home page$")
    public void I_should_be_back_on_the_home_page() throws Throwable {
        assertTrue("Not at Puppy Adoption Home Page!", main.locationIsVerified());
    }

    @When("^I complete the adoption using no information$")
    public void I_complete_the_adoption_using_no_information() throws Throwable {
        PaymentInfo paymentInfo = new PaymentInfo();
        paymentInfo.orderAddress = "";
        paymentInfo.orderEmail = "";
        paymentInfo.orderName = "";
        paymentInfo.orderPaymentType = "";
        order.completeOrder(paymentInfo);
    }

    @Then("^I should see this error message \"([^\"]*)\"$")
    public void I_should_see_this_error_message(String errorMsg) throws Throwable {
        assertTrue("Unexpected error message!", order.verifyErrorMessage(errorMsg));
    }
}
