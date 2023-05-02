<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE>
<html>
<head>
    <title>Book edit</title>
    <style>
        .error{
            color:red;
        }
    </style>
</head>

<body>

<form:form action="/admin/books/edit" method="post" modelAttribute="bookToEdit">

    <form:input type="hidden" name="id" path="id" id="id" />

    <label for="isbn">ISBN</label>
    <form:input path="isbn" id="isbn"/>
    <form:errors path="isbn" cssClass="error"/><br/>

    <label for="title">Title</label>
    <form:input path="title" id="title"/>
    <form:errors path="title" cssClass="error"/><br/>

    <label for="author">Author</label>
    <form:input path="author" id="author"/>
    <form:errors path="author" cssClass="error"/><br/>

    <label for="publisher">Publisher</label>
    <form:input path="publisher" id="publisher"/>
    <form:errors path="publisher" cssClass="error"/><br/>

    <label for="type">Type</label>
    <form:input path="type" id="type"/>
    <form:errors path="type" cssClass="error"/><br/>

    <input type="submit" value="Save">

</form:form>

</body>
</html>
