<%@page pageEncoding="UTF-8"%>
<html>
<head>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script type="text/javascript">
	function selectfr() {
		document.getElementById("a1").click();
	};

	function select() {
		console.log("ファイルを選択しました。");
	};
	$(function() {

		$("#a1").change(function() {
			select();
		});
	});
</script>
</head>
<body>
	<div style="height: 200px; background-color: black"
		onclick="selectfr()"></div>


	<input type="file" multiple="multiple" style="display: none" id="a1">
</html>