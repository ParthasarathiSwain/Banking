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

<title>ADMIN-VIEW BANK</title>
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
							<li class="breadcrumb-item active" aria-current="page">VIEW BANK</li>
						</ol>
					</nav>
				</div>
			</div>
			<!-- breadcrumb end -->
			<div class="card">
				
				<div class="card-body">

					 <div class="d-flex align-items-center">
                      <h5 class="mb-0">Bank Details</h5>
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
                          
                          <th>Branch Name</th>
                          <th>Head Office</th>
                          <th>Location</th>
                          <th>Created Date</th>
                          <th>Created By</th>
                          <th>Updated By</th>
                          <th>Updated Date</th>
                          <th>Status</th>
                          <th>Actions</th>
                         </tr>
                       </thead>
                       <tbody  id="viewBranch">
                       		
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
		        <h5 class="modal-title" id="exampleModalLabel">Edit Branch</h5>
		        <button type="button" class="close" data-bs-dismiss="modal" aria-label="Close">
		          <span aria-hidden="true">&times;</span>
		        </button>
		      </div>
		      <div class="modal-body">
		       <div class="card-body">
		           <div class="border p-3 rounded">
		               <form id="updatebranch">
								
								
								<div class="mb-3">
									<label for="branchname" class="form-label">Branch Name</label>
									<input class="form-control " name="branchname" type="text" required placeholder="Enter Branch Email" id="branchname" >
									<input  type="hidden" name="event" value="updateBranch" >
									<input  type="hidden" id="branchid" name="branchid" value="" >
								</div>
								<div class="mb-3">
									<label for="location" class="form-label">Location</label>
									<input class="form-control " name="location"  type="text" required placeholder="Enter Branch Location" id="location" >
								</div>
								<div class="mb-3">
									<label for="createdby" class="form-label">Created By</label>
									<input class="form-control" name="createdby" type="text" required id="createdby" >
								</div>
								<div class="mb-3">
									<label for="updatedby" class="form-label">Updated By</label>
									<input class="form-control" name="updatedby" type="text" required id="updatedby" >
								</div>
								<div class=" mb-3">
									<input class="form-check-input" name="isActive" value="1" type="radio" required id="isActive" >&nbsp;&nbsp;<b>Active</b>&nbsp;
									<input class="form-check-input" name="isActive"  value="0" type="radio" required id="isActive" >&nbsp;&nbsp;&nbsp;<b>Deactive</b>
								</div>
								<div class="mb-3">
								
									<input class="form-control btn btn-primary" type="submit" value="Update Branch" >
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
	        	let event ="event=getBranches";
	        	$.ajax({
	    			url:"../branchServlet",
	    			data:event,
	    			type:"POST",
	    			dataType:"json",
	    			success:function(data,textStatus,jqXHR){ 					 
	    				console.log(data);	    				
	    				 let s="";
	    				 let i=1;
	    				for (var key in data) {
	    					if (data.hasOwnProperty(key)) {
	    						var status=data[key].IsActive;	    				
	    					 if(status==true){
	    						  s+="<tr>";
		    					  s+="<td>"+i+"</td>";
		    					  s+="<td><div class='d-flex align-items-center gap-3 cursor-pointer'>";
		    					  s+="<div class=''><p class='mb-0'>"+data[key].branchName+"</p></div></div> </td>";
		    					  s+="<td>"+data[key].bankName+"</td>";
		    					  s+="<td>"+data[key].location+"</td>";
		    					  s+="<td>"+data[key].createdDate+"</td>";
		    					  s+="<td>"+data[key].createdBy+"</td>";		    					  
		    					  s+="<td>"+data[key].updatedBy+"</td>";
		    					  s+="<td>"+data[key].updatedDate+"</td>";
		    					  s+="<td><span class='badge bg-success'>Active</span></td>";
		    					  s+="<td><div class='table-actions d-flex align-items-center gap-3 fs-6'>";
		    					  s+="<a  class='text-info branch_edit' data-bs-toggle='tooltip' data-bs-placement='bottom' title='Edit' data-id='"+data[key].branchId+"' id='"+data[key].branchId+"'><i class='bi bi-pencil-fill'></i></a>";
		    					  s+="<a  class='text-danger branch_delete' data-bs-toggle='tooltip' data-bs-placement='bottom' title='Delete' data-id='"+data[key].branchId+"' id='"+data[key].branchId+"'><i class='bi bi-trash-fill'></i></a>";
		    					  s+="</div></td></tr>";
	    					 }else{
	    						 s+="<tr>";
		    					  s+="<td>"+i+"</td>";
		    					  s+="<td><div class='d-flex align-items-center gap-3 cursor-pointer'>";
		    					  s+="<div class=''><p class='mb-0'>"+data[key].branchName+"</p></div></div> </td>";
		    					  s+="<td>"+data[key].bankName+"</td>";
		    					  s+="<td>"+data[key].location+"</td>";
		    					  s+="<td>"+data[key].createdDate+"</td>";
		    					  s+="<td>"+data[key].createdBy+"</td>";		    					  
		    					  s+="<td>"+data[key].updatedBy+"</td>";
		    					  s+="<td>"+data[key].updatedDate+"</td>";
		    					  s+="<td><span class='badge bg-warning'>Deactive</span></td>";
		    					  s+="<td><div class='table-actions d-flex align-items-center gap-3 fs-6'>";
		    					  s+="<a  class='text-info branch_edit' data-bs-toggle='tooltip' data-bs-placement='bottom' title='Edit' data-id='"+data[key].branchId+"' id='"+data[key].branchId+"'><i class='bi bi-pencil-fill'></i></a>";
		    					  s+="<a  class='text-secondary ' data-bs-toggle='tooltip' data-bs-placement='bottom' title='disabled' disabled><i class='bi bi-trash-fill'></i></a>";
		    					  s+="</div></td></tr>"; 
	    					 }
	    					}
	    					i++;
	    				}
	    				$('#viewBranch').html(s);
	    				console.log("success...")
	    	  		},
	    		error:function(jqXHR,textStatus,errorThrown){
	    			console.log(jqXHR.responseText);
	    				console.log("error...")
	    			}
	    	    });
			  }
				 $(document).on('click', '.branch_delete', function() {
					 branchId = $(this).attr('id');
					
	                 if (confirm('Are you sure you want to Deactive this?')) {
	              $.ajax({
					    type:'POST',
					    url:'../branchServlet',
						data:{'branchId':branchId,'event':'branch_delete'},
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
		  		  			    $('#viewBranch').html('');
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
			 $(document).on('click', '.branch_edit', function() {
                	id = $(this).attr('id');                	 
                	$("#editModal").modal("show");
				$.ajax({
				    type:'POST',
				    url:'../branchServlet',
					data:{'branchId':id,'event':'fatchBranchById'},
					method:'POST',
					dataType:'JSON',
					success:function(data,textStatus,jqXHR){
						var selectedOption = "isActive";
						$("#branchid").val(data[0].branchId);
	    				$("#branchname").val(data[0].branchName);
	    				$("#createdby").val(data[0].createdBy);
	    				$("#location").val(data[0].location);
	    				$("#updatedby").val(data[0].updatedBy);
	    				$('#' + selectedOption).prop('checked', data[0].IsActive);			
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
		  	$(document).ready(function(){
		  		console.log("page is ready .....");		  		
		  		$("#updatebranch").on('submit',function(event){
		  			event.preventDefault();
					var f=$(this).serialize();
					$.ajax({
		  				url:"../branchServlet",
		  				data:f,
		  				type:'POST',		  				
		  				success:function(data,textStatus,jqXHR){
			  				if(data.trim() ==='done'){			  					
			  					window.location.href = 'viewBranch.jsp';		  				
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
							console.log("error...")
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
		  	});
		  </script>
</body>
</html>