<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<meta charset="utf-8">

<head>
  <title>BarcodeReader</title>
</head>

<body>
  <div id="container">aaa</div>
  <script type="text/javascript" src="BarcodeReader.js"></script>
  <script type="text/javascript" src="barcode-reader.jquery.js"></script>
  <script type="text/javascript">
    $('#container').barcodeReader();
  </script>
</body>

</html>