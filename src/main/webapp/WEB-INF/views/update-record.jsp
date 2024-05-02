<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Record</title>
    <!-- Add Font Awesome CSS -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    <!-- Add Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <h1>Update Record</h1>
    <form action="/update-record/${record.id}" method="post">
        <div class="form-group">
            <label for="title">Title:</label>
            <input type="text" class="form-control" id="title" name="title" value="${record.title}">
        </div>
        <div class="form-group">
            <label for="date">Date:</label>
            <input type="text" class="form-control" id="date" name="date" value="${record.date}">
        </div>
        <div class="form-group">
            <label for="author">Author:</label>
            <input type="text" class="form-control" id="author" name="author" value="${record.author}">
        </div>
        <div class="form-group">
            <label for="preference">Preference:</label>
            <input type="text" class="form-control" id="preference" name="preference" value="${record.preference}">
        </div>

        <div class="form-group">
            <label for="publishedOnConnect">Published on Connect:</label>
            <input type="text" class="form-control" id="publishedOnConnect" name="publishedOnConnect" value="${record.publishedOnConnect}">
        </div>
        <button type="submit" class="btn btn-primary">Update Record</button>
    </form>
</div>
</body>
</html>
