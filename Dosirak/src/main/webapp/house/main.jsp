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
<link href="../css3/layout.css" type="text/css" rel="stylesheet" />

<!-- <script src="../js/main.js" ></script> -->
<!--  -->
<style type="text/css">
a{color:#000;}
 
.mask{width:100%; height:100%; position:fixed; left:0; top:0; z-index:10; background:#000; opacity:.5; filter:alpha(opacity=50);}
 
#modalLayer{display:none; position:relative;}
#modalLayer .modalContent{width:220px; height:200px; padding:20px; border:1px solid #ccc; position:fixed; left:50%; 
top:50%; z-index:11; background:#fff;}
#modalLayer .modalContent button{position:absolute; right:0; top:0; cursor:pointer;}

</style>
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
	<div class="row">
		
		<div style="position: absolute; top: 60px; left: 400px;">
			<a href="main.do" id="againHome"><img class ="home" src="../images/home.png"/></a>
		</div>
		
		<div style="position: absolute; top: 60px; left: 490px;">
			<a href="#" data-backdrop="true" data-target="#friendDiv" data-toggle="modal" id ="friendbtn"><img  class ="friends" src="../images/friends.png"/></a>
		</div>
		
		<div id="house-owner">
	         <img alt="" src="../images/FrogIcon.png">
	         <p>${p.nickname}의 집</p>
    	</div>

     	<div id="owner-status">
        	 <p>${p.status}</p>
     	</div>
     	
     	<div id="getActDate">
        	 ${actDate}
     	</div>
     	
     	<input id="error" name="error" type="hidden" value="${errorCode}"/>
      
   	   	<div id="timer">
        	 <img alt="" src="../images/circular-clock.png">
         	<p id="getActDate">${actDate}</p>
      	</div>
      	
      	<img id="gold-image" src="../images/coin.png" alt="" />
			<div id="gold-window">
	         	<p id="gold">${p.gold}</p>
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
			<a href="inventory.do?tabCheck=dosirak" class="btn btn-warning btn-group-sm btni"><img  class ="icon" src="../images/backpack.png"/> 내가방</a>
		</div>
	 	<div style="position: absolute; top: 230px; left: 1350px;">
			<a href="collection.do" class="btn btn-warning btn-group-sm btni"><img  class ="icon" src="../images/inventory.png"/> 수집품</a>
		</div>
		<div style="position: absolute; top: 310px; left: 1350px;">
			<a href="../shop/shop.do" class="btn btn-warning btn-group-sm btni"><img  class ="icon" src="../images/store.png"/> 상점 </a>
		</div>		
		<div style="position: absolute; top: 390px; left: 1350px; color: white;">
			<a href="#" class="btn btn-warning btn-group-sm btni"><img  class ="icon" src="../images/history.png"/> 히스토리</a>
		</div>
		<div style="position: absolute; top: 470px; left: 1350px; color: white;">
			<a href="#" class="btn btn-warning btn-group-sm btni" data-backdrop="true" data-target="#guestNoteDiv" data-toggle="modal"><img  class ="icon" src="../images/email.png"/> 방명록</a>
		</div>
		<div style="position: absolute; top: 708px; left: 1350px; color: white;">
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
		
		<c:if test="${p.status == 'HOME'}">
			<div>
				<img style="position: absolute; top: 320px; left: 500px;"  id ="frog1" src="../images/${p.imgName}"/>
			</div>
		</c:if>
		<c:if test="${p.status != 'HOME'}">
			<div>
				<img style="position: absolute; top: 320px; left: 200000px;"  id ="frog1" src="../images/${p.imgName}"/>
			</div>
		</c:if>
			
	</div>
	
	<div class="modal fade" id ="friendDiv">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button data-dismiss="modal" class="close" type="button">&times;</button>
                        
                        <h3>친구 목록</h3>
                    </div>
                    <div class="friend-modal-body modal-body"></div>
                </div>
            </div>
        </div>
        
        <div class="modal fade" id ="guestNoteDiv">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button data-dismiss="modal" class="close" type="button">&times;</button>
                        <h3>방 명 록</h3>
                    </div>
                    
                    <div class="modal-body">
                       <!-- 반복 되어야 하는 구간 -->
                        <div class="guestNote-obj">
                           <div class="col-md-3">
                        <div class="friend-profile">
                           <img alt="" src="../images/FriendFrog.png">
                           <p class="friend-id">누구야</p>
                        </div>                           
                           </div>
                           
                           <div class="col-md-9">
                                 <div class="guestNote-main">
                              <p>방명록 테스트 메세지 입니다.</p>                    
                                 </div>
                           </div>
                        </div>
                        <!-- 여기까지 -->
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
					
					<%-- <form action="travelProc.do" method="post" id="goTravel">
						<div class="modal-btns btn-1">
							<a href=# class="button" onclick="formSubmit1(); return false;">
								<img class ="modalIcon" src="../images/world.png"/>
								<c:if test="${!empty errorMsg}">
									<span id="errorP">${errorMsg}</span>
	                            </c:if>
							</a>
							<div class="btn-text">여 행</div>
						</div>
					</form> --%>
					
					<!-- 여행 에이젝스
					<div class="modal-btns btn-1">
						<a data-dismiss="modal" id="goTravel" href="#" class="">
							<img class ="modalIcon" src="../images/world.png"/>
							<div class="btn-text">여 행</div>
						</a>
					</div> -->
					
					<form action="travelProc.do" method="post" id="goTravel">
					
						<div class="modal-btns btn-2">
							<a href=# class="button" onclick="formSubmit1(); return false;">
								<img class ="modalIcon" src="../images/world.png"/>
							</a>
							<div class="btn-text">여 행</div>
						</div>
					</form>
					
					<form action="workProc.do" method="post" id="goWork">
						<div class="modal-btns btn-2">
							<a href=# class="button" onclick="formSubmit(); return false;">
								<img class ="modalIcon" src="../images/coins.png"/>
							</a>
							<div class="btn-text">일</div>
						</div>
					</form>
				
				</div>
				<div class="modal-footer">
					<a href="#" id="exitBtn" class="btn btn-warning"><img id ="logoutModalIcon" src="../images/exit.png"/>나가기</a>
				</div>
			</div>
		</div>
	</div>
	
	<!------- 0607khj 추가------->
	<!-- <div id="modalLayer">
	  <div class="modalContent">
	    <button id = "zz" type="button">닫기</button>
	  </div>
	 </div>
	<button class="dd">닫기</button> -->
	
	<div id="modalLayer">
		<div class="modalContent">
			<button id="recordModalClose" type="button">닫기</button>
		 </div>
	</div>
	
	<!------- 일에서 집으로 돌아올 때 모달 창 ------->
	<!-- <div class="modal fade" id ="recordModalDiv">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button data-dismiss="modal" class="close" type="button">&times;</button>
                    <h3>일 지</h3>
                </div>
                    
                <div class="modal-body">
                	<div class="guestNote-obj">
                		<div class="col-md-3">
                			<div class="friend-profile">
                          		<img alt="" src="../images/FriendFrog.png">
                        	</div>                           
                        </div>
                           
                        <div class="col-md-9">
                        	<div class="recordModal"></div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>-->
 
</body>
<script type="text/javascript">
$(document).on("click", "#recordModalClose", function(){
	$("#modalLayer").fadeOut("slow");
});


function changeStatus(pay) {
   	$.ajax({
         url: "updateHomePlayer.do",         			
         type: "GET",
         data: {"owner" : "${owner}" ,"pay": pay},
	  	error: function(jqXHR) {
        	alert(jqXHR.status);
            alert(jqXHR.statusText);
      	},
        dataType: "json",
        success: function(resData) {         		
       	   	changeGold(resData);
        }
    });
}

function afterTravelStatus() {
   	$.ajax({
         url: "afterTravelStatus.do",         			
         type: "GET",
         data: {"owner" : "${owner}"},
	  	error: function(jqXHR) {
        	alert(jqXHR.status);
            alert(jqXHR.statusText);
      	},
        dataType: "json",
        success: function(resData) {         		
        	printData3(resData)
        }
    });
}

function formSubmit()
{
	var status = $("#owner-status").text(); 
	if(status == "HOME") {
		document.getElementById("goWork").submit();
	}else {
		alert("개구리가 " + status + " 중 입니다.");
	}
}
function formSubmit1()
{
	var status = $("#owner-status").text();
	if(status == "HOME") {
		document.getElementById("goTravel").submit();
	}else {
		alert("개구리가 " + status + " 중 입니다.");
	}
}

$(function() {											// 친구모달 실행 (조회해주는부분)
	$(document).on("click", "#friendbtn", function(){
    	$.ajax({
          url: "friendmodal.do",         				
          type: "GET",
          data: {"owner" : "${owner}"},
		  error: function(jqXHR) {
             alert(jqXHR.status);
             alert(jqXHR.statusText);
          },
          dataType: "json",
          success: function(resData) {         			
        	  printData(resData);  
          }
       });
    });
});

function getStatus() {
	$.ajax({
         url: "getStatus.do",         				
         type: "GET",
         data: {"owner" : "${owner}"},
         error: function(jqXHR) {
            alert(jqXHR.status);
            alert(jqXHR.statusText);
         },
         dataType: "json",
         success: function(resData) {         		
       	  	printData1(resData);
         }
    });
}

/* 여행 보내자 에이젝스 */
/* $(document).on("click", "#goTravel", function(){
	
	$.ajax({
         url: "travelProc.do",         				// 필수 ! 요청 페이지
         type: "POST",
         data: {"owner" : "${owner}"},
         error: function(jqXHR) {
            alert(jqXHR.status);
            alert(jqXHR.statusText);
         },
         dataType: "json",
         success: function(resData) {			// 필수!! 그에 대응되는 결과
        	 printData2(resData);
         }
    });
}); */

function printData(resData) {
   
	var result = "";
	
	$.each(resData, function(index, item) {
		alert(item["imgname"]);
		result += '<div class="friend-obj"><div class="col-md-3"><div class="friend-icon"><img alt="" src="../images/'+item["imgname"]+'"></div></div>'
				+ '<div class="col-md-6"><div class="friend-id"><p>'+item["fid"]+'</p></div></div>'
				+ '<div class="col-md-3"><div class="visit-btn"><a href="friendmain.do?fid='+item["fid"]+'"id="friendhome" >방 문</a></div></div></div>'
				+ '<img style ="width: 80px; height: 80px;" id="friendmodalImage" src="../images/" alt="" />'
				+'<input name="fid" type="hidden" value="${f.fid}"/>'
				$(".friend-modal-body").html(result);
	});
	
}

function printData1(resData) {
	$("#owner-status").text(resData["status"]);
}
function changeGold(resData) {
	$("#gold").text(resData["gold"]);
}

/* function printData2(resData) {
	if(resData == null) {
		alert("여행 시 필요한 도시락과 티켓을 지참해주세요.");
	}
} */

function printData3(resData) {

	var result = '<button id="recordModalClose" type="button">닫기</button><p>여 행 일 지</p><li>방문 도시 : '+resData["city"]+'</li>'
			+ '<li>명물 : '+resData["gname"]+'</li>'
			+ '<li>친구 : '+resData["fid"]+'</li>'
			$(".modalContent").html(result);

}

function compareTime() {
	  
	/* var nowTime = new Date();
	var time = $("#getActDate").text();
	var actTime = new Date(time);
	if(nowTime == actTime) { */
		
	var gold = 100;
	var bonus = (Math.floor(Math.random() * 5))*10;
	var pay = gold + bonus;
	changeStatus(pay);
	
	alert("일에서 돌아왔습니다. 기본급 : 100골드 보너스 : " + (pay-100) + "골드");
	
	// }
}

window.addEventListener("load", function(){
	
	var modalLayer = $("#modalLayer");
	
    var setTimer =0; 
    var status = $("#owner-status").text(); 
    var a = $.trim(status);
    var result = 0;
    
    var nowTime = new Date();
	var time = $("#getActDate").text();
	var actTime = new Date(time);

	if(a == "WORK") {
		if(nowTime > actTime) {	
 			compareTime();
		}	
	}else if(a == "TRAVEL") {
		if(nowTime > actTime) {
			modalLayer.fadeIn("slow");
			afterTravelStatus();
		}	
	}
		
	setTimer = setInterval(function(){
    	
	   nowTime = new Date();
       getStatus();
       var status = $("#owner-status").text();
       
       var img1 = document.getElementById("frog1");
       var house1 = document.getElementById("house1");
	   var house2 = document.getElementById("house2");
	   var house3 = document.getElementById("house3");
	   var house4 = document.getElementById("house4");
	   var house5 = document.getElementById("house5");
	   var house6 = document.getElementById("house6");
	   var a = $.trim(status);
	   
       if(a == 'HOME') {
	       result = Math.floor(Math.random() * 6) + 1;
	       img1.style.opacity = "1";
	       house1.style.opacity = "0.2";
		   house2.style.opacity = "0.2";
		   house3.style.opacity = "0.2";
		   house4.style.opacity = "0.2";
		   house5.style.opacity = "0.2";
		   house6.style.opacity = "0.2";
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
	          img1.style.position = "absolute";
	          img1.style.top = "320px";
	          img1.style.left = "500px";
	          house1.style.opacity = "1";
	       }

	       var error = $("#error").val();
           if(error == "checkX"){
              alert("여행에 필요한 도시락과 티켓을 지참해주세요.");
              $("#error").val("");
           }
           
       }else{
    	/* house1.style.opacity = "0.2";
		   house2.style.opacity = "0.2";
		   house3.style.opacity = "0.2";
		   house4.style.opacity = "0.2";
		   house5.style.opacity = "0.2";
		   house6.style.opacity = "0.2"; */
    	   img1.style.left = "200000px";
    	 	
    	   if((nowTime - actTime) >= 0 && (nowTime - actTime) < 1000) {
    		   if(a == 'WORK') {
    			   compareTime();
    		   }else {
    			   modalLayer.fadeIn("slow");
    			   afterTravelStatus();
    		   }
    	   }
       }
    }, 1000);
	
});

</script>
</html>