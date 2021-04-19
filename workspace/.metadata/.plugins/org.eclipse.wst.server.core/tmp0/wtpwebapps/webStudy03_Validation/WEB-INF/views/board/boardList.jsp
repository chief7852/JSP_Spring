<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="/includee/preScript.jsp" />
<style type="text/css">
	.preView{
		width: 100px;
		height: 100px;
	}
	.preView img{
		size : auto;
	}
</style>
<c:if test="${not empty message }">
	<script type="text/javascript">
		alert("${message}")
	</script>
	<c:remove var="message" scope="session" />
</c:if>

</head>
<body>
<h4>게시글 목록 조회</h4>
<table class="table table-bordered">
	<thead>
		<tr>
			<th>게시글종류</th>
			<th>글번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>조회수</th>
			<th>추천수</th>
		</tr>
	</thead>
	<tbody id="listBody">
	<c:choose>
		<c:when test="${not empty pagingVO.dataList }">
			<c:forEach items="${pagingVO.dataList }" var="board">
				<tr>
					<td>${board.bo_type eq 'NOTICE'?'공지':'일반' }</td>
					<td>${board.bo_no }</td>
					<td>
						<c:url value="/board/boardView.do" var="viewURL">
							<c:param name="what" value="${board.bo_no }" />
						</c:url>
						<c:choose>
							<c:when test="${board.bo_sec eq 'Y'}">
									<a class="secret" href="#">
								${board.bo_title }
								</a>
							</c:when>
							<c:otherwise>
								<a class="nonsecret" href="${viewURL }"  data-toggle="popover" title="Popover title" >
								${board.bo_title }
								</a>
							</c:otherwise>
						</c:choose>
						
					</td>
					<td>${board.bo_writer }</td>
					<td>${board.bo_date }</td>
					<td>${board.bo_hit }</td>
					<td>${board.bo_rec }</td>
				</tr>
			</c:forEach>
		</c:when>
		<c:otherwise>
			<tr>
				<td colspan="8">
					조건에 맞는 게시글이 없음.
				</td>
			</tr>
		</c:otherwise>
	</c:choose>
	</tbody>
	<tfoot>
		<tr>
			<td colspan="6">
					<form id="searchForm" hidden>
						<input type="text" name="searchType" value="${pagingVO.searchMap.searchType }"/>
						<input type="text" name="searchWord" value="${pagingVO.searchMap.searchWord }"/>
						<input type="text" name="minDate" value="${pagingVO.searchMap.minDate }"/>
						<input type="text" name="maxDate" value="${pagingVO.searchMap.maxDate }"/>
						<input type="text" name="page" />
					</form>
					<div id="searchUI" class="d-flex justify-content-center">
						<select name="searchType">
							<option value>전체</option>
							<option value="title">제목</option>
							<option value="writer">작성자</option>
							<option value="content">내용</option>
							<option value="type">게시판종류</option>
						</select>
						<input type="text" name="searchWord" value="${pagingVO.searchMap.searchWord }"/>
						<input type="date" name="minDate" value="${pagingVO.searchMap.minDate }" />
						<input type="date" name="maxDate" value="${pagingVO.searchMap.maxDate }"/>
						<input id="searchBtn" type="button" value="검색" />
						
						
						<button type="button"><a href="${cPath }/board/boardInsert.do">새글작성</a></button>
					</div>
				<div id="pagingArea" class="d-flex justify-content-center">
					
					
					
					${pagingVO.pagingHTML }
					
					
					
				</div>
			</td>
		</tr> 
	</tfoot>
</table>
<script type="text/javascript">
	let searchForm = $("#searchForm");
	let searchUI = $("#searchUI");
	searchUI.find("[name='searchType']").val("${pagingVO.searchMap.searchType }");
	$("#searchBtn").on("click", function(){
		let inputs = searchUI.find(":input[name]");
		$(inputs).each(function(idx, input){
			let name = $(this).attr("name");
			let sameInput = searchForm.find("[name='"+name+"']");
			$(sameInput).val($(this).val());
		});
		searchForm.submit();
	});
	
	$("#pagingArea").on("click", "a", function(event){
		event.preventDefault();
		let page = $(this).data("page");
		if(page){
			searchForm.find("[name='page']").val(page);
			searchForm.submit();
		}
		return false;
	});
	
	$(function () {
		$("#listBody a.nonsecret").hover(function(){
			
			$(this).popover({
				html:true
				, content:function(){
					let url = this.href;
					let retValue = null;
					$.ajax({
						url : url,
						dataType : "text",
						success : function(resp) {
							console.log(1);
							retValue = resp;
						},
						async : false,
						cache : true,
						error : function(xhr, error, msg) {
							console.log(xhr);
							console.log(error);
							console.log(msg);
						}
					});
					console.log(2);
					retValue = $("<div>").addClass("preView").html(retValue)
					return retValue;
				}
			}).popover("toggle")
		});
// 	  $('[data-toggle="popover"]').popover()
	});
	/* 	<a class="secret" href="${viewURL }">
								${board.bo_title }
								</a> */
	$(".secret").on('click',function(){
		let bono = 
		let cpass = prompt("비밀번호입력하십시오")
		$.ajax({
			url : "/board/authenticate.do",
			method : "",
			data : "",
			dataType : "",
			success : function(resp) {

			},
			error : function(xhr, error, msg) {
				console.log(xhr);
				console.log(error);
				console.log(msg);
			}
		});
	})
</script>

<jsp:include page="/includee/postScript.jsp" />
</body>
</html>










