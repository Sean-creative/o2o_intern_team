package com.o2o.action.server.app;

import com.google.actions.api.Capability;
import com.google.actions.api.*;
import com.google.actions.api.response.ResponseBuilder;
import com.google.actions.api.response.helperintent.SelectionList;
import com.google.api.services.actions_fulfillment.v2.model.*;
import com.o2o.action.server.util.CommonUtil;

import java.util.*;
import java.util.concurrent.ExecutionException;

//테스트 -창선
// 선우 수정 20/03/19
// 혜원 수정 20/03/19
// 선우 인텔리제이에서 보냄 0319/ 2:43PM
public class interactiveCanvas extends DialogflowApp {

	@ForIntent("Default Welcome Intent")
	public ActionResponse defaultWelcome(ActionRequest request) throws ExecutionException, InterruptedException {

		ResponseBuilder rb = getResponseBuilder(request);
		Map<String, Object> data = rb.getConversationData();

		if (!request.hasCapability("actions.capability.INTERACTIVE_CANVAS")) {
			return rb
					.add("Sorry, try this on a phone or select the phone surface in the simulator.")
					.add("안된다 안돼 선우야!! ?")
					.build();
		} else {
			int a = (int)(Math.random()*100);

//			data.put("data1", a);
//			data.put("command", "SEANTWO");
			return rb.add(new SimpleResponse().setTextToSpeech("안녕하세요. 인턴 캔버스 테스트 입니다. 무엇을 도와드릴까요?"))
					.add(new HtmlResponse().setUrl("https://interactivecanvastest-d2723.firebaseapp.com").setUpdatedState(data)).build();
		}  //https://interactivecanvastest-d2723.firebaseapp.com  인터랙티브 캔버스
	}


	@ForIntent("snow")
	public ActionResponse basicCard(ActionRequest request) {
		ResponseBuilder responseBuilder = getResponseBuilder(request);
		Map<String, Object> data = responseBuilder.getConversationData();

		data.clear();

		if (!request.hasCapability("actions.capability.INTERACTIVE_CANVAS")) {
			return responseBuilder
					.add("Sorry, try this on a phone or select the phone surface in the simulator.")
					.add("Which response would you like to see next?")
					.build();
		} else {
			int a = (int) (Math.random() * 100);
			data.put("data1", a);
			data.put("command", "SEANONE");
			return responseBuilder.add(new SimpleResponse().setTextToSpeech("인텐트 체인지 체크"))
					.add(new HtmlResponse().setUpdatedState(data)).build();
		}


	}
}
