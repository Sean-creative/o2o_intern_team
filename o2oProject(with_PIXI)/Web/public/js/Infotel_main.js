/* eslint-disable no-invalid-this */

window.onload = () => {
  this.scene = new Scene();
  this.scene.action = new Action(scene);
  this.scene.action.setCallbacks();
};

class Scene {
  constructor() {

    const screens = new PIXI.Application({
      backgroundColor: 0x059D46,
      width: 412,
      height: 773
    });
    document.body.appendChild(screens.view);
    //버튼이미지 load
    this.Unclick_chip_Home = PIXI.Texture.from('./image/chip_Home.png');
    this.Click_chip_Home = PIXI.Texture.from('./image/click_chip_Home.png');
    this.Unclick_chip_Greeting = PIXI.Texture.from('./image/chip_Greeting.png');
    this.Click_chip_Greeting = PIXI.Texture.from('./image/click_chip_Greeting.png');
    this.Unclick_chip_Aog = PIXI.Texture.from('./image/chip_Aog.png');
    this.Click_chip_Aog = PIXI.Texture.from('./image/click_chip_Aog.png');
    this.Unclick_chip_Info = PIXI.Texture.from('./image/chip_Info.png');
    this.Click_chip_Info = PIXI.Texture.from('./image/click_chip_Info.png');


    //////////////INFOTEL
    this.Infotel_container = new PIXI.Container();
    screens.stage.addChild(this.Infotel_container);
    this.Infotel_container.visible = true;

    // create a background
    this.Infotel_background = PIXI.Sprite.from('image/INFO/background.png');
    this.Infotel_background.width = screens.screen.width;
    this.Infotel_background.height = screens.screen.height;
    this.Infotel_container.addChild(this.Infotel_background);

    //infotel이미지 load
    this.Infotel_oddu = PIXI.Sprite.from('./image/INFO/1_oddu.png');
    this.Infotel_memo = PIXI.Sprite.from('./image/INFO/memo.png');
    this.Infotel_folder = PIXI.Sprite.from('./image/INFO/folder.png');
    this.Infotel_prize = PIXI.Sprite.from('./image/INFOTEL/prize.png');
    this.Infotel_address = PIXI.Sprite.from('./image/INFOTEL/address.png');
    this.Infotel_establish = PIXI.Sprite.from('./image/INFOTEL/establish.jpg');
    this.Infotel_homepage = PIXI.Sprite.from('./image/INFOTEL/homepage.jpg');
    this.Infotel_phone = PIXI.Sprite.from('./image/INFOTEL/phone.png');
    this.Infotel_email = PIXI.Sprite.from('./image/INFOTEL/email.png');

    this.Infotel_chip_Home = new PIXI.Sprite(this.Unclick_chip_Home);
    this.Infotel_chip_Greeting = new PIXI.Sprite(this.Unclick_chip_Greeting);
    this.Infotel_chip_Aog = new PIXI.Sprite(this.Unclick_chip_Aog);
    this.Infotel_chip_Info = new PIXI.Sprite(this.Unclick_chip_Info);

    //이미지 배치
    this.Infotel_oddu.width = 280;
    this.Infotel_oddu.height = 355;
    this.Infotel_oddu.anchor.set(0.5);
    this.Infotel_oddu.x = screens.screen.width / 2;
    this.Infotel_oddu.y = 280;

    this.Infotel_memo.width = 380;
    this.Infotel_memo.height = 140;
    this.Infotel_memo.anchor.set(0.5);
    this.Infotel_memo.x = screens.screen.width / 2;
    this.Infotel_memo.y = 180;

    this.Infotel_folder.scale.x *= 0.27;
    this.Infotel_folder.scale.y *= 0.40;
    this.Infotel_folder.anchor.set(0.5);
    this.Infotel_folder.x = screens.screen.width / 2;
    this.Infotel_folder.y = 490 - 70;

    this.Infotel_prize.scale.x *= 0.16;
    this.Infotel_prize.scale.y *= 0.16;
    this.Infotel_prize.anchor.set(0.5);
    this.Infotel_prize.x = screens.screen.width / 2;
    this.Infotel_prize.y = 490 - 130;

    this.Infotel_homepage.scale.x *= 0.16;
    this.Infotel_homepage.scale.y *= 0.16;
    this.Infotel_homepage.anchor.set(0.5);
    this.Infotel_homepage.x = screens.screen.width / 2;
    this.Infotel_homepage.y = 490 - 130;

    this.Infotel_establish.scale.x *= 0.25;
    this.Infotel_establish.scale.y *= 0.25;
    this.Infotel_establish.anchor.set(0.5);
    this.Infotel_establish.x = screens.screen.width / 2;
    this.Infotel_establish.y = 490 - 130;

    this.Infotel_phone.scale.x *= 0.42;
    this.Infotel_phone.scale.y *= 0.42;
    this.Infotel_phone.anchor.set(0.5);
    this.Infotel_phone.x = screens.screen.width / 2 - 80;
    this.Infotel_phone.y = 490 - 130;

    this.Infotel_email.scale.x *= 0.30;
    this.Infotel_email.scale.y *= 0.30;
    this.Infotel_email.anchor.set(0.5);
    this.Infotel_email.x = screens.screen.width / 2 + 80;
    this.Infotel_email.y = 490 - 130;

    //텍스트 배치
    this.Infotel_prizeText = new PIXI.Text('2020.01.17. 관광편의 시설업 지정\n2018.10.10. 특허청장 수상\n2018.07.12. 벤처기업 인증\n2018.04.19. 기업부설연구소 설립\n2018.04.10. 무역업 등록\n2017.08.16. (주)오투오 본사 설립', {
      fontSize: 18
    });
    this.Infotel_prizeText.x = 60;
    this.Infotel_prizeText.y = 490 - 40;

    this.Infotel_addressText = new PIXI.Text('서울특별시 서초구 매헌로8길 47, \n양재 AI 허브(희경빌딩 B동) 203호', {
      fontSize: 18
    });
    this.Infotel_addressText.x = 60;
    this.Infotel_addressText.y = 490 - 40;

    this.Infotel_contactText = new PIXI.Text('\uD83D\uDCE7 : info@o2o.kr\n☎ : 070-4260-8310', {
      fontSize: 18
    });
    this.Infotel_contactText.x = 60;
    this.Infotel_contactText.y = 490 - 40;

    this.Infotel_establishText = new PIXI.Text('2017년 8월 16일', {
      fontSize: 18
    });
    this.Infotel_establishText.x = 60;
    this.Infotel_establishText.y = 490 - 40;

    this.Infotel_homepageText = new PIXI.Text('http://www.o2o.kr', {
      fontSize: 18
    });
    this.Infotel_homepageText.x = 60;
    this.Infotel_homepageText.y = 490 - 40;

    this.Infotel_chip_Home.anchor.set(0.5);
    this.Infotel_chip_Home.x = 56;
    this.Infotel_chip_Home.y = 700;
    this.Infotel_chip_Home.scale.x *= 0.35;
    this.Infotel_chip_Home.scale.y *= 0.35;

    this.Infotel_chip_Greeting.anchor.set(0.5);
    this.Infotel_chip_Greeting.x = 156;
    this.Infotel_chip_Greeting.y = 700;
    this.Infotel_chip_Greeting.scale.x *= 0.35;
    this.Infotel_chip_Greeting.scale.y *= 0.35;

    this.Infotel_chip_Aog.anchor.set(0.5);
    this.Infotel_chip_Aog.x = 256;
    this.Infotel_chip_Aog.y = 700;
    this.Infotel_chip_Aog.scale.x *= 0.35;
    this.Infotel_chip_Aog.scale.y *= 0.35;

    this.Infotel_chip_Info.anchor.set(0.5);
    this.Infotel_chip_Info.x = 356;
    this.Infotel_chip_Info.y = 700;
    this.Infotel_chip_Info.scale.x *= 0.35;
    this.Infotel_chip_Info.scale.y *= 0.35;

    this.Infotel_chip_Home.interactive = true;
    this.Infotel_chip_Home.buttonMode = true;
    this.Infotel_chip_Greeting.interactive = true;
    this.Infotel_chip_Greeting.buttonMode = true;
    this.Infotel_chip_Aog.interactive = true;
    this.Infotel_chip_Aog.buttonMode = true;
    this.Infotel_chip_Info.interactive = true;
    this.Infotel_chip_Info.buttonMode = true;

    this.Infotel_address.scale.x *= 0.50;
    this.Infotel_address.scale.y *= 0.50;
    this.Infotel_address.anchor.set(0.5);
    this.Infotel_address.x = screens.screen.width / 2;
    this.Infotel_address.y = 490 - 130;

    this.Infotel_homepage.interactive = true;
    this.Infotel_homepage.buttonMode = true;
    this.Infotel_phone.interactive = true;
    this.Infotel_phone.buttonMode = true;
    this.Infotel_email.interactive = true;
    this.Infotel_email.buttonMode = true;
    this.Infotel_address.interactive = true;
    this.Infotel_address.buttonMode = true;

    //버튼 액션
    this.Infotel_chip_Home.on('pointerdown', () => {
      this.Infotel_chip_Home.texture = this.Click_chip_Home;

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

    this.Infotel_chip_Greeting.on('pointerdown', () => {
      this.Infotel_chip_Greeting.texture = this.Click_chip_Greeting;

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

    this.Infotel_chip_Aog.on('pointerdown', () => {
      this.Infotel_chip_Aog.texture = this.Click_chip_Aog;

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

    this.Infotel_chip_Info.on('pointerdown', () => {
      this.Infotel_chip_Info.texture = this.Click_chip_Info;

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

    ////////////////////////////////////////////////////////////////////////////////

    this.Infotel_phone.on('pointerdown', () => {
      //const that = this;
      console.log('phone button OK');
      location.replace("tel:+82-70-4260-8310");
    });

    this.Infotel_email.on('pointerdown', () => {
      //const that = this;
      console.log('email button OK');
      location.replace("mailto:info@o2o.kr");
    });

    this.Infotel_homepage.on('pointerdown', () => {
      const that = this;
      location.replace("https://o2o.kr");
    });

    this.Infotel_address.on('pointerdown', () => {
      //const that = this;
      console.log('address button OK');
      location.replace("https://map.naver.com/v5/search/%EC%84%9C%EC%9A%B8%ED%8A%B9%EB%B3%84%EC%8B%9C%20%EC%84%9C%EC%B4%88%EA%B5%AC%20%EB%A7%A4%ED%97%8C%EB%A1%9C8%EA%B8%B8%2047/address/14141588.565368045,4504265.872974722,%EC%84%9C%EC%9A%B8%ED%8A%B9%EB%B3%84%EC%8B%9C%20%EC%84%9C%EC%B4%88%EA%B5%AC%20%EB%A7%A4%ED%97%8C%EB%A1%9C8%EA%B8%B8%2047,new?c=14141472.1183328,4504265.8729747,17,0,0,0,dh");
    });
    //Add the cat to the stage
    this.Infotel_container.addChild(this.Infotel_oddu);
    this.Infotel_container.addChild(this.Infotel_memo);
    this.Infotel_container.addChild(this.Infotel_folder);
    this.Infotel_container.addChild(this.Infotel_prize);
    this.Infotel_container.addChild(this.Infotel_establish);
    this.Infotel_container.addChild(this.Infotel_phone);
    this.Infotel_container.addChild(this.Infotel_address);
    this.Infotel_container.addChild(this.Infotel_email);
    this.Infotel_container.addChild(this.Infotel_prizeText);
    this.Infotel_container.addChild(this.Infotel_homepage);
    this.Infotel_container.addChild(this.Infotel_prizeText);
    this.Infotel_container.addChild(this.Infotel_addressText);
    this.Infotel_container.addChild(this.Infotel_contactText);
    this.Infotel_container.addChild(this.Infotel_establishText);
    this.Infotel_container.addChild(this.Infotel_homepageText);
    this.Infotel_container.addChild(this.Infotel_chip_Home);
    this.Infotel_container.addChild(this.Infotel_chip_Greeting);
    this.Infotel_container.addChild(this.Infotel_chip_Aog);
    this.Infotel_container.addChild(this.Infotel_chip_Info);
    this.Infotel_container.addChild(this.Infotel_phone);
    this.Infotel_container.addChild(this.Infotel_email);



  }

}
