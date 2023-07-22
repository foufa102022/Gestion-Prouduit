<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head> <%@include file = "Link.jsp"%>

  <title>JSP - Hello World</title>
</head>
<body>
<%@include file="menu.jsp"%>
<div class="container pt-5">
  <div class="row">
    <div class="col-6">

<h1><%= "Bonjour Cher Client !" %></h1>
<br/>
<a href="hello-servlet">Gestion des produits </a>

    </div>
  </div>
</div>
</body>
</html>