package com.example.convertCurrency;

public class ExchangeValue {
	private String fromCountryCode;
	private Double conversionFactor;
	private String environment;
	
	public ExchangeValue(String fromCountryCode, Double conversionFactor, String environment) {
		super();
		this.fromCountryCode = fromCountryCode;
		this.conversionFactor = conversionFactor;
		this.setEnvironment(environment);
	}
	
	public ExchangeValue() {
		super();
	}
	public String getFromCountryCode() {
		return fromCountryCode;
	}
	public void setFromCountryCode(String fromCountryCode) {
		this.fromCountryCode = fromCountryCode;
	}
	public Double getConversionFactor() {
		return conversionFactor;
	}
	public void setConversionFactor(Double conversionFactor) {
		this.conversionFactor = conversionFactor;
	}

	public String getEnvironment() {
		return environment;
	}

	public void setEnvironment(String environment) {
		this.environment = environment;
	}
	
}
