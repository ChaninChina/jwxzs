/**
 * 
 */
package com.controller;

import javax.annotation.Resource;

import com.service.Impl.YhxxService;
import com.util.attach.AttachInfo;
import com.util.config.ConfigInfo;
import com.util.dict.DictFillUtil;
import com.util.dict.DictListUtil;
import com.util.jg.OrgnListUtil;
import com.util.qy.AreaListUtil;


/**
 * @author Chanin
 *
 */
public class BaseController {
	
	
	@Resource
	protected ConfigInfo configInfo;
	@Resource
	protected DictListUtil dictListUtil;
	@Resource
	protected DictFillUtil dictFillUtil;
	@Resource
	protected AreaListUtil areaListUtil;
	@Resource
	protected OrgnListUtil orgnListUtil;
	@Resource
	protected YhxxService yhXxService;

}
