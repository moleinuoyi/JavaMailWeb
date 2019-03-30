<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
    	<meta name="renderer" content="webkit">
    	
		<title>Insert title here</title>
	    
	    <link href="css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
	    <link href="css/font-awesome.min.css?v=4.4.0" rel="stylesheet">
	    <link href="css/animate.css" rel="stylesheet">
	    <link href="css/style.css?v=4.1.0" rel="stylesheet">
	    
	    <link type="text/css" rel="stylesheet" href="css/custom.css" />
	    <link type="text/css" rel="stylesheet" href="plugins/toastr/css/toastr.min.css"/>
	    
	    
	    <style type="text/css">
			.c{
				border: 1px solid gray;
			}
		</style>
    
	</head>
	<body  class="fixed-sidebar full-height-layout gray-bg fixed-nav pace-done" style="overflow:hidden">
	<!-- 加载动画 
	<div class="preloader" 
		 style=" position: fixed;
		 width: 100%;
		 height: 100%;
		 top: 0;
		 left: 0;
		 z-index: 100000;
		 backface-visibility: hidden;
		 background: #ffffff;">
   		<div class="preloader_img" 
   			 style="width: 200px;
		  	 height: 200px;
		  	 position: absolute;
		  	 left: 48%;
		  	 top: 48%;
		  	 background-position: center;
			 z-index: 999999">
             <img src="images/loader.gif" style=" width: 50px;" alt="loading...">
    	</div>
	</div>
	-->
		<div id="wrapper">
		<!--左侧导航开始-->
			<nav class="navbar-default navbar-static-side" role="navigation">
				<div class="nav-close"><i class="fa fa-times-circle"></i></div>
				<div class="sidebar-collapse">
					<ul class="nav" id="side-menu">
						<li class="nav-header">
							<div class="dropdown profile-element">
								<!-- 头像图片 -->
								<span><img alt="image" class="img-circle" width="65px" height="65px" src="${session.user.userImage}"/></span>
								<a data-toggle="dropdown" class="dropdown-toggle" href="#">
									<span class="clear">
										<!-- 用户名 -->
										<span class="block m-t-xs"><strong class="font-bold">您好：${session.user.userName}</strong></span>
										<!-- 用户角色 -->
										<span class="text-muted text-xs block">${session.user.mailName}<b class="caret"></b></span>
									</span>
								</a>
								<!-- 用户下拉列表 -->
								<ul class="dropdown-menu animated fadeInRight m-t-xs">
									<li>
										<a class="J_menuItem" href="form_avatar.html">修改密码</a>
                                	</li>
                                	<li>
                                		<a href="login.html">安全退出</a>
                                	</li>
								</ul>
								<div class="logo-element">MVC</div>
							</div>
						</li>
						<li>
							<a href="mailbox.html">
								<i class="fa fa fa-bar-chart-o"></i>
								<span class="nav-label">信箱 </span>
								<span class="label label-warning pull-right">16</span>
							</a>
                        	<ul class="nav nav-second-level">
								<li>
	                                <a class="J_menuItem" href="mail_send.jsp">
										<i class="fa fa-envelope"></i> 
										<span class="nav-label">写信</span>
									</a>
	                            </li>
	                            <li>
	                                <a class="J_menuItem" href="${pageContext.request.contextPath }/receivemail.action">
										<i class="fa fa-inbox"></i> 
										<span class="nav-label">收信</span>
										<span class="label label-warning pull-right">16</span>
									</a>
	                            </li>
	                            <li>
		                            <a class="J_menuItem" href="lockscreen.html">
										<i class="fa fa-users"></i> 
										<span class="nav-label">通讯录</span>
									</a>
								</li>
								<li>
		                            <a href="#">
										<span class="nav-label">信箱列表</span>
										<span class="fa arrow"></span>
									</a>
									<ul class="nav nav-third-level">
	                                    <li><a class="J_menuItem" href="mail_inbox.html">收件箱</a></li>
	                                    <li><a class="J_menuItem" href="agile_board.html">星标邮件</a></li>
	                                    <li><a class="J_menuItem" href="agile_board1.html">群邮件</a></li>
	                                    <li><a class="J_menuItem" href="agile_board2.html">草稿箱</a></li>
	                                    <li><a class="J_menuItem" href="agile_board3.html">已发送</a></li>
	                                    <li><a class="J_menuItem" href="agile_board5.html">垃圾箱</a></li>
	                                </ul>
								</li>
							</ul>
						</li>
						<li>
							<a class="J_menuItem" href="calendar.html">
								<i class="fa fa fa-calendar"></i>
								<span class="nav-label">日历 </span>
							</a>
                        	
						</li>
						<li>
							<a href="mailbox.html">
								<i class="fa fa fa-calendar"></i>
								<span class="nav-label">博客 </span>
								<span class="fa arrow"></span>
							</a>
                        	<ul class="nav nav-second-level">
								<li>
	                                <a class="J_menuItem" href="graph_echarts.html">写博客</a>
	                            </li>
	                            <li>
	                                <a class="J_menuItem" href="graph_echarts.html">我的博客</a>
	                            </li>
	                            <li>
	                                <a class="J_menuItem" href="graph_echarts.html">博客列表</a>
	                            </li>
							</ul>
						</li>
						<li>
							<a href="mailbox.html">
								<i class="fa fa-picture-o"></i>
								<span class="nav-label">相册 </span>
								<span class="fa arrow"></span>
							</a>
                        	<ul class="nav nav-second-level">
								<li>
	                                <a class="J_menuItem" href="graph_echarts.html">111</a>
	                            </li>
	                            <li>
	                                <a class="J_menuItem" href="graph_echarts.html">222</a>
	                            </li>
							</ul>
						</li>
						<li>
							<a href="mailbox.html">
								<i class="fa fa-picture-o"></i>
								<span class="nav-label">即时通讯 </span>
								<span class="fa arrow"></span>
							</a>
                        	<ul class="nav nav-second-level">
								<li>
	                                <a class="J_menuItem" href="graph_echarts.html">111</a>
	                            </li>
	                            <li>
	                                <a class="J_menuItem" href="graph_echarts.html">222</a>
	                            </li>
							</ul>
						</li>
						<li>
							<a href="mailbox.html">
								<i class="fa fa-picture-o"></i>
								<span class="nav-label">任务清单 </span>
								<span class="fa arrow"></span>
							</a>
                        	<ul class="nav nav-second-level">
								<li>
	                                <a class="J_menuItem" href="graph_echarts.html">111</a>
	                            </li>
	                            <li>
	                                <a class="J_menuItem" href="graph_echarts.html">222</a>
	                            </li>
							</ul>
						</li>
					</ul>
				</div>
			</nav>
			<!--左侧导航结束-->
        	<!--右侧部分开始-->
        	<div id="page-wrapper" class="gray-bg dashbard-1">
        		<div class="row border-bottom">
        			<nav class="navbar navbar-fixed-top" role="navigation" style="margin-bottom: 0 ;background:#345f73">
        				<div class="col-md-4">
        					<div class="row">
	        					<div class="col-md-3">
		        					<a class="navbar-minimalize minimalize-styl-2 btn btn-primary " href="#">
		        						<i class="fa fa-bars"></i> 
		        					</a>
		        				</div>
		        				<div class="col-md-9" align="left" style="margin-top:15px">
		                            	<h3 style=" color:#FFF; font-size:20px">欢迎来到mail.zwt.com</h3>
		        				</div>
        					</div>
	                  	</div>
	                  	<div class="col-md-8" style="padding:0px">
	                  		
	                  		<!-- 右边导航栏 -->
		                    <ul class="nav navbar-top-links navbar-right">
								<li class="dropdown hidden-xs" style="padding-bottom: 2px">
									<form class="navbar-form ">
			        					<div class="form-group">
			          						<input type="text" class="form-control" placeholder="Search">
			        					</div>
			        					<button type="submit" class="btn btn-primary"><i class="fa fa-search text-primary"></i></button>
			      					</form>
								</li>
								<!-- 邮件 -->
		                    	<li class="dropdown hidden-xs" style="padding-bottom: 2px">
		                    		<a href="#" class="right-sidebar-toggle dropdown-toggle" data-toggle="dropdown" aria-expanded="false" style="color:#a7b1c2"> 
		                    			<i class="fa fa-envelope-o fa-1x"></i>
                                		<span class="badge badge-pill badge-warning notifications_badge_top">8</span>
                            		</a>
                            		<ul class="dropdown-menu animated fadeInRight m-t-xs" style="margin-top: 2px">
                            			<li class="dropdown-header">
											<a class="dropdown-item titlec" href="#">You have 9 Notifications</a>
	                                	</li>
	                                	<li>
	                                		<a class="dropdown-item" href="edit_user.html">
	                                			<i class="fa fa-cogs"></i>
                                    			账户设置
                                    		</a>
	                                	</li>
                            		</ul>
                            		
                            		
		                    	</li>
		                    	<!-- 消息 -->
		                    	<li class="dropdown hidden-xs" style="padding-bottom: 2px">
			                    	<a href="#" class="right-sidebar-toggle dropdown-toggle" data-toggle="dropdown" aria-expanded="false" style="color:#a7b1c2"> 
			                    		<i class="fa fa-bell-o"></i>
                                		<span class="badge badge-pill badge-danger notifications_badge_top">9</span>
                            		</a>
                            		<ul class="dropdown-menu animated fadeInRight m-t-xs" style="margin-top: 2px">
                            			<li class="dropdown-header">
											<a class="dropdown-item titlec" href="#">You have 9 Notifications</a>
	                                	</li>
	                                	<li>
	                                		<a class="dropdown-item" href="edit_user.html">
	                                			<i class="fa fa-cogs"></i>
                                    			账户设置
                                    		</a>
	                                	</li>
                            		
                            		
                            		</ul>
		                    	</li>
		                    	<!-- 菜单 -->
		                    	<li class="dropdown hidden-xs" style="padding-bottom: 2px">
		                    		<a class="right-sidebar-toggle" id="request_btn" aria-expanded="false" style="color:#a7b1c2"> 
		                    			&nbsp;&nbsp;<i class="fa fa-sliders" aria-hidden="true"></i>&nbsp;
                            		</a>
                            		
		                    	</li>
		                    	<!-- 人物设置 -->
		                    	<li class="dropdown" hidden-xs style="padding-bottom: 2px">
		                    		<a style="color:#a7b1c2" class="right-sidebar-toggle dropdown-toggle" data-toggle="dropdown" href="#" aria-expanded="false" >
			                    		<img src="images/a5.jpg" class="img-circle" alt="avatar" width="20px" height="20px" > 
			                    		<strong class="font-bold">Micheal<b class="caret"></b></strong>&nbsp;&nbsp;
		                    		</a>
		                    		<!-- 用户下拉列表 -->
									<ul class="dropdown-menu animated fadeInRight m-t-xs" style="margin-top: 2px">
										<li class="dropdown-header">
											<h3 style="padding-top:6px;margin-bottom:0px">Admire Admin</h3>
	                                	</li>
	                                	<li class="divider"></li>
	                                	<li>
	                                		<a class="dropdown-item" href="edit_user.html">
	                                			<i class="fa fa-cogs"></i>
                                    			账户设置
                                    		</a>
	                                	</li>
	                                	<li>
	                                		<a class="dropdown-item" href="#">
                                    			<i class="fa fa-user"></i>
                                    			用户状态
                                			</a>
	                                	</li>
	                                	<li>
	                                		<a class="dropdown-item" href="mail_inbox.html">
	                                			<i class="fa fa-envelope"></i>
                                    			信箱
                                    		</a>
										</li>
										<li>
                                			<a class="dropdown-item" href="lockscreen.html">
                                				<i class="fa fa-lock"></i>
		                                    	锁屏
		                                    </a>
										</li>
                                    	<li>
                                			<a class="dropdown-item" href="login2.html">
                                				<i class="fa fa-sign-out"></i>
                                    			安全退出
                                    		</a>
	                                	</li>
									</ul>
		                    	</li>
			                	<li class="dropdown hidden-xs">
			                    	<a  href="login.html" class="right-sidebar-toggle" aria-expanded="false" style="color:#a7b1c2">
			                        	<i class="fa fa fa-sign-out"></i>退出
			                     	</a>
			            		</li>
		               		</ul>
	                    </div>
        			</nav>
        		</div>
        		<!-- 页面导航 -->
        		<div class="row content-tabs">
        			<button class="roll-nav roll-left J_tabLeft">
        				<i class="fa fa-backward"></i>
                	</button>
        			<nav class="page-tabs J_menuTabs">
        				<div class="page-tabs-content">
	                        <a href="javascript:;" class="active J_menuTab" data-id="index_v1.html">首页</a>
	                    </div>	
        			</nav>
        			<button class="roll-nav roll-right J_tabRight">
        				<i class="fa fa-forward"></i>
                	</button>
                	<div class="btn-group roll-nav roll-right">
                		<button class="dropdown J_tabClose" data-toggle="dropdown">
	                		关闭操作
	                		<span class="caret"></span>
                    	</button>
                    	<ul role="menu" class="dropdown-menu dropdown-menu-right">
                    		<li class="J_tabShowActive"><a>定位当前选项卡</a></li>
                    		<li class="divider"></li>
                    		<li class="J_tabCloseAll"><a>关闭全部选项卡</a></li>
                        	<li class="J_tabCloseOther"><a>关闭其他选项卡</a></li>
                    	</ul>
                	</div>
                	<a href="#" class="roll-nav roll-right J_tabExit" id="alarm-fullscreen-toggler"><i class="fa fa-arrows-alt"></i> 全屏</a>
        		</div>
        		<!-- 中间面板 -->
        		<div class="row J_mainContent" id="content-main">
	                <iframe class="J_iframe" name="iframe0" width="100%" height="100%" src="index_box.jsp" frameborder="0" data-id="index_v1.html" seamless></iframe>
	            </div>
	            <!-- 底部面板 -->
	            <div class="footer">
	                <div class="pull-right">
	                	&copy; 2019 
	                	<a href="#" target="_blank">zwt.com</a>
	                </div>
	            </div>
        		
        	</div>
		</div>
		
		
		<script src="js/jquery.min.js?v=2.1.4"></script>
	    <script src="js/quanping.js"></script>
	    <script src="js/bootstrap.min.js?v=3.3.6"></script>
	    <script src="plugins/metisMenu/jquery.metisMenu.js"></script>
	    <script src="plugins/slimscroll/jquery.slimscroll.min.js"></script>
	    <script src="plugins/layer/layer.min.js"></script>
	    <script type="text/javascript" src="plugins/toastr/js/toastr.min.js"></script>
	
	    <!-- 自定义js -->
	    <script src="js/hplus.js?v=4.1.0"></script>
	    <script type="text/javascript" src="js/contabs.js"></script>
	    <script type="text/javascript" src="js/zwt.js"></script>
	
	    <!-- 第三方插件 -->
    	<script src="plugins/pace/pace.min.js"></script>
	</body>
</html>