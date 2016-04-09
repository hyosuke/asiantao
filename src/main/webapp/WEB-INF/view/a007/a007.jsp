<%@page pageEncoding="UTF-8"%>
<html>
<head>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<meta name="viewport" content="user-scalable=no">
<link rel="stylesheet" type="text/css" href="/asiantao/css/a007.css">
<script type="text/javascript">

	var kakuteiFg = ${kakuteiFg};
	
	function jump1(id) {

		document.getElementById("f1").action = "/asiantao/a007/reset"
		document.getElementById("f1").name = "a007ActionForm"
		document.getElementById("f1").submit();
	}

	function jump2(id) {
		var tourokuDt = document.getElementById(id).childNodes.item(3).childNodes.item(0).nodeValue;
		
		if(kakuteiFg=='1' || tourokuDt !='未登録'){
			document.getElementById("s1").value = id;
			document.getElementById("f1").action = "/asiantao/a009/"
			document.getElementById("f1").name = "a009ActionForm"
			document.getElementById("f1").submit();
			
		}else{
		document.getElementById("s1").value = id;
		document.getElementById("f1").action = "/asiantao/a008/"
		document.getElementById("f1").name = "a008ActionForm"
		document.getElementById("f1").submit();
		}
	}

	function jump3(id) {

		document.getElementById("f1").action = "/asiantao/a007/regist"
		document.getElementById("f1").name = "a007ActionForm"
		document.getElementById("f1").submit();

	}
	function jump4() {
		location.href = "/asiantao/a005";
	};
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
				onclick="jump4()">
			<div>
				<span class="u">戻る</span>
			</div>
		</div>
	</div>
	<div style="height: 15px;"></div>
	<div class="a1">
		<table class="a5">
			<col span="4" align="center">
			<tr>
				<th width="32%">年月</th>
				<th width="32%">登録日</th>
				<th width="32%">登録人数</th>
				<th width="4%"></th>
			</tr>
		</table>

		<table class="a2">
			<col span="4" align="center">
			<c:forEach items="${scheduleDetailDtoList}" var="scheduleDetailDto">

				<tr class="a6" id="${scheduleDetailDto.day}"
					onclick="jump2(this.id)">
					<td width="32%">${scheduleDetailDto.dayStr }</td>

					<td width="32%">${scheduleDetailDto.torokuDt}</td>

					<td width="32%">${scheduleDetailDto.TorokuQy}</td>
					<td width="4%"><img alt="page" src="../img/page.png"
						class="a7"></td>


				</tr>

			</c:forEach>
		</table>
		<div style="height: 20px"></div>

		<c:if test="${kakuteiFg == '0' }">
			<html:button property="regist" onclick=" jump3()" styleClass="a4">確定</html:button>
		</c:if>
		<c:if test="${kakuteiFg == '1' }">
			<html:button property="regist" onclick=" jump1()" styleClass="a4">確定取消</html:button>
		</c:if>

		<div style="height: 20px"></div>

		<s:form method="post" action="" styleId="f1">
			<html:hidden property="selectMonth" value="${selectMonth}" />
			<html:hidden property="firstFg" value="${firstFg}" />
			<html:hidden property="day" value="" styleId="s1" />
		</s:form>
	</div>
</body>
</html>