package com.example.manageCurrencyConversion;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ManageCurrencyConversionController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private Environment environment;

	@Autowired
	private ManageCurrencyConversionService manageCurrencyConversionService;

	@PostMapping(value = "/manage-currency-conversion")
	public ResponseEntity<String> addConversionFactor(
			@RequestBody ManageCurrencyConversionEntity currencyConversionEntity) {
		System.out.println("Inside ManageCurrencyConversionController - addConversionFactor - running at port:"
				+ Integer.parseInt(environment.getProperty("local.server.port")));

		ManageCurrencyConversionEntity savedEntity = manageCurrencyConversionService
				.saveCurrencyConversionData(currencyConversionEntity);
		if (savedEntity != null) {
			return ResponseEntity.status(HttpStatus.OK).body("The content is saved in the database.\n");
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body("The content is either not valid or not saved in the database.\n");

	}

	@GetMapping(value = "/manage-currency-conversion/{countryCode}")
	public ExchangeValue getConversionFactor(@PathVariable String countryCode) {
		System.out.println("Inside ManageCurrencyConversionController - getConversionFactor - running at port:"
				+ Integer.parseInt(environment.getProperty("local.server.port")));
		Double conversionFactor = manageCurrencyConversionService.getConversionFactorData(countryCode);

		ExchangeValue exchangeValue = new ExchangeValue(countryCode, conversionFactor,
				Integer.parseInt(environment.getProperty("local.server.port")));
		logger.info("{}", exchangeValue);
		return exchangeValue;
	}
	
	@PutMapping(value = "/manage-currency-conversion")
	public ResponseEntity<String> updateConversionFactor(
			@RequestBody ManageCurrencyConversionEntity newCurrencyConversionEntity) {
		System.out.println("Inside ManageCurrencyConversionController - updateConversionFactor - running at port:"
				+ Integer.parseInt(environment.getProperty("local.server.port")));

		if (manageCurrencyConversionService.updateCurrencyConversionData(newCurrencyConversionEntity)) {
			return ResponseEntity.status(HttpStatus.OK).body("The content is updated or saved in the database.\n");
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body("The content is either not valid or not updated in the database.\n");
	}


}
