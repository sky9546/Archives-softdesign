<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Records</title>
    <!-- Add Font Awesome CSS -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    <!-- Add jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <!-- Add DataTables library for sorting, searching, and pagination -->
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.25/css/jquery.dataTables.css">
    <link href="css/style.css" rel="stylesheet" ></link>
    <script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.25/js/jquery.dataTables.js"></script>
       <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
     <script>
         $(document).ready(function() {
             // Initialize DataTables for the records table
             $('#recordsTable').DataTable();
         });

         function deleteRecord(id) {
             if (confirm('Are you sure you want to delete this record?')) {
                 // Send a DELETE request to the controller
                 $.ajax({
                     url: '/' + id,
                     type: 'DELETE',
                     success: function(result) {
                         // Refresh the page after successful deletion
                         location.reload();
                     }
                 });
             }
         }
     </script>

</head>
<body>
<div>
<div class="row">
    <div class="col">
        <h3>Articles</h3>
    </div>
    <div class="col text-right">
        <div class="p-3">
            <a class="btn btn-primary" href="/add-record" role="button">Add Articles</a>
        </div>
    </div>
</div>

    <!-- Add a table with an id for DataTables -->
    <table id="recordsTable">
        <thead>
            <tr>
                <th>Title</th>
                <th>Date</th>
                <th>Author</th>
                <th>Preference</th>
                <th>Status</th>
                <th>Published on Connect</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${records}" var="record">
                <tr>
                    <td>${record.title}</td>
                    <td>${record.date}</td> <!-- You might need to format this date -->
                    <td>${record.author}</td>
                    <td>${record.preference}</td>
                    <td>${record.status}</td>
                    <td>${record.publishedOnConnect}</td>
          <td>
              <!-- View record icon -->
              <a href="#" onclick="viewRecord(${record.id})"><i class="fa fa-eye"></i></a>
              <!-- View record details icon -->
              <a href="/view-record" onclick="viewRecordDetails(${record.id})"><i class="fa fa-eye" style="color: aqua;"></i></a>
              <!-- Edit record icon -->
               <!-- Update record icon -->
             <a href="/update-record/${record.id}" onclick="updateRecord(${record.id})"><i class="far fa-edit"></i></a>



              <!-- Delete record icon -->
              <a href="#" onclick="deleteRecord(${record.id})"><i class="fa fa-trash"></i></a>
          </td>


                </tr>
            </c:forEach>
        </tbody>
    </table>

    <h2>Logs</h2>
    <!-- Display logs -->
    <div id="logs">
        <c:forEach items="${logs}" var="log">
            <p>${log}</p>
        </c:forEach>
    </div>



</body>
</html>
