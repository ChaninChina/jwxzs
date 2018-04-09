package com.util.exception;

/**
 * 登录超时
 * @author QingLong
 */
public class TimeoutException extends Exception {
	
	private static final long serialVersionUID = 1586004283642131805L;
	
	public TimeoutException() {}
	
	public TimeoutException (String msg) {
		super(msg);
	}
	
	public TimeoutException (Throwable thr) {
		super(thr);
	}
	
	public TimeoutException (String msg, Throwable thr) {
		super(msg, thr);
	}
}