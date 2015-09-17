/***************************/
//@Author: Adrian "yEnS" Mato Gondelle
//@website: www.yensdesign.com
//@email: yensamg@gmail.com
//@license: Feel free to use it, but keep this credits please!					
/***************************/

//SETTING UP OUR POPUP
//0 means disabled; 1 means enabled;
var popupStatus = 0;

//loading popup with jQuery magic!
function loadPopup(){
	//loads popup only if it is disabled
	if(popupStatus==0){
		$("#backgroundPopup").css({
			"opacity": "0.7"
		});
		$("#backgroundPopup").fadeIn("slow");
		$("#popupContact").fadeIn("slow");
		popupStatus = 1;
		
		 $('html, body').animate({scrollTop:0}, 10);
	}
}

//disabling popup with jQuery magic!
function disablePopup(){
	//disables popup only if it is enabled
	if(popupStatus==1){
		$("#backgroundPopup").fadeOut("slow");
		$("#popupContact").fadeOut("slow");
		popupStatus = 0;
		 $('html, body').animate({scrollTop:800}, 10);
	}
}

//centering popup
function centerPopup(){
	//request data for centering
	var windowWidth = document.documentElement.clientWidth;
	var windowHeight = document.documentElement.clientHeight;
	var popupHeight = $("#popupContact").height();
	var popupWidth = $("#popupContact").width();
	//centering
	$("#popupContact").css({
		"position": "absolute",
		"top": 20,
		"left": windowWidth/2-popupWidth/2
	});
	//only need force for IE6
	
	$("#backgroundPopup").css({
		"height": windowHeight
	});
	
}

//loading popup with jQuery magic!
function loadPopup2(){
	//loads popup only if it is disabled
	if(popupStatus==0){
		$("#backgroundPopup2").css({
			"opacity": "0.7"
		});
		$("#backgroundPopup2").fadeIn("slow");
		$("#popupContact2").fadeIn("slow");
		popupStatus = 1;
		 $('html, body').animate({scrollTop:0}, 10);
	}
}

//disabling popup with jQuery magic!
function disablePopup2(){
	//disables popup only if it is enabled
	if(popupStatus==1){
		$("#backgroundPopup2").fadeOut("slow");
		$("#popupContact2").fadeOut("slow");
		popupStatus = 0;
		 $('html, body').animate({scrollTop:800}, 10);
	}
}

//centering popup
function centerPopup2(){
	//request data for centering
	var windowWidth = document.documentElement.clientWidth;
	var windowHeight = document.documentElement.clientHeight;
	var popupHeight = $("#popupContact2").height();
	var popupWidth = $("#popupContact2").width();
	//centering
	$("#popupContact2").css({
		"position": "absolute",
		"top": 20,
		"left": windowWidth/2-popupWidth/2
	});
	//only need force for IE6
	
	$("#backgroundPopup2").css({
		"height": windowHeight
	});
	
}


//loading popup with jQuery magic!
function loadPopup3(){
	//loads popup only if it is disabled
	if(popupStatus==0){
		$("#backgroundPopup3").css({
			"opacity": "0.7"
		});
		$("#backgroundPopup3").fadeIn("slow");
		$("#popupContact3").fadeIn("slow");
		popupStatus = 1;
		 $('html, body').animate({scrollTop:0}, 10);
	}
}

//disabling popup with jQuery magic!
function disablePopup3(){
	//disables popup only if it is enabled
	if(popupStatus==1){
		$("#backgroundPopup3").fadeOut("slow");
		$("#popupContact3").fadeOut("slow");
		popupStatus = 0;
		 $('html, body').animate({scrollTop:800}, 10);
	}
}

//centering popup
function centerPopup3(){
	//request data for centering
	var windowWidth = document.documentElement.clientWidth;
	var windowHeight = document.documentElement.clientHeight;
	var popupHeight = $("#popupContact3").height();
	var popupWidth = $("#popupContact3").width();
	//centering
	$("#popupContact3").css({
		"position": "absolute",
		"top": 20,
		"left": windowWidth/2-popupWidth/2
	});
	//only need force for IE6
	
	$("#backgroundPopup3").css({
		"height": windowHeight
	});
	
}



//loading popup with jQuery magic!
function loadPopup4(){
	//loads popup only if it is disabled
	if(popupStatus==0){
		$("#backgroundPopup4").css({
			"opacity": "0.7"
		});
		$("#backgroundPopup4").fadeIn("slow");
		$("#popupContact4").fadeIn("slow");
		popupStatus = 1;
		 $('html, body').animate({scrollTop:0}, 10);
	}
}

//disabling popup with jQuery magic!
function disablePopup4(){
	//disables popup only if it is enabled
	if(popupStatus==1){
		$("#backgroundPopup4").fadeOut("slow");
		$("#popupContact4").fadeOut("slow");
		popupStatus = 0;
		 $('html, body').animate({scrollTop:800}, 10);
	}
}

