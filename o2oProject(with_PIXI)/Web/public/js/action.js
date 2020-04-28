/*
 * Copyright 2019 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

'use strict';

/**
 * This class is used as a wrapper for Google Assistant Canvas Action class
 * along with its callbacks.
 */

class Action {
  /**
   * @param {*} scene which serves as a container of all visual elements
   */
  constructor(scene) {
    this.canvas = window.interactiveCanvas;
    this.scene = scene;
    const that = this;
    this.commands = {
      HI: function(data) {
        console.log("command : " + data.command);
        //해당 인텐트를 제외한 모든 인텐트의 화면을 숨김
        that.scene.Hi_container.visible = true;
        that.scene.Fallback_container.visible = false;
        that.scene.Greeting_container.visible = false;
        that.scene.Info_container.visible = false;

        //이미지가 변경된 버튼을 원래대로 변경
        that.scene.Hi_chip_Home.texture = that.scene.Unclick_chip_Home;
        that.scene.Hi_chip_Greeting.texture = that.scene.Unclick_chip_Greeting;
        that.scene.Hi_chip_Aog.texture = that.scene.Unclick_chip_Aog;
        that.scene.Hi_chip_Info.texture = that.scene.Unclick_chip_Info;

        //welcome인텐트에서 위치가 변경된 오프젝트의 위치를 초기화
        that.scene.Hi_ottu.width = 0;
        that.scene.Hi_ottu.height = 0;
        that.scene.Hi_ottu.x = 50;
        that.scene.Hi_ottu.y = 0;

        that.scene.Hi_ottu_Shadow.width = 0;
        that.scene.Hi_ottu_Shadow.height = 0;
        that.scene.Hi_ottu_Shadow.x = 206;
        that.scene.Hi_ottu_Shadow.y = 620;

        that.scene.Hi_chip_Home.width = 0;
        that.scene.Hi_chip_Home.height = 0;
        that.scene.Hi_chip_Greeting.width = 0;
        that.scene.Hi_chip_Greeting.height = 0;
        that.scene.Hi_chip_Aog.width = 0;
        that.scene.Hi_chip_Aog.height = 0;
        that.scene.Hi_chip_Info.width = 0;
        that.scene.Hi_chip_Info.height = 0;

        that.scene.Hi_chip_Home.x = 37 + 35;
        that.scene.Hi_chip_Home.y = 110 + 35;
        that.scene.Hi_chip_Greeting.x = 127 + 35;
        that.scene.Hi_chip_Greeting.y = 110 + 35;
        that.scene.Hi_chip_Aog.x = 217 + 35;
        that.scene.Hi_chip_Aog.y = 110 + 35;
        that.scene.Hi_chip_Info.x = 307 + 35;
        that.scene.Hi_chip_Info.y = 110 + 35;

        that.scene.Hi_bubble.width = 370;
        that.scene.Hi_bubble.height = 230;
        that.scene.Hi_bubble.x = 21;
        that.scene.Hi_bubble.y = -270;

        //액션 재시작
        that.scene.Hi = 0;

      },

      GREETING: function(data) {
        console.log("command : " + data.command);
        //해당 인텐트를 제외한 모든 인텐트의 화면을 숨김
        that.scene.Hi_container.visible = false;
        that.scene.Fallback_container.visible = false;
        that.scene.Greeting_container.visible = true;
        that.scene.Info_container.visible = false;

        //이미지가 변경된 버튼을 원래대로 변경
        that.scene.Greeting_chip_Home.texture = that.scene.Unclick_chip_Home;
        that.scene.Greeting_chip_Greeting.texture = that.scene.Unclick_chip_Greeting;
        that.scene.Greeting_chip_Aog.texture = that.scene.Unclick_chip_Aog;
        that.scene.Greeting_chip_Info.texture = that.scene.Unclick_chip_Info;

        //액션 재시작
        that.scene.Greeting = 0;

      },

      AOG: function(data) {
        console.log("command : " + data.command);
        //이미지가 변경된 버튼을 원래대로 변경
        that.scene.Aog_chip_Home.texture = that.scene.Unclick_chip_Home;
        that.scene.Aog_chip_Greeting.texture = that.scene.Unclick_chip_Greeting;
        that.scene.Aog_chip_Aog.texture = that.scene.Unclick_chip_Aog;
        that.scene.Aog_chip_Info.texture = that.scene.Unclick_chip_Info;

        //액션 재시작
        that.scene.hello = 0;
        that.scene.swing = 0;
      },

      INFO: function(data) {
        console.log("command : " + data.command);
        //해당 인텐트를 제외한 모든 인텐트의 화면을 숨김
        that.scene.Hi_container.visible = false;
        that.scene.Fallback_container.visible = false;
        that.scene.Greeting_container.visible = false;
        that.scene.Info_container.visible = true;

        //이미지가 변경된 버튼을 원래대로 변경
        that.scene.Info_chip_Home.texture = that.scene.Unclick_chip_Home;
        that.scene.Info_chip_Greeting.texture = that.scene.Unclick_chip_Greeting;
        that.scene.Info_chip_Aog.texture = that.scene.Unclick_chip_Aog;
        that.scene.Info_chip_Info.texture = that.scene.Unclick_chip_Info;
      },

      FALLBACK: function(data) {
        console.log("command : " + data.command);
        //해당 인텐트를 제외한 모든 인텐트의 화면을 숨김
        that.scene.Hi_container.visible = false;
        that.scene.Fallback_container.visible = true;
        that.scene.Greeting_container.visible = false;
        that.scene.Info_container.visible = false;

        //이미지가 변경된 버튼을 원래대로 변경
        that.scene.Fallback_chip_Home.texture = that.scene.Unclick_chip_Home;
        that.scene.Fallback_chip_Greeting.texture = that.scene.Unclick_chip_Greeting;
        that.scene.Fallback_chip_Aog.texture = that.scene.Unclick_chip_Aog;
        that.scene.Fallback_chip_Info.texture = that.scene.Unclick_chip_Info;

        //액션 재시작
        that.scene.Fallback = 0;
        that.scene.time = 0;


      },

      ADDRESSDIV_INFO_OPTION: function(data) {
        console.log("command : " + data.command);
        //해당 인텐트를 제외한 모든 인텐트의 화면을 숨김
        that.scene.Infotel_container.visible = true;
        that.scene.Infotel_prize.visible = false;
        that.scene.Infotel_address.visible = true;
        that.scene.Infotel_establish.visible = false;
        that.scene.Infotel_homepage.visible = false;
        that.scene.Infotel_prizeText.visible = false;
        that.scene.Infotel_addressText.visible = true;
        that.scene.Infotel_contactText.visible = false;
        that.scene.Infotel_establishText.visible = false;
        that.scene.Infotel_homepageText.visible = false;
        that.scene.Infotel_phone.visible = false;
        that.scene.Infotel_email.visible = false;

        //이미지가 변경된 버튼을 원래대로 변경
        that.scene.Infotel_chip_Home.texture = that.scene.Unclick_chip_Home;
        that.scene.Infotel_chip_Greeting.texture = that.scene.Unclick_chip_Greeting;
        that.scene.Infotel_chip_Aog.texture = that.scene.Unclick_chip_Aog;
        that.scene.Infotel_chip_Info.texture = that.scene.Unclick_chip_Info;
      },

      HOMEPAGEDIV_INFO_OPTION: function(data) {
        console.log("command : " + data.command);
        //해당 인텐트를 제외한 모든 인텐트의 화면을 숨김
        that.scene.Infotel_container.visible = true;
        that.scene.Infotel_prize.visible = false;
        that.scene.Infotel_address.visible = false;
        that.scene.Infotel_establish.visible = false;
        that.scene.Infotel_homepage.visible = true;
        that.scene.Infotel_prizeText.visible = false;
        that.scene.Infotel_addressText.visible = false;
        that.scene.Infotel_contactText.visible = false;
        that.scene.Infotel_establishText.visible = false;
        that.scene.Infotel_homepageText.visible = true;
        that.scene.Infotel_phone.visible = false;
        that.scene.Infotel_email.visible = false;

        //이미지가 변경된 버튼을 원래대로 변경
        that.scene.Infotel_chip_Home.texture = that.scene.Unclick_chip_Home;
        that.scene.Infotel_chip_Greeting.texture = that.scene.Unclick_chip_Greeting;
        that.scene.Infotel_chip_Aog.texture = that.scene.Unclick_chip_Aog;
        that.scene.Infotel_chip_Info.texture = that.scene.Unclick_chip_Info;
      },

      CONTACTDIV_INFO_OPTION: function(data) {
        console.log("command : " + data.command);
        //해당 인텐트를 제외한 모든 인텐트의 화면을 숨김
        that.scene.Infotel_container.visible = true;
        that.scene.Infotel_prize.visible = false;
        that.scene.Infotel_address.visible = false;
        that.scene.Infotel_establish.visible = false;
        that.scene.Infotel_homepage.visible = false;
        that.scene.Infotel_prizeText.visible = false;
        that.scene.Infotel_addressText.visible = false;
        that.scene.Infotel_contactText.visible = true;
        that.scene.Infotel_establishText.visible = false;
        that.scene.Infotel_homepageText.visible = false;
        that.scene.Infotel_phone.visible = true;
        that.scene.Infotel_email.visible = true;

        //이미지가 변경된 버튼을 원래대로 변경
        that.scene.Infotel_chip_Greeting.texture = that.scene.Unclick_chip_Greeting;
        that.scene.Infotel_chip_Home.texture = that.scene.Unclick_chip_Home;
        that.scene.Infotel_chip_Aog.texture = that.scene.Unclick_chip_Aog;
        that.scene.Infotel_chip_Info.texture = that.scene.Unclick_chip_Info;
      },

      ESTABLISHDIV_INFO_OPTION: function(data) {
        console.log("command : " + data.command);
        //해당 인텐트를 제외한 모든 인텐트의 화면을 숨김
        that.scene.Infotel_container.visible = true;
        that.scene.Infotel_prize.visible = false;
        that.scene.Infotel_address.visible = false;
        that.scene.Infotel_establish.visible = true;
        that.scene.Infotel_homepage.visible = false;
        that.scene.Infotel_prizeText.visible = false;
        that.scene.Infotel_addressText.visible = false;
        that.scene.Infotel_contactText.visible = false;
        that.scene.Infotel_establishText.visible = true;
        that.scene.Infotel_homepageText.visible = false;
        that.scene.Infotel_phone.visible = false;
        that.scene.Infotel_email.visible = false;

        //이미지가 변경된 버튼을 원래대로 변경
        that.scene.Infotel_chip_Home.texture = that.scene.Unclick_chip_Home;
        that.scene.Infotel_chip_Greeting.texture = that.scene.Unclick_chip_Greeting;
        that.scene.Infotel_chip_Aog.texture = that.scene.Unclick_chip_Aog;
        that.scene.Infotel_chip_Info.texture = that.scene.Unclick_chip_Info;
      },

      PRIZEDIV_INFO_OPTION: function(data) {
        console.log("command : " + data.command);
        //해당 인텐트를 제외한 모든 인텐트의 화면을 숨김
        that.scene.Infotel_container.visible = true;
        that.scene.Infotel_prize.visible = true;
        that.scene.Infotel_address.visible = false;
        that.scene.Infotel_establish.visible = false;
        that.scene.Infotel_homepage.visible = false;
        that.scene.Infotel_prizeText.visible = true;
        that.scene.Infotel_addressText.visible = false;
        that.scene.Infotel_contactText.visible = false;
        that.scene.Infotel_establishText.visible = false;
        that.scene.Infotel_homepageText.visible = false;
        that.scene.Infotel_phone.visible = false;
        that.scene.Infotel_email.visible = false;

        //이미지가 변경된 버튼을 원래대로 변경
        that.scene.Infotel_chip_Home.texture = that.scene.Unclick_chip_Home;
        that.scene.Infotel_chip_Greeting.texture = that.scene.Unclick_chip_Greeting;
        that.scene.Infotel_chip_Aog.texture = that.scene.Unclick_chip_Aog;
        that.scene.Infotel_chip_Info.texture = that.scene.Unclick_chip_Info;
      }
    };
  }




  /**
   * Register all callbacks used by Interactive Canvas
   * executed during scene creation time.
   *
   */
  setCallbacks() {
    const that = this;
    // declare interactive canvas callbacks
    const callbacks = {
      onUpdate(data) {
        try {
          that.commands[data.command.toUpperCase()](data);
          console.log("onUpdate : " + data.command);
          // 예상 출력값 : onUpdate : MAIN
        } catch (e) {
          // AoG 입력값을 매칭하지 못했을 경우
          console.log("error : " + e);
          // 예상 출력값 : error : TypeError: Cannot read property 'toUpperCase' of undefined
          // do nothing, when no command is sent or found
        }
      },
    };
    // called by the Interactive Canvas web app once web app has loaded to
    // register callbacks
    this.canvas.ready(callbacks);
    console.log("setCallbacks READY");
  }
}
