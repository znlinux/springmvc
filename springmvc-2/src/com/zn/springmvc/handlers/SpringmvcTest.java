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
 * �˽⣺���Ը��Ӿ�ȷ������params headersӳ�������Ҷ���֧�ּ򵥵ı��ʽ
 * 
 * ant�����Դ��ַ֧��3��ƥ��� 
 * -�� ƥ���ļ����е�һ���ַ� 
 * -* �����ַ� 
 * -** ����ַ�
 *
 * @PathVariable ��������ӳ��URL�е�ռλ����Ŀ�귽���Ĳ�����
 * @param id
 *
 *            ʹ��ռλ����Я������ ��η���PUT�����DELETE�����أ� 1.��Ҫ����HiddenHttpMethodFilter
 *            2.��Ҫ����POST���� 3.��Ҫ��POST����ʱЯ��һ��name="_method"��������ֵΪDELETE�� PUT
 *            ��springmvc��Ŀ�귽������εõ�ID�أ� ʹ��@PathVariableע��
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
	 * ����Ҫ��һ��������޸Ĳ�������һ���ֶβ��ܸı䣬�����¼��¼��ʱ�䣻���蹲��3���ֶΣ� 
	 * �����������ֶ�
	 * @param map
	 * @return
	 */
	@ModelAttribute
	public void getUser(@RequestParam(value="id",required=false) Integer id,
			Map<String, Object> map){
		if(id != null){
			User user=new User(1,"Grace", "123456", "grace@163.com","123456");
			System.out.println("�����ݿ��л�ȡһ������ "+user);
			map.put("user", user);
		}
	}
	@RequestMapping("/testModelAttribute")
	public String testModelAttribute(User user){
		System.out.println("�޸�Ϊ�� "+user);
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
	 * Ŀ�귽���������Map���ͣ�ʵ����Ҳ������Model���� ��ModelMap����)�Ĳ���
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
	 * Ŀ�귽���ķ���ֵ������ModelAndView���� ���п��԰�����ͼ��ģ����Ϣ
	 * 
	 * @return
	 */
	@RequestMapping("/testModelAndView")
	public ModelAndView testModelAndView() {
		String viewname = "success";
		ModelAndView modelAndView = new ModelAndView(viewname);
		// ���ģ������
		modelAndView.addObject("time", new Date());
		return modelAndView;
	}

	/**
	 * ����ʹ��Servlet��ԭ��API��ΪĿ�귽���Ĳ��� ����֧��һ�����ͣ� HttpServletRequest
	 * HttpServletResponse java.security.Pricipal Locale InputStream
	 * OutputStream Reader Writer
	 * 
	 * @throws IOException
	 */

	@RequestMapping("/testServletAPI")
	public void testServletAPI(HttpServletRequest request, HttpServletResponse response, Writer out)
			throws IOException {
		System.out.println("testServletAPI: " + request + " , " + response);
		// Ϊ�˲�����ʹ��ԭ��̬Servlet�е�Writer���Ȱѷ���ֵStringȥ����Ϊvoid��һ��������Ļ����ʾString
		out.write("hello springmvc!");
		// return "success";
	}

	/*
	 * /** ʹ��POJO������������ֵ Springmvc�ᰴ�������������POJO�������Զ�����ƥ�䣬�Զ�Ϊ�ö����������ֵ��֧�ּ�������
	 */
	@RequestMapping("/testPojo")
	public String testPojo(User user) {
		System.out.println("testPojo: " + user);
		return "success";
	}

	/**
	 * ����ӳ��һ��cookieֵ���÷�ͬ@RequestParam
	 * 
	 */
	@RequestMapping("/testCookieValue")
	public String testCookieValue(@CookieValue("JSESSIONID") String sessionId) {
		System.out.println("test: CookieValue: " + sessionId);
		return "success";
	}

	/**
	 * �÷�ͬ@RequestParam������ӳ������ͷ
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
	 * �������@RequestParam�����������ֵ -value������ -required�Ƿ����Ҫ�� Ĭ����true
	 * -defaultValue���������Ĭ��ֵ
	 * 
	 * @param id
	 * @return
	 */

	@RequestMapping(value = "/testRequestParam")
	public String testRequestParam(@RequestParam(value = "username") String un,
			@RequestParam(value = "age", required = false, defaultValue = "0") int age) {
		System.out.println("�û���Ϊ:" + un + " ����Ϊ" + age);
		return "success";
	}

	@RequestMapping(value = "/testRest/{id}", method = RequestMethod.PUT)
	public String testRestPut(@PathVariable("id") Integer id) {
		System.out.println("����idΪ: " + id + "���û�");
		return "success";
	}

	@RequestMapping(value = "/testRest/{id}", method = RequestMethod.DELETE)
	public String testRestDelete(@PathVariable("id") Integer id) {
		System.out.println("ɾ��idΪ: " + id + "���û�");
		return "success";
	}

	@RequestMapping(value = "/testRest", method = RequestMethod.POST)
	public String testRest() {
		System.out.println("�½��û� ");
		return "success";
	}

	@RequestMapping(value = "/testRest/{id}", method = RequestMethod.GET)
	public String testRest(@PathVariable("id") Integer id) {
		System.out.println("�鿴idΪ: " + id + "���û�");
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
