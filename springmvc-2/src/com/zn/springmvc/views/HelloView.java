package com.zn.springmvc.views;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.View;

@Component
public class HelloView implements View {

	@Override
	public String getContentType() {
		// TODO Auto-generated method stub
		//������ͼ����
		return "text/html";
	}

	@Override
	public void render(Map<String, ?> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		//��Ⱦ��ͼ����ͼ����ʾ���ݣ�
		response.getWriter().print("HelloView, time: "+ new Date());
	}

}
