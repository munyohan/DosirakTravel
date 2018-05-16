<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1"> 
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript">

	window.addEventListener("load", function(){
		var setTimer =0; 
		var result = 0;
		setTimer = setInterval(function(){
			result = Math.floor(Math.random() * 6) + 1;
			/* var p1 = document.getElementById("p1");
			p1.innerHTML = result; */
			var img1 = document.getElementById("frog1");
			var house1 = document.getElementById("house1");
			var house2 = document.getElementById("house2");
			var house3 = document.getElementById("house3");
			var house4 = document.getElementById("house4");
			var house5 = document.getElementById("house5");
			var house6 = document.getElementById("house6");
			house1.style.opacity = "0.5";
			house2.style.opacity = "0.5";
			house3.style.opacity = "0.5";
			house4.style.opacity = "0.5";
			house5.style.opacity = "0.5";
			house6.style.opacity = "0.5";
			img1.style.opacity = "1";
			if(result == 2){
				img1.src = "../images/개구리1.png";
				img1.style.position = "absolute";
				img1.style.top = "320px";
				img1.style.left = "830px";
				house2.style.opacity = "1";				
			}else if(result == 3){
				img1.src = "../images/개구리1.png";
				img1.style.position = "absolute";
				img1.style.top = "370px";
				img1.style.left = "1250px";
				house3.style.opacity = "1";
			}else if(result == 4){
				img1.src = "../images/개구리1.png";
				img1.style.position = "absolute";
				img1.style.top = "680px";
				img1.style.left = "520px";
				house4.style.opacity = "1";
			}else if(result == 5){
				img1.src = "../images/개구리1.png";
				img1.style.position = "absolute";
				img1.style.top = "570px";
				img1.style.left = "815px";
				house5.style.opacity = "1";
			}else if(result == 6){
				img1.src = "../images/개구리1.png";
				img1.style.position = "absolute";
				img1.style.top = "610px";
				img1.style.left = "1150px";
				house6.style.opacity = "1";
			}else{		
		 		img1.src = "../images/개구리1.png";
				img1.style.position = "absolute";
				img1.style.top = "320px";
				img1.style.left = "500px";

				house1.style.opacity = "1";
				
			}
			
			
		}, 3000);
	});

</script>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
html, body {
  
  background-color: #D0DAA8;
 
}
#house1,#house2,#house3,#house4,#house5,#house6,#frog1{
	opacity: 0.5;
}
.dropbtn {
    /* background-color: #4CAF50; */
	/* color: white; */
    margin: 0px 500px;
    /* padding: 16px;
    font-size: 16px;
    border: none; */
    decoration: none;
    /* cursor: pointer; */
}

/* .dropbtn:hover, .dropbtn:focus {
    background-color: #3e8e41;
} */

#myInput {
    border-box: box-sizing;
    background-image: url('searchicon.png');
    background-position: 14px 12px;
    background-repeat: no-repeat;
    font-size: 16px;
    padding: 14px 20px 12px 45px;
    border: none;
    border-bottom: 1px solid #ddd;
}

#myInput:focus {outline: 3px solid #ddd;}

.dropdown {
    position: relative;
    display: inline-block;
}

.dropdown-content {
    display: none;
    position: absolute;
    margin: 0px 500px;
    background-color: #f6f6f6;
    min-width: 230px;
    overflow: auto;
    border: 1px solid #ddd;
    z-index: 1;
}

.dropdown-content a {
    color: black;
    padding: 12px 16px;
    text-decoration: none;
    display: block;
}

.dropdown a:hover {background-color: #ddd}

.show {display:block;}
.btn-warning{
	padding: 16px;
    font-size: 16px;
}
#friends{
	width: 60px;
	height: 60px;
}
#house{
	width: 1000px;
	height: 700px;
}
.img{
	width: 300px;
	height: 300px;
	border-color: black;
	
}

