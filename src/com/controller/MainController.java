/**
 * 
 */
package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * @author Chanin
 *
 */
@Controller
public class MainController extends BaseController{
	
	//主页
	@RequestMapping("/index")
	public String toMain() {
		return "main/index";
	}

}
