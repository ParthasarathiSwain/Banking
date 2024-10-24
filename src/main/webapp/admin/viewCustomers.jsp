<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ page session="true" %>
<%@ page import="com.otz.util.DbConnection" %>
<%
if (session.getAttribute("username") == null || session.getAttribute("username").equals(""))
{
	response.sendRedirect("adminLogin.jsp");
}

String tempPath=DbConnection.Path();
String Path =tempPath.substring(tempPath.length() - 13);
%>
<!DOCTYPE html>
<html lang="en" class="semi-dark">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="icon" href="assets/images/favicon-32x32.png" type="image/png" />
<!--plugins-->
<link href="assets/plugins/vectormap/jquery-jvectormap-2.0.2.css"
	rel="stylesheet" />
<link href="assets/plugins/simplebar/css/simplebar.css" rel="stylesheet" />
<link href="assets/plugins/perfect-scrollbar/css/perfect-scrollbar.css"
	rel="stylesheet" />
<link href="assets/plugins/metismenu/css/metisMenu.min.css"
	rel="stylesheet" />
<!-- Bootstrap CSS -->
<link href="assets/css/bootstrap.min.css" rel="stylesheet" />
<link href="assets/css/bootstrap-extended.css" rel="stylesheet" />
<link href="assets/css/style.css" rel="stylesheet" />
<link href="assets/css/icons.css" rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500&display=swap"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">

<!--toast-->
<link href="assets/plugins/jquery-toast/src/jquery.toast.css"
	rel="stylesheet" />
<link href="assets/plugins/jquery-toast/dist/jquery.toast.min.css"
	rel="stylesheet" />

<!-- loader-->
<link href="assets/css/pace.min.css" rel="stylesheet" />

<!--Theme Styles-->
<link href="assets/css/dark-theme.css" rel="stylesheet" />
<link href="assets/css/light-theme.css" rel="stylesheet" />
<link href="assets/css/semi-dark.css" rel="stylesheet" />
<link href="assets/css/header-colors.css" rel="stylesheet" />

