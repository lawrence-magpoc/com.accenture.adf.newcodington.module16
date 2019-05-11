package com.accenture.adf.newcodington.module16.sample;

import java.text.DecimalFormat;

/**
 * Class to convert one unit into other units of temperature
 */
public class TemperatureConvertor {
	// Displays messages after conversion
	private String conversionMessage;
	/**
	 * Default empty constructor
	 */
	public TemperatureConvertor()
	{
		
	}
	/**
	 * Constructor accepts temperature object to initiate conversion
	 * @param temperature
	 * @throws NullPointerException
	 * @throws ArithmeticException
	 */
	public TemperatureConvertor(Temperature temperature) throws NullPointerException, ArithmeticException
	{
		try
		{
			if(temperature==null)
				throw new NullPointerException("The Temperature Object was not found");
			if(temperature.getCurrUOM()==temperature.getNewUOM())
				throw new ArithmeticException("No conversion required.  The units of measure are the same.");
		}
		catch(NullPointerException ex)
		{
			System.out.println(ex.getMessage());
			throw new NullPointerException(ex.getMessage());
		}
		catch(ArithmeticException ex)
		{
			System.out.println(ex.getMessage());
			System.out.println("The temperature remains the same: " + temperature.getTemparature() + temperature.getCurrUOM());
			throw new ArithmeticException(ex.getMessage());
		}
		conversionMessage="Temperature Converter Initiated:  Temperature Data Received";
		System.out.println(conversionMessage);
	}
	/**
	 * Method to convert one unit into anathor
	 * @param temperature
	 * @throws NullPointerException
	 * @throws ArithmeticException
	 */
	public void convertTemperature(Temperature temperature) throws NullPointerException, ArithmeticException
	{
		conversionMessage="Conversion Performed: Old Temperature = "+temperature.getTemparature()+ temperature.getCurrUOM();
		
		switch(temperature.getCurrUOM())
		{
		 case 'K':
			 if(temperature.getNewUOM()=='C') {
				 convertKelvinToCelsius(temperature);
			 }else if(temperature.getNewUOM()=='F') {
				 convertKelvintoFahrenheit(temperature);
			 }
			 break;
		 case 'C':
			 if(temperature.getNewUOM()=='K') {
				 convertCelsiusToKelvin(temperature);
			 }else if(temperature.getNewUOM()=='F') {
				 convertCelsiusToFahrenheit(temperature);
			 }
			 break;
		 case 'F':
			 if(temperature.getNewUOM()=='K') {
				 convertFahrenheitToKelvin(temperature);
			 }else if(temperature.getNewUOM()=='C') {
				 convertFahrenheitToCelsius(temperature);
			 }
			 break;			 
		}
		
		System.out.println(conversionMessage + " New Temperature = " +temperature.getTemparature() + temperature.getNewUOM());
		if(absoluteZeroCheck(temperature))
		{
//			conversionMessage+="New Temparature ="+temperature.getTemparature()+" "+temperature.getCurrUOM();
//			System.out.println(conversionMessage);
			System.out.println("Temperature Below Absolute Zero! Must be reset to Absolute zero.");
			temperature.setTemparature(0);
			temperature.setCurrUOM('K');
			temperature.setNewUOM('K');
			conversionMessage+=" New Temparature = "+temperature.getTemparature() + temperature.getCurrUOM();
		}else {
			conversionMessage+=" New Temparature = "+temperature.getTemparature() + temperature.getNewUOM();
		}
		
		System.out.println("Last Successful Action: "+conversionMessage);				
	}
	/**
	 * Method to convert Fahrenheit to Kelvin
	 * @param temperature
	 * @throws NullPointerException
	 * @throws ArithmeticException
	 */
	public void convertFahrenheitToKelvin(Temperature temperature) throws NullPointerException, ArithmeticException
	{
		float newTemperature;
		float currTemperatute;
		currTemperatute=temperature.getTemparature();
		newTemperature=(5.0f/9.0f) * (currTemperatute - 32f) + 273.15f;
		temperature.setTemparature(newTemperature);
		temperature.setCurrUOM('F');
		temperature.setNewUOM('K');
	}
	/**
	 * Method to convert Fahrenheit to Celsius
	 * @param temperature
	 * @throws NullPointerException
	 * @throws ArithmeticException
	 */
	public void convertFahrenheitToCelsius(Temperature temperature) throws NullPointerException, ArithmeticException
	{
		float newTemperature;
		float currTemperatute;
		currTemperatute=temperature.getTemparature();
		newTemperature=(5.0f/9.0f)*(currTemperatute-32f);
		temperature.setTemparature(newTemperature);
		temperature.setCurrUOM('F');
		temperature.setNewUOM('C');
	}
	/**
	 * Method to convert Celsius to Fahrenheit
	 * @param temperature
	 * @throws NullPointerException
	 * @throws ArithmeticException
	 */
	public	void convertCelsiusToFahrenheit(Temperature temperature) throws NullPointerException, ArithmeticException
	{
		float newTemperature;
		float currTemperatute;
		currTemperatute=temperature.getTemparature();
		newTemperature=((9f/5f)*currTemperatute)+32f;
		temperature.setTemparature(newTemperature);
		temperature.setCurrUOM('C');
		temperature.setNewUOM('F');
	}
	/**
	 * Method to convert Celsius to Kelvin
	 * @param temperature
	 * @throws NullPointerException
	 * @throws ArithmeticException
	 */
	public	void convertCelsiusToKelvin(Temperature temperature) throws NullPointerException, ArithmeticException
	{
		float newTemperature;
		float currTemperatute;
		currTemperatute=temperature.getTemparature();
		newTemperature=currTemperatute+273.15f;
		temperature.setTemparature(newTemperature);
		temperature.setCurrUOM('C');
		temperature.setNewUOM('K');
	}
	/**
	 * Method to convert Kelvin to Fahrenheit 
	 * @param temperature
	 * @throws NullPointerException
	 * @throws ArithmeticException
	 */
	public	void convertKelvintoFahrenheit(Temperature temperature) throws NullPointerException, ArithmeticException
	{
		float newTemperature;
		float currTemperatute;
		currTemperatute=temperature.getTemparature();
		newTemperature=(9.0f/5.0f)*(currTemperatute-273.15f)+32f;
		temperature.setTemparature(newTemperature);
		temperature.setCurrUOM('K');
		temperature.setNewUOM('F');
	}
	/**
	 * Method to convert Kelvin to Celsius 
	 * @param temperature
	 * @throws NullPointerException
	 * @throws ArithmeticException
	 */
	public void convertKelvinToCelsius(Temperature temperature) throws NullPointerException, ArithmeticException
	{
		float newTemperature;
		float currTemperatute;
		currTemperatute=temperature.getTemparature();
		newTemperature=currTemperatute-273.15f;
		temperature.setTemparature(newTemperature);
		temperature.setCurrUOM('K');
		temperature.setNewUOM('C');
	}
	/**
	 * Method to check temperature for absolute zero
	 * @param temperature
	 * @return boolean
	 * @throws NullPointerException
	 * @throws ArithmeticException
	 */
	public boolean absoluteZeroCheck(Temperature temperature) throws NullPointerException, ArithmeticException
	{
		float newTemperature=temperature.getTemparature();
		char newUOM=temperature.getNewUOM();
		boolean checkResult=false;
		switch(newUOM)
		{
		 case 'C':
			 if(newTemperature < -273.15f) {
				 checkResult=true;
			 }
			 	break;
		 case 'F':
			 if(newTemperature < -459.67f) {
				 checkResult=true;
			 }
			 	break;
		 case 'K':
			 if(newTemperature < 0F) {
				 checkResult=true;
			 }
			 	break;
		}
		return checkResult;
	}
	
	// Getter and Setter methods
	
	public String getConversionMessage() {
		return conversionMessage;
	}
	public void setConversionMessage(String conversionMessage) {
		this.conversionMessage = conversionMessage;
	}
	
	
	
}
