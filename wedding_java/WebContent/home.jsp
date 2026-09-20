<%@ page language="java" contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
	<meta http-equiv="Content-Style-Type" content="text/css"/>
	<meta http-equiv="Content-Script-Type" content="text/javascript"/>
	<meta http-equiv="imagetoolbar" content="no"/>
	<meta name="description" content=""/>
	<meta name="keywords" content=""/>
    <title>ホーム画面</title>
    <style type="text/css">
	/*=====TAG LAYOUT=====*/
	#humberger {
		position: relative;
		height: 20px;
		width: 28px;
		display: inline-block;	
		box-sizing: border-box;
	}
	
	#humberger div {
		position: absolute;
		left: 0;
		height: 2px;
		width: 28px;
		background-color: #444;
		border-radius: 2px;
		display: inline-block;	
		box-sizing: border-box;
	}
	
	#humberger div:nth-of-type(1) {
		bottom: 20px;
	}
	
	#humberger div:nth-of-type(2) {
		bottom: 10px;
	}
	
	#humberger div:nth-of-type(3) {
		bottom: 0;
	}

		</style>		
</head>

<body>
 	<header>
        <ul>
            <li> 
            <span id="top">
            <div id="humberger">
				<div></div>
				<div></div>
				<div></div>
			</div>
            </span></li>
            <li>プロフィール</li>
            <li>D.I.Blogについて</li>
            <s:if test="#session.loginAuthority == 1">
	            <li><a href='<s:url action="RegistAction"/>'>アカウント登録</a></li>
	            <li><a href='<s:url action="ListAction"/>'>アカウント一覧</a> </li> 
            </s:if>          	
            <li>登録フォーム</li>
            <li>問い合わせ</li>
            <li>その他</li>
        </ul>
    </header>
</body>
</html>