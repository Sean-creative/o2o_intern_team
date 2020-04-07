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


	@ForIntent("O2O_greeting")
	public ActionResponse O2O_greeting(ActionRequest request) throws ExecutionException, InterruptedException {
		ResponseBuilder rb = getResponseBuilder(request);
		SimpleResponse simpleResponse = new SimpleResponse();

		Map<String, Object> data = rb.getConversationData();

		data.clear();
		CommonUtil.printMapData(data);

		simpleResponse
				.setTextToSpeech("<speak>"
						+ "<audio src=\"https://firebasestorage.googleapis.com/v0/b/o2o-intern-nfumup.appspot.com/o/dubbing%2Fo2o_greeting1.mp3?alt=media&amp;token=917baaee-d8d9-4459-9d25-378100ea5c6a\"></audio>"
						+ "<audio src=\"https://firebasestorage.googleapis.com/v0/b/o2o-intern-nfumup.appspot.com/o/dubbing%2Fo2o_greeting2.mp3?alt=media&amp;token=7e270873-f6d7-4f1d-bb66-0b6aaf396f9e\"></audio>"
						+ "<audio src=\"https://firebasestorage.googleapis.com/v0/b/o2o-intern-nfumup.appspot.com/o/dubbing%2Fo2o_greeting3.mp3?alt=media&amp;token=ad3401a0-b5cd-4143-8ab8-9f03ee915ba3\"></audio>"
						+ "<audio src=\"https://firebasestorage.googleapis.com/v0/b/o2o-intern-nfumup.appspot.com/o/dubbing%2Fo2o_greeting4.mp3?alt=media&amp;token=99316fa1-33b7-4c40-a92d-78060779bf4d\"></audio>"
						+ "</speak>")
				.setDisplayText("오투오의 인삿말입니다!");


		data.put("command", "GREETING");
			return rb.add(simpleResponse).add(new HtmlResponse().setUpdatedState(data)).build();
		}


	@ForIntent("O2O_aog")
	public ActionResponse O2O_aog(ActionRequest request) throws ExecutionException, InterruptedException {
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
		data.put("SO", "SO SAD");
		return rb.add(simpleResponse).add(new HtmlResponse().setUpdatedState(data)).build();
	}


	@ForIntent("O2O_info")
	public ActionResponse O2O_info(ActionRequest request) throws ExecutionException, InterruptedException {
		ResponseBuilder rb = getResponseBuilder(request);
		SimpleResponse simpleResponse = new SimpleResponse();

		Map<String, Object> data = rb.getConversationData();

		data.clear();
		CommonUtil.printMapData(data);

		data.put("command", "INFO");
		data.put("SO", "SO SAD");
		return rb.add(new SimpleResponse().setTextToSpeech("INFO입니다")).add(new HtmlResponse().setUpdatedState(data)).build();

	}

}



