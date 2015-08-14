package cn.zhang.action;

import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import cn.zhang.bean.Title;
import cn.zhang.service.TitleService;

import com.opensymphony.xwork2.ModelDriven;

@Controller
public class TitleAction extends BaseAction implements ModelDriven<Title>{
    
    private Title title=new Title();
    @Override
    public Title getModel() {
        return title;
    }
    
    @Resource
    private TitleService titleService;
    
    //ǰ̨�����Titlelist
    public void getList() throws Exception{
        HttpServletRequest request=ServletActionContext.getRequest();
        //����
        String type = request.getParameter("type");
        //������
        JSONObject json=null;
        if (StringUtils.isBlank(type)) {
            json= new JSONObject();
            json.put("state", 4); //4����type����Ϊ��
        }else{
            json = titleService.getList(type);
        }
        //��ֹ����
        String outMessage = json.toString();
        outMessage=new String(outMessage.getBytes("GB2312"),"ISO-8859-1"); 
        //���ؽ��
        HttpServletResponse response=ServletActionContext.getResponse();  
        response.setContentType("text/html");
        PrintWriter out=null;  
        try {
            out = response.getWriter();
            out.println(outMessage);  
            out.flush();  
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            out.close();
        }  
    }
    
    //��̨�õģ����Titlelist
    public void getListJson() throws Exception{
        HttpServletRequest request=ServletActionContext.getRequest();
        String type = request.getParameter("type");//����
        
        //1 ���÷�ҳ����
        //��ǰҳ           
        int intPage = Integer.parseInt((page == null || page == "0") ? "1":page);            
        //ÿҳ��ʾ����            
        int number = Integer.parseInt((rows == null || rows == "0") ? "10":rows); 
        //ÿҳ�Ŀ�ʼ��¼  ��һҳΪ1  �ڶ�ҳΪnumber +1
        int start = (intPage-1)*number;
        
        
        JSONObject json = titleService.getList(type, start, number);//������
        //���ؽ��
        HttpServletResponse response=ServletActionContext.getResponse();  
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out=null;  
        try {
            out = response.getWriter();
            out.write(json.toString());
            out.flush();  
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            out.close();
        }  
    }   
    
    /**
     * ���One
     * @throws Exception
     */
    public void getOne() throws Exception{
        JSONObject json=JSONObject.fromObject(titleService.getOne(title.getId()));
        //���ؽ��
        HttpServletResponse response=ServletActionContext.getResponse();  
        response.setContentType("application/json;");
        PrintWriter out=null;  
        try {
            out = response.getWriter();
            out.write(json.toString());
            out.flush();  
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            out.close();
        }  
    }
    
    /**
     * ɾ��
     */
    public void delete(){
        PrintWriter out=null;  
        try {
            String ids = ServletActionContext.getRequest().getParameter("ids");
            //���ؽ��
            HttpServletResponse response=ServletActionContext.getResponse();  
            response.setContentType("application/json;");
            out = response.getWriter();
            out.write(titleService.delete(ids.split(",")).toString());
            out.flush();  
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            out.close();
        }  
    }
    
    /**
     * udpateOne
     * @throws Exception
     */
    public void udpateOne() throws Exception{
        PrintWriter out=null;  
        try {
            HttpServletResponse response=ServletActionContext.getResponse();  
            response.setContentType("application/json;");
            out = response.getWriter();
            JSONObject json=null;
            if (null==title.getId()||StringUtils.isBlank(title.getType())||StringUtils.isBlank(title.getTitle())||StringUtils.isBlank(title.getContent())) {
                json=new JSONObject();
                json.put("state", 0); //0ʧ��
            }else{
                json=titleService.update(title);
            }
            out.write(json.toString());
            out.flush();  
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            out.close();
        }  
    }
    
    /**
     * ����
     */
    public void addOne(){
        PrintWriter out=null;  
        try {
            HttpServletResponse response=ServletActionContext.getResponse();  
            response.setContentType("application/json");
            out = response.getWriter();
            JSONObject json=null;
            if (StringUtils.isBlank(title.getType())||StringUtils.isBlank(title.getTitle())||StringUtils.isBlank(title.getContent())) {
                json=new JSONObject();
                json.put("state", 0); //0ʧ��
            }else{
                json=titleService.addOne(title);
            }
            out.write(json.toString());
            out.flush();  
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            out.close();
        }
    }

}
