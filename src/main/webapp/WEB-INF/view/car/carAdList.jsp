<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="/WEB-INF/view/template/header.jsp"%>

<link href="<c:url value="/resources/css/my.css" />" rel="stylesheet" />



<div class="container-wrappper">
	<div class="container">
		<div class="page-header">
			<h1>All Add list</h1>
			<p class="lead"></p>

		</div>


		<div>
			<div class="form-group">
				<label for="carMake"> Car Make</label>
				<select id="carMake">
					<option value="" label="--- Select ----" />
					<options items="${carMake}" />
				</select>
			</div>



<!-- 			<div class="form-group"> -->
<!-- 				<label for="carModel"> Car Model</label> -->
<%-- 				<form:select path="" id="carModel"> --%>
<%-- 					<form:option value="" label="--- Select ----" /> --%>
<%-- 					<form:options items="${carMakeModel}" /> --%>
<%-- 				</form:select> --%>
<!-- 			</div> -->


		</div>

		<table class="table table-striped table-hover">
			<thead>
				<tr class="bg-success">
					<th>Photo</th>
					<th>Car Add Title</th>
					<th>Price</th>
					<th>Description</th>
					<th></th>
				</tr>
			</thead>
			<c:forEach items="${caradlist}" var="carad">
				<tr>
					<td class="listImg"><img
						src="<c:url value="/resources/images/${carad.id}/${carad.firstImageId}.jpg" />"
						alt="image" style="width: 100%" /></td>
					<td></td>
					<td>${carad.adtitle}</td>
					<td>${carad.price}</td>
					<td>${carad.descr}</td>
				</tr>
			</c:forEach>
		</table>


		<%@ include file="/WEB-INF/view/template/footer.jsp"%>