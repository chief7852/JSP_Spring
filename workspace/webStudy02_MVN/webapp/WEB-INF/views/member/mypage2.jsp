<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="/includee/preScript.jsp"></jsp:include>
</head>
<body>
	<jsp:useBean id="member" class="kr.or.ddit.vo.MemberVO" scope="request"></jsp:useBean>
	<h4><%=member.getMem_name()%>님의 마이페이지
	</h4>
	
	<table>
		<tr>
			<th>회원아이디</th>
			<td id="mem_id"><%=member.getMem_id()%></td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td><%=member.getMem_pass()%></td>
		</tr>
		<tr>
			<th>이름</th>
			<td><%=member.getMem_name()%></td>
		</tr>
		<tr>
			<th>주민등록번호</th>
			<td><%=member.getMem_regno1()%></td>
		</tr>
		<tr>
			<th>주민등록번호뒷자리</th>
			<td><%=member.getMem_regno2()%></td>
		</tr>
		<tr>
			<th>생년월일</th>
			<td><%=member.getMem_bir()%></td>
		</tr>
		<tr>
			<th>집</th>
			<td><%=member.getMem_zip()%></td>
		</tr>
		<tr>
			<th>주소1</th>
			<td><%=member.getMem_add1()%></td>
		</tr>
		<tr>
			<th>주소2</th>
			<td><%=member.getMem_add2()%></td>
		</tr>
		<tr>
			<th>집전화번호</th>
			<td><%=member.getMem_hometel()%></td>
		</tr>
		<tr>
			<th>회사전화번호</th>
			<td><%=member.getMem_comtel()%></td>
		</tr>
		<tr>
			<th>휴대폰번호</th>
			<td><%=member.getMem_hp()%></td>
		</tr>
		<tr>
			<th>이메일</th>
			<td><%=member.getMem_mail()%></td>
		</tr>
		<tr>
			<th>직업</th>
			<td><%=member.getMem_job()%></td>
		</tr>
		<tr>
			<th>취미</th>
			<td><%=member.getMem_like()%></td>
		</tr>
		<tr>
			<th>결혼기념일</th>
			<td><%=member.getMem_memorial()%></td>
		</tr>
		<tr>
			<th>결혼일</th>
			<td><%=member.getMem_memorialday()%></td>
		</tr>
		<tr>
			<th>마일리지</th>
			<td><%=member.getMem_mileage()%></td>
		</tr>
		<tr>
			<th>퇴사일</th>
			<td><%=member.getMem_delete()%></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="button" value="수정" class="controlBtn" id="updateBtn" />
				<button type="button" class="controlBtn" id="deleteBtn">탈퇴</button>
			</td>
		</tr>
	</table>
	
	<script type="text/javascript">
		
		$(".controlBtn").on("click", function(){
			let btnId = $(this).prop("id");
			let memId = "<%=member.getMem_id()%>";
			if(btnId == "updateBtn"){
				location.href="<%=request.getContextPath()%>/member/memberUpdate.do"
			}else if(btnId == "deleteBtn"){
				var pass = prompt('암호를 입력하십시오','암호를 입력하세요');
				var pasOri = "<%=member.getMem_pass()%>";
				if(pass != pasOri){
					return
				}
				$.ajax({
					url : "/memberDelete.do",
					method : "POST",
					data : {
						id : memId,
						pass : pass
					},
					dataType : "json",
					success : function(resp) {
						alert(memberId+"님 탈퇴되었습니다.")
						location.href="<%=request.getContextPath()%>/index.jsp"
					},
					error : function(xhr, error, msg) {
						console.log(xhr);
						console.log(error);
						console.log(msg);
					}
				});
			}
			// /member/memberUpdate.do
		})
	</script>
</body>
</html> --%>