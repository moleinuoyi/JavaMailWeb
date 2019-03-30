<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<link type="text/css" rel="stylesheet" href="css/components.css" />
	<link type="text/css" rel="stylesheet" href="css/custom.css" />
<!-- end of global styles-->

	<link type="text/css" rel="stylesheet" href="plugins/jasny-bootstrap/css/jasny-bootstrap.min.css"/>
	<link type="text/css" rel="stylesheet" href="plugins/fullcalendar/css/fullcalendar.min.css"/>
    <link type="text/css" rel="stylesheet" href="plugins/toastr/css/toastr.min.css"/>
	
	<link type="text/css" rel="stylesheet" href="css/profile.css"/>
	<link type="text/css" rel="stylesheet" href="css/calendar_custom.css"/>
	<link type="text/css" rel="stylesheet" href="css/new_dashboard.css"/>
	
</head>
<body class="body">
	<div id="wrap">
		<div class="wrapper">
			<div id="content" class="bg-container" style="background-color:#e7eaec;">
				<div class="outer">
					<div class="inner bg-container"  style="background-color:#f3f3f4;;">
						<div class="row">
							<div class="col-md-4" style="margin-rigght:-10px">
								<div class="card bg-success top_cards">
						         	<div class="row">
						              	<div class="col-md-12" style="margin-bottom: -20px">
						                   	<font face="华文新魏" size="7"><span id="showTime"></span></font>
						         		</div>
						     	   	</div>
						     	   	<div class="row">
						              	<div class="col-md-12">
						               		<font face="华文新魏" size="6">&nbsp;&nbsp;${session.user.userName}</font>
						              	</div>
						            </div>
						            <div class="row">
						              	<div class="col-md-12 text-center" style="margin-bottom: 10px;margin-top: -5px;">
						               		<font size="2">——${session.user.discription}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font>
						              	</div>
						            </div>
					      			<div class="row">   
						             	<div class="col-md-12 text-right">
						                   	<font face="华文新魏" size="7"><span id="clock"></span></font>
						              	</div>
						          	</div>
						        </div>	
							</div>
							<div class="col-md-5">
								<!-- 天气 -->
								<div class="card weather_section md_align_section">
									<div class="card-block">
										<div class="row margin_align">
											<div class="col-6">
												<div class="icon sun-shower">
													<div class="cloud"></div>
													<div class="sun">
														<div class="rays"></div>
													</div>
													<div class="rain"></div>
												</div>
											</div>
											<div class="col-6">
												<div class="weather-value">
													<span class=" text-white">
														<span class="degree"><span class="low"></span>&deg;~<span class="high"></span>&deg;</span>
													</span>
												</div>
												<div class="weather_location">
													<span class="text-white"><i class="fa fa-map-marker"></i><span id="city"></span></span>
												</div>
											</div>
										</div>
										<!-- 周一到周四 -->
										<div class="row weekly_report">
											<div class="col-3">
												<span id="date1"></span> <br/> 
												<img src="#" alt="weather" id="weather1">
												<p><span id="low1"></span>&deg;~<span id="high1"></span>&deg;</p>
											</div>
											<div class="col-3">
												<span id="date2"></span> <br/> 
												<img src="images/w3.png" alt="weather" id="weather2">
												<p><span id="low2"></span>&deg;~<span id="high2"></span>&deg;</p>
											</div>
											<div class="col-3">
												<span id="date3"></span> <br/> 
												<img src="images/w5.png" alt="weather" id="weather3">
												<p><span id="low3"></span>&deg;~<span id="high3"></span>&deg;</p>
											</div>
											<div class="col-3">
												<span id="date4"></span> <br/> 
												<img src="images/w1.png" alt="weather" id="weather4">
												<p><span id="low4"></span>&deg;~<span id="high4"></span>&deg;</p>
											</div>
										</div>
									</div>
								</div>
							</div>
							<div class="col-md-3">
							<!-- 图标 -->
								<div class="row">
									<div class="col-md-12">
									<!-- 图标1信件 -->
										<div class="card bg-warning top_cards">
											<div class="row icon_margin_left">
												<div class="col-5 icon_padd_left">
													<div class="float-left">
														<span class="fa-stack fa-sm">
		                                                    <i class="fa fa-circle fa-stack-2x"></i>
		                                                    <i class="fa fa-envelope-o fa-stack-1x fa-inverse text-warning sales_hover"></i>
		                                                </span>
													</div>
												</div>
												<div class="col-7 icon_padd_right">
		                                            <div class="float-right cards_content">
		                                                <span class="number_val" id="sales_count">8</span>
		                                                <i class="fa fa-envelope-o fa-2x"></i><br/>
		                                                <span class="card_description">信&nbsp;&nbsp;件&nbsp;&nbsp;&nbsp;&nbsp;</span>
		                                            </div>
                                           		</div>
											</div>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-12">
									<!-- 图标二通知 -->
										<div class="card bg-danger top_cards">
											<div class="row icon_margin_left">
												<div class="col-5 icon_padd_left">
													<div class="float-left">
														<span class="fa-stack fa-sm">
		                                                    <i class="fa fa-circle fa-stack-2x"></i>
		                                    	         	<i class="fa fa-bell-o fa-stack-1x fa-inverse text-danger sales_hover"></i>
		                                           		</span>
													</div>
												</div>
												<div class="col-7 icon_padd_right">
		                                            <div class="float-right cards_content">
		                                                <span class="number_val" id="sales_count">9</span>
		                                                <i class="fa fa-bell-o fa-2x"></i><br/>
		                                                <span class="card_description">通&nbsp;&nbsp;知&nbsp;&nbsp;&nbsp;&nbsp;</span>
		                                            </div>
                                           		</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
						<!-- 第一行 -->
						<div class="row">
							<!-- 要做清单 -->
							<div class="col-md-8">
							<div class="row">
							
								<div class="col-md-7">
									<div id="area-chart" class="flotChart3" style="display:none;"></div>
	                            	<div id="realtime" class="flotChart4 " style="display:none;"></div>
									<div class="card to_do"  style="margin-top:20px">
	                            	    <div class="card-header bg-white">
	                                        To Do List
	                                    </div>
	                                    <div class="card-block no-padding to_do_section">
	                                        <div class="row">
	                                            <div class="todo_section" style="width:100%">
	                                                <form class="list_of_items">
	                                                    <div class="todolist_list showactions px-3">
	                                                        <div class="row">
	                                                            <div class="col-9 nopad custom_textbox1">
	                                                                <div class="todo_primarybadge"></div>
	                                                                <div class="todoitemcheck">
	                                                                    <input type="checkbox" class="striked"/>
	                                                                </div>
	                                                                <div class="todotext todoitem todo_width" >列出需要做的清单！</div>
	                                                            </div>
	                                                            <div class="col-3  float-right showbtns todoitembtns">
	                            	                              	<a href="#" class="todoedit">
	                                                                    <span class="fa fa-pencil"></span>
	                                                                </a>
	                                                                <span class='dividor'>|</span>
	                                                                <a href="#" class="tododelete redcolor">
	                                                                    <span class="fa fa-trash"></span>
	                                                                </a>
	                                                            </div>
	                                                            <span class="seperator"></span>
	                                                        </div>
	                                                    </div>
	                                                </form>
	                                            </div>
	                                            <form id="main_input_box" class="form-inline">
	                                                <div class="input-group todo">
	                                                        <span class="input-group-btn">
	                                            	           	<a class="btn btn-primary" tabindex="0" role="button" data-toggle="popover" data-trigger="focus" data-contentwrapper=".mycontent" id="btn_color" data-badge="todo_mintbadge">
	                                                           		Color&nbsp;&nbsp;
	                                                           		<i class="fa fa-caret-right"> </i>
	                                                           	</a>
	                                                        </span>
	                                                    <input id="custom_textbox" name="Item" type="text" required
	                                                           placeholder="Write and hit enter"
	                                                           class="input-md form-control" size="75"/>
	                                                </div>
	                                            </form>
	                                        </div>
	                                        <div class="mycontent">
	                                            <div class="border_color bg-danger border_danger"
	                                                 data-color="btn-danger" data-badge="bg-danger"></div>
	                                            <div class="border_color bg-primary border_primary"
	                                                 data-color="btn-primary" data-badge="bg-primary"></div>
	                                            <div class="border_color bg-info border_info" data-color="btn-info"
	                                                 data-badge="bg-info"></div>
	                                            <div class="border_color bg-mint border_mint" data-color="btn-mint"
	                                                 data-badge="bg-mint"></div>
	                                        </div>
	                                    </div>
	                                </div>
								</div>
								<!-- 记事本 -->
								<div class="col-md-5">
									<div class="block widget-notes" style="margin-top:20px">
                                        <div class="card" id="notes_section">
                                            <div class="card-header bg-white">
                                                Notes
                                            </div>
                                            <div class="content">
                                                <div class="notes" contenteditable="true">
                                                    <div>
                                                        <br>
                                                        <br>
                                                        <br>
                                                        <br>
                                                        <br>
                                                        <br>
                                                        <br>
                                                        <br>
                                                        <br>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
								</div>
	                        </div>	
							</div>
							
							<!-- 日历 -->
							<div class="col-md-4">
								<div class="card-block m-t-35 padding-body view_user_cal" style="margin-top:0px">
		                       		<div id="calendar_mini" class="bg-mint"></div>
		                        </div>
							</div>
							
							
						</div>
						<!-- 第2行 -->
					</div>
				</div>
			</div>
		</div>
	</div>

	<script type="text/javascript" src="js/components.js"></script>
	<script type="text/javascript" src="js/custom.js"></script>
	<!--End of Global scripts-->
	<!--Plugin scripts-->
	<script type="text/javascript" src="plugins/toastr/js/toastr.min.js"></script>
	<script type="text/javascript" src="plugins/switchery/js/switchery.min.js"></script>
	<script type="text/javascript" src="plugins/flotchart/js/jquery.flot.js"></script>
	<script type="text/javascript" src="plugins/bootstrap_calendar/js/bootstrap_calendar.min.js"></script>
	
	<script type="text/javascript" src="js/mini_calendar.js"></script>
	<script type="text/javascript" src="js/new_dashboard.js"></script>
	<!-- 
	 -->
	<script type="text/javascript">
		window.onload=function()
	    {
			getTime();
			showHolle();
			getWeather();
	    }
		function showHolle(){
			var now = new Date()
			var hour = now.getHours()
			if (hour > 3 && hour < 7) {
				document.getElementById("showTime").innerHTML = "凌晨好！";
			} else if (hour < 9) {
				document.getElementById("showTime").innerHTML = "早上好！";
			} else if (hour < 11) {
				document.getElementById("showTime").innerHTML = "上午好！";
			} else if (hour < 14) {
				document.getElementById("showTime").innerHTML = "中午好！";
			} else if (hour < 17) {
				document.getElementById("showTime").innerHTML = "下午好！";
			} else if (hour < 19) {
				document.getElementById("showTime").innerHTML = "傍晚好！";
			} else if (hour < 22) {
				document.getElementById("showTime").innerHTML = "晚上好！";
			} else {
				document.getElementById("showTime").innerHTML = "深夜了,早点睡!";
			}
		}
		
	</script>
	<script type="text/javascript">
		//取得系统当前时间
		function getTime(){
			var myDate = new Date();
			var hours = myDate.getHours();
			var minutes = myDate.getMinutes();
			var seconds = myDate.getSeconds();
			
			if(hours == 0){
	            hours = '00';
	        }else if(hours < 10){
	            hours = '0' + hours;
	        }else{
	            hours = hours;
	        }
			if(minutes == 0){
				minutes = '00';
	        }else if(minutes < 10){
	        	minutes = '0' + minutes;
	        }else{
	        	minutes = minutes;
	        }
			if(seconds == 0){
				seconds = '00';
	        }else if(seconds < 10){
	        	seconds = '0' + seconds;
	        }else{
	        	seconds = seconds;
	        }
			document.getElementById("clock").innerHTML = hours+":"+minutes+":"+seconds+"&nbsp;&nbsp;";
		}
		window.setInterval("getTime();",1000); //每隔一秒运行一次
		window.setInterval("showHolle();",60000);
	</script>
	<script type="text/javascript">
		function getWeather() {
	        $.ajax({
	            // 请求地址
	            url: 'http://wthrcdn.etouch.cn/weather_mini?city=深圳',
	            // 请求类型：GET/POST
	            type: 'GET',
	            // 请求参数，是一个字符串。
	            // data: '',
	            // 指定服务器返回的数据类型
	            dataType: 'json',
	            // 指定请求失败的回调函数
	            error: function (data, status) {
	                console.log('请求失败：', status, data);
	            },
	            // 请求成功的回调函数
	            success: function (data, status) {
	                // 请求成功，得到json数据，解析json数据，将数据展示到页面中。
	                //console.log('请求成功：', data);
	                var city = data.data.city;
                    var high = data.data.forecast[0].high;
                    high = high.substring(3,high.length-1);
                    var low = data.data.forecast[0].low;
                    low = low.substring(3,low.length-1);
                    var date = data.data.forecast[0].date;
                    date = date.substring(3);
                    var type = data.data.forecast[0].type;
                    
	                // 通过js给p标签赋值
	                $('#city').text(city);
	                $('.high').text(high);
                    $('.low').text(low);
                    $('#date').text(date);
                    
                    var high1 = data.data.forecast[1].high;
                    high1 = high1.substring(3,high1.length-1);
                    var low1 = data.data.forecast[1].low;
                    low1 = low1.substring(3,low1.length-1);
                    var date1 = data.data.forecast[1].date;
                    date1 = date1.substring(3);
                    var type1 = data.data.forecast[1].type;
                    $('#high1').text(high1);
                    $('#low1').text(low1);
                    $('#date1').text(date1);
                    if(type1.indexOf("雨")>0){
                    	document.getElementById("weather1").src="images/w3.png";
                    }else if(type1.indexOf("多云")>0){
                    	document.getElementById("weather1").src="images/w5.png";
                    }else if(type1.indexOf("阴天")>0){
                    	document.getElementById("weather1").src="images/w1.png";
                    }else if(type1.indexOf("晴")>0){
                    	document.getElementById("weather1").src="images/w4.png";
                    }
                    
                    
                    var high2 = data.data.forecast[2].high;
                    high2 = high2.substring(3,high2.length-1);
                    var low2 = data.data.forecast[2].low;
                    low2 = low2.substring(3,low2.length-1);
                    var date2 = data.data.forecast[2].date;
                    date2 = date2.substring(3);
                    var type2 = data.data.forecast[2].type;
                    $('#high2').text(high2);
                    $('#low2').text(low2);
                    $('#date2').text(date2);
                    
                    var high3 = data.data.forecast[3].high;
                    high3 = high3.substring(3,high3.length-1);
                    var low3 = data.data.forecast[3].low;
                    low3 = low3.substring(3,low3.length-1);
                    var date3 = data.data.forecast[3].date;
                    date3 = date3.substring(3);
                    var type3 = data.data.forecast[3].type;
                    $('#high3').text(high3);
                    $('#low3').text(low3);
                    $('#date3').text(date3);
                    
                    var high4 = data.data.forecast[4].high;
                    high4 = high4.substring(3,high4.length-1);
                    var low4 = data.data.forecast[4].low;
                    low4 = low4.substring(3,low4.length-1);
                    var date4 = data.data.forecast[4].date;
                    date4 = date4.substring(3);
                    var type4 = data.data.forecast[4].type;
                    $('#high4').text(high4);
                    $('#low4').text(low4);
                    $('#date4').text(date4);
	            },
	
	            // 发起请求的方式：同步(false)还是异步(true)
	            async: true
	        });
	    }
	</script>
</body>
</html>