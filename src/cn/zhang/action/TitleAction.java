package cn.zhang.action;

import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.xwork.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;

import cn.zhang.service.TitleService;

@Controller
public class TitleAction {
    @Resource
    private TitleService titleService;
    
    //�û�ע��
    public void getList() throws Exception{
        HttpServletRequest request=ServletActionContext.getRequest();
        //����
        String type = request.getParameter("type");
        //������
        JSONObject json=null;
        if (StringUtils.isBlank(type)) {
            json= new JSONObject().put("state", 1);
        }else{
            json = titleService.getList(type);
        }
        //���ؽ��
        HttpServletResponse response=ServletActionContext.getResponse();  
        response.setContentType("text/html");
        PrintWriter out=null;  
        try {
            out = response.getWriter();
            out.println(json.toString());  
            out.flush();  
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            out.close();
        }  
    }
}
