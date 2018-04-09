/**
 * 
 */
package com.service.Impl;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.collections4.CollectionUtils;

import com.mapper.YdYhdlMapper;
import com.mapper.YhxxMapper;
import com.mapper.YhzhMapper;
import com.model.YdYhdl;
import com.model.Yhxx;
import com.model.Yhzh;
import com.model.virtual.RegisterInfo;
import com.service.IYhxxService;
import com.util.DateUtil;
import com.util.PinyUtil;
import com.util.UUIDUtil;
import com.util.dict.DictEnumUtil;
import com.util.exception.AuthException;

/**
 * @author Chanin
 *
 */
public class YhxxService implements IYhxxService{
	
	@Resource
	private YhxxMapper yhXxMapper;
	@Resource
	private YhzhMapper yhzhMapper;
	@Resource
	private YdYhdlMapper ydYhdlMapper;

	/* 登录
	 * @see com.service.IYhXxService#selectYhXx(java.util.HashMap)
	 */
	@Override
	public List<Yhxx> selectYhXx(HashMap<String, Object> paramMap) throws Exception {
		// TODO Auto-generated method stub
		
		return yhXxMapper.selectYhxx(paramMap);
	}


	/* (non-Javadoc)
	 *修改
	 */
	@Override
	public int updateYhXx(HashMap<String, Object> paramMap) throws Exception {
		// TODO Auto-generated method stub
		return yhXxMapper.updateYhxx(paramMap);
	}


	/* (non-Javadoc)
	 * 修改Token
	 * 
	 */
	@Override
	public int updateYhXxToken(String yhId, String token,Long expTime) throws Exception {
		// TODO Auto-generated method stub
		Yhxx yhXx = new Yhxx();
		yhXx.setYhid(yhId);
//		yhXx.setToken(token);
//		yhXx.setExpTime(expTime);		
		return yhXxMapper.updateByPrimaryKeySelective(yhXx);
	}

//
//	/* (non-Javadoc)
//	 * @see com.service.IYhXxService#selectYhXxByToken(java.lang.String)
//	 * 通过token获取用户信息
//	 */
//	@Override
//	public Yhxx selectYhXxByToken(String token) throws Exception {
//		HashMap<String, Object> paramMap = new HashMap<>();
//		paramMap.put("token", token);
//		paramMap.put("deleteStatus", DictEnumUtil.DELETE_STATUS_WSC);
//		List<Yhxx> yhXxs = selectYhXx(paramMap );
//		if(CollectionUtils.isNotEmpty(yhXxs)){
//			Yhxx yhXx = yhXxs.get(0);
////			if(System.currentTimeMillis()>yhXx.getExpTime()){
////				throw new AuthException("token已过期！");
////			}else {
////				return yhXx;
////			}
//		}else {
//			throw new AuthException("token无效！");
//		}
//		return null;
//	}


	/**
	 * 登陆
	 */
	@Override
	public YdYhdl selectYdYhdl(HashMap<String, Object> paramMap) throws Exception {
		List<Yhzh> yhzhs =  yhzhMapper.selectYhzh(paramMap);
		if(CollectionUtils.isEmpty(yhzhs)) {
			throw new Exception("用户名或密码不正确！");
		}
		Yhzh yhzh = yhzhs.get(0);
		
//		HashMap<String, Object> ydYhdlParam = new HashMap<>();
//		ydYhdlParam.put("yhid", yhzh.getYhid());
//		ydYhdlParam.put("gqsj", DateUtil.getDate(DateUtil.yyyy_MM_dd_HH_mm_ss));
//		List<YdYhdl> ydYhdls= ydYhdlMapper.selectYdYhdl(ydYhdlParam);
		HashMap<String, Object> yhxxlParam = new HashMap<>();
		yhxxlParam.put("yhid", yhzh.getYhid());
		yhxxlParam.put("deleteStatus", DictEnumUtil.DELETE_STATUS_WSC);
		List<Yhxx> yhXxs = yhXxMapper.selectYhxx(yhxxlParam);
		if(CollectionUtils.isEmpty(yhXxs)) {
			throw new Exception("用户已注销！");
		}
		Yhxx yhxx = yhXxs.get(0);
		if(DictEnumUtil.GLYBZ_TRUE.equals(yhxx.getGlybz())) {
			throw new Exception("用户类型不符！");
		}
		
		YdYhdl ydYhdl = ydYhdlMapper.selectByPrimaryKey(yhzh.getYhid());
		if(ydYhdl == null) {
			ydYhdl = new YdYhdl();
			ydYhdl.setYhid(yhzh.getYhid());
			ydYhdl.setToken(UUIDUtil.getUUID());
			ydYhdl.setGqsj(System.currentTimeMillis()+15*24*3600*1000);
			ydYhdl.setDlsj(DateUtil.getDate(DateUtil.yyyy_MM_dd_HH_mm_ss));
			ydYhdl.setEnableStatus(DictEnumUtil.ENABLE_STATUS_YQY);
			ydYhdl.setDeleteStatus(DictEnumUtil.DELETE_STATUS_WSC);
			ydYhdl.setCreateId(yhzh.getYhid());
			ydYhdl.setCreateTime(DateUtil.getDate(DateUtil.yyyy_MM_dd_HH_mm_ss));
			ydYhdl.setUpdateId(yhzh.getYhid());
			ydYhdl.setUpdateTime(DateUtil.getDate(DateUtil.yyyy_MM_dd_HH_mm_ss));
			ydYhdlMapper.insertSelective(ydYhdl);
		}else {
			ydYhdl.setToken(UUIDUtil.getUUID());
			ydYhdl.setGqsj(System.currentTimeMillis()+15*24*3600*1000);
			ydYhdl.setDlsj(DateUtil.getDate(DateUtil.yyyy_MM_dd_HH_mm_ss));
			ydYhdl.setUpdateId(yhzh.getYhid());
			ydYhdl.setUpdateTime(DateUtil.getDate(DateUtil.yyyy_MM_dd_HH_mm_ss));
			ydYhdlMapper.updateByPrimaryKeySelective(ydYhdl);
		}
		ydYhdl.setYhxx(yhxx);
		return ydYhdl;
	}


