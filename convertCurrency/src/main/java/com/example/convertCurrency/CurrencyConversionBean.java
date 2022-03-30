package com.example.convertCurrency;

public class CurrencyConversionBean {
	private String fromCountryCode;
	private String toCountryCode;
	private Double conversionFactor;
	private Double multiple;
	private Double finalAmount;
	private int port;
	
	public String getFromCountryCode() {
		return fromCountryCode;
	}
	public void setFromCountryCode(String fromCountryCode) {
		this.fromCountryCode = fromCountryCode;
	}
	public String getToCountryCode() {
		return toCountryCode;
	}
	public void setToCountryCode(String toCountryCode) {
		this.toCountryCode = toCountryCode;
	}
	public Double getConversionFactor() {
		return conversionFactor;
	}
	public void setConversionFactor(Double conversionFactor) {
		this.conversionFactor = conversionFactor;
	}
	public Double getMultiple() {
		return multiple;
	}
	public void setMultiple(Double multiple) {
		this.multiple = multiple;
	}
	public Double getFinalAmount() {
		return finalAmount;
	}
	public void setFinalAmount(Double finalAmount) {
		this.finalAmount = finalAmount;
	}
	public int getPort() {
		return port;
	}
	public CurrencyConversionBean() {
		super();
	}
	public CurrencyConversionBean(String fromCountryCode, String toCountryCode, Double conversionFactor, Double multiple,
			Double finalAmount, int port) {
		super();
		this.fromCountryCode = fromCountryCode;
		this.toCountryCode = toCountryCode;
		this.conversionFactor = conversionFactor;
		this.multiple = multiple;
		this.finalAmount = finalAmount;
		this.port = port;
	}
	public void setPort(int port) {
		this.port = port;
	}
}
