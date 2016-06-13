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

        <table class="table">
            <thead>
            <tr>
                <th>#</th>
                <th class='text-center'>Client Name</th>
                <th class='text-center'>Rental Car</th>
                <th class='text-center'>Rent Date</th>
                <th class='text-center'>Return Date</th>
                <th class='text-center'>Status</th>
                <th class='text-center'>Action</th>
            </tr>
            </thead>
            <tbody>
            <jstl:set var="count" value="1" />
            <jstl:forEach items="${rentalList}" var="rental">
            <tr>
                <th scope="row">${count}</th>
                <td class='col-md-2 text-center'>${rental.client}</td>
                <td class='col-md-2 text-center'>${rental.car}-${rental.carType}</td>
                <td class='col-md-2 text-center'>${rental.rentDate}</td>
                <td class='col-md-2 text-center'>${rental.returnDate}</td>
                <td class='col-md-2 text-center'>${rental.rentalClose}</td>
                <td class='col-md-2 text-center'>
                    <form method="post" action="<jstl:url value="/rent-close"/>" class='col-md-6'>
                        <input type="hidden" value="${rental.id}"  name="rClose">
                        <input type="submit" class="btn bg-success" value="Close">
                    </form>
                    <form method="post" action="<jstl:url value="/rent-delete"/>" class='col-md-6'>
                        <input type="hidden" value="${rental.id}"  name="rDelete">
                        <input type="submit" class="btn bg-success" value="Delete">
                    </form>
                </td>
            </tr>
                <jstl:set var="count" value="${count+1}"/>
            </jstl:forEach>
            </tbody>
        </table>



    </section>

<footer style="padding: 15px; background-color: #FFF8DC" id="footer" class="text-center footer">
    Copyright © 2016 Sergiy Dreamcatcher.
    <br>Developed in Java

</footer>

</body>
</html>
