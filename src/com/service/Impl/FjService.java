/**
 * 
 */
package com.service.Impl;

import java.io.File;
import java.util.HashMap;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.mapper.FjxxMapper;
import com.model.Fjxx;
import com.service.IFjService;
import com.util.DateUtil;
import com.util.FileUtil;
import com.util.UUIDUtil;
import com.util.config.ConfigInfo;
import com.util.dict.DictEnumUtil;

/**
 * @author Chanin
 *
 */
public class FjService implements IFjService{
	
	@Resource
	private ConfigInfo configInfo;
	@Resource
	private FjxxMapper fjXxMapper;

	/* (non-Javadoc)
	 * @see com.service.IFjService#saveFj(org.springframework.web.multipart.MultipartFile)
	 */
	@Override
	public String saveFj(MultipartFile multipartFile)  throws Exception{
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * 保存图片附件
	 */
	@Override
	public String saveTpFj(String yhId,MultipartFile multipartFile)  throws Exception{
		String 	fjlj = configInfo.getPicPath() + FileUtil.getDatePath(); //文件路径
		
		String filePath = FileUtil.doUpload(fjlj, UUIDUtil.getUUID(), multipartFile);
		if(StringUtils.isNotEmpty(filePath)){
			String path = new File(configInfo.getPicPath()).getPath();
			filePath = filePath.replace(path, "");
		}
		
		Fjxx fjXx = new Fjxx();
		fjXx.setFjid(UUIDUtil.getUUID());
		fjXx.setFjdz(filePath);
		fjXx.setFjlx(DictEnumUtil.TMLX_FJ_TP);
		fjXx.setFjmc(multipartFile.getOriginalFilename());
		fjXx.setFjms(multipartFile.getOriginalFilename());
		String time = DateUtil.getDate(DateUtil.yyyy_MM_dd_HH_mm_ss);
		fjXx.setEnableStatus(DictEnumUtil.ENABLE_STATUS_YQY);
		fjXx.setDeleteStatus(DictEnumUtil.DELETE_STATUS_WSC);
		fjXx.setCreateId(yhId);
		fjXx.setCreateTime(time);
		fjXx.setUpdateId(yhId);
		fjXx.setUpdateTime(time);
		fjXxMapper.insertSelective(fjXx);
		return fjXx.getFjid();
	}

	/* (non-Javadoc)
	 * 保存音频附件
	 */
	@Override
	public String saveLyFj(String yhId,MultipartFile multipartFile) throws Exception {
		String 	fjlj = configInfo.getAudioPath() + FileUtil.getDatePath(); //文件路径
		String filePath = FileUtil.doUpload(fjlj, UUIDUtil.getUUID(), multipartFile);
		if(StringUtils.isNotEmpty(filePath)){
			String path = new File(configInfo.getAudioPath()).getPath();
			filePath = filePath.replace(path, "");
		}
		Fjxx fjXx = new Fjxx();
		fjXx.setFjid(UUIDUtil.getUUID());
		fjXx.setFjdz(filePath);
		fjXx.setFjlx(DictEnumUtil.TMLX_FJ_LY);
		fjXx.setFjmc(multipartFile.getOriginalFilename());
		fjXx.setFjms(multipartFile.getOriginalFilename());
		String time = DateUtil.getDate(DateUtil.yyyy_MM_dd_HH_mm_ss);
		fjXx.setEnableStatus(DictEnumUtil.ENABLE_STATUS_YQY);
		fjXx.setDeleteStatus(DictEnumUtil.DELETE_STATUS_WSC);
		fjXx.setCreateId(yhId);
		fjXx.setCreateTime(time);
		fjXx.setUpdateId(yhId);
		fjXx.setUpdateTime(time);
		fjXxMapper.insertSelective(fjXx);
		return fjXx.getFjid();
	}

	/* (non-Javadoc)
	 * 保存视频附件
	 */
	@Override
	public String saveSpFj(String yhId,MultipartFile multipartFile) throws Exception {
		String 	fjlj = configInfo.getVideoPath() + FileUtil.getDatePath(); //文件路径
		String filePath = FileUtil.doUpload(fjlj, UUIDUtil.getUUID(), multipartFile);
		if(StringUtils.isNotEmpty(filePath)){
			String path = new File(configInfo.getVideoPath()).getPath();
			filePath = filePath.replace(path, "");
		}
		Fjxx fjXx = new Fjxx();
		fjXx.setFjid(UUIDUtil.getUUID());
		fjXx.setFjdz(filePath);
		fjXx.setFjlx(DictEnumUtil.TMLX_FJ_SP);
		fjXx.setFjmc(multipartFile.getOriginalFilename());
		fjXx.setFjms(multipartFile.getOriginalFilename());
		String time = DateUtil.getDate(DateUtil.yyyy_MM_dd_HH_mm_ss);
		fjXx.setEnableStatus(DictEnumUtil.ENABLE_STATUS_YQY);
		fjXx.setDeleteStatus(DictEnumUtil.DELETE_STATUS_WSC);
		fjXx.setCreateId(yhId);
		fjXx.setCreateTime(time);
		fjXx.setUpdateId(yhId);
		fjXx.setUpdateTime(time);
		fjXxMapper.insertSelective(fjXx);
		return fjXx.getFjid();
	}

	/**
	 * 保存文件附件
	 */
	@Override
	public String saveWjFj(String yhid, MultipartFile multipartFile) throws Exception {
		String 	fjlj = configInfo.getDocPath() + FileUtil.getDatePath(); //文件路径
		String filePath = FileUtil.doUpload(fjlj, UUIDUtil.getUUID(), multipartFile);
		if(StringUtils.isNotEmpty(filePath)){
			String path = new File(configInfo.getDocPath()).getPath();
			filePath = filePath.replace(path, "");
		}
		Fjxx fjXx = new Fjxx();
		fjXx.setFjid(UUIDUtil.getUUID());
		fjXx.setFjdz(filePath);
		fjXx.setFjlx(DictEnumUtil.TMLX_FJ_WJ);
		fjXx.setFjmc(multipartFile.getOriginalFilename());
		fjXx.setFjms(multipartFile.getOriginalFilename());
		String time = DateUtil.getDate(DateUtil.yyyy_MM_dd_HH_mm_ss);
		fjXx.setEnableStatus(DictEnumUtil.ENABLE_STATUS_YQY);
		fjXx.setDeleteStatus(DictEnumUtil.DELETE_STATUS_WSC);
		fjXx.setCreateId(yhid);
		fjXx.setCreateTime(time);
		fjXx.setUpdateId(yhid);
		fjXx.setUpdateTime(time);
		fjXxMapper.insertSelective(fjXx);
		return fjXx.getFjid();
	}

	/**
	 * 获取任务记录附件
	 */
	@Override
	public String selectRwfj(HashMap<String, Object> hashMap) throws Exception {
		// TODO Auto-generated method stub
		return fjXxMapper.selectRwfj(hashMap);
	}

}
