<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="/WEB-INF/view/template/header.jsp" %>


    <div class="container-wrappper">
    <div class="container">
    <div class="page-header">
    <h1>Add Product</h1>
    <p class="lead">Add New Product </p>
    

 <form:form action="${pageContext.request.contextPath}/admin/productInventory/addProduct" method="post" commandName="product" enctype="multipart/form-data">
 <div class="form-group">
 
 <label for="name">Product Name</label>
 <form:input path="productName" id="name" class="form-control"/>
 </div>
 
 <div class="form-group">
 <label for="category"> Category</label>
   <label class="checkbox-inline" ><form:radiobutton id="category" path="productCategory" value="instrument"/>Instrument</label>
   <label class="checkbox-inline" ><form:radiobutton id="category" path="productCategory" value="record"/>Record</label>
   <label class="checkbox-inline" ><form:radiobutton id="category" path="productCategory" value="accessory"/>Accessory</label>
 </div>
 
 <div class="form-group">
 <label for="descreption">Description</label>
 <form:textarea path="productDescription"  id="description" class="form-control"/>
 </div>
 
 
 <div class="form-group">
 <label for="price"> Price</label> 
 <form:input path="productPrice" id="price" class="form-control"/>
 </div>
 
 <div class="form-group">
 <label for="condition"> Conditon</label>
   <label class="checkbox-inline" ><form:radiobutton id="condition" path="productCondition" value="new"/>New</label>
   <label class="checkbox-inline" ><form:radiobutton id="condition" path="productCondition" value="used"/>Used</label>
 
 </div>
 
 <div class="form-group">
 <label for="status"> Status</label>
   <label class="checkbox-inline" ><form:radiobutton id="status" path="productStatus" value="active"/>Active</label>
   <label class="checkbox-inline" ><form:radiobutton id="status" path="productStatus" value="inactive"/>Inactive</label>
 </div>
 
 <div class="form-group">
 <label for="stock"> Unit in Stock</label> 
 <form:input path="productUnitInStock" id="stock" class="form-control"/>
 </div>
 
 <div class="form-group">
 <label for="manufacturer">Manufacturer</label> 
 <form:input path="productManufacturer" id="manufacturer" class="form-control"/>
 </div>
 
 <div class="form-group">
 <label for="productImage" class="control-label">Upload Image</label> 
 <form:input path="productImage" id="productImage" type="file" class="form:input-large"/>
 </div>
 
 <br><br>
 
 <input type="submit" class="btn btn-default">
 <a href="<c:url value="/admin/productInventory"  />" class="btn btn-default">Cancel</a>
 </form:form>

<%@ include file="/WEB-INF/view/template/footer.jsp" %>
