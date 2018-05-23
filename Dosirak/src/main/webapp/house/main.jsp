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
<link href="../css/main.css" type="text/css" rel="stylesheet" />
<link href="../css/layout.css" type="text/css" rel="stylesheet" />

<script src="../js/main.js" ></script>
<!--  -->
<meta name="viewport" content="width=device-width, initial-scale=1">
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
			<a href="inventory.do" class="btn btn-warning btn-group-sm btni"><img  class ="icon" src="../images/backpack.png"/> 내가방</a>
		</div>
	 	<div style="position: absolute; top: 230px; left: 1350px;">
			<a href="collection.jsp" class="btn btn-warning btn-group-sm btni"><img  class ="icon" src="../images/inventory.png"/> 수집품</a>
		</div>
		<div style="position: absolute; top: 310px; left: 1350px;">
			<a href="../shop/shop.jsp" class="btn btn-warning btn-group-sm btni"><img  class ="icon" src="../images/store.png"/> 상점 </a>
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
					<p>외 출</p>
				</div>
				<div class="modal-body">
					
					<form action="travelProc.do" method="post">
						<div class="modal-btns btn-1">
							<a href="#" class="">
								<img class ="modalIcon" src="../images/world.png"/>
								<div class="btn-text">여 행</div>
							</a>
						</div>
					</form>
					
					<form action="workProc.do" method="post">
						<div class="modal-btns btn-2">
							<a href="#" class="">
								<img class ="modalIcon" src="../images/coins.png"/>
								<div class="btn-text">일</div>
							</a>
						</div>
					</form>
				
				</div>
				<div class="modal-footer">
					<a href="#" id="exitBtn" class="btn btn-warning"><img id ="logoutModalIcon" src="../images/exit.png"/>나가기</a>
				</div>
			</div>
		</div>
	</div>

</body>
</html>