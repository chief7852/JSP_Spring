<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.error{
		color:red;
	}
</style>
</head>
<body>
<h4>가입양식</h4>
<jsp:useBean id="member" class="kr.or.ddit.vo.MemberVO" scope="request"></jsp:useBean>
<jsp:useBean id="errors" class="java.util.LinkedHashMap" scope="request"></jsp:useBean>
<form method="POST">
	<table>
		<tr>
			<th>회원아이디</th>
			<td>
				<input type="text" name="mem_id" />
				<span class="error"><%=errors.get("mem_id") %></span>
			</td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td>
				<input type="text" name="mem_pass" />
				
			</td>
		</tr>
		<tr>
			<th>이름</th>
			<td>
				<input type="text" name="mem_name" />
				
			</td>
		</tr>
		<tr>
			<th>주민등록번호앞자리</th>
			<td>
				<input type="text" name="mem_regno1" />
				
			</td>
		</tr>
		<tr>
			<th>주민등록번호뒷자리</th>
			<td>
				<input type="text" name="mem_regno2" />
				
			</td>
		</tr>
		<tr>
			<th>생년월일</th>
			<td>
				<input type="text" name="mem_bir" />
				
			</td>
		</tr>
		<tr>
			<th>번지</th>
			<td>
				<input type="text" name="mem_zip" />
				
			</td>
		</tr>
		<tr>
			<th>주소1</th>
			<td>
				<input type="text" name="mem_add1" />
				
			</td>
		</tr>
		<tr>
			<th>주소2</th>
			<td>
				<input type="text" name="mem_add2" />
				
			</td>
		</tr>
		<tr>
			<th>집전화번호</th>
			<td>
				<input type="text" name="mem_hometel" />
				
			</td>
		</tr>
		<tr>
			<th>회사번호</th>
			<td>
				<input type="text" name="mem_comtel" />
				
			</td>
		</tr>
		<tr>
			<th>휴대폰번호</th>
			<td>
				<input type="text" name="mem_hp" />
				
			</td>
		</tr>
		<tr>
			<th>이메일</th>
			<td>
				<input type="text" name="mem_mail" />
				
			</td>
		</tr>
		<tr>
			<th>직업</th>
			<td>
				<input type="text" name="mem_job" />
				
			</td>
		</tr>
		<tr>
			<th>취미</th>
			<td>
				<input type="text" name="mem_like" />
				
			</td>
		</tr>
		<tr>
			<th>결혼기념일</th>
			<td>
				<input type="text" name="mem_memorial" />
				
			</td>
		</tr>
		<tr>
			<th>결혼일</th>
			<td>
				<input type="text" name="mem_memorialday" />
				
			</td>
		</tr>
		<tr>
			<th>마일리지</th>
			<td>
				<input type="text" name="mem_mileage" />
				
			</td>
		</tr>
		<tr>
			<th>퇴사일</th>
			<td>
				<input type="text" name="mem_id" />
				
			</td>	
		</tr>	
	</table>
	<input type="submit" value="저장">
</form>
</body>
</html> --%>