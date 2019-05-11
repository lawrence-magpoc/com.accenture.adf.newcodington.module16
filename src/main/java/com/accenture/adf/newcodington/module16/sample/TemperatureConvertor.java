package com.accenture.adf.newcodington.module16.sample;
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
		}
		catch(ArithmeticException ex)
		{
			System.out.println(ex.getMessage());
			System.out.println("The temperature remains the same:" + temperature.getTemparature() + "degrees " + temperature.getCurrUOM());
		}
		conversionMessage="Temperature Converter Initiated:  Temperature Data Received";
	}
	/**
	 * Method to convert one unit into anathor
	 * @param temperature
	 * @throws NullPointerException
	 * @throws ArithmeticException
	 */
	public void convertTemperature(Temperature temperature) throws NullPointerException, ArithmeticException
	{
		conversionMessage=" Conversion Performed:  Old Temperature = "+temperature.getTemparature()+ " "+ temperature.getNewUOM();
		
		switch(temperature.getCurrUOM())
		{
		 case 'K':
			 if(temperature.getNewUOM()=='C')
				 convertCelsiusToKelvin(temperature);
			 else if(temperature.getNewUOM()=='F')
				 convertKelvintoFahrenheit(temperature);
			 break;
		 case 'C':
			 if(temperature.getNewUOM()=='K')
				 convertCelsiusToKelvin(temperature);
			 else if(temperature.getNewUOM()=='F')
				 convertFahrenheitToCelsius(temperature);
			 break;
		 case 'F':
			 if(temperature.getNewUOM()=='F')
				 convertKelvintoFahrenheit(temperature);
			 else if(temperature.getNewUOM()=='F')
				 convertFahrenheitToCelsius(temperature);
			 break;			 
		}
		
		if(absoluteZeroCheck(temperature))
		{
			conversionMessage+="New Temparature ="+temperature.getTemparature()+" "+temperature.getCurrUOM();
			System.out.println(conversionMessage);
			System.out.println("Temperature Below Absolute Zero! Must be reset to Absolute zero.");
			temperature.setTemparature(0);
			temperature.setCurrUOM('K');
			temperature.setNewUOM('K');
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
		newTemperature=(5/9)*(currTemperatute+32)-273.15f;
		temperature.setTemparature(newTemperature);
		temperature.setCurrUOM('K');
		temperature.setNewUOM('F');
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
		newTemperature=(5/9)*(currTemperatute-32);
		temperature.setTemparature(currTemperatute);
		temperature.setCurrUOM('C');
		temperature.setNewUOM('F');
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
		newTemperature=(5/9*currTemperatute)+32;
		temperature.setTemparature(newTemperature);
		temperature.setCurrUOM('F');
		temperature.setNewUOM('C');
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
		newTemperature=currTemperatute+273f;
		temperature.setTemparature(newTemperature);
		temperature.setCurrUOM('K');
		temperature.setNewUOM('C');
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
		newTemperature=9/5*(currTemperatute-273.15f)+32;
		temperature.setTemparature(newTemperature);
		temperature.setCurrUOM('F');
		temperature.setNewUOM('K');
	}
	/**
	 * Method to convert Kelvin to Celsius 
	 * @param temperature
	 * @throws NullPointerException
	 * @throws ArithmeticException
	 */
	public void convertKelvintoCelsius(Temperature temperature) throws NullPointerException, ArithmeticException
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
		float currTemperature=temperature.getTemparature();
		char currUOM=temperature.getCurrUOM();
		boolean checkResult=false;
		switch(currUOM)
		{
		 case 'C':
			 if(currTemperature<273.15)
				 checkResult=true;
			 	break;
		 case 'F':
			 if(currTemperature<549.67)
				 checkResult=true;
			 	break;
		 case 'K':
			 if(currTemperature<0)
				 checkResult=true;
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
