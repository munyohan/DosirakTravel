<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">

<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />

<!-- custom CSS & JS -->
<link href="../css/inventory.css" type="text/css" rel="stylesheet" />
<link href="../css/layout.css" type="text/css" rel="stylesheet" />

<!--  -->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>index</title>

</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-offset-3 col-md-6">
				<img id="gold-image" src="../images/coin.png" alt="" />

				<div id="gold-window">
					<p id="gold">27,000</p>
				</div>

				<div id="homeBtn">
					<a href="main.jsp"><img src="../images/home.png" /></a>
				</div>

				<div id="friendBtn">
					<a href="#" data-backdrop="true" data-target="#friendDiv"
						data-toggle="modal"><img class="friends"
						src="../images/friends.png" /></a>
				</div>

				<div id="inventory-window">

					<a href="#">
						<div class="tabs tab1">
							<div class="inner-text">도 시 락</div>
						</div>
					</a>
					<a href="#">
						<div class="tabs tab2">
							<div class="inner-text">티 켓</div>
						</div>
					</a> 
					<a href="#">
						<div class="tabs tab3">
							<div class="inner-text">명 물</div>
						</div>
					</a>

					<div id="inventory-inner-window">
						<div class="row">
							<c:forEach items="${ilist}" var="item">
								<div class="item-slot inbag">
									<a href="#" data-backdrop="static" data-target="#itemInfoModal" data-toggle="modal">
										<img kind="${item.itemkind}" title="${item.imgname}" class="item-slot-image" src="../images/${item.imgname}" alt="" />${item.amount}
									</a>
								</div>
							</c:forEach>
						</div>

						<div class="row"></div>
					</div>
				</div>

				<div id="mybag-window">
					<div id="mybag-title">내 가방</div>
					<div class="col-md-6">
						<div class="item-slot inbag">
							<a href="#" data-backdrop="static" data-target="#cancelDosirakInfoModal" data-toggle="modal">
								<img title="${b.dimgname}" class="cancelD" src="../images/${b.dimgname}" alt="" />	
							</a>
						</div>
					</div>

					<div class="col-md-6">
						<div class="item-slot inbag">
							<a href="#" data-backdrop="static" data-target="#cancelTicketInfoModal" data-toggle="modal">
								<img title="${b.timgname}" class="cancelT" src="../images/${b.timgname}" alt="" />	
							</a>
						</div>
					</div>
				</div>
			</div>
			<div class="col-md-3">
				<div id="gameBtns">
					<a href="#" class="btn btn-warning">
						<img class="icon" src="../images/backpack.png" /> 내가방
					</a> 
					<a href="collection.jsp" class="btn btn-warning">
						<img class="icon" src="../images/inventory.png" /> 수집품
					</a>
					<a href="../shop/shop.jsp" class="btn btn-warning">
						<img class="icon" src="../images/store.png" /> 상점
					</a>
				</div>
			</div>
		</div>
	</div>

	<form action="inventoryReg.do" method="post">
	 	<div class="modal fade" id="itemInfoModal">
			<div class="modal-dialog modal-md">
				<div class="modal-content">
					<div class="modal-header">
						<button data-dismiss="modal" class="close" type="button">&times;</button>
						<h3>아이템 정보</h3>
					</div>
	
					<div id="itemModalBody" class="modal-body"></div>
	
					<div class="modal-footer">
						<button id="equip" type="submit" class="btn btn-info">장 착</button>
					</div>
				</div>
			</div>
		</div>
	</form>
		
	<form action="inventoryDproc.do" method="post">
		<div class="modal fade" id="cancelDosirakInfoModal">
			<div class="modal-dialog modal-md">
				<div class="modal-content">
					<div class="modal-header">
						<button data-dismiss="modal" class="close" type="button">&times;</button>
						<h3>아이템 정보</h3>
					</div>
	
					<div id="itemCancelDModalBody" class="modal-body"></div>
		
					<div class="modal-footer">
						<button id="equip" type="submit" class="btn btn-info">해 제</button>
					</div>
				</div>
			</div>
		</div>
	</form>
	
	<form action="inventoryTproc.do" method="post">
		<div class="modal fade" id="cancelTicketInfoModal">
			<div class="modal-dialog modal-md">
				<div class="modal-content">
					<div class="modal-header">
						<button data-dismiss="modal" class="close" type="button">&times;</button>
						<h3>아이템 정보</h3>
					</div>
	
					<div id="itemCancelTModalBody" class="modal-body"></div>
	
					<div class="modal-footer">
						<button id="equip" type="submit" class="btn btn-info">해 제</button>
					</div>
				</div>
			</div>
		</div>
	</form>

</body>
<script type="text/javascript">

	$(function() {
		$(document).on("click", ".item-slot-image", function(){
	  		var img = $(this).attr("title");
	    	var kind = $(this).attr("kind");
	    	$.ajax({
	          url: "inventoryModal.do",         // 필수 ! 요청 페이지
	          type: "GET",
			  data: {"img" : img, "kind" : kind},
			  // data: {"owner" : "KHJ@KHJ.COM"},
	          error: function(jqXHR) {
	             alert(jqXHR.status);
	             alert(jqXHR.statusText);
	          },
	          dataType: "json",
	          success: function(resData) {         // 필수!! 그에 대응되는 결과
	        	  if(kind == '도시락') {
	        		  alert(kind);
	        		  printData1(resData);  
	        	  }else if(kind == '티켓') {
	        		  alert(kind);
	        		  printData2(resData); 
	        	  }else if(kind == '명물') {
	        		  alert(kind);
	        		  printData3(resData); 
	        	  }  
	          }
	       });
	    });
	});

	$(function() {
		$(document).on("click", ".cancelD", function(){
	  		var img = $(this).attr("title");
	  		alert("도시락 캔슬 성공");
	    	$.ajax({
	          url: "inventoryCancelDModal.do",         // 필수 ! 요청 페이지
	          type: "GET",
			  data: {"img" : img},
			  // data: {"owner" : "KHJ@KHJ.COM"},
	          error: function(jqXHR) {
	             alert(jqXHR.status);
	             alert(jqXHR.statusText);
	          },
	          dataType: "json",
	          success: function(resData) {         // 필수!! 그에 대응되는 결과
	        	  printData4(resData);  
	          }
	       });
	    });
 	});
	
	$(function() {
		$(document).on("click", ".cancelT", function(){
	  		var img = $(this).attr("title");
	  		alert("티켓 캔슬 성공");
	    	$.ajax({
	          url: "inventoryCancelTModal.do",         // 필수 ! 요청 페이지
	          type: "GET",
			  data: {"img" : img},
			  // data: {"owner" : "KHJ@KHJ.COM"},
	          error: function(jqXHR) {
	             alert(jqXHR.status);
	             alert(jqXHR.statusText);
	          },
	          dataType: "json",
	          success: function(resData) {         // 필수!! 그에 대응되는 결과
	        	  printData5(resData);
	          }
	       });
	    });
 	});
 	
	$(function() {
	    $(".tab1").click(function () {
	       $.ajax({
	          url: "inventoryDosirak.do",         // 필수 ! 요청 페이지
	          type: "GET",
			  data: {"owner" : "${owner}"},
			  // data: {"owner" : "KHJ@KHJ.COM"},
	          error: function(jqXHR) {
	             alert(jqXHR.status);
	             alert(jqXHR.statusText);
	          },
	          dataType: "json",
	          success: function(resData) {         // 필수!! 그에 대응되는 결과
	        	  printData(resData);
	          }
	       });
		 });
	 });
	 
	$(function() {
		$(".tab2").click(function() {
			$.ajax({
				url : "inventoryTicket.do", // 필수 ! 요청 페이지
				type : "GET",
				data : {"owner" : "${owner}"},
				error : function(jqXHR) {
					alert(jqXHR.status);
					alert(jqXHR.statusText);
				},
				dataType : "json",
				success : function(resData) { // 필수!! 그에 대응되는 결과
					printData(resData);
				}
			});
		});
	});

	$(function() {
 	    $(".tab3").click(function () {
 	       $.ajax({
 	          url: "inventoryGift.do",         // 필수 ! 요청 페이지
 	          type: "GET",
 			  data: {"owner" : "${owner}"},
 			  error: function(jqXHR) {
 	             alert(jqXHR.status);
 	             alert(jqXHR.statusText);
 	          },
 	          dataType: "json",
 	          success: function(resData) {         // 필수!! 그에 대응되는 결과
 	        	  printData(resData);
 	          }
 	       });
 	    });
 	 });
	
	function printData1(resData) {
		
		var result = "";
		
		result += '<div class="col-md-4">'
			+ '<img id="modalImage" src="../images/'+resData["imgName"]+'" alt="" /></div>'
			+ '<div class="col-md-8"><ul id="itemModalList">'
			+ '<li>이름 : '+resData["dName"]+'</li>'
			+ '<li>종류 : '+"도시락"+'</li>'
			+ '<input name="inventoryKind" type="hidden" value="도시락"/>'
			+ '<input name="inventoryCode" type="hidden" value="'+resData["dCode"]+'"/>'
			+ '<li>가격 : '+resData["price"]+"골드"+'</li>'
			+ '<li>효과 : </li></ul></div>'
			$("#itemModalBody").html(result);
			
		alert(result);
	
	}
	function printData2(resData) {
		
		var result = "";
		
		result += '<div class="col-md-4">'
			+ '<img id="modalImage" src="../images/'+resData["imgName"]+'" alt="" /></div>'
			+ '<div class="col-md-8"><ul id="itemModalList">'
			+ '<li>이름 : '+resData["tName"]+'</li>'
			+ '<li>종류 : '+"티켓"+'</li>'
			+ '<input name="inventoryKind" type="hidden" value="티켓"/>'
			+ '<input name="inventoryCode" type="hidden" value="'+resData["tCode"]+'"/>'
			+ '<li>가격 : '+resData["price"]+"골드"+'</li>'
			+ '<li>효과 : </li></ul></div>'
			$("#itemModalBody").html(result);
		
	}
	function printData3(resData) {
		
		var result = "";
		
		result += '<div class="col-md-4">'
			+ '<img id="modalImage" src="../images/'+resData["imgName"]+'" alt="" /></div>'
			+ '<div class="col-md-8"><ul id="itemModalList">'
			+ '<li>이름 : '+resData["gName"]+'</li>'
			+ '<li>종류 : '+"명물"+'</li>'
			+ '<li>효과 : </li></ul></div>'
			$("#itemModalBody").html(result);
		
	}
	
	function printData4(resData) {
		
		var result = "";
		
		result += '<div class="col-md-4">'
			+ '<img id="modalImage" src="../images/'+resData["imgName"]+'" alt="" /></div>'
			+ '<input id="dCode" type="hidden" name="sdCode" value='+resData["dCode"]+' />'
			+ '<div class="col-md-8"><ul id="itemModalList">'
			+ '<li>이름 : '+resData["dName"]+'</li>'
			+ '<li>종류 : '+"도시락"+'</li>'
			+ '<li>가격 : '+resData["price"]+"골드"+'</li>'
			+ '<li>효과 : </li></ul></div>'
			$("#itemCancelDModalBody").html(result);
			
		alert(result);
	
	}
	
	function printData5(resData) {
		
		var result = "";
		
		result += '<div class="col-md-4">'
			+ '<img id="modalImage" src="../images/'+resData["imgName"]+'" alt="" /></div>'
			+ '<input id="tCode" type="hidden" name="stCode" value="'+resData["tCode"]+'" />'
			+ '<div class="col-md-8"><ul id="itemModalList">'
			+ '<li>이름 : '+resData["tName"]+'</li>'
			+ '<li>종류 : '+"티켓"+'</li>'
			+ '<li>가격 : '+resData["price"]+"골드"+'</li>'
			+ '<li>효과 : </li></ul></div>'
			$("#itemCancelTModalBody").html(result);
		
	}
	function printData(resData) {
		var result = "";

		$.each(resData, function(index, item) {
			result += '<div class="item-slot inbag">'
					+ '<a href="#" data-backdrop="static" data-target="#itemInfoModal" data-toggle="modal">'
					+ '<img kind="'+item["itemkind"]+'" title="'+item["imgname"]+'" class="item-slot-image" src="../images/'+item["imgname"]+'" alt="" /><p>'+item["amount"]+item["imgname"]+'</p></a></div>';
			$("#inventory-inner-window").html(result);
		});
	}
	
</script>
</html>
