/**
 * 
 */
package com.service.Impl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.mapper.FjxxMapper;
import com.mapper.RwjlMapper;
import com.mapper.RwjlTmFjMapper;
import com.mapper.RwjlTmMapper;
import com.mapper.RwjlTmxxMapper;
import com.mapper.XxxxMapper;
import com.model.Fjxx;
import com.model.Rwjl;
import com.model.RwjlTm;
import com.model.RwjlTmFj;
import com.model.RwjlTmTjmx;
import com.model.RwjlTmxx;
import com.model.RwjlXxTjmx;
import com.model.Splc;
import com.model.Spxx;
import com.model.Strw;
import com.model.Xxxx;
import com.model.YhRw;
import com.service.IFjService;
import com.service.IRwjlService;
import com.service.IRwjlTmTjmxService;
import com.service.IRwjlXxTjmxService;
import com.service.ISplcService;
import com.service.ISpxxService;
import com.service.IStrwService;
import com.service.IYhRwService;
import com.util.DateUtil;
import com.util.JsonUtil;
import com.util.UUIDUtil;
import com.util.dict.DictEnumUtil;
import com.util.page.PageInfo;
import com.util.page.PageResult;
import com.util.page.PageUtil;

/**
 * @author Chanin
 *
 */
public class RwjlService implements IRwjlService {

	@Resource
	private RwjlMapper rwjlMapper;
	@Resource
	private IFjService fjService;
	@Resource
	private RwjlTmFjMapper rwjlTmFjMapper;
	@Resource
	private FjxxMapper fjXxMapper;
	@Resource
	private RwjlTmMapper rwjlTmMapper;
	@Resource
	private RwjlTmxxMapper rwjlTmxxMapper;
	@Resource
	private XxxxMapper xxxxMapper;
	@Resource
	private IStrwService strwService;
	@Resource
	private ISplcService splcService;
	@Resource
	private ISpxxService spxxService;

	@Resource
	private IYhRwService yhRwService;
	@Resource
	private IRwjlTmTjmxService rwjlTmTjmxService;
	@Resource
	private IRwjlXxTjmxService rwjlXxTjmxService;
	
	


	/*
	 * (non-Javadoc)
	 * 查询任务记录
	 * @see com.service.IRwjlService#selectRwjl(java.util.HashMap)
	 */
	@Override
	public List<Rwjl> selectRwjl(HashMap<String, Object> paramMap) {
		// TODO Auto-generated method stub
		return rwjlMapper.selectRwjl(paramMap);
	}

	/**
	 * 查询任务记录详情
	 */
	@Override
	public List<Rwjl> selectRwjlInfo(HashMap<String, Object> paramMap) throws Exception {
		List<Rwjl> rwjls = rwjlMapper.selectRwjl(paramMap);
		if (CollectionUtils.isNotEmpty(rwjls)) {
			for (Rwjl rwjl : rwjls) {
				HashMap<String, Object> p1 = new HashMap<>();
				p1.put("rwjlid", rwjl.getRwjlid());
				// p1.put("notfjtmfzid", "null");
				p1.put("deleteStatus", DictEnumUtil.DELETE_STATUS_WSC);
				List<RwjlTm> rwjlTms = rwjlTmMapper.selectRwjlTm(p1);
				full(rwjlTms);
				rwjl.setRwjlTmList(rwjlTms);
			}
		}

		return rwjls;
	}

