package com.o2o.action.server.app;

import com.google.actions.api.*;
import com.google.actions.api.Capability;
import com.google.actions.api.response.ResponseBuilder;
import com.google.actions.api.response.helperintent.SelectionCarousel;
import com.google.actions.api.response.helperintent.SelectionList;
import com.google.api.services.actions_fulfillment.v2.model.*;
import com.o2o.action.server.util.CommonUtil;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;
import java.util.concurrent.ExecutionException;
//테스트 -창선
public class internApp extends DialogflowApp {

	@ForIntent("Default Welcome Intent")
	public ActionResponse defaultWelcome(ActionRequest request) throws ExecutionException, InterruptedException {
		ResponseBuilder rb = getResponseBuilder(request);
		List<String> suggestions = new ArrayList<String>();SimpleResponse simpleResponse = new SimpleResponse();
		BasicCard basicCard = new BasicCard();

		Map<String, Object> data = rb.getConversationData();

		data.clear();
		CommonUtil.printMapData(data);

		simpleResponse.setTextToSpeech("안녕! 나는 오투오의 귀염둥이 오뚜야! 주식회사 오투오는 처음이지? 궁금한게 있으면 편하게 물어봐줘! 입력되지 않은 오투오의 정보는 곧 업데이트 될 예정이야!")
				.setDisplayText("안녕! 나는 오투오의 귀염둥이 오뚜야! 주식회사 오투오는 처음이지? 궁금한게 있으면 편하게 물어봐줘! 입력되지 않은 오투오의 정보는 곧 업데이트 될 예정이야!")
		;

		basicCard
				.setFormattedText("안녕하세요! 주식회사 오투오 입니다. 궁금하신점에 대해 마음껏 물어봐주세요!")
				.setImage(new Image().setUrl("https://firebasestorage.googleapis.com/v0/b/o2o-intern-nfumup.appspot.com/o/logo.jpg?alt=media&token=5ba71cb0-2de8-4b0a-a8b5-aa95ff90cbb6")
						.setAccessibilityText("O2O"));

		rb.add(simpleResponse);
		rb.add(basicCard);

		return rb.build();
	}


	@ForIntent("O2O_info")
	public ActionResponse o2o_info(ActionRequest request) throws ExecutionException, InterruptedException {
		ResponseBuilder rb = getResponseBuilder(request);
		List<String> suggestions = new ArrayList<String>();
		SimpleResponse simpleResponse = new SimpleResponse();
		//BasicCard basicCard = new BasicCard();

		Map<String, Object> data = rb.getConversationData();
		data.clear();
		CommonUtil.printMapData(data);

		simpleResponse
				.setTextToSpeech("우리 회사의 기본정보 목록이야! 궁금한게 있으면 골라봐!")
				.setDisplayText("우리 회사의 기본정보 목록이야! 궁금한게 있으면 골라봐!");

		// 리스트를 보여줄 때 대사! -> 우리 회사의 기본정보 목록이야! 궁금한게 있으면 골라봐!
		// 주소가 궁금하구나
		// fallback 보류  --- 궁금쓰
		rb.add(simpleResponse);

		//코드수정 테스트 - 제현
		rb.addSuggestions(suggestions.toArray(new String[suggestions.size()]));
		return rb.build();
	}

	@ForIntent("O2O_aog")
	public ActionResponse browseCarousel(ActionRequest request) {
		ResponseBuilder responseBuilder = getResponseBuilder(request);
		if (!request.hasCapability(Capability.SCREEN_OUTPUT.getValue())
				|| !request.hasCapability(Capability.WEB_BROWSER.getValue())) {
			return responseBuilder
					.add("Sorry, try this on a phone or select the phone surface in the simulator.")
					.add("Which response would you like to see next?")
					.build();
		}

		responseBuilder
				.add("우리가 만든 AOG는 이런게 있어. 궁금하지? 관심있는 AOG를 눌러봐! ")
				.add(
						new CarouselBrowse()
								.setItems(
										new ArrayList<CarouselBrowseItem>(
												Arrays.asList(
														new CarouselBrowseItem()
																.setTitle("코로나알림장")
																.setDescription(" ")
																.setOpenUrlAction(new OpenUrlAction().setUrl("https://youtu.be/8WO6KlAidCc"))
																.setImage(
																		new Image()
																				.setUrl(
																						"https://firebasestorage.googleapis.com/v0/b/o2o-intern-nfumup.appspot.com/o/%EC%BD%94%EB%A1%9C%EB%82%98%EC%95%8C%EB%A6%BC%EC%9E%A5.png?alt=media&token=0445c102-607b-4135-b0f7-348ab3e8bd44")
																				.setAccessibilityText("Image alternate text"))
																.setFooter("(주)오투오"),
														new CarouselBrowseItem()
																.setTitle("춘천 트립")
																.setDescription(" ")
																.setOpenUrlAction(new OpenUrlAction().setUrl("https://www.youtube.com/watch?v=tcBKO2P-AQQ"))
																.setImage(
																		new Image()
																				.setUrl(
																						"https://firebasestorage.googleapis.com/v0/b/o2o-intern-nfumup.appspot.com/o/%EC%9D%B4%EB%AF%B8%EC%A7%80%20012.png?alt=media&token=6414fe80-dca0-4f32-baaf-03ff3039e17c")
																				.setAccessibilityText("Image alternate text"))
																.setFooter("(주)오투오")))));

		return responseBuilder.build();
	}

	@ForIntent("O2O_greeting")  // 대표님 GIF + 음성 따서 해도 재밌을듯 
	public ActionResponse greeting(ActionRequest request) {
		ResponseBuilder rb = getResponseBuilder(request);
		List<String> suggestions = new ArrayList<String>();
		SimpleResponse simpleResponse = new SimpleResponse();

		Map<String, Object> data = rb.getConversationData();
		data.clear();
		CommonUtil.printMapData(data);

		simpleResponse.setTextToSpeech("주식회사 오투오는 ai를 기반으로 한 음성인식 응용 디바이스 및 서비스를 제공하는 회사야! " +
				"오투오에서 만드는 서비스는 google assistant와 빅데이터를 기반으로 하기 때문에 사용자에 따라 최상의 답변을 제공할 수 있어! " +
				"주요 서비스로는 대화형 관광안내, 행정정보 등이 있어. 궁금하면 유투브에 ai o2o를 검색하면 오투오에서 만든 다양한 aog를 볼 수 있어!")


				.setDisplayText("주식회사 오투오는 ai를 기반으로 한 음성인식 응용 디바이스 및 서비스를 제공하는 회사야! " +
						"오투오에서 만드는 서비스는 google assistant와 빅데이터를 기반으로 하기 때문에 사용자에 따라 최상의 답변을 제공할 수 있어! " +
						"주요 서비스로는 대화형 관광안내, 행정정보 등이 있어. 궁금하면 유투브에 ai o2o를 검색하면 오투오에서 만든 다양한 aog를 볼 수 있어!");

		rb.add(simpleResponse);

		rb.addSuggestions(suggestions.toArray(new String[suggestions.size()]));
		return rb.build();

	}
}

