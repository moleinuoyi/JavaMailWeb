<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html class="no-js" lang="en">
	<head>
	    <meta charset="UTF-8">
	    <title> View | Admire</title>
	    <!--IE Compatibility modes-->
	    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <!--Mobile first-->
	    <meta name="viewport" content="width=device-width, initial-scale=1">
	    <!-- global styles-->
	    <link type="text/css" rel="stylesheet" href="css/components.css" />
		<link type="text/css" rel="stylesheet" href="css/custom.css" />
	    <!--End of global styles-->
	    
	    <link type="text/css" rel="stylesheet" href="plugins/bootstrap3-wysihtml5-bower/css/bootstrap3-wysihtml5.min.css" />
	    <link type="text/css" rel="stylesheet" href="css/pages/mail_box.css"/>
	</head>
	<body>
	<div id="wrap">
	    <!-- /#top -->
	    <div class="wrapper">
	        <!-- /#left -->
	        <div id="content" class="bg-container">
	            <div class="outer">
	                <div class="inner bg-container">
	                    <div class="row web-mail mail_compose">
	                        <div class="col-lg-12">
	                            <div class="card media_max_991">
	                                <div class="card-header bg-white">
	                                    <p class="m-t-20">主题: ${request.mail.mailTitle}.</p>
	                                    <p class="m-t-10"><span>发送者: ${request.mail.sendPeople} </span><span class="float-right">06:15AM 28 FEB 2016</span></p>
	                                </div>
	                                <div class="card-block m-t-35">
	                                    ${request.mail.mailContent} 
	                                    <hr>
	                                    <h4 class="m-t-25"><i class="fa fa-paperclip"></i> &nbsp;附件 <span>(2)</span></h4>
	                                    <div class="row">
	                                        <div class="col-xl-3 col-lg-4 col-sm-4 col-6 m-t-20">
	                                            <img class="img-thumbnail img-fluid view_admin_img" alt="Admin" src="img/mailbox_imgs/1.jpg">
	                                        </div>
	                                        <div class="col-xl-3 col-lg-4 col-sm-4 col-6  m-t-20">
	                                            <img class="img-thumbnail img-fluid view_admin_img" alt="Admin" src="img/mailbox_imgs/3.jpg">
	                                        </div>
	                                    </div>
	                                    <br/>
	                                    <hr>
	                                    <div class="m-t-20">
	                                        <form action="mail_sent.html" class="mail_view_wysi">
	                                            <div class="form-group">
	                                                <input type="email" class="form-control" id="forward_to" placeholder="To *" required="">
	                                            </div>
	                                            <div class="form-group">
	                                                <textarea rows="10" cols="40" name="content" id="content"></textarea>
													<script type="text/javascript">
														window.onload = function(){
															CKEDITOR.replace("content");
														}
													</script>
	                                            </div>
	                                            <div class="form-group">
	                                                <button class="btn btn-primary" id="goto_sent_page">发送</button>
	                                                <a class="btn btn-primary" href="mail_view.html">返回</a>
	                                            </div>
	                                        </form>
	                                        <button class="btn btn-primary" id="view_reply1"><i class="fa fa-reply"></i> 回信</button>
	                                        <button class="btn btn-primary" id="view_reply2"><i class="fa fa-reply"></i> 抄送</button>
	                                        <a href="mail_trash.html" class="btn btn-warning" id="view_reply3"><i class="fa fa-trash-o"></i> 删除</a>
	                                    </div>
	                                </div>
	                            </div>
	                        </div>
	                    </div>
	                </div>
	            </div>
	        </div>
	    </div>
	</div>
	
	<!-- global scripts-->
	<script type="text/javascript" src="js/components.js"></script>
	<script type="text/javascript" src="js/custom.js"></script>
	<!-- end of global scripts-->
	<script type="text/javascript" src="plugins/bootstrap3-wysihtml5-bower/js/bootstrap3-wysihtml5.all.min.js"></script>
	<script type="text/javascript" src="js/mail_box.js"></script>
	
	</body>
</html>