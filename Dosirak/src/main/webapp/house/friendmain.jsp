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

<!--  Custom CSS & JS -->
<link href="../css3/main.css" type="text/css" rel="stylesheet" />
<link href="../css3/layout.css" type="text/css" rel="stylesheet" />

<!-- <script src="../js/main.js" ></script> -->
<!--  -->
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
	<div class="row">
		
		<div style="position: absolute; top: 60px; left: 400px;">
			<a href="main.do" ><img  class ="home" src="../images/home.png"/></a>
		</div>
		
		<div style="position: absolute; top: 60px; left: 690px;" id ="nickname">
			${p.nickname}
		</div>
		
		<%-- <input id="status" type="hidden" name="status" value='${p.status }' /> --%>
		<div style="position: absolute; top: 60px; left: 790px;" id ="status">
			${p.status}
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
			<a href="#" class="btn btn-warning btn-group-sm btni"><img  class ="icon" src="../images/email.png"/> 방명록</a>
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
		
		<c:if test="${p.status == 'HOME'}">
			<div>
				<img style="position: absolute; top: 320px; left: 500px;"  id ="frog1" src="../images/${p.imgName}"/>
			</div>
		</c:if>
	</div>

</body>
<script type="text/javascript">

window.addEventListener("load", function(){
    var setTimer =0; 
    var result = 0;
    setTimer = setInterval(function(){
       result = Math.floor(Math.random() * 6) + 1;
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
          img1.style.position = "absolute";
          img1.style.top = "320px";
          img1.style.left = "830px";
          house2.style.opacity = "1";            
       }else if(result == 3){
          img1.style.position = "absolute";
          img1.style.top = "370px";
          img1.style.left = "1250px";
          house3.style.opacity = "1";
       }else if(result == 4){
          img1.style.position = "absolute";
          img1.style.top = "680px";
          img1.style.left = "520px";
          house4.style.opacity = "1";
       }else if(result == 5){
          img1.style.position = "absolute";
          img1.style.top = "570px";
          img1.style.left = "815px";
          house5.style.opacity = "1";
       }else if(result == 6){
          img1.style.position = "absolute";
          img1.style.top = "610px";
          img1.style.left = "1150px";
          house6.style.opacity = "1";
       }else{      
          // img1.src = "../images/개구리1.png";
          img1.style.position = "absolute";
          img1.style.top = "320px";
          img1.style.left = "500px";

          house1.style.opacity = "1";
          
       }
       
       
    }, 3000);
    
    
 });


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
</html>