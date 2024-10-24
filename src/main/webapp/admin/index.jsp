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
<!doctype html>
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
  

  <!-- loader-->
	<link href="assets/css/pace.min.css" rel="stylesheet" />

  <!--Theme Styles-->
  <link href="assets/css/dark-theme.css" rel="stylesheet" />
  <link href="assets/css/light-theme.css" rel="stylesheet" />
  <link href="assets/css/semi-dark.css" rel="stylesheet" />
  <link href="assets/css/header-colors.css" rel="stylesheet" />

  <title>BANKING WEBAPP ADMIN</title>
</head>

<body>


  <!--start wrapper-->
  <div class="wrapper">
    
	<%@include file="include/header.jsp" %>
    <%@include file="include/sidebar.jsp" %>
       

       <!--start content-->
          <main class="page-content">
              
             <div class="row row-cols-1 row-cols-lg-2 row-cols-xl-4">
                 <div class="col">
                  <div class="card rounded-4">
                    <div class="card-body">
                      <div class="d-flex align-items-center">
                        <div class="">
                          <p class="mb-1">Total Orders</p>
                          <h4 class="mb-0">5.8K</h4>
                          <p class="mb-0 mt-2 font-13"><i class="bi bi-arrow-up"></i><span>22.5% from last week</span></p>
                        </div>
                        <div class="ms-auto widget-icon bg-primary text-white">
                          <i class="bi bi-basket2"></i>
                        </div>
                      </div>
                     
                    </div>
                  </div>
                 </div>
                 <div class="col">
                  <div class="card rounded-4">
                    <div class="card-body">
                      <div class="d-flex align-items-center">
                        <div class="">
                          <p class="mb-1">Total Income</p>
                          <h4 class="mb-0">$9,786</h4>
                          <p class="mb-0 mt-2 font-13"><i class="bi bi-arrow-up"></i><span>13.2% from last week</span></p>
                        </div>
                        <div class="ms-auto widget-icon bg-success text-white">
                          <i class="bi bi-currency-dollar"></i>
                        </div>
                      </div>
                    </div>
                  </div>
                 </div>
                 <div class="col">
                  <div class="card rounded-4">
                    <div class="card-body">
                      <div class="d-flex align-items-center">
                        <div class="">
                          <p class="mb-1">Total Views</p>
                          <h4 class="mb-0">875</h4>
                          <p class="mb-0 mt-2 font-13"><i class="bi bi-arrow-up"></i><span>12.3% from last week</span></p>
                        </div>
                        <div class="ms-auto widget-icon bg-orange text-white">
                          <i class="bi bi-emoji-heart-eyes"></i>
                        </div>
                      </div>
                    </div>
                  </div>
                 </div>
                 <div class="col">
                  <div class="card rounded-4">
                    <div class="card-body">
                      <div class="d-flex align-items-center">
                        <div class="">
                          <p class="mb-1">New Clients</p>
                          <h4 class="mb-0">9853</h4>
                          <p class="mb-0 mt-2 font-13"><i class="bi bi-arrow-up"></i><span>32.7% from last week</span></p>
                        </div>
                        <div class="ms-auto widget-icon bg-info text-white">
                          <i class="bi bi-people-fill"></i>
                        </div>
                      </div>
                    </div>
                  </div>
                 </div>

             </div><!--end row-->

             
             <div class="row">
                <div class="col-12 col-lg-8 col-xl-8 d-flex">
                   <div class="card w-100 rounded-4">
                     <div class="card-body">
                      <div class="d-flex align-items-center mb-3">
                        <h6 class="mb-0">Revenue History</h6>
                        <div class="fs-5 ms-auto dropdown">
                           <div class="dropdown-toggle dropdown-toggle-nocaret cursor-pointer" data-bs-toggle="dropdown"><i class="bi bi-three-dots"></i></div>
                             <ul class="dropdown-menu">
                               <li><a class="dropdown-item" href="#">Action</a></li>
                               <li><a class="dropdown-item" href="#">Another action</a></li>
                               <li><hr class="dropdown-divider"></li>
                               <li><a class="dropdown-item" href="#">Something else here</a></li>
                             </ul>
                         </div>
                       </div>
                      <div class="d-flex align-items-center gap-3">
                        <div class="">
                          <h4 class="text-success mb-0">$9,279</h4>
                          <p class="mb-0">Revenue</p>
                        </div>
                        <div class="vr"></div>
                        <div class="">
                          <h4 class="text-pink mb-0">$5,629</h4>
                          <p class="mb-0">Investment</p>
                        </div>
                      </div>
                        <div id="chart1"></div>
                     </div>
                   </div>
                </div>
                <div class="col-12 col-lg-4 col-xl-4 d-flex">
                  <div class="card w-100 rounded-4">
                    <div class="card-body">
                     <div class="d-flex align-items-center mb-3">
                       <h6 class="mb-0">Task Overview</h6>
                       <div class="fs-5 ms-auto dropdown">
                          <div class="dropdown-toggle dropdown-toggle-nocaret cursor-pointer" data-bs-toggle="dropdown"><i class="bi bi-three-dots"></i></div>
                            <ul class="dropdown-menu">
                              <li><a class="dropdown-item" href="#">Action</a></li>
                              <li><a class="dropdown-item" href="#">Another action</a></li>
                              <li><hr class="dropdown-divider"></li>
                              <li><a class="dropdown-item" href="#">Something else here</a></li>
                            </ul>
                        </div>
                      </div>
                       <div id="chart2"></div>
                    </div>
                    <ul class="list-group list-group-flush mb-0 shadow-none">
                      <li class="list-group-item bg-transparent border-top"><i class="bi bi-circle-fill me-2 font-weight-bold text-primary"></i> Complete <span class="float-end">120</span></li>
                      <li class="list-group-item bg-transparent"><i class="bi bi-circle-fill me-2 font-weight-bold text-orange"></i> In Progress <span class="float-end">110</span></li>
                      <li class="list-group-item bg-transparent"><i class="bi bi-circle-fill me-2 font-weight-bold text-info"></i> Started <span class="float-end">70</span></li>
                    </ul>
                  </div>
               </div>

             </div><!--end row-->

          <div class="row row-cols-1 row-cols-lg-3">
          <div class="col">
            <div class="card rounded-4">
              <div class="card-body">
                 <div class="d-flex align-items-center justify-content-between mb-3">
                  <div class="">
                    <h4 class="mb-0">24.5K</h4>
                    <p class="mb-0">Facebook Followers</p>
                 </div>
                 <div class="fs-2 text-facebook">
                  <i class="bi bi-facebook"></i>
                </div>
                 </div>
                 <div id="chart7"></div>
              </div>
            </div>
          </div>
          <div class="col">
            <div class="card rounded-4">
              <div class="card-body">
                 <div class="d-flex align-items-center justify-content-between mb-3">
                  <div class="">
                    <h4 class="mb-0">37.8K</h4>
                    <p class="mb-0">Twitter Followers</p>
                 </div>
                 <div class="fs-2 text-twitter">
                  <i class="bi bi-twitter"></i>
                </div>
                 </div>
                 <div id="chart8"></div>
              </div>
            </div>
          </div>
          <div class="col">
            <div class="card rounded-4">
              <div class="card-body">
                 <div class="d-flex align-items-center justify-content-between mb-3">
                  <div class="">
                    <h4 class="mb-0">56.9K</h4>
                    <p class="mb-0">Youtube Subscribers</p>
                 </div>
                 <div class="fs-2 text-youtube">
                  <i class="bi bi-youtube"></i>
                </div>
                 </div>
                 <div id="chart9"></div>
              </div>
            </div>
          </div>

        </div><!--end row-->


        <div class="row">
          <div class="col-12 col-lg-6 col-xl-6 d-flex">
            <div class="card rounded-4 w-100">
              <div class="card-header bg-transparent">
                <div class="d-flex align-items-center">
                  <h6 class="mb-0">Customer Reviews</h6>
                  <div class="fs-5 ms-auto dropdown">
                     <div class="dropdown-toggle dropdown-toggle-nocaret cursor-pointer" data-bs-toggle="dropdown"><i class="bi bi-three-dots"></i></div>
                       <ul class="dropdown-menu">
                         <li><a class="dropdown-item" href="#">Action</a></li>
                         <li><a class="dropdown-item" href="#">Another action</a></li>
                         <li><hr class="dropdown-divider"></li>
                         <li><a class="dropdown-item" href="#">Something else here</a></li>
                       </ul>
                   </div>
                 </div>
              </div>
               <div class="card-body">
                 <div class="review-list">
                  <div class="d-flex align-items-start">
                    <div class="review-user">
                      <img src="assets/adminImg/" width="65" height="65" class="rounded-circle" alt="">
                    </div>
                    <div class="review-content ms-3">
                      <div class="rates cursor-pointer fs-6">
                        <i class="bx bxs-star text-warning"></i>
                        <i class="bx bxs-star text-warning"></i>
                        <i class="bx bxs-star text-warning"></i>
                        <i class="bx bxs-star text-warning"></i>
                        <i class="bx bxs-star text-warning"></i>
                      </div>
                      <div class="d-flex align-items-center mb-2">
                        <h6 class="mb-0">Welcome to </h6>
                        <p class="mb-0 ms-auto">February 16, 2021</p>
                      </div>
                      <p>Nesciunt tofu stumptown aliqua, retro synth master cleanse. Mustache cliche tempor, williamsburg carles vegan helvetica. Reprehenderit butcher retro keffiyeh dreamcatcher synth.</p>
                    </div>
                  </div>
                  <hr>
                  <div class="d-flex align-items-start">
                    <div class="review-user">
                      <img src="assets/images/avatars/avatar-2.png" width="65" height="65" class="rounded-circle" alt="">
                    </div>
                    <div class="review-content ms-3">
                      <div class="rates cursor-pointer fs-6">
                        <i class="bx bxs-star text-warning"></i>
                        <i class="bx bxs-star text-warning"></i>
                        <i class="bx bxs-star text-warning"></i>
                        <i class="bx bxs-star text-warning"></i>
                        <i class="bx bxs-star text-warning"></i>
                      </div>
                      <div class="d-flex align-items-center mb-2">
                        <h6 class="mb-0">David Buckley</h6>
                        <p class="mb-0 ms-auto">February 22, 2021</p>
                      </div>
                      <p>Nesciunt tofu stumptown aliqua, retro synth master cleanse. Mustache cliche tempor, williamsburg carles vegan helvetica. Reprehenderit butcher retro keffiyeh dreamcatcher synth.</p>
                    </div>
                  </div>
                  <hr>
                  <div class="d-flex align-items-start">
                    <div class="review-user">
                      <img src="assets/images/avatars/avatar-3.png" width="65" height="65" class="rounded-circle" alt="">
                    </div>
                    <div class="review-content ms-3">
                      <div class="rates cursor-pointer fs-6">
                        <i class="bx bxs-star text-warning"></i>
                        <i class="bx bxs-star text-warning"></i>
                        <i class="bx bxs-star text-warning"></i>
                        <i class="bx bxs-star text-warning"></i>
                        <i class="bx bxs-star text-warning"></i>
                      </div>
                      <div class="d-flex align-items-center mb-2">
                        <h6 class="mb-0">Peter Costanzo</h6>
                        <p class="mb-0 ms-auto">February 26, 2021</p>
                      </div>
                      <p>Nesciunt tofu stumptown aliqua, retro synth master cleanse. Mustache cliche tempor, williamsburg carles vegan helvetica. Reprehenderit butcher retro keffiyeh dreamcatcher synth.</p>
                    </div>
                  </div>
                  <hr>
                  <div class="d-flex align-items-start">
                    <div class="review-user">
                      <img src="assets/images/avatars/avatar-4.png" width="65" height="65" class="rounded-circle" alt="">
                    </div>
                    <div class="review-content ms-3">
                      <div class="rates cursor-pointer fs-6">
                        <i class="bx bxs-star text-warning"></i>
                        <i class="bx bxs-star text-warning"></i>
                        <i class="bx bxs-star text-warning"></i>
                        <i class="bx bxs-star text-warning"></i>
                        <i class="bx bxs-star text-warning"></i>
                      </div>
                      <div class="d-flex align-items-center mb-2">
                        <h6 class="mb-0">Peter Costanzo</h6>
                        <p class="mb-0 ms-auto">February 26, 2021</p>
                      </div>
                      <p>Nesciunt tofu stumptown aliqua, retro synth master cleanse. Mustache cliche tempor, williamsburg carles vegan helvetica. Reprehenderit butcher retro keffiyeh dreamcatcher synth.</p>
                    </div>
                  </div>
                  <hr>
                  <div class="d-flex align-items-start">
                    <div class="review-user">
                      <img src="assets/images/avatars/avatar-5.png" width="65" height="65" class="rounded-circle" alt="">
                    </div>
                    <div class="review-content ms-3">
                      <div class="rates cursor-pointer fs-6">
                        <i class="bx bxs-star text-warning"></i>
                        <i class="bx bxs-star text-warning"></i>
                        <i class="bx bxs-star text-warning"></i>
                        <i class="bx bxs-star text-warning"></i>
                        <i class="bx bxs-star text-warning"></i>
                      </div>
                      <div class="d-flex align-items-center mb-2">
                        <h6 class="mb-0">Peter Costanzo</h6>
                        <p class="mb-0 ms-auto">February 26, 2021</p>
                      </div>
                      <p>Nesciunt tofu stumptown aliqua, retro synth master cleanse. Mustache cliche tempor, williamsburg carles vegan helvetica. Reprehenderit butcher retro keffiyeh dreamcatcher synth.</p>
                    </div>
                  </div>
                  <hr>
                  <div class="d-flex align-items-start">
                    <div class="review-user">
                      <img src="assets/images/avatars/avatar-6.png" width="65" height="65" class="rounded-circle" alt="">
                    </div>
                    <div class="review-content ms-3">
                      <div class="rates cursor-pointer fs-6">
                        <i class="bx bxs-star text-warning"></i>
                        <i class="bx bxs-star text-warning"></i>
                        <i class="bx bxs-star text-warning"></i>
                        <i class="bx bxs-star text-warning"></i>
                        <i class="bx bxs-star text-warning"></i>
                      </div>
                      <div class="d-flex align-items-center mb-2">
                        <h6 class="mb-0">Peter Costanzo</h6>
                        <p class="mb-0 ms-auto">February 26, 2021</p>
                      </div>
                      <p>Nesciunt tofu stumptown aliqua, retro synth master cleanse. Mustache cliche tempor, williamsburg carles vegan helvetica. Reprehenderit butcher retro keffiyeh dreamcatcher synth.</p>
                    </div>
                  </div>
                  <hr>
                  <div class="d-flex align-items-start">
                    <div class="review-user">
                      <img src="assets/images/avatars/avatar-7.png" width="65" height="65" class="rounded-circle" alt="">
                    </div>
                    <div class="review-content ms-3">
                      <div class="rates cursor-pointer fs-6">
                        <i class="bx bxs-star text-warning"></i>
                        <i class="bx bxs-star text-warning"></i>
                        <i class="bx bxs-star text-warning"></i>
                        <i class="bx bxs-star text-warning"></i>
                        <i class="bx bxs-star text-warning"></i>
                      </div>
                      <div class="d-flex align-items-center mb-2">
                        <h6 class="mb-0">Peter Costanzo</h6>
                        <p class="mb-0 ms-auto">February 26, 2021</p>
                      </div>
                      <p>Nesciunt tofu stumptown aliqua, retro synth master cleanse. Mustache cliche tempor, williamsburg carles vegan helvetica. Reprehenderit butcher retro keffiyeh dreamcatcher synth.</p>
                    </div>
                  </div>

                </div>

               </div>
            </div>
          </div>
          <div class="col-12 col-lg-6 col-xl-6 d-flex">
            <div class="card rounded-4 w-100">
              <div class="card-header bg-transparent">
                <div class="d-flex align-items-center">
                  <h6 class="mb-0">Chat Box</h6>
                  <div class="fs-5 ms-auto dropdown">
                     <div class="dropdown-toggle dropdown-toggle-nocaret cursor-pointer" data-bs-toggle="dropdown"><i class="bi bi-three-dots"></i></div>
                       <ul class="dropdown-menu">
                         <li><a class="dropdown-item" href="#">Action</a></li>
                         <li><a class="dropdown-item" href="#">Another action</a></li>
                         <li><hr class="dropdown-divider"></li>
                         <li><a class="dropdown-item" href="#">Something else here</a></li>
                       </ul>
                   </div>
                 </div>
              </div>
               <div class="card-body p-0">
                  <div class="chat-talk d-flex flex-column gap-4 p-3">
                     <div class="d-flex align-items-end gap-3">
                      <div class="chat-user">
                        <img src="assets/images/avatars/avatar-7.png" width="55" height="55" class="rounded-circle" alt="">
                      </div>
                      <div class="chat-msg border flex-grow-1 rounded-4 p-3">
                         Hello , Codervent
                      </div>
                     </div>
                     <div class="d-flex align-items-end gap-3">
                      <div class="chat-msg border flex-grow-1 rounded-4 p-3 bg-light">
                         Hello , Codervent
                      </div>
                      <div class="chat-user">
                        <img src="assets/images/avatars/avatar-7.png" width="55" height="55" class="rounded-circle" alt="">
                      </div>
                     </div>
                     <div class="d-flex align-items-end gap-3">
                      <div class="chat-user">
                        <img src="assets/images/avatars/avatar-7.png" width="55" height="55" class="rounded-circle" alt="">
                      </div>
                      <div class="chat-msg border flex-grow-1 rounded-4 p-3">
                         Hello , Codervent
                      </div>
                     </div>
                     <div class="d-flex align-items-end gap-3">
                      <div class="chat-msg border flex-grow-1 rounded-4 p-3 bg-light">
                         Hello , Codervent
                      </div>
                      <div class="chat-user">
                        <img src="assets/images/avatars/avatar-7.png" width="55" height="55" class="rounded-circle" alt="">
                      </div>
                     </div>
                     <div class="d-flex align-items-end gap-3">
                      <div class="chat-user">
                        <img src="assets/images/avatars/avatar-7.png" width="55" height="55" class="rounded-circle" alt="">
                      </div>
                      <div class="chat-msg border flex-grow-1 rounded-4 p-3">
                         Hello , Codervent
                      </div>
                     </div>
                     <div class="d-flex align-items-end gap-3">
                      <div class="chat-msg border flex-grow-1 rounded-4 p-3 bg-light">
                         Hello , Codervent
                      </div>
                      <div class="chat-user">
                        <img src="assets/images/avatars/avatar-7.png" width="55" height="55" class="rounded-circle" alt="">
                      </div>
                     </div>
                     <div class="d-flex align-items-end gap-3">
                      <div class="chat-user">
                        <img src="assets/images/avatars/avatar-7.png" width="55" height="55" class="rounded-circle" alt="">
                      </div>
                      <div class="chat-msg border flex-grow-1 rounded-4 p-3">
                         Hello , Codervent
                      </div>
                     </div>
                     <div class="d-flex align-items-end gap-3">
                      <div class="chat-msg border flex-grow-1 rounded-4 p-3 bg-light">
                         Hello , Codervent
                      </div>
                      <div class="chat-user">
                        <img src="assets/images/avatars/avatar-7.png" width="55" height="55" class="rounded-circle" alt="">
                      </div>
                     </div>
                  </div>
                  <div class="card-footer bg-transparent">
                    <div class="input-group">
                      <input type="text" class="form-control" placeholder="Type your message">
                      <button class="btn btn-primary" type="button"><i class="bi bi-send"></i></button>
                    </div>
                  </div>

               </div>
            </div>
          </div>

        </div><!--end row-->


          </main>
       <!--end page main-->

       <!--start overlay-->
        <div class="overlay nav-toggle-icon"></div>
       <!--end overlay-->

       <!--Start Back To Top Button-->
		     <a href="javaScript:;" class="back-to-top"><i class='bx bxs-up-arrow-alt'></i></a>
       <!--End Back To Top Button-->

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
  <!--end wrapper-->


  <!-- Bootstrap bundle JS -->
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
  <!--app-->
  <script src="assets/js/app.js"></script>
  <script src="assets/js/index.js"></script>
  <script>
    new PerfectScrollbar(".review-list")
    new PerfectScrollbar(".chat-talk")
 </script>


</body>

</html>