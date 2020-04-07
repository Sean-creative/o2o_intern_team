package com.o2o.action.server.app;

import com.google.actions.api.ActionRequest;
import com.google.actions.api.ActionResponse;
import com.google.actions.api.ActionsSdkApp;
import com.google.actions.api.DialogflowApp;
import com.google.actions.api.ForIntent;
import com.google.actions.api.response.ResponseBuilder;
import com.google.actions.api.response.helperintent.SelectionCarousel;
import com.google.api.services.actions_fulfillment.v2.model.*;
import com.o2o.action.server.util.CommonUtil;
import com.o2o.action.server.util.CommonWord;
import com.google.actions.api.Capability;


import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class sourceApp extends DialogflowApp {

	@ForIntent("Default Welcome Intent")
	public ActionResponse defaultWelcome(ActionRequest request) throws ExecutionException, InterruptedException {
		ResponseBuilder rb = getResponseBuilder(request);
		List<String> suggestions = new ArrayList<String>();
		SimpleResponse simpleResponse = new SimpleResponse();
		BasicCard basicCard = new BasicCard();

		Map<String, Object> data = rb.getConversationData();


		data.clear();
		CommonUtil.printMapData(data);

		simpleResponse.setTextToSpeech("안녕하세요, 저는 무비베어에요. 저는 영화를 좋아해요! 좋아하는 장르의 영화가 있으신가요?")
				.setDisplayText("안녕하세요, 저는 무비베어에요. 저는 영화를 좋아해요! 좋아하는 장르의 영화가 있으신가요?");
		basicCard
				.setFormattedText("안녕하세요, 저는 무비베어에요. 저는 영화를 좋아해요! 좋아하는 장르의 영화가 있으신가요?")
				.setImage(new Image().setUrl("https://i.pinimg.com/474x/45/8d/03/458d03744a51b1f9e67308beeb6018df.jpg")
						.setAccessibilityText("movie_bear"));

		rb.add(simpleResponse);
		rb.add(basicCard);

		rb.addSuggestions(suggestions.toArray(new String[suggestions.size()]));
		return rb.build();
	}

	@ForIntent("Default Fallback Intent")
	public ActionResponse defaultFallback(ActionRequest request) throws ExecutionException, InterruptedException {
		ResponseBuilder rb = getResponseBuilder(request);
		List<String> suggestions = new ArrayList<String>();
		SimpleResponse simpleResponse = new SimpleResponse();
		BasicCard basicCard = new BasicCard();

		Map<String, Object> data = rb.getConversationData();

		data.clear();
		CommonUtil.printMapData(data);

		simpleResponse.setTextToSpeech("죄송해요. 다시 들려 주실래요?").setDisplayText("죄송해요. 다시 들려 주실래요?");
		basicCard.setFormattedText("죄송해요. 다시 들려 주실래요?")
				.setImage(new Image().setUrl("https://i.pinimg.com/474x/45/8d/03/458d03744a51b1f9e67308beeb6018df.jpg")
						.setAccessibilityText("movie_bear"));

		rb.add(simpleResponse);
		rb.add(basicCard);

		rb.addSuggestions(suggestions.toArray(new String[suggestions.size()]));
		return rb.build();
	}

	@ForIntent("popular_drama")
	public ActionResponse popular_drama(ActionRequest request) throws ExecutionException, InterruptedException {
		ResponseBuilder rb = getResponseBuilder(request);
		List<String> suggestions = new ArrayList<String>();
		SimpleResponse simpleResponse = new SimpleResponse();
		BasicCard basicCard = new BasicCard();

		Map<String, Object> data = rb.getConversationData();

		data.clear();
		CommonUtil.printMapData(data);
		String input = CommonUtil.makeSafeString(request.getParameter("genre"));
	//	simpleResponse.setDisplayText(input);

		if(!CommonUtil.isEmptyString(input)) {
			switch (input) {
				case "horror" :
					rb
							.add(
									new SelectionCarousel()
											.setItems(
													Arrays.asList(
															new CarouselSelectCarouselItem()
																	.setTitle("컨져링2")
																	.setDescription("1977년 영국 엔필드. 엄마 페기와 네 남매가 살고 있는 가족의 집에 정체를 알 수 없는 존재가 나타난다. 일명 폴터가이스트 유령. 벽을 두드리는 소리, 사악한 목소리, 유령은 밤마다 가구와 물건들, 심지어 아이들까지 공중에 띄우는 등 기이한 일들을 일으킨다..")
																	.setImage(
																			new Image()
																					.setUrl("https://movie-phinf.pstatic.net/20160525_161/1464156291880IEpkO_JPEG/movie_image.jpg")
																					.setAccessibilityText("Image alternate text"))
																	.setOptionInfo(
																			new OptionInfo()
																					.setSynonyms(
																							Arrays.asList("컨져링1"))
																					.setKey("The Conjuring 2")),
															new CarouselSelectCarouselItem()
																	.setTitle("애나벨: 인형의 주인")
																	.setDescription(
																			"인형장인과 그의 아내는 비극적인 사고로 어린 딸을 잃는다. 그리고 12년 후, 그 집에 고아원 소녀들과 수녀가 함께 살게 되는데…")
																	.setImage(
																			new Image()
																					.setUrl("https://movie-phinf.pstatic.net/20170710_33/1499652500267HjUEN_JPEG/movie_image.jpg")
																					.setAccessibilityText("Annabelle: Creation"))
																	.setOptionInfo(
																			new OptionInfo()
																					.setKey("Annabelle: Creation")
																			)
													)));
					break;
				case "noir" :
					rb
							.add(
									new SelectionCarousel()
											.setItems(
													Arrays.asList(
															new CarouselSelectCarouselItem()
																	.setTitle("범죄도시")
																	.setDescription("2004년 서울… 하얼빈에서 넘어와 단숨에 기존 조직들을 장악하고 가장 강력한 세력인 춘식이파 보스 ‘황사장’까지 위협하며 도시 일대의 최강자로 급부상한 신흥범죄조직의 악랄한 보스 ‘장첸’.")
																	.setImage(
																			new Image()
																					.setUrl("https://movie-phinf.pstatic.net/20170915_299/1505458505658vbKcN_JPEG/movie_image.jpg")
																					.setAccessibilityText("THE OUTLAWS"))
																	.setOptionInfo(
																			new OptionInfo()
																					.setSynonyms(Arrays.asList("마동석", "윤계상"))
																					.setKey("THE OUTLAWS")),
															new CarouselSelectCarouselItem()
																	.setTitle("신세계")
																	.setDescription("세 남자가 가고 싶었던 서로 다른 신세계 \"너, 나하고 일 하나 같이 하자\"\"우리 브라더는 그냥 딱, 이 형님만 믿으면 돼야!\" \"약속 했잖습니까... 이번엔 진짜 끝이라고\"")
																	.setImage(
																			new Image()
																					.setUrl("https://movie-phinf.pstatic.net/20130206_29/13601146693401seof_JPEG/movie_image.jpg")
																					.setAccessibilityText("New World"))
																	.setOptionInfo(
																			new OptionInfo()
																					.setSynonyms(
																							Arrays.asList("최민식", "이정재", "황정민"))
																					.setKey("New World")))));
					break;
				case "comedy" :
					rb
							.add(
									new SelectionCarousel()
											.setItems(
													Arrays.asList(
															new CarouselSelectCarouselItem()
																	.setTitle("극한직업")
																	.setDescription("낮에는 치킨장사! 밤에는 잠복근무! 지금까지 이런 수사는 없었다!")
																	.setImage(
																			new Image()
																					.setUrl("https://movie-phinf.pstatic.net/20190116_206/1547615429111dINWj_JPEG/movie_image.jpg")
																					.setAccessibilityText("Extreme Job"))
																	.setOptionInfo(
																			new OptionInfo()
																					.setSynonyms(
																							Arrays.asList("류승룡", "이하늬", "이동휘", "신하균"))
																					.setKey("Extreme Job")),
															new CarouselSelectCarouselItem()
																	.setTitle("히트맨")
																	.setDescription(
																			"술김에 그리지 말아야 할 1급 기밀을 그려버리고\n" +
																					" 예상치 않게 웹툰은 하루아침에 초대박이 나지만,\n" +
																					" 그로 인해 '준'은 국정원과 테러리스트의 더블 타깃이 되는데..." )
																	.setImage(
																			new Image()
																					.setUrl("https://movie-phinf.pstatic.net/20200122_181/15796574636309Fux2_JPEG/movie_image.jpg")
																					.setAccessibilityText("HITMAN: AGENT JUN"))
																	.setOptionInfo(
																			new OptionInfo()
																					.setKey("HITMAN: AGENT JUN")))));

					break;
				case "action" :
					rb
							.add(
									new SelectionCarousel()
											.setItems(
													Arrays.asList(
															new CarouselSelectCarouselItem()
																	.setTitle("미션 임파서블: 폴아웃")
																	.setDescription("세계를 멸망시킬 핵 재앙을 막기 위해 세계 최강 스파이기관, IMF의 에단 헌트와 정예 요원들(사이먼 페크, 빙 라메스, 레베카 퍼거슨)은 숙명의 라이벌, 중앙정보국 CIA의 상급 요원(헨리 카빌)과 불편한 동맹을 맺어야만 한다.\n" +
																			" 이보다 더 불가능한 미션은 없었다!.")
																	.setImage(
																			new Image()
																					.setUrl("https://movie-phinf.pstatic.net/20180523_234/1527043720337JCQAP_JPEG/movie_image.jpg")
																					.setAccessibilityText("Image alternate text"))
																	.setOptionInfo(
																			new OptionInfo()
																					.setSynonyms(
																							Arrays.asList("톰 크루즈", "헨리 카빌"))
																					.setKey("Mission: Impossible - Fallout")),
															new CarouselSelectCarouselItem()
																	.setTitle("존 윅 3: 파라벨룸")
																	.setDescription(
																			"전설이 된 킬러 ‘존 윅’ (키아누 리브스). 룰을 어긴 죄로 그에게 현상금 1,400만 불이 붙고, 전 세계 모든 킬러의 총구가 그를 향한다.")
																	.setImage(
																			new Image()
																					.setUrl("https://movie-phinf.pstatic.net/20190621_225/1561080456596qGGRl_JPEG/movie_image.jpg")
																					.setAccessibilityText("John Wick: Chapter 3 - Parabellum"))
																	.setOptionInfo(
																			new OptionInfo()
																					.setSynonyms(
																							Arrays.asList("키아누 리브스", "할리 베리"))
																					.setKey("John Wick: Chapter 3 - Parabellum")))));
					break;
				case "thriller" :
					rb
							.add(
									new SelectionCarousel()
											.setItems(
													Arrays.asList(
															new CarouselSelectCarouselItem()
																	.setTitle("조커")
																	.setDescription("“내 인생이 비극인줄 알았는데, 코미디였어”")
																	.setImage(
																			new Image()
																					.setUrl("https://movie-phinf.pstatic.net/20190906_128/1567761736426S6Fje_JPEG/movie_image.jpg")
																					.setAccessibilityText("Joker"))
																	.setOptionInfo(
																			new OptionInfo()
																					.setSynonyms(
																							Arrays.asList("호아킨 피닉스"))
																					.setKey("Joker")),
															new CarouselSelectCarouselItem()
																	.setTitle("나를 찾아줘")
																	.setDescription(
																			"우리부부는 누구나 부러워하는 ‘완벽한 커플’이었다. 그날, 아내가 사라지기 전까지…")
																	.setImage(
																			new Image()
																					.setUrl("https://movie-phinf.pstatic.net/20140926_208/1411709062718lr7RV_JPEG/movie_image.jpg")
																					.setAccessibilityText("Gone Girl"))
																	.setOptionInfo(
																			new OptionInfo()
																					.setSynonyms(
																							Arrays.asList("벤 애플렉", "로자먼드 파이크"))
																					.setKey("Gone Girl")))));
					break;
				case "fantasy" :
					rb
							.add(
									new SelectionCarousel()
											.setItems(
													Arrays.asList(
															new CarouselSelectCarouselItem()
																	.setTitle("신과함께-인과 연")
																	.setDescription("천 년 동안 48명의 망자를 환생시킨 저승 삼차사, 한 명만 더 환생시키면 그들도 새로운 삶을 얻을 수 있다.")
																	.setImage(
																			new Image()
																					.setUrl("https://movie-phinf.pstatic.net/20180703_65/15305852198817R6a1_JPEG/movie_image.jpg")
																					.setAccessibilityText("Along with the Gods: The Last 49 Days"))
																	.setOptionInfo(
																			new OptionInfo()
																					.setSynonyms(
																							Arrays.asList("하정우", "주지훈", "김향기", "마동석"))
																					.setKey("Along with the Gods: The Last 49 Days")),
															new CarouselSelectCarouselItem()
																	.setTitle("당신, 거기 있어줄래요")
																	.setDescription("인생을 뒤바꾼 기적 같은 10번의 기회 “넌 30년 전의 나고, 난 30년 후의 너야”")
																	.setImage(
																			new Image()
																					.setUrl("https://movie-phinf.pstatic.net/20161124_88/1479951959050RqcvW_JPEG/movie_image.jpg")
																					.setAccessibilityText("Will You Be There?"))
																	.setOptionInfo(
																			new OptionInfo()
																					.setSynonyms(
																							Arrays.asList("김윤석", "변요한"))
																					.setKey("Will You Be There?")))));
					break;
				case "melo" :
					rb
							.add(
									new SelectionCarousel()
											.setItems(
													Arrays.asList(
															new CarouselSelectCarouselItem()
																	.setTitle("어바웃 타임")
																	.setDescription("모태솔로 팀(돔놀 글리슨)은 성인이 된 날, 아버지(빌 나이)로부터 놀랄만한 가문의 비밀을 듣게 된다. 바로 시간을 되돌릴 수 있는 능력이 있다는 것!")
																	.setImage(
																			new Image()
																					.setUrl("https://movie-phinf.pstatic.net/20131115_243/1384498185621awKv1_JPEG/movie_image.jpg")
																					.setAccessibilityText("About Time"))
																	.setOptionInfo(
																			new OptionInfo()
																					.setSynonyms(
																							Arrays.asList("도널 글리슨", "레이첼 맥아담스"))
																					.setKey("About Time")),
															new CarouselSelectCarouselItem()
																	.setTitle("러브 앳")
																	.setDescription("어느 날, 눈 떠보니 평행세계! 아내 ‘올리비아’와 다투고 만취 상태로 잠에서 깨어난 ‘라파엘’은 평소와 다름을 느낀다. 같은 듯 다른 세상.")
																	.setImage(
																			new Image()
																					.setUrl("https://movie-phinf.pstatic.net/20191101_59/1572592686493NxSfy_JPEG/movie_image.jpg")
																					.setAccessibilityText("Mon inconnue, Love at Second Sight"))
																	.setOptionInfo(
																			new OptionInfo()
																					.setSynonyms(
																							Arrays.asList("프랑수아 시빌", "조세핀 자피"))
																					.setKey("Mon inconnue, Love at Second Sight")))));
					break;
			}
		}
		simpleResponse.setTextToSpeech("혹시 이 영화 봐보셨나요?")
				.setDisplayText("혹시 이 영화 봐보셨나요?");

		rb.addSuggestions(suggestions.toArray(new String[suggestions.size()]));
		return rb.add(simpleResponse).build();
	}
	@ForIntent("drama_OPTION")
	public ActionResponse drama_OPTION(ActionRequest request) {
		ResponseBuilder responseBuilder = getResponseBuilder(request);
		String selectedItem = request.getSelectedOption();
		BasicCard basicCard = new BasicCard();
		SimpleResponse simpleResponse = new SimpleResponse();
		String response;

		if (selectedItem.equals("The Conjuring 2")) {
			simpleResponse.setTextToSpeech("컨져링2의 상세정보입니다. 1977년 영국 엔필드. 엄마 페기와 네 남매가 살고 있는 가족의 집에 정체를 알 수 없는 존재가 나타난다. 일명 폴터가이스트 유령. 벽을 두드리는 소리, 사악한 목소리, 유령은 밤마다 가구와 물건들, 심지어 아이들까지 공중에 띄우는 등 기이한 일들을 일으킨다.");
			basicCard
					.setTitle("컨져링2")
					.setFormattedText("1977년 영국 엔필드. 엄마 페기와 네 남매가 살고 있는 가족의 집에 정체를 알 수 없는 존재가 나타난다. 일명 폴터가이스트 유령. 벽을 두드리는 소리, 사악한 목소리, 유령은 밤마다 가구와 물건들, 심지어 아이들까지 공중에 띄우는 등 기이한 일들을 일으킨다.")
					.setImage(new Image().setUrl("https://movie-phinf.pstatic.net/20160525_161/1464156291880IEpkO_JPEG/movie_image.jpg")
							.setAccessibilityText("The Conjuring 2"))
					.setButtons(
							new ArrayList<Button>(
									Arrays.asList(
											new Button()
													.setTitle("상세 정보 링크.")
													.setOpenUrlAction(
															new OpenUrlAction().setUrl("https://movie.naver.com/movie/bi/mi/basic.nhn?code=114282")
													)
									)
							)
					);
		} else if (selectedItem.equals("Annabelle: Creation")) {
			simpleResponse.setTextToSpeech("애나벨: 인형의 주인 상세정보입니다. “그렇게 소녀는 애나벨이 되었다” 인형장인과 그의 아내는 비극적인 사고로 어린 딸을 잃는다. 그리고 12년 후, 그 집에 고아원 소녀들과 수녀가 함께 살게 되는데… “딸을 다시 볼 수만 있다면 어떤 존재도 받아들이겠다 기도했어요. 그건 우리 꿀벌… 내 딸이 틀림없었죠. 인형 속에 들어가 평생 우리랑 있겠다더군요. 하지만 곧 내 딸이 아니란 걸 깨닫게 됐죠. 사악한 존재가 우릴 속여서 영혼을 빼앗으려고 했어요. 교회의 도움으로 악마를 인형 속에 가뒀고,이제 사라진 줄 알았는데… 돌아왔어, 이렇게 될 줄 알았어…”");
			basicCard
					.setTitle("애나벨: 인형의 주인 ")
					.setFormattedText("“그렇게 소녀는 애나벨이 되었다” 인형장인과 그의 아내는 비극적인 사고로 어린 딸을 잃는다. 그리고 12년 후, 그 집에 고아원 소녀들과 수녀가 함께 살게 되는데… “딸을 다시 볼 수만 있다면 어떤 존재도 받아들이겠다 기도했어요. 그건 우리 꿀벌… 내 딸이 틀림없었죠. 인형 속에 들어가 평생 우리랑 있겠다더군요. 하지만 곧 내 딸이 아니란 걸 깨닫게 됐죠. 사악한 존재가 우릴 속여서 영혼을 빼앗으려고 했어요. 교회의 도움으로 악마를 인형 속에 가뒀고,이제 사라진 줄 알았는데… 돌아왔어, 이렇게 될 줄 알았어…”")
					.setImage(new Image().setUrl("https://movie-phinf.pstatic.net/20170710_33/1499652500267HjUEN_JPEG/movie_image.jpg")
							.setAccessibilityText("Annabelle: Creation"))
					.setButtons(
							new ArrayList<Button>(
									Arrays.asList(
											new Button()
													.setTitle("상세 정보 링크.")
													.setOpenUrlAction(
															new OpenUrlAction().setUrl("https://movie.naver.com/movie/bi/mi/basic.nhn?code=152341")
													)
									)
							)
					);
		} else if (selectedItem.equals("THE OUTLAWS")) {
			simpleResponse.setTextToSpeech("범죄도시의 상세정보입니다. 2004년 서울… 하얼빈에서 넘어와 단숨에 기존 조직들을 장악하고 가장 강력한 세력인 춘식이파 보스 ‘황사장’까지 위협하며 도시 일대의 최강자로 급부상한 신흥범죄조직의 악랄한 보스 ‘장첸’.");
			basicCard
					.setTitle("범죄도시")
					.setFormattedText("2004년 서울… 하얼빈에서 넘어와 단숨에 기존 조직들을 장악하고 가장 강력한 세력인 춘식이파 보스 ‘황사장’까지 위협하며 도시 일대의 최강자로 급부상한 신흥범죄조직의 악랄한 보스 ‘장첸’.")
					.setImage(new Image().setUrl("https://movie-phinf.pstatic.net/20170915_299/1505458505658vbKcN_JPEG/movie_image.jpg")
							.setAccessibilityText("THE OUTLAWS"))
					.setButtons(
							new ArrayList<Button>(
									Arrays.asList(
											new Button()
													.setTitle("상세 정보 링크.")
													.setOpenUrlAction(
															new OpenUrlAction().setUrl("https://movie.naver.com/movie/bi/mi/basic.nhn?code=161242")
													)
									)
							)
					);
		} else if (selectedItem.equals("New World")) {
			simpleResponse.setTextToSpeech("신세계의 상세정보입니다. 세 남자가 가고 싶었던 서로 다른 신세계 \"너, 나하고 일 하나 같이 하자\"\"우리 브라더는 그냥 딱, 이 형님만 믿으면 돼야!\" \"약속 했잖습니까... 이번엔 진짜 끝이라고\"");
			basicCard
					.setTitle("신세계")
					.setFormattedText("세 남자가 가고 싶었던 서로 다른 신세계 \"너, 나하고 일 하나 같이 하자\"\"우리 브라더는 그냥 딱, 이 형님만 믿으면 돼야!\" \"약속 했잖습니까... 이번엔 진짜 끝이라고\"")
					.setImage(new Image().setUrl("https://movie-phinf.pstatic.net/20130206_29/13601146693401seof_JPEG/movie_image.jpg")
							.setAccessibilityText("New World"))
					.setButtons(
							new ArrayList<Button>(
									Arrays.asList(
											new Button()
													.setTitle("상세 정보 링크.")
													.setOpenUrlAction(
															new OpenUrlAction().setUrl("https://movie.naver.com/movie/bi/mi/basic.nhn?code=91031")
													)
									)
							)
					);
		} else if (selectedItem.equals("Extreme Job")) {
			simpleResponse.setTextToSpeech("극한직업의 상세정보입니다. 낮에는 치킨장사! 밤에는 잠복근무! 지금까지 이런 수사는 없었다! <극한직업>");
			basicCard
					.setTitle("극한직업")
					.setFormattedText("낮에는 치킨장사! 밤에는 잠복근무! 지금까지 이런 수사는 없었다!")
					.setImage(new Image().setUrl("https://movie-phinf.pstatic.net/20190116_206/1547615429111dINWj_JPEG/movie_image.jpg")
							.setAccessibilityText("Extreme Job"))
					.setButtons(
							new ArrayList<Button>(
									Arrays.asList(
											new Button()
													.setTitle("상세 정보 링크.")
													.setOpenUrlAction(
															new OpenUrlAction().setUrl("https://movie.naver.com/movie/bi/mi/basic.nhn?code=167651")
													)
									)
							)
					);
		} else if (selectedItem.equals("HITMAN: AGENT JUN")) {
			simpleResponse.setTextToSpeech("히트맨의 상세정보입니다. 술김에 그리지 말아야 할 1급 기밀을 그려버리고 예상치 않게 웹툰은 하루아침에 초대박이 나지만, 그로 인해 '준'은 국정원과 테러리스트의 더블 타깃이 되는데...");
			basicCard
					.setTitle("히트맨")
					.setFormattedText("술김에 그리지 말아야 할 1급 기밀을 그려버리고 예상치 않게 웹툰은 하루아침에 초대박이 나지만, 그로 인해 '준'은 국정원과 테러리스트의 더블 타깃이 되는데...")
					.setImage(new Image().setUrl("https://movie-phinf.pstatic.net/20160525_161/1464156291880IEpkO_JPEG/movie_image.jpg")
							.setAccessibilityText("HITMAN: AGENT JUN"))
					.setButtons(
							new ArrayList<Button>(
									Arrays.asList(
											new Button()
													.setTitle("상세 정보 링크.")
													.setOpenUrlAction(
															new OpenUrlAction().setUrl("https://movie.naver.com/movie/bi/mi/basic.nhn?code=185838")
													)
									)
							)
					);
		} else if (selectedItem.equals("Mission: Impossible - Fallout")) {
			simpleResponse.setTextToSpeech("미션 임파서블: 폴아웃의 상세정보입니다. 세계를 멸망시킬 핵 재앙을 막기 위해 세계 최강 스파이기관, IMF의 에단 헌트와 정예 요원들(사이먼 페크, 빙 라메스, 레베카 퍼거슨)은 숙명의 라이벌, 중앙정보국 CIA의 상급 요원(헨리 카빌)과 불편한 동맹을 맺어야만 한다. 이보다 더 불가능한 미션은 없었다! <미션 임파서블: 폴아웃>");
			basicCard
					.setTitle("미션 임파서블: 폴아웃")
					.setFormattedText("세계를 멸망시킬 핵 재앙을 막기 위해 세계 최강 스파이기관, IMF의 에단 헌트와 정예 요원들(사이먼 페크, 빙 라메스, 레베카 퍼거슨)은 숙명의 라이벌, 중앙정보국 CIA의 상급 요원(헨리 카빌)과 불편한 동맹을 맺어야만 한다. 이보다 더 불가능한 미션은 없었다!")
					.setImage(new Image().setUrl("https://movie-phinf.pstatic.net/20180523_234/1527043720337JCQAP_JPEG/movie_image.jpg")
							.setAccessibilityText("Mission: Impossible - Fallout"))
					.setButtons(
							new ArrayList<Button>(
									Arrays.asList(
											new Button()
													.setTitle("상세 정보 링크.")
													.setOpenUrlAction(
															new OpenUrlAction().setUrl("https://movie.naver.com/movie/bi/mi/basic.nhn?code=154222")
													)
									)
							)
					);
		} else if (selectedItem.equals("John Wick: Chapter 3 - Parabellum")) {
			simpleResponse.setTextToSpeech("존 윅 3: 파라벨룸의 상세정보입니다. 전설이 된 킬러 ‘존 윅’. 룰을 어긴 죄로 그에게 현상금 1,400만 불이 붙고, 전 세계 모든 킬러의 총구가 그를 향한다.");
			basicCard
					.setTitle("존 윅 3: 파라벨룸")
					.setFormattedText("전설이 된 킬러 ‘존 윅’ (키아누 리브스). 룰을 어긴 죄로 그에게 현상금 1,400만 불이 붙고, 전 세계 모든 킬러의 총구가 그를 향한다.")
					.setImage(new Image().setUrl("https://movie-phinf.pstatic.net/20190621_225/1561080456596qGGRl_JPEG/movie_image.jpg")
							.setAccessibilityText("John Wick: Chapter 3 - Parabellum"))
					.setButtons(
							new ArrayList<Button>(
									Arrays.asList(
											new Button()
													.setTitle("상세 정보 링크.")
													.setOpenUrlAction(
															new OpenUrlAction().setUrl("https://movie.naver.com/movie/bi/mi/basic.nhn?code=181698")
													)
									)
							)
					);
		} else if (selectedItem.equals("Joker")) {
			simpleResponse.setTextToSpeech("조커의 상세정보입니다. “내 인생이 비극인줄 알았는데, 코미디였어” 고담시의 광대 아서 플렉은 코미디언을 꿈꾸는 남자. 하지만 모두가 미쳐가는 코미디 같은 세상에서 맨 정신으로는 그가 설 자리가 없음을 깨닫게 되는데… 이제껏 본 적 없는 진짜 ‘조커’를 만나라!");
			basicCard
					.setTitle("조커")
					.setFormattedText("“내 인생이 비극인줄 알았는데, 코미디였어” 고담시의 광대 아서 플렉은 코미디언을 꿈꾸는 남자. 하지만 모두가 미쳐가는 코미디 같은 세상에서 맨 정신으로는 그가 설 자리가 없음을 깨닫게 되는데… 이제껏 본 적 없는 진짜 ‘조커’를 만나라!")
					.setImage(new Image().setUrl("https://movie-phinf.pstatic.net/20190906_128/1567761736426S6Fje_JPEG/movie_image.jpg")
							.setAccessibilityText("Joker"))
					.setButtons(
							new ArrayList<Button>(
									Arrays.asList(
											new Button()
													.setTitle("상세 정보 링크.")
													.setOpenUrlAction(
															new OpenUrlAction().setUrl("https://movie.naver.com/movie/bi/mi/basic.nhn?code=167613")
													)
									)
							)
					);
		} else if (selectedItem.equals("Gone Girl")) {
			simpleResponse.setTextToSpeech("나를 찾아줘의 상세정보입니다. 우리부부는 누구나 부러워하는 ‘완벽한 커플’이었다. 그날, 아내가 사라지기 전까지…<나를 찾아줘>");
			basicCard
					.setTitle("나를 찾아줘")
					.setFormattedText("우리부부는 누구나 부러워하는 ‘완벽한 커플’이었다. 그날, 아내가 사라지기 전까지…")
					.setImage(new Image().setUrl("https://movie-phinf.pstatic.net/20140926_208/1411709062718lr7RV_JPEG/movie_image.jpg")
							.setAccessibilityText("Gone Girl"))
					.setButtons(
							new ArrayList<Button>(
									Arrays.asList(
											new Button()
													.setTitle("상세 정보 링크.")
													.setOpenUrlAction(
															new OpenUrlAction().setUrl("https://movie.naver.com/movie/bi/mi/basic.nhn?code=116234")
													)
									)
							)
					);
		} else if (selectedItem.equals("Along with the Gods: The Last 49 Days")) {
			simpleResponse.setTextToSpeech("신과함께-인과 연의 상세정보입니다. 천 년 동안 48명의 망자를 환생시킨 저승 삼차사, 한 명만 더 환생시키면 그들도 새로운 삶을 얻을 수 있다.");
			basicCard
					.setTitle("신과함께-인과 연")
					.setFormattedText("천 년 동안 48명의 망자를 환생시킨 저승 삼차사, 한 명만 더 환생시키면 그들도 새로운 삶을 얻을 수 있다.")
					.setImage(new Image().setUrl("https://movie-phinf.pstatic.net/20180703_65/15305852198817R6a1_JPEG/movie_image.jpg")
							.setAccessibilityText("Along with the Gods: The Last 49 Days"))
					.setButtons(
							new ArrayList<Button>(
									Arrays.asList(
											new Button()
													.setTitle("상세 정보 링크.")
													.setOpenUrlAction(
															new OpenUrlAction().setUrl("https://movie.naver.com/movie/bi/mi/basic.nhn?code=167697")
													)
									)
							)
					);
		} else if (selectedItem.equals("Will You Be There?")) {
			responseBuilder.add("당신, 거기 있어줄래요의 상세정보입니다");
			simpleResponse.setTextToSpeech("당신, 거기 있어줄래요의 상세정보입니다. 인생을 뒤바꾼 기적 같은 10번의 기회 “넌 30년 전의 나고, 난 30년 후의 너야”");
			basicCard
					.setTitle("당신, 거기 있어줄래요")
					.setFormattedText("인생을 뒤바꾼 기적 같은 10번의 기회 “넌 30년 전의 나고, 난 30년 후의 너야”")
					.setImage(new Image().setUrl("https://movie-phinf.pstatic.net/20161124_88/1479951959050RqcvW_JPEG/movie_image.jpg")
							.setAccessibilityText("Will You Be There?"))
					.setButtons(
							new ArrayList<Button>(
									Arrays.asList(
											new Button()
													.setTitle("상세 정보 링크.")
													.setOpenUrlAction(
															new OpenUrlAction().setUrl("https://movie.naver.com/movie/bi/mi/basic.nhn?code=145292")
													)
									)
							)
					);
		} else if (selectedItem.equals("About Time")) {
			simpleResponse.setTextToSpeech("어바웃 타임의 상세정보입니다. 모태솔로 팀은 성인이 된 날, 아버지로부터 놀랄만한 가문의 비밀을 듣게 된다. 바로 시간을 되돌릴 수 있는 능력이 있다는 것! 그것이 비록 히틀러를 죽이거나 여신과 뜨거운 사랑을 할 수는 없지만, 여자친구는 만들어 줄 순 있으리..");
			basicCard
				.setTitle("어바웃 타임")
				.setFormattedText("모태솔로 팀(돔놀 글리슨)은 성인이 된 날, 아버지(빌 나이)로부터 놀랄만한 가문의 비밀을 듣게 된다. 바로 시간을 되돌릴 수 있는 능력이 있다는 것!그것이 비록 히틀러를 죽이거나 여신과 뜨거운 사랑을 할 수는 없지만, 여자친구는 만들어 줄 순 있으리..")
				.setImage(new Image().setUrl("https://movie-phinf.pstatic.net/20131115_243/1384498185621awKv1_JPEG/movie_image.jpg")
						.setAccessibilityText("About Time"))
				.setButtons(
						new ArrayList<Button>(
								Arrays.asList(
										new Button()
												.setTitle("상세 정보 링크.")
												.setOpenUrlAction(
														new OpenUrlAction().setUrl("https://movie.naver.com/movie/bi/mi/basic.nhn?code=92075")
												)
								)
						)
				);
		} else if (selectedItem.equals("Mon inconnue, Love at Second Sight")) {
			simpleResponse.setTextToSpeech("러브 앳의 상세정보입니다어느 날, 눈 떠보니 평행세계! 아내 ‘올리비아’와 다투고 만취 상태로 잠에서 깨어난 ‘라파엘’은 평소와 다름을 느낀다. 같은 듯 다른 세상. <러브 앳>");
			basicCard
					.setTitle("러브 앳")
					.setFormattedText("어느 날, 눈 떠보니 평행세계! 아내 ‘올리비아’와 다투고 만취 상태로 잠에서 깨어난 ‘라파엘’은 평소와 다름을 느낀다. 같은 듯 다른 세상.")
					.setImage(new Image().setUrl("https://movie-phinf.pstatic.net/20191101_59/1572592686493NxSfy_JPEG/movie_image.jpg")
							.setAccessibilityText("Mon inconnue, Love at Second Sight"))
					.setButtons(
							new ArrayList<Button>(
									Arrays.asList(
											new Button()
													.setTitle("상세 정보 링크.")
													.setOpenUrlAction(
															new OpenUrlAction().setUrl("https://movie.naver.com/movie/bi/mi/basic.nhn?code=190244")
													)
									)
							)
					);

		} else {
			simpleResponse.setTextToSpeech("해당 정보가 없습니다.");
		}

		return responseBuilder.add(simpleResponse).add(basicCard).build();
	}
}



