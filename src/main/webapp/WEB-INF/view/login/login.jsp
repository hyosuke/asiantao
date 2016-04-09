<%@page pageEncoding="UTF-8"%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="/asiantao/css/login.css">
<script type="text/javascript" src="/asiantao/js/jquery-1.11.3.min.js"></script>
<meta name="viewport" content="user-scalable=no">

<script type="text/javascript">

//新規登録画面へ遷移
function jump1(){
	location.href = "/asiantao/createUser/";
};


</script>

</head>
<body>

<div class="a1"> 
<div style="height:35px"></div>
<span class="t1">AsianTao</span>
<table></table>


<div style="height:20px"></div>

<s:form method="post" action="/login">	
	
	<input type="text" name="userId" value="" placeholder="userId" class="a2" maxlength="10"/>
	<br><div style="height:20px"></div>
	
	<input type="password" name="pw" value="" placeholder="password"  class = "a3" maxlength="10"/>
	
	<br><div style="height:20px"></div>
	<s:submit property="check" value="ログイン" styleClass="a4"></s:submit>
	<br><div style="height:20px"></div>
	<html:button property="jump" onclick="jump1()" styleClass="a4">新規登録</html:button>
	
</s:form>

<div style="height:20px"></div>
</div>


</body>
</html>