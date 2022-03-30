package com.example.manageCurrencyConversion;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Currency_Conversion_Table")
public class ManageCurrencyConversionEntity {
	@Id
	@Column(name = "Country_Code")
	private String countryCode;
	@Column(name = "Conversion_Factor")
	private Double conversionFactor;

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public Double getConversionFactor() {
		return conversionFactor;
	}

	public void setConversionFactor(Double conversionFactor) {
		this.conversionFactor = conversionFactor;
	}
}
