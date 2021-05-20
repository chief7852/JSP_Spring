<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE HTML>
<html>
<head>
    <title>Text 2 QR Code</title>

</head>
<body>
      회원이름: <input type="text" id="memId" value="" class="input-xxlarge"><br>
    구매 날짜: <input type="date" id="date" class="input-xxlarge"><br>
    이용권명: <input type="text" id="name" value="성공함" class="input-xxlarge"><br>
    포켓코인: <input type="text" id="money" value="성공함" class="input-xxlarge"><br>ree
    Size: <input type="text" id="size" value="200"><br>
    <button type="button" onclick="generateQRCode();">Generate QR Code!</button>
    <img id="qrcode_img" style="display:none" onload="this.style.display='block'">
        <script type="text/javascript">
        var generateQRCode = function() {
            var url = "<%=request.getContextPath()%>/services/qrcode/text2qrcode.do";
            //회원 아이디 받기
            var memId = document.getElementById("memId").value;
            //날짜
            var date = document.getElementById("date").value;
            //이용권이름
            var name = document.getElementById("name").value;
            //포켓코인
            var money = document.getElementById("money").value;
            //QR코드 사이즈
            var size = document.getElementById("size").value;
            
            var imgObj = document.getElementById("qrcode_img");
            
//             if (text) {
//                 text = encodeURIComponent(text);
                
                if (size > 0 && size < 500) {
                    url += "?width=" + size + "&height=" + size + "&memId=" + memId + "&date=" + date
                    		+ "&name=" + name + "&money=" + money;
                    
                    imgObj.src = url;
                }
            
        }
    </script>
</body>
</html>