<%@page pageEncoding="UTF-8"%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="/asiantao/css/a004.css">
<meta name="viewport" content="user-scalable=no">
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script type="text/javascript">
	function opct(id) {
		$(function() {
			var target = document.getElementsByClassName(id).item(0);
			if (target != null) {
				if (target.style.display == "none") {
					$("." + id).slideDown();
				} else {
					$("." + id).slideUp();
				}
			}
		});

	};
	$(function() {
		var windowHeight = $(window).height();
		var contentHeight = $('.a1').height();

		if (contentHeight < windowHeight) {
			$('.a1').css('height', windowHeight - 120 + 'px');
		}
	});

	function jump2() {
		location.href = "/asiantao/a003";
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
		<table class="a4">
			<c:forEach items="${dayList}" var="day">
				<tr onclick="opct(this.id)" id="${day}" class="a4">
					<td class="a21">${day}日</td>
					<td class="a2"></td>
					<td class="a2"><img alt="page" src="../img/page1.png"
						class="a7"></td>

					<tr style="display: none" class="${day}">
							<td class="a5">時間</td>
							<td class="a5">ポジション</td>
							<td class="a5">名前</td>
					</tr>

					<c:forEach items="${scheduleDetailDtoList}" var="scheduleDetailDto">
						<c:if test="${ day==scheduleDetailDto.day}">

							<tr style="display: none" class="${day} a9">
								<td class="a3">${scheduleDetailDto.kakuteiScheduleDvNm}</td>
								<td class="a3">${scheduleDetailDto.kakuteiPozishonDvNm}</td>
								<td class="a3">${scheduleDetailDto.userNm}</td>
							</tr>
						</c:if>
					</c:forEach>
				</c:forEach>
		</table>

	</div>
	<div style="height:20px"></div>
</body>
</html>