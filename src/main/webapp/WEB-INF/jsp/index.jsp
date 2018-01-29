<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Bootstrap Form With Spring Mvc Example</title>

    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
    <script src="<c:url value="/resources/js/jquery-3.3.1.min.js" />"></script>
    <script src="<c:url value="/resources/js/popper.min.js" />"></script>
    <script src="<c:url value="/resources/js/bootstrap.js" />"></script>
    

</head>
<body>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />;
<div class="container-fluid">
    <div class="row-fluid">
        <div class="span12">
            <fieldset>
                <legend>Bootstrap Form With Spring Mvc Example</legend>

                <form class="form-horizontal" id="list">
                    <div class="control-group">
                        <label class="control-label">Age</label>
                        <div class="controls">
                            <input type="text" name="id" id="id" title="id" value="">
                        </div>
                    </div>
                    <div class="form-actions">
                        <button type="submit" class="btn btn-primary" data-toggle="modal" data-target="#exampleModalCenter" id="buton1">
                            Launch demo modal
                        </button>
                    </div>
                </form>
            </fieldset>
        </div>
    </div>
</div>
<div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered" role="document">
        <div class="modal-content">


                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLongTitle">Modal title</h5>

                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
            <form class="form-horizontal" id="guncel">
            <div class="modal-body">
                    <div id="student-detail">
                        <input type="text" name="name"  >
                        <input type="text" name="surname"  >
                        <input type="text" name="age"  >
                        <input type="text" name="id">
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-footer" id="update">Save changes</button>
                </div>
            </form>
        </div>
    </div>
</div>

<script>
    $(document).ready(function () {
        $("#buton1").on("click",function (event) {
            event.preventDefault();
            var form=$(this).closest("form");
            var id=form.find("input[name='id']").val();
            var url="${pageContext.request.contextPath}/student";
            $.ajax({
                type :"Post",
                url:url,
                data:{id:id},
                success: function (data){
                    var student = JSON.parse(data);
                    var detail_Student=$('#student-detail')
                    detail_Student.find("input[name='name']").val(student.name);
                    detail_Student.find("input[name='surname']").val(student.surname);
                    detail_Student.find("input[name='age']").val(student.age);
                    detail_Student.find("input[name='id']").val(student.id);
                }
            });
        });
        $("#update").on("click",function (event) {
            event.preventDefault();
            var form=$(this).closest("form");
            var name=   form.find("input[name='name']").val();
            var surname=form.find("input[name='surname']").val();
            var age=    form.find("input[name='age']").val();
            var  id=    form.find("input[name='id']").val();
            var url="${pageContext.request.contextPath}/update";
            console.log(id,name,surname,age);
            $.ajax({
                type:"post",
                url:url,
                data:{id:id,name:name,surname:surname,age:age},
                success:function (data) {
                    $('#exampleModalCenter').modal('hide');
                }
            });
        });
    });
</script>
</body>
</html>