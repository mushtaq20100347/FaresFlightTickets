package com.brownfield.pss.fares.controller;

//Define thread
public class RunnableFactorial implements Runnable{ //task
	@Override
	public void run(){
		try {
			//Thread.sleep(20*1000);
			//int factorial = fact1(1);
			 fact1();

			} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("done");
	}
	
	
	public void fact1() {
		  int i, j, fact=1;  
		  long number=1000000000;//It is the number to calculate factorial   
		  
		  
		  for(j=1;j<=1000000000;j++){  
			  
				  for(i=1;i<=number;i++){    
				      fact=fact*i;    
				  }    
		  }
		 // System.out.println("Factorial of "+number+" is: "+fact);    
		 }  
	
	
	static int fact(int n)
	   {
	       int output;
	    /*  if(n==1){
	         return 1;
	       }*/
	       //Recursion: Function calling itself!!
	       output = fact(n-1)* n;
	       return output;
	   }
}
