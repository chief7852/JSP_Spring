<%@page import="kr.or.ddit.vo.BuyerVO"%>
<%@page import="kr.or.ddit.vo.ProdVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		ProdVO prod = (ProdVO) request.getAttribute("prod");
	
	%>
	<table border="1">
		<tr>
			<th>상품코드</th>
			<td>
				<%=prod.getBuyer().getBuyer_id() %>
			</td>

		</tr>
		<tr>
			<th>거래처 정보</th>
			<td>
			
				<table border="1">
					<thead>
						<tr>
							<th>거래처명</th>
							<th>담당자명</th>
							<th>연락처</th>
							<th>주소1</th>
						</tr>
					</thead>
					<tbody>
						<tr><%
							if (prod.getBuyer().getBuyer_id() != null) {
								
								%>
							<td><%=prod.getBuyer().getBuyer_id()%></td> 
							<td><%=prod.getBuyer().getBuyer_bankname()%></td>
							<td><%=prod.getBuyer().getBuyer_bankno()%></td>
							<td><%=prod.getBuyer().getBuyer_add1()%></td>
							<%
								} else {
							%>
							<td colspan="4">거래처 정보가 없습니다</td>
							<%
								}
							%>
						</tr>
					</tbody>
				</table>
			</td>
		</tr>
	</table>
</body>
</html>