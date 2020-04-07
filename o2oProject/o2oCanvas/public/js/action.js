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
        var con = document.getElementById("hi");
        con.style.display = 'block';
        con = document.getElementById("greeting");
        con.style.display = 'none';
        con = document.getElementById("aog");
        con.style.display = 'none';
        con = document.getElementById("info");
        con.style.display = 'none';
        // setLoadHandler("bg");
      },

      GREETING: function(data) {
        console.log("command : " + data.command);
        var con = document.getElementById("greeting");
        con.style.display = 'block';
        con = document.getElementById("hi");
        con.style.display = 'none';
        con = document.getElementById("aog");
        con.style.display = 'none';
        con = document.getElementById("info");
        con.style.display = 'none';
        // setLoadHandler("bg");
      },

      AOG: function(data) {
        console.log("command : " + data.command);
        var con = document.getElementById("aog");
        setLoadHandler("bg");
        con.style.display = 'block';
        con = document.getElementById("hi");
        con.style.display = 'none';
        con = document.getElementById("greeting");
        con.style.display = 'none';
        con = document.getElementById("info");
        // con.style.display = 'none';
      },

      INFO: function(data) {
        console.log("command : " + data.command);
        var con = document.getElementById("info");
        setLoadHandler("bg");
        con.style.display = 'block';
        con = document.getElementById("hi");
        con.style.display = 'none';
        con = document.getElementById("greeting");
        con.style.display = 'none';
        con = document.getElementById("aog");
        con.style.display = 'none';
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

function getDisplayInfo() {
  console.log("fdata : 2");

  var size = {
    width: window.innerWidth || document.body.clientWidth,
    height: window.innerHeight || document.body.clientHeight
  }
  console.log("fdata : 3");
  return size;
}

function onLoadHandler() {
  var size = getDisplayInfo();
  var bgs = document.getElementsByClassName("bg");
  for (var i = 0; i < bgs.length; i++) {
    var section1 = bgs.item(i);
    section1.style.width = size.width;
  }

  var bg = document.getElementsByClassName("bg");
  for (var i = 0; i < bgs.length; i++) {
    var section1 = bgs.item(i);
    section1.style.height = size.height - 56;
  }
}

function setLoadHandler(data) {
  var size = getDisplayInfo();
  var bgs = document.getElementsByClassName(data);
  for (var i = 0; i < bgs.length; i++) {
    var section1 = bgs.item(i);
    section1.style.width = size.width;
  }

  var bg = document.getElementsByClassName(data);
  for (var i = 0; i < bgs.length; i++) {
    var section1 = bgs.item(i);
    section1.style.height = size.height - 56;
  }
}