//centering popup
function centerPopup4(){
	//request data for centering
	var windowWidth = document.documentElement.clientWidth;
	var windowHeight = document.documentElement.clientHeight;
	var popupHeight = $("#popupContact4").height();
	var popupWidth = $("#popupContact4").width();
	//centering
	$("#popupContact4").css({
		"position": "absolute",
		"top": 20,
		"left": windowWidth/2-popupWidth/2
	});
	//only need force for IE6
	
	$("#backgroundPopup4").css({
		"height": windowHeight
	});
	
}


//loading popup with jQuery magic!
function loadPopup5(){
	//loads popup only if it is disabled
	if(popupStatus==0){
		$("#backgroundPopup5").css({
			"opacity": "0.7"
		});
		$("#backgroundPopup5").fadeIn("slow");
		$("#popupContact5").fadeIn("slow");
		popupStatus = 1;
		 $('html, body').animate({scrollTop:0}, 10);
	}
}

//disabling popup with jQuery magic!
function disablePopup5(){
	//disables popup only if it is enabled
	if(popupStatus==1){
		$("#backgroundPopup5").fadeOut("slow");
		$("#popupContact5").fadeOut("slow");
		popupStatus = 0;
		 $('html, body').animate({scrollTop:800}, 10);
	}
}

//centering popup
function centerPopup5(){
	//request data for centering
	var windowWidth = document.documentElement.clientWidth;
	var windowHeight = document.documentElement.clientHeight;
	var popupHeight = $("#popupContact5").height();
	var popupWidth = $("#popupContact5").width();
	//centering
	$("#popupContact5").css({
		"position": "absolute",
		"top": 20,
		"left": windowWidth/2-popupWidth/2
	});
	//only need force for IE6
	
	$("#backgroundPopup5").css({
		"height": windowHeight
	});
	
}




//loading popup with jQuery magic!
function loadPopup6(){
	//loads popup only if it is disabled
	if(popupStatus==0){
		$("#backgroundPopup6").css({
			"opacity": "0.7"
		});
		$("#backgroundPopup6").fadeIn("slow");
		$("#popupContact6").fadeIn("slow");
		popupStatus = 1;
		 $('html, body').animate({scrollTop:0}, 10);
	}
}

//disabling popup with jQuery magic!
function disablePopup6(){
	//disables popup only if it is enabled
	if(popupStatus==1){
		$("#backgroundPopup6").fadeOut("slow");
		$("#popupContact6").fadeOut("slow");
		popupStatus = 0;
		 $('html, body').animate({scrollTop:800}, 10);
	}
}

//centering popup
function centerPopup6(){
	//request data for centering
	var windowWidth = document.documentElement.clientWidth;
	var windowHeight = document.documentElement.clientHeight;
	var popupHeight = $("#popupContact6").height();
	var popupWidth = $("#popupContact6").width();
	//centering
	$("#popupContact6").css({
		"position": "absolute",
		"top": 20,
		"left": windowWidth/2-popupWidth/2
	});
	//only need force for IE6
	
	$("#backgroundPopup6").css({
		"height": windowHeight
	});
	
}

//CONTROLLING EVENTS IN jQuery
$(document).ready(function(){
	
	//LOADING POPUP
	//Click the button event!
	$("#button").click(function(){
		//centering with css
		centerPopup();
		//load popup
		loadPopup();
	});
	
	//CLOSING POPUP
	//Click the x event!
	$("#popupContactClose").click(function(){
		disablePopup();
	});
	$("#popupContactClose2").click(function(){
		disablePopup2();
	});
	$("#popupContactClose3").click(function(){
		disablePopup3();
	});
	$("#popupContactClose4").click(function(){
		disablePopup4();
	});
	$("#popupContactClose5").click(function(){
		disablePopup5();
	});
	$("#popupContactClose6").click(function(){
		disablePopup6();
	});
	//Click out event!
	$("#backgroundPopup").click(function(){
		disablePopup();
	});
	$("#backgroundPopup2").click(function(){
		disablePopup2();
	});
	$("#backgroundPopup3").click(function(){
		disablePopup3();
	});
	$("#backgroundPopup4").click(function(){
		disablePopup4();
	});
	$("#backgroundPopup5").click(function(){
		disablePopup5();
	});
	$("#backgroundPopup6").click(function(){
		disablePopup6();
	});
	
	//Press Escape event!
	$(document).keypress(function(e){
		if(e.keyCode==27 && popupStatus==1){
			disablePopup();
			disablePopup2();
			disablePopup3();
			disablePopup4();
			disablePopup5();
			disablePopup6();
		}
	});

});