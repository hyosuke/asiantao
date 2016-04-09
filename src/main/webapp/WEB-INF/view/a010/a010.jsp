<%@page pageEncoding="UTF-8"%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="/asiantao/css/a010.css">
<meta name="viewport" content="user-scalable=no">
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {
		var windowHeight = $(window).height();
		var contentHeight = $('.a1').height();

		if (contentHeight < windowHeight) {
			$('.a1').css('height', windowHeight - 120 + 'px');
		}
	});

	function jump2() {
		document.getElementById("f1").action = "/asiantao/a010/return1"
		document.getElementById("f1").name = "a010ActionForm"
		document.getElementById("f1").submit();
	};
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
		<table class="a5">
			<col span="5" align="center">
			<tr>
				<th width="2%"></th>
				<th width="48%">希望時間</th>
				<th width="48%">名前</th>
				<th width="2%"></th>
			</tr>
		</table>
		<table class="a2">
			<col span="5" align="center">
			<c:forEach items="${scheduleDetailDtoList}" var="scheduleDetailDto">

				<tr class="a6">
					<td width="2%"></td>
					<td width="48%">${scheduleDetailDto.scheduleDvNm}</td>
					<td width="48%">${scheduleDetailDto.userNm}</td>
					<td width="2%"></td>
				</tr>
			</c:forEach>
		</table>
		<s:form method="post" action="" styleId="f1">
			<html:hidden property="selectMonth" value="${selectMonth}" />
			<html:hidden property="firstFg" value="${firstFg}" />
		</s:form>

	</div>

</body>
</html>