<!DOCTYPE HTML PUBLIC
    "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language = "java" pageEncoding = "UTF-8" %>
<%@ taglib uri = "/struts-tags"  prefix = "s" %>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html" />
    <title><s:property value="getText('page.index.title')" /></title>
    <link href="css/bootstrap.min.css" rel="stylesheet" />
    <link href="css/dashboard.css" rel="stylesheet" />
</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top">
<div class="container-fluid">
  <div class="navbar-header">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
    </button>
    <a class="navbar-brand" href="#">NSV Time Entry</a>
  </div>
  <div id="navbar" class="navbar-collapse collapse">
    <ul class="nav navbar-nav navbar-right">
        <li><p class="navbar-text">Hello!&nbsp;<a href="#" class="navbar-link">Obelix</a></p><li>
        <li><a href="#">Change Password</a></li>
        <li><a href="#">Logout</a></li>
        <li><a href="#">Help</a></li>
     </ul>
  </div>
</div>
</nav>
<div class="container-fluid">
      <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
          <ul class="nav nav-sidebar">
            <li class="active"><a href="#">Overview <span class="sr-only">(current)</span></a></li>
            <li><a href="#">Reports</a></li>
            <li><a href="#">Analytics</a></li>
            <li><a href="#">Export</a></li>
          </ul>
          <ul class="nav nav-sidebar">
            <li><a href="">Nav item</a></li>
            <li><a href="">Nav item again</a></li>
            <li><a href="">One more nav</a></li>
            <li><a href="">Another nav item</a></li>
            <li><a href="">More navigation</a></li>
          </ul>
          <ul class="nav nav-sidebar">
            <li><a href="">Nav item again</a></li>
            <li><a href="">One more nav</a></li>
            <li><a href="">Another nav item</a></li>
          </ul>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
          <ol class="breadcrumb">
            <li><a href="#">Home</a></li>
            <li><a href="#">Library</a></li>
            <li class="active">Data</li>
          </ol>
          <div class="row placeholder">
            <div class="col-xs-6 col-sm-3 placeholder">
                <div class="input-group">
                  <span class="input-group-addon" id="basic-addon1">@</span>
                  <input type="text" class="form-control" placeholder="Username" aria-describedby="basic-addon1">
                </div>

                <div class="input-group">
                  <input type="text" class="form-control" placeholder="Recipient's username" aria-describedby="basic-addon2">
                  <span class="input-group-addon" id="basic-addon2">@example.com</span>
                </div>

                <div class="input-group">
                  <span class="input-group-addon">$</span>
                  <input type="text" class="form-control" aria-label="Amount (to the nearest dollar)">
                  <span class="input-group-addon">.00</span>
                </div>
            </div>
          </div>

          <div class="table-responsive">
            <table class="table table-striped">
              <thead>
                <tr>
                  <th>#</th>
                  <th>Header</th>
                  <th>Header</th>
                  <th>Header</th>
                  <th>Header</th>
                </tr>
              </thead>
              <tbody>
                <tr>
                  <td>1,001</td>
                  <td>Lorem</td>
                  <td>ipsum</td>
                  <td>dolor</td>
                  <td>sit</td>
                </tr>
              </tbody>
            </table>
          </div>
        </div>
      </div>
    </div>
    <script type="text/javascript" src="js/jquery-2.2.3.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
</body>
</html>
