<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hello! Java laba #6:</title>
</head>
<body>
<h3>Hello! Java laba #6:</h3>
<%
    String text = (String) request.getAttribute("text");
    Integer size = (Integer) request.getAttribute("size");
    Integer count = (Integer) request.getAttribute("count");
    String color = (String) request.getAttribute("color");

    if (text == null) {
        text = "";
    }
%>
<div id="form">
    <form action="${pageContext.request.contextPath}/index" method="GET" enctype="multipart/form-data">
        <div class="edit-input">
            <label for="edit-size">Font size</label>
            <input id="edit-size"  required name="size" type="number" min="10" max="48" value="<%= size %>"/>
        </div>
        <div class="edit-input">
            <label for="edit-count">Count strings</label>
            <input id="edit-count" required name="count" type="number" min="1" max="10" value="<%= count %>"/>
        </div>
        <div class="edit-input">
            <label for="edit-color">Color</label>
            <select id="edit-color" name="color">
                <option disabled selected>- Select color -</option>
                <option value="#000000">Black</option>
                <option value="#007bff">Blue</option>
                <option value="#6c757d">Gray</option>
                <option value="#28a745">Green</option>
                <option value="#dc3545">Red</option>
                <option value="#ffc107">Yellow</option>
            </select>
        </div>
        <input type="submit" value="Submit"/>
    </form>
</div>

<div class="text-content" style="font-size: <%= size%>px; color: <%= color%>">
    <p><%= text %></p>
</div>
<div>

</div>
</body>
</html>
