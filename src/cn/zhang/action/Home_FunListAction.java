package cn.zhang.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import cn.zhang.service.EmployeeService;

/**
  * ������ҳ���еĹ����б����ݵ�action
  */
@Controller 
public class Home_FunListAction {

		//action��Ĭ��ִ�к���
		public void execute(){
			HttpServletResponse response=ServletActionContext.getResponse();  
	        //���´����JSON.java�п�������  
	        response.setContentType("text/html");  
	        PrintWriter out;  
	        //��ȡ���������
	        try {
				out = response.getWriter();
				JSONArray ja = new JSONArray();
		        for(int i = 1; i< 21 ; i++){
		        	JSONObject json=new JSONObject();  
			        json.put("id", i);
			        json.put("appName", "����"+i);
			        json.put("photo", "/images/funIcon/index.png");
			        json.put("webAddr", "http://test");
			        ja.put(json);
		        }
		        String message =new String(ja.toString().getBytes("GB2312"),"ISO-8859-1");
		        //System.out.println(message);
		        //��json���ݷŵ�������з���
		        out.println(message);  
		        out.flush();  
		        out.close();
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}
		
		
}
