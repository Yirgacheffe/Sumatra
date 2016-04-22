<!DOCTYPE HTML PUBLIC
    "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language = "java" pageEncoding = "UTF-8" %>
<%@ taglib uri = "/struts-tags"  prefix = "s" %>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title><s:property value="getText('page.index.title')" /></title>
    <link href="css/bootstrap.min.css" rel="stylesheet" />
    <script type="text/javascript" src="js/jquery-2.2.3.min.js">
    </script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
<s:actionerror />
<s:form id="login_form" action="login" method="POST">
    <s:textfield name="email"    key="label.email"    size="50" />
    <s:password  name="password" key="label.password" size="50" />
    <s:submit key="label.signin" method="login" />
</s:form>
</div>
</body>
</html>
