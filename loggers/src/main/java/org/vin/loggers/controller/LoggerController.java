package org.vin.loggers.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class LoggerController {

	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(LoggerController.class);

	@PostMapping("log" )
	public String log(@RequestParam("log") String logJson) {
		System.out.println(logJson);
		JSONObject jsonObject = JSON.parseObject(logJson);
		jsonObject.put("ts", System.currentTimeMillis());

		logger.info(jsonObject.toJSONString());

		return "success";
	}

}
