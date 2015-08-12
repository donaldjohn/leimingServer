package cn.zhang.action;

import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import cn.zhang.bean.UserControl;
import cn.zhang.service.UserControlService;

import com.opensymphony.xwork2.ModelDriven;

@Controller
public class UserControlAction extends BaseAction implements ModelDriven<UserControl>{
    
    private UserControl userControl=new UserControl();
    @Override
    public UserControl getModel() {
        return userControl;
    }
    
    @Resource
    private UserControlService userControlService;
    
    //��̨�õģ����UserControllist
    public void getListJson() throws Exception{
        //1 ���÷�ҳ����
        //��ǰҳ           
        int intPage = Integer.parseInt((page == null || page == "0") ? "1":page);            
        //ÿҳ��ʾ����            
        int number = Integer.parseInt((rows == null || rows == "0") ? "10":rows); 
        //ÿҳ�Ŀ�ʼ��¼  ��һҳΪ1  �ڶ�ҳΪnumber +1
        int start = (intPage-1)*number;
        
        JSONObject json = userControlService.getList(start, number);//������
        //���ؽ��
        HttpServletResponse response=ServletActionContext.getResponse();  
        response.setContentType("application/json;charset=UTF-8");
        response.setContentType("");
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
        JSONObject json=JSONObject.fromObject(userControlService.getOne(userControl.getUserName()));
        //���ؽ��
        HttpServletResponse response=ServletActionContext.getResponse();  
        response.setContentType("application/json");
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
            String userNames = ServletActionContext.getRequest().getParameter("userNames");
            //���ؽ��
            HttpServletResponse response=ServletActionContext.getResponse();  
            response.setContentType("application/json");
            out = response.getWriter();
            out.write(userControlService.delete(userNames.split(",")).toString());
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
            response.setContentType("application/json");
            out = response.getWriter();
            JSONObject json=null;
            if (StringUtils.isBlank(userControl.getUserName())||StringUtils.isBlank(userControl.getUserPermission())) {
                json=new JSONObject();
                json.put("state", 0); //0ʧ��
            }else{
                json=userControlService.update(userControl);
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
            if (StringUtils.isBlank(userControl.getUserName())||StringUtils.isBlank(userControl.getUserPermission())) {
                json=new JSONObject();
                json.put("state", 0); //0ʧ��
            }else if(null!=userControlService.getOne(userControl.getUserName())){
                json=new JSONObject();
                json.put("state", 3); //3�ظ�
            }else{
                json=userControlService.addOne(userControl);
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
