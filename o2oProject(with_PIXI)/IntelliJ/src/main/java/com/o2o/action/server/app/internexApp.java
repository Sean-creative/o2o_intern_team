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

public class internexApp extends DialogflowApp {
	
	//시작 페이지 intent
	@ForIntent("Default Welcome Intent")
	public ActionResponse defaultWelcome(ActionRequest request) throws ExecutionException, InterruptedException {
		ResponseBuilder rb = getResponseBuilder(request);
		SimpleResponse simpleResponse = new SimpleResponse();
		Map<String, Object> data = rb.getConversationData();

		data.clear();
		CommonUtil.printMapData(data);
		
		//오뚜 인사말 음성 출력
		simpleResponse.setTextToSpeech("<speak>"
						+ "<audio src=\"https://firebasestorage.googleapis.com/v0/b/o2o-intern-nfumup.appspot.com/o/dubbing%2Fwelcome_default_intent.mp3?alt=media&amp;token=a1b413ad-6bb3-4fa0-8061-d089c16c9765\"></audio>"
						+ "</speak>")
				.setDisplayText("오투오의 등장!");
		//디바이스가 interactive canvas를 지원하지 않을 경우
		if (!request.hasCapability("actions.capability.INTERACTIVE_CANVAS")) {
			return rb.add(new SimpleResponse().setTextToSpeech("지원하지않습니다.")).endConversation().build();
		} else {
			//디바이스가 interactive canvas를 지원하면 HI 명령을 보낸다.
			data.put("command", "HI");
			
			//interactive canvas에 해당 페이지를 사용해 HTML응답을 보내고 명령 전달
			return rb.add(simpleResponse).add(new HtmlResponse().setUrl("https://intern-ex.firebaseapp.com")
					.setUpdatedState(data)).build();

	}
	}
	
	//사용자의 명령을 인식하지 못했을 경우에 실행되는 intent
	@ForIntent("Default Fallback Intent")
	public ActionResponse defaultFallback(ActionRequest request) throws ExecutionException, InterruptedException {
		ResponseBuilder rb = getResponseBuilder(request);
		SimpleResponse simpleResponse = new SimpleResponse();

		Map<String, Object> data = rb.getConversationData();

		data.clear();
		CommonUtil.printMapData(data);
		
		//오뚜의 Fallback 음성 출력
		simpleResponse
				.setTextToSpeech("<speak>"
						+ "<audio src=\"https://firebasestorage.googleapis.com/v0/b/o2o-intern-nfumup.appspot.com/o/%EC%98%A4%ED%88%AC%EC%98%A4%20fallback%20%EC%B5%9C%EC%A2%85.mp3?alt=media&amp;token=aac5c1e0-4ac1-4ebd-bbce-a8c649cb6033\"></audio>"
						+ "</speak>")
				.setDisplayText("오투오의 Fallback입니다!");

		//FALLBACK 명령어를 interactive canvas로 전달
		data.put("command", "FALLBACK");
		
		//interactive canvas에 해당 페이지를 사용해 HTML응답을 보내고 명령 전달
		return rb.add(simpleResponse).add(new HtmlResponse().setUrl("https://intern-ex.firebaseapp.com").setUpdatedState(data)).build();
	}
	
	//오투오 소개 intent
	@ForIntent("O2O_greeting")
	public ActionResponse O2O_greeting(ActionRequest request) throws ExecutionException, InterruptedException {
		ResponseBuilder rb = getResponseBuilder(request);
		SimpleResponse simpleResponse = new SimpleResponse();

		Map<String, Object> data = rb.getConversationData();

		data.clear();
		CommonUtil.printMapData(data);
		
		//오뚜 음성과 대표님 음성을 순서대로 출력
		simpleResponse
				.setTextToSpeech("<speak>"
						+ "<audio src=\"https://firebasestorage.googleapis.com/v0/b/o2o-intern-nfumup.appspot.com/o/dubbing%2F%EC%98%A4%EB%9A%9C%EC%9D%98%20%EC%86%8C%EA%B0%9C.mp3?alt=media&amp;token=24a8462c-dae2-4276-bbce-3cd1de0f48cb\"></audio>"
						+ "<audio src=\"https://firebasestorage.googleapis.com/v0/b/o2o-intern-nfumup.appspot.com/o/dubbing%2F%EB%8C%80%ED%91%9C%EB%8B%98.mp3?alt=media&amp;token=56893311-33ac-4dc4-ad30-b9000c9690da\"></audio>"
						+ "</speak>")
				//.setTextToSpeech("주식회사 오투오는 ai를 기반으로 한 음성인식 응용 디바이스 및 서비스를 제공하는 회사입니다. 오투오에서 만드는 서비스는 google assistant와 빅데이터를 기반으로 하기 때문에 사용자에 따라 최상의 답변을 제공할 수 있습니다. 주요 서비스로는 대화형 관광안내, 행정정보 등이 있습니다. 궁금하시다면 아래의 유투브 링크를 클릭해보세요.")
				.setDisplayText("우리 회사의 안성민 대표님이 잘 소개해주실꺼야!");


		//interactive canvas에 GREETING 명령 전달
		data.put("command", "GREETING");
		
		//interactive canvas에 해당 페이지를 사용해 HTML응답을 보내고 명령 전달
		return rb.add(simpleResponse).add(new HtmlResponse().setUrl("https://intern-ex.firebaseapp.com").setUpdatedState(data)).build();

		}
	
