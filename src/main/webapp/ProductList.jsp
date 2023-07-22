<%--
  Created by IntelliJ IDEA.
  User: foufa
  Date: 29/05/2023
  Time: 09:10
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file = "Link.jsp"%>
    <title>Title</title>
</head>
<body>
<%@include file="menu.jsp"%>
<div class = "container">
    <div class = "row">
        <div class = "col-6">

            <form action="Produit" method = "post" name="produitsform">
                <label class ="form-label" for="nom">Nom:</label>
                <input class="form-control" name="nom" id="nom" type="text" placeholder="Donner le nom du produit" required />
                <label class ="form-label" for="Description"></label>
                <input class="form-control" name="Description" id="Description" type="text" placeholder="Decrir le produit" required /> <br>
                <label class ="form-label" for="Prix"></label>
                <input class="form-control" name="Prix" id="Prix" type="text" placeholder="Donner le prix du produit" required /> <br>

                <button class="btn btn-primary" type="submit" name="save" style="display: block; margin: 0 auto; width: 200px;">Add</button>
            </form>
            <table class="table">
                <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Name</th>
                    <th scope="col">Age</th>
                    <th scope="col">Action</th>


                </tr>
                </thead>
                <tbody>
                <c:forEach items="${ Produit }" var="p">
                    <tr>
                        <th scope="row"><c:out value="${s.id}"/> </th>
                        <td><c:out value="${p.nom}"/></td>
                        <td><c:out value="${p.description}"/></td>
                        <td><c:out value="${p.prix}"/></td>
                        <td>
                            <a href="/DeleteServlet?id=<c:out value="${s.id}"/>"
                               onclick="javascript:window.confirm('Do you really want to leave?')"
                               class="btn btn-danger ml-4"> Delete </a > </td>
                    </tr>
                </c:forEach>
                </tbody


</table>



        </div>
    </div>
</div>
</body>
</html>
