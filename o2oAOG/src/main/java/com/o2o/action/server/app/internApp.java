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
// 선우 수정 20/03/19
// 혜원 수정 20/03/19
public class internApp extends DialogflowApp {

	List<String> suggestions = new ArrayList<String>();

	BasicCard createCard(String input) {
		BasicCard basicCard = new BasicCard();

		if(input.equals("Address")) {
			basicCard
					.setTitle("주소")
					//.setSubtitle(WebtoonData[1][n])
					.setFormattedText("서울특별시 서초구 매헌로8길 47,  \n" +
							"양재AI허브(희경빌딩 B동) 203호")
					.setImage(
							new Image()
									.setUrl("https://firebasestorage.googleapis.com/v0/b/o2o-intern-nfumup.appspot.com/o/map.jpg?alt=media&token=8c92ec69-c6d8-4d70-af6f-05ee218dd7f7")
									.setAccessibilityText("주소 이미지"))
					.setButtons(
							new ArrayList<Button>(
									Arrays.asList(
											new Button()
													.setTitle("네이버 지도로 보기")
													.setOpenUrlAction(
															new OpenUrlAction().setUrl("https://map.naver.com/v5/search/%EC%84%9C%EC%9A%B8%ED%8A%B9%EB%B3%84%EC%8B%9C%20%EC%84%9C%EC%B4%88%EA%B5%AC%20%EB%A7%A4%ED%97%8C%EB%A1%9C8%EA%B8%B8%2047/address/14141588.565368045,4504265.872974722,%EC%84%9C%EC%9A%B8%ED%8A%B9%EB%B3%84%EC%8B%9C%20%EC%84%9C%EC%B4%88%EA%B5%AC%20%EB%A7%A4%ED%97%8C%EB%A1%9C8%EA%B8%B8%2047,new?c=14141472.1183328,4504265.8729747,17,0,0,0,dh")))));
															//new OpenUrlAction().setUrl("https://www.google.com/maps/place/%EC%84%9C%EC%9A%B8%ED%8A%B9%EB%B3%84%EC%8B%9C+%EC%84%9C%EC%B4%88%EA%B5%AC+%EC%96%91%EC%9E%AC2%EB%8F%99+%EB%A7%A4%ED%97%8C%EB%A1%9C8%EA%B8%B8+47/@37.465949,127.0338064,17z/data=!3m1!4b1!4m5!3m4!1s0x357ca12beb539099:0xab846532cf5fbbd5!8m2!3d37.465949!4d127.0359951")))));
		}
		else if(input.equals("Prize")) {
			basicCard
					.setTitle("수상내역")
					.setFormattedText("2020.01.17. 관광편의 시설업 지정  \n" +// ( 26116 2020 000001호)
							"2018. 10.10. 특허청장 수상  \n" +// ( 2018 강원창의 아이디어 공모전, 대표이사외 3)
							"2018. 07.12. 벤처기업 인증  \n" +
							"2018. 04.19. 기업부설연구소 설립 ( 경기도 성남시)  \n" +
							"2018. 04.10. 무역업 등록 ( 고유번호 30952179)  \n" +
							"2017. 10.21. 자본금 증자 (300백만원)  \n" +
							"2017. 08.16. (주)오투오 본사 및 오투오 경기지사 설립")//(주)오투오 본사 (춘천시) 및 오투오 경기지사 (경기도 성남시 ) 설립 / 자본금 20백만원
					.setImage(
							new Image()
									.setUrl("https://firebasestorage.googleapis.com/v0/b/o2o-intern-nfumup.appspot.com/o/Awards.png?alt=media&token=cf252b00-e599-4372-b079-ea80fb028059")
									.setAccessibilityText("수상 이미지"))
			;
		}
		else if(input.equals("Established")) {
			basicCard
					.setTitle("설립일")
					.setFormattedText("2017년 8월 16일")
					.setImage(
							new Image()
									.setUrl("https://firebasestorage.googleapis.com/v0/b/o2o-intern-nfumup.appspot.com/o/%EC%84%A4%EB%A6%BD%EC%9D%BC.jpg?alt=media&token=96f10ce9-b06f-434a-bbed-e6bf50e04f00")
									.setAccessibilityText("설립일 이미지"));
		}
		else if(input.equals("Homepage")) {
			basicCard
					.setTitle("홈페이지")
					.setFormattedText("http://www.o2o.kr")
					.setImage(
							new Image()
									.setUrl("https://firebasestorage.googleapis.com/v0/b/o2o-intern-nfumup.appspot.com/o/homepage.jpg?alt=media&token=8ebf351e-248a-4eb1-84cf-7ca692f165a5")
									.setAccessibilityText("홈페이지 이미지"))
					.setButtons(
							new ArrayList<Button>(
									Arrays.asList(
											new Button()
													.setTitle("홈페이지 바로가기")
													.setOpenUrlAction(
															new OpenUrlAction().setUrl("http://www.o2o.kr"))

									)));
		}
		else if(input.equals("Contact")) {
			basicCard
					.setTitle("연락처")
					.setFormattedText("\uD83D\uDCE7 : info@o2o.kr  \n" +
							"☎ : 070-4260-8310") //
					.setImage(
							new Image()
									.setUrl("https://firebasestorage.googleapis.com/v0/b/o2o-intern-nfumup.appspot.com/o/contact.jpg?alt=media&token=ae582d8a-a5f1-4eac-bd73-5195d3bb854f")
									.setAccessibilityText("연락처 이미지"))
					.setButtons(
					new ArrayList<Button>(
							Arrays.asList(
									//new Button()
									//		.setTitle("전화걸기")
									//		.setOpenUrlAction(
									//				new OpenUrlAction().setUrl("tel:+82-70-4260-8310"))
									//,new Button()
									//		.setTitle("Email 보내기")
									//		.setOpenUrlAction(
									//				new OpenUrlAction().setUrl("mailto:info@o2o.kr"))

							)));
		}

		return basicCard;
	}

