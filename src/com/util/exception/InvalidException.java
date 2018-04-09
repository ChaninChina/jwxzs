package com.util.exception;

/**
 * 无效访问
 * @author QingLong
 */
public class InvalidException extends Exception {
	
	private static final long serialVersionUID = -1110269643055478082L;
	
	public InvalidException() {}
	
	public InvalidException (String msg) {
		super(msg);
	}
	
	public InvalidException (Throwable thr) {
		super(thr);
	}
	
	public InvalidException (String msg, Throwable thr) {
		super(msg, thr);
	}
}