	@Override
	public Yhxx getYhxxByToken(String token) throws Exception {
		// TODO Auto-generated method stub		
		
		HashMap<String, Object> paramMap = new HashMap<>();
		paramMap.put("token", token);
		List<YdYhdl> yhdls = ydYhdlMapper.selectYdYhdl(paramMap );
		if(CollectionUtils.isEmpty(yhdls)) {
			throw new AuthException("无效token");
		}
		
		YdYhdl ydYhdl = yhdls.get(0);
		if(ydYhdl.getGqsj()<System.currentTimeMillis() ) {
			throw new AuthException("token已过期");
		}
		return yhXxMapper.selectByPrimaryKey(ydYhdl.getYhid());
	}


	/**
	 * 修改用户密码
	 */
	@Override
	public void changeYhmm(String dlzh, String oldMm, String newMm) throws Exception {
		HashMap<String, Object> paramMap = new HashMap<>();
		paramMap.put("dlzh", dlzh);
		paramMap.put("dlmm", oldMm);
		paramMap.put("deleteStatus", DictEnumUtil.DELETE_STATUS_WSC);
		List<Yhzh> yhzhs = yhzhMapper.selectYhzh(paramMap);
		if(CollectionUtils.isEmpty(yhzhs)) {
			throw new Exception("当前没有找到账号！");
		}
		
		Yhzh yhzh = yhzhs.get(0);
		yhzh.setDlmm(newMm);
		yhzh.setUpdateId(yhzh.getYhid());
		yhzh.setUpdateTime(DateUtil.getDate(DateUtil.yyyy_MM_dd_HH_mm_ss));
		yhzhMapper.updateByPrimaryKeySelective(yhzh);
	}


	/**
	 * 注册用户信息
	 */
	@Override
	public void registerUser(RegisterInfo registerInfo) throws Exception {
		// TODO Auto-generated method stub
		String yhid = UUIDUtil.getUUID();
		String nowDate = DateUtil.getDate(DateUtil.yyyy_MM_dd_HH_mm_ss);
		Yhxx yhxx =new  Yhxx.Builder()
				.yhid(yhid)
				.orgnId(registerInfo.getOrgnId())
				.yhxm(registerInfo.getYhxm())
				.yhsp(PinyUtil.getFullyPinyin(registerInfo.getYhxm(), false, false))
				.yhlx(registerInfo.getYhlx())
				.yhxb(registerInfo.getYhxb())
				.lxdh(registerInfo.getLxdh())
				.sfzh(registerInfo.getSfzh())
				.yhzw(registerInfo.getYhzw())
				.szdw(registerInfo.getSzdw())
				.glybz(DictEnumUtil.GLYBZ_FALSE)
				.enableStatus(DictEnumUtil.ENABLE_STATUS_YQY)
				.deleteStatus(DictEnumUtil.DELETE_STATUS_WSC)
				.createTime(nowDate)
				.createId(yhid)
				.updateTime(nowDate)
				.updateId(yhid)
				.build();
		yhXxMapper.insertSelective(yhxx);
		
		Yhzh yhzh = new Yhzh.Builder()
				.zhid(UUIDUtil.getUUID())
				.yhid(yhid)
				.dlzh(registerInfo.getDlzh())
				.dlmm(registerInfo.getDlmm())
				.sypt(registerInfo.getSypt())
				.zhlx(registerInfo.getZhlx())
				.enableStatus(DictEnumUtil.ENABLE_STATUS_YQY)
				.deleteStatus(DictEnumUtil.DELETE_STATUS_WSC)
				.createTime(nowDate)
				.createId(yhid)
				.updateTime(nowDate)
				.updateId(yhid)
				.build();
		yhzhMapper.insertSelective(yhzh);
		
		
	}


	/**
	 * 查询用户账号信息
	 */
	@Override
	public List<Yhzh> selectYhzh(HashMap<String, Object> paramMap) throws Exception {
		// TODO Auto-generated method stub
		return yhzhMapper.selectYhzh(paramMap);
	}


	/**
	 * 修改用户信息
	 */
	@Override
	public void updateYhXx(Yhxx yhxx) throws Exception {
		// TODO Auto-generated method stub
		yhXxMapper.updateByPrimaryKeySelective(yhxx);
	}

}
