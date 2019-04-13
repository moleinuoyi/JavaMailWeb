<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	    <meta charset="utf-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	
	    <title>写信</title>
	
	    <link href="css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
	    <link href="css/font-awesome.css?v=4.4.0" rel="stylesheet">
	    <link href="plugins/summernote/summernote.css" rel="stylesheet">
	    <link href="plugins/summernote/summernote-bs3.css" rel="stylesheet">
	    <link href="css/animate.css" rel="stylesheet">
	    <link href="css/style.css?v=4.1.0" rel="stylesheet">
	    
	    <script type="text/javascript" src="ckeditor/ckeditor.js"></script>
		<script type="text/javascript">
			CKEDITOR.replace('afficheContent',{
				filebrowserImageUploadUrl : "imageUpload.action",
				language : 'zh-cn',
			});
		</script>
	
	</head>
	<body class="gray-bg">
	    <div class="wrapper wrapper-content">
	        <div class="row">
	            <div class="col-md-12 animated fadeInRight">
	                <div class="mail-box-header">
	                    <div class="pull-right tooltip-demo">
	                        <a href="#" class="btn btn-white btn-sm" data-toggle="tooltip" data-placement="top" title="存为草稿" onclick="savedraft()"><i class="fa fa-pencil"></i> 存为草稿</a>
	                        <a href="#" class="btn btn-danger btn-sm" data-toggle="tooltip" data-placement="top" title="放弃"><i class="fa fa-times"></i> 放弃</a>
	                    </div>
	                    <h2>
	                    	写信
	                	</h2>
	                </div>
	                <form class="form-horizontal" name="sendMail" method="get">
	                <div class="mail-box">
	                    <div class="mail-body">
	                            <div class="form-group">
	                                <label class="col-sm-2 control-label">发送到：</label>
	                                <div class="col-sm-10">
	                                    <input type="text" class="form-control" name="sendTo" value="">
	                                </div>
	                            </div>
	                            <div class="form-group">
	                                <label class="col-sm-2 control-label">主题：</label>
	                                <div class="col-sm-10">
	                                    <input type="text" class="form-control" name="title" value="">
	                                </div>
	                            </div>
	                    </div>
	
	                    <div class="mail-text h-200">
	                        <textarea rows="10" cols="40" name="content" id="content"></textarea>
							<script type="text/javascript">
								window.onload = function(){
									CKEDITOR.replace("content");
								}
							</script>
	                    </div>
	                    <div class="mail-body text-right tooltip-demo">
	                        <a href="#" class="btn btn-sm btn-primary" data-toggle="tooltip" data-placement="top" title="Send" onclick="sendmail()"><i class="fa fa-reply"></i> 发送</a>
	                        <a href="#" class="btn btn-white btn-sm" data-toggle="tooltip" data-placement="top" title="Discard email"><i class="fa fa-times"></i> 放弃</a>
	                        <a href="#" class="btn btn-white btn-sm" data-toggle="tooltip" data-placement="top" title="Move to draft folder" onclick="savedraft()"><i class="fa fa-pencil"></i> 存为草稿</a>
	                    </div>
	                    <div class="clearfix"></div>
	                </div>
	                </form>
	            </div>
	        </div>
	    </div>
	
	    <!-- 全局js -->
	    <script src="js/jquery.min.js?v=2.1.4"></script>
	    <script src="js/bootstrap.min.js?v=3.3.6"></script>
	
	    <!-- 自定义js -->
	    <script src="js/content.js?v=1.0.0"></script>
	
	    <!-- SUMMERNOTE -->
	    <script src="plugins/summernote/summernote.min.js"></script>
	    <script src="plugins/summernote/summernote-zh-CN.js"></script>
		
		<script>
		    function sendmail(){
		//        document.("表单的name值").action
		//        document.("表单的name值").submit
		        document.sendMail.action="${pageContext.request.contextPath }/sendmail.action";
		        document.sendMail.submit();
		    }
		    function savedraft() {
		        document.sendMail.action = "${pageContext.request.contextPath }/savemailtodraft.action";
		        document.sendMail.submit();
		    }
</script>
	
	</body>

</html>
