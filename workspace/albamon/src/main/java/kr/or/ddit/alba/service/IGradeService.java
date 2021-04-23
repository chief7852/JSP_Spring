package kr.or.ddit.alba.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.or.ddit.vo.GradeVO;
@Service
public interface IGradeService {
	
	public List<GradeVO> selectgrade();
}
