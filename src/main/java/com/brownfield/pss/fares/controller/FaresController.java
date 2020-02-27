package com.brownfield.pss.fares.controller;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.brownfield.pss.fares.component.FaresComponent;
import com.brownfield.pss.fares.entity.Fare;
import java.util.concurrent.ExecutorService;

import java.util.concurrent.Executors;

@RestController
@CrossOrigin
@RequestMapping("/fares")
public class FaresController {
	FaresComponent faresComponent;
	private static final Logger logger = LoggerFactory.getLogger(FaresController.class);

	@Autowired
	FaresController(FaresComponent faresComponent){
	 this.faresComponent = faresComponent;
	}

	@RequestMapping("/get")
	Fare getFare(@RequestParam(value="flightNumber") String flightNumber, @RequestParam(value="flightDate") String flightDate){

			logger.info("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@    FaresController flightNumber== "+flightNumber);
			System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@    FaresController flightNumber=="+flightNumber);

		return faresComponent.getFare(flightNumber,flightDate);
	}
	
	@RequestMapping("/autoscale")
	String autoscale(){

			logger.info("@@@test@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@    FaresController autoscale== ");
				System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@    FaresController autoscale== ");
			RunnableFactorial r = new RunnableFactorial(); 
			
			ExecutorService threadPool = Executors.newFixedThreadPool(10); //put break point here
			
			threadPool.execute(r); //pool-1-thread-1
			threadPool.execute(r); //pool-1-thread-2
			threadPool.execute(r); //pool-1-thread-3
			threadPool.execute(r); //pool-1-thread-4
			threadPool.execute(r); //pool-1-thread-5

			threadPool.execute(r); //pool-1-thread-1
			threadPool.execute(r); //pool-1-thread-2
			threadPool.execute(r); //pool-1-thread-3
			threadPool.execute(r); //pool-1-thread-4
			threadPool.execute(r); //pool-1-thread-5

			threadPool.shutdown();

		


			return "COMPLETED";
	}

	
	
	@RequestMapping(value = "/exception")
	public String exception() {
		String response = "";
		try {
			logger.info("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@    FaresController exception() == ");
			
			throw new Exception("Exception has occured....");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.toString());

			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			String stackTrace = sw.toString();
			logger.error("Exception - " + stackTrace);
			response = stackTrace;
		}

		return response;
	}

}





