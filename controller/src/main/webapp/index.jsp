<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Shabdashri Classes</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
  <style>
	#fullDive{
		//background: linear-gradient(to right, #ffbf96, #fe7096);
		background-color: #f0f0f0;
	}
	.buttoncolor{
		background: linear-gradient(to right, #da8cff, #9a55ff);
	}
	
	.inner{
		margin-bottom: 20px;
		margin-top: 20px;
	}
	.card{
		background-color :#ffff;
		border-radius: 5px;
		padding-bottom: 20px;
		margin-top: 20px;
		margin-bottom: 20px;
	}
	#form{
		background-color :#ffff;
		border-radius: 5px;
		padding-bottom: 20px;
		margin-top: 20px;
		margin-bottom: 20px;
	}
    /* Remove the navbar's default margin-bottom and rounded borders */ 
    .navbar {
      margin-bottom: 0;
      border-radius: 0;
	 
    }
    
    /* Set height of the grid so .sidenav can be 100% (adjust as needed) */
    .row.content {height: 450px;}
    
    /* Set gray background color and 100% height */
    .sidenav {
      padding-top: 20px;
      background-color: #f1f1f1;
      height: 100%;
    }
    
    /* Set black background color, white text and some padding */
    footer {
      background-color: #555;
      color: white;
      padding: 15px;
    }
    
    /* On small screens, set height to 'auto' for sidenav and grid */
    @media screen and (max-width: 767px) {
      .sidenav {
        height: auto;
        padding: 15px;
      }
      .row.content {height:auto;} 
    }
	
	
	.results tr[visible='false'],
	.no-result{
	  display:none;
	}

	.results tr[visible='true']{
	  display:table-row;
	}

	.counter{
	  padding:8px; 
	  color:#ccc;
	}
  </style>
</head>
<body id="fullDive">
  
	<div id="site-wrapper">
		<nav class="navbar navbar-inverse">
		  <div class="container-fluid ">
			<div class="navbar-header">
			  <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>                        
			  </button>
			  <a class="navbar-brand" href="#">Shabdashri</a>
			</div>
			<div class="collapse navbar-collapse" id="myNavbar">
			  <ul class="nav navbar-nav navbar-right">
				<li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
			  </ul>
			</div>
		  </div>
		</nav>
		  
		<div class="container-fluid text-center">    
		  <div class="row content">
			<div class="inner col-sm-2 text-left"> 
				  <ul class="nav nav-pills brand-pills nav-stacked">
					<li class="active "><a data-toggle="tab" href="#home">Student</a></li>
					<li><a data-toggle="tab" href="#menu1">Teacher </a></li>
					<li><a data-toggle="tab" href="#menu2">Enquiry Details</a></li>
				  </ul>
			</div>
			<div class=" col-sm-10 text-left"> 
			  <div class="tab-content">
				<div id="home" class="tab-pane fade in active">
					<div id="form" class="col-sm-12">
						<h3>Student Information</h3>
					<div class="form-group col-sm-12">
						<input type="text" class="search form-control" placeholder="What you looking for?">
					</div>
					<span class="counter pull-right"></span>
					<table class="table table-hover table-bordered results">
					  <thead>
						<tr>
						  <th>#</th>
						  <th class="col-md-3 col-xs-3">Student ID</th>
						  <th class="col-md-3 col-xs-3">Name / Surname</th>
						  <th class="col-md-3 col-xs-3">Standerd</th>
						  <th class="col-md-3 col-xs-3">Courses</th>
						</tr>
						<tr class="warning no-result">
						  <td colspan="4"><i class="fa fa-warning"></i> No result</td>
						</tr>
					  </thead>
					  <tbody>
						<tr>
						  <th scope="row">1</th>
						  <th scope="row">S1000259</th>
						  <td>Vatsal Rao</td>
						  <td>12<sup>th</sup></td>
						  <td>Maths</td>
						</tr>
						<tr>
						  <th scope="row">2</th>
						  <th scope="row">S1000459</th>
						  <td>Rishikesh Wandre</td>
						  <td>12<sup>th</sup></td>
						  <td>All</td>
						</tr>
						<tr>
						  <th scope="row">3</th>
						  <th scope="row">S1000299</th>
						  <td>Nayan Salunkhe</td>
						  <td>12<sup>th</sup></td>
						  <td>Science</td>
						</tr>
						<tr>
						  <th scope="row">4</th>
						  <th scope="row">S1000459</th>
						  <td>Renuka Dar</td>
						  <td>12<sup>th</sup></td>
						  <td>Maths</td>
						</tr>
					  </tbody>
					</table>				
					</div>
				</div>
			  </div>
			</div>
		  </div>
		</div>
		<script>
		$(document).ready(function() {
		  $(".search").keyup(function () {
			var searchTerm = $(".search").val();
			var listItem = $('.results tbody').children('tr');
			var searchSplit = searchTerm.replace(/ /g, "'):containsi('")
			
			  $.extend($.expr[':'], {'containsi': function(elem, i, match, array){
					return (elem.textContent || elem.innerText || '').toLowerCase().indexOf((match[3] || "").toLowerCase()) >= 0;
				}
			  });
			  $(".results tbody tr").not(":containsi('" + searchSplit + "')").each(function(e){
				$(this).attr('visible','false');
			  });

			  $(".results tbody tr:containsi('" + searchSplit + "')").each(function(e){
				$(this).attr('visible','true');
			  });

			  var jobCount = $('.results tbody tr[visible="true"]').length;
				$('.counter').text(jobCount + ' item');

			  if(jobCount == '0') {$('.no-result').show();}
				else {$('.no-result').hide();}
					  });
		});
		</script>
		<script>
			$(document).ready(function sendRequestToBackend() {
				var url = document.getElementById("url").value;
				var method = document.getElementById("method").value;
				var body = document.getElementById("body").value;
				//print(" " url + " " + method + " " + body)
				document.getElementById("url").value = "Hello"
				
				
				const Http = new XMLHttpRequest();
				if (method === "GET") {
				  Http.open(method, url);
				  console.log("Other Req");
				  Http.send();
				} else {
				  Http.open(method, url, true);
	     		  Http.setRequestHeader('Content-Type', 'application/json');
	     		  console.log(body);
	     		  var data = JSON.stringify(body);
	     		  Http.send(data);
				}

				Http.onreadystatechange = (e) => {
				  console.log(Http.responseText)
				  alert(result);
				}
				document.getElementById("url").value = "world"
			});
		</script>
	</div>
<footer class="container-fluid text-center">
  <p>WebsiteDemo.com © 2019 </p>
</footer>
</body>
</html>