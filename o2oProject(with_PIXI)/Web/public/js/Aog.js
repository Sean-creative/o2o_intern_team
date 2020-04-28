/* eslint-disable no-invalid-this */

window.onload = () => {
  this.scene = new Scene();
  this.scene.action = new Action(scene);
  this.scene.action.setCallbacks();
};

class Scene {
  constructor() {

    const screens = new PIXI.Application({
      backgroundColor: 0x7D68B5,
      width: 412,
      height: 773
    });
    document.body.appendChild(screens.view);

    this.Unclick_chip_Home = PIXI.Texture.from('./image/chip_Home.png');
    this.Click_chip_Home = PIXI.Texture.from('./image/click_chip_Home.png');
    this.Unclick_chip_Greeting = PIXI.Texture.from('./image/chip_Greeting.png');
    this.Click_chip_Greeting = PIXI.Texture.from('./image/click_chip_Greeting.png');
    this.Unclick_chip_Aog = PIXI.Texture.from('./image/chip_Aog.png');
    this.Click_chip_Aog = PIXI.Texture.from('./image/click_chip_Aog.png');
    this.Unclick_chip_Info = PIXI.Texture.from('./image/chip_Info.png');
    this.Unclick_chip_Info = PIXI.Texture.from('./image/chip_Info.png');
    this.Click_chip_Info = PIXI.Texture.from('./image/click_chip_Info.png');

    //Aog_intent


    this.Aog_container = new PIXI.Container();
    screens.stage.addChild(this.Aog_container);
//    this.Aog_container.visible = false;

    this.Aog_background = PIXI.Sprite.from('image/aog/background.png');
    this.Aog_background.width = screens.screen.width;
    this.Aog_background.height = screens.screen.height;
    this.Aog_container.addChild(this.Aog_background);

    this.Aog_chip_Home = new PIXI.Sprite(this.Unclick_chip_Home);
    this.Aog_chip_Greeting = new PIXI.Sprite(this.Unclick_chip_Greeting);
    this.Aog_chip_Aog = new PIXI.Sprite(this.Unclick_chip_Aog);
    this.Aog_chip_Info = new PIXI.Sprite(this.Unclick_chip_Info);
    this.Aog_ottu = PIXI.Sprite.from('./image/aog/no_arm_oddu.png');
    this.Aog_ottu_arm = PIXI.Sprite.from('./image/aog/stickk.png');
    this.Aog_board = PIXI.Sprite.from('./image/aog/board.png');
    this.Aog_shadow = PIXI.Sprite.from('./image/aog/ottu_shadow.png');
    this.Aog_1 = PIXI.Sprite.from('./image/aog/image1.png');
    this.Aog_2 = PIXI.Sprite.from('./image/aog/image2.png');

    this.Aog_ottu.scale.set(0.2, 0.2);
    this.Aog_ottu.anchor.set(0.5);
    this.Aog_ottu.x = 100;
    this.Aog_ottu.y = 500;

    this.Aog_shadow.scale.set(0.4, 0.4);
    this.Aog_shadow.anchor.set(0.5);
    this.Aog_shadow.x = 100;
    this.Aog_shadow.y = 600;

    this.Aog_board.anchor.set(0.5);
    this.Aog_board.x = screens.screen.width / 2;
    this.Aog_board.y = 295;
    this.Aog_board.scale.set(0.4, 0.4); //borad부분

    this.Aog_ottu_arm.scale.set(0.6, 0.6);
    this.Aog_ottu_arm.anchor.y = 1;
    this.Aog_ottu_arm.x = 175;
    this.Aog_ottu_arm.y = 560; //오뚜 팔부분

    this.Aog_ottu.scale.set(0.4, 0.4);
    this.Aog_ottu.anchor.set(0.5);
    this.Aog_ottu.x = 100;
    this.Aog_ottu.y = 500; //오뚜 이미지

    this.Aog_chip_Home.anchor.set(0.5);
    this.Aog_chip_Home.x = 56;
    this.Aog_chip_Home.y = 700;
    this.Aog_chip_Home.scale.set(0.35, 0.35);

    this.Aog_chip_Greeting.anchor.set(0.5);
    this.Aog_chip_Greeting.x = 156;
    this.Aog_chip_Greeting.y = 700;
    this.Aog_chip_Greeting.scale.set(0.35, 0.35);

    this.Aog_chip_Aog.anchor.set(0.5);
    this.Aog_chip_Aog.x = 256;
    this.Aog_chip_Aog.y = 700;
    this.Aog_chip_Aog.scale.set(0.35, 0.35);

    this.Aog_chip_Info.anchor.set(0.5);
    this.Aog_chip_Info.x = 356;
    this.Aog_chip_Info.y = 700;
    this.Aog_chip_Info.scale.set(0.35, 0.35);

    this.Aog_1.anchor.set(0.5);
    this.Aog_1.x = screens.screen.width / 2;
    this.Aog_1.y = 180;
    this.Aog_1.scale.set(0.8, 0.8);

    this.Aog_2.anchor.set(0.5);
    this.Aog_2.x = screens.screen.width / 2;
    this.Aog_2.y = 390;
    this.Aog_2.scale.set(0.8, 0.8);

    this.Aog_chip_Home.interactive = true;
    this.Aog_chip_Home.buttonMode = true;
    this.Aog_chip_Greeting.interactive = true;
    this.Aog_chip_Greeting.buttonMode = true;
    this.Aog_chip_Aog.interactive = true;
    this.Aog_chip_Aog.buttonMode = true;
    this.Aog_chip_Info.interactive = true;
    this.Aog_chip_Info.buttonMode = true;
    this.Aog_1.interactive = true;
    this.Aog_1.buttonMode = true;
    this.Aog_2.interactive = true;
    this.Aog_2.buttonMode = true;


    this.Aog_1.on('pointerdown', () => {
      //const that = this;
      console.log('aogvideo');
      location.replace("https://www.youtube.com/embed/QqoQWMoZKZg");
    });

    this.Aog_2.on('pointerdown', () => {
      //const that = this;
      console.log('aogvideo2');
      location.replace("https://www.youtube.com/embed/tcBKO2P-AQQ");
    });

    this.Aog_chip_Home.on('pointerdown', () => {
      this.Aog_chip_Home.texture = this.Click_chip_Home;

      const that = this;
      console.log(`안녕`);
      that.action.canvas.sendTextQuery('안녕')
        .then((res) => {
          if (res.toUpperCase() === 'SUCCESS') {
            console.log(`Request in flight: ${res}`);
          } else {
            console.log(`Request in flight: ${res}`);
          }
        });
    });

    this.Aog_chip_Greeting.on('pointerdown', () => {
      this.Aog_chip_Greeting.texture = this.Click_chip_Greeting;

      const that = this;
      console.log(`소개`);
      that.action.canvas.sendTextQuery('소개')
        .then((res) => {
          if (res.toUpperCase() === 'SUCCESS') {
            console.log(`Request in flight: ${res}`);
          } else {
            console.log(`Request in flight: ${res}`);
          }
        });
    });

    this.Aog_chip_Aog.on('pointerdown', () => {
      this.Aog_chip_Aog.texture = this.Click_chip_Aog;

      const that = this;
      console.log(`Aog`);
      that.action.canvas.sendTextQuery('Aog')
        .then((res) => {
          if (res.toUpperCase() === 'SUCCESS') {
            console.log(`Request in flight: ${res}`);
          } else {
            console.log(`Request in flight: ${res}`);
          }
        });
    });

    this.Aog_chip_Info.on('pointerdown', () => {
      this.Aog_chip_Info.texture = this.Click_chip_Info;

      const that = this;
      console.log(`기본정보`);
      that.action.canvas.sendTextQuery('기본정보')
        .then((res) => {
          if (res.toUpperCase() === 'SUCCESS') {
            console.log(`Request in flight: ${res}`);
          } else {
            console.log(`Request in flight: ${res}`);
          }
        });
    });

    this.Aog_container.addChild(this.Aog_shadow);
    this.Aog_container.addChild(this.Aog_board);
    this.Aog_container.addChild(this.Aog_1);
    this.Aog_container.addChild(this.Aog_2);
    this.Aog_container.addChild(this.Aog_ottu);
    this.Aog_container.addChild(this.Aog_ottu_arm);
    this.Aog_container.addChild(this.Aog_chip_Greeting);
    this.Aog_container.addChild(this.Aog_chip_Aog);
    this.Aog_container.addChild(this.Aog_chip_Info);
    this.Aog_container.addChild(this.Aog_chip_Home);

    this.hello = 0;
    this.swing = 0;

    screens.ticker.add((delta) => {
      if (this.swing <= 4) {
        if (this.hello < 30) {
          this.Aog_ottu_arm.rotation -= 0.01 * delta;
          this.hello++;
        } else if (this.hello >= 30 && this.hello < 60) {
          this.Aog_ottu_arm.rotation += 0.01 * delta;
          this.hello++;
        } else if (this.hello >= 60) {
          this.Aog_ottu_arm.rotation = 0;
          this.hello = 0;
          this.swing++;
        }
      }
      if (this.swing > 6) {
        this.ticker.remove;
      }
    });

  }

}
