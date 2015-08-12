package cn.zhang.action;

import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import cn.zhang.bean.Admin;
import cn.zhang.dao.AdminDao;

import com.opensymphony.xwork2.ModelDriven;

/**
 * ��̨����Ա
 * 
 * @author ZhangYaxu
 * @date 2015��8��6��
 */
@Controller
public class AdminAction implements ModelDriven<Admin>{
    private Admin admin=new Admin();
    @Override
    public Admin getModel() {
        return admin;
    }
    
    @Resource
    private AdminDao adminDao;
    
    /**
     * ����½ҳ��
     * @return
     * @throws Exception
     */
    public String login()throws Exception{
        return "login";
    }
    
    /**
     * ע��
     * @return
     * @throws Exception
     */
    public String logout()throws Exception{
        HttpSession session=ServletActionContext.getRequest().getSession();
        if (null!=session.getAttribute("admin")) {
            session.removeAttribute("admin");
        }
        return "login";
    }
    
    /**
     * ��½
     * @throws Exception
     */
    public void loginSubmit()throws Exception{
        boolean canLogin=adminDao.checkLogin(admin.getLoginName(), admin.getPassword());
        if(canLogin){
            PrintWriter writer=ServletActionContext.getResponse().getWriter();
            HttpServletRequest request=ServletActionContext.getRequest();
            request.getSession().setAttribute("admin", admin);
            writer.write(request.getContextPath()+"/admin_framehome");
            writer.flush();
            writer.close();
        }
    }
    
    public String framehome() throws Exception{
        Admin sessionAdmin=(Admin)ServletActionContext.getRequest().getSession().getAttribute("admin");
        if(null==sessionAdmin){
            return "login";
        }
        return "framehome";
    }

}
