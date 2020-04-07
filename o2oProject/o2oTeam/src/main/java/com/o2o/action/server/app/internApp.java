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

public class internApp extends DialogflowApp {

	@ForIntent("Default Welcome Intent")
	public ActionResponse defaultWelcome(ActionRequest request) throws ExecutionException, InterruptedException {
		ResponseBuilder rb = getResponseBuilder(request);
		List<String> suggestions = new ArrayList<String>();SimpleResponse simpleResponse = new SimpleResponse();
		BasicCard basicCard = new BasicCard();

		Map<String, Object> data = rb.getConversationData();

		data.clear();
		CommonUtil.printMapData(data);

		simpleResponse
				.setDisplayText("안녕! 나는 오투오의 귀염둥이 오뚜야! 주식회사 오투오는 처음이지? 궁금한게 있으면 편하게 물어봐줘! 입력되지 않은 오투오의 정보는 곧 업데이트 될 예정이야!")
				.setTextToSpeech("<speak>"
						+ "<audio src=\"https://firebasestorage.googleapis.com/v0/b/o2o-intern-nfumup.appspot.com/o/dubbing%2Fwelcome_default_intent.mp3?alt=media&amp;token=a1b413ad-6bb3-4fa0-8061-d089c16c9765\"></audio>"
						+ "</speak>");


		basicCard
				.setFormattedText("주식회사 오투오 알리미 오뚜에게 물어보세요")
				.setImage(new Image().setUrl("https://firebasestorage.googleapis.com/v0/b/o2o-intern-nfumup.appspot.com/o/logo.jpg?alt=media&token=5ba71cb0-2de8-4b0a-a8b5-aa95ff90cbb6")
						.setAccessibilityText("O2O"));

		rb.add(simpleResponse);
		rb.add(basicCard);

		return rb.build();
	}
	@ForIntent("Carousel")
	public ActionResponse browseCarousel(ActionRequest request) {
		ResponseBuilder rb = getResponseBuilder(request);
		List<String> suggestions = new ArrayList<String>();
		SimpleResponse simpleResponse = new SimpleResponse();
		BasicCard basicCard = new BasicCard();

		Map<String, Object> data = rb.getConversationData();
		data.clear();
		CommonUtil.printMapData(data);

		simpleResponse
				.setTextToSpeech("<speak>"
						+ "<audio src=\"https://firebasestorage.googleapis.com/v0/b/o2o-intern-nfumup.appspot.com/o/dubbing%2F01_%EC%98%A4%ED%88%AC%EC%98%A4%EC%97%90_%EB%8C%80%ED%95%B4_%EC%98%A4%EB%9A%9C%EA%B0%80_%EC%86%8C%EA%B0%9C%ED%95%B4%EC%A4%84%EA%B2%8C.mp3?alt=media&amp;token=5c9f19e3-161e-4006-99b1-6911c757e3d7\"></audio>"
						+ "<audio src=\"https://firebasestorage.googleapis.com/v0/b/o2o-intern-nfumup.appspot.com/o/dubbing%2F%EB%8C%80%ED%91%9C%EC%9D%B8%EC%82%AC%EB%A7%90.mp3?alt=media&amp;token=e3faf9e6-b774-4757-a139-278b01466337\"></audio>"
						+ "</speak>")
				.setDisplayText("우리 회사의 안성민 대표님이 잘 소개해주실꺼야!");

		basicCard
				.setFormattedText("주식회사 오투오는 ai를 기반으로 한 음성인식 응용 디바이스 및 서비스를 제공하는 회사야!  \n " +
						"오투오에서 만드는 서비스는 google assistant와 빅데이터를 기반으로 하기 때문에 사용자에 따라 최상의 답변을 제공할 수 있어!  \n " +
						"주요 서비스로는 대화형 관광안내, 행정정보 등이 있어.  \n 궁금하면 아래의 유투브 링크를 확인하면 오투오에서 만든 다양한 aog를 볼 수 있어! 구독과 좋아요도 부탁해!")
				.setImage(new Image().setUrl("https://actions.o2o.kr/content/telechips/telechipsaiperson_ko.gif")
						.setAccessibilityText("오뚜"))
				.setButtons(
						new ArrayList<Button>(
								Arrays.asList(
										new Button()
												.setTitle("AI O2O 링크")
												.setOpenUrlAction(
														new OpenUrlAction().setUrl("https://www.youtube.com/channel/UCIiFvxaahQA-rLP8KpkDM0w")
												)
								)
						)
				);

		rb.add(simpleResponse);
		rb.add(basicCard);

		rb.addSuggestions(suggestions.toArray(new String[suggestions.size()]));
		return rb.build();
	}

	@ForIntent("Carousel-OPTION")
	public ActionResponse carouselSelected(ActionRequest request) {
		ResponseBuilder rb = getResponseBuilder(request);
		List<String> suggestions = new ArrayList<String>();
		SimpleResponse simpleResponse = new SimpleResponse();
		SelectionList selectionList = new SelectionList();
		BasicCard basicCard = new BasicCard();

		Map<String, Object> data = rb.getConversationData();
		data.clear();
		CommonUtil.printMapData(data);

		return rb.build();
	}
}

