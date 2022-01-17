package it.tecnoinnovis.restcontrollerTest;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import it.tecnoinnovis.client.FabrickRestClient;
import it.tecnoinnovis.entity.MoneyTransferRequest;
import it.tecnoinnovis.entity.MoneyTransferResponse;

@RestController
public class ControllerAppTest {
	
	@Value("${hostname}")
	private String hostname;
	
	@Value("${accountBalancePath}")
	private String accountBalancePath;
	
	@Value("${moneyTransferPath}")
	private String moneyTransferPath;
	
	@Value("${accountTransactionsPath}")
	private String accountTransactionsPath;
	
	@GetMapping(path="/getBalanceByAccountId/{accountId}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> getBalanceByAccountId(@PathVariable("accountId") Integer accountId) throws Exception {
				
		String accountBalancePathReplace = accountBalancePath.replace("{accountId}", String.valueOf(accountId));
		FabrickRestClient client = new FabrickRestClient(hostname + accountBalancePathReplace);
		
		Object execute;
		try {
			execute = client.execute(HttpMethod.GET, null);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		ObjectMapper mapper = new ObjectMapper();
		Map<String,Object> result = mapper.readValue((String)execute, HashMap.class);
		
		return new ResponseEntity<Object>(result.get("payload"), HttpStatus.OK);
	}
	
	
	@PostMapping(path="/moneyTransfer/{accountId}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> moneyTransfer(@PathVariable("accountId") Integer accountId , @Valid @RequestBody MoneyTransferRequest moneyTransferRequest) throws Exception {
		
		ObjectMapper mapper = new ObjectMapper();
		String jsonStr = mapper.writeValueAsString(moneyTransferRequest);
		
		String moneyTransferPathReplace = moneyTransferPath.replace("{accountId}", String.valueOf(accountId));
		FabrickRestClient client = new FabrickRestClient(hostname + moneyTransferPathReplace);
		Object execute;
		try {
			execute =  client.execute(HttpMethod.POST, jsonStr);
		} catch (Exception e) {
			Map<String, String> map = new HashMap<String, String>(); 
			map.put("code:", "API000");
			map.put("description:", "Errore tecnico La condizione BP049 non è prevista per il conto id " + accountId);
			return new ResponseEntity<Object>(map, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		Map<String,Object> result = mapper.readValue((String)execute, HashMap.class);
		MoneyTransferResponse moneyTransferResponse = mapper.readValue((String)result.get("payload"), MoneyTransferResponse.class);
		
		return new ResponseEntity<Object>(moneyTransferResponse, HttpStatus.OK);
	}
	
	@GetMapping(path="/accountTransactions/{accountId}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> accountTransactions(@PathVariable("accountId") Integer accountId , @RequestParam String fromDate, @RequestParam String toDate) throws Exception{
		
		String accountTransactionsPathReplace = accountTransactionsPath.replace("{accountId}", String.valueOf(accountId));
		
		StringBuilder accountTransactionsPathBuilder = new StringBuilder();
		accountTransactionsPathBuilder.append(accountTransactionsPathReplace);
		accountTransactionsPathBuilder.append("fromAccountingDate=");
		accountTransactionsPathBuilder.append(fromDate);
		accountTransactionsPathBuilder.append("&toAccountingDate=");
		accountTransactionsPathBuilder.append(toDate);
		
		FabrickRestClient client = new FabrickRestClient(hostname + accountTransactionsPathBuilder);
		
		Object execute;
		try {
			execute = client.execute(HttpMethod.GET, null);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		ObjectMapper mapper = new ObjectMapper();
		Map<String,Object> result = mapper.readValue((String)execute, HashMap.class);
		
		return new ResponseEntity<Object>(result.get("payload"), HttpStatus.OK);
	}

}
