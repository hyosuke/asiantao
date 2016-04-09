<%@page pageEncoding="UTF-8"%>
<html>
<head>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>

<link rel="stylesheet" type="text/css" href="/asiantao/css/a002.css">
<meta name="viewport" content="user-scalable=no">
<script type="text/javascript">


	function jump1(id){
		
		document.getElementById("s1").value = id;
		document.a010ActionForm.submit();
	
	};
	function jump2() {
		location.href = "/asiantao/a001";
	};
	$(function() {
		var windowHeight = $(window).height();
		var contentHeight = $('.a1').height();

		if (contentHeight < windowHeight) {
			$('.a1').css('height', windowHeight - 120 + 'px');
		}
	});
	
	var mode = ${mode};
	
	$(function(){
		if(mode =="2"){
			
			$('.a3').attr('disabled',true);
			$('.a4').hide();
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
				onclick="jump2()">
			<div>
				<span class="u">戻る</span>
			</div>
		</div>
	</div>
	<div style="height: 15px"></div>
	<div class="a1">


		<s:form method="post" action="/a002/regist/">

			<table class="a5">
				<col span="3" align="center" width="33%">
				<tr>
					<th>日</th>
					<th>希望時間</th>
					<th>申請人数</th>
				</tr>
			</table>

			<table class="a2">
				<col span="3" align="center" width="33%">
				<c:forEach items="${scheduleDetailDtoList}"
					var="scheduleDetailDtoList">
					<tr class="a6">
						<td>${scheduleDetailDtoList.dayStr }<html:hidden
								property="day" name="scheduleDetailDtoList" indexed="true"
								value="${scheduleDetailDtoList.day }" />
						</td>
						<td><html:select styleClass="a3" name="scheduleDetailDtoList"
								indexed="true" property="scheduleDv"
								value="${scheduleDetailDtoList.scheduleDv}">
								<html:options collection="dvDtoList" property="dvValue"
									labelProperty="dvName" />
							</html:select></td>
						<td id="${scheduleDetailDtoList.day }" onclick="jump1(this.id)">${scheduleDetailDtoList.shinseiQy}</td>
					</tr>
				</c:forEach>
			</table>
			<html:hidden property="selectMonth" value="${selectMonth}" />
			<html:hidden property="firstFg" value="${firstFg}" />
			<div style="height: 20px"></div>
			<s:submit property="regist" value="登録" styleClass="a4"></s:submit>
		</s:form>
		<div style="height: 20px"></div>
		
		<s:form method ="post" action="/a010/">
				<html:hidden property="selectMonth" value="${selectMonth}" />
				<html:hidden property="firstFg" value="${firstFg}" />
				<html:hidden property="day" value="" styleId="s1"/>
		</s:form>
	</div>

</body>
</html>