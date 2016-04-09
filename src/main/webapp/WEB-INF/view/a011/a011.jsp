<%@page pageEncoding="UTF-8"%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="/asiantao/css/a011.css">
<meta name="viewport" content="user-scalable=no">
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script type="text/javascript">

function jump2(){
	
	document.getElementById("f1").submit();
}


function jump1(){
	
	location.href = "/asiantao/top/";
}

$(function() {

	var windowHeight = $(window).height();
	var contentHeight = $('.a1').height();

	if (contentHeight < windowHeight) {
		$('.a1').css('height', windowHeight - 120 + 'px');
	}
});
</script>

</head>
<body>

	<div class="header">
		<div class="m">
			<span class="n">AsianTao</span>
		</div>
		<div class="e">
			<img alt="" src="/asiantao/img/menu.png" class="menu"
				onclick="jump1()">
			<div>
				<span class="u">戻る</span>
			</div>
		</div>
	</div>
	<div style="height: 15px;"></div>
	<div class="a1">
	
	<s:form method="post" action ="/a011/regist" styleId="f1">
	<div style="height:20px"></div>
	<textarea name="oshirase" rows="40" cols="100" maxlength="150"></textarea>
	
	<div style="height:20px"></div>
	<html:button property="jump" onclick="jump2()" styleClass="a4">登録</html:button>
	<div style="height:20px"></div>
	</s:form>
	
	</div>
</body>
</html>