	void setDefaultSuggestions() {
		suggestions = new ArrayList<String>();

		suggestions.add("인사말");
		suggestions.add("기본정보");
		suggestions.add("오투오의AOG");
	}

	@ForIntent("Default Welcome Intent")
	public ActionResponse defaultWelcome(ActionRequest request) throws ExecutionException, InterruptedException {
		ResponseBuilder rb = getResponseBuilder(request);
		SimpleResponse simpleResponse = new SimpleResponse();
		BasicCard basicCard = new BasicCard();

		Map<String, Object> data = rb.getConversationData();

		data.clear();
		CommonUtil.printMapData(data);

		simpleResponse
				.setDisplayText("나는 오투오의 귀염둥이 오뚜야!  \n" +
						"주식회사 오투오는 처음이지?  \n" +
						"궁금한게 있으면 편하게 물어봐줘!  \n" +
						"입력되지 않은 오투오의 정보는 곧 업데이트 될 예정이야!")
				.setTextToSpeech("<speak>"
						+ "<audio src=\"https://firebasestorage.googleapis.com/v0/b/o2o-intern-nfumup.appspot.com/o/dubbing%2Fwelcome_default_intent.mp3?alt=media&amp;token=a1b413ad-6bb3-4fa0-8061-d089c16c9765\"></audio>"
						+ "</speak>");

		basicCard
				.setFormattedText("안녕하세요! 주식회사 오투오 입니다.  \n" +
						"궁금하신점에 대해 마음껏 물어봐주세요!")
				.setImage(new Image().setUrl("https://firebasestorage.googleapis.com/v0/b/o2o-intern-nfumup.appspot.com/o/logo.jpg?alt=media&token=5ba71cb0-2de8-4b0a-a8b5-aa95ff90cbb6")
						.setAccessibilityText("O2O"));

		setDefaultSuggestions();

		rb.addSuggestions(suggestions.toArray(new String[suggestions.size()]));
		rb.add(simpleResponse);
		rb.add(basicCard);

		return rb.build();
	}


