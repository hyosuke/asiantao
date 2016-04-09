<%@page pageEncoding="UTF-8"%>
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="/asiantao/css/createuser.css">
	<meta name="viewport" content="user-scalable=no">
	<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script type="text/javascript">
	function showConfirm() {

		if (window.confirm('送信してよろしいですか？')) { // 確認ダイアログを表示

			return true; // 「OK」時は送信を実行

		} else { // 「キャンセル」時の処理

			return false; // 送信を中止

		}
	};
	$(function() {
		var windowHeight = $(window).height();
		var contentHeight = $('.a1').height();

		if (contentHeight < windowHeight) {
			$('.a1').css('height', windowHeight - 120 + 'px');
		}
	});
	function jump1() {
		location.href = "/asiantao/login/";
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
				onclick="jump1()">
			<div>
				<span class="u">戻る</span>
			</div>
		</div>
	</div>
	<div style="height: 15px;"></div>
	<div class="a1">
		<s:form method="post" action="/createUser"
			onsubmit=" return showConfirm()">
			<div style="height: 30px"></div>
			<div>ユーザID</div>
			<input type="text" name="userId" value="" placeholder="userId" maxlength="10"
				class="a2" />

			<div style="height: 30px"></div>
			<div>パスワード</div>
			<input type="password" name="pw" value="" placeholder="password" maxlength="10"
				class="a2" />

			<div style="height: 30px"></div>
			<div>ユーザ名</div>
			<input type="text" name="userNm" value="" placeholder="username" maxlength="10"
				class="a2" />
				
			<div style="height: 30px"></div>
			<div>メールアドレス</div>
			<input type="text" name="mailAd" value="" placeholder="mailaddres" maxlength="30"
				class="a2" />

			<div style="height: 30px"></div>
			<s:submit styleClass="a4" property="regist" value="登録"></s:submit>
		</s:form>

	</div>
</body>
</html>