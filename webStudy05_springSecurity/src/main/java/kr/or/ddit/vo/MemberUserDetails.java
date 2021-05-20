package kr.or.ddit.vo;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Getter;

@Getter		//한번만들면 못바꾸게하겠다는뜻
public class MemberUserDetails extends User{


	private MemberVO adaptee;

//	adaptee용 생성자
	public MemberUserDetails(MemberVO adaptee) {
//		AuthorityUtils.createAuthorityList(adaptee.getMem_role())
		super(adaptee.getMem_id(), adaptee.getMem_pass(), AuthorityUtils.createAuthorityList(adaptee.getMem_role()));
	}

}
