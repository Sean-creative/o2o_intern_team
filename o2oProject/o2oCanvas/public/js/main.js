/* eslint-disable no-invalid-this */

window.onload = () => {
	this.scene = new Scene();
	this.scene.action = new Action(scene);
	//고쳤다
	this.scene.action.setCallbacks();
};

class Scene {
	constructor(){
		//화면 크기를 콘솔에 출력
		const view = document.getElementById('view');
		this.radio = window.devicePixelRatio;
		console.log("main.js ");
	}
}


function addressButtton() {
		assistantCanvas.sendTextQuery('주소');
}
function prizeButton() {
	assistantCanvas.sendTextQuery('수상');
}
function establishButton() {
	assistantCanvas.sendTextQuery('설립일');
}
function homepageButton() {
	assistantCanvas.sendTextQuery('홈페이지');
}
function contactButton() {
	assistantCanvas.sendTextQuery('연락처');
}


function sendWelcomeIntent(){
	assistantCanvas.sendTextQuery('안녕');
}
function sendGreetingIntent(){
	assistantCanvas.sendTextQuery('소개');
}
function sendAogIntent(){
	assistantCanvas.sendTextQuery('aog');
}
function sendInfoIntent(){
	assistantCanvas.sendTextQuery('기본정보');
}


function apply_option(data) {
	$(".INTENT").hide();
	$("#INFO_OPTION" ).css("display", "flex");
	$("#folder_INFO_OPTION > div").hide();
	$("#folder_INFO_OPTION > #" + data.command).show();
}


function apply(data) {
	$(".INTENT").hide();
	// console.log("전체 불끄기");

	$("#" + data.command).css("display", "flex");
	// console.log(data.command + " 하나만 켜기");
}




//
// function getDisplayInfo() {
// 	console.log("fdata : 2");
//
// 	var size = {
// 		width: window.innerWidth || document.body.clientWidth,
// 		height: window.innerHeight || document.body.clientHeight
// 	}
// 	console.log("fdata : 3");
// 	return size;
// }
//
//
//
//
//
// function onLoadHandler() {
// 	var size = getDisplayInfo();
// 	var bgs = document.getElementsByClassName("bg");
// 	for (var i = 0; i < bgs.length; i++) {
// 		var section1 = bgs.item(i);
// 		section1.style.width = size.width;
// 	}
//
// 	var bg = document.getElementsByClassName("bg");
// 	for (var i = 0; i < bgs.length; i++) {
// 		var section1 = bgs.item(i);
// 		section1.style.height = size.height - 56;
// 	}
// }
//
//
// function setLoadHandler(data) {
// 	var size = getDisplayInfo();
// 	var bgs = document.getElementsByClassName(data);
// 	for (var i = 0; i < bgs.length; i++) {
// 		var section1 = bgs.item(i);
// 		section1.style.width = size.width;
// 	}
//
// 	var bg = document.getElementsByClassName(data);
// 	for (var i = 0; i < bgs.length; i++) {
// 		var section1 = bgs.item(i);
// 		section1.style.height = size.height - 56;
// 	}
// }
