<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">


    <link rel="stylesheet" href="<jstl:url value="/resources/css/bootstrap.min.css"/>"/>
    <link rel="stylesheet" href="<jstl:url value="/resources/css/sticky-footer.css"/>"/>
    <link rel="stylesheet" href="<jstl:url value="/resources/css/bootstrap-theme.min.css"/>"/>
    <link rel="stylesheet" href="<jstl:url value="/resources/css/style.css"/>"/>
    <link rel="stylesheet" href="<jstl:url value="/resources/css/bootstrap-datetimepicker.css"/>"/>

    <script src="<jstl:url value="/resources/js/jquery-2.1.4.js"/> "></script>
    <script src="<jstl:url value="/resources/js/bootstrap.min.js"/> "></script>
    <script src="<jstl:url value="/resources/js/moments.js"/> "></script>
    <script src="<jstl:url value="/resources/js/bootstrap-datetimepicker.min.js"/> "></script>




</head>
<body>
<header class = "page-header" style="background-color: #FFF8DC">

    <h1 class="text-center bac">
        Test Task
    </h1>

</header>


<aside class="col-md-2" style="background-color: #FFF8DC">
    <ul class="nav nav-pills nav-stacked">
        <li class="nav-item">
            <a class="nav-link active" href="<jstl:url value="/"/>">Home</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="<jstl:url value="/create-page"/>">Create</a>
        </li>

    </ul>
</aside>

<section class="col-md-10">
    <form action="<jstl:url value="/create-rental"/>" method="post" role="form" class='col-md-5' style="background-color: #FFF8DC; margin: 3px;">
        <h3 class="text-center">Car rental form</h3>
        <div>
            <div class='col-md-6'>
                <input name="startDate" type='date' class="form-control"  />
            </div>
            <div class='col-md-6'>
                <input name="stopDate" type='date' class="form-control"  />
            </div>
        </div>
        <br><br>
        <div class='col-md-12'>
            <div class='col-md-6'>
                <span class="text-center">Available Cars</span>
                <select name="car" class="form-control" size="5">
                    <jstl:forEach items="${cars}" var="car">
                        <option value="${car.id}">${car.name}-${car.type}</option>
                    </jstl:forEach>

               </select>
            </div>
            <div class='col-md-6'>
                <span class="text-center">Clients</span>
            <select name="client" class="form-control" size="5">
                <jstl:forEach items="${clients}" var="client">
                    <option value="${client.id}">${client.name}-${client.address}</option>
                </jstl:forEach>

            </select>
            </div>
        </div>
        <input type="submit" class="btn bg-success pull-right" value="Save">
    </form>

    <form action="<jstl:url value="/create-car"/>" method="post" role="form" class='col-md-5' style="background-color: #FFF8DC; margin: 3px;">
        <h3 class="text-center">Create new car</h3>
        <div class='col-md-5'>
            <div>Car name</div>
            <input type="text" name="carName" class='col-md-12'>
        </div>
        <div class='col-md-4'>
            <div>Car Type</div>
            <input type="text" name="carType" class='col-md-12'>
        </div>
        <div class='col-md-3'>
            <div>Cost per day</div>
            <input type="text" name="costDay" class='col-md-12'>
        </div>
        <input type="submit" class="btn bg-success pull-right" value="Save">

    </form>

    <form action="<jstl:url value="/create-client"/>" method="post" role="form" class='col-md-5' style="background-color: #FFF8DC; margin: 3px;">
        <h3 class="text-center">Create new client</h3>
        <div class='col-md-5'>
            <div>Client name</div>
            <input type="text" name="clientName" class='col-md-12'>
        </div>
        <div class='col-md-7'>
            <div>Client Address</div>
            <input type="text" name="clientAddress" class='col-md-12'>
        </div>
        <input type="submit" class="btn bg-success pull-right" value="Save">

    </form>


</section>

<footer style="padding: 15px; background-color: #FFF8DC" id="footer" class="text-center footer">
    Copyright © 2016 Sergiy Dreamcatcher.
    <br>Developed in Java

</footer>

</body>
</html>