	//오투오의 AoG 소개 intent
	@ForIntent("O2O_aog")
	public ActionResponse O2O_aog(ActionRequest request) throws ExecutionException, InterruptedException {
		ResponseBuilder rb = getResponseBuilder(request);
		SimpleResponse simpleResponse = new SimpleResponse();

		Map<String, Object> data = rb.getConversationData();

		data.clear();
		CommonUtil.printMapData(data);
		
		//오뚜 AoG 소개 음성 출력
		simpleResponse
				.setTextToSpeech("<speak>"
						+ "<audio src=\"https://firebasestorage.googleapis.com/v0/b/o2o-intern-nfumup.appspot.com/o/dubbing%2Fo2o_aog.mp3?alt=media&amp;token=47455549-6a8c-4d49-a103-b64aa32f9843\"></audio>"
						+ "</speak>")
				.setDisplayText("오투오의 aog입니다!");

		//interactive canvas로 AOG 명령 전달
		data.put("command", "AOG");
		
		//interactive canvas에 해당 페이지를 사용해 HTML응답을 보내고 명령 전달
		//다시 interactive canvas로 돌아올 수 있도록 하기 위해 서로 다른 html 파일을 사용
		return rb.add(simpleResponse).add(new HtmlResponse().setUrl("https://intern-ex.firebaseapp.com/Aog.html").setUpdatedState(data)).build();
	}
	
	//오투오 기본정보 소개 intent
	@ForIntent("O2O_info")
	public ActionResponse O2O_info(ActionRequest request) throws ExecutionException, InterruptedException {
		ResponseBuilder rb = getResponseBuilder(request);
		SimpleResponse simpleResponse = new SimpleResponse();

		Map<String, Object> data = rb.getConversationData();

		data.clear();
		CommonUtil.printMapData(data);
		
		//오뚜 기본정보 음성 출력
		simpleResponse
				.setTextToSpeech("<speak>"
						+ "<audio src=\"https://firebasestorage.googleapis.com/v0/b/o2o-intern-nfumup.appspot.com/o/dubbing%2Fo2o_info.mp3?alt=media&amp;token=8ae3c1e8-1392-40c9-9c18-5e8781f3cd72\"></audio>"
						+ "</speak>")
				.setDisplayText("우리 회사의 기본정보 목록이야!  \n"
						+ "궁금한게 있으면 골라봐!");
		
		//interactive canvas로 INFO 명령 전달
		data.put("command", "INFO");
		
		//interactive canvas에 해당 페이지를 사용해 HTML응답을 보내고 명령 전달
		return rb.add(simpleResponse).add(new HtmlResponse().setUrl("https://intern-ex.firebaseapp.com").setUpdatedState(data)).build();

	}

