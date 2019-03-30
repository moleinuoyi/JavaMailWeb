<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Insert title here</title>
		
		<link type="text/css" rel="stylesheet" href="css/components.css" />
		<link type="text/css" rel="stylesheet" href="css/custom.css" />
	<!-- end of global styles-->
	
		<link type="text/css" rel="stylesheet" href="plugins/fullcalendar/css/fullcalendar.min.css"/>
	    <link type="text/css" rel="stylesheet" href="plugins/toastr/css/toastr.min.css"/>
		
		<link type="text/css" rel="stylesheet" href="css/mail_box.css"/>
		<style type="text/css">
			.td-link:hover { cursor: pointer; }
		</style>
	<!-- style="background-color:#f3f3f4;" -->
	</head>
	<body class="body ">
		<div id="wrap" style="background-color:#f3f3f4;">
			<div class="wrapper">
				<div id="content" class="bg-container" style="background-color:#f3f3f4;">
					<div class="outer">
						<div class="inner bg-light lter bg-container cal_btn_hov" style="background-color:#f3f3f4;">
							<div class="row web-mail">
								<div class="col-md-12 ">
									<div class="card mail media_max_991">
	                                	<div class="card-header bg-white">
	                                		<div class="row">
	                                			<div class="col-md-8 col-12 m-t-10 dropdown_list_hover">
	                                				<div class="btn-group float-left table-bordereds">
	                                					
	                                					<label class="custom-control custom-checkbox mr-0 mb-0">
		                                                    <input type="checkbox" class="custom-control-input select-all">
		                                                    <span class="custom-control-indicator"></span>
		                                                    	全选
		                                                </label>
	                                				</div>
	                                				
		                                            <button type="button" class="btn btn-labeled btn-primary" id="refresh_inbox">
	                                                   	<span class="btn-label">
	                                                     	<i class="fa fa-refresh fa-spin"></i>
	                                                   	</span>
	                                                   	刷新
	                                                </button>
		                                            <button type="button" class="btn btn-labeled btn-warning">
	                                                   	<span class="btn-label">
	                                                     	<i class="fa fa-trash-o"></i>
	                                                   	</span>
	                                                   	删除
	                                                </button>
	                                                <button type="button" class="btn btn-labeled btn-danger">
	                                                   	<span class="btn-label">
	                                                     	<i class="fa fa-trash-o"></i>
	                                                   	</span>
	                                                   	彻底删除
	                                                </button>
		                                            <span class="dropdown">
	                                                  	<button class="btn btn-mint dropdown-toggle" type="button" data-toggle="dropdown" >
	                                                    	标记为
	                                                   	</button>
	                                                    <span class="dropdown-menu" aria-labelledby="about-us1">
	                                                   		<s:iterator value="#session.Status" id="sta">
	                                                    		<a class="dropdown-item" href="receivemailcommons.action?localId=#sta.id"><s:property value='#sta.statusName'/></a>
	                                                    	</s:iterator>
	                                                      	<hr style="margin-top:2px;margin-bottom:2px;"/>
	                                                      	<a class="dropdown-item" href="#">新建文件夹</a>
	                                                  	</span>
	                                              	</span>
	                                              	<span class="dropdown">
	                                                  	<button class="btn btn-mint dropdown-toggle" type="button" data-toggle="dropdown" >
	                                                    	移动到
	                                                   	</button>
	                                                    <span class="dropdown-menu" aria-labelledby="about-us1">
	                                                   		<s:iterator value="#session.Locals" id="loc">
	                                                    		<a class="dropdown-item" href="receivemailcommons.action?localId=#loc.id"><s:property value='#loc.loaclName'/></a>
	                                                    	</s:iterator>
	                                                      	<hr style="margin-top:2px;margin-bottom:2px;"/>
	                                                      	<a class="dropdown-item" href="#">新建文件夹</a>
	                                                  	</span>
	                                              	</span>
	                                			</div>
	                                			<!-- 头部右边搜索框 -->
	                                			<div class="col-md-4 col-12">
		                                            <div class="input-group margin bottom">
		                                                <input type="text" class="form-control inbox_search_height m-t-10" placeholder="Search">
		                                                <span class="input-group-btn">
		                                                <button type="button" class="btn btn-mint inbox_search_height m-t-10">Search</button>
		                                            </span>
		                                            </div>
		                                        </div>
	                                		</div>
	                                	</div>
	                                	<!-- 第二行分类菜单 -->
	                                	<div class="card-block m-t-25 p-d-0">
	                                		<div class="tabs tabs-bordered tabs-icons">
	                                			<ul class="nav nav-tabs">
		                                            <li class="nav-item active" id="primary2">
		                                                <a href="#primary" class="nav-link" data-toggle="tab"
		                                                   aria-expanded="true"><i class="fa fa-inbox"></i> Primary</a>
		                                            </li>
		                                            <li class="nav-item" id="social2">
		                                                <a href="#social" class="nav-link" data-toggle="tab"
		                                                   aria-expanded="false"><i class="fa fa-group"></i> Social</a>
		                                            </li>
		                                            <li class="nav-item" id="promotions2">
		                                                <a href="#promotions" class="nav-link" data-toggle="tab"
		                                                   aria-expanded="false"><i class="fa fa-star"></i> Promotions</a>
		                                            </li>
		                                        </ul>
		                                        <div class="tab-content">
		                                        	<div class="tab-pane table-responsive reset padding-all fade active show" id="primary">
		                                        		<table class="table">
	                                                    <tbody>
	                                                    	<s:iterator value="#request.MailAll" id="mail">
	                                                    		<s:if test="#mail.nature == \"private\"">
	                                                    			<s:if test="#mail.status == 3">
		                                                    			<tr class="mail-unread">
				                                                    		<td>
					                                                            <div class="checker m-l-20">
					                                                                <label class="custom-control custom-checkbox">
					                                                                    <input name="checkbox" type="checkbox"
					                                                                           class="custom-control-input ">
					                                                                    <span class="custom-control-indicator"></span>
					                                                                </label>
					                                                            </div>
					                                                        </td>
					                                                        <td><i class="fa fa-envelope"></i></td>
					                                                        <td><i class="fa fa-star"></i></td>
					                                                        <td class="td-link" onclick="window.document.location = 'lookmail.action?mailId=<s:property value='#mail.id'/>'">
					                                                        	<s:property value='#mail.sendPeople'/>
					                                                        </td>
					                                                        <td class="td-link" onclick="window.document.location = 'lookmail.action?mailId=<s:property value='#mail.id'/>'">
					                                                        	<s:property value='#mail.mailTitle'/>
					                                                        </td>
					                                                        <td class="td-link" onclick="window.document.location = 'lookmail.action?mailId=<s:property value='#mail.id'/>'">
					                                                        </td>
					                                                        <td class="td-link" onclick="window.document.location = 'lookmail.action?mailId=<s:property value='#mail.id'/>'">
					                                                        	<s:property value='#mail.dateTime'/>
					                                                        </td>
		                                                    			</tr>
		                                                    		</s:if>
		                                                    		<s:else>
		                                                    			<tr>
				                                                    		<td>
					                                                            <div class="checker m-l-20">
					                                                                <label class="custom-control custom-checkbox">
					                                                                    <input name="checkbox" type="checkbox"
					                                                                           class="custom-control-input ">
					                                                                    <span class="custom-control-indicator"></span>
					                                                                </label>
					                                                            </div>
					                                                        </td>
					                                                        <td><i class="fa fa-inbox"></i></td>
					                                                        <td><i class="fa fa-star"></i></td>
					                                                        <td class="td-link" onclick="window.document.location = 'lookmail.action?mailId=<s:property value='#mail.id'/>'">
					                                                        	<s:property value='#mail.sendPeople'/>
					                                                        </td>
					                                                        <td class="td-link" onclick="window.document.location = 'lookmail.action?mailId=<s:property value='#mail.id'/>'">
					                                                        	<s:property value='#mail.mailTitle'/>
					                                                        </td>
					                                                        <td class="td-link" onclick="window.document.location = 'lookmail.action?mailId=<s:property value='#mail.id'/>'">
					                                                        	<i class="fa fa-paperclip"></i>
					                                                        </td>
					                                                        <td class="td-link" onclick="window.document.location = 'lookmail.action?mailId=<s:property value='#mail.id'/>'">
					                                                        	<s:property value='#mail.dateTime'/>
					                                                        </td>
		                                                    			</tr>
		                                                    		</s:else>
	                                                    		</s:if>
	                                                    	</s:iterator>
	                                                    </tbody>
	                                                    </table>
														<center>
															<s:if test="#request.Page.hasPrePage">
																<a href="receivemail.action?currentPage=1">首页</a>
																<a href="receivemail.action?currentPage=${Page.currentPage-1}">上一页</a>
															</s:if>
															<s:else>
																首页 上一页
															</s:else>
															(${request.Page.currentPage}/${request.Page.totalPage}，共${request.Page.totalCount}封信)
															<s:if test="#request.Page.hasNextPage">
																<a href="receivemail.action?currentPage=${Page.currentPage+1}">下一页</a>
																<a href="receivemail.action?currentPage=${Page.totalPage}">尾页</a>
															</s:if>
															<s:else>
																下一页 尾页
															</s:else>
														</center>
		                                        	</div>
		                                        	<!-- 社会公众信息列表 -->
		                                        	<div class="tab-pane table-responsive reset padding-all fade" id="social">
		                                                <table class="table">
		                                                <tbody>
		                                                	<s:iterator value="#request.MailAll" id="mail">
	                                                    		<s:if test="#mail.nature == \"social\"">
	                                                    			<s:if test="#mail.status == 3">
		                                                    			<a href="showArticle.action?article_id=<s:property value='#art.Article_id'/>">
		                                                    			<tr class="mail-unread">
				                                                    		<td>
					                                                            <div class="checker m-l-20">
					                                                                <label class="custom-control custom-checkbox">
					                                                                    <input name="checkbox" type="checkbox"
					                                                                           class="custom-control-input ">
					                                                                    <span class="custom-control-indicator"></span>
					                                                                </label>
					                                                            </div>
					                                                        </td>
					                                                        <td><i class="fa fa-envelope"></i></td>
					                                                        <td><i class="fa fa-star"></i></td>
					                                                        <td class="sent_to_mailview"><s:property value='#request.sendPeople'/></td>
					                                                        <td class="sent_to_mailview"><s:property value='#request.mailTitle'/></td>
					                                                        <td class="sent_to_mailview"></td>
					                                                        <td class="sent_to_mailview"><s:property value='#request.dateTime'/></td>
		                                                    			</tr>
		                                                    			</a>
		                                                    		</s:if>
		                                                    		<s:else>
		                                                    			<a href="showArticle.action?article_id=<s:property value='#art.Article_id'/>">
		                                                    			<tr>
				                                                    		<td>
					                                                            <div class="checker m-l-20">
					                                                                <label class="custom-control custom-checkbox">
					                                                                    <input name="checkbox" type="checkbox"
					                                                                           class="custom-control-input ">
					                                                                    <span class="custom-control-indicator"></span>
					                                                                </label>
					                                                            </div>
					                                                        </td>
					                                                        <td><i class="fa fa-inbox"></i></td>
					                                                        <td><i class="fa fa-star"></i></td>
					                                                        <td class="sent_to_mailview"><s:property value='#request.sendPeople'/></td>
					                                                        <td class="sent_to_mailview"><s:property value='#request.mailTitle'/></td>
					                                                        <td class="sent_to_mailview"><i class="fa fa-paperclip"></i></td>
					                                                        <td class="sent_to_mailview"><s:property value='#request.dateTime'/></td>
		                                                    			</tr>
		                                                    			</a>
		                                                    		</s:else>
	                                                    		</s:if>
	                                                    	</s:iterator>
		                                                </tbody>
		                                                </table>
		                                                <center>
															<s:if test="#request.Page.hasPrePage">
																<a href="receivemail.action?currentPage=1">首页</a>
																<a href="receivemail.action?currentPage=${Page.currentPage-1}">上一页</a>
															</s:if>
															<s:else>
																首页 上一页
															</s:else>
															(${request.Page.currentPage}/${request.Page.totalPage}，共${request.Page.totalCount}封信)
															<s:if test="#request.Page.hasNextPage">
																<a href="receivemail.action?currentPage=${Page.currentPage+1}">下一页</a>
																<a href="receivemail.action?currentPage=${Page.totalPage}">尾页</a>
															</s:if>
															<s:else>
																下一页 尾页
															</s:else>
														</center>
	                                                </div>
	                                                <div class="tab-pane table-responsive reset padding-all fade" id="promotions">
	                                                	<table class="table">
	                                                    <tbody>
	                                                    	<s:iterator value="#request.MailAll" id="mail">
	                                                    		<s:if test="#mail.nature == \"promotions\"">
	                                                    			<s:if test="#mail.status == 3">
		                                                    			<a href="showArticle.action?article_id=<s:property value='#art.Article_id'/>">
		                                                    			<tr class="mail-unread">
				                                                    		<td>
					                                                            <div class="checker m-l-20">
					                                                                <label class="custom-control custom-checkbox">
					                                                                    <input name="checkbox" type="checkbox"
					                                                                           class="custom-control-input ">
					                                                                    <span class="custom-control-indicator"></span>
					                                                                </label>
					                                                            </div>
					                                                        </td>
					                                                        <td><i class="fa fa-envelope"></i></td>
					                                                        <td><i class="fa fa-star"></i></td>
					                                                        <td class="sent_to_mailview"><s:property value='#request.sendPeople'/></td>
					                                                        <td class="sent_to_mailview"><s:property value='#request.mailTitle'/></td>
					                                                        <td class="sent_to_mailview"></td>
					                                                        <td class="sent_to_mailview"><s:property value='#request.dateTime'/></td>
		                                                    			</tr>
		                                                    			</a>
		                                                    		</s:if>
		                                                    		<s:else>
		                                                    			<a href="showArticle.action?article_id=<s:property value='#art.Article_id'/>">
		                                                    			<tr>
				                                                    		<td>
					                                                            <div class="checker m-l-20">
					                                                                <label class="custom-control custom-checkbox">
					                                                                    <input name="checkbox" type="checkbox"
					                                                                           class="custom-control-input ">
					                                                                    <span class="custom-control-indicator"></span>
					                                                                </label>
					                                                            </div>
					                                                        </td>
					                                                        <td><i class="fa fa-inbox"></i></td>
					                                                        <td><i class="fa fa-star"></i></td>
					                                                        <td class="sent_to_mailview"><s:property value='#request.sendPeople'/></td>
					                                                        <td class="sent_to_mailview"><s:property value='#request.mailTitle'/></td>
					                                                        <td class="sent_to_mailview"><i class="fa fa-paperclip"></i></td>
					                                                        <td class="sent_to_mailview"><s:property value='#request.dateTime'/></td>
		                                                    			</tr>
		                                                    			</a>
		                                                    		</s:else>
	                                                    		</s:if>
	                                                    	</s:iterator>
	                                                    </tbody>
	                                                    </table>
	                                                    <center>
																	<s:if test="#request.Page.hasPrePage">
																		<a href="receivemail.action?currentPage=1">首页</a>
																		<a href="receivemail.action?currentPage=${Page.currentPage-1}">上一页</a>
																	</s:if>
																	<s:else>
																		首页 上一页
																	</s:else>
																	(${request.Page.currentPage}/${request.Page.totalPage}，共${request.Page.totalCount}封信)
																	<s:if test="#request.Page.hasNextPage">
																		<a href="receivemail.action?currentPage=${Page.currentPage+1}">下一页</a>
																		<a href="receivemail.action?currentPage=${Page.totalPage}">尾页</a>
																	</s:if>
																	<s:else>
																		下一页 尾页
																	</s:else>
																</center>
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
			</div>
		</div>
	
		<script type="text/javascript" src="js/components.js"></script>
		<script type="text/javascript" src="js/custom.js"></script>
		<!--End of Global scripts-->
		<!--Plugin scripts-->
		<script type="text/javascript" src="js/mail_box.js"></script>
	
	</body>
</html>