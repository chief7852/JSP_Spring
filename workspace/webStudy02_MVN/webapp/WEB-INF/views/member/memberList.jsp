<%@page import="kr.or.ddit.vo.MemberVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">

</script>
</head>
<body>
<h4>회원 목록 조회</h4>
<table border="1">
	<thead>
		<tr>
			<th>회원아이디</th>
			<th>회원명</th>
			<th>이메일</th>
			<th>휴대폰</th>
			<th>마일리지</th>
			<th>탈퇴여부</th>
		</tr>
	</thead>
	<tbody>
	<% 
	List<MemberVO> list = (List)request.getAttribute("memList");
	if(list.size()>0){
		for(MemberVO mem : list){
	%>
	
		<tr>
			<td><%=mem.getMem_id() %></td>
			<td><%=mem.getMem_name() %></td>
			<td><%=mem.getMem_mail() %></td>
			<td><%=mem.getMem_hp() %></td>
			<td><%=mem.getMem_mileage() %></td>
			<td>
			<%="Y".equals(mem.getMem_delete())? "탈퇴":"" %>
			</td>
		</tr>
	
	 <%
		}
	}else{
		%>
		<tr>
			<td colspan="5">
			등록된 회원이 없음
			</td>
		</tr>
		<%
	}
	 %>
	 </tbody>
</table>
</body>
</html>