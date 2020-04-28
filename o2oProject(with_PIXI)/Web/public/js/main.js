/* eslint-disable no-invalid-this */

window.onload = () => {
  this.scene = new Scene();
  this.scene.action = new Action(scene);
  this.scene.action.setCallbacks();
};

class Scene {
  constructor() {

    const screens = new PIXI.Application({
      backgroundColor: 0x1B53A6,
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

    /////////////////////////welcome_intent

    // hi container 생성 및 screens에 추가
    this.Hi_container = new PIXI.Container();
    this.Hi_container.visible = true;
    screens.stage.addChild(this.Hi_container);
    
    // 이미지 sprite 객체로 변환하여 크기 조절 후 hi container에 추가
    this.Hi_background = PIXI.Sprite.from('./image/HI/hi_background.png');
    this.Hi_background.width = screens.screen.width;
    this.Hi_background.height = screens.screen.height;
    this.Hi_container.addChild(this.Hi_background);

    // 오뚜,shadow,bubble,chip sprite 객체 생성
    this.Hi_ottu = PIXI.Sprite.from('./image/ottu.png');
    this.Hi_ottu_Shadow = PIXI.Sprite.from('./image/HI/ottu_shadow.png');
    this.Hi_bubble = PIXI.Sprite.from('./image/HI/bubble.png');
    this.Hi_chip_Home = new PIXI.Sprite(this.Unclick_chip_Home);
    this.Hi_chip_Greeting = new PIXI.Sprite(this.Unclick_chip_Greeting);
    this.Hi_chip_Aog = new PIXI.Sprite(this.Unclick_chip_Aog);
    this.Hi_chip_Info = new PIXI.Sprite(this.Unclick_chip_Info);

    // 오뚜 크기 및 위치 조절
    this.Hi_ottu.width = 0;
    this.Hi_ottu.height = 0;
    this.Hi_ottu.x = 50;
    this.Hi_ottu.y = 0;

    // 그림자 위치 및 크기 조절
    this.Hi_ottu_Shadow.width = 0;
    this.Hi_ottu_Shadow.height = 0;
    this.Hi_ottu_Shadow.x = 206;
    this.Hi_ottu_Shadow.y = 620;

    // chip 위치 및 크기 조절
    this.Hi_chip_Home.width = 0;
    this.Hi_chip_Home.height = 0;
    this.Hi_chip_Greeting.width = 0;
    this.Hi_chip_Greeting.height = 0;
    this.Hi_chip_Aog.width = 0;
    this.Hi_chip_Aog.height = 0;
    this.Hi_chip_Info.width = 0;
    this.Hi_chip_Info.height = 0;

    this.Hi_chip_Home.x = 37 + 35;
    this.Hi_chip_Home.y = 110 + 35;
    this.Hi_chip_Greeting.x = 127 + 35;
    this.Hi_chip_Greeting.y = 110 + 35;
    this.Hi_chip_Aog.x = 217 + 35;
    this.Hi_chip_Aog.y = 110 + 35;
    this.Hi_chip_Info.x = 307 + 35;
    this.Hi_chip_Info.y = 110 + 35;

    this.Hi_bubble.width = 370;
    this.Hi_bubble.height = 230;
    this.Hi_bubble.x = 21;
    this.Hi_bubble.y = -270;

    // button 이벤트에 반응할 수 있도록 대화형으로 true로 설정
    // Sprite의 버튼 모드를 지정
    this.Hi_chip_Home.interactive = true;
    this.Hi_chip_Home.buttonMode = true;
    this.Hi_chip_Greeting.interactive = true;
    this.Hi_chip_Greeting.buttonMode = true;
    this.Hi_chip_Aog.interactive = true;
    this.Hi_chip_Aog.buttonMode = true;
    this.Hi_chip_Info.interactive = true;
    this.Hi_chip_Info.buttonMode = true;

    // 각 이미지 hi_container에 추가
    this.Hi_container.addChild(this.Hi_ottu_Shadow);
    this.Hi_container.addChild(this.Hi_ottu);
    this.Hi_container.addChild(this.Hi_bubble);
    this.Hi_container.addChild(this.Hi_chip_Home);
    this.Hi_container.addChild(this.Hi_chip_Greeting);
    this.Hi_container.addChild(this.Hi_chip_Aog);
    this.Hi_container.addChild(this.Hi_chip_Info);

    // sendTextQuery를 통해 알맞은 intent 이동
    this.Hi_chip_Home.on('pointerdown', () => {
      const that = this;
      this.Hi_chip_Home.texture = this.Click_chip_Home;

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

    this.Hi_chip_Greeting.on('pointerdown', () => {
      const that = this;
      this.Hi_chip_Greeting.texture = this.Click_chip_Greeting;

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

    this.Hi_chip_Aog.on('pointerdown', () => {
      const that = this;
      console.log(`Aog`);
      this.Hi_chip_Aog.texture = this.Click_chip_Aog;

      that.action.canvas.sendTextQuery('Aog')
        .then((res) => {
          if (res.toUpperCase() === 'SUCCESS') {
            console.log(`Request in flight: ${res}`);
          } else {
            console.log(`Request in flight: ${res}`);
          }
        });
    });

    this.Hi_chip_Info.on('pointerdown', () => {
      this.Hi_chip_Info.texture = this.Click_chip_Info;
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

    //오뚜 등장하는 action, 말풍선 action 추가
    this.Hi = 0;
    screens.ticker.add(delta => {
      if (this.Hi <= 100) {
        this.Hi_ottu.width += 3;
        this.Hi_ottu.height += 4;
        this.Hi_ottu.y += 2.4;

        if (this.Hi >= 90) {
          this.Hi_ottu_Shadow.width += 30;
          this.Hi_ottu_Shadow.height += 5;
          this.Hi_ottu_Shadow.x -= 15;
        }
        this.Hi++;
      } else if (this.Hi >= 100 && this.Hi <= 150) {
        this.Hi_bubble.y += 7;
        this.Hi++;
      } else if (this.Hi >= 150 && this.Hi <= 175) {
        this.Hi++;
        this.Hi_chip_Home.x -= 70 / 50;
        this.Hi_chip_Home.y -= 70 / 50;
        this.Hi_chip_Home.width += 140 / 50;
        this.Hi_chip_Home.height += 140 / 50;
      } else if (this.Hi >= 175 && this.Hi <= 200) {
        this.Hi++;
        this.Hi_chip_Greeting.x -= 70 / 50;
        this.Hi_chip_Greeting.y -= 70 / 50;
        this.Hi_chip_Greeting.width += 140 / 50;
        this.Hi_chip_Greeting.height += 140 / 50;
      } else if (this.Hi >= 200 && this.Hi <= 225) {
        this.Hi++;
        this.Hi_chip_Aog.x -= 70 / 50;
        this.Hi_chip_Aog.y -= 70 / 50;
        this.Hi_chip_Aog.width += 140 / 50;
        this.Hi_chip_Aog.height += 140 / 50;
      } else if (this.Hi >= 225 && this.Hi <= 250) {
        this.Hi++;
        this.Hi_chip_Info.x -= 70 / 50;
        this.Hi_chip_Info.y -= 70 / 50;
        this.Hi_chip_Info.width += 140 / 50;
        this.Hi_chip_Info.height += 140 / 50;
      }
      if (this.Hi > 255) {
        this.ticker.remove;
      }
    });


    /////////////////////////////////FALLBACK intent

    // fallback container 생성
    // screens에 fallback container 추가
    this.Fallback_container = new PIXI.Container();
    this.Fallback_container.visible = false;
    screens.stage.addChild(this.Fallback_container);

    // fallback background에 이미지 업로드 및 크기 조정
    // fallback background를 container에 추가
    this.Fallback_background = PIXI.Sprite.from('image/FALLBACK/background.png');
    this.Fallback_background.width = screens.screen.width;
    this.Fallback_background.height = screens.screen.height;
    this.Fallback_container.addChild(this.Fallback_background);

    // fallback chip, bubble, shadow 이미지 sprite 객체로 변환
    this.Fallback_chip_Home = new PIXI.Sprite(this.Unclick_chip_Home);
    this.Fallback_chip_Greeting = new PIXI.Sprite(this.Unclick_chip_Greeting);
    this.Fallback_chip_Aog = new PIXI.Sprite(this.Unclick_chip_Aog);
    this.Fallback_chip_Info = new PIXI.Sprite(this.Unclick_chip_Info);
    this.Fallback_bubble = PIXI.Sprite.from('./image/HI/bubble.png');
    this.Fallback_shadow = PIXI.Sprite.from('./image/FALLBACK/ottu_shadow.png');

    // 생성한 sprite 객체의 위치 조절
    this.Fallback_chip_Home.x = 37;
    this.Fallback_chip_Home.y = 110;
    this.Fallback_chip_Greeting.x = 127;
    this.Fallback_chip_Greeting.y = 110;
    this.Fallback_chip_Aog.x = 217;
    this.Fallback_chip_Aog.y = 110;
    this.Fallback_chip_Info.x = 307;
    this.Fallback_chip_Info.y = 110;

    // 생성한 sprite 객체의 크기 조절
    this.Fallback_chip_Home.width = 70;
    this.Fallback_chip_Home.height = 70;
    this.Fallback_chip_Greeting.width = 70;
    this.Fallback_chip_Greeting.height = 70;
    this.Fallback_chip_Aog.width = 70;
    this.Fallback_chip_Aog.height = 70;
    this.Fallback_chip_Info.width = 70;
    this.Fallback_chip_Info.height = 70;

    this.Fallback_bubble.width = 370;
    this.Fallback_bubble.height = 230;
    this.Fallback_bubble.x = 21;
    this.Fallback_bubble.y = 80;

    // scale로 크기 설정 및 anchor로 원점 설정
    this.Fallback_shadow.scale.set(0.4, 0.3);
    this.Fallback_shadow.anchor.set(0.5);
    this.Fallback_shadow.x = 205;
    this.Fallback_shadow.y = 647;

    // button 이벤트에 반응할 수 있도록 대화형으로 true로 설정
    // Sprite의 버튼 모드를 지정
    this.Fallback_chip_Home.interactive = true;
    this.Fallback_chip_Home.buttonMode = true;
    this.Fallback_chip_Greeting.interactive = true;
    this.Fallback_chip_Greeting.buttonMode = true;
    this.Fallback_chip_Aog.interactive = true;
    this.Fallback_chip_Aog.buttonMode = true;
    this.Fallback_chip_Info.interactive = true;
    this.Fallback_chip_Info.buttonMode = true;

    // 각 sprite를 fallback container에 추가
    this.Fallback_container.addChild(this.Fallback_bubble);
    this.Fallback_container.addChild(this.Fallback_chip_Home);
    this.Fallback_container.addChild(this.Fallback_chip_Greeting);
    this.Fallback_container.addChild(this.Fallback_chip_Aog);
    this.Fallback_container.addChild(this.Fallback_chip_Info);
    this.Fallback_container.addChild(this.Fallback_shadow);

    // home chip을 눌렀을 경우
    this.Fallback_chip_Home.on('pointerdown', () => {
      this.Fallback_chip_Home.texture = this.Click_chip_Home;
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

    // greeting chip을 눌렀을 경우
    this.Fallback_chip_Greeting.on('pointerdown', () => {
      this.Fallback_chip_Greeting.texture = this.Click_chip_Greeting;
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

    // aog chip을 눌렀을 경우
    this.Fallback_chip_Aog.on('pointerdown', () => {
      this.Fallback_chip_Aog.texture = this.Click_chip_Aog;
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

    // info chip을 눌렀을 경우
    this.Fallback_chip_Info.on('pointerdown', () => {
      this.Fallback_chip_Info.texture = this.Click_chip_Info;
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

    /** 오뚜 우는 이미지 texture로 변환한 후 
    swap하여 나타날 이미지를 넣은 Fallback_sprite 객체 생성,
    Fallback_sprite 크기 및 위치 조절 및 container에 추가 **/
    this.Fallback_texture = PIXI.Texture.from('./image/FALLBACK/oddu_cry1.png');
    this.Fallback_secondTexture = PIXI.Texture.from('./image/FALLBACK/oddu_cry2.png');
    this.Fallback_thirdTexture = PIXI.Texture.from('./image/FALLBACK/oddu_cry3.png');
    this.Fallback_sprite = new PIXI.Sprite(this.Fallback_texture);
    this.Fallback_sprite.anchor.set(0.5);
    this.Fallback_sprite.width = 265;
    this.Fallback_sprite.height = 406;
    this.Fallback_sprite.x = 202;
    this.Fallback_sprite.y = 445;
    this.Fallback_container.addChild(this.Fallback_sprite);

    // 오뚜 우는 이미지 swap
    this.Fallback = 0;
    this.time = 0;
    screens.ticker.add(() => {
      if (this.time <= 3) {
        if (this.Fallback <= 30) {

          this.Fallback_sprite.texture = this.Fallback_texture;
          this.Fallback++;
        } else if (this.Fallback > 30 && this.Fallback < 60) {
          this.Fallback_sprite.texture = this.Fallback_secondTexture;
          this.Fallback++;
        } else if (this.Fallback >= 60 && this.Fallback < 90) {
          this.Fallback_sprite.texture = this.Fallback_thirdTexture;
          this.Fallback++;
        } else if (this.Fallback >= 90) {
          this.Fallback = 0;
          this.Fallback_sprite.texture = this.Fallback_texture;
          this.time++;
        }
      }
      if (this.time > 5) {
        this.ticker.remove;
      }

    });

    /////////////////////////greeting_intent

    // greeting container 생성 및 screens에 추가
    this.Greeting_container = new PIXI.Container();
    this.Greeting_container.visible = false;
    screens.stage.addChild(this.Greeting_container);

    // 각 sprite 생성
    this.Greeting_background = PIXI.Sprite.from('image/GREETING/background.png');
    this.Greeting_sprite = PIXI.Sprite.from('image/GREETING/oddu_GREETING.png');
    this.Greeting_desk = PIXI.Sprite.from('image/GREETING/desk.png');
    this.Greeting_mic = PIXI.Sprite.from('image/GREETING/mic.png');
    this.Greeting_book = PIXI.Sprite.from('image/GREETING/book.png');
    this.Greeting_ceo = PIXI.Sprite.from('image/GREETING/ceo.png');
    this.Greeting_chip_Home = new PIXI.Sprite(this.Unclick_chip_Home);
    this.Greeting_chip_Greeting = new PIXI.Sprite(this.Unclick_chip_Greeting);
    this.Greeting_chip_Aog = new PIXI.Sprite(this.Unclick_chip_Aog);
    this.Greeting_chip_Info = new PIXI.Sprite(this.Unclick_chip_Info);

    // background 크기 조절
    this.Greeting_background.width = screens.screen.width;
    this.Greeting_background.height = screens.screen.height;
    
    // desk 위치 및 크기 조절
    this.Greeting_desk.anchor.set(0.5);
    this.Greeting_desk.x = 0;
    this.Greeting_desk.scale.x *= 1.0;
    this.Greeting_desk.scale.y *= 0.3;
    this.Greeting_desk.y = 570;

    // book 위치 및 크기 조절
    this.Greeting_book.anchor.set(0.5);
    this.Greeting_book.x = 100;
    this.Greeting_book.scale.x *= 0.3;
    this.Greeting_book.scale.y *= 0.3;
    this.Greeting_book.y = 200;

    // 대표님 이미지 위치 및 크기 조절
    this.Greeting_ceo.anchor.set(0.5);
    this.Greeting_ceo.x = 280;
    this.Greeting_ceo.y = 350;
    this.Greeting_ceo.scale.x *= 0.7;
    this.Greeting_ceo.scale.y *= 0.7;

    // Greeting_sprite 위치 및 크기 조절
    this.Greeting_sprite.anchor.set(0.5);
    this.Greeting_sprite.x = 0;
    this.Greeting_sprite.y = 70
    this.Greeting_sprite.scale.x *= 0.4;
    this.Greeting_sprite.scale.y *= 0.4;

    // 마이크 위치 및 크기 조절
    this.Greeting_mic.anchor.set(0.5);
    this.Greeting_mic.x = 170;
    this.Greeting_mic.y = -30;
    this.Greeting_mic.scale.x *= 0.3;
    this.Greeting_mic.scale.y *= 0.3;

    // home chip 위치 및 크기 조절
    this.Greeting_chip_Home.anchor.set(0.5);
    this.Greeting_chip_Home.x = 56;
    this.Greeting_chip_Home.y = 700;
    this.Greeting_chip_Home.scale.x *= 0.35;
    this.Greeting_chip_Home.scale.y *= 0.35;

    // greeting chip 위치 및 크기 조절
    this.Greeting_chip_Greeting.anchor.set(0.5);
    this.Greeting_chip_Greeting.x = 156;
    this.Greeting_chip_Greeting.y = 700;
    this.Greeting_chip_Greeting.scale.x *= 0.35;
    this.Greeting_chip_Greeting.scale.y *= 0.35;

    // aog chip 위치 및 크기 조절
    this.Greeting_chip_Aog.anchor.set(0.5);
    this.Greeting_chip_Aog.x = 256;
    this.Greeting_chip_Aog.y = 700;
    this.Greeting_chip_Aog.scale.x *= 0.35;
    this.Greeting_chip_Aog.scale.y *= 0.35;

    // info chip 위치 및 크기 조절
    this.Greeting_chip_Info.anchor.set(0.5);
    this.Greeting_chip_Info.x = 356;
    this.Greeting_chip_Info.y = 700;
    this.Greeting_chip_Info.scale.x *= 0.35;
    this.Greeting_chip_Info.scale.y *= 0.35;

    // button 이벤트에 반응할 수 있도록 대화형으로 true로 설정
    // Sprite의 버튼 모드를 지정
    this.Greeting_chip_Home.interactive = true;
    this.Greeting_chip_Home.buttonMode = true;
    this.Greeting_chip_Greeting.interactive = true;
    this.Greeting_chip_Greeting.buttonMode = true;
    this.Greeting_chip_Aog.interactive = true;
    this.Greeting_chip_Aog.buttonMode = true;
    this.Greeting_chip_Info.interactive = true;
    this.Greeting_chip_Info.buttonMode = true;

    // sendTextQuery를 통해 알맞은 intent 이동
    this.Greeting_chip_Home.on('pointerdown', () => {
      this.Greeting_chip_Home.texture = this.Click_chip_Home;

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

    this.Greeting_chip_Greeting.on('pointerdown', () => {
      this.Greeting_chip_Greeting.texture = this.Click_chip_Greeting;

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

    this.Greeting_chip_Aog.on('pointerdown', () => {
      this.Greeting_chip_Aog.texture = this.Click_chip_Aog;

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

    this.Greeting_chip_Info.on('pointerdown', () => {
      this.Greeting_chip_Info.texture = this.Click_chip_Info;

      const that = this;
      that.action.canvas.sendTextQuery('기본정보')
        .then((res) => {
          if (res.toUpperCase() === 'SUCCESS') {
            console.log(`Request in flight: ${res}`);
          } else {
            console.log(`Request in flight: ${res}`);
          }
        });
    });

    // 생성한 sprite를 container에 추가
    this.Greeting_container.addChild(this.Greeting_background);
    this.Greeting_container.addChild(this.Greeting_book);
    this.Greeting_container.addChild(this.Greeting_ceo);
    this.Greeting_container.addChild(this.Greeting_desk);
    this.Greeting_container.addChild(this.Greeting_sprite);
    this.Greeting_container.addChild(this.Greeting_mic);
    this.Greeting_container.addChild(this.Greeting_chip_Home);
    this.Greeting_container.addChild(this.Greeting_chip_Greeting);
    this.Greeting_container.addChild(this.Greeting_chip_Aog);
    this.Greeting_container.addChild(this.Greeting_chip_Info);

    // 마이크, 대표님, 오뚜에 움직이는 action 추가
    this.Greeting = 0;
    screens.ticker.add((delta) => {
      if (this.Greeting <= 80) {
        this.Greeting_sprite.x = 1.1 * this.Greeting;
        this.Greeting_sprite.y = 440;
        this.Greeting_ceo.x = 495 - (2.5 * this.Greeting)
        this.Greeting_mic.x = 180;
        this.Greeting_mic.y = 5.7 * this.Greeting;
        this.Greeting++;
        if (this.Greeting == 86) {
          this.ticker.remove;
        }

      }

    });

    /////////////////////////////////info intent

    // info container 생성 및  screens에 추가
    this.Info_container = new PIXI.Container();
    screens.stage.addChild(this.Info_container);
    
    // background sprite 생성 및 사이즈 조절
    // background sprite를 info container에 추가
    this.Info_background = PIXI.Sprite.from('image/INFO/background.png');
    this.Info_background.width = screens.screen.width;
    this.Info_background.height = screens.screen.height;
    this.Info_container.addChild(this.Info_background);
    this.Info_container.visible = false;
    
    // 각 sprite 생성
    this.Info_oddu = PIXI.Sprite.from('./image/INFO/1_oddu.png');
    this.Info_memo = PIXI.Sprite.from('./image/INFO/memo.png');
    this.Info_folder = PIXI.Sprite.from('./image/INFO/folder.png');
    this.Info_prize = PIXI.Sprite.from('./image/INFO/prize.png');
    this.Info_address = PIXI.Sprite.from('./image/INFO/address.png');
    this.Info_contact = PIXI.Sprite.from('./image/INFO/contact.png');
    this.Info_establish = PIXI.Sprite.from('./image/INFO/establish.png');
    this.Info_homepage = PIXI.Sprite.from('./image/INFO/homepage.png');
    this.Info_chip_Home = new PIXI.Sprite(this.Unclick_chip_Home);
    this.Info_chip_Greeting = new PIXI.Sprite(this.Unclick_chip_Greeting);
    this.Info_chip_Aog = new PIXI.Sprite(this.Unclick_chip_Aog);
    this.Info_chip_Info = new PIXI.Sprite(this.Unclick_chip_Info);

    // 오뚜 위치 및 크기 조절
    this.Info_oddu.width = 280;
    this.Info_oddu.height = 355;
    this.Info_oddu.anchor.set(0.5);
    this.Info_oddu.x = screens.screen.width / 2;
    this.Info_oddu.y = 280;

    // memo 위치 및 크기 조절
    this.Info_memo.width = 380;
    this.Info_memo.height = 140;
    this.Info_memo.anchor.set(0.5);
    this.Info_memo.x = screens.screen.width / 2;
    this.Info_memo.y = 180;

    // 폴더 위치 및 크기 조절
    this.Info_folder.scale.x *= 0.27;
    this.Info_folder.scale.y *= 0.27;
    this.Info_folder.anchor.set(0.5);
    this.Info_folder.x = screens.screen.width / 2;
    this.Info_folder.y = 490;

    // prize 아이콘 위치 및 크기 조절
    this.Info_prize.width = 70;
    this.Info_prize.height = 70;
    this.Info_prize.anchor.set(0.5);
    this.Info_prize.x = 100;
    this.Info_prize.y = 450;

    // address 아이콘 위치 및 크기 조절
    this.Info_address.width = 70;
    this.Info_address.height = 70;
    this.Info_address.anchor.set(0.5);
    this.Info_address.x = 210;
    this.Info_address.y = 450;

    // contact 아이콘 위치 및 크기 조절
    this.Info_contact.width = 70;
    this.Info_contact.height = 70;
    this.Info_contact.anchor.set(0.5);
    this.Info_contact.x = 320;
    this.Info_contact.y = 450;

    // establish 아이콘 위치 및 크기 조절
    this.Info_establish.width = 70;
    this.Info_establish.height = 70;
    this.Info_establish.anchor.set(0.5);
    this.Info_establish.x = 100;
    this.Info_establish.y = 550;

    // homepage 아이콘 위치 및 크기 조절
    this.Info_homepage.width = 70;
    this.Info_homepage.height = 56;
    this.Info_homepage.anchor.set(0.5);
    this.Info_homepage.x = 210;
    this.Info_homepage.y = 550;

    // chip 위치 및 크기 조절
    this.Info_chip_Home.anchor.set(0.5);
    this.Info_chip_Home.x = 56;
    this.Info_chip_Home.y = 700;
    this.Info_chip_Home.scale.x *= 0.35;
    this.Info_chip_Home.scale.y *= 0.35;

    this.Info_chip_Greeting.anchor.set(0.5);
    this.Info_chip_Greeting.x = 156;
    this.Info_chip_Greeting.y = 700;
    this.Info_chip_Greeting.scale.x *= 0.35;
    this.Info_chip_Greeting.scale.y *= 0.35;

    this.Info_chip_Aog.anchor.set(0.5);
    this.Info_chip_Aog.x = 256;
    this.Info_chip_Aog.y = 700;
    this.Info_chip_Aog.scale.x *= 0.35;
    this.Info_chip_Aog.scale.y *= 0.35;

    this.Info_chip_Info.anchor.set(0.5);
    this.Info_chip_Info.x = 356;
    this.Info_chip_Info.y = 700;
    this.Info_chip_Info.scale.x *= 0.35;
    this.Info_chip_Info.scale.y *= 0.35;

    // button 이벤트에 반응할 수 있도록 대화형으로 true로 설정
    // Sprite의 버튼 모드를 지정
    this.Info_chip_Home.interactive = true;
    this.Info_chip_Home.buttonMode = true;
    this.Info_chip_Greeting.interactive = true;
    this.Info_chip_Greeting.buttonMode = true;
    this.Info_chip_Aog.interactive = true;
    this.Info_chip_Aog.buttonMode = true;
    this.Info_chip_Info.interactive = true;
    this.Info_chip_Info.buttonMode = true;
    
    // sendTextQuery를 통해 알맞은 intent 이동
    this.Info_chip_Home.on('pointerdown', () => {
      this.Info_chip_Home.texture = this.Click_chip_Home;

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

    this.Info_chip_Greeting.on('pointerdown', () => {
      this.Info_chip_Greeting.texture = this.Click_chip_Greeting;

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

    this.Info_chip_Aog.on('pointerdown', () => {
      this.Info_chip_Aog.texture = this.Click_chip_Aog;

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

    this.Info_chip_Info.on('pointerdown', () => {
      this.Info_chip_Info.texture = this.Click_chip_Info;

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

    // button 이벤트에 반응할 수 있도록 대화형으로 ture로 설정
    // Sprite의 버튼 모드를 지정
    this.Info_prize.interactive = true;
    this.Info_prize.buttonMode = true;
    this.Info_address.interactive = true;
    this.Info_address.buttonMode = true;
    this.Info_contact.interactive = true;
    this.Info_contact.buttonMode = true;
    this.Info_establish.interactive = true;
    this.Info_establish.buttonMode = true;
    this.Info_homepage.interactive = true;
    this.Info_homepage.buttonMode = true;

    // sendTextQuery를 이용하여 알맞는 기본정보로 넘어감
    //When prizeButton is pressed
    this.Info_prize.on('pointerdown', () => {

      const that = this;
      console.log(`수상`);
      that.action.canvas.sendTextQuery('수상')
        .then((res) => {
          if (res.toUpperCase() === 'SUCCESS') {
            console.log(`Request in flight: ${res}`);
          } else {
            console.log(`Request in flight: ${res}`);
          }
        });
    });
    //When addressButton is pressed
    this.Info_address.on('pointerdown', () => {
      const that = this;

      console.log(`주소`);
      that.action.canvas.sendTextQuery('주소')
        .then((res) => {
          if (res.toUpperCase() === 'SUCCESS') {
            console.log(`Request in flight: ${res}`);
          } else {
            console.log(`Request in flight: ${res}`);
          }
        });
    });
    //When contactButton is pressed
    this.Info_contact.on('pointerdown', () => {

      const that = this;
      console.log(`연락처`);
      that.action.canvas.sendTextQuery('연락처')
        .then((res) => {
          if (res.toUpperCase() === 'SUCCESS') {
            console.log(`Request in flight: ${res}`);
          } else {
            console.log(`Request in flight: ${res}`);
          }
        });
    });
    //When establishButton is pressed
    this.Info_establish.on('pointerdown', () => {

      const that = this;
      console.log(`설립일`);
      that.action.canvas.sendTextQuery('설립일')
        .then((res) => {
          if (res.toUpperCase() === 'SUCCESS') {
            console.log(`Request in flight: ${res}`);
          } else {
            console.log(`Request in flight: ${res}`);
          }
        });
    });
    //When homepageButton is pressed
    this.Info_homepage.on('pointerdown', () => {

      const that = this;
      console.log(`홈페이지`);
      that.action.canvas.sendTextQuery('홈페이지')
        .then((res) => {
          if (res.toUpperCase() === 'SUCCESS') {
            console.log(`Request in flight: ${res}`);
          } else {
            console.log(`Request in flight: ${res}`);
          }
        });
    });

    //Add the cat to the stage
    this.Info_container.addChild(this.Info_oddu);
    this.Info_container.addChild(this.Info_memo);
    this.Info_container.addChild(this.Info_folder);
    this.Info_container.addChild(this.Info_prize);
    this.Info_container.addChild(this.Info_address);
    this.Info_container.addChild(this.Info_contact);
    this.Info_container.addChild(this.Info_establish);
    this.Info_container.addChild(this.Info_homepage);
    this.Info_container.addChild(this.Info_chip_Home);
    this.Info_container.addChild(this.Info_chip_Greeting);
    this.Info_container.addChild(this.Info_chip_Aog);
    this.Info_container.addChild(this.Info_chip_Info);


  }

}
