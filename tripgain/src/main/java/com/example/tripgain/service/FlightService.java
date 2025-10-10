package com.example.tripgain.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.tripgain.exception.ResourceNotFoundException;
import com.example.tripgain.model.FlightInfo;
import com.example.tripgain.repository.FlightInfoRepository;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.data.domain.Sort;

import java.util.Optional;

@Service
public class FlightService {
	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private FlightInfoRepository flightInfoRepository;

	public void fetchAndStoreFlights() {
		String url = "https://flightapigateway.iweensoft.com/api/flights/fake-search";

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("gw-flightapi-key", "JAVA-ASSIGMENT20250524");

		Map<String, Object> requestBody = new HashMap<>();

		requestBody.put("numAdults", 1);
		requestBody.put("numChildren", 0);
		requestBody.put("numInfants", 0);
		requestBody.put("journeyType", "OneWay");
		List<Map<String, String>> odPairs = new ArrayList<>();
		Map<String, String> odPair = new HashMap<>();
		odPair.put("origin", "BOM");
		odPair.put("destination", "DEL");
		odPair.put("jDate", "2025-05-28");
		odPair.put("cabinClass", "E");
		odPairs.add(odPair);
		requestBody.put("odPairs", odPairs);

		HttpEntity<Map<String, Object>> request = new HttpEntity<>(requestBody, headers);

		ResponseEntity<JsonNode> response = restTemplate.postForEntity(url, request, JsonNode.class);

		if (response.getStatusCode() == HttpStatus.OK) {
			JsonNode flights = response.getBody().path("flights");
			for (JsonNode flightNode : flights) {
				FlightInfo flight = mapJsonToFlightInfo(flightNode);
				flightInfoRepository.save(flight);
			}
		}
	}

	public List<FlightInfo> getAllFlights() {
		return flightInfoRepository.findAll(Sort.by(Sort.Direction.ASC, "totalAmount"));
	}
	
	
	

	private FlightInfo mapJsonToFlightInfo(JsonNode json) {
		FlightInfo flightInfo = new FlightInfo();

		if (json.has("gwFlightKey")) {
			flightInfo.setGwFlightKey(json.get("gwFlightKey").asText());
		}
		if (json.has("carrier")) {
			flightInfo.setCarrier(json.get("carrier").asText());
		}
		if (json.has("flightNumber")) {
			flightInfo.setFlightNumber(json.get("flightNumber").asText());
		}
		if (json.has("fareType")) {
			flightInfo.setFareType(json.get("fareType").asText());
		}
		if (json.has("totalAmount")) {
			flightInfo.setTotalAmount(json.get("totalAmount").asDouble());
		}

		return flightInfo;
	}
	
	
	

	public Optional<FlightInfo> getFlightByNumber(String flightNumber) {
	    return flightInfoRepository.findByFlightNumber(flightNumber);
	}



	

	public Optional<FlightInfo> getFlightWithMaxPrice() {
		return flightInfoRepository.findTopByOrderByTotalAmountDesc();
	}

	
	
	
	public Optional<FlightInfo> getFlightWithMinPrice() {
		return flightInfoRepository.findTopByOrderByTotalAmountAsc();
	}
}
