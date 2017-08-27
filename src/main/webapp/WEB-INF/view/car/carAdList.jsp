<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="/WEB-INF/view/template/header.jsp"%>

<link href="<c:url value="/resources/css/my.css" />" rel="stylesheet" />



<div class="container-wrappper">
	<div class="container">
		<div class="page-header">
			<h1>All Add list</h1>
			<p class="lead"></p>

		</div>

			<form:form action="${pageContext.request.contextPath}/car/addCarAd"
				method="post" commandName="carSearch" enctype="multipart/form-data">

		<div>
				<div class="form-group">
					<label for="carMake"> Car Make</label>
					<form:select path="make" id="carMake">
						<form:option value="" label="--- Select ----" />
						<form:options items="${carMake}" />
					</form:select>
				</div>



				<div class="form-group">
					<label for="carModel"> Car Model</label>
					<form:select path="model" id="carModel">
						<form:option value="" label="--- Select ----" />
						<form:options items="${carMakeModel}" />
					</form:select>
				</div>


		</div>
     </form:form>
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

			<script
				src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
			 

			<script src="<c:url value="/resources/js/controller.js"/>"></script>
		<%@ include file="/WEB-INF/view/template/footer.jsp"%>