package cn.zhang.service;

import java.util.List;

import cn.zhang.bean.Employee;

/**
 * �ṩ��Employee��service�Ľӿڹ���
 * */
public interface EmployeeService {

		public void save(Employee employee);
		public void update(Employee employee);
		public Employee find(String username);
		//ʹ�ö�̬����
		public void delete(String ...usernames);
		public List<Employee> list(); 
}
