<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ann</title>
</head>
<body>
<h3>Java laba #6:</h3>
<%
    String text = (String) request.getAttribute("text");
    Integer size = (Integer) request.getAttribute("size");
    Integer count = (Integer) request.getAttribute("count");
%>
<div id="form">
    <form action="${pageContext.request.contextPath}/index" method="GET" enctype="multipart/form-data">
        <div class="edit-input">
            <label for="edit-size">Font size</label>
            <input id="edit-size"  required name="size" type="number" min="10" max="48" value="<%= size %>"/>
        </div>
        <div class="edit-input">
            <label for="edit-count">Count paragraphs</label>
            <input id="edit-count" required name="count" type="number" min="1" max="10" value="<%= count %>"/>
        </div>
        <input type="submit" value="Submit"/>
    </form>
</div>

<div class="text-content" style="font-size: <%= size%>px">
    <%= text %>
</div>
<div>

</div>
</body>
</html>
