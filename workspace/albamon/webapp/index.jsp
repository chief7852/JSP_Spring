<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="en">
<jsp:include page="/includee/preScript.jsp" />
  <head>
   
    <title>Cover Template · Bootstrap v4.6</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/4.6/examples/cover/">



    <style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        -ms-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }
    </style>

    
    <!-- Custom styles for this template -->
    <link href="cover.css" rel="stylesheet">
  </head>
  <body class="text-center">
    

  <header class="masthead mb-auto">
    <div class="inner">
      <h3 class="masthead-brand">Albamon</h3>
      <nav class="nav nav-masthead justify-content-center">
        <a class="nav-link active" href="#">MY PAGE</a>
        <a class="nav-link" href="#">SIGN UP</a>
        
      </nav>
    </div>
  </header>


    <h1 class="cover-heading">WelCome Page</h1>
    
    <p class="lead">
      <a href="#" class="btn btn-lg btn-secondary"data-toggle="modal" data-target="#exampleModal">로그인</a>
    </p>


<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">관리자로그인</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
      <form action="${cPath }/alba/albaPass.do" method="post">
        	비밀번호 : <input type="password" name="pass">
        	</div>
      		<div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="submit" class="btn btn-primary">확인</button>
        </form>
      </div>
      
    </div>
  </div>
</div>
<c:if test="${!empty message }">
	<script type="text/javascript">
		$(function(){
			alert("${message}")
		
		})
		
	</script>
	<c:remove var="message" scope="session"/>
</c:if>
<jsp:include page="/includee/postScript.jsp" />
  </body>
</html>
