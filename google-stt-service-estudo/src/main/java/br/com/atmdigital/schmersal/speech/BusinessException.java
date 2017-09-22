package br.com.atmdigital.schmersal.speech;

public class BusinessException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BusinessException (String message){
		super(message);
	}
	
	public BusinessException (){
		super();
	}
}
