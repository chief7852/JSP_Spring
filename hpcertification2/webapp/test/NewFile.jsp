<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>

</head>
<body>
<input type=file accept="image/*" capture=environment id="qr-scanner" tabindex=-1>
 
</body>
<script type="text/javascript">
//open the scanner
$(document).on('change', '#qr-scanner', function (e) {
     e.preventDefault();
     e.stopPropagation();
     var scanResult = scanQR(this);
});
// process the image with scanner
function scanQR(node) {
  var reader = new FileReader();
  reader.onload = function() {
  qrcode.callback = function(res) {
    if(res instanceof Error) {
        handleScanResults(false);
    } else {
        handleScanResults(res);
    }
  };
  qrcode.decode(reader.result);
  };
  reader.readAsDataURL(node.files[0]);
}
// handle scanner results
function handleScanResults(scanResult) {
  if (scanResult) {
      alert(scanResult);
  } else {
      alert('Scan error, try again.');
  }
}

</script>
</html>