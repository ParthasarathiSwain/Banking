<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page session="true" %>
<%@page import="java.sql.*" %>
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
  <link href="assets/plugins/vectormap/jquery-jvectormap-2.0.2.css" rel="stylesheet"/>
  <link href="assets/plugins/simplebar/css/simplebar.css" rel="stylesheet" />
  <link href="assets/plugins/perfect-scrollbar/css/perfect-scrollbar.css" rel="stylesheet" />
  <link href="assets/plugins/metismenu/css/metisMenu.min.css" rel="stylesheet" />
  <!-- Bootstrap CSS -->
  <link href="assets/css/bootstrap.min.css" rel="stylesheet" />
  <link href="assets/css/bootstrap-extended.css" rel="stylesheet" />
  <link href="assets/css/style.css" rel="stylesheet" />
  <link href="assets/css/icons.css" rel="stylesheet">
  <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500&display=swap" rel="stylesheet">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">
  
	<!--toast-->
  <link href="assets/plugins/jquery-toast/src/jquery.toast.css" rel="stylesheet" />
  <link href="assets/plugins/jquery-toast/dist/jquery.toast.min.css" rel="stylesheet" />
 
  <!-- loader-->
	<link href="assets/css/pace.min.css" rel="stylesheet" />

  <!--Theme Styles-->
  <link href="assets/css/dark-theme.css" rel="stylesheet" />
  <link href="assets/css/light-theme.css" rel="stylesheet" />
  <link href="assets/css/semi-dark.css" rel="stylesheet" />
  <link href="assets/css/header-colors.css" rel="stylesheet" />

  <title>ADMIN-CREATE NEW ACCOUNT</title>
