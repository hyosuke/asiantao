<%@page pageEncoding="UTF-8"%>
<html>
<head>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="/asiantao/css/a001.css">
<meta name="viewport" content="user-scalable=no">
<script type="text/javascript">
	//スケジュール詳細画面へ遷移
	function jump1(id) {
		document.getElementById("s1").value = id.substring(0, 6);
		document.getElementById("s2").value = id.substring(6, 7);
		document.a002ActionForm.submit();
	}	
	
	//TOP画面へ遷移
	function jump2(){
		location.href = "/asiantao/top";
	};
	
	$(function(){
	var windowHeight = $(window).height();
	var contentHeight = $('.a1').height();
		
		if(contentHeight <windowHeight){
			$('.a1').css('height',windowHeight-10+'px');
		}
	});
</script>



</head>
<body>
	<div class="header">
			<div class="m"><span class="n">AsianTao</span></div>
			<div class="e">
				<img alt="" src="/asiantao/img/menu.png" class="menu" onclick="jump2()">
				<div><span class ="u" >TOP</span></div>
			</div>
	</div>
	<div style="height: 15px;"></div>

	<div class="a1">

		<table class="a5">
			<col span="4" align="center">
			<tr>
				<th width="32%">年月</th>
				<th width="32%">登録日</th>
				<th width="32%">確定日</th>
				<th width="4%"></th>
			</tr>
		</table>

		<table class="a2">
			<col span="4" align="center">
			<c:forEach items="${scheduleDtoList}" var="scheduledto">

				<tr class="a6" id="${scheduledto.selectStr}"
					onclick="jump1(this.id)">
					<td width="32%">${scheduledto.selectMonth}</td>
					<td width="32%">${scheduledto.tourokuDt}</td>
					<td width="32%">${scheduledto.kakutei}</td>
					<td width="4%"><img alt="page" src="../img/page.png"
						class="a7"></td>
				</tr>

			</c:forEach>
		</table>
		<s:form method="post" action="/a002/">
			<html:hidden property="selectMonth" value="" styleId="s1" />
			<html:hidden property="firstFg" value="" styleId="s2" />
		</s:form>
	</div>
</body>
</html>