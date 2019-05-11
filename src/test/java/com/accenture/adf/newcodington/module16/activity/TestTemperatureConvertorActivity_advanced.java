package com.accenture.adf.newcodington.module16.activity;

import java.text.DecimalFormat;

import org.junit.Test;

import com.accenture.adf.newcodington.module16.sample.Temperature;
import com.accenture.adf.newcodington.module16.sample.TemperatureConvertor;

import junit.framework.TestCase;
/**
 * Topic : Unit Testing
 * 
 * Description:
 * 
 * The TestTemperatureConvertorActivity class is used test 
 * the workflow conditions of the TemperatureConvertor domain class. 
 * It tests the normal condition and the exception conditions for the class
 */

public class TestTemperatureConvertorActivity_advanced extends TestCase {

	// Local objects of Temparature and TemperatureConvertorSolution classes
	Temperature temperature;
	TemperatureConvertor convertorSolution;

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	@Test
	/**
	 * TCS.UT.AP331.TC.009: Initialization is done successfully
	 */
	public void testTemparatureConvertorSolution() {

		temperature = new Temperature();
		convertorSolution = new TemperatureConvertor(temperature);
		assertEquals("Temperature Converter Initiated:  Temperature Data Received",
					convertorSolution.getConversionMessage());
	}
	@Test
	/**
	 * TCS.UT.AP331.TC.010: Pass Temperature Object (no Temperature Object)
	 */
	public void testTemperatureConvertorSolutionTemperature_NoObject() {

		/* TODO 1 - create a new TemperatureConvertor object by passing a null argument to the constructor
		 * 			handle the NullPointerException thrown by the constructor and write an assert statement
		 * 			to ensure that appropriate exception was thrown.
		 */	
		
		try {
			convertorSolution = new TemperatureConvertor(null);
		} catch (NullPointerException e) {
			assertEquals(e.getMessage(), "The Temperature Object was not found");
		}
	}
	