	private void full(List<RwjlTm> rwjlTms) {
		if (CollectionUtils.isNotEmpty(rwjlTms)) {
			for (RwjlTm rwjlTm : rwjlTms) {
				if (DictEnumUtil.XXBZ_Y.equals(rwjlTm.getXxbz())) {
					HashMap<String, Object> p2 = new HashMap<>();
					p2.put("rwtmid", rwjlTm.getRwtmid());
					p2.put("deleteStatus", DictEnumUtil.DELETE_STATUS_WSC);
					List<RwjlTmxx> rwjlTmxxs = rwjlTmxxMapper.selectRwjlTmxx(p2);
					rwjlTm.setRwjlTmxxes(rwjlTmxxs);
				}
				if (DictEnumUtil.ATTACH_SYMBOL_Y.equals(rwjlTm.getFjbz())) {
					HashMap<String, Object> p3 = new HashMap<>();
					p3.put("rwtmid", rwjlTm.getRwtmid());
					p3.put("deleteStatus", DictEnumUtil.DELETE_STATUS_WSC);
					List<Fjxx> fjxxs = fjXxMapper.selectRwjlTmfj(p3);
					rwjlTm.setFjxxes(fjxxs);
				}

				// if(DictEnumUtil.SUBSET_SYMBOL_YYZJ.equals(rwjlTm.getSubsetSymbol())) {
				// HashMap<String, Object> p4 = new HashMap<>();
				// p4.put("rwjlid", rwjlTm.getRwjlid());
				// p4.put("fjtmfzid",rwjlTm.getTmfzid());
				// p4.put("deleteStatus", DictEnumUtil.DELETE_STATUS_WSC);
				// List<RwjlTm> rwjltms = rwjlTmMapper.selectRwjlTm(p4);
				// full(rwjltms);
				// rwjlTm.setRwjlTms(rwjltms);
				// }

			}
		}
	}

	/**
	 * 分页查询任务记录
	 */
	@Override
	public PageResult<Rwjl> selectRwjlPage(HashMap<String, Object> paramMap) throws Exception {

		Object ep = paramMap.get("ep"); // 每页数量
		Integer everyPage = ((ep == null || ep == "") ? Integer.valueOf(DictEnumUtil.DEFAULT_EVERYPAGE)
				: Integer.valueOf(String.valueOf(ep)));
		Object cn = paramMap.get("cn"); // 当前页码
		Integer currentNo = ((cn == null || cn == "") ? 1 : Integer.valueOf(String.valueOf(cn)));

		// 总记录数
		Integer size = rwjlMapper.searchRwjlOfSize(paramMap);
		PageInfo pageInfo = PageUtil.createPage(everyPage, currentNo, size); // 分页实体
		paramMap.put("page", pageInfo);
		List<Rwjl> rwjls = null;// 返回集合
		if (size != null && size > 0) {
			rwjls = rwjlMapper.searchRwjlOfList(paramMap);
		}

		// if(CollectionUtils.isNotEmpty(rwjls)) {
		// for(Rwjl rwjl:rwjls) {
		//
		// }
		// }

		return new PageResult<Rwjl>(pageInfo, rwjls);
	}

