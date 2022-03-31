package com.example.convertCurrency;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;


@RestController
public class ConvertCurrencyController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ConvertCurrencyService convertCurrencyService;

	
	@GetMapping(value = "/convert-currency-service/{countryCode}/{amount}/")
	//@Retry(name="convertCurrencyRetry", fallbackMethod = "convertCurrencyCircuitBreakerFallBack") 
	@CircuitBreaker(name="convertCurrencyCircuitBreaker", fallbackMethod = "convertCurrencyCircuitBreakerFallBack") 
	public CurrencyConversionBean convertCurrency(@PathVariable String countryCode, @PathVariable Double amount) {
		logger.info("Inside the convertCurrency method.");

		Double convertedAmount = 0.0;
		Double conversionFactor = 0.0;
		int port = 0;
		if (countryCode != null) {
			logger.info("Before call");
			/*
			 * Map<String, String> uriVariables = new HashMap<>();
			 * uriVariables.put("countryCode", countryCode); ResponseEntity<ExchangeValue>
			 * responseEntity = new RestTemplate().getForEntity(
			 * "http://localhost:8000/manageCurrencyCoversionEntity/{countryCode}",
			 * ExchangeValue.class, uriVariables); ExchangeValue exchangeValue =
			 * responseEntity.getBody();
			 */
			
			
			/* String a = null; a.toString(); */
			 
			ExchangeValue exchangeValue = convertCurrencyService.getConversionFactorAmtOfACountry(countryCode);
			
			logger.info("{}", exchangeValue);
			conversionFactor = exchangeValue.getConversionFactor();
			port = exchangeValue.getPort();
			convertedAmount = amount * (conversionFactor);
			logger.info("After call");

		}
		
		return new CurrencyConversionBean(countryCode, "INR",conversionFactor , amount, convertedAmount, port);
	}


	public CurrencyConversionBean convertCurrencyCircuitBreakerFallBack(Exception exception) {
		System.out.println("Inside the fallback method");
		logger.info("Inside the fallback method");

		return new CurrencyConversionBean("", "INR",0.0 , 0.0, 0.0, 0);
	}
	
	
}
