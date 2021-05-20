<%@page import="kr.or.ddit.Constants"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<!-- Brand Logo -->
 <a href="${cPath }/" class="brand-link">
   <img src="${cPath }/theme/AdminLTE-3.1.0/dist/img/AdminLTELogo.png" alt="AdminLTE Logo" class="brand-image img-circle elevation-3" style="opacity: .8">
   <span class="brand-text font-weight-light">AdminLTE 3</span>
 </a>

 <!-- Sidebar -->
 <div class="sidebar">
 <!-- 인증을 if 대신해서 함 -->
 <security:authorize access="isAuthenticated()">
 <!-- 어센티케이션 접근해서 context안(authentication에 보관되고있는)에 있는 principal.username값을 들고와 authUsername라는
 		이름으로 지정해준다-->
 	<security:authentication property="principal.username" var="authUsername"/>
<%--   <c:if test="${not empty sessionScope.authMember }"> --%>
   <!-- Sidebar user (optional) -->
   <div class="user-panel mt-3 pb-3 mb-3 d-flex">
     <div class="image">
       <c:choose>
       	<c:when test="${not empty authMember.mem_img }">
	       <img src="data:image/*;base64,${authMember.base64Image }" 
	       		class="img-circle elevation-2" alt="User Image">
       	</c:when>
       </c:choose>
     </div>
     <div class="info">
	   <form name="logoutForm" method="post" action="<%=request.getContextPath() %>/login/logout.do"></form>
       <a href="${cPath }/mypage.do" class="d-block">${authMember.mem_name }</a>
	   <a href="#" onclick="clickHandler(event);" class="d-block">${authUsername }로그아웃</a>
   	   <script type="text/javascript">
			function clickHandler(event){
				event.preventDefault();
				document.logoutForm.submit();
				return false;
			}
	   </script>
     </div>
   </div>
<%--   </c:if>  --%>
  </security:authorize>
  
  
  <!-- 인증됐는지 확인여부 -->
  <security:authorize access="isAnonymous()">
<%--    <c:if test="${empty sessionScope.authMember }"> --%>
	   <!-- Sidebar user (optional) -->
	   <div class="user-panel mt-3 pb-3 mb-3 d-flex">
		   <div class="info">
	       	<a href="${cPath }/member/memberInsert.do" class="d-block">회원가입</a>
	       	<a href="${cPath }/login/loginForm.jsp" class="d-block">로그인</a>
	       </div>
	   </div>
<%--    </c:if> --%>
   </security:authorize>

   <!-- SidebarSearch Form -->
   <div class="form-inline">
     <div class="input-group" data-widget="sidebar-search">
       <input class="form-control form-control-sidebar" type="search" placeholder="Search" aria-label="Search">
       <div class="input-group-append">
         <button class="btn btn-sidebar">
           <i class="fas fa-search fa-fw"></i>
         </button>
       </div>
     </div>
   </div>

   <!-- Sidebar Menu -->
   <nav class="mt-2">
     <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">
       <li class="nav-header">EXAMPLES</li>
       <li class="nav-item">
         <a href="${cPath }/member/memberList.do" class="nav-link">
           <i class="nav-icon far fa-user"></i>
           <p>
              	회원관리
             <span class="badge badge-info right">
             	${applicationScope[Constants.SESSIONCOUNTATTRNAME] }
             </span>
           </p>
         </a>
       </li>
       <li class="nav-item">
         <a href="${cPath }/prod/prodList.do" class="nav-link">
           <i class="nav-icon fas fa-cubes"></i>
           <p>
             	상품관리
           </p>
         </a>
       </li>
       <li class="nav-item">
         <a href="#" class="nav-link">
           <i class="nav-icon fas fa-building"></i>
           <p>
             	거래처관리
           </p>
         </a>
       </li>
       <li class="nav-item">
         <a href="${cPath }/board/boardList.do" class="nav-link">
           <i class="nav-icon fas fa-chalkboard"></i>
           <p>
             	자유게시판
           </p>
         </a>
       </li>
       <li class="nav-item">
         <a href="#" class="nav-link">
           <i class="nav-icon fas fa-people-carry"></i>
           <p>
             	알바관리
           </p>
         </a>
       </li>
     </ul>
   </nav>
   <!-- /.sidebar-menu -->
 </div>
 <!-- /.sidebar -->

 <div class="sidebar-custom">
   <a href="#" class="btn btn-link"><i class="fas fa-cogs"></i></a>
   <a href="#" class="btn btn-secondary hide-on-collapse pos-right">Help</a>
 </div>
 <!-- /.sidebar-custom -->