#frog1{
	width: 80px;
	height: 80px;
}
.icon{
	width: 40px;
	height: 40px;
}
.btni{
	width: 130px;
}
.home, .friends{
	width: 80px;
	height: 80px;
	opacity: 0.5;
}
.home:hover, .friends:hover {
	opacity: 1;
}
.modalIcon{
	width: 80px;
	height: 80px;

}
</style>
</head>
<body>
	
	<div class="row">
		
		<div style="position: absolute; top: 60px; left: 400px;">
			<a href="main.jsp" ><img  class ="home" src="../images/home.png"/></a>
		</div>
		
		<div style="position: absolute; top: 60px; left: 490px;">
			<a href="#" data-backdrop="true" data-target="#friendDiv" data-toggle="modal" id ="friendbtn"><img  class ="friends" src="../images/friends.png"/></a>
		</div>
		
		<div style="position: absolute; top: 150px; left: 400px;">
			<img id ="house1" class ="img" src="../images/거실.PNG"/>
		</div>
		<div style="position: absolute;top: 150px; left: 720px;">
			<img id ="house2" class ="img" src="../images/공부방.PNG"/>
		</div>
		<div style="position: absolute;top: 150px; left: 1040px;">
			<img id ="house3" class ="img" src="../images/부엌.PNG"/>
		</div>
		
		
		<div style="position: absolute; top: 150px; left: 1350px;">
			<a href="inventory.jsp" class="btn btn-warning btn-group-sm btni"><img  class ="icon" src="../images/backpack.png"/> 내가방</a>
		</div>
	 	<div style="position: absolute; top: 230px; left: 1350px;">
			<a href="collection.jsp" class="btn btn-warning btn-group-sm btni"><img  class ="icon" src="../images/inventory.png"/> 수집품</a>
		</div>
		<div style="position: absolute; top: 310px; left: 1350px;">
			<a href="../shop/shop.jsp" class="btn btn-warning btn-group-sm btni"><img  class ="icon" src="../images/store.png"/> 상점  </a>
		</div>		
		<div style="position: absolute; top: 390px; left: 1350px;">
			<a href="#" class="btn btn-warning btn-group-sm btni"><img  class ="icon" src="../images/history.png"/> 히스토리</a>
		</div>
		<div style="position: absolute; top: 470px; left: 1350px;">
			<a href="#" class="btn btn-warning btn-group-sm btni"><img  class ="icon" src="../images/email.png"/> 방명록</a>
		</div>
		<div style="position: absolute; top: 708px; left: 1350px;">
			<a href="#" data-backdrop="true" data-target="#logoutDiv" data-toggle="modal" id ="logoutbtn" class="btn btn-warning btn-group-sm btni"><img  class ="icon" src="../images/door.png"/> 외출</a>
		</div>
		
		<div style="position: absolute; top: 480px; left: 400px;">
			<img id ="house4" class ="img" src="../images/서재.PNG"/>
		</div>
		<div style="position: absolute;top: 480px; left: 720px;">
			<img id ="house5" class ="img" src="../images/욕실.PNG"/>
		</div>
		<div style="position: absolute; top: 480px; left: 1040px;">
			<img  id ="house6" class ="img" src="../images/침실.PNG"/>
		</div>
		
		<div>
			<img style="position: absolute; top: 320px; left: 500px;"  id ="frog1" src="../images/개구리1.png"/>
		</div>
		
		
	</div>

	<div class="modal fade" id ="friendDiv">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button data-dismiss="modal" class="close" type="button">&times;</button>
					<h3>친 구 목 록</h3>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" id="myForm" method="post"> <!--action nono 왜냐하면 ajax에서 쓸거야  -->
						<div class="form-group">
						<!-- mid와 input을 넣기 위해 해준다 -->
							<label class="control-label col-xs-2">Mid :</label>
							<div class="col-xs-2">
								<img alt="" src="../images/친구개구리.png"><input class="form-control" type="text" name="mid" id ="mid">
							</div>
									
							<div class="col-xs-6">
								<input class="form-control" type="text" name="content" id ="content">
							</div>
							<p id ="p1" class="col-xs-offset-2 col-xs-10"></p>
						</div>
								
						<div class="form-group">
							<div class="col-xs-offset-10 col-xs-10">
								<button  class="btn btn-success" type="submit">등록</button>
							</div>
						</div>
					</form>
					<div class="modal-footer">
						<button data-dismiss="modal" class="btn btn-info" type="button">Close</button>
					</div>
				</div>
			</div>
		</div>
	</div>
				
	<div class="modal fade" id ="logoutDiv">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button data-dismiss="modal" class="close" type="button">&times;</button>
					<h3>외 출</h3>
				</div>
				<div class="modal-body">
					<img class ="modalIcon" src="../images/world.png"/>
					<a href="#" class="btn btn-warning btn-group-sm btni">여 행</a>
					<img class ="modalIcon" src="../images/coins.png"/>
					<a href="#" class="btn btn-warning btn-group-sm btni">일</a>
				</div>
				<div class="modal-footer">
					<p><img class ="modalIcon" src="../images/exit.png"/></p>
					<a href="#" class="btn btn-warning btn-group-sm btni"> 나가기</a>
				</div>
			</div>
		</div>
	</div>
		
<script>
/* When the user clicks on the button,
toggle between hiding and showing the dropdown content */

function myFunction() {
    document.getElementById("myDropdown").classList.toggle("show");
}

function filterFunction() {
    var input, filter, ul, li, a, i;
    input = document.getElementById("myInput");
    filter = input.value.toUpperCase();
    div = document.getElementById("myDropdown");
    a = div.getElementsByTagName("a");
    for (i = 0; i < a.length; i++) {
        if (a[i].innerHTML.toUpperCase().indexOf(filter) > -1) {
            a[i].style.display = "";
        } else {
            a[i].style.display = "none";
        }
	}
    
}
</script>

</body>
</html>