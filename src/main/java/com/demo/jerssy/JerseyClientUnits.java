package com.demo.jerssy;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class JerseyClientUnits {

	public static void main(String[] args) {

		try {
			Client client = Client.create();
			WebResource webResource = client
					.resource("http://localhost:8080/Shopping/rest/unitService/insert");
			String input = "{\"unitName\":\"VVVV\"}";

			ClientResponse response = webResource.type("application/json")
					.post(ClientResponse.class,input);

			if (response.getStatus() != 201) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ response.getStatus());
			}
			System.out.println("Output from Server .... \n");
			String output = response.getEntity(String.class);
			System.out.println(output);

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

}
/*
 * GET CHECK ========= http://localhost:8080/Shopping/rest/unitService/get
 * 
 * POST CHECK ========== WebResource webResource =
 * client.resource("http://localhost:8080/Shopping/rest/unitService/post");
 * String input = "{\"unitName\":\"GMS\"}";
 * 
 * Insert ====== WebResource webResource =
 * client.resource("http://localhost:8080/Shopping/rest/unitService/insert");
 * String input = "{\"unitName\":\"GMS\"}";
 * 
 * O/P --->
 * {"unitName":"GMS","createdBy":0,"modifiedBy":0,"statusMsg":"sucess","id":10}
 * 
 * 
 * Update ====== WebResource webResource =
 * client.resource("http://localhost:8080/Shopping/rest/unitService/update");
 * String input = "{\"unitName\":\"GMS\",\"id\":\"10\"}";
 * 
 * O/P --->
 * {"unitName":"GMS","createdBy":0,"modifiedBy":0,"statusMsg":"sucess","id":10}
 * 
 * GET LIST ======== WebResource webResource =
 * client.resource("http://localhost:8080/Shopping/rest/unitService/getAll");
 * //String input = "{\"unitName\":\"GMS\"}";
 * 
 * O/P --->
 * [{"unitName":"GMS","createdBy":0,"modifiedBy":0,"statusMsg":null,"id":10},
 * {"unitName":"KGS","createdBy":0,"modifiedBy":0,"statusMsg":null,"id":20},
 * {"unitName":"LTR","createdBy":0,"modifiedBy":0,"statusMsg":null,"id":21},
 * {"unitName":"10GMS","createdBy":0,"modifiedBy":0,"statusMsg":null,"id":22}]
 * 
 * SEARCH BY ID ============ WebResource webResource =
 * client.resource("http://localhost:8080/Shopping/rest/unitService/search");
 * String input = "{\"id\":\"10\"}";
 */
