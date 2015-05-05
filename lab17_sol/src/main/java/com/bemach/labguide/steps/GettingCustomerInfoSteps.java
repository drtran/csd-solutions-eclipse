package com.bemach.labguide.steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


public class GettingCustomerInfoSteps {
    private Customer customer;
	private String url;
	private String restURL;

	@Before
	public void setUp() {
        this.url = "http://localhost:18080/northwind-web";
        this.restURL = "http://localhost:18080/MongoRS/services/customers";
	}

	@After
	public void tearDown() {

	}


	@Given("^that a customer exists with \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", and \"([^\"]*)\"$")
	public void that_a_customer_exists_with_and(String customerId, String companyName,
												String contactName, String contactTitle, String phone) throws Throwable {
		RSClient rsClient = new RSClient();
		rsClient.setUrl(restURL);
		Customer customer = rsClient.getCustomerById(customerId);
		assertNotNull(customer);
	}

	@When("^I call MongoRS service with a given \"([^\"]*)\"$")
	public void I_call_MongoRS_service_with_a_given(String customerId) throws Throwable {
        RSClient rsClient = new RSClient();
        rsClient.setUrl("http://localhost:18080/MongoRS/services/customers");
        customer = rsClient.getCustomerById(customerId);
	}

	@Then("^I should receive a customer record with \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", and \"([^\"]*)\"$")
	public void I_should_receive_a_customer_record_with_and(String customerId, String companyName,
                                                            String contactName, String contactTitle, String phone) throws Throwable {
        assertEquals(customerId, customer.getCustomerId());
        assertEquals(companyName, customer.getCompanyName());
        assertEquals(contactName, customer.getContactName());
        assertEquals(contactTitle, customer.getContactTitle());
        assertEquals(phone, customer.getPhone());
	}


}
