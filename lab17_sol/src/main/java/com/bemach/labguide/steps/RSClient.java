package com.bemach.labguide.steps;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

public class RSClient {

	private String targetUrl;

	public void setUrl(String targetUrl) {
		this.targetUrl = targetUrl;
	}

	public Customer getCustomerById(String customerId) {
		Client client = ClientBuilder.newClient();
		Customer customer = client.target(targetUrl)
											  .path(customerId)
											  .request(MediaType.APPLICATION_JSON)
											  .get(new GenericType<Customer>(){});
		return customer;
	}

}
