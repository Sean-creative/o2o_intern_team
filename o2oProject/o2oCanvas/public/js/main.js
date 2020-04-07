/* eslint-disable no-invalid-this */

window.onload = () => {
	this.scene = new Scene();
	this.scene.action = new Action(scene);
	this.scene.action.setCallbacks();
};

class Scene {
	constructor(){
		//화면 크기를 콘솔에 출력
		const view = document.getElementById('view');
		this.radio = window.devicePixelRatio;
	console.log("mais.js ");
    }
}
