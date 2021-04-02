/*
 * 
 */
   $.generateMessage = function (message) {
      let messageTag = $("<span>")
         .text(message?message:"")
         .addClass("message")
         .addClass("error");
      return messageTag;
   }
   // blur : 값을 입력 한 뒤 떠날 때 일어나는 이벤트(tab or focus 가 다른 곳으로 이동 할 때)
   let idTag = $("input[name=mem_id]").on("change", function() {
      idCheckBtn.trigger("click");
   });
   let idCheckBtn = $("#idCheck").on("click", function() {
      memberForm.data("idcheck", "FAIL");
      /* let idTag = $("input[name=mem_id]").val(); */
      idTag.next(".message:first").remove();
      let mem_id = idTag.val();
      $.ajax({
         url : "idCheck.do",
         method : "post",
         data : {
            id:mem_id
         },
         dataType : "json",
         success : function(resp) {
            // 데이터 속성을 건드리기 위해서 사용 [ key : value 형태]
            memberForm.data("idcheck", resp.result);
            if(resp.result!="OK") {
               let messageTag = $.generateMessage("아이디 중복");
               idTag.after(messageTag);
               idTag.focus();
            }
         },
         error : function(xhr, error, msg) { // xmlHttpRequest, error, massage
            console.log(xhr);
            console.log(error);
            console.log(msg);
         }
      })
   });
   let memberForm = $("#memberForm").on("submit", function() {
      let checked = $(this).data("idcheck")=="OK";
      if(!checked) {
         let messageTag = idTag.next(".message:first");
         if(!messageTag || messageTag.length==0) {
            messageTag = $.generateMessage();            
         }
         messageTag.text("아이디 중복 체크 하세요.");
         
         idTag.after(messageTag);
         idTag.focus();
      }
      return checked;
   });