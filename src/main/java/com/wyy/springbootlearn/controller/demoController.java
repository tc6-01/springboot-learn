package com.wyy.springbootlearn.controller;

import com.wyy.springbootlearn.utils.propertiesLoading;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author WangYangYang
 * @Description
 * @Date 创建于 2024/9/18 14:44
 */
@RestController
public class demoController {
	@Resource
	private Environment environment;
	@Resource
	private propertiesLoading properBean;

	@Value("${app.demo.val}")
	private String autoInject;

	@Value("${app.demo.not:dada}")
	private String notExists;

	@Value("${user.name}")
	private String name;

	@GetMapping(path = "show")
	public String show() {
		Map<String, String> result = new HashMap<>(6);
		result.put("properBean", properBean.toString());
		result.put("autoInject", autoInject);
		result.put("env", environment.getProperty("server.port"));
		result.put("not", notExists);
		result.put("name", name);
		return result.toString();
	}
}

