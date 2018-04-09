/**
 * 
 */
package com.service;

import java.util.HashMap;
import java.util.List;

import com.model.YdYhdl;
import com.model.Yhxx;
import com.model.Yhzh;
import com.model.virtual.RegisterInfo;

/**
 * @author Chanin
 *
 */
public interface IYhxxService {

	public List<Yhxx> selectYhXx(HashMap<String, Object> paramMap) throws Exception;

	public int updateYhXx(HashMap<String, Object> paramMap) throws Exception;

	public int updateYhXxToken(String yhId, String token, Long expTime) throws Exception;

	//public Yhxx selectYhXxByToken(String token) throws Exception;

	public YdYhdl selectYdYhdl(HashMap<String, Object> paramMap) throws Exception;

	public Yhxx getYhxxByToken(String token) throws Exception;

	public void changeYhmm(String dlzh, String oldMm, String newMm) throws Exception;

	public void registerUser(RegisterInfo registerInfo) throws Exception;

	public List<Yhzh> selectYhzh(HashMap<String, Object> paramMap) throws Exception;

	public void updateYhXx(Yhxx yhxx) throws Exception;

	// public List<Yhxx> selectYhxxByQzid(HashMap<String, Object> paramMap) throws
	// Exception;

}
