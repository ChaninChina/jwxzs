/**
 * 
 */
package com.service.Impl;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import com.mapper.MbJltmMapper;
import com.mapper.MbJlxxKzxxMapper;
import com.mapper.MbJlxxMapper;
import com.mapper.MbTmfzMapper;
import com.mapper.MbTmkzMapper;
import com.mapper.MbxxMapper;
import com.mapper.StrwMapper;
import com.model.MbJltm;
import com.model.MbJlxx;
import com.model.MbJlxxKzxx;
import com.model.MbTmfz;
import com.model.MbTmkz;
import com.model.Mbxx;
import com.service.IMbxxService;
import com.util.dict.DictEnumUtil;

/**
 * @author Chanin
 *
 */
public class MbxxService implements IMbxxService {

	@Resource
	private MbTmfzMapper mbTmFzMapper;

	@Resource
	private MbJltmMapper mbJlTmMapper;

	@Resource
	private MbJlxxMapper mbJlXxMapper;

	@Resource
	private MbxxMapper mbXxMapper;

	@Resource
	private StrwMapper strwMapper;

	@Resource
	private MbJlxxKzxxMapper mbJlxxKzxxMapper;
	
	@Resource
	private MbTmkzMapper mbTmkzMapper;

	/*
	 * (non-Javadoc)
	 * 
	 * 查询模板条目分组信息
	 */
	@Override
	public List<MbTmfz> selectMbTmFz(HashMap<String, Object> paramMap) throws Exception {
		// TODO Auto-generated method stub
		return mbTmFzMapper.selectMbTmFz(paramMap);
	}

