package com.o2o.action.server.app;

import com.google.actions.api.ActionRequest;
import com.google.actions.api.ActionResponse;
import com.google.actions.api.DialogflowApp;
import com.google.actions.api.ForIntent;
import com.google.actions.api.response.ResponseBuilder;
import com.google.actions.api.response.helperintent.*;
import com.google.api.services.actions_fulfillment.v2.model.*;
import com.o2o.action.server.util.CommonUtil;
import com.google.actions.api.Capability;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class OdduApp extends DialogflowApp {



	@ForIntent("Default Welcome Intent")
	public ActionResponse defaultWelcome(ActionRequest request) throws ExecutionException, InterruptedException {
		ResponseBuilder rb = getResponseBuilder(request);
		SimpleResponse simpleResponse = new SimpleResponse();
		BasicCard basicCard = new BasicCard();

		Map<String, Object> data = rb.getConversationData();

		data.clear();
		CommonUtil.printMapData(data);

		simpleResponse.setTextToSpeech("<speak>"
						+ "<audio src=\"https://firebasestorage.googleapis.com/v0/b/o2o-intern-nfumup.appspot.com/o/dubbing%2Fwelcome_default_intent.mp3?alt=media&amp;token=a1b413ad-6bb3-4fa0-8061-d089c16c9765\"></audio>"
						+ "</speak>")
				.setDisplayText("오투오의 등장!");


		if (!request.hasCapability("actions.capability.INTERACTIVE_CANVAS")) {
			return rb.add(new SimpleResponse().setTextToSpeech("지원하지않습니다.")).endConversation().build();
		}
		else {
			data.put("command", "HI");
			return rb.add(simpleResponse).add(new HtmlResponse().setUrl("https://o2o-interactivecanvas.web.app")
					.setUpdatedState(data)).build();
		}
	}




	@ForIntent("GREETING")
	public ActionResponse GREETING(ActionRequest request) throws ExecutionException, InterruptedException {
		ResponseBuilder rb = getResponseBuilder(request);
		SimpleResponse simpleResponse = new SimpleResponse();

		Map<String, Object> data = rb.getConversationData();

		data.clear();
		CommonUtil.printMapData(data);

		simpleResponse
				.setTextToSpeech("<speak>"
						+ "<audio src=\"https://firebasestorage.googleapis.com/v0/b/o2o-intern-nfumup.appspot.com/o/dubbing%2F%EC%98%A4%EB%9A%9C%EC%9D%98%20%EC%86%8C%EA%B0%9C.mp3?alt=media&amp;token=24a8462c-dae2-4276-bbce-3cd1de0f48cb\"></audio>"
						+ "<audio src=\"https://firebasestorage.googleapis.com/v0/b/o2o-intern-nfumup.appspot.com/o/dubbing%2FCEO_greeting.mp3?alt=media&amp;token=99840ec1-ece4-4f11-9854-dd9b89a382a9\"></audio>"
						+ "</speak>")
				//.setTextToSpeech("주식회사 오투오는 ai를 기반으로 한 음성인식 응용 디바이스 및 서비스를 제공하는 회사입니다. 오투오에서 만드는 서비스는 google assistant와 빅데이터를 기반으로 하기 때문에 사용자에 따라 최상의 답변을 제공할 수 있습니다. 주요 서비스로는 대화형 관광안내, 행정정보 등이 있습니다. 궁금하시다면 아래의 유투브 링크를 클릭해보세요.")
				.setDisplayText("우리 회사의 안성민 대표님이 잘 소개해주실꺼야!");

		data.put("command", "GREETING");
			return rb.add(simpleResponse).add(new HtmlResponse().setUpdatedState(data)).build();
		}






	@ForIntent("AOG")
	public ActionResponse AOG(ActionRequest request) throws ExecutionException, InterruptedException {
		ResponseBuilder rb = getResponseBuilder(request);
		SimpleResponse simpleResponse = new SimpleResponse();

		Map<String, Object> data = rb.getConversationData();

		data.clear();
		CommonUtil.printMapData(data);
		simpleResponse
				.setTextToSpeech("<speak>"
				+ "<audio src=\"https://firebasestorage.googleapis.com/v0/b/o2o-intern-nfumup.appspot.com/o/dubbing%2Fo2o_aog.mp3?alt=media&amp;token=47455549-6a8c-4d49-a103-b64aa32f9843\"></audio>"
				+ "</speak>")
				.setDisplayText("오투오의 aog입니다!");

		data.put("command", "AOG");
		return rb.add(simpleResponse).add(new HtmlResponse().setUpdatedState(data)).build();
	}






	@ForIntent("INFO")
	public ActionResponse INFO(ActionRequest request) throws ExecutionException, InterruptedException {
		ResponseBuilder rb = getResponseBuilder(request);
		SimpleResponse simpleResponse = new SimpleResponse();

		Map<String, Object> data = rb.getConversationData();

		data.clear();
		CommonUtil.printMapData(data);

		simpleResponse
			.setTextToSpeech("<speak>"
				+ "<audio src=\"https://firebasestorage.googleapis.com/v0/b/o2o-intern-nfumup.appspot.com/o/dubbing%2Fo2o_info.mp3?alt=media&amp;token=8ae3c1e8-1392-40c9-9c18-5e8781f3cd72\"></audio>"
				+ "</speak>")
			.setDisplayText("오투오의 info입니다!");
		
		data.put("command", "INFO");
		
		return rb.add(simpleResponse).add(new HtmlResponse().setUpdatedState(data)).build();
	}



	@ForIntent("INFOTEL")
	public ActionResponse INFO_TEL(ActionRequest request) throws ExecutionException, InterruptedException {
		ResponseBuilder rb = getResponseBuilder(request);
		SimpleResponse simpleResponse = new SimpleResponse();

		Map<String, Object> data = rb.getConversationData();

		data.clear();
		CommonUtil.printMapData(data);
		String input = CommonUtil.makeSafeString(request.getParameter("Information"));
        if(!CommonUtil.isEmptyString(input) && input.equals("Address") || input.equals("Homepage") || input.equals("Contact") || input.equals("Established") || input.equals("Prize")) {

		  if (input.equals("Address")) {
		  	simpleResponse
					.setTextToSpeech("<speak>"
							  + "<audio src=\"https://firebasestorage.googleapis.com/v0/b/o2o-intern-nfumup.appspot.com/o/dubbing%2F02_%EC%9A%B0%EB%A6%AC_%ED%9A%8C%EC%82%AC_%EC%A3%BC%EC%86%8C%EB%8A%94_%EC%84%9C%EC%9A%B8%ED%8A%B9%EB%B3%84%EC%8B%9C_%EC%84%9C%EC%B4%88%EA%B5%AC_%EB%A7%A4%ED%97%8C%EB%A1%9C8%EA%B8%B8_47_%EC%96%91%EC%9E%AC_%EC%97%90%EC%9D%B4%EC%95%84%EC%9D%B4%ED%97%88%EB%B8%8C_%ED%9D%AC%EA%B2%BD%EB%B9%8C%EB%94%A9_B%EB%8F%99_2.mp3?alt=media&token=ba0f84ed-ecef-44b8-93dc-ffe3fcd5ce0a\"></audio>"
							  + "</speak>")
					.setDisplayText("우리 회사 주소는  \n" +
							  "서울특별시 서초구 매헌로 8길 47번지,  \n" +
							  "양재 AI 허브 희경빌딩 B동 203호야!");

		  } else if (input.equals("Homepage")) {
			  simpleResponse
					  .setTextToSpeech("<speak>"
							  + "<audio src=\"https://firebasestorage.googleapis.com/v0/b/o2o-intern-nfumup.appspot.com/o/dubbing%2F03_%EC%9A%B0%EB%A6%AC_%ED%9A%8C%EC%82%AC%EC%9D%98_%ED%99%88%ED%8E%98%EC%9D%B4%EC%A7%80%EC%95%BC.mp3?alt=media&amp;token=e2f53074-1977-476c-ba34-a331e768a4b1\"></audio>"
							  + "</speak>")
					  .setDisplayText("우리 회사의 홈페이지야!");

		  } else if (input.equals("Contact")) {
			  simpleResponse
					  .setTextToSpeech("<speak>"
							  + "<audio src=\"https://firebasestorage.googleapis.com/v0/b/o2o-intern-nfumup.appspot.com/o/dubbing%2F04_%EC%9A%B0%EB%A6%AC_%ED%9A%8C%EC%82%AC%EC%9D%98_%EC%97%B0%EB%9D%BD%EC%B2%98%EC%95%BC.mp3?alt=media&amp;token=ee67b529-7500-463a-91be-e5f75d1a0532\"></audio>"
							  + "</speak>")
					  .setDisplayText("우리 회사의 연락처야!");

		  } else if (input.equals("Established")) {
			  simpleResponse
					  .setTextToSpeech("<speak>"
							  + "<audio src=\"https://firebasestorage.googleapis.com/v0/b/o2o-intern-nfumup.appspot.com/o/dubbing%2F05_%EC%9A%B0%EB%A6%AC_%ED%9A%8C%EC%82%AC%EC%9D%98_%EC%84%A4%EB%A6%BD%EC%9D%BC%EC%9D%80_2017%EB%85%84_8%EC%9B%94_16%EC%9D%BC%EC%9D%B4%EC%95%BC.mp3?alt=media&amp;token=ef47d3b3-b4ef-4290-87aa-eec561037137\"></audio>"
							  + "</speak>")
					  .setDisplayText("우리 회사의 설립일은  \n" +
							  "2017년 8월 16일이야!");

		  } else if (input.equals("History")) {
			  simpleResponse
					  .setTextToSpeech("<speak>"
							  + "<audio src=\"https://firebasestorage.googleapis.com/v0/b/o2o-intern-nfumup.appspot.com/o/dubbing%2F06_%EC%9A%B0%EB%A6%AC_%ED%9A%8C%EC%82%AC%EC%9D%98_%EC%97%B0%ED%98%81%EA%B3%BC_%EC%88%98%EC%83%81%EC%9D%B4%EB%A0%A5%EC%9D%B4%EC%95%BC.mp3?alt=media&amp;token=6871b8fc-ba5f-4643-ac5e-26e4659834bd\"></audio>"
							  + "</speak>")
					  .setDisplayText("우리 회사의 연혁과 수상이력이야!");
		  }
	  }

		data.put("command", "INFOTEL");
		return rb.add(simpleResponse).add(new HtmlResponse().setUpdatedState(data)).build();
	}






	@ForIntent("Default Fallback Intent")
	public ActionResponse defaultFallback(ActionRequest request) throws ExecutionException, InterruptedException {
		ResponseBuilder rb = getResponseBuilder(request);
		SimpleResponse simpleResponse = new SimpleResponse();

		Map<String, Object> data = rb.getConversationData();

		data.clear();
		CommonUtil.printMapData(data);

		simpleResponse
				.setTextToSpeech("<speak>"
						+ "<audio src=\"https://firebasestorage.googleapis.com/v0/b/o2o-intern-nfumup.appspot.com/o/%EC%98%A4%ED%88%AC%EC%98%A4%20fallback.mp3?alt=media&amp;token=41f5c972-30be-424b-bb1d-39e10736d84b\"></audio>"
						+ "</speak>")
				.setDisplayText("오투오의 Fallback입니다!");


		data.put("command", "FALLBACK");

		return rb.add(simpleResponse).add(new HtmlResponse().setUpdatedState(data)).build();
	}
}



