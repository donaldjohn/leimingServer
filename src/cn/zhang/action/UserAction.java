package cn.zhang.action;

import java.io.PrintWriter;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import cn.zhang.service.UserService;

/**
 * �����û������action
 * ���ɾ���û���
 * */
@Controller //
public class UserAction{
	
	@Resource
	private UserService userService;
	//�û�ע��
	public void register(){
		HttpServletRequest request=ServletActionContext.getRequest();
		//�û��˺�
		String username = new String(request.getParameter("username"));
		//�û�������mac��ַ
		String userMac = new String(request.getParameter("user_mac"));
		//��ȡ��
		//System.out.println(username+"---"+userMac);
		String returnValue = null;
		//��ѯ�Ƿ��е�ǰ���û�
		StringBuilder proofRule = new StringBuilder(username.substring(0, 5) + userMac.substring(5, 15));
		String state = userService.register(username, userMac, proofRule.toString()); 
		if( state.equals("1") ){
			returnValue = "1"; //˵��ע��ɹ�
		}else{ 
			returnValue = "2"; //ע��ʧ��
		}
		//����¼�������
		
		HttpServletResponse response=ServletActionContext.getResponse();  
        response.setContentType("text/html");  
        PrintWriter out;  
        //��ȡ���������
        try {
			out = response.getWriter();
        	JSONObject json=new JSONObject();  
	        json.put("state", returnValue);
	        //��json���ݷŵ�������з���
	        out.println(json.toString());  
	        out.flush();  
	        out.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}
