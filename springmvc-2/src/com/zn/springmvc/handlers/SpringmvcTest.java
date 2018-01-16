package com.zn.springmvc.handlers;

import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.zn.springmvc.entities.User;

/**
 * 了解：可以更加精确的适用params headers映射请求，且二者支持简单的表达式
 * 
 * ant风格资源地址支持3种匹配符 
 * -？ 匹配文件名中的一个字符 
 * -* 任意字符 
 * -** 多层字符
 *
 * @PathVariable 可以用来映射URL中的占位符到目标方法的参数中
 * @param id
 *
 *            使用占位符来携带参数 如何发送PUT请求和DELETE请求呢？ 1.需要配置HiddenHttpMethodFilter
 *            2.需要发送POST请求 3.需要在POST请求时携带一个name="_method"的隐藏域，值为DELETE或 PUT
 *            在springmvc的目标方法中如何得到ID呢？ 使用@PathVariable注解
 *
 *
 * @author Administrator
 *
 */
@SessionAttributes(value = {"user"}, types = {String.class})
@Controller
public class SpringmvcTest {
	
	
	@RequestMapping("/testView")
	public String testView(){
		System.out.println("testView");
		return"helloView";
	}

	/**
	 * 我们要对一个对象的修改操作（有一个字段不能改变，比如记录的录入时间；假设共有3个字段） 
	 * 表单传入两个字段
	 * @param map
	 * @return
	 */
	@ModelAttribute
	public void getUser(@RequestParam(value="id",required=false) Integer id,
			Map<String, Object> map){
		if(id != null){
			User user=new User(1,"Grace", "123456", "grace@163.com","123456");
			System.out.println("从数据库中获取一个对象： "+user);
			map.put("user", user);
		}
	}
	@RequestMapping("/testModelAttribute")
	public String testModelAttribute(User user){
		System.out.println("修改为： "+user);
		return "success";
	}
	
	@RequestMapping("/testViewAndViewResolver")
	public String testViewAndViewResolver(){
		System.out.println("testViewAndViewResolver");
		return"success";
	}
	@RequestMapping("/testSessionAttributes")
	public String testSessionAttributes(Map<String, Object> map) {
		User user = new User("Tom", "123456", "zn@123.com", "123456");
		map.put("user", user);
		return "success";
	}

	/**
	 * 目标方法可以添加Map类型（实际上也可以是Model类型 或ModelMap类型)的参数
	 * 
	 * @param map
	 * @return
	 */
	@RequestMapping("/testMap")
	public String testMap(Map<String, Object> map) {
		map.put("names", Arrays.asList("Tom", "Mike", "Lily"));
		return "success";
	}

	/**
	 * 目标方法的返回值可以是ModelAndView类型 其中可以包括视图和模型信息
	 * 
	 * @return
	 */
	@RequestMapping("/testModelAndView")
	public ModelAndView testModelAndView() {
		String viewname = "success";
		ModelAndView modelAndView = new ModelAndView(viewname);
		// 添加模型数据
		modelAndView.addObject("time", new Date());
		return modelAndView;
	}

	/**
	 * 可以使用Servlet的原生API作为目标方法的参数 具体支持一下类型： HttpServletRequest
	 * HttpServletResponse java.security.Pricipal Locale InputStream
	 * OutputStream Reader Writer
	 * 
	 * @throws IOException
	 */

	@RequestMapping("/testServletAPI")
	public void testServletAPI(HttpServletRequest request, HttpServletResponse response, Writer out)
			throws IOException {
		System.out.println("testServletAPI: " + request + " , " + response);
		// 为了测试能使用原生态Servlet中的Writer，先把返回值String去掉改为void，一样能在屏幕上显示String
		out.write("hello springmvc!");
		// return "success";
	}

	/*
	 * /** 使用POJO对象绑定请求参数值 Springmvc会按照请求参数名和POJO属性名自动进行匹配，自动为该对象填充属性值。支持级联属性
	 */
	@RequestMapping("/testPojo")
	public String testPojo(User user) {
		System.out.println("testPojo: " + user);
		return "success";
	}

	/**
	 * 用于映射一个cookie值，用法同@RequestParam
	 * 
	 */
	@RequestMapping("/testCookieValue")
	public String testCookieValue(@CookieValue("JSESSIONID") String sessionId) {
		System.out.println("test: CookieValue: " + sessionId);
		return "success";
	}

	/**
	 * 用法同@RequestParam，用于映射请求头
	 * 
	 * @param al
	 * @return
	 */

	@RequestMapping("/testRequestHeader")
	public String testRequestHeader(@RequestHeader(value = "Accept-Language") String al) {
		System.out.println("testRequestHeader:Accept-Language:" + al);
		return "success";
	}

	/**
	 * 请求参数@RequestParam来绑定请求参数值 -value参数名 -required是否必须要有 默认是true
	 * -defaultValue请求参数的默认值
	 * 
	 * @param id
	 * @return
	 */

	@RequestMapping(value = "/testRequestParam")
	public String testRequestParam(@RequestParam(value = "username") String un,
			@RequestParam(value = "age", required = false, defaultValue = "0") int age) {
		System.out.println("用户名为:" + un + " 年龄为" + age);
		return "success";
	}

	@RequestMapping(value = "/testRest/{id}", method = RequestMethod.PUT)
	public String testRestPut(@PathVariable("id") Integer id) {
		System.out.println("更新id为: " + id + "的用户");
		return "success";
	}

	@RequestMapping(value = "/testRest/{id}", method = RequestMethod.DELETE)
	public String testRestDelete(@PathVariable("id") Integer id) {
		System.out.println("删除id为: " + id + "的用户");
		return "success";
	}

	@RequestMapping(value = "/testRest", method = RequestMethod.POST)
	public String testRest() {
		System.out.println("新建用户 ");
		return "success";
	}

	@RequestMapping(value = "/testRest/{id}", method = RequestMethod.GET)
	public String testRest(@PathVariable("id") Integer id) {
		System.out.println("查看id为: " + id + "的用户");
		return "success";
	}

	@RequestMapping("/testAntPath/*")
	public String testAntPath() {
		System.out.println("testAntPath");
		return "success";
	}

	@RequestMapping(value = "testRequestParamsAndHeaders", params = { "username", "age!=10" })
	public String testRequestParamsAndHeaders() {
		System.out.println("testRequestParamsAndHeaders");
		return "success";
	}

	@RequestMapping(value = "/testRequestMethod", method = RequestMethod.POST)
	public String testRequestMethod() {
		System.out.println("testRequestMethod");
		return "success";
	}

}
