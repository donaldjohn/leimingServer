package cn.zhang.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import cn.zhang.service.EmployeeService;

/**
 * �����action����spring���й���ͨ��ע��ķ�ʽ
 * 
 * ͬʱ�������ｫaction��ʵ��������spring����ô����Ϳ�������spring��
 * ����ע�뽫 ҵ��bean ע�����
 * */
@Controller //employeeAction(Ĭ�ϵ�bean������)
public class EmployeeAction {

		//����spring������ע��ԭ��ҵ��beanע�����
		@Resource
		EmployeeService employeeService;
		//action��Ĭ��ִ�к���
		public String execute(){
			//�ڽ�Ա����Ϣ�б����ݣ�����request����Χ��
			ActionContext.getContext().put("employees", employeeService.list());
			return "list";
		}
}
