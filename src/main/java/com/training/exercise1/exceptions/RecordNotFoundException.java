/**
 * 
 */
package com.training.exercise1.exceptions;

/**
 * @author michaeldelacruz
 *
 */

public class RecordNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RecordNotFoundException(String message) {
		super(message);
	}
	
	public RecordNotFoundException(String message, Throwable t) {
		super(message, t);
	}
	
}
