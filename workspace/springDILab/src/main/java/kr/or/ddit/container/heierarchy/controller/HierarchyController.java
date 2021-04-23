package kr.or.ddit.container.heierarchy.controller;

import org.springframework.stereotype.Controller;

import kr.or.ddit.container.heierarchy.service.HierarchyService;
@Controller
public class HierarchyController {
	private HierarchyService service;
	
	public HierarchyController(HierarchyService service) {
		this.service = service;
	}
}
