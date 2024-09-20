package com.wyy.springbootlearn.utils;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author WangYangYang
 * @Description
 * @Date 创建于 2024/9/18 14:37
 */

@Data
@Component
@ConfigurationProperties(prefix = "app.proper")
public class propertiesLoading {
  	private String key;
	private Integer id;
	private String value;
}