	@ForIntent("O2O_info")
	public ActionResponse o2o_info(ActionRequest request) throws ExecutionException, InterruptedException {
		ResponseBuilder rb = getResponseBuilder(request);

		SimpleResponse simpleResponse = new SimpleResponse();
		SelectionList selectionList = new SelectionList();
		BasicCard basicCard = new BasicCard();

		Map<String, Object> data = rb.getConversationData();
		data.clear();
		CommonUtil.printMapData(data);

		String input = CommonUtil.makeSafeString(request.getParameter("Information"));
		//String input = CommonUtil.makeSafeString(request.getRawText());
		//simpleResponse.setTextToSpeech(input).setDisplayText(input);
		//rb.add(simpleResponse);


		if(!CommonUtil.isEmptyString(input) && input.equals("Informations")) {
			simpleResponse
					.setTextToSpeech("<speak>"
							+ "<audio src=\"https://firebasestorage.googleapis.com/v0/b/o2o-intern-nfumup.appspot.com/o/dubbing%2Fo2o_info.mp3?alt=media&amp;token=8ae3c1e8-1392-40c9-9c18-5e8781f3cd72\"></audio>"
							+ "</speak>")
					.setDisplayText("우리 회사의 기본정보 목록이야!  \n"
							+ "궁금한게 있으면 골라봐!");

			selectionList = new SelectionList()
					.setTitle("기본정보")
					.setItems(
							Arrays.asList(
									new ListSelectListItem()
											.setTitle("주소")
											.setOptionInfo(
													new OptionInfo()
															.setKey("Address")),
									new ListSelectListItem()
											.setTitle("홈페이지")
											.setOptionInfo(
													new OptionInfo()
															.setKey("Homepage")),
									new ListSelectListItem()
											.setTitle("연락처")
											.setOptionInfo(
													new OptionInfo()
															.setKey("Contact")),
									new ListSelectListItem()
											.setTitle("설립일")
											.setOptionInfo(
													new OptionInfo()
															.setKey("Established")),

									new ListSelectListItem()
											.setTitle("회사연혁 및 수상이력")
											.setOptionInfo(
													new OptionInfo()
															.setKey("History"))

							));

			rb.add(simpleResponse);
			rb.add(selectionList);
			//rb.add(basicCard);
		}
		else if(!CommonUtil.isEmptyString(input) && input.equals("Address") || input.equals("Homepage") || input.equals("Contact") || input.equals("Established") || input.equals("Prize")) {
			if(input.equals("Address")) {
				simpleResponse
						.setTextToSpeech("<speak>"
								+ "<audio src=\"https://firebasestorage.googleapis.com/v0/b/o2o-intern-nfumup.appspot.com/o/dubbing%2F02_%EC%9A%B0%EB%A6%AC_%ED%9A%8C%EC%82%AC_%EC%A3%BC%EC%86%8C%EB%8A%94_%EC%84%9C%EC%9A%B8%ED%8A%B9%EB%B3%84%EC%8B%9C_%EC%84%9C%EC%B4%88%EA%B5%AC_%EB%A7%A4%ED%97%8C%EB%A1%9C8%EA%B8%B8_47_%EC%96%91%EC%9E%AC_%EC%97%90%EC%9D%B4%EC%95%84%EC%9D%B4%ED%97%88%EB%B8%8C_%ED%9D%AC%EA%B2%BD%EB%B9%8C%EB%94%A9_B%EB%8F%99_2.mp3?alt=media&token=ba0f84ed-ecef-44b8-93dc-ffe3fcd5ce0a\"></audio>"
								+ "</speak>")
						.setDisplayText("우리 회사 주소는  \n" +
								"서울특별시 서초구 매헌로 8길 47번지,  \n" +
								"양재 AI 허브 희경빌딩 B동 203호야!");

			}
			else if(input.equals("Homepage")) {
				simpleResponse
						.setTextToSpeech("<speak>"
						+ "<audio src=\"https://firebasestorage.googleapis.com/v0/b/o2o-intern-nfumup.appspot.com/o/dubbing%2F03_%EC%9A%B0%EB%A6%AC_%ED%9A%8C%EC%82%AC%EC%9D%98_%ED%99%88%ED%8E%98%EC%9D%B4%EC%A7%80%EC%95%BC.mp3?alt=media&amp;token=e2f53074-1977-476c-ba34-a331e768a4b1\"></audio>"
						+ "</speak>")
						.setDisplayText("우리 회사의 홈페이지야!");

			}
			else if(input.equals("Contact")) {
				simpleResponse
				 .setTextToSpeech("<speak>"
						+ "<audio src=\"https://firebasestorage.googleapis.com/v0/b/o2o-intern-nfumup.appspot.com/o/dubbing%2F04_%EC%9A%B0%EB%A6%AC_%ED%9A%8C%EC%82%AC%EC%9D%98_%EC%97%B0%EB%9D%BD%EC%B2%98%EC%95%BC.mp3?alt=media&amp;token=ee67b529-7500-463a-91be-e5f75d1a0532\"></audio>"
						+ "</speak>")
						.setDisplayText("우리 회사의 연락처야!");

			}
			else if(input.equals("Established")) {
				simpleResponse
				 .setTextToSpeech("<speak>"
						+ "<audio src=\"https://firebasestorage.googleapis.com/v0/b/o2o-intern-nfumup.appspot.com/o/dubbing%2F05_%EC%9A%B0%EB%A6%AC_%ED%9A%8C%EC%82%AC%EC%9D%98_%EC%84%A4%EB%A6%BD%EC%9D%BC%EC%9D%80_2017%EB%85%84_8%EC%9B%94_16%EC%9D%BC%EC%9D%B4%EC%95%BC.mp3?alt=media&amp;token=ef47d3b3-b4ef-4290-87aa-eec561037137\"></audio>"
						+ "</speak>")
						.setDisplayText("우리 회사의 설립일은  \n" +
								"2017년 8월 16일이야!");

			}
			else if(input.equals("History")) {
				simpleResponse
				  .setTextToSpeech("<speak>"
						+ "<audio src=\"https://firebasestorage.googleapis.com/v0/b/o2o-intern-nfumup.appspot.com/o/dubbing%2F06_%EC%9A%B0%EB%A6%AC_%ED%9A%8C%EC%82%AC%EC%9D%98_%EC%97%B0%ED%98%81%EA%B3%BC_%EC%88%98%EC%83%81%EC%9D%B4%EB%A0%A5%EC%9D%B4%EC%95%BC.mp3?alt=media&amp;token=6871b8fc-ba5f-4643-ac5e-26e4659834bd\"></audio>"
						+ "</speak>")
						.setDisplayText("우리 회사의 연혁과 수상이력이야!");
			}

			basicCard = createCard(input);

			rb.add(simpleResponse);
			//rb.add(selectionList);
			rb.add(basicCard);
		}

		// 주소가 궁금하구나
		// fallback 보류  --- 궁금쓰
		setDefaultSuggestions();

		rb.addSuggestions(suggestions.toArray(new String[suggestions.size()]));
		return rb.build();
	}

