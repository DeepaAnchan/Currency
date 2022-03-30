package com.example.convertCurrency;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;


@RestController
public class ConvertCurrencyController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ConvertCurrencyService convertCurrencyService;


	public CurrencyConversionBean convertCurrencyCircuitBreakerFallBack(String countryCode,Double amount) {
		System.out.println("Inside the fallback method");
		logger.info("Inside the fallback method");

		return new CurrencyConversionBean("", "INR",0.0 , 0.0, 0.0, 0);
	}
	
	@GetMapping(value = "/convertCurrency/{countryCode}/{amount}/")
	@HystrixCommand(fallbackMethod = "convertCurrencyCircuitBreakerFallBack") 
	public CurrencyConversionBean convertCurrency(@PathVariable String countryCode, @PathVariable Double amount) {
		System.out.println("Inside the convertCurrency method.");
		Double convertedAmount = 0.0;
		Double conversionFactor = 0.0;
		int port = 0;
		if (countryCode != null) {
			System.out.println("Before call");
			/*
			 * Map<String, String> uriVariables = new HashMap<>();
			 * uriVariables.put("countryCode", countryCode); ResponseEntity<ExchangeValue>
			 * responseEntity = new RestTemplate().getForEntity(
			 * "http://localhost:8000/manageCurrencyCoversionEntity/{countryCode}",
			 * ExchangeValue.class, uriVariables); ExchangeValue exchangeValue =
			 * responseEntity.getBody();
			 */
			ExchangeValue exchangeValue = convertCurrencyService.getConversionFactorAmtOfACountry(countryCode);
			
			logger.info("{}", exchangeValue);
			conversionFactor = exchangeValue.getConversionFactor();
			port = exchangeValue.getPort();
			convertedAmount = amount * (conversionFactor);
			System.out.println("After call");

		}
		
		return new CurrencyConversionBean(countryCode, "INR",conversionFactor , amount, convertedAmount, port);
	}
	
	
	
}