	/**
	 * 保存任务记录
	 */
	@Override
	public boolean saveRwjl(String yhid, Rwjl rwjl, Map<String, List<MultipartFile>> files) throws Exception {

		HashMap<String, Object> paramMap = new HashMap<>();
		paramMap.put("yhid", yhid);
		paramMap.put("rwid", rwjl.getRwid());
		paramMap.put("deleteStatus", DictEnumUtil.DELETE_STATUS_WSC);
		List<Strw> strws = strwService.selectYhStrw(paramMap);
		if (CollectionUtils.isEmpty(strws)) {
			throw new Exception("任务不存在，无法保存记录！");
		}
		Strw strw = strws.get(0);
		//判断结束时间
		if(StringUtils.isNotEmpty(strw.getJssj())&&DateUtil.isOverTime(strw.getJssj())) {
			changeWczt(strw,yhid);
			throw new Exception("任务已停止，无法保存记录！");
		}
		//任务是否即将完成（与要求的记录数只相差1即为即将完成）
		boolean shouldChange = false;
		//判断最大记录数
		if(strw.getZdjls()!=null&&strw.getZdjls()>0) {
			HashMap<String, Object> countMap = new HashMap<>();
			countMap.put("rwid", strw.getRwid());
			countMap.put("deleteStatus", DictEnumUtil.DELETE_STATUS_WSC);;
			//countMap.put("shjg", DictEnumUtil.REVIEW_RESULT_YTG);
			long count = rwjlMapper.searchRwjlOfSize(countMap);
			if(count>=strw.getZdjls()) {
				changeWczt(strw,yhid);
				throw new Exception("记录数已达到最大，任务已停止！");
			}else if ((count+1) == strw.getZdjls()) {
				shouldChange = true;
			}
		}
		
		String jlzqlx = strw.getJlzqlx();
		//根据记录周期类型判断任务的完成情况
		if(!DictEnumUtil.JLZQ_NONE.equals(jlzqlx)) {
			if(strw.getJlzqZdz()!=null&&strw.getJlzqZdz()>0) {
				if(DictEnumUtil.JLZQ_HOUR.equals(jlzqlx)) {//每小时
					HashMap<String, Object> countMap = new HashMap<>();
					countMap.put("rwid", strw.getRwid());
					countMap.put("deleteStatus", DictEnumUtil.DELETE_STATUS_WSC);;
					//countMap.put("shjg", DictEnumUtil.REVIEW_RESULT_YTG);
					if(DictEnumUtil.RWLX_GRRW.equals(strw.getRwlx())) {
						countMap.put("createId", yhid);
					}
					countMap.put("startTime",DateUtil.getHourStartTime());
					long count = rwjlMapper.searchRwjlOfSize(countMap);
					if(count>=strw.getJlzqZdz()) {
						changeWczt(strw,yhid);
						throw new Exception("本小时记录数提交已达上限！");
					}else if ((count+1) == strw.getJlzqZdz()) {
						shouldChange = true;
					}
				}else if (DictEnumUtil.JLZQ_DAY.equals(jlzqlx)) {//每天
					HashMap<String, Object> countMap = new HashMap<>();
					countMap.put("rwid", strw.getRwid());
					countMap.put("deleteStatus", DictEnumUtil.DELETE_STATUS_WSC);;
					//countMap.put("shjg", DictEnumUtil.REVIEW_RESULT_YTG);
					if(DictEnumUtil.RWLX_GRRW.equals(strw.getRwlx())) {
						countMap.put("createId", yhid);
					}
					countMap.put("startTime",DateUtil.getDayStartTime());
					long count = rwjlMapper.searchRwjlOfSize(countMap);
					if(count>=strw.getJlzqZdz()) {
						changeWczt(strw,yhid);
						throw new Exception("本日记录数提交已达上限！");
					}else if ((count+1) == strw.getJlzqZdz()) {
						shouldChange = true;
					}
				}else if (DictEnumUtil.JLZQ_WEEK.equals(jlzqlx)) {//每周
					HashMap<String, Object> countMap = new HashMap<>();
					countMap.put("rwid", strw.getRwid());
					countMap.put("deleteStatus", DictEnumUtil.DELETE_STATUS_WSC);;
					//countMap.put("shjg", DictEnumUtil.REVIEW_RESULT_YTG);
					if(DictEnumUtil.RWLX_GRRW.equals(strw.getRwlx())) {
						countMap.put("createId", yhid);
					}
					countMap.put("startTime",DateUtil.getWeekStartTime());
					long count = rwjlMapper.searchRwjlOfSize(countMap);
					if(count>=strw.getJlzqZdz()) {
						changeWczt(strw,yhid);
						throw new Exception("本周记录数提交已达上限！");
					}else if ((count+1) == strw.getJlzqZdz()) {
						shouldChange = true;
					}
				}else if (DictEnumUtil.JLZQ_MONTH.equals(jlzqlx)) {//每月
					HashMap<String, Object> countMap = new HashMap<>();
					countMap.put("rwid", strw.getRwid());
					countMap.put("deleteStatus", DictEnumUtil.DELETE_STATUS_WSC);;
					//countMap.put("shjg", DictEnumUtil.REVIEW_RESULT_YTG);
					if(DictEnumUtil.RWLX_GRRW.equals(strw.getRwlx())) {
						countMap.put("createId", yhid);
					}
					countMap.put("startTime",DateUtil.getMonthStartTime());
					long count = rwjlMapper.searchRwjlOfSize(countMap);
					if(count>=strw.getJlzqZdz()) {
						changeWczt(strw,yhid);
						throw new Exception("本月记录数提交已达上限！");
					}else if ((count+1) == strw.getJlzqZdz()) {
						shouldChange = true;
					}
				}else if (DictEnumUtil.JLZQ_QUARTER.equals(jlzqlx)) {//每季度
					HashMap<String, Object> countMap = new HashMap<>();
					countMap.put("rwid", strw.getRwid());
					countMap.put("deleteStatus", DictEnumUtil.DELETE_STATUS_WSC);;
					//countMap.put("shjg", DictEnumUtil.REVIEW_RESULT_YTG);
					if(DictEnumUtil.RWLX_GRRW.equals(strw.getRwlx())) {
						countMap.put("createId", yhid);
					}
					countMap.put("startTime",DateUtil.getQuarterStartTime());
					long count = rwjlMapper.searchRwjlOfSize(countMap);
					if(count>=strw.getJlzqZdz()) {
						changeWczt(strw,yhid);
						throw new Exception("本季度记录数提交已达上限！");
					}else if ((count+1) == strw.getJlzqZdz()) {
						shouldChange = true;
					}
				}else if (DictEnumUtil.JLZQ_YEAR.equals(jlzqlx)) {//每年
					HashMap<String, Object> countMap = new HashMap<>();
					countMap.put("rwid", strw.getRwid());
					countMap.put("deleteStatus", DictEnumUtil.DELETE_STATUS_WSC);;
					//countMap.put("shjg", DictEnumUtil.REVIEW_RESULT_YTG);
					if(DictEnumUtil.RWLX_GRRW.equals(strw.getRwlx())) {
						countMap.put("createId", yhid);
					}
					countMap.put("startTime",DateUtil.getYearStartTime());
					long count = rwjlMapper.searchRwjlOfSize(countMap);
					if(count>=strw.getJlzqZdz()) {
						changeWczt(strw,yhid);
						throw new Exception("本年记录数提交已达上限！");
					}else if ((count+1) == strw.getJlzqZdz()) {
						shouldChange = true;
					}
				}
				
			}
		}
		

		
		
		//保存任务记录
		String rwjlid = UUIDUtil.getUUID();
		String date = DateUtil.getDate(DateUtil.yyyy_MM_dd_HH_mm_ss);
		rwjl.setCreateId(yhid);
		rwjl.setCreateTime(date);
		rwjl.setUpdateId(yhid);
		rwjl.setUpdateTime(date);
		rwjl.setDeleteStatus(DictEnumUtil.DELETE_STATUS_WSC);
		rwjl.setEnableStatus(DictEnumUtil.ENABLE_STATUS_YQY);
		rwjl.setRwjlid(rwjlid);
		if (DictEnumUtil.REVIEW_SYMBOL_TRUE.equals(strw.getShbz())) {//任务是否需要审核
			rwjl.setShbz(DictEnumUtil.REVIEW_SYMBOL_TRUE);
			rwjl.setShzt(DictEnumUtil.REVIEW_STATUS_WSH);
			changeShzt(strw,yhid);//更新审核标志
		} else {
			rwjl.setShbz(DictEnumUtil.REVIEW_SYMBOL_FALSE);
			rwjl.setShzt(DictEnumUtil.REVIEW_STATUS_YSH);
			rwjl.setShjg(DictEnumUtil.REVIEW_RESULT_YTG);
		}
		rwjlMapper.insertSelective(rwjl);
		if(shouldChange) {
			changeWczt(strw, yhid);//更新已完成标志
			insertXxxx(strw, yhid);
		}
		//保存记录条目
		List<RwjlTm> rwjlTmList = rwjl.getRwjlTmList();
		for (RwjlTm rwjlTm : rwjlTmList) {
			String rwtmid = UUIDUtil.getUUID();
			rwjlTm.setCreateId(yhid);
			rwjlTm.setCreateTime(date);
			rwjlTm.setUpdateId(yhid);
			rwjlTm.setUpdateTime(date);
			rwjlTm.setDeleteStatus(DictEnumUtil.DELETE_STATUS_WSC);
			rwjlTm.setEnableStatus(DictEnumUtil.ENABLE_STATUS_YQY);
			rwjlTm.setRwjlid(rwjlid);
			rwjlTm.setRwtmid(rwtmid);
			rwjlTmMapper.insertSelective(rwjlTm);
			saveRwjlTmTjmx(rwjlTm,strw);
			//保存条目选项
			if (DictEnumUtil.XXBZ_Y.equals(rwjlTm.getXxbz())) {
				List<RwjlTmxx> rwjlTmxxes = rwjlTm.getRwjlTmxxes();
				for (RwjlTmxx rwjlTmxx : rwjlTmxxes) {
					rwjlTmxx.setCreateId(yhid);
					rwjlTmxx.setCreateTime(date);
					rwjlTmxx.setUpdateId(yhid);
					rwjlTmxx.setUpdateTime(date);
					rwjlTmxx.setDeleteStatus(DictEnumUtil.DELETE_STATUS_WSC);
					rwjlTmxx.setEnableStatus(DictEnumUtil.ENABLE_STATUS_YQY);
					rwjlTmxx.setRwtmid(rwtmid);
					rwjlTmxx.setRwxxid(UUIDUtil.getUUID());
					rwjlTmxxMapper.insertSelective(rwjlTmxx);
					saveRwjlXxTjmx(rwjlTm, rwjlTmxx,strw);
				}
			}

			//保存附件
			if (DictEnumUtil.ATTACH_SYMBOL_Y.equals(rwjlTm.getFjbz())) {
				if (DictEnumUtil.TMLX_FJ_TP.equals(rwjlTm.getTmlx())) {//图片
					List<MultipartFile> multipartFiles = files.get(rwjlTm.getTmid());
					if (CollectionUtils.isNotEmpty(multipartFiles)) {
						for (MultipartFile multipartFile : multipartFiles) {
							String fjId = fjService.saveTpFj(yhid, multipartFile);
							saveRwjlFj(yhid, date, rwtmid, fjId);
						}
					}

				} else if (DictEnumUtil.TMLX_FJ_SP.equals(rwjlTm.getTmlx())) {//视频
					List<MultipartFile> multipartFiles = files.get(rwjlTm.getTmid());
					if (CollectionUtils.isNotEmpty(multipartFiles)) {
						for (MultipartFile multipartFile : multipartFiles) {
							String fjId = fjService.saveSpFj(yhid, multipartFile);
							saveRwjlFj(yhid, date, rwtmid, fjId);
						}
					}

				} else if (DictEnumUtil.TMLX_FJ_LY.equals(rwjlTm.getTmlx())) {//录音
					List<MultipartFile> multipartFiles = files.get(rwjlTm.getTmid());
					if (CollectionUtils.isNotEmpty(multipartFiles)) {
						for (MultipartFile multipartFile : multipartFiles) {
							String fjId = fjService.saveLyFj(yhid, multipartFile);
							saveRwjlFj(yhid, date, rwtmid, fjId);
						}
					}

				} else if (DictEnumUtil.TMLX_FJ_WJ.equals(rwjlTm.getTmlx())) {//文件
					List<MultipartFile> multipartFiles = files.get(rwjlTm.getTmid());
					if (CollectionUtils.isNotEmpty(multipartFiles)) {
						for (MultipartFile multipartFile : multipartFiles) {
							String fjId = fjService.saveWjFj(yhid, multipartFile);
							saveRwjlFj(yhid, date, rwtmid, fjId);
						}
					}

				}
			}

		}

		//新增审批信息
		saveSpxx(rwjl,strw);
		return true;
	}

