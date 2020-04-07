package com.o2o.action.server.app;

import com.google.actions.api.ActionRequest;
import com.google.actions.api.ActionResponse;
import com.google.actions.api.DialogflowApp;
import com.google.actions.api.ForIntent;
import com.google.actions.api.response.ResponseBuilder;
import com.google.actions.api.response.helperintent.SelectionCarousel;
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

public class O2O_internApp extends DialogflowApp {

	@ForIntent("Default Welcome Intent")
	public ActionResponse defaultWelcome(ActionRequest request) throws ExecutionException, InterruptedException {
		ResponseBuilder rb = getResponseBuilder(request);
		List<String> suggestions = new ArrayList<String>();
		SimpleResponse simpleResponse = new SimpleResponse();
		BasicCard basicCard = new BasicCard();

		Map<String, Object> data = rb.getConversationData();


		data.clear();
		CommonUtil.printMapData(data);

		simpleResponse.setTextToSpeech("안녕하세요, 테스트앱sad입니다.")
				.setDisplayText("안녕하세요, 테스트앱입ads니다.")
		;
		basicCard
				.setFormattedText("안녕하세요, 테스트앱입니다.")
				.setImage(new Image().setUrl("https://actions.o2o.kr/content/telechips/telechipsaiperson_ko.gif")
						.setAccessibilityText("home"));

		rb.add(simpleResponse);
		rb.add(basicCard);

		rb.addSuggestions(suggestions.toArray(new String[suggestions.size()]));
		return rb.build();
	}
	@ForIntent("O2O_greeting")
	public ActionResponse browseCarousel(ActionRequest request) {
			ResponseBuilder rb = getResponseBuilder(request);
			List<String> suggestions = new ArrayList<String>();
		SimpleResponse simpleResponse = new SimpleResponse();
		BasicCard basicCard = new BasicCard();

		Map<String, Object> data = rb.getConversationData();
		data.clear();
		CommonUtil.printMapData(data);

		simpleResponse.setTextToSpeech("주식회사 오투오는 ai를 기반으로 한 음성인식 응용 디바이스 및 서비스를 제공하는 회사야! " +
				"오투오에서 만드는 서비스는 google assistant와 빅데이터를 기반으로 하기 때문에 사용자에 따라 최상의 답변을 제공할 수 있어! " +
				"주요 서비스로는 대화형 관광안내, 행정정보 등이 있어. 궁금하면 유투브에 ai o2o를 검색하면 오투오에서 만든 다양한 aog를 볼 수 있어!")
				.setDisplayText("주식회사 오투오는 ai를 기반으로 한 음성인식 응용 디바이스 및 서비스를 제공하는 회사야! " +
						"오투오에서 만드는 서비스는 google assistant와 빅데이터를 기반으로 하기 때문에 사용자에 따라 최상의 답변을 제공할 수 있어! " +
						"주요 서비스로는 대화형 관광안내, 행정정보 등이 있어. 궁금하면 유투브에 ai o2o를 검색하면 오투오에서 만든 다양한 aog를 볼 수 있어!");
		basicCard
				.setFormattedText("안녕하세요, 오투오의 오뚜에요!")
				.setImage(new Image().setUrl("https://actions.o2o.kr/content/telechips/telechipsaiperson_ko.gif")
						.setAccessibilityText("home"));
		rb.add(
				"<speak>"
						+ "<audio src=\"https://actions.google.com/sounds/v1/animals/buzzing_fly.ogg\"></audio>"
						+ "<audio src=\"https://actions.google.com/sounds/v1/animals/buzzing_fly.ogg\"></audio>"
						+ "<audio src=\"https://actions.google.com/sounds/v1/animals/buzzing_fly.ogg\"></audio>"
						+ "<audio src=\"https://actions.google.com/sounds/v1/animals/buzzing_fly.ogg\"></audio>"
						+ "</speak>");
		rb.add(simpleResponse);

		rb.addSuggestions(suggestions.toArray(new String[suggestions.size()]));
		return rb.build();

	}

	@ForIntent("Carousel-OPTION")
	public ActionResponse carouselSelected(ActionRequest request) {
		ResponseBuilder responseBuilder = getResponseBuilder(request);
		String selectedItem = request.getSelectedOption();
		String response;

		if (selectedItem.equals("SELECTION_KEY_ONE")) {
			response = "You selected the first item";
		} else if (selectedItem.equals("SELECTION_KEY_GOOGLE_HOME")) {
			response = "You selected the Google Home!";
		} else if (selectedItem.equals("SELECTION_KEY_GOOGLE_PIXEL")) {
			response = "You selected the Google Pixel!";
		} else {
			response = "You did not select a valid item";
		}
		return responseBuilder.add(response).add("Which response would you like to see next?").build();
	}

}