	//기본정보에서 상세 정보 선택 시 정보를 보여주는 intent
	@ForIntent("INFOTEL")
	public ActionResponse INFOTEL(ActionRequest request) throws ExecutionException, InterruptedException {
		ResponseBuilder rb = getResponseBuilder(request);
		SimpleResponse simpleResponse = new SimpleResponse();

		Map<String, Object> data = rb.getConversationData();

		data.clear();
		CommonUtil.printMapData(data);

		//사용자의 음성을 text로 저장
		String input = CommonUtil.makeSafeString(request.getRawText());
		
		//입력받은 text가 해당 내용을 포함하고 있을 때 각각에 맞는 정보를 보여줌
		if (!CommonUtil.isEmptyString(input) && input.contains("주소") || input.contains("홈페이지") || input.contains("연락처") || input.contains("설립") || input.contains("연혁") || input.contains("수상")
				|| input.contains("수상내역") || input.contains("수상이력") || input.contains("전화번호") || input.contains("번호") || input.contains("메일") || input.contains("이메일")) {
			if (input.contains("주소")) {//주소 선택 시 이에 맞는 음성을 출력하고 명령 전달
				data.put("command", "ADDRESSDIV_INFO_OPTION");
				simpleResponse
						.setTextToSpeech("<speak>"
								+ "<audio src=\"https://firebasestorage.googleapis.com/v0/b/o2o-intern-nfumup.appspot.com/o/dubbing%2F%EC%98%A4%EB%9A%9C%20%EC%A3%BC%EC%86%8C.mp3?alt=media&amp;token=6db3ab35-16bd-425c-870f-d831e60fe439\"></audio>"
								+ "</speak>")
						.setDisplayText("우리 회사 주소는  \n" +
								"서울특별시 서초구 매헌로 8길 47번지,  \n" +
								"양재 AI허브 희경빌딩 B동 203호야!");

			} else if (input.contains("홈페이지")) {//홈페이지 선택 시 이에 맞는 음성을 출력하고 명령 전달
				data.put("command", "HOMEPAGEDIV_INFO_OPTION");
				simpleResponse
						.setTextToSpeech("<speak>"
								+ "<audio src=\"https://firebasestorage.googleapis.com/v0/b/o2o-intern-nfumup.appspot.com/o/dubbing%2F03_%EC%9A%B0%EB%A6%AC_%ED%9A%8C%EC%82%AC%EC%9D%98_%ED%99%88%ED%8E%98%EC%9D%B4%EC%A7%80%EC%95%BC.mp3?alt=media&amp;token=e2f53074-1977-476c-ba34-a331e768a4b1\"></audio>"
								+ "</speak>")
						.setDisplayText("우리 회사의 홈페이지야!");

			} else if (input.contains("연락처") || input.contains("전화번호") || input.contains("번호") || input.contains("메일") || input.contains("이메일")) {
				////연락처 선택 시 이에 맞는 음성을 출력하고 명령 전달
				data.put("command", "CONTACTDIV_INFO_OPTION");
				simpleResponse
						.setTextToSpeech("<speak>"
								+ "<audio src=\"https://firebasestorage.googleapis.com/v0/b/o2o-intern-nfumup.appspot.com/o/dubbing%2F04_%EC%9A%B0%EB%A6%AC_%ED%9A%8C%EC%82%AC%EC%9D%98_%EC%97%B0%EB%9D%BD%EC%B2%98%EC%95%BC.mp3?alt=media&amp;token=ee67b529-7500-463a-91be-e5f75d1a0532\"></audio>"
								+ "</speak>")
						.setDisplayText("우리 회사의 연락처야!");

			} else if (input.contains("설립")) {
				//설립일 선택 시 이에 맞는 음성을 출력하고 명령 전달
				data.put("command", "ESTABLISHDIV_INFO_OPTION");
				simpleResponse
						.setTextToSpeech("<speak>"
								+ "<audio src=\"https://firebasestorage.googleapis.com/v0/b/o2o-intern-nfumup.appspot.com/o/dubbing%2F05_%EC%9A%B0%EB%A6%AC_%ED%9A%8C%EC%82%AC%EC%9D%98_%EC%84%A4%EB%A6%BD%EC%9D%BC%EC%9D%80_2017%EB%85%84_8%EC%9B%94_16%EC%9D%BC%EC%9D%B4%EC%95%BC.mp3?alt=media&amp;token=ef47d3b3-b4ef-4290-87aa-eec561037137\"></audio>"
								+ "</speak>")
						.setDisplayText("우리 회사의 설립일은  \n" +
								"2017년 8월 16일이야!");

			} else if (input.contains("연혁") || input.contains("수상") || input.contains("수상내역") || input.contains("수상이력")) {
				//수상내역 선택 시 이에 맞는 음성을 출력하고 명령 전달
				data.put("command", "PRIZEDIV_INFO_OPTION");
				simpleResponse
						.setTextToSpeech("<speak>"
								+ "<audio src=\"https://firebasestorage.googleapis.com/v0/b/o2o-intern-nfumup.appspot.com/o/dubbing%2F06_%EC%9A%B0%EB%A6%AC_%ED%9A%8C%EC%82%AC%EC%9D%98_%EC%97%B0%ED%98%81%EA%B3%BC_%EC%88%98%EC%83%81%EC%9D%B4%EB%A0%A5%EC%9D%B4%EC%95%BC.mp3?alt=media&amp;token=6871b8fc-ba5f-4643-ac5e-26e4659834bd\"></audio>"
								+ "</speak>")
						.setDisplayText("우리 회사의 연혁과 수상이력이야!");
			}
		}
		
		//interactive canvas에 해당 페이지를 사용해 HTML응답을 보내고 명령 전달
		//다시 interactive canvas로 돌아올 수 있도록 하기 위해 서로 다른 html 파일을 사용
		return rb.add(simpleResponse).add(new HtmlResponse().setUrl("https://intern-ex.firebaseapp.com/Infotel.html").setUpdatedState(data)).build();
	}
}



