//package kr.or.ddit.member.dao;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.List;
//
//import kr.or.ddit.db.ConnectionFactory;
//import kr.or.ddit.vo.MemberVO;
//
//public class MemberDAOImpl implements IMemberDAO {
//
//	@Override
//	public MemberVO selectMemberForAuth(String mem_id) {
//		MemberVO member = null;
//		StringBuffer sql = new StringBuffer();
//		sql.append(" SELECT MEM_ID, MEM_PASS, MEM_NAME, MEM_MAIL       ");
//		sql.append(" FROM MEMBER                                       ");
//		sql.append(" WHERE MEM_ID = ?   ");
//		try(
//			Connection conn = ConnectionFactory.getConnection();
////			Statement stmt = conn.createStatement();	
//			PreparedStatement pstmt = conn.prepareStatement(sql.toString());	
//		){
//			pstmt.setString(1, mem_id);
//			ResultSet rs = pstmt.executeQuery();
//			if(rs.next()) {
//				member = new MemberVO();
//				member.setMem_id(rs.getString("MEM_ID"));
//				member.setMem_pass(rs.getString("MEM_PASS"));
//				member.setMem_name(rs.getString("MEM_NAME"));
//				member.setMem_mail(rs.getString("MEM_MAIL"));
//			}		
//			return member;
//		}catch (SQLException e) {
//			throw new RuntimeException(e);
//		}
//	}
//
//	@Override
//	public MemberVO selectMemberDetail(String mem_id) {
//		MemberVO member = null;
//		StringBuffer sql = new StringBuffer();
//	sql.append("	SELECT                                                                     			");
//	sql.append("		MEM_ID, MEM_PASS, MEM_NAME, MEM_REGNO1,                                         ");
//	sql.append("	    MEM_REGNO2, TO_CHAR(MEM_BIR,'YYYY-MM-DD') MEM_BIR, MEM_ZIP, MEM_ADD1,           ");
//	sql.append("	    MEM_ADD2, MEM_HOMETEL, MEM_COMTEL,                                              ");
//	sql.append("	    MEM_HP, MEM_MAIL, MEM_JOB,                                                      ");
//	sql.append("	    MEM_LIKE,   MEM_MEMORIAL, TO_CHAR(MEM_MEMORIALDAY,'YYYY-MM-DD')MEM_MEMORIALDAY,    ");
//	sql.append("	    MEM_MILEAGE, MEM_DELETE                                                         ");
//	sql.append("FROM                                                                                    ");
//	sql.append("    MEMBER                                                                              ");
//	sql.append("    WHERE MEM_ID = ?                                                                    ");
//		try(
//			Connection conn = ConnectionFactory.getConnection();
////			Statement stmt = conn.createStatement();	
//			PreparedStatement pstmt = conn.prepareStatement(sql.toString());	
//		){
//			pstmt.setString(1, mem_id);
//			ResultSet rs = pstmt.executeQuery();
//			if(rs.next()) {
//				member = new MemberVO();
//				member.setMem_id(rs.getString("MEM_ID"));
//				member.setMem_id(rs.getString("MEM_ID"));
//				member.setMem_pass(rs.getString("MEM_PASS"));
//				member.setMem_name(rs.getString("MEM_NAME"));
//				member.setMem_regno1(rs.getString("MEM_REGNO1"));
//				member.setMem_regno2(rs.getString("MEM_REGNO2"));
//				member.setMem_bir(rs.getString("MEM_BIR"));
//				member.setMem_zip(rs.getString("MEM_ZIP"));
//				member.setMem_add1(rs.getString("MEM_ADD1"));
//				member.setMem_add2(rs.getString("MEM_ADD2"));
//				member.setMem_hometel(rs.getString("MEM_HOMETEL"));
//				member.setMem_comtel(rs.getString("MEM_COMTEL"));
//				member.setMem_hp(rs.getString("MEM_HP"));
//				member.setMem_mail(rs.getString("MEM_MAIL"));
//				member.setMem_job(rs.getString("MEM_JOB"));
//				member.setMem_like(rs.getString("MEM_LIKE"));
//				member.setMem_memorial(rs.getString("MEM_MEMORIAL"));
//				member.setMem_memorialday(rs.getString("MEM_MEMORIALDAY"));
//				member.setMem_mileage(rs.getInt("MEM_MILEAGE"));
//				member.setMem_delete(rs.getString("MEM_DELETE"));
//			}		
//			return member;
//		}catch (SQLException e) {
//			throw new RuntimeException(e);
//		}
//	}
//
//	@Override
//	public int insertMember(MemberVO member) {
//		int result = 0;
//		StringBuffer sql = new StringBuffer();
//		sql.append("insert into ");
//		sql.append("member(");
//		sql.append("mem_id,mem_pass,mem_name,");
//		sql.append("mem_regno1,mem_regno2,mem_bir,mem_zip,");
//		sql.append("mem_add1,mem_add2,mem_hometel,");
//		sql.append("mem_comtel,mem_hp,mem_mail,mem_job,");
//		sql.append("mem_like,mem_memorial,mem_memorialday,mem_mileage,mem_delete");
//		sql.append(") values("+member.getMem_id()+","+
//								member.getMem_pass()+","+
//								member.getMem_name()+","+
//								member.getMem_regno1()+","+
//								member.getMem_regno2()+","+
//								member.getMem_bir()+","+
//								member.getMem_zip()+","+
//								member.getMem_add1()+","+
//								member.getMem_add2()+","+
//								member.getMem_hometel()+","+
//								member.getMem_comtel()+","+
//								member.getMem_hp()+","+
//								member.getMem_mail()+","+
//								member.getMem_job()+","+
//								member.getMem_like()+","+
//								member.getMem_memorial()+","+
//								member.getMem_memorialday()+","+
//								member.getMem_mileage()+","+
//								member.getMem_delete()+")");
//		try(Connection conn = ConnectionFactory.getConnection();
//			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
//			){
//			result = pstmt.executeUpdate();
//		} catch (SQLException e) {
//			throw new RuntimeException(e);
//		}
//		return result;
//	}
//
//	@Override
//	public int updateMember(MemberVO member) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	@Override
//	public int deleteMember(String mem_id) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	@Override
//	public List<MemberVO> selectMemberList() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//}
//
//
//
//
//
//
//
//
