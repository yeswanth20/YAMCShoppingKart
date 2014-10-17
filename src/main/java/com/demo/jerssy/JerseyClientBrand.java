package com.demo.jerssy;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class JerseyClientBrand {

	public static void main(String[] args) {

		try {
			Client client = Client.create();
			WebResource webResource = client
					.resource("http://localhost:8080/Shopping/rest/brandService/insert");
			String input = "{\"brandNameEng\":\"Brand\"}";
			
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
	
	Insert
	======
	WebResource webResource = client.resource("http://localhost:8080/Shopping/rest/brandService/insert");
	String input = "{"brandNameEng":"brandNameEng","brandNameTel":"brandNameTel","brandNameHindi":"brandNameHindi","brandNameTamil":"brandNameTamil"}";
	
	O/P --->
	{"id":80,"brandNameEng":"brandNameEng","brandNameTel":"brandNameTel","brandNameHindi":"brandNameHindi","brandNameTamil":"brandNameTamil","createdBy":0,"modifiedBy":0}


	
	Update
	======
	WebResource webResource = client.resource("http://localhost:8080/Shopping/rest/brandService/update");
	String input = "{"brandNameEng":"brandNameEng","brandNameTel":"brandNameTel"}";
	
	O/P ---> 
	{"id":80,"brandNameEng":"brandNameEng","brandNameTel":"brandNameTel","brandNameHindi":"brandNameHindi","brandNameTamil":"brandNameTamil","createdBy":0,"modifiedBy":0}

	{"id":70,"brandNameEng":"brandNameEng1","brandNameHindi":"brandNameHindi1","createdBy":0,"modifiedBy":0}

	GET LIST
	========
	WebResource webResource = client.resource("http://localhost:8080/Shopping/rest/brandService/getAll");
	
	O/P --->
	[
	{"id":60,"brandNameEng":"brandNameEng","createdBy":0,"modifiedBy":0},
	{"id":80,"brandNameEng":"brandNameEng","brandNameTel":"brandNameTel","brandNameHindi":"brandNameHindi","brandNameTamil":"brandNameTamil","createdBy":0,"modifiedBy":0},
	{"id":70,"brandNameEng":"brandNameEng1","brandNameHindi":"brandNameHindi1","createdBy":0,"modifiedBy":0}
	]


	
	SEARCH BY ID
	============
	WebResource webResource = client.resource("http://localhost:8080/Shopping/rest/brandService/search");
    
    OUTPUT--->
    {"id":60,"brandNameEng":"brandNameEng","createdBy":0,"modifiedBy":0}
	{"id":80,"brandNameEng":"brandNameEng","brandNameTel":"brandNameTel","brandNameHindi":"brandNameHindi","brandNameTamil":"brandNameTamil","createdBy":0,"modifiedBy":0}

*/
