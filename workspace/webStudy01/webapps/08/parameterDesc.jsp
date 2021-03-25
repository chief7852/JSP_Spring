<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="/includee/preScript.jsp" />
<html>
<head>
<meta charset="UTF-8">
<title>08/parameterDesc.jsp</title>
</head>
<body>
<!-- enctype은 post방식때만 사용한다 -->
<form enctype="application/x-www-form-urlencoded" id="paramForm" action="<%=request.getContextPath() %>/08/parameters" method="post">
<pre>
	<input type="hidden" name="param1" value="hiddenParam" />
	<input type="text" name="param1" placeholder="param1"/>
	<input type="text" name="param1" placeholder="param1"/>
	<input type="text" name="param2" placeholder="param2"/>
	<select name="param2">
		<option>option1</option>
		<option>option2</option>
		<option>option3</option>
	</select>
	
	<select name="param3" multiple>
		<option>option1</option>
		<option>option2</option>
		<option>option3</option>
	</select>
	<input type="checkbox" name="param4" value="1"/>CHECK1
	<input type="checkbox" name="param4" value="2"/>CHECK2
	<input type="checkbox" name="param4" value="3"/>CHECK3
	<input type="radio" name="param5" value="RADIO1"/>
	<input type="radio" name="param5" value="RADIO2"/>
	<input type="button" value="버튼"/>
	<input type="submit" value="전송"/>
	<input type="reset" value="취소"/>
	
	
</pre>
</form>
<script type="text/javascript">
	$.fn.serializeJson=function() {
	    //1. form 태그가 존재하는지 유무
	    let tagName = this.prop("tagName").toLowerCase();
	    if(this.length != 1 || tagName != "form") {
	       throw "form에  대해서만 호출 가능한 함수";
	    }
	    let array = this.serializeArray();
//		console.log(array)
		let obj ={}
//		obj.param1 = ["값1","값2"]
		$(array).each(function(){
			console.log(this);
			let name = this.name;
			let value = this.value;
			if(obj[name] && Array.isArray(obj[name])){
				value = obj[name].concat(value);
			}else if(obj[name]||(typeof obj[name] == "string" && obj[name].trim()=="")){
				let tmpArray = [obj[name]];
				tmpArray.push(value);
				value= tmpArray;
			}
			obj[name] = value;
			console.log(obj);
		});
			return obj
	}

	$("#paramForm").on("submit", function(event) {
		event.preventDefault();
		let url = this.action;
		let method = this.method;
		//let enctype = this.enctype;	// 쿼리스트링
		//let data = $(this).serialize();
		//let data = $(this).serializeArray();// 쿼리스트링
		let enctype = "application/json;charset=UTF-8";   // 이렇게  json 세트
		let data = $(this).serializeJson();               //
		data = JSON.stringify(data);                      //
		console.log(data)
		$.ajax({
			url:url,
			method:method,
			contentType:enctype,
			data:data
		});
		return false;
	}) 
	
</script>
</body>
</html>