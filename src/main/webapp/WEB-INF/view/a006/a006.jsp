<%@page pageEncoding="UTF-8"%>
<html>
<head>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="/asiantao/css/a006.css">
<meta name="viewport" content="user-scalable=no">
<script type="text/javascript">
	$(function() {
		var windowHeight = $(window).height();
		var contentHeight = $('.a1').height();

		if (contentHeight < windowHeight) {
			$('.a1').css('height', windowHeight - 120 + 'px');
		}
	});
	
	function jump2(){
		
		location.href = "/asiantao/a005/";
	}
</script>

</head>
<body>
	<div class="header">
		<div class="m">
			<span class="n">AsianTao</span>
		</div>
		<div class="e">
			<img alt="" src="/asiantao/img/menu.png" class="menu"
				onclick="jump2()">
			<div>
				<span class="u">戻る</span>
			</div>
		</div>
	</div>
	<div style="height: 15px;"></div>
	<div class="a1">
		<div style="height: 30px"></div>
		未申請者
		<div style="height: 10px"></div>
		<div class="a3">
			<c:forEach items="${miteishutuList}" var="miteishutu">

				<div>${miteishutu}</div>
			</c:forEach>
		</div>
		<div style="height: 30px"></div>
		<s:form method="post" action="/a007" styleId="f1">
			<s:submit property="jamp" value="登録" styleClass="a4"></s:submit>
			<html:hidden property="selectMonth" value="${selectMonth }"
				styleId="s1" />
			<html:hidden property="firstFg" value="${firstFg}" styleId="s2" />
		</s:form>
	</div>
</body>
</html>