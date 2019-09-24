package com.anxin.shirotest.controller;

import com.anxin.shirotest.config.ShiroCasConfiguration;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.anxin.shirotest.pojo.ResponseBo;
import com.anxin.shirotest.pojo.User;
import com.anxin.shirotest.util.MD5Utils;

@Controller
public class LoginController {

	@PostMapping("/login")
	@ResponseBody
	public ResponseBo login(String username, String password) {
		password = MD5Utils.encrypt(username, password);
		UsernamePasswordToken token = new UsernamePasswordToken(username, password);
		Subject subject = SecurityUtils.getSubject();
		try {
			subject.login(token);
			return ResponseBo.ok();
		} catch (UnknownAccountException e) {
			return ResponseBo.error(e.getMessage());
		} catch (IncorrectCredentialsException e) {
			return ResponseBo.error(e.getMessage());
		} catch (LockedAccountException e) {
			return ResponseBo.error(e.getMessage());
		} catch (AuthenticationException e) {
			return ResponseBo.error("认证失败！");
		}
	}

	@RequestMapping(value="/login",method= RequestMethod.GET)
	public String loginForm(Model model){
		model.addAttribute("user", new User());
		return "redirect:/index";
	}

	@RequestMapping(value="/logout",method= RequestMethod.GET)
	public String logout(Model model){
		Subject subject = SecurityUtils.getSubject();
		subject.logout();
		model.addAttribute("msg","安全退出！");
		return "redirect:" + ShiroCasConfiguration.logoutUrl;
	}

	@RequestMapping("/")
	public String redirectIndex() {
		return "redirect:/index";
	}

	@RequestMapping("/index")
	public String index(Model model) {
		User user = (User) SecurityUtils.getSubject().getPrincipal();
		model.addAttribute("user", user);
		return "index";
	}
}