<title>ADMIN-VIEW CUSTOMERS</title>
</head>
<body>
	<!--start wrapper-->
	<div class="wrapper">
		<%@include file="include/header.jsp"%>
		<%@include file="include/sidebar.jsp"%>

		<!--start content-->
		<main class="page-content">
			<!--breadcrumb-->
			<div class="page-breadcrumb d-none d-sm-flex align-items-center mb-3">
				<div class="breadcrumb-title pe-3">BANK</div>
				<div class="ps-3">
					<nav aria-label="breadcrumb">
						<ol class="breadcrumb mb-0 p-0">
							<li class="breadcrumb-item"><a href="javascript:;"><i
									class="bx bx-home-alt"></i></a></li>
							<li class="breadcrumb-item active" aria-current="page">VIEW CUSTOMERS</li>
						</ol>
					</nav>
				</div>
			</div>
			<!-- breadcrumb end -->
			<div class="card">
				
				<div class="card-body">

					 <div class="d-flex align-items-center">
                      <h5 class="mb-0">Customer Details</h5>
                       <form class="ms-auto position-relative">
                         <div class="position-absolute top-50 translate-middle-y search-icon px-3"><i class="bi bi-search"></i></div>
                         <input class="form-control ps-5" type="text" placeholder="search">
                       </form>
                   </div>
                   <div class="table-responsive mt-3">
                     <table class="table align-middle">
                       <thead class="table-secondary">
                         <tr>
                          <th>#</th>
                          <th>Customer Name</th>
                          <th>Email</th>
                          <th>DOB</th>                         
                          <th>Phone</th>
                          <th>UserId</th>
                          <th>Password</th>
                          <th>Redg Date</th>
                          <th>Address</th>
                          <th>Active Location</th>
                          <th>Actions</th>
                         </tr>
                       </thead>
                       <tbody  id="viewBank">
                       		
                       </tbody>
                    </table>
				</div>
			</div>

			<!-- row start -->
			<!--end row-->
		</main>
		<!-- content end -->
		<!--start switcher-->
		<div class="switcher-body">
			<button class="btn btn-primary btn-switcher shadow-sm" type="button"
				data-bs-toggle="offcanvas" data-bs-target="#offcanvasScrolling"
				aria-controls="offcanvasScrolling">
				<i class="bi bi-paint-bucket me-0"></i>
			</button>
			<div class="offcanvas offcanvas-end shadow border-start-0 p-2"
				data-bs-scroll="true" data-bs-backdrop="false" tabindex="-1"
				id="offcanvasScrolling">
				<div class="offcanvas-header border-bottom">
					<h5 class="offcanvas-title" id="offcanvasScrollingLabel">Theme
						Customizer</h5>
					<button type="button" class="btn-close text-reset"
						data-bs-dismiss="offcanvas"></button>
				</div>
				<div class="offcanvas-body">
					<h6 class="mb-0">Theme Variation</h6>
					<hr>
					<div class="form-check form-check-inline">
						<input class="form-check-input" type="radio"
							name="inlineRadioOptions" id="LightTheme" value="option1">
						<label class="form-check-label" for="LightTheme">Light</label>
					</div>
					<div class="form-check form-check-inline">
						<input class="form-check-input" type="radio"
							name="inlineRadioOptions" id="DarkTheme" value="option2">
						<label class="form-check-label" for="DarkTheme">Dark</label>
					</div>
					<div class="form-check form-check-inline">
						<input class="form-check-input" type="radio"
							name="inlineRadioOptions" id="SemiDarkTheme" value="option3"
							checked> <label class="form-check-label"
							for="SemiDarkTheme">Semi Dark</label>
					</div>
					<hr>
					<div class="form-check form-check-inline">
						<input class="form-check-input" type="radio"
							name="inlineRadioOptions" id="MinimalTheme" value="option3">
						<label class="form-check-label" for="MinimalTheme">Minimal
							Theme</label>
					</div>
					<hr />
					<h6 class="mb-0">Header Colors</h6>
					<hr />
					<div class="header-colors-indigators">
						<div class="row row-cols-auto g-3">
							<div class="col">
								<div class="indigator headercolor1" id="headercolor1"></div>
							</div>
							<div class="col">
								<div class="indigator headercolor2" id="headercolor2"></div>
							</div>
							<div class="col">
								<div class="indigator headercolor3" id="headercolor3"></div>
							</div>
							<div class="col">
								<div class="indigator headercolor4" id="headercolor4"></div>
							</div>
							<div class="col">
								<div class="indigator headercolor5" id="headercolor5"></div>
							</div>
							<div class="col">
								<div class="indigator headercolor6" id="headercolor6"></div>
							</div>
							<div class="col">
								<div class="indigator headercolor7" id="headercolor7"></div>
							</div>
							<div class="col">
								<div class="indigator headercolor8" id="headercolor8"></div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!--end switcher-->

	</div>
	<!--End wrapper-->
	 <!--Edit Modal dept-->
		<div class="modal fade" id="editModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
		  <div class="modal-dialog" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title" id="exampleModalLabel">Edit Customer</h5>
		        <button type="button" class="close" data-bs-dismiss="modal" aria-label="Close">
		          <span aria-hidden="true">&times;</span>
		        </button>
		      </div>
		      <div class="modal-body">
		       <div class="card-body">
		           <div class="border p-3 rounded">
		               <form id="updateCustomer"  onsubmit="getLocationAndSubmitForm(event)">
								<div class="mb-3">
									<label for="custfname" class="form-label">Customer First Name</label>
									<input class="form-control " name="custfname"  type="text" required placeholder="First Name" id="custfname" >
									<input  type="hidden" name="event" value="updateCustomer" >
									<input  type="hidden" id="custId" name="custId" value="" >
								</div>
								<div class="mb-3">
									<label for="custlname" class="form-label">Customer Last Name</label>
									<input class="form-control " name="custlname"  type="text" required placeholder="Last Name" id="custlname" >
									
								</div>
								<div class="mb-3">
									<label for="custemail" class="form-label">Customer Email</label>
									<input class="form-control " name="custemail" type="text" required placeholder="Enter Customer Email" id="custemail" >
								</div>
								<div class="mb-3">
									<label for="custpass" class="form-label">Customer Password</label>
									<input class="form-control " name="custpass"  type="text" required placeholder="Enter Customer Password" id="custpass" >
								</div>
								<div class="mb-3">
									<label for="custdob" class="form-label">Customer Dob</label>
									<input class="form-control " name="custdob"  type="date" required placeholder="Enter Customer DOB" id="custdob" >
								</div>
								<div class="mb-3">
									<label for="custphone" class="form-label">Customer Phone</label>
									<input class="form-control " name="custphone"  type="text" required placeholder="Enter Customer Phone" id="custphone" >
								</div>
								<div class="mb-3">
									<label for="custadd" class="form-label">Customer Address</label>
									<textarea class="form-control " name="custadd"  type="text" required placeholder="Enter Customer Phone" id="custadd" ></textarea>
								</div>
								<div class="mb-3">
									<label for="formFileMultiple" class="form-label">Photo</label>
									<input class="form-control" name="custimg" type="file" required id="formFileMultiple" multiple>
								</div>
								<div class="mb-3">
								
									<input class="form-control btn btn-primary" type="submit"  value="Update Customer">
								</div>
							</form>
								 
		            </div>
		        </div>
		         
		      </div>
		    </div>
		  </div>
		</div>
	<script src="assets/js/bootstrap.bundle.min.js"></script>
	<!--plugins-->
	<script src="assets/js/jquery.min.js"></script>
	<script src="assets/plugins/simplebar/js/simplebar.min.js"></script>
	<script src="assets/plugins/metismenu/js/metisMenu.min.js"></script>
	<script src="assets/plugins/perfect-scrollbar/js/perfect-scrollbar.js"></script>
	<script src="assets/js/pace.min.js"></script>
	<script src="assets/plugins/chartjs/js/Chart.min.js"></script>
	<script src="assets/plugins/chartjs/js/Chart.extension.js"></script>
	<script src="assets/plugins/apexcharts-bundle/js/apexcharts.min.js"></script>
	<!-- Vector map JavaScript -->
	<script src="assets/plugins/vectormap/jquery-jvectormap-2.0.2.min.js"></script>
	<script
		src="assets/plugins/vectormap/jquery-jvectormap-world-mill-en.js"></script>
	<!--  toast -->
	<script src="assets/plugins/jquery-toast/src/jquery.toast.js"></script>
	<script src="assets/plugins/jquery-toast/dist/jquery.toast.min.js"></script>
	<!--app-->
	<script src="assets/js/app.js"></script>
	<script src="assets/js/index.js"></script>
	

	<!--app-->
