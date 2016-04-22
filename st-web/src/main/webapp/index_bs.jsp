<!DOCTYPE HTML PUBLIC
    "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language = "java" pageEncoding = "UTF-8" %>
<%@ taglib uri = "/struts-tags"  prefix = "s" %>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title><s:property value="getText('page.index.title')" /></title>
    <link href="css/bootstrap.min.css" rel="stylesheet" />
    <link href="css/signin.css" rel="stylesheet" />
</head>
<body>
<div class="container">
  <form class="form-signin">
    <h2 class="form-signin-heading">Please sign in</h2>
    <label for="inputEmail" class="sr-only">Email address</label>
    <input type="email" id="inputEmail" class="form-control" placeholder="Email address" required autofocus>
    <label for="inputPassword" class="sr-only">Password</label>
    <input type="password" id="inputPassword" class="form-control" placeholder="Password" required>
    <div class="checkbox">
      <label>
        <input type="checkbox" value="remember-me"> Remember me
      </label>
    </div>
    <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
  </form>
</div>
<script type="text/javascript" src="js/jquery-2.2.3.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
</body>
</html>
