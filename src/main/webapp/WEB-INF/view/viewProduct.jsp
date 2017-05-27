<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="/WEB-INF/view/template/header.jsp" %>


    <div class="container-wrappper">
    <div class="container">
    <div class="page-header">
    <h1>Product</h1>
    <p class="lead">Product information</p>
    
    </div>
    
    <div class="container">
    <div class="row">
    <div class="col-md-5">
    <img src="<c:url value="/resources/images/${product.productId}.jpg" />"  alt="img"  style="width:100%; height:300px "/></div>
    <div class="col-md-5">
    <h3>${product.productName} </h3>
    <p>${product.productPrice} </p>
    <p>${product.productDescription}</p>
    </div>
    </div>
    
    </div>
 

<%@ include file="/WEB-INF/view/template/footer.jsp" %>
