package com.demo.jerssy;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class JerseyClientCategories {


	public static void main(String[] args) {

		try {
			Client client = Client.create();
			WebResource webResource = client
					.resource("http://localhost:8080/Shopping/rest/categoryService/insert");
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
	WebResource webResource = client.resource("http://localhost:8080/Shopping/rest/categoryService/insert");
	
	O/P --->
	{"id":9,"categoryNameEng":"categoryNameEng","categoryNameTel":"categoryNameTel","categoryNameHindi":"categoryNameHindi","categoryNameTamil":"categoryNameTamil","parentCategory":0,"rootCategory":0,"createdBy":0,"modifiedBy":0}


	
	Update
	======
	WebResource webResource = client.resource("http://localhost:8080/Shopping/rest/categoryService/update");
	
	O/P ---> 
	{"id":9,"categoryNameEng":"categoryNameEng second","categoryNameTel":"categoryNameTel second","categoryNameHindi":"categoryNameHindi second","categoryNameTamil":"categoryNameTamil second","parentCategory":0,"rootCategory":0,"createdBy":0,"modifiedBy":0}



	GET LIST
	========
	WebResource webResource = client.resource("http://localhost:8080/Shopping/rest/categoryService/getAll");
	
	O/P --->



	
	SEARCH BY ID
	============
	WebResource webResource = client.resource("http://localhost:8080/Shopping/rest/categoryService/search");
    
    OUTPUT--->
	{"id":9,"categoryNameEng":"categoryNameEng second","categoryNameTel":"categoryNameTel second","categoryNameHindi":"categoryNameHindi second","categoryNameTamil":"categoryNameTamil second","parentCategory":0,"rootCategory":0,"createdBy":0,"modifiedBy":0}
*/
