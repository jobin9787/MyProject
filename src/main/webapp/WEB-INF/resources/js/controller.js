
 $("#fileUpload").on('change', function () {

         if (typeof (FileReader) != "undefined") {

             var image_holder = $("#image-holder");
             image_holder.empty();

             var reader = new FileReader();
             reader.onload = function (e) {
                 $("<img />", {
                     "src": e.target.result,
                     "class": "thumb-image"
                 }).appendTo(image_holder);

             }
             image_holder.show();
             reader.readAsDataURL($(this)[0].files[0]);
         } else {
             alert("This browser does not support FileReader.");
         }
     });
 
 
 
 
 
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

		 
		 for( var key in map ) {
			 
			 if (map.hasOwnProperty(key)) {
				    console.log(key + " -> " + map[key]);
				    html += '<option value="' + key + '">' + map[key] + '</option>';
				  }

			 
			 
			    }
	        $("#carModel").html(html);
		 

	}

	
	
	// **
	$(document).ready(function() {
		  if (window.File && window.FileList && window.FileReader) {
		    $("#files").on("change", function(e) {
		      var files = e.target.files,
		        filesLength = files.length;
		      var thistarget=this;
		        var f = files[0]
		        var fileReader = new FileReader();
		        fileReader.onload = (function(e) {
		          var file = e.target;
		          $("<span class=\"pip\">" +
		            "<img class=\"imageThumb\" src=\"" + e.target.result + "\" title=\"" + file.name + "\"/>" +
		            "<br/><span class=\"remove\">Remove image</span>" +
		            "</span>").insertAfter("#files");
		          $(".remove").click(function(){
		            $(this).parent(".pip").remove();
		            $(".imageThumb").attr("src","");
		            $(".imageThumb").attr("title","");
		            $(thistarget).show();
		          });
		          $(thistarget).hide();
		          // Old code here
		          /*$("<img></img>", {
		            class: "imageThumb",
		            src: e.target.result,
		            title: file.name + " | Click to remove"
		          }).insertAfter("#files").click(function(){$(this).remove();});*/
		          
		        });
		        fileReader.readAsDataURL(f);
		      
		    });
		  } else {
		    alert("Your browser doesn't support to File API")
		  }
		});   
 
