package kr.or.ddit.container.heierarchy.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.or.ddit.container.heierarchy.dao.HierachyDAO;
@Service
public class HierarchyService {
	private HierachyDAO dao;
	
	@Inject
	public void setDao(HierachyDAO dao) {
		this.dao = dao;
	}
}
