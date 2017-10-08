package com.soecode.lyf.web;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.mysql.fabric.Response;
import com.soecode.lyf.entity.Book;
import com.soecode.lyf.entity.Cuser;
import com.soecode.lyf.service.CuserService;

@Controller
public class CuserController {

	@Autowired
	private CuserService cuserService;
	
	@RequestMapping(value = "/to_login", method = RequestMethod.POST)
	private String login( Model mav,@RequestParam("uphone") String uphone,@RequestParam("upassword") String upassword) {
		Cuser cuser = cuserService.login(uphone,upassword);
		if(cuser != null) {
			
			mav.addAttribute("cuser",cuser);
			//��װΪjson���ݡ�
			return "loginSuccess";
			
		}
		
		return "login";
	}
	
	@RequestMapping(value = "/tz", method = RequestMethod.GET)
	private String tz() {
		System.out.println("sasdfasf");
		return "login";
	} 
}
