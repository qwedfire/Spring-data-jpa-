package com.infotran.springboot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.infotran.springboot.service.MemberService;

@Controller
public class LabController {

	final static Logger log = LoggerFactory.getLogger(LabController.class);
	
	MemberService memberService;

	@Autowired
	public LabController(MemberService memberService) {
		this.memberService = memberService;
		
	}

	@RequestMapping(value="/members", method= {RequestMethod.GET, RequestMethod.DELETE})
	public String findAll(Model model) {
		model.addAttribute("memberList", memberService.findAll());
		return "showAllMembers";
	}
	
	@DeleteMapping("/members/{id}")
	public String deleteById(@PathVariable(value="id", required = false ) Integer id) {
		memberService.deleteById(id);
		return "forward:/members";
	}
	
	@GetMapping("/findAll")
	public String findId4() {
		memberService.findById(4);
		return "forward:/members";
	}
}
