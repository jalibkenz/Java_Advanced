package com.example.tripgain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "flightinfo")
public class FlightInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "gwflightkey", length = 255)
	private String gwFlightKey;

	@Column(name = "carrier", length = 10)
	private String carrier;

	@Column(name = "flightnumber", length = 10)
	private String flightNumber;

	@Column(name = "faretype", length = 100)
	private String fareType;

	@Column(name = "totalamount")
	private double totalAmount;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getGwFlightKey() {
		return gwFlightKey;
	}

	public void setGwFlightKey(String gwFlightKey) {
		this.gwFlightKey = gwFlightKey;
	}

	public String getCarrier() {
		return carrier;
	}

	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getFareType() {
		return fareType;
	}

	public void setFareType(String fareType) {
		this.fareType = fareType;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

}
