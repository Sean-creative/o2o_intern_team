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

	BasicCard createCard(String input) {
		BasicCard basicCard = new BasicCard();


		if(input.equals("Address")) {
			basicCard
					.setTitle("주소")
					//.setSubtitle(WebtoonData[1][n])
					.setFormattedText("서울특별시 서초구 매헌로8길 47, 양재AI허브(희경빌딩 B동) 202호");
					//.setImage(
					//		new Image()
					//				.setUrl(WebtoonData[3][n])
					//				.setAccessibilityText(WebtoonData[0][n] + " 이미지"))
					//.setButtons(
					//		new ArrayList<Button>(
					//				Arrays.asList(
					//						new Button()
					//								.setTitle(WebtoonData[0][n] + " 보기")
					//								.setOpenUrlAction(
					//										new OpenUrlAction().setUrl(WebtoonData[4][n])))));
		}
		else if(input.equals("Prize")) {
			basicCard
					.setTitle("수상내역")
					.setFormattedText("2020. 01. 17 관광편의 시설업 지정 ( 26116 2020 000001호)\n" +
							"2018. 10. 10 특허청장 수상 ( 2018 강원창의 아이디어 공모전, 대표이사외 3)\n" +
							"2018. 07. 12 벤처기업 인증\n" +
							"2018. 04. 19 기업부설연구소 설립 ( 경기도 성남시)\n" +
							"2018. 04. 10 무역업 등록 ( 고유번호 30952179)\n" +
							"2017. 10. 21 자본금 증자 (300백만원)\n" +
							"2017. 08. 16 (주)오투오 본사 (춘천시) 및 오투오 경기지사 (경기도 성남시 ) 설립 / 자본금 20백만원\n");
		}
		else if(input.equals("Established")) {
			basicCard
					.setTitle("설립일")
					.setFormattedText("2017년 8월 16일");
		}
		else if(input.equals("Homepage")) {
			basicCard
					.setTitle("홈페이지")
					.setFormattedText("http://www.o2o.kr")
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
					.setFormattedText("Email : info@o2o.kr\n" +
							"Tel : +82 70 4260 8310\n")
					.setButtons(
							new ArrayList<Button>(
									Arrays.asList(
											new Button()
													.setTitle("전화걸기")
													.setOpenUrlAction(
															new OpenUrlAction().setUrl("tel:+82-70-4260-8310")),
											new Button()
													.setTitle("Email 보내기")
													.setOpenUrlAction(
															new OpenUrlAction().setUrl("mailto:info@o2o.kr"))

									)));
		}

		return basicCard;
	}

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
				.setFormattedText("주식회사 오투오 알리미 오뚜에게 물어보세요")
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
		SelectionList selectionList = new SelectionList();
		BasicCard basicCard = new BasicCard();

		Map<String, Object> data = rb.getConversationData();
		data.clear();
		CommonUtil.printMapData(data);

		String input = CommonUtil.makeSafeString(request.getParameter("Information"));
		simpleResponse.setDisplayText(input)
		.setTextToSpeech(input);
		rb.add(simpleResponse);

//		if(!CommonUtil.isEmptyString(input) && input.equals("Informations")) {
//			simpleResponse
//					.setTextToSpeech("우리 회사의 기본정보 목록이야! 궁금한게 있으면 골라봐!")
//					.setDisplayText("우리 회사의 기본정보 목록이야! 궁금한게 있으면 골라봐!");
//
//			selectionList = new SelectionList()
//					.setTitle("기본정보")
//					.setItems(
//							Arrays.asList(
//									new ListSelectListItem()
//											.setTitle("주소")
//											.setOptionInfo(
//													new OptionInfo()
//															.setKey("Address")),
//									new ListSelectListItem()
//											.setTitle("홈페이지")
//											.setOptionInfo(
//													new OptionInfo()
//															.setKey("Homepage")),
//									new ListSelectListItem()
//											.setTitle("연락처")
//											.setOptionInfo(
//													new OptionInfo()
//															.setKey("Contact")),
//									new ListSelectListItem()
//											.setTitle("설립일")
//											.setOptionInfo(
//													new OptionInfo()
//															.setKey("Established")),
//
//									new ListSelectListItem()
//											.setTitle("회사연혁 및 수상이력")
//											.setOptionInfo(
//													new OptionInfo()
//															.setKey("History"))
//
//							));
//			rb.add(simpleResponse);
//			rb.add(selectionList);
//			//rb.add(basicCard);
//		}
//		else if(!CommonUtil.isEmptyString(input) && input.equals("Address") || input.equals("Homepage") || input.equals("Contact") || input.equals("Established") || input.equals("Prize")) {
//			if(input.equals("Address")) {
//				simpleResponse
//						.setTextToSpeech("우리 회사 주소는 서울특별시 서초구 매헌로 팔길 사십 칠 번지, 양재 에이아이허브 희경빌딩 비동 이백 이호야!");
//			}
//			else if(input.equals("Homepage")) {
//				simpleResponse
//						.setTextToSpeech("우리 회사의 홈페이지야!");
//			}
//			else if(input.equals("Contact")) {
//				simpleResponse
//						.setTextToSpeech("우리 회사의 연락처야!");
//			}
//			else if(input.equals("Established")) {
//				simpleResponse
//						.setTextToSpeech("우리 회사의 설립일은 이천 십칠년 팔월 십육일이야!");
//			}
//			else if(input.equals("History")) {
//				simpleResponse
//						.setTextToSpeech("우리 회사의 연혁과 수상이력이야!");
//			}
//
//			basicCard = createCard(input);
//
//			rb.add(simpleResponse);
//			//rb.add(selectionList);
//			rb.add(basicCard);
//		}

		// 주소가 궁금하구나
		// fallback 보류  --- 궁금쓰


		rb.addSuggestions(suggestions.toArray(new String[suggestions.size()]));
		return rb.build();
	}

	@ForIntent("O2O_info - OPTION")
	public ActionResponse o2o_info_option(ActionRequest request) throws ExecutionException, InterruptedException {
		ResponseBuilder rb = getResponseBuilder(request);
		List<String> suggestions = new ArrayList<String>();
		SimpleResponse simpleResponse = new SimpleResponse();
		BasicCard basicCard = new BasicCard();

		Map<String, Object> data = rb.getConversationData();
		data.clear();
		CommonUtil.printMapData(data);

		String input = CommonUtil.makeSafeString(request.getParameter("Information"));

		if (!CommonUtil.isEmptyString(input) && input.equals("Address") || input.equals("Homepage") || input.equals("Contact") || input.equals("Established") || input.equals("Prize")) {
			if (input.equals("Address")) {
				simpleResponse
						.setTextToSpeech("우리 회사 주소는 서울특별시 서초구 매헌로 팔길 사십 칠 번지, 양재 에이아이허브 희경빌딩 비동 이백 이호야!");
			} else if (input.equals("Homepage")) {
				simpleResponse
						.setTextToSpeech("우리 회사의 홈페이지야!");
			} else if (input.equals("Contact")) {
				simpleResponse
						.setTextToSpeech("우리 회사의 연락처야!");
			} else if (input.equals("Established")) {
				simpleResponse
						.setTextToSpeech("우리 회사의 설립일은 이천 십칠년 팔월 십육일이야!");
			} else if (input.equals("History")) {
				simpleResponse
						.setTextToSpeech("우리 회사의 연혁과 수상이력이야!");
			}

			basicCard = createCard(input);
		}

		// 주소가 궁금하구나
		// fallback 보류  --- 궁금쓰
		rb.add(simpleResponse);
		rb.add(basicCard);

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
