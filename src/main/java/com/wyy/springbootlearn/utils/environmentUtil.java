package com.wyy.springbootlearn.utils;
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
 * @Date 创建于 2024/9/18 14:31
 */
@RestController
public class environmentUtil {

    @Resource
     private Environment environment;

  // 配置必须存在，且获取的是配置名为 app.demo.val 的配置信息
  @Value("${app.demo.val}")
  private String autoInject;

  // 配置app.demo.not不存在时，不抛异常，给一个默认值data
  @Value("${app.demo.not:dada}")
  private String notExists;

     @GetMapping(path = "show")
     public String show() {
         Map<String, String> result = new HashMap<>(4);
         result.put("env", environment.getProperty("server.port"));
         return result.toString();
     }

}
