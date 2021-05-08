<script src="https://www.google.com/recaptcha/api.js"></script>
<script>
$(function() {
$('#add_member_form').submit(function() {
		var captcha = 1;
		$.ajax({
            url: '/pro/VerifyRecaptcha',
            type: 'post',
            data: {
                recaptcha: $("#g-recaptcha-response").val()
            },
            success: function(data) {
                switch (data) {
                    case 0:
                        console.log("자동 가입 방지 봇 통과");
                        captcha = 0;
                		break;
                    case 1:
                        alert("자동 가입 방지 봇을 확인 한뒤 진행 해 주세요.");
                        break;
                    default:
                        alert("자동 가입 방지 봇을 실행 하던 중 오류가 발생 했습니다. [Error bot Code : " + Number(data) + "]");
                   		break;
                }
            }
        });
		if(captcha != 0) {
			return false;
		} 
});
});
</script>
<body>

 <div class="g-recaptcha" data-sitekey="<!-- 여기가 사이트키 -->6Ld1tsgaAAAAAMN22NYiVxQdxPOwXWbzn-MpAhTP"></div>
<button id = "join_button"type="submit">회원가입</button>
</body>