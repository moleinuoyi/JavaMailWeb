/* Toastr notifications */
    var i = -1;
    var toastCount = 0;
    var $toastlast;

    var shortCutFunction = "success";
    var msg = "感谢您的支持！";
    var title = "<span>欢迎来到！</span> <h5 class='text-white'>mail.zwt.com</h5>";
    var $showDuration = 1000;
    var $hideDuration = 1000;
    var $timeOut = 5000;
    var $extendedTimeOut = 1000;
    var $showEasing = "swing";
    var $hideEasing = "linear";
    var $showMethod = "fadeIn";
    var $hideMethod = "fadeOut";
    var toastIndex = toastCount++;
    toastr.options = {
        closeButton: $('#closeButton').prop('checked'),
        debug: $('#debugInfo').prop('checked'),
        positionClass: 'toast-top-right',
        onclick: null
    };
    if ($('#addBehaviorOnToastClick').prop('checked')) {
        toastr.options.onclick = function() {
            alert('You can perform some custom action after a toast goes away');
        };
    }
    if ($showDuration.length) {
        toastr.options.showDuration = $showDuration;
    }
    if ($hideDuration.length) {
        toastr.options.hideDuration = $hideDuration;
    }
    if ($timeOut.length) {
        toastr.options.timeOut = $timeOut;
    }
    if ($extendedTimeOut.length) {
        toastr.options.extendedTimeOut = $extendedTimeOut;
    }
    if ($showEasing.length) {
        toastr.options.showEasing = $showEasing;
    }
    if ($hideEasing.length) {
        toastr.options.hideEasing = $hideEasing;
    }
    if ($showMethod.length) {
        toastr.options.showMethod = $showMethod;
    }
    if ($hideMethod.length) {
        toastr.options.hideMethod = $hideMethod;
    }
    $("#toastrOptions").text("Command: toastr[" + shortCutFunction + "](\"" + msg + (title ? "\", \"" + title : '') + "\")\n\ntoastr.options = " + JSON.stringify(toastr.options, null, 2));
    var $toast = toastr[shortCutFunction](msg, title); // Wire up an event handler to a button in the toast, if it exists
    $toastlast = $toast;

function loadjscssfile(filename, filetype) {
    if (filetype == "css") {
        var fileref = document.createElement("link");
        fileref.rel = "stylesheet";
        fileref.type = "text/css";
        fileref.href = 'css/skins/' + filename;
        $("#skin_change").attr("href", "css/skins/"+filename+"")
    }
}
(function ($, Admire) {
    var $body = $('body'),
        $leftToggle = $('.toggle-left'),
        $rightToggle = $('.toggle-right');
    var leftopened = 0;
    var demo = $("<div />").css({
        position: "fixed",
        top: "200px",
        right: "-1px",
        transition: 'all 0.3s ease-in-out',
        background: "#00cc99",
        "border-radius": "5px 0px 0px 5px",
        padding: "5px",
        "font-size": "16px",
        cursor: "pointer",
        color: "#ddd"
    }).html(" <i class='fa fa-fw fa-cog skin-icon'></i>").addClass("no-print"); 
    $body.append(demo);
    $(".no-print").on("mouseenter mouseleave", function(){
        $(".skin-icon").toggleClass("fa-spin");
        return false;
    });
    
    return Admire;
})(jQuery, Admire || {});