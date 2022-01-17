package it.tecnoinnovis.client;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import it.tecnoinnovis.entity.MoneyTransferResponse;

public class FabrickRestClient {

	private String endpoint;

	public FabrickRestClient(String endpoint) {
		super();
		this.endpoint = endpoint;
	}

	public Object execute(HttpMethod httpMethod, String jsonRequest) throws Exception{

		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.set("Auth-Schema", "S2S");
		headers.set("Api-Key", "FXOVVXXHVCPVPBZXIJOBGUGSKHDNFRRQJP");
		headers.set("X-Time-Zone", "Europe/Rome");

		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

		ResponseEntity<String> exchange = new ResponseEntity<String>(HttpStatus.OK);
		try {
			if (httpMethod == HttpMethod.GET) {
				exchange = restTemplate.exchange(endpoint, httpMethod, entity, String.class);
				if (exchange.getStatusCode() != HttpStatus.OK) {
					throw new Exception(exchange.getBody().toString());
				}
			}
			if (httpMethod == HttpMethod.POST) {
				HttpEntity<String> request = new HttpEntity<String>(jsonRequest.toString(), headers);
				exchange = restTemplate.postForEntity(endpoint, request, String.class);
			}
		} catch (RestClientResponseException e) {
			throw new Exception(e.getResponseBodyAsString());
		}
		return exchange.getBody();
	}

}