	/**
	 * 查询模板信息
	 * @param paramMap
	 * @return
	 */
	public List<Mbxx> selectMbXx(HashMap<String, String> paramMap) throws Exception {
		return mbXxMapper.selectMbXx(paramMap);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.service.IMbXxService#selectMbXxByStId(java.util.HashMap)
	 */
	@Override
	public Mbxx selectMbXxByStId(HashMap<String, String> paramMap) throws Exception {
		return null;
		// List<StMb> stMbs = strwMapper.selectStMb(paramMap);
		// if(CollectionUtils.isEmpty(stMbs)){
		// throw new Exception("实体还未关联模板！");
		// }
		// StMb stMb = stMbs.get(0);
		// HashMap<String, String> mbXxParamMap = new HashMap<>();
		// mbXxParamMap.put("mbid", stMb.getMbid());
		// mbXxParamMap.put("deleteStatus", DictEnumUtil.DELETE_STATUS_WSC);
		// List<MbXx> mbXxs = mbXxMapper.selectMbXx(mbXxParamMap);
		// if(CollectionUtils.isNotEmpty(mbXxs)){
		// MbXx mbXx = mbXxs.get(0);
		// HashMap<String, String> tmfzParamMap = new HashMap<>();
		// tmfzParamMap.put("mbid", mbXx.getMbid());
		// tmfzParamMap.put("deleteStatus", DictEnumUtil.DELETE_STATUS_WSC);
		// List<MbTmFz> mbTmFzs = mbTmFzMapper.selectMbTmFz(tmfzParamMap);
		// if(CollectionUtils.isNotEmpty(mbTmFzs)){
		// for(MbTmFz mbTmFz:mbTmFzs){
		// HashMap<String, String> mbjlParamMap = new HashMap<>();
		// mbjlParamMap.put("tmfzid", mbTmFz.getTmfzid());
		// mbjlParamMap.put("deleteStatus", DictEnumUtil.DELETE_STATUS_WSC);
		// List<MbJlTm> mbJlTms = mbJlTmMapper.selectMbJlTm(mbjlParamMap);
		// if(CollectionUtils.isNotEmpty(mbJlTms)){
		// for(MbJlTm mbJlTm:mbJlTms){
		// HashMap<String, String> jjxxParamMap = new HashMap<>();
		// jjxxParamMap.put("jltmid", mbJlTm.getTmid());
		// jjxxParamMap.put("deleteStatus", DictEnumUtil.DELETE_STATUS_WSC);
		// List<MbJlXx> mbJlXxs = mbJlXxMapper.selectMbJlXx(jjxxParamMap);
		// if(CollectionUtils.isNotEmpty(mbJlXxs)){
		// mbJlTm.setMbJlXxs(mbJlXxs);
		// }
		// }
		// }
		// mbTmFz.setMbJlTms(mbJlTms);
		// }
		// }
		// mbXx.setMbTmFzs(mbTmFzs);
		// return mbXx;
		//
		// }else{
		// throw new Exception("未找到相关模板！");
		// }

	}

	/*
	 * 通过任务主键获取模板信息
	 *  (non-Javadoc)
	 * @see com.service.IMbxxService#selectMbXxByRwid(java.lang.String)
	 */
	@Override
	public Mbxx selectMbXxByRwid(String rwid) throws Exception {
		// TODO Auto-generated method stub
		HashMap<String, Object> p1 = new HashMap<>();
		p1.put("rwid", rwid);
		p1.put("deleteStatus", DictEnumUtil.DELETE_STATUS_WSC);
		List<Mbxx> mbxxs = mbXxMapper.selectMbxxByRwid(p1);
		if (CollectionUtils.isEmpty(mbxxs)) {
			throw new Exception("未找到任务模板信息！");
		}

		Mbxx mbxx = mbxxs.get(0);
		HashMap<String, Object> p2 = new HashMap<>();
		p2.put("mbid", mbxx.getMbid());
		p2.put("fjtmfzid", "null");
		p2.put("deleteStatus", DictEnumUtil.DELETE_STATUS_WSC);
		List<MbTmkz> mbTmkzs = mbTmkzMapper.selectMbTmKz(p2);
		mbxx.setMbtmkzs(mbTmkzs);
		List<MbTmfz> mbTmfzs = findMbTmFz(p2);//根据模板id获取模板记录分组
		mbxx.setMbTmfzs(mbTmfzs);
		
		return mbxx;
	}

	/**
	 * 根据条件获取模板条目分组
	 * @param p2
	 * @return
	 */
	private List<MbTmfz> findMbTmFz(HashMap<String, Object> p2) {
		List<MbTmfz> mbTmfzs = mbTmFzMapper.selectMbTmFz(p2);
		if (CollectionUtils.isNotEmpty(mbTmfzs)) {
			for (MbTmfz mbTmfz : mbTmfzs) {
				List<MbJltm> mbJltms = findMbJltm(mbTmfz.getTmfzid());
				mbTmfz.setMbJltms(mbJltms);
				if(DictEnumUtil.SUBSET_SYMBOL_YYZJ.equals(mbTmfz.getSubsetSymbol())) {
					HashMap<String, Object> p3 = new HashMap<>();
					p3.put("fjtmfzid", mbTmfz.getTmfzid());
					p3.put("deleteStatus", DictEnumUtil.DELETE_STATUS_WSC);
					List<MbTmfz> zjmbTmfzs = findMbTmFz(p3);//获取子集条目分组
					mbTmfz.setMbTmfzs(zjmbTmfzs);
				}
			}
		}
		return mbTmfzs;
	}

	/**
	 * 根据条目分组id获取条目
	 * @param tmfzid
	 * @return
	 */
	private List<MbJltm> findMbJltm(String tmfzid) {
		HashMap<String, Object> p3 = new HashMap<>();
		p3.put("tmfzid", tmfzid);
		p3.put("deleteStatus", DictEnumUtil.DELETE_STATUS_WSC);
		List<MbJltm> mbJltms = mbJlTmMapper.selectMbJlTm(p3);
		for (MbJltm mbJltm : mbJltms) {
			if (StringUtils.isNotEmpty(mbJltm.getTmlx()) && mbJltm.getTmlx().contains("-")
					&& (DictEnumUtil.TMLX_DX.equals(mbJltm.getTmlx().split("-")[0])
							|| DictEnumUtil.TMLX_MDX.equals(mbJltm.getTmlx().split("-")[0]))) {
				String tmid;
				if(StringUtils.isNoneBlank(mbJltm.getTmmbid())) {
					tmid = mbJltm.getTmmbid();
				}else {
					tmid = mbJltm.getTmid();
				}
				List<MbJlxx> mbjlxxs = findMbJlxxByTmid(tmid);
				mbJltm.setMbJlxxes(mbjlxxs);
			}
			
			
		}
		return mbJltms;
	}

	
	/**
	 * 根据条目id获取条目选项
	 * @param tmid
	 * @return
	 */
	private List<MbJlxx> findMbJlxxByTmid(String tmid) {
		HashMap<String, Object> p4 = new HashMap<>();
		p4.put("tmid", tmid);
		p4.put("deleteStatus", DictEnumUtil.DELETE_STATUS_WSC);
		return findMbjlxx(p4);
	}
	
	
	/**
	 * 根据父级条目选项主键获取条目选项
	 * @param fjxxid
	 * @return
	 */
	public List<MbJlxx> findZjMbJlxx(String fjxxid){
		HashMap<String, Object> p4 = new HashMap<>();
		p4.put("fjxxid", fjxxid);
		p4.put("deleteStatus", DictEnumUtil.DELETE_STATUS_WSC);
		return findMbjlxx(p4);
	}
	

	/**
	 * 根据条件获取条目选项
	 * @param p4
	 * @return
	 */
	private List<MbJlxx> findMbjlxx(HashMap<String, Object> p4) {
		List<MbJlxx> mbjlxxs = mbJlXxMapper.selectMbjlxx(p4);
		for (MbJlxx mbJlxx : mbjlxxs) {
			if (DictEnumUtil.XXKZBZ_Y.equals(mbJlxx.getXxkzbz())) {
				MbJlxxKzxx mbJlxxKzxx = mbJlxxKzxxMapper.selectByPrimaryKey(mbJlxx.getXxid());
				if (mbJlxxKzxx != null
						&& DictEnumUtil.DELETE_STATUS_WSC.equals(mbJlxxKzxx.getDeleteStatus())) {
					mbJlxx.setMbJlxxKzxx(mbJlxxKzxx);
				}
			}
		}
		return mbjlxxs;
	}

}
