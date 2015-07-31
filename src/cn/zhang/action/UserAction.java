package cn.zhang.action;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
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
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

import cn.zhang.bean.User;
import cn.zhang.service.UserService;

/**
 * �����û������action
 * ���ɾ���û���
 * */
@Controller //employeeAddAtion
public class UserAction{
	
	//�ϴ��û�ͷ��
	public void uphead(){
		HttpServletRequest request=ServletActionContext.getRequest();
		//��ȡϵͳ�ĸ�·��
		String savePath = ServletActionContext.getRequest().getRealPath("/");
		String user_head = new String(request.getParameter("user_head"));
		String returnValue = null;
		
		byte [] user_headByte = Base64.decode(user_head);
		//���������û�ͷ���file
		File file = new File(savePath+"images/user/user_head.jpg");
		try {
			if(file.exists()){
				file.createNewFile();
			}
			FileOutputStream fos = new FileOutputStream(file);
			fos.write(user_headByte);
			fos.flush();
			fos.close();
			returnValue = "1";
		} catch (IOException e) {
			e.printStackTrace();
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