	@ForIntent("O2O_info - OPTION")
	public ActionResponse o2o_info_option(ActionRequest request) throws ExecutionException, InterruptedException {
		ResponseBuilder rb = getResponseBuilder(request);
		//List<String> suggestions = new ArrayList<String>();
		SimpleResponse simpleResponse = new SimpleResponse();
		BasicCard basicCard = new BasicCard();

		Map<String, Object> data = rb.getConversationData();
		data.clear();
		CommonUtil.printMapData(data);

		//String input = CommonUtil.makeSafeString(request.getParameter("Information"));
		String input = CommonUtil.makeSafeString(request.getRawText());
		//simpleResponse.setTextToSpeech("option - " + input).setDisplayText("option - " + input);
		//rb.add(simpleResponse);


		//if (!CommonUtil.isEmptyString(input) && input.equals("Address") || input.equals("Homepage") || input.equals("Contact") || input.equals("Established") || input.equals("Prize")) {
		if (!CommonUtil.isEmptyString(input) && input.contains("주소") || input.contains("홈페이지") || input.contains("연락처") || input.contains("설립일") || input.contains("연혁") || input.contains("수상")) {
			if (input.contains("주소")) {//한글 영어로 고쳐야함 - 제현
				simpleResponse
						.setTextToSpeech("<speak>"
								+ "<audio src=\"https://firebasestorage.googleapis.com/v0/b/o2o-intern-nfumup.appspot.com/o/dubbing%2F02_%EC%9A%B0%EB%A6%AC_%ED%9A%8C%EC%82%AC_%EC%A3%BC%EC%86%8C%EB%8A%94_%EC%84%9C%EC%9A%B8%ED%8A%B9%EB%B3%84%EC%8B%9C_%EC%84%9C%EC%B4%88%EA%B5%AC_%EB%A7%A4%ED%97%8C%EB%A1%9C8%EA%B8%B8_47_%EC%96%91%EC%9E%AC_%EC%97%90%EC%9D%B4%EC%95%84%EC%9D%B4%ED%97%88%EB%B8%8C_%ED%9D%AC%EA%B2%BD%EB%B9%8C%EB%94%A9_B%EB%8F%99_2.mp3?alt=media&amp;token=ba0f84ed-ecef-44b8-93dc-ffe3fcd5ce0a\"></audio>"
								+ "</speak>")
						.setDisplayText("우리 회사 주소는  \n" +
								"서울특별시 서초구 매헌로 8길 47번지,  \n" +
								"양재 AI허브 희경빌딩 B동 203호야!");

				basicCard = createCard("Address");
			} else if (input.contains("홈페이지")) {
				simpleResponse
				.setTextToSpeech("<speak>"
						+ "<audio src=\"https://firebasestorage.googleapis.com/v0/b/o2o-intern-nfumup.appspot.com/o/dubbing%2F03_%EC%9A%B0%EB%A6%AC_%ED%9A%8C%EC%82%AC%EC%9D%98_%ED%99%88%ED%8E%98%EC%9D%B4%EC%A7%80%EC%95%BC.mp3?alt=media&amp;token=e2f53074-1977-476c-ba34-a331e768a4b1\"></audio>"
						+ "</speak>")
						.setDisplayText("우리 회사의 홈페이지야!");

				basicCard = createCard("Homepage");
			} else if (input.contains("연락처")) {
				simpleResponse
				 .setTextToSpeech("<speak>"
						+ "<audio src=\"https://firebasestorage.googleapis.com/v0/b/o2o-intern-nfumup.appspot.com/o/dubbing%2F04_%EC%9A%B0%EB%A6%AC_%ED%9A%8C%EC%82%AC%EC%9D%98_%EC%97%B0%EB%9D%BD%EC%B2%98%EC%95%BC.mp3?alt=media&amp;token=ee67b529-7500-463a-91be-e5f75d1a0532\"></audio>"
						+ "</speak>")
						.setDisplayText("우리 회사의 연락처야!");

				basicCard = createCard("Contact");
			} else if (input.contains("설립일")) {
				simpleResponse
				 .setTextToSpeech("<speak>"
						+ "<audio src=\"https://firebasestorage.googleapis.com/v0/b/o2o-intern-nfumup.appspot.com/o/dubbing%2F05_%EC%9A%B0%EB%A6%AC_%ED%9A%8C%EC%82%AC%EC%9D%98_%EC%84%A4%EB%A6%BD%EC%9D%BC%EC%9D%80_2017%EB%85%84_8%EC%9B%94_16%EC%9D%BC%EC%9D%B4%EC%95%BC.mp3?alt=media&amp;token=ef47d3b3-b4ef-4290-87aa-eec561037137\"></audio>"
						+ "</speak>")
						.setDisplayText("우리 회사의 설립일은  \n" +
								"2017년 8월 16일이야!");

				basicCard = createCard("Established");
			} else if (input.contains("연혁") || input.contains("수상")) {
				simpleResponse
				  .setTextToSpeech("<speak>"
						+ "<audio src=\"https://firebasestorage.googleapis.com/v0/b/o2o-intern-nfumup.appspot.com/o/dubbing%2F06_%EC%9A%B0%EB%A6%AC_%ED%9A%8C%EC%82%AC%EC%9D%98_%EC%97%B0%ED%98%81%EA%B3%BC_%EC%88%98%EC%83%81%EC%9D%B4%EB%A0%A5%EC%9D%B4%EC%95%BC.mp3?alt=media&amp;token=6871b8fc-ba5f-4643-ac5e-26e4659834bd\"></audio>"
						+ "</speak>")
						.setDisplayText("우리 회사의 연혁과 수상이력이야!");
				basicCard = createCard("Prize");
			}


		}

		// 주소가 궁금하구나
		// fallback 보류  --- 궁금쓰
		rb.add(simpleResponse);
		rb.add(basicCard);

		setDefaultSuggestions();

		rb.addSuggestions(suggestions.toArray(new String[suggestions.size()]));
		return rb.build();
	}
	@ForIntent("O2O_aog")
	public ActionResponse browseCarousel(ActionRequest request) {
		ResponseBuilder responseBuilder = getResponseBuilder(request);
		SimpleResponse simpleResponse = new SimpleResponse();
		if (!request.hasCapability(Capability.SCREEN_OUTPUT.getValue())
				|| !request.hasCapability(Capability.WEB_BROWSER.getValue())) {
			return responseBuilder
					.add("Sorry, try this on a phone or select the phone surface in the simulator.")
					.add("Which response would you like to see next?")
					.build();
		}

		simpleResponse
				.setTextToSpeech("<speak>"
						+ "<audio src=\"https://firebasestorage.googleapis.com/v0/b/o2o-intern-nfumup.appspot.com/o/dubbing%2Fo2o_aog.mp3?alt=media&amp;token=47455549-6a8c-4d49-a103-b64aa32f9843\"></audio>"
						+ "</speak>")
				.setDisplayText("우리가 만든 AOG는 이런게 있어.  \n" +
						"궁금하지? 관심있는 AOG를 눌러봐!");
		responseBuilder.add(simpleResponse);
		responseBuilder
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
																.setTitle("국민연금 서비스")
																.setDescription(" ")
																.setOpenUrlAction(new OpenUrlAction().setUrl("https://www.youtube.com/watch?v=aeZ8t4gvH8w&t=1s"))
																.setImage(
																		new Image()
																				.setUrl(
																						"https://firebasestorage.googleapis.com/v0/b/o2o-intern-nfumup.appspot.com/o/AOG%20%EC%86%8C%EA%B0%9C%20%EC%82%AC%EC%A7%84%ED%8C%8C%EC%9D%BC%2F%EA%B5%AD%EB%AF%BC%EC%97%B0%EA%B8%88%20%EC%84%9C%EB%B9%84%EC%8A%A4%20AOG.png?alt=media&token=7dd62fd5-ca98-4783-8d97-6bf8316c3235")
																				.setAccessibilityText("Image alternate text"))
																.setFooter("(주)오투오"),
														new CarouselBrowseItem()
																.setTitle("제사키 징글")
																.setDescription(" ")
																.setOpenUrlAction(new OpenUrlAction().setUrl("https://www.youtube.com/watch?v=R5parcsNLSw"))
																.setImage(
																		new Image()
																				.setUrl(
																						"https://firebasestorage.googleapis.com/v0/b/o2o-intern-nfumup.appspot.com/o/AOG%20%EC%86%8C%EA%B0%9C%20%EC%82%AC%EC%A7%84%ED%8C%8C%EC%9D%BC%2F%EC%A0%9C%EC%82%AC%ED%82%A4%20%EC%A7%95%EA%B8%80%20AOG.png?alt=media&token=4f48cad6-8fd6-4331-86b7-06dfa0a9c1c0")
																				.setAccessibilityText("Image alternate text"))
																.setFooter("(주)오투오"),
														new CarouselBrowseItem()
																.setTitle("이명수")
																.setDescription(" ")
																.setOpenUrlAction(new OpenUrlAction().setUrl("https://www.youtube.com/watch?v=SVAMAgwO_gE"))
																.setImage(
																		new Image()
																				.setUrl(
																						"https://firebasestorage.googleapis.com/v0/b/o2o-intern-nfumup.appspot.com/o/AOG%20%EC%86%8C%EA%B0%9C%20%EC%82%AC%EC%A7%84%ED%8C%8C%EC%9D%BC%2F%EC%9D%B4%EB%AA%85%EC%88%98%20AOG.png?alt=media&token=7c335599-df44-4fab-8563-ba8b741a65a4")
																				.setAccessibilityText("Image alternate text"))
																.setFooter("(주)오투오"),
														new CarouselBrowseItem()
																.setTitle("도담도담")
																.setDescription(" ")
																.setOpenUrlAction(new OpenUrlAction().setUrl("https://www.youtube.com/watch?v=DDUucnlfW6o&t=28s"))
																.setImage(
																		new Image()
																				.setUrl(
																						"https://firebasestorage.googleapis.com/v0/b/o2o-intern-nfumup.appspot.com/o/AOG%20%EC%86%8C%EA%B0%9C%20%EC%82%AC%EC%A7%84%ED%8C%8C%EC%9D%BC%2F%EB%8F%84%EB%8B%B4%EB%8F%84%EB%8B%B4.png?alt=media&token=17729373-9375-4c47-bc77-e3ade8d10e7a")
																				.setAccessibilityText("Image alternate text"))
																.setFooter("(주)오투오"),
														new CarouselBrowseItem()
																.setTitle("강한희망용기데모")
																.setDescription(" ")
																.setOpenUrlAction(new OpenUrlAction().setUrl("https://www.youtube.com/watch?v=a8rKQ2b3cMc"))
																.setImage(
																		new Image()
																				.setUrl(
																						"https://firebasestorage.googleapis.com/v0/b/o2o-intern-nfumup.appspot.com/o/AOG%20%EC%86%8C%EA%B0%9C%20%EC%82%AC%EC%A7%84%ED%8C%8C%EC%9D%BC%2F%EA%B0%95%ED%95%9C%ED%9D%AC%EB%A7%9D%EC%9A%A9%EA%B8%B0%EB%8D%B0%EB%AA%A8.png?alt=media&token=d8a40a59-ead0-4b98-8544-3d8c3aef63cb")
																				.setAccessibilityText("Image alternate text"))
																.setFooter("(주)오투오"),
														new CarouselBrowseItem()
																.setTitle("skylife")
																.setDescription(" ")
																.setOpenUrlAction(new OpenUrlAction().setUrl("https://www.youtube.com/watch?v=mEew7cm5I1I&t=37s"))
																.setImage(
																		new Image()
																				.setUrl(
																						"https://firebasestorage.googleapis.com/v0/b/o2o-intern-nfumup.appspot.com/o/AOG%20%EC%86%8C%EA%B0%9C%20%EC%82%AC%EC%A7%84%ED%8C%8C%EC%9D%BC%2Fskylife%20AOG.png?alt=media&token=64c2cb9e-082f-49f3-a69e-3cc600c923fd")
																				.setAccessibilityText("Image alternate text"))
																.setFooter("(주)오투오"),
														new CarouselBrowseItem()
																.setTitle("Telechips Eng")
																.setDescription(" ")
																.setOpenUrlAction(new OpenUrlAction().setUrl("https://www.youtube.com/watch?v=HyqA4SzFbls"))
																.setImage(
																		new Image()
																				.setUrl(
																						"https://firebasestorage.googleapis.com/v0/b/o2o-intern-nfumup.appspot.com/o/AOG%20%EC%86%8C%EA%B0%9C%20%EC%82%AC%EC%A7%84%ED%8C%8C%EC%9D%BC%2FTelechips%20Eng%20AOG.png?alt=media&token=30f761f8-fb88-477f-97be-5a4a2e361407")
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

		setDefaultSuggestions();
		responseBuilder.addSuggestions(suggestions.toArray(new String[suggestions.size()]));
		return responseBuilder.build();
	}

		@ForIntent("O2O_greeting")  // 대표님 GIF + 음성 따서 해도 재밌을듯
		public ActionResponse greeting(ActionRequest request) {
			ResponseBuilder rb = getResponseBuilder(request);
			//List<String> suggestions = new ArrayList<String>();
			SimpleResponse simpleResponse = new SimpleResponse();
			BasicCard basicCard = new BasicCard();

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

			basicCard
					.setFormattedText("주식회사 오투오는 AI를 기반으로 한 음성인식 응용 디바이스 및 서비스를 제공하는 회사입니다.  \n" +
							"오투오에서 만드는 서비스는 Google Assistant와 빅데이터를 기반으로 하기 때문에 사용자에 따라 최상의 답변을 제공할 수 있습니다.  \n" +
							"주요 서비스로는 대화형 관광안내, 행정정보 등이 있습니다.  \n" +
							"궁금하시다면 아래의 홈페이지 링크를 클릭해보세요.")
					//.setImage(new Image().setUrl("https://actions.o2o.kr/content/telechips/telechipsaiperson_ko.gif")
					.setImage(new Image().setUrl("https://firebasestorage.googleapis.com/v0/b/o2o-intern-nfumup.appspot.com/o/CEO.png?alt=media&token=1cdf8c9d-d9a8-4a92-a2b1-b928c11574ab")
					.setAccessibilityText("오뚜"))
					.setButtons(
							new ArrayList<Button>(
									Arrays.asList(
											new Button()
													.setTitle("홈페이지 바로가기")
													.setOpenUrlAction(
															new OpenUrlAction().setUrl("https://o2o.kr")
													)
									)
							)
					);

			rb.add(simpleResponse);
			rb.add(basicCard);

			setDefaultSuggestions();

			rb.addSuggestions(suggestions.toArray(new String[suggestions.size()]));
			return rb.build();
		}
	}
