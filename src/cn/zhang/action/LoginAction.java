package cn.zhang.action;

import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import cn.zhang.bean.User;
import cn.zhang.service.UserService;

/**
 * �û���¼���õ�action
 * */
@Controller
public class LoginAction {
	
	public void execute(){
		HttpServletRequest request=ServletActionContext.getRequest();
		String username = new String(request.getParameter("username"));
		String password = new String(request.getParameter("user_mac"));
		//��ȡ��
		System.out.println(username+"---"+password);
		String returnValue = null;
		if( ("admin".equals(username) && "admin".equals(password)) || 
				"user".equals(username) && "admin".equals(password) ||
				"spring".equals(username) && "admin".equals(password)
				){
			returnValue = "1";
		}else{
			returnValue = "2";
		}
		//����¼�������
		
		HttpServletResponse response=ServletActionContext.getResponse();  
        response.setContentType("text/html");  
        PrintWriter out;  
        //��ȡ���������
        try {
			out = response.getWriter();
        	JSONObject json=new JSONObject();  
	        json.put("State", returnValue);
	        //��json���ݷŵ�������з���
	        out.println(json.toString());  
	        out.flush();  
	        out.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}
