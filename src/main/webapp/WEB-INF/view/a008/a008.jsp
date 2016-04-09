<%@page pageEncoding="UTF-8"%>
<html>
<head>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="/asiantao/css/a008.css">
<meta name="viewport" content="user-scalable=no">

<script type="text/javascript">
	var cnt = ${shinseiQy};

	$(function() {

		var windowHeight = $(window).height();
		var contentHeight = $('.a1').height();

		if (contentHeight < windowHeight) {
			$('.a1').css('height', windowHeight - 120 + 'px');
		}
	});

	function addGyou() {

		var ele1 = document.getElementById("schedule").cloneNode(true);
		var ele2 = document.getElementById("position").cloneNode(true);
		var ele3 = document.getElementById("user").cloneNode(true);
		var ele4 = document.getElementById("add").cloneNode(true);
		var ele5 = document.getElementById("del").cloneNode(true);
		var ele6 = document.getElementById("tuikaFg").cloneNode(true);

		ele1.style.display = "";
		ele2.style.display = "";
		ele3.style.display = "";
		ele5.style.display = "";
		ele1.id = "scheduleDetailDtoList[" + cnt + "]_scheduleDv";
		ele2.id = "scheduleDetailDtoList[" + cnt + "]_pozishonDv";
		ele3.id = "scheduleDetailDtoList[" + cnt + "]_userId";
		ele4.id = "add[" + cnt + "]";
		ele5.id = "del[" + cnt + "]";
		ele6.id = "tuikaFg[" + cnt + "]";
		ele1.name = "scheduleDetailDtoList[" + cnt + "].scheduleDv";
		ele2.name = "scheduleDetailDtoList[" + cnt + "].pozishonDv";
		ele3.name = "scheduleDetailDtoList[" + cnt + "].userId";
		ele4.name = "add" + cnt;
		ele5.name = cnt;
		ele6.name = "scheduleDetailDtoList[" + cnt + "].tuikaFg";
		ele4.appendChild(ele5);
		ele4.appendChild(ele1);
		ele4.appendChild(ele2);
		ele4.appendChild(ele3);
		ele4.appendChild(ele6);
		document.getElementById("adderea").appendChild(ele4);
		cnt++;
		var contentHeight = $('.a1').height();
		$('.a1').css('height', contentHeight + 120 + 'px');
	};

	function dellGyou(id) {
		target = document.getElementById("add["
				+ document.getElementById(id).name + "]");
		document.getElementById("adderea").removeChild(target);
		var contentHeight = $('.a1').height();
		$('.a1').css('height', contentHeight - 120 + 'px');
	};

	function jump2() {

		document.getElementById("f1").action = "/asiantao/a007/"
		document.getElementById("f1").name = "a007ActionForm"
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
		<c:forEach items="${messageList}" var="message">
			<div>${message}</div>
		</c:forEach>


		<s:form method="post" action="/a008/regist/">
			<html:hidden property="selectMonth" value="${ selectMonth}" />
			<html:hidden property="day" value="${day}" />
			<div style="height: 20px"></div>
			<div style="width: 100%; height: 100px;">
				<img src="../img/plus.png" class="a2" onclick="addGyou()">

			</div>
			<div style="height: 20px;clear:both;"></div>
				<c:forEach items="${scheduleDetailDtoList}" var="scheduleDetailDto">

						<input type="checkbox" class="a5"
						name="scheduleDetailDtoList[${scheduleDetailDto.cntQy}].okFg"/>

					<div style=" margin-left:20px; width: 25%; height: 100px; float:left;"><html:select
							name="scheduleDetailDtoList" indexed="true" property="scheduleDv"
							value="${scheduleDetailDto.scheduleDv}" styleClass="a4">
							<c:forEach items="${scheduleDetailDto.scheduleDvList}"
								var="scheduleDv">
								<html:option value="${scheduleDv.dvValue }">${scheduleDv.dvName}</html:option>
							</c:forEach>
						</html:select></div>

					<div style="width: 25%; height: 100px;float:left;"><html:select
							name="scheduleDetailDtoList" indexed="true" property="pozishonDv"
							value="${scheduleDetailDto.pozishonDv}" styleClass="a4">

							<c:forEach items="${positionList}" var="position">
								<html:option value="${position.dvValue }">${position.dvName}</html:option>
							</c:forEach>
						</html:select></div>
					<div style="width: 30%; height: 100px; font-size: 50px;float:left;text-align: center;">
					<span style="line-height:100px;">${scheduleDetailDto.userNm}</span>
					<html:hidden
							name="scheduleDetailDtoList" indexed="true" property="userId"
							value="${scheduleDetailDto.userId}" />
					</div>
					
					<div style="clear: both"></div>

				</c:forEach>

			<div style="height: 20px;clear:both;"></div>
			<div id="adderea"></div>
			<div id="add"></div>
			<img src="../img/minus.png" class="addcont1" id="del"
				onclick="dellGyou(this.id)" style="display: none;">
			<select id="schedule" style="display: none; width: 25%"
				class="addcont">
				<c:forEach items="${scheduleList}" var="schedule">
					<option value="${schedule.dvValue }">${schedule.dvName}</option>
				</c:forEach>
			</select>
			<select id="user" style="display: none; width: 35%" class="addcont">
				<c:forEach items="${userList}" var="user">
					<option value="${user.userId }">${user.userNm}</option>
				</c:forEach>
			</select>
			<select id="position" style="display: none; width: 25%"
				class="addcont">
				<c:forEach items="${positionList}" var="position">
					<option value="${position.dvValue }">${position.dvName}</option>
				</c:forEach>
			</select>
			<html:hidden property="tuikaFg" value="true" styleId="tuikaFg" />
			<div style="height: 20px"></div>
			<s:submit property="regist" value="登録" styleClass="a3"></s:submit>

		</s:form>
		<s:form method="post" action="" styleId="f1">
			<html:hidden property="selectMonth" value="${selectMonth}" />
			<html:hidden property="firstFg" value="${firstFg}" />
		</s:form>
	</div>

	<div style="height: 20px"></div>
</body>
</html>