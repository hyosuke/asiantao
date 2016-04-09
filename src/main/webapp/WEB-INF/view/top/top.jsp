<%@page pageEncoding="UTF-8"%>
<html>
<head>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="/asiantao/css/top.css">
<meta name="viewport" content="user-scalable=no">
<script type="text/javascript">

//シフト入力画面へ遷移
function jump1(){
	location.href = "/asiantao/a001/";
}
//シフト一覧画面へ遷移
function jump2(){
	location.href = "/asiantao/a003/";
}
//シフト登録画面へ遷移
function jump3(){
	location.href = "/asiantao/a005/";
}
//お知らせ登録画面へ遷移
function jump4(){
	location.href = "/asiantao/a011/";	
}

$(function() {
	var windowHeight = $(window).height();
	var contentHeight = $('.a1').height();

	if (contentHeight < windowHeight) {
		$('.a1').css('height', windowHeight - 100 + 'px');
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
			<div>
				<span class="u">ユーザID: ${userDto.s_userId}</span>
			</div>
			<div>
				<span class="u">ユーザ名: ${userDto.s_userNm}</span>
			</div>
		</div>
	</div>

<div class="a1">
<span class="a6">お知らせ</span>

<div id="keijiban" class="a3">

<c:forEach  items="${oshiraseList}" var="oshirase">

<div class ="oshirase1"><fmt:formatDate value="${oshirase.tourokubi}" pattern="yyyyMMdd" />---</div>
<div class ="oshirase2">${oshirase.ohirase}</div>
</c:forEach>

</div>

<div class="a5">
<div style="height:20px"></div>
<html:button property="jump" onclick="jump1()" styleClass="a4">シフト入力</html:button>
<div style="height:20px"></div>
<html:button property="jump" onclick="jump2()" styleClass="a4">シフト一覧</html:button>
<div style="height:20px"></div>
<c:if test="${userDto.kanriFg =='1'}">
<html:button property="jump" onclick="jump3()" styleClass="a4">シフト登録</html:button>
<div style="height:20px"></div>
<html:button property="jump" onclick="jump4()" styleClass="a4">お知らせ登録</html:button>
</c:if>

<div style="height:20px"></div>
</div>
</div>
</body>
</html>