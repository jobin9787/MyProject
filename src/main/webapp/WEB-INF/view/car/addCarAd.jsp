<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="/WEB-INF/view/template/header.jsp" %>
<c:url var="home" value="/" scope="request" />

    <div class="container-wrappper">
    <div class="container">
    <div class="page-header">
    <h1>Add Product</h1>
    <p class="lead">Add New Product </p>
    

 <form:form action="${pageContext.request.contextPath}/car/addCarAd" method="post" commandName="carAd" enctype="multipart/form-data">
 <div class="form-group">
 
 <label for="adtitle">Add Title</label>
 <form:input path="adtitle" id="adtitle" class="form-control"/>
 </div>
 
 <div class="form-group">
 <label for="soldBy"> Sold By</label>
   <label class="checkbox-inline" ><form:radiobutton id="soldBy" path="soldby" value="deal"/>Dealer</label>
   <label class="checkbox-inline" ><form:radiobutton id="soldBy" path="soldby" value="prop"/>Record</label>
  
 </div>
 
 <div class="form-group">
 <label for="carMake"> Car Make</label>
  <form:select path="make" id="carMake">
  <form:option value="" label="--- Select ----"/>
  <form:options items="${carMake}"/>
  </form:select>
  
  </div>
  
  
   
 <div class="form-group">
 <label for="carModel"> Car Model</label>
  <form:select path="model" id="carModel">
  <form:option value="" label="--- Select ----"/>
  <form:options items="${carMakeModel}"/>
  </form:select>
 </div>
 
 <div class="form-group">
 <label for="descreption">Description</label>
 <form:textarea path="descr"  id="description" class="form-control"/>
 </div>
 
 
 <div class="form-group">
 <label for="price"> Price</label> 
 <form:input path="price" id="price" class="form-control"/>
 </div>
 
 <div class="form-group">
 <label for="firstImage" class="control-label">Upload Image</label> 
 <form:input path="carImage" id="firstImage" type="file" class="form:input-large"/>
 </div>
 
 <br><br>
 
 <input type="submit" class="btn btn-default">
 <a href="<c:url value="/car/addCarAd"  />" class="btn btn-default">Cancel</a>
 </form:form>
 
 
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script>
 $(document).ready(function(){
 
 $("#carMakev").change(function(){
	    var carMakeVal = $(this).val();
	    
	    alert(carMakeVal);
	    $.ajax({
	        type: "GET",
	        contentType:"application/json",
	        url: "http://localhost:8080/MyProject/car/getModel",
	        dataType:'json',
	        data: {"carMakeVal" : carMakeVal },
	        
	        
	        success: function(data){
	        	 console.log("succes",data);
// 	        	var slctcarModel = $("#carModel"), option= "";
// 	            slctcarModel.empty();
	           
// 	            for(var sb =0; sb<data.length; sb++){
// 	                option = option + "<option value='" + data[sb].name + "'>" +data[sb].name + "</option>";
// 	            }
// 	            slctcarModel.append(option);
	        },
	        error:function(){
	           alert("error");
	        }
	   });

	});
 });
 
 </script>
 
 <script>
	jQuery(document).ready(function($) {

		$("#carMake").change(function(event) {

			 var carMakeVal = $(this).val();

			// Prevent the form from submitting via the browser.
			event.preventDefault();

			searchViaAjax(carMakeVal);

		});

	});

	function searchViaAjax(carMakeVal1) {
		
		var search = {}
		search["name"] =carMakeVal1 ;
// 		search["email"] = $("#email").val();

		$.ajax({
			type : "POST",
			contentType : "application/json",
			url : "http://localhost:8080/MyProject/car/getModel",
			data :JSON.stringify(search),
			dataType : 'json',
			timeout : 100000,
			success : function(data) {
				console.log("SUCCESS: ", data);
				display(data);
				
				
				
			},
			error : function(e) {
				console.log("ERROR: ", e);
				display(e);
			},
			done : function(e) {
				console.log("DONE");
				enableSearchButton(true);
			}
		});

	}

	function enableSearchButton(flag) {
		$("#btn-search").prop("disabled", flag);
	}

	function display(data) {
		
		 var html = '<option value="">---NONE---</option>';
		 var map =data.mapResult;
		 for (var i = 0; i < map.length; i++) {
// 	            html += '<option value="' + map[i].key + '">' + map[i].value + '</option>';
	       alert(i);
		 
		 }
		 
		 for( var key in map ) {
			 
			 if (map.hasOwnProperty(key)) {
				    console.log(key + " -> " + map[key]);
				    html += '<option value="' + key + '">' + map[key] + '</option>';
				  }

			 
			 
			    }
	        $("#carModel").html(html);
		 

	}
</script>
 
 

<%@ include file="/WEB-INF/view/template/footer.jsp" %>
