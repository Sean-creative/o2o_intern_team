package com.o2o.action.server.rest;

import java.util.concurrent.ExecutionException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.o2o.action.server.app.O2O_internApp;
import com.o2o.action.server.repo.CategoryRepository;
import com.o2o.action.server.util.CommonUtil;

@RestController
public class O2O_internController {
	private final O2O_internApp O2O_internApp;

	@Autowired
	private CategoryRepository categoryRepository;

	public O2O_internController() {
		O2O_internApp = new O2O_internApp();
	}

	@RequestMapping(value = "/O2ntern", method = RequestMethod.POST)
	public @ResponseBody String processActions(@RequestBody String body, HttpServletRequest request,
			HttpServletResponse response) {
		String jsonResponse = null;
		try {
			System.out.println("request : " + body + "," + categoryRepository);
			jsonResponse = O2O_internApp.handleRequest(body, CommonUtil.getHttpHeadersMap(request)).get();
			System.out.println("response : " + jsonResponse);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}

		return jsonResponse;
	}

}