</head>
<body>
<!--start wrapper-->
  	<div class="wrapper">
    	<%@include file="include/header.jsp" %>
   		<%@include file="include/sidebar.jsp" %>
   		
   		 <!--start content-->
       <main class="page-content">
   		<!--breadcrumb-->
			<div class="page-breadcrumb d-none d-sm-flex align-items-center mb-3">
				<div class="breadcrumb-title pe-3">ACCOUNT</div>
					<div class="ps-3">
						<nav aria-label="breadcrumb">
							<ol class="breadcrumb mb-0 p-0">
								<li class="breadcrumb-item"><a href="javascript:;"><i class="bx bx-home-alt"></i></a>
								</li>
								<li class="breadcrumb-item active" aria-current="page">CREATE NEW ACCOUNT</li>
							</ol>
						</nav>
					</div>
			</div>
		<!-- breadcrumb end -->
		<div class="row">
					<div class="col-xl-9 mx-auto">
						
						<div class="card">
							<div class="card-body">
							<h6 class="mb-0 text-uppercase"><b>Customer Details</b></h6>
						<hr/>
							<form  class="row g-3" id="addAccount"  onsubmit="getLocationAndSubmitForm(event)">
								<div class="col-3">
									<label for="custfname" class="form-label">Customer First Name</label>
									<input class="form-control " name="custfname"  type="text" required placeholder="First Name" id="custfname" >
									<input  type="hidden" name="event" value="addAccount" >
									
								</div>
								<div class="col-3">
									<label for="custlname" class="form-label">Customer Last Name</label>
									<input class="form-control " name="custlname"  type="text" required placeholder="Last Name" id="custlname" >
									
								</div>
								<div class="col-3">
									<label for="custemail" class="form-label">Customer Email</label>
									<input class="form-control " name="custemail" type="text" required placeholder="Enter Customer Email" id="custemail" >
								</div>
								<div class="col-3">
									<label for="custpass" class="form-label">Customer Password</label>
									<input class="form-control " name="custpass"  type="text" required placeholder="Enter Customer Password" id="custpass" >
								</div>
								<div class="col-3">
									<label for="custdob" class="form-label">Customer Dob</label>
									<input class="form-control " name="custdob"  type="date" required placeholder="Enter Customer DOB" id="custdob" >
								</div>
								<div class="col-3">
									<label for="custphone" class="form-label">Customer Phone</label>
									<input class="form-control " name="custphone"  type="text" required placeholder="Enter Customer Phone" id="custphone" >
								</div>
								<div class="col-3">
									<label for="custadd" class="form-label">Customer Address</label>
									<textarea class="form-control " name="custadd"  type="text" required placeholder="Enter Address" id="custadd" ></textarea>
								</div>
								<div class="col-3">
									<label for="formFileMultiple" class="form-label">Photo</label>
									<input class="form-control" name="custimg" type="file" required id="formFileMultiple" multiple>
								</div>
								<h6 class="mb-0 text-uppercase"><b>Bank & Branch Details</b></h6><hr>
								<div class="col-6">
							     <label for="bankid" class="form-label">Select Bank </label>
									<select name="bankid" class="form-select" id="selectbankid">
										
									</select>
								
								</div>
								<div class="col-6">
							     <label for="branchId" class="form-label">Select Branch </label>
									<select name="branchid" class="form-select" id="branchId">
										
									</select>
								
								</div>
							     <h6 class="mb-0 text-uppercase"><b>Account Details</b></h6><hr>
							     <div class="col-6">
							     <label for="typeid" class="form-label">Account Type</label>
									<select name="typeId" class="form-select" id="typeid">
										<option selected>-Choose Account Type- </option>
										<%
											Connection con1 = DbConnection.getConnection();
											String sql1="SELECT accTypeId,accTypeName  FROM accounttype";
											PreparedStatement ps1=con1.prepareStatement(sql1);  
											ResultSet rs1=ps1.executeQuery();  
											while(rs1.next())
											{
											  %>
											   <option   value="<%=rs1.getInt(1) %>"><%=rs1.getString(2) %></option>
											  <% 
											 }
										 %>
									</select>
								
								</div>
								<div class="col-6">
									<label for="minBalance" class="form-label">Minimum Balance</label>
									<input class="form-control" value="500.00" name="balance" type="text" readonly required id="minBalance" >
								</div>
								<div class="mb-3">
								     <input class="form-control btn btn-primary" type="submit" value="Create New Account" >
								</div>
							</form>
								 
								
							</div>
						</div>
						
					</div>
				</div>
				<!--end row-->
   	   </main>
   		<!-- content end -->
	 <!--start switcher-->
       <div class="switcher-body">
        <button class="btn btn-primary btn-switcher shadow-sm" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasScrolling" aria-controls="offcanvasScrolling"><i class="bi bi-paint-bucket me-0"></i></button>
        <div class="offcanvas offcanvas-end shadow border-start-0 p-2" data-bs-scroll="true" data-bs-backdrop="false" tabindex="-1" id="offcanvasScrolling">
          <div class="offcanvas-header border-bottom">
            <h5 class="offcanvas-title" id="offcanvasScrollingLabel">Theme Customizer</h5>
            <button type="button" class="btn-close text-reset" data-bs-dismiss="offcanvas"></button>
          </div>
          <div class="offcanvas-body">
            <h6 class="mb-0">Theme Variation</h6>
            <hr>
            <div class="form-check form-check-inline">
              <input class="form-check-input" type="radio" name="inlineRadioOptions" id="LightTheme" value="option1">
              <label class="form-check-label" for="LightTheme">Light</label>
            </div>
            <div class="form-check form-check-inline">
              <input class="form-check-input" type="radio" name="inlineRadioOptions" id="DarkTheme" value="option2">
              <label class="form-check-label" for="DarkTheme">Dark</label>
            </div>
            <div class="form-check form-check-inline">
              <input class="form-check-input" type="radio" name="inlineRadioOptions" id="SemiDarkTheme" value="option3" checked>
              <label class="form-check-label" for="SemiDarkTheme">Semi Dark</label>
            </div>
            <hr>
            <div class="form-check form-check-inline">
              <input class="form-check-input" type="radio" name="inlineRadioOptions" id="MinimalTheme" value="option3">
              <label class="form-check-label" for="MinimalTheme">Minimal Theme</label>
            </div>
            <hr/>
            <h6 class="mb-0">Header Colors</h6>
            <hr/>
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
   <script src="assets/plugins/vectormap/jquery-jvectormap-world-mill-en.js"></script>
  <!--  toast -->
   <script src="assets/plugins/jquery-toast/src/jquery.toast.js"></script>
  <script src="assets/plugins/jquery-toast/dist/jquery.toast.min.js"></script>
  <!--app-->
  <script src="assets/js/app.js"></script>
  <script src="assets/js/index.js"></script>
  <script>
    new PerfectScrollbar(".review-list")
    new PerfectScrollbar(".chat-talk")
 </script>

 <script>
		
		$(document).ready(function() {
			let event ="event=getBanks";
	        	$.ajax({
	    			url:"../bankServlet",
	    			data:event,
	    			type:"POST",
	    			dataType:"json",
	    			success:function(data,textStatus,jqXHR){ 					 
	    				console.log(data);	    				
	    				 let s="<option value='0'>-Select Bank-</option>";
	    				for (var key in data) {
	    					 
	    					if (data.hasOwnProperty(key)) {	  
	    					 s+="<option value='"+data[key].bankId+"'>"+data[key].bankName+"</option>";
	    					}
	    				}
	    				$('#selectbankid').html(s);
	    				console.log("success...")
	    	  		},
	    		error:function(jqXHR,textStatus,errorThrown){
	    			console.log(jqXHR.responseText);
	    				console.log("error...")
	    			}
	    	    });
		  });  
		</script> 		
    <script>
     $(document).ready(function() {
    	  $('#selectbankid').change(function() {
    		 var bankId = $(this).val();
    	   $.ajax({
    	      type: 'POST',
    	      url: '../branchServlet',
    	      data:{'bankId':bankId,'event':'getBranchByBankId'},
			  dataType:"JSON", 
    	     success:function(data,textStatus,jqXHR){ 					     				
 				 let s="<option value='0'>-Select Branch-</option>";
 				for (var key in data) {
 					if (data.hasOwnProperty(key)) {	  
 					 s+="<option    value='"+data[key].branchId+"'  >"+data[key].branchName+"</option>";
 					}
 				}
 				$('#branchId').html(s);
 				console.log("success...")
 	  		},
 			error:function(jqXHR,textStatus,errorThrown){
 			console.log(jqXHR.responseText);
 				console.log("error...")
 			}
    	    });
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
                    var formData = new FormData($('#addAccount')[0]);

                    // Append latitude and longitude to FormData object
                    formData.append('latitude', latitude);
                    formData.append('longitude', longitude);
                    // Send location and form data to Servlet using AJAX
                    $.ajax({
                        url: '../accountServlet',
                        type: 'POST',
                        data: formData,
                        async: false,
                        success: function(data,textStatus,jqXHR){
                        	if(data.trim() ==='done'){
			  					$.toast({
			  					    text: "Account Create Successfully !", 
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
			  					$('#addAccount')[0].reset();		  				
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
  <!--app-->
  
</body>
</html>