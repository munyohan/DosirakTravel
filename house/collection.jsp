<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">

<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>

<link href="../css/layout.css" type="text/css" rel="stylesheet" />
<link href="../css/collection.css" type="text/css" rel="stylesheet" />

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>index</title>

</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-offset-3 col-md-6">
				<div id="homeBtn">
					<a href="main.jsp"><img src="../images/home.png"/></a>
				</div>
				
				<div id="friendBtn">
					<a href="#" data-backdrop="true" data-target="#friendDiv" data-toggle="modal"><img  class ="friends" src="../images/friends.png"/></a>
				</div>
			
				<div id="collection-window">
					<a href="#">
                        <div class="tabs tab1">
                            <div class="inner-text">명 물</div>
                        </div>
                    </a>
                    
                    <a href="#">
                        <div class="tabs tab2">
                            <div class="inner-text">사 진</div>
                        </div>
                    </a>
                    
                    <div id="collection-inner-window">
                        <div class="row">
                            <div class="col-md-3">
                                <a href="#" data-backdrop="static" data-target="#itemInfoModal" data-toggle="modal">
                                	<div class="item-slot inbag">
                                		<img class="item-slot-image" src="../images/QuestionBox.png" alt="" />
                                	</div>
                                </a>
                            </div>
                            
                            <div class="col-md-3">
                            	<a href="#" data-backdrop="static" data-target="#itemInfoModal" data-toggle="modal">
                                	<div class="item-slot inbag">
                                		<img class="item-slot-image" src="../images/QuestionBox.png" alt="" />
                                	</div>
                                </a>
                            </div>
                            
                            <div class="col-md-3">
                            	<a href="#" data-backdrop="static" data-target="#itemInfoModal" data-toggle="modal">
                                	<div class="item-slot inbag">
                                		<img class="item-slot-image" src="../images/QuestionBox.png" alt="" />
                                	</div>
                                </a>
                            </div>
                            
                            <div class="col-md-3">
                            	<a href="#" data-backdrop="static" data-target="#itemInfoModal" data-toggle="modal">
                                	<div class="item-slot inbag">
                                		<img class="item-slot-image" src="../images/QuestionBox.png" alt="" />
                                	</div>
                                </a>
                            </div>
                 
                        </div>
                        
                        <div class="row">
                            <div class="col-md-3">
                                <a href="#" data-backdrop="static" data-target="#itemInfoModal" data-toggle="modal">
                                	<div class="item-slot inbag">
                                		<img class="item-slot-image" src="../images/QuestionBox.png" alt="" />
                                	</div>
                                </a>
                            </div>
                            
                            <div class="col-md-3">
                            	<a href="#" data-backdrop="static" data-target="#itemInfoModal" data-toggle="modal">
                                	<div class="item-slot inbag">
                                		<img class="item-slot-image" src="../images/QuestionBox.png" alt="" />
                                	</div>
                                </a>
                            </div>
                            
                            <div class="col-md-3">
                            	<a href="#" data-backdrop="static" data-target="#itemInfoModal" data-toggle="modal">
                                	<div class="item-slot inbag">
                                		<img class="item-slot-image" src="../images/QuestionBox.png" alt="" />
                                	</div>
                                </a>
                            </div>
                            
                            <div class="col-md-3">
                            	<a href="#" data-backdrop="static" data-target="#itemInfoModal" data-toggle="modal">
                                	<div class="item-slot inbag">
                                		<img class="item-slot-image" src="../images/QuestionBox.png" alt="" />
                                	</div>
                                </a>
                            </div>
                 
                        </div>
                        
                        <div class="row">
                            <div class="col-md-3">
                            	<a href="#" data-backdrop="static" data-target="#itemInfoModal" data-toggle="modal">
                                	<div class="item-slot inbag">
                                		<img class="item-slot-image" src="../images/QuestionBox.png" alt="" />
                                	</div>
                                </a>
                            </div>
                            
                            <div class="col-md-3">
								<a href="#" data-backdrop="static" data-target="#itemInfoModal" data-toggle="modal">
                                	<div class="item-slot inbag">
                                		<img class="item-slot-image" src="../images/QuestionBox.png" alt="" />
                                	</div>
                                </a>
                            </div>
                            
                            <div class="col-md-3">
                            	<a href="#" data-backdrop="static" data-target="#itemInfoModal" data-toggle="modal">
                                	<div class="item-slot inbag">
                                		<img class="item-slot-image" src="../images/QuestionBox.png" alt="" />
                                	</div>
                                </a>
                            </div>
                            
                            <div class="col-md-3">
                            	<a href="#" data-backdrop="static" data-target="#itemInfoModal" data-toggle="modal">
                                	<div class="item-slot inbag">
                                		<img class="item-slot-image" src="../images/QuestionBox.png" alt="" />
                                	</div>
                                </a>
                            </div>
                        </div>
                    </div>
				</div>
			</div>
			
			<div class="col-md-3">
				<div id="gameBtns">
					<a href="inventory.jsp" class="btn btn-warning"><img class ="icon" src="../images/backpack.png"/> 내가방</a>
					<a href="#" class="btn btn-warning"><img class ="icon" src="../images/inventory.png"/> 수집품</a>
					<a href="../shop/shop.jsp" class="btn btn-warning"><img class ="icon" src="../images/store.png"/> 상점  </a>
				</div>
			</div>
		</div>
	</div>
	
	<div class="modal fade" id="itemInfoModal">
		<div class="modal-dialog modal-md">
			<div class="modal-content">
				<div class="modal-header">
					<button data-dismiss="modal" class="close" type="button">&times;</button>
					<h3>아이템 정보</h3>
				</div>
					
				<div id="itemModalBody" class="modal-body">
					<div class="col-md-4">
						<img id="modalImage" src="../images/QuestionBox.png" alt="" />
					</div>
					
					<div class="col-md-8">
						<ul id="itemModalList">
							<li>아직 발견하지 못한 명물입니다. 새로운 나라를 방문하여 진귀한 명물들을 얻어보세요 ! </li>
						</ul>
					</div>				
				</div>
					
				<div class="modal-footer">
					<a id="equip" href="#" class="btn btn-info">확 인</a>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
