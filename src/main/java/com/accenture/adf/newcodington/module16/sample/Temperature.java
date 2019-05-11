package com.accenture.adf.newcodington.module16.sample;
/**
 * Temperature Domain class
 */
public class Temperature {

	// Data fields to accept temperature, Current and New Units
	private float temperature;
	private char currUOM;
	private char newUOM;
	
	/**
	 * Default constructor to set initial values
	 */
	public Temperature()
	{
		temperature=32;
		currUOM='F';
		newUOM='C';
	}
	/**
	 * Constructor for accepting temperature and current units 
	 * @param temparature
	 * @param currUOM
	 * @throws ArithmeticException
	 * @throws NullPointerException
	 */
	public Temperature(float temparature,char currUOM) throws ArithmeticException,NullPointerException
	{
		if(currUOM != 'F' && currUOM != 'C' && currUOM != 'K')
		{
			throw new ArithmeticException("Invalid Unit of Measure Provided for current UOM:"+currUOM+ ". Value must be  C, F, or K");
		}
		switch (currUOM) {
		case 'C':
			this.newUOM='K';
			break;
		case 'F':
			this.newUOM='C';
			break;
		case 'K':
			this.newUOM='C';
			break;
		}
		if(newUOM != 'F' && newUOM != 'C' && newUOM != 'K')
		{
			throw new ArithmeticException("Invalid Unit of Measure Provided for current UOM:"+newUOM+ ". Value must be  C, F, or K");
		}
		this.temperature=temparature;
		this.currUOM=currUOM;
	}
	
	/**
	 * Constructor for accepting temperature, current units and new units 
	 * @param temparature
	 * @param currUOM
	 * @param newUOM
	 * @throws ArithmeticException
	 * @throws NullPointerException
	 */
	public Temperature(float temparature,char currUOM,char newUOM) throws ArithmeticException,NullPointerException
	{
		if(currUOM != 'F' && currUOM != 'C' && currUOM != 'K')
		{
			throw new ArithmeticException("Invalid Unit of Measure Provided for current UOM:"+currUOM+ ". Value must be  C, F, or K");
		}
		if(newUOM != 'F' && newUOM != 'C' && newUOM != 'K')
		{
			throw new ArithmeticException("Invalid Unit of Measure Provided for current UOM:"+newUOM+ ". Value must be  C, F, or K");
		}
		this.temperature=temparature;
		this.currUOM=currUOM;
		this.newUOM=newUOM;
	}	
	
	// Getter and Setter Methods
	
	public float getTemparature() {
		return temperature;
	}
	public void setTemparature(float temparature) {
		this.temperature = temparature;
	}
	public char getCurrUOM() {
		return currUOM;
	}
	public void setCurrUOM(char currUOM) {
		this.currUOM = currUOM;
	}
	public char getNewUOM() {
		return newUOM;
	}
	public void setNewUOM(char newUOM) {
		this.newUOM = newUOM;
	}
	
}
