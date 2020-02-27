package com.brownfield.pss.fares.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brownfield.pss.fares.entity.Fare;

@Service 
public class FaresComponent {
	private static final Logger logger = LoggerFactory.getLogger(FaresComponent.class);

	
	public FaresComponent(){
		
	}
	

	public Fare getFare(String flightNumber, String flightDate){ 
		logger.info("inside FaresComponent Looking for fares flightNumber "+ flightNumber + " flightDate "+ flightDate);
		
		System.out.println(" inside FaresComponent Looking for fares flightNumber "+ flightNumber + " flightDate "+ flightDate);
		return new Fare(12345,"BF100FARE","22-JAN-16", "100");	//faresRepository.getFareByFlightNumberAndFlightDate(flightNumber, flightDate);
	}
}
/*
Fare[] fares = {
		new Fare("BF100","22-JAN-16", "100"),
		new Fare("BF101","22-JAN-16", "101"),
		new Fare("BF102","22-JAN-16", "102"),
		new Fare("BF103","22-JAN-16", "103"),
		new Fare("BF104","22-JAN-16", "104"),
		new Fare("BF105","22-JAN-16", "105"),
		new Fare("BF106","22-JAN-16", "106")};
		List<Fare> list = Arrays.stream(fares).collect(Collectors.toList());*/