<script type="text/javascript">
		$(document).ready(function() {
				getData();
				function getData(){
	        	let event ="event=viewCustomers";
	        	$.ajax({
	    			url:"../custServlet",
	    			data:event,
	    			type:"POST",
	    			dataType:"json",
	    			success:function(data,textStatus,jqXHR){ 					 
	    				console.log(data);	    				
	    				 let s="";
	    				 let i=1;
	    				for (var key in data) {
	    					if (data.hasOwnProperty(key)) {
	    					  s+="<tr>";
	    					  s+="<td>"+i+"</td>";
	    					  s+="<td><div class='d-flex align-items-center gap-3 cursor-pointer'>";
	    					  s+="<img src='assets/custImg/"+data[key].custImg+"'class='product-box' width='44' height='44' alt=''>";
	    					  s+="<div class=''><p class='mb-0'>"+data[key].custFname+" "+data[key].custLname+"</p></div></div> </td>";
	    					  s+="<td>"+data[key].custEmail+"</td>";
	    					  s+="<td>"+data[key].custDOB+"</td>";
	    					  s+="<td>"+data[key].custPhone+"</td>";
	    					  s+="<td>"+data[key].custUserId+"</td>";
	    					  s+="<td>"+data[key].custPass+"</td>";
	    					  s+="<td>"+data[key].custRedgDate+"</td>";
	    					  s+="<td>"+data[key].custAddress+"</td>";
	    					  s+="<td>Lo-"+data[key].longitude+"<br>La-"+data[key].latitude+"</td>";
	    					  s+="<td><div class='table-actions d-flex align-items-center gap-3 fs-6'>";
	    					  s+="<a  class='text-info cust_edit' data-bs-toggle='tooltip' data-bs-placement='bottom' title='Edit' data-id='"+data[key].custId+"' id='"+data[key].custId+"'><i class='bi bi-pencil-fill'></i></a>";
	    					  s+="<a  class='text-danger cust_delete' data-bs-toggle='tooltip' data-bs-placement='bottom' title='Delete' data-id='"+data[key].custId+"' id='"+data[key].custId+"'><i class='bi bi-trash-fill'></i></a>";
	    					  s+="</div></td></tr>";
	    					}
	    					i++;
	    				}
	    				$('#viewBank').html(s);
	    				console.log("success...")
	    	  		},
	    		error:function(jqXHR,textStatus,errorThrown){
	    			console.log(jqXHR.responseText);
	    				console.log("error...")
	    			}
	    	    });
			  }
				 $(document).on('click', '.cust_delete', function() {
					 custId = $(this).attr('id');
	                 if (confirm('Are you sure you want to delete this?')) {
	              $.ajax({
					    type:'POST',
					    url:'../custServlet',
						data:{'custId':custId,'event':'cust_delete'},
						method:'POST',
						dataType:'JSON',
						success:function(data,textStatus,jqXHR){
	  						if(data.trim() ==='done'){	  							
	  							$.toast({
	  		  					    text: "Successfully Deleted!", 
	  		  					    heading: 'Success...', 
	  		  					    icon: 'success',
	  		  					    showHideTransition: 'slide', 
	  		  					    allowToastClose: true, 
	  		  					    hideAfter: 3000, 
	  		  					    stack: 10, 
	  		  					    position: 'top-center',            
	  		  					    textAlign: 'left',  
	  		  					    loader: true,  
	  		  					    loaderBg: '#24ffb6',
	  		  					});
		  		  				$('#msg').html("");
		  		  			    $('#viewBank').html('');
		  		  			    getData();
	  		  				}else{
	  		  				$.toast({
				  		  	    text: "Something went wrong on server!", 
				  		  	    heading: 'Failed...', 
				  		  	    icon: 'error', 
				  		  	    showHideTransition: 'slide', 
				  		  	    allowToastClose: true, 
				  		  	    hideAfter: 3000, 
				  		  	    stack: 10, 
				  		  	    position: 'top-center',         
				  		  	    textAlign: 'left',  
				  		  	    loader: true,
				  		  	    loaderBg: '#9EC600', 
				  		  	});
		  		  			}
	  				},
					error:function(jqXHR,textStatus,errorThrown){
						console.log("error...");
						$.toast({
			  		  	    text: "Something went wrong on server!", 
			  		  	    heading: 'Failed...', 
			  		  	    icon: 'error', 
			  		  	    showHideTransition: 'slide', 
			  		  	    allowToastClose: true, 
			  		  	    hideAfter: 3000, 
			  		  	    stack: 10, 
			  		  	    position: 'top-center',         
			  		  	    textAlign: 'left',  
			  		  	    loader: true,
			  		  	    loaderBg: '#9EC600', 
			  		  	});
	  		  		  }
				    });	
	              } //confirm end   
			  });
	        });
		</script>
		<script>
			 $(document).on('click', '.cust_edit', function() {
				 custId = $(this).attr('id');                	 
                	$("#editModal").modal("show");
				$.ajax({
				    type:'POST',
				    url:'../custServlet',
					data:{'custId':custId,'event':'fatchCustById'},
					method:'POST',
					dataType:'JSON',
					success:function(data,textStatus,jqXHR){
						$("#custId").val(data[0].custId);
	    				$("#custfname").val(data[0].custFname);
	    				$("#custlname").val(data[0].custLname);
	    				$("#custemail").val(data[0].custEmail);
	    				$("#custpass").val(data[0].custPass);
	    				$("#custdob").val(data[0].custDOB);
	    				$("#custphone").val(data[0].custPhone);
	    				$("#custadd").val(data[0].custAddress);
	    				$("#formFileMultiple").val(data[0].custImg);
  				},
				error:function(jqXHR,textStatus,errorThrown){
					$.toast({
		  		  	    text: "Something went wrong on server!", 
		  		  	    heading: 'Failed...', 
		  		  	    icon: 'error', 
		  		  	    showHideTransition: 'slide', 
		  		  	    allowToastClose: true, 
		  		  	    hideAfter: 3000, 
		  		  	    stack: 10, 
		  		  	    position: 'top-center',         
		  		  	    textAlign: 'left',  
		  		  	    loader: true,
		  		  	    loaderBg: '#9EC600', 
		  		  	});
  				}
			});	
                	   
		 });
     </script>
     <script>
        function getLocationAndSubmitForm(event) {
            // Prevent the default form submission
            event.preventDefault();

            // Get the current location
            if (navigator.geolocation) {
                navigator.geolocation.getCurrentPosition(function(position) {
                    var latitude = position.coords.latitude;
                    var longitude = position.coords.longitude;
                    var formData = new FormData($('#updateCustomer')[0]);

                    // Append latitude and longitude to FormData object
                    formData.append('latitude', latitude);
                    formData.append('longitude', longitude);
                    // Send location and form data to Servlet using AJAX
                    $.ajax({
                        url: '../custServlet',
                        type: 'POST',
                        data: formData,
                        async: false,
                        success: function(data,textStatus,jqXHR){
                        	if(data.trim() ==='done'){
                        		window.location.href = 'viewCustomers.jsp';			  				
			  		  		}else{
					  		  		$.toast({
					  		  	    text: "Something went wrong on server!", 
					  		  	    heading: 'Failed...', 
					  		  	    icon: 'error', 
					  		  	    showHideTransition: 'slide', 
					  		  	    allowToastClose: true, 
					  		  	    hideAfter: 3000, 
					  		  	    stack: 10, 
					  		  	    position: 'top-center',         
					  		  	    textAlign: 'left',  
					  		  	    loader: true,
					  		  	    loaderBg: '#9EC600', 
					  		  	});
			  		  		}
                        },
                        cache: false,
		  		        contentType: false,
		  		        processData: false,
                        error: function(jqXHR,textStatus,errorThrown){
                        	$.toast({
				  		  	    text: "Something went wrong on server!", 
				  		  	    heading: 'Failed...', 
				  		  	    icon: 'error', 
				  		  	    showHideTransition: 'slide', 
				  		  	    allowToastClose: true, 
				  		  	    hideAfter: 3000, 
				  		  	    stack: 10, 
				  		  	    position: 'top-center',         
				  		  	    textAlign: 'left',  
				  		  	    loader: true,
				  		  	    loaderBg: '#9EC600', 
				  		  	});
                        }
                    });
                    return false;
                });
            } else {
                alert("Geolocation is not supported by this browser.");
            }
        }
    </script>
     
</body>
</html>