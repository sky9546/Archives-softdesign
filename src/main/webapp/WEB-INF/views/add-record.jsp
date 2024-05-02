<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Record</title>
    <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <!-- TinyMCE library -->
    <script src="https://cdn.tiny.cloud/1/6a6whhjkrfjgjptjaky84gnilq12kkvid3jefj0kpei788d8/tinymce/7/tinymce.min.js" referrerpolicy="origin"></script>
      <!-- Add Font Awesome CSS -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
</head>
<body>
    <div class="container-fluid">
        <h3 class="mt-5 mb-4">Add Record</h3>
        <form action="/save-record" method="post">
            <div class="row">
                <!-- First column -->
                <div class="col-md-4 mb-3">
                    <label for="title">Title</label>
                    <input type="text" class="form-control" id="title" name="title" required>
                </div>
                <!-- Second column -->
                <div class="col-md-4 mb-3">
                    <label for="author">Author</label>
                    <input type="text" class="form-control" id="author" name="author" required>
                </div>
                <!-- Third column -->
                <div class="col-md-4 mb-3">
                    <label for="public-url">Public URL</label>
                    <input type="text" class="form-control" id="public-url" name="public-url" required>
                </div>
            </div>
            <div class="row">
                <!-- First column -->
             <div class="col-md-4 mb-3">
                 <label for="article_date">Article Date</label>
                 <input type="date" class="form-control" id="article_date" name="article_date" required>
             </div>

                <!-- Second column -->
                <div class="col-md-4 mb-3">
                    <label for="access-category">Access Category</label>
                    <input type="text" class="form-control" id="access-category" name="access-category" required>
                </div>
                <!-- Third column -->
                <div class="col-md-4 mb-3">
                    <label for="free-view-expiry">Free View Expiry</label>
                    <input type="date" class="form-control" id="free_view_expiry" name="free_view_expiry" required>
                </div>
            </div>
            <div class="row">
                <!-- First column -->
                <div class="col-md-4 mb-3">
                    <label for="description">Description</label>
                    <input type="text" class="form-control" id="description" name="description">
                </div>
                <!-- Initialize TinyMCE on description textarea -->
                <script>
                    tinymce.init({
                        selector: '#description',
                        height: 300,
                        plugins: [
                            'advlist autolink lists link image charmap print preview anchor',
                            'searchreplace visualblocks code fullscreen',
                            'insertdatetime media table paste code help wordcount'
                        ],
                        toolbar: 'undo redo | formatselect | ' +
                            'bold italic backcolor | alignleft aligncenter ' +
                            'alignright alignjustify | bullist numlist outdent indent | ' +
                            'removeformat | help',
                        content_css: '//www.tiny.cloud/css/codepen.min.css'
                    });
                </script>
                <!-- Second column -->
                <div class="col-md-4 mb-3">
                    <label for="feature-image">Feature Image</label>
                    <input type="file" class="form-control-file" id="feature-image" name="feature-image">
                </div>
                <!-- Third column -->
                <div class="col-md-4 mb-3">
                    <label for="pdf-img">PDF/Image</label>
                    <input type="file" class="form-control-file" id="pdf-img" name="pdf-img">
                </div>
            </div>
            <button class="btn btn-success" type="submit">Save</button>
            <a class="btn btn-primary" href="/" role="button"><i class="fa fa-bars"></i> List</a>
        </form>
    </div>
    <!-- Bootstrap JS and dependencies -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
