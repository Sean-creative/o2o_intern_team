package com.o2o.action.server.rest;

import com.o2o.action.server.app.interactiveCanvas;
import com.o2o.action.server.app.internApp;
import com.o2o.action.server.repo.CategoryRepository;
import com.o2o.action.server.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.ExecutionException;

@RestController
public class interacitveController {
	private final interactiveCanvas inter;

	@Autowired
	private CategoryRepository categoryRepository;

	public interacitveController() {
		inter = new interactiveCanvas();
	}

	@RequestMapping(value = "/intern", method = RequestMethod.POST)
	public @ResponseBody String processActions(@RequestBody String body, HttpServletRequest request,
			HttpServletResponse response) {
		String jsonResponse = null;
		try {
			System.out.println("request : " + body + "," + categoryRepository);
			jsonResponse = inter.handleRequest(body, CommonUtil.getHttpHeadersMap(request)).get();
			System.out.println("response : " + jsonResponse);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}

		return jsonResponse;
	}
}