	@Test
	/**
	 * TCS.UT.AP331.TC.011: Pass Temperature Object 
	 * (temperature, currUOM and newUOM are VALID but the same)
	 */
	public void testTemperatureConvertorSolutionTemperature_SameUOM() {


		temperature = new Temperature(32f, 'F', 'F');

		// TODO 2 - write an assert statement statement to ensure that required exception is being thrown

		try {
			convertorSolution = new TemperatureConvertor(temperature);
		} catch (ArithmeticException e) {
			assertEquals(e.getMessage(), "No conversion required.  The units of measure are the same.");
		}
	}
	@Test
	/**
	 *  TCS.UT.AP331.TC.012: Celsius to Fahrenheit
	 */
	public void testConvertTemperature_Celsius_Fahrenheit() {

		temperature = new Temperature(50.0f, 'C', 'F');
		convertorSolution = new TemperatureConvertor();
		convertorSolution.convertTemperature(temperature);
		
		// TODO 3 - Write assert statements to run the the test conditions 
		assertTrue(temperature.getCurrUOM() == 'C' 
				&& temperature.getNewUOM() == 'F'
				&& temperature.getTemparature() == 122f);

	}
	@Test
	/**
	 * TCS.UT.AP331.TC.013: Test Celsius to Kelvin
	 */
	public void testConvertTemperature_Celsius_Kelvin() {
		temperature = new Temperature(100.0f, 'C', 'K');
		convertorSolution = new TemperatureConvertor();
		convertorSolution.convertTemperature(temperature);

		// TODO 4 - Write assert statements to run the the test conditions
		assertTrue(temperature.getCurrUOM() == 'C' 
				&& temperature.getNewUOM() == 'K' 
				&& temperature.getTemparature() == 373.15f);
	}
	@Test
	/**
	 *  TCS.UT.AP331.TC.014: Test Fahrenheit to Celsius
	 */
	public void testConvertTemperature_Fahrenheit_Celsius() {
		temperature = new Temperature(212.0f, 'F', 'C');
		convertorSolution = new TemperatureConvertor();
		convertorSolution.convertTemperature(temperature);

		// TODO 5 - Write assert statements to run the the test conditions

		DecimalFormat df = new DecimalFormat("0.0000");
		assertTrue(temperature.getCurrUOM() == 'F' 
				&& temperature.getNewUOM() == 'C' 
				&& Float.parseFloat(df.format(temperature.getTemparature())) == 100f);
	}
	@Test
	/**
	 *  TCS.UT.AP331.TC.015: Test Fahrenheit to Kelvin
	 */
	public void testConvertTemperature_Fahrenheit_Kelvin() {
		temperature = new Temperature(-94.0f, 'F', 'K');
		convertorSolution = new TemperatureConvertor();
		convertorSolution.convertTemperature(temperature);

		// TODO 6 - Write assert statements to run the the test conditions
		assertTrue(temperature.getCurrUOM() == 'F' 
				&& temperature.getNewUOM() == 'K' 
				&& temperature.getTemparature() == 203.15f);
	}
	@Test
	/**
	 *  TCS.UT.AP331.TC.016: Test Kelvin to Celsius
	 */
	public void testConvertTemperature_Kelvin_Celsius() {
		temperature = new Temperature(367.0f, 'K', 'C');
		convertorSolution = new TemperatureConvertor();
		convertorSolution.convertTemperature(temperature);

		// TODO 7 - Write assert statements to run the the test conditions
		DecimalFormat df = new DecimalFormat("0.0000");
		assertTrue(temperature.getCurrUOM() == 'K' 
				&& temperature.getNewUOM() == 'C' 
				&& Float.parseFloat(df.format(temperature.getTemparature())) == 93.85f);
	}
	@Test
	/**
	 *  TCS.UT.AP331.TC.017: Test Kelvin to Fahrenheit
	 */
	public void testConvertTemperature_Kelvin_Fahrenheit() {
		temperature = new Temperature(32.0f, 'K', 'F');
		convertorSolution = new TemperatureConvertor();
		convertorSolution.convertTemperature(temperature);
	
		// TODO 8 - Write assert statements to run the the test conditions
		DecimalFormat df = new DecimalFormat("0.0000");
		assertTrue(temperature.getCurrUOM() == 'K' 
				&& temperature.getNewUOM() == 'F' 
				&& Float.parseFloat(df.format(temperature.getTemparature())) == -402.07f);
	}
	@Test
	/**
	 * TCS.UT.AP331.TC.018:Test Fahrenheit to Celsius: Absolute zero check -
	 * adjust Celsius temperature
	 */
	public void testConvertTemperature_Fahrenheit_Celsius_AbsoluteZero() {

		temperature = new Temperature(-459.7f, 'F', 'C');
		convertorSolution = new TemperatureConvertor();
		convertorSolution.convertTemperature(temperature);
	
		// TODO 9 - Write assert statements to run the the test conditions
		assertTrue(temperature.getCurrUOM() == 'K' 
				&& temperature.getNewUOM() == 'K' 
				&& temperature.getTemparature() == 0f);
	}
	@Test
	/**
	 * TCS.UT.AP331.TC.019:Test Kelvin to Fahrenheit : Absolute zero check -
	 * adjust Fahrenheit temperature
	 */
	public void testConvertTemperature_Kelvin_Fahrenheit_AbsoluteZero() {

		temperature = new Temperature(-0.1f, 'K', 'F');
		convertorSolution = new TemperatureConvertor();
		convertorSolution.convertTemperature(temperature);
		
		// TODO 10  - Write assert statements to run the the test conditions
		assertTrue(temperature.getCurrUOM() == 'K' 
				&& temperature.getNewUOM() == 'K' 
				&& temperature.getTemparature() == 0f);
	}
	@Test
	/**
	 * TCS.UT.AP331.TC.020:Test Celsius to Kelvin : Absolute zero check -
	 * adjust Kelvin temperature
	 */
	public void testConvertTemperature_Celsius_Kelvin_AbsoluteZero() {

		temperature = new Temperature(-273.16f, 'C', 'K');
		convertorSolution = new TemperatureConvertor();
		convertorSolution.convertTemperature(temperature);
	
		// TODO 11 - Write assert statements to run the the test conditions
		assertTrue(temperature.getCurrUOM() == 'K' 
				&& temperature.getNewUOM() == 'K' 
				&& temperature.getTemparature() == 0f);
	}

}
