package com.util.model;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import org.apache.commons.io.output.ByteArrayOutputStream;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 基础实体对象
 * @author QingLong
 */
public class BasicObject implements Cloneable, Serializable {
	
	private static final long serialVersionUID = -7314955721752904307L;
	
	/**
	 * 覆盖默认的toString方法实现
	 */
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
	
	/**
	 * 覆盖默认的clone方法实现
	 */
	@Override
	public Object clone() {
		ByteArrayOutputStream byteOut = null;
		ObjectOutputStream objOut = null;
		ByteArrayInputStream byteIn = null;
		ObjectInputStream objIn = null;
		try {
			byteOut = new ByteArrayOutputStream();
			objOut = new ObjectOutputStream(byteOut);
			objOut.writeObject(this);
			byteIn = new ByteArrayInputStream(byteOut.toByteArray());
			objIn = new ObjectInputStream(byteIn);
			return (Object) objIn.readObject();
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} finally {
			try {
				byteIn = null;
				byteOut = null;
				if (objOut != null) objOut.close();
				if (objIn != null) objIn.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return null;
	}
}