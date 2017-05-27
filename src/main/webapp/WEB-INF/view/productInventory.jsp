<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="/WEB-INF/view/template/header.jsp" %>


    <div class="container-wrappper">
    <div class="container">
    <div class="page-header">
    <h1>All Product</h1>
    <p class="lead">Product Inventory </p>
    
    </div>
    
    <table class="table table-striped table-hover" >
    <thead>
    <tr class="bg-success">
    <th>Photo </th>
    <th>Product Name </th>
    <th>Category  </th>
    <th>Price </th>
    <th></th>
    </tr>
    </thead>
    <c:forEach items="${products}" var="product">
    <tr>
    <td> <img src="<c:url value="/resources/images/${product.productId}.jpg" />" alt="image" style="width:100%"/></td>
    <td>${product.productName}</td>
    <td>${product.productCategory}</td>
    <td>${product.productPrice}</td>
    <td><a href="<spring:url value="/productlist/details/${product.productId}"/>"><span class="glyphicon glyphicon-info-sign"></span></a>
        <a href="<spring:url value="/admin/productInventory/deleteProduct/${product.productId}"/>"><span class="glyphicon glyphicon-remove"></span></a>
    </td>
    </tr>
    </c:forEach>
    </table>
 
 <a href="<spring:url value="/admin/productInventory/addProduct"/>"  class="btn btn-primary"> Add product </a>
<%@ include file="/WEB-INF/view/template/footer.jsp" %>