	//更新审核状态
	private void changeShzt(Strw strw, String yhid) throws Exception{
		HashMap<String, Object> updateMap = new HashMap<>();
		updateMap.put("rwid", strw.getRwid());
		updateMap.put("newshzt",DictEnumUtil.REVIEW_STATUS_WSH);
		if(DictEnumUtil.RWLX_GRRW.equals(strw.getRwlx())) {
			updateMap.put("yhid",yhid);
		}
		yhRwService.updateYhRw(updateMap);
		
	}

	//更新完成状态
	private void changeWczt(Strw strw,String yhid) throws Exception {
		HashMap<String, Object> updateMap = new HashMap<>();
		updateMap.put("rwid", strw.getRwid());
		updateMap.put("newwczt",DictEnumUtil.WCZT_YWC);
		if(DictEnumUtil.RWLX_GRRW.equals(strw.getRwlx())) {
			updateMap.put("yhid",yhid);
		}
		yhRwService.updateYhRw(updateMap);
	}

	private void insertXxxx(Strw strw, String yhid) throws Exception {
		if(DictEnumUtil.RWLX_GRRW.equals(strw.getRwlx())) {
			Xxxx xxxx = new Xxxx.Builder()
					.xxid(UUIDUtil.getUUID())
					.xxbt(strw.getRwmc())
					.xxnr("您的任务 "+strw.getRwmc()+" 当前周期内已完成！")
					.xxlx(DictEnumUtil.XXLX_RWXX)
					.stid(strw.getStid())
					.rwid(strw.getRwid())
					.qzid(strw.getQzid())
					.ydzt(DictEnumUtil.YDZT_WWD)
					.fssj(DateUtil.getNowDate())
					.fsfid(strw.getRwid())
					.jsfid(yhid)
					.enableStatus(DictEnumUtil.ENABLE_STATUS_YQY)
					.deleteStatus(DictEnumUtil.DELETE_STATUS_WSC)
					.createId(strw.getRwid())
					.createTime(DateUtil.getNowDate())
					.updateId(strw.getRwid())
					.updateTime(DateUtil.getNowDate())
					.build();
			xxxxMapper.insertSelective(xxxx);
		}else {
			HashMap<String, Object> hashMap = new HashMap<>();
			hashMap.put("rwid", strw.getRwid());
			hashMap.put("deleteSatus", DictEnumUtil.DELETE_STATUS_WSC);
			List<String> yhids = yhRwService.selectYhidByRwid(hashMap);
			if(CollectionUtils.isNotEmpty(yhids)) {
				for (String yh : yhids) {
					Xxxx xxxx = new Xxxx.Builder()
							.xxid(UUIDUtil.getUUID())
							.xxbt(strw.getRwmc())
							.xxnr("您的任务 "+strw.getRwmc()+" 当前周期内已完成！")
							.xxlx(DictEnumUtil.XXLX_RWXX)
							.stid(strw.getStid())
							.rwid(strw.getRwid())
							.qzid(strw.getQzid())
							.ydzt(DictEnumUtil.YDZT_WWD)
							.fssj(DateUtil.getNowDate())
							.fsfid(strw.getRwid())
							.jsfid(yh)
							.enableStatus(DictEnumUtil.ENABLE_STATUS_YQY)
							.deleteStatus(DictEnumUtil.DELETE_STATUS_WSC)
							.createId(strw.getRwid())
							.createTime(DateUtil.getNowDate())
							.updateId(strw.getRwid())
							.updateTime(DateUtil.getNowDate())
							.build();
					xxxxMapper.insertSelective(xxxx);
				}
			}
		}
	}

	
	/**
	 * 先判断任务是否需要审批，然后获取审批规则，插入审批信息
	 * @param rwjl
	 * @param strw
	 * @throws Exception
	 */
	private void saveSpxx(Rwjl rwjl,Strw strw) throws Exception {
		if (DictEnumUtil.REVIEW_SYMBOL_TRUE.equals(rwjl.getShbz())) {
			HashMap<String, Object> spclMap = new HashMap<>();
			spclMap.put("rwid", rwjl.getRwid());
			spclMap.put("deleteStatus", DictEnumUtil.DELETE_STATUS_WSC);
			spclMap.put("sjlcIdNull", "null");
			List<Splc> splcs = splcService.selectSplc(spclMap);
			if (CollectionUtils.isNotEmpty(splcs)) {
				Splc splc = splcs.get(0);
				String date = DateUtil.getDate(DateUtil.yyyy_MM_dd_HH_mm_ss);
				Spxx spxx = new Spxx.Builder().createId(rwjl.getCreateId()).createTime(date)
						.updateId(rwjl.getCreateId()).updateTime(date).deleteStatus(DictEnumUtil.DELETE_STATUS_WSC)
						.enableStatus(DictEnumUtil.ENABLE_STATUS_YQY).sclcId(splc.getSjlcId()).lccj(splc.getLccj())
						.lcid(splc.getLcid()).rwjlId(rwjl.getRwjlid()).sclcId(splc.getSjlcId()).xjlcId(splc.getXjlcId())
						.shsx(0).spxxId(UUIDUtil.getUUID()).spzt(DictEnumUtil.REVIEW_STATUS_WSH)
						.build();
				spxxService.insert(spxx);
				if (DictEnumUtil.RWLX_GRRW.equals(strw.getRwlx())) {
					HashMap<String, Object> updateMap = new HashMap<>();
					updateMap.put("yhid", rwjl.getCreateId());
					updateMap.put("rwid", rwjl.getRwid());
					updateMap.put("newshzt", DictEnumUtil.REVIEW_STATUS_WSH);
					yhRwService.updateYhRwShztByRwid(updateMap);
				} else {
					HashMap<String, Object> updateMap = new HashMap<>();
					updateMap.put("rwid", rwjl.getRwid());
					updateMap.put("newshzt", DictEnumUtil.REVIEW_STATUS_WSH);
					yhRwService.updateYhRwShztByRwid(updateMap);
				}
			}
		}
	}

	/**
	 * 保存任务记录选项统计明细
	 * 先查数据库，若有+1，若无新增一条记录
	 * @param rwjlTm
	 * @param rwjlTmxx
	 * @param strw
	 * @throws Exception
	 */
	private void saveRwjlXxTjmx(RwjlTm rwjlTm, RwjlTmxx rwjlTmxx, Strw strw) throws Exception {
		
		RwjlXxTjmx rwjlXxTjmx = null;
		HashMap<String, Object> hashMap = new HashMap<>();
		hashMap.put("rwid", strw.getRwid());
		hashMap.put("tmid",rwjlTm.getTmid());
		hashMap.put("xxid",rwjlTmxx.getXxid());
		hashMap.put("deleteStatus", DictEnumUtil.DELETE_STATUS_WSC);
		List<RwjlXxTjmx> rwjlXxTjmxs = rwjlXxTjmxService.selectRwjlXxTjmx(hashMap);
		if(CollectionUtils.isNotEmpty(rwjlXxTjmxs)) {
			rwjlXxTjmx = rwjlXxTjmxs.get(0);
			rwjlXxTjmx.setXzcs((rwjlXxTjmx.getXzcs()==null?0:rwjlXxTjmx.getXzcs())+1);
			rwjlXxTjmx.setUpdateTime(DateUtil.getNowDate());
			rwjlXxTjmxService.updateRwjlXxTjmx(rwjlXxTjmx);
		}else {
			String now = DateUtil.getNowDate();
			String yhid = rwjlTm.getCreateId();
			
			rwjlXxTjmx = new RwjlXxTjmx.Builder()
					.mxid(UUIDUtil.getUUID())
					.qzid(strw.getQzid())
					.rwid(strw.getRwid())
					.stid(strw.getStid())
					.mbid(strw.getMbid())
					.tmid(rwjlTm.getTmid())
					.xxid(rwjlTmxx.getXxid())
					.xzcs(1)
					.enableStatus(DictEnumUtil.ENABLE_STATUS_YQY)
					.deleteStatus(DictEnumUtil.DELETE_STATUS_WSC)
					.createTime(now)
					.createId(yhid)
					.updateId(yhid)
					.updateTime(now)
					.build();
			rwjlXxTjmxService.insertRwjlXxTjmx(rwjlXxTjmx);
		}
	}

	/**
	 * 保存任务记录条目统计明细
	 * 
	 * @param rwjlTm
	 * @param strw
	 * @throws Exception
	 */
	private void saveRwjlTmTjmx(RwjlTm rwjlTm, Strw strw) throws Exception {
	
		RwjlTmTjmx rwjlTmTjmx = null;
		HashMap<String, Object> hashMap = new HashMap<>();
		hashMap.put("rwid", strw.getRwid());
		hashMap.put("tmid",rwjlTm.getTmid());
		hashMap.put("deleteStatus", DictEnumUtil.DELETE_STATUS_WSC);
		List<RwjlTmTjmx> rwjlTmTjmxs = rwjlTmTjmxService.selectRwjlTmTjmx(hashMap);
		if(CollectionUtils.isNotEmpty(rwjlTmTjmxs)) {
			rwjlTmTjmx = rwjlTmTjmxs.get(0);
			rwjlTmTjmx.setDtcs((rwjlTmTjmx.getDtcs()==null?0:rwjlTmTjmx.getDtcs())+1);
			rwjlTmTjmx.setUpdateTime(DateUtil.getNowDate());
			rwjlTmTjmxService.updateRwjlTmTjmx(rwjlTmTjmx);
		}else {
			String now = DateUtil.getNowDate();
			String yhid = rwjlTm.getCreateId();
			
			rwjlTmTjmx = new RwjlTmTjmx.Builder()
					.mxid(UUIDUtil.getUUID())
					.qzid(strw.getQzid())
					.rwid(strw.getRwid())
					.stid(strw.getStid())
					.mbid(strw.getMbid())
					.tmid(rwjlTm.getTmid())
					.dtcs(1)
					.enableStatus(DictEnumUtil.ENABLE_STATUS_YQY)
					.deleteStatus(DictEnumUtil.DELETE_STATUS_WSC)
					.createTime(now)
					.createId(yhid)
					.updateId(yhid)
					.updateTime(now)
					.build();
			rwjlTmTjmxService.insertRwjlTmTjmx(rwjlTmTjmx);
		}
	}

	/**
	 * 保存任务记录附件
	 * @param yhid
	 * @param date
	 * @param rwtmid
	 * @param fjId
	 */
	private void saveRwjlFj(String yhid, String date, String rwtmid, String fjId) {
		RwjlTmFj stTmFj = new RwjlTmFj();
		stTmFj.setRwtmid(rwtmid);
		stTmFj.setFjid(fjId);
		stTmFj.setGlid(UUIDUtil.getUUID());
		stTmFj.setEnableStatus(DictEnumUtil.ENABLE_STATUS_YQY);
		stTmFj.setDeleteStatus(DictEnumUtil.DELETE_STATUS_WSC);
		stTmFj.setCreateId(yhid);
		stTmFj.setCreateTime(date);
		stTmFj.setUpdateId(yhid);
		stTmFj.setUpdateTime(date);
		rwjlTmFjMapper.insertSelective(stTmFj);
	}
}
