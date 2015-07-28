package cn.zhang.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import cn.zhang.bean.Employee;
import cn.zhang.service.EmployeeService;

//����spring���й���
/*
 * ע�⣺�����������ǽ�action����spring���й����ʱ��spring��
 * ʹ�õ�����ģʽ���н���action��ʵ�����󣬵�����struts2����Ϊÿһ�ε����󶼻ᴴ��һ��
 * action�ģ���ô��ʱ���������Ҫ��struts2�����ò��ϣ���ô�����������ã�
 * ����������Ϊԭ�ͣ�@Scope("prototype")תΪԭ��ģʽ,��������ȷ����struts2�Ĳ���
 * 
 * ����ǵ���ģʽ��ô���action���ǲ���ȫ�ģ���Ϊ�����п��ܻᱻ�޸�
 * 
 * ����������������������������漰���������ݵ�actionһ��Ҫ����Ϊԭ��ģʽ
 * */
@Controller //employeeAddAtion
@Scope("prototype")
public class EmployeeAddAtion {
	
		//��EmployeeServiceҵ��bean����ע��
		@Resource
		private EmployeeService employeeService;
		//�������ڻ��ҳ�������
		private Employee employee;
		
		public Employee getEmployee() {
			return employee;
		}
		public void setEmployee(Employee employee) {
			this.employee = employee;
		}
		//����һ����ʾ��������ķ���
		public String addUI(){
			return "addUI";
		}
		//���崦����ӹ��ܸ��ķ���
		public String add(){
			
			try {
				employeeService.save(employee);
				
				List<Employee> emList=employeeService.list();
				ActionContext.getContext().put("employees", emList);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return "message";
		}
}
