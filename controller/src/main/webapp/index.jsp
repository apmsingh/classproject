<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Shabdashri Classes</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<style>
#fullDive { //
	background: linear-gradient(to right, #ffbf96, #fe7096);
	background-color: #f0f0f0;
}

.buttoncolor {
	background: linear-gradient(to right, #da8cff, #9a55ff);
}

.inner {
	margin-bottom: 20px;
	margin-top: 20px;
}

.card {
	background-color: #ffff;
	border-radius: 5px;
	padding-bottom: 20px;
	margin-top: 20px;
	margin-bottom: 20px;
}

#form {
	background-color: #ffff;
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
.row.content {
	height: 450px;
}

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
	.row.content {
		height: auto;
	}
}

.results tr[visible='false'], .no-result {
	display: none;
}

.results tr[visible='true'] {
	display: table-row;
}

.counter {
	padding: 8px;
	color: #ccc;
}
</style>
</head>
<body id="fullDive">

	<div id="site-wrapper">
		<nav class="navbar navbar-inverse">
			<div class="container-fluid ">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target="#myNavbar">
						<span class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="#">Shabdashri</a>
				</div>
				<div class="collapse navbar-collapse" id="myNavbar">
					<ul class="nav navbar-nav navbar-right">
						<li><a href="#"><span class="glyphicon glyphicon-log-in"></span>
								Login</a></li>
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
									<input type="text" class="search form-control"
										placeholder="What you looking for?">
								</div>
								<span class="counter pull-right"></span>
								<div id="studentDetails">
								</div>
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
		   window.onload = function() {
			   var url = "http://localhost:5092/controller/student/load";
			   const Http = new XMLHttpRequest();
			   Http.open("GET", url);
			   Http.send();
			   
		       var execOne = 1;
			   Http.onreadystatechange = (e) => {
      		   if(execOne === 1) {
					var responseData = JSON.parse(Http.responseText);
					var listOfStudents = responseData.students;
					var tableObject = document.createElement("TABLE");
					tableObject.setAttribute("id", "studentDetailsTable");
					tableObject.setAttribute("class", "table table-hover table-bordered results");
					
					console.log("----------------");
					console.log(tableObject);
					var createTHead = document.createElement("THEAD");
					tableObject.appendChild(createTHead);
					
					var createRowHead = document.createElement("TR");
					createTHead.appendChild(createRowHead);
					
					var firstVal = document.createElement("TH");
					var first = document.createTextNode("#");
					firstVal.appendChild(first);
					createRowHead.appendChild(firstVal);
					
					var secondVal = document.createElement("TH");
					secondVal.setAttribute("class", "col-md-3 col-xs-3");
					var second = document.createTextNode("Student ID");
					secondVal.appendChild(second);
					createRowHead.appendChild(secondVal);
					
					var thirdVal = document.createElement("TH");
					thirdVal.setAttribute("class", "col-md-3 col-xs-3");
					var third = document.createTextNode("Name / Surname");
					thirdVal.appendChild(third);
					createRowHead.appendChild(thirdVal);
					
					var fourthVal = document.createElement("TH");
					fourthVal.setAttribute("class", "col-md-3 col-xs-3");
					var fourth = document.createTextNode("Standard");
					fourthVal.appendChild(fourth);
					createRowHead.appendChild(fourthVal);
					
					var fifthVal = document.createElement("TH");
					fifthVal.setAttribute("class", "col-md-3 col-xs-3");
					var fifth = document.createTextNode("Courses");
					fifthVal.appendChild(fifth);
					createRowHead.appendChild(fifthVal);
					
					var createTBody = document.createElement("TBODY");
					tableObject.appendChild(createTBody);
					
					for (i = 0; i < listOfStudents.length; i++) {
					   var student = listOfStudents[i];
					   var id = student.id;
					   var name = student.name;
					   var standard = student.standard;
					   var courses = student.courses;
					   var rowNumber = "row" + i;
						
					   var createRow = document.createElement("TR");
					   createRow.setAttribute("id", rowNumber);
					   createTBody.appendChild(createRow);
						
					   var dataCellSno = document.createElement("TH");
					   dataCellSno.setAttribute("scope", "row");
					   var cellValueSno = document.createTextNode(id);
					   dataCellSno.appendChild(cellValueSno);
					   
					   var dataCellId = document.createElement("TH");
					   dataCellId.setAttribute("scope", "row");
					   var cellValueId = document.createTextNode(id);
					   dataCellId.appendChild(cellValueId);
					   
					   var dataCellName = document.createElement("TD");
					   cellValueName = document.createTextNode(name);
					   dataCellName.appendChild(cellValueName);

					   var dataCellStandard = document.createElement("TD");
					   cellValueStandard = document.createTextNode(standard);
					   dataCellStandard.appendChild(cellValueStandard);
						
					   var dataCellCourse = document.createElement("TD");
					   var courses = "";
					   if (courses.length > 0) {
						   for(j=0; j < courses.length; j++) {
							   courses += courses[j];
							   if (j != courses.length) {
								   courses += ",";
							   }
						   }
					   } else {
						   courses = "All";
					   }
					   cellValueCourse = document.createTextNode(courses);
					   dataCellCourse.appendChild(cellValueCourse);
					   
					   createRow.appendChild(dataCellSno);
					   createRow.appendChild(dataCellId);
					   createRow.appendChild(dataCellName);
					   createRow.appendChild(dataCellStandard);
					   createRow.appendChild(dataCellCourse);
					}
					console.log(tableObject);
				  document.getElementById("studentDetails").appendChild(tableObject);
		         execOne = 2;
				}
				console.log("Finally Added");
			 
		     }
		   };
		</script>
	</div>
	<footer class="container-fluid text-center">
		<p>WebsiteDemo.com © 2019</p>
	</footer>
</body>
</html>