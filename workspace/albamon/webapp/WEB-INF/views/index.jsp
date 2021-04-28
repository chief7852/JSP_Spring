<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="kr">
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
<c:choose>
	<c:when test="${not empty message }">
		<script type="text/javascript">
			alert("${message}")
		</script>
	</c:when>
</c:choose>

  <header class="masthead mb-auto">
    <div class="inner">
      <h3 class="masthead-brand">Albamon</h3>
      <nav class="nav nav-masthead justify-content-center">
        <a class="nav-link active" href="${cPath }/alba/albaInsert.do">알바생 추가</a>
        <a class="nav-link" href="#">월급관리</a>
        
      </nav>
    </div>
  </header>


    <h1 class="cover-heading">관리자 알바생 관리</h1>
    
    <p class="lead">
      <a href="#" class="btn btn-lg btn-secondary"data-toggle="modal" data-target="#exampleModal">알바 리스트</a>
    </p>



<!-- Modal -->
<script type="text/javascript">
	$(".btn-secondary").on('click',function(){
		location.href="${cPath}/alba/albaList.do"
	})
	
</script>
<jsp:include page="/includee/postScript.jsp" />
  </body>
</html>
