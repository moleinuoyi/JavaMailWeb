// JavaScript Document
//function FullScreen(el) {
//    var isFullscreen = document.fullScreen || document.mozFullScreen || document.webkitIsFullScreen;
//    if (!isFullscreen) {//进入全屏,多重短路表达式
//        (el.requestFullscreen && el.requestFullscreen()) ||
//        (el.mozRequestFullScreen && el.mozRequestFullScreen()) ||
//        (el.webkitRequestFullscreen && el.webkitRequestFullscreen()) || (el.msRequestFullscreen && el.msRequestFullscreen());

//    } else {	//退出全屏,三目运算符
//        document.exitFullscreen ? document.exitFullscreen() :
//        document.mozCancelFullScreen ? document.mozCancelFullScreen() :
//        document.webkitExitFullscreen ? document.webkitExitFullscreen() : '';
//    }
//}
//function toggleFullScreen(e) {
//    var el = e.srcElement || e.target;//target兼容Firefox
//    el.innerHTML == "<a href='@Url.Action('Index', 'Home')'></a>" ? el.innerHTML = "<a href='@Url.Action('Index', 'Home')'></a>" :
//    FullScreen(el);
//}
$('#alarm-fullscreen-toggler').on('click', function(e) {
		var element = document.documentElement;
		if (!$('body').hasClass("full-screen")) {
			$('body').addClass("full-screen");
			$('#alarm-fullscreen-toggler').addClass("active");
			if (element.requestFullscreen) {
				element.requestFullscreen();
			} else if (element.mozRequestFullScreen) {
				element.mozRequestFullScreen();
			} else if (element.webkitRequestFullscreen) {
				element.webkitRequestFullscreen();
			} else if (element.msRequestFullscreen) {
				element.msRequestFullscreen();
			}
 
		} else {
			$('body').removeClass("full-screen");
			$('#alarm-fullscreen-toggler').removeClass("active");
			if (document.exitFullscreen) {
				document.exitFullscreen();
			} else if (document.mozCancelFullScreen) {
				document.mozCancelFullScreen();
			} else if (document.webkitCancelFullScreen) {
				document.webkitCancelFullScreen();
			} else if (document.msExitFullscreen) {
				document.msExitFullscreen();
			}
		}
	});
