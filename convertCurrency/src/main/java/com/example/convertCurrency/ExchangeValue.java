package com.example.convertCurrency;

public class ExchangeValue {
	private String fromCountryCode;
	private Double conversionFactor;
	private int port;
	
	public ExchangeValue() {
		super();
	}
	public ExchangeValue(String fromCountryCode, Double conversionFactor, int port) {
		super();
		this.fromCountryCode = fromCountryCode;
		this.conversionFactor = conversionFactor;
		this.port = port;
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
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	
}
