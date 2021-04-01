package kr.or.ddit.member.service;

import java.util.List;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.member.UserNotFoundException;
import kr.or.ddit.member.dao.IMemberDAO2;

import kr.or.ddit.member.dao.MemberDAOImpl2;
import kr.or.ddit.vo.MemberVO;

public class MemberServiceImpl2 implements IMemberService2 {
	private IMemberDAO2 dao = new MemberDAOImpl2();
	
	@Override
	public MemberVO retrieveMember(String mem_id) {
		
		MemberVO savedMember = dao.selectMemberDetail(mem_id);
		if(savedMember==null) {
			// custom exception 발생
			throw new UserNotFoundException("아이디에 해당하는 회원이 존재하지 않음.");
		}
		return savedMember;
	}

	@Override
	public ServiceResult createMember(MemberVO member) {
		ServiceResult result = null;
		if(dao.selectMemberDetail(member.getMem_id())==null) {
			int rowcnt = dao.insertMember(member);
			if(rowcnt>0) {
				result = ServiceResult.OK;
			}else {
				result = ServiceResult.FAIL;
			}
		}else {
			result = ServiceResult.PKDUPLICATED;
		}
		return result;
	}

	@Override
	public ServiceResult modifyMember(MemberVO member) {
		// INVALIDPASSWORD, OK, FAIL
		MemberVO savedMember = retrieveMember(member.getMem_id());
		String savePass = savedMember.getMem_pass();
		String inputPass = member.getMem_pass();
		ServiceResult result = null;
		if(savePass.equals(inputPass)) {
			int rwcnt = dao.updateMember(member);
			if(rwcnt>0) {
				result = ServiceResult.OK;
			}else {
				result = ServiceResult.FAIL;
			}
		}else {
			result = ServiceResult.INVALIDPASSWORD;
		}
		return result;
	}

	@Override
	public ServiceResult removeMember(MemberVO member) {
		// TODO Auto-generated method stub
		MemberVO savedMember = retrieveMember(member.getMem_id());
		String savePass = savedMember.getMem_pass();
		String inputPass = member.getMem_pass();
		ServiceResult result = null;
		if(savePass.equals(inputPass)) {
			int rwcnt = dao.deleteMember(member.getMem_id());
			if(rwcnt>0) {
				result = ServiceResult.OK;
			}else {
				result = ServiceResult.FAIL;
			}
		}else {
			result = ServiceResult.INVALIDPASSWORD;
		}
		return result;
	}

	@Override
	public List<MemberVO> retrieveMemberList() {
		// TODO Auto-generated method stub
		return null;
	}

}
















