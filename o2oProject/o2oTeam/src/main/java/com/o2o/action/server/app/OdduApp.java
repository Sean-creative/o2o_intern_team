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

		data.put("command", "INFO");
		return rb.add(new SimpleResponse().setTextToSpeech("INFO입니다")).add(new HtmlResponse().setUpdatedState(data)).build();

	}





	@ForIntent("INFOTEL")
	public ActionResponse INFO_TEL(ActionRequest request) throws ExecutionException, InterruptedException {
		ResponseBuilder rb = getResponseBuilder(request);
		SimpleResponse simpleResponse = new SimpleResponse();

		Map<String, Object> data = rb.getConversationData();

		data.clear();
		CommonUtil.printMapData(data);

		data.put("command", "INFOTEL");
		return rb.add(new SimpleResponse().setTextToSpeech("INFOTEL입니다")).add(new HtmlResponse().setUpdatedState(data)).build();


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

		return rb.add(new SimpleResponse().setTextToSpeech("Fallback 입니다")).add(new HtmlResponse().setUpdatedState(data)).build();
	}
}



