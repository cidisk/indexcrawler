package io.github.cidisk.indexcrawler.exceptions;

public class DeadFishException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DeadFishException(int depth){
		super("Aborted fetching of this URL because depth ( " + depth + " ), dead fish!");
	}
}
