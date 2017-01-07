package com.cheney.web.controller.java;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cheney.gencode.gen.java.GenServiceCode;

/**
 * @Moudle: GenJavaCodeController
 * @version:v1.0
 * @Description: Java代码生成器控制入口
 * @author: xuyushuai
 * @date: 2015年3月27日 下午2:08:57
 *
 */
@RestController
@RequestMapping("/gencode/java")
public class GenJavaCodeController {

	@RequestMapping(value="/genservice",method=RequestMethod.POST)
	public Map<String,String> genService(String prefix,String json) {
		// 入参设置
		json = json.replaceAll("\\s","");
		Map<String,String> parmMap = new HashMap<String,String>();
		parmMap.put("prefix",prefix);
		parmMap.put("json",json);
		// 生成接口代码和实现代码
		String interfaceCode = GenServiceCode.genInterface(parmMap);
		String implCode = GenServiceCode.genImpl(parmMap);
		// 返回数据
		Map<String,String> codeMap = new HashMap<String,String>();
		codeMap.put("interfaceCode", interfaceCode);
		codeMap.put("implCode", implCode);

		return codeMap;
	}

	@RequestMapping("/gendao")
	public String genDao(String json, String prefix) {
		return "content/gencode/java/javacode";
	}
}