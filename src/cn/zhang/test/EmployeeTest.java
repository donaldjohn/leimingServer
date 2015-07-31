package cn.zhang.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.zhang.bean.User;
import cn.zhang.service.UserService;

/**
 * �ò��������ڽ��в���spring��hibernate�Ľ���Ƿ�ɹ�
 * ���Ա�׼�����ܹ�����Employee��hbm.xml�ļ�������Ӧ�ı�
 * 
 * ��Ҫʵ����spring����������
 * */
public class EmployeeTest {

	private static UserService employeeService;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		//���ڸ÷���ʵ�����еĲ���ִ��ǰ���еĲ������������������ｫ��Щ����
		//�Ƶ��������������test�����Ϳ���ֱ������
		try {
			ApplicationContext act=new ClassPathXmlApplicationContext("beans.xml");
			employeeService=(UserService) act.getBean("employeeServiceImpl");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test() {
		//���������ʹ����·���µ�xml�ļ�����ʵ����
		//��������ʵ����spring�����ˣ���spring����������sessionFactory��Ȼ�ͻᱻ����
		//Ȼ�����������beans��sessionFactory������hibernate.hbm2ddl.auto=update
		//���Զ��Ľ��д�����Ӧ�ı�
		new ClassPathXmlApplicationContext("beans.xml");
	}
	@Test 
	public void save(){
		employeeService.save(new User("chun","123"));
	}
	@Test 
	public void update(){
		User eml=employeeService.find("zhang");
		eml.setUserpass("1111");
		employeeService.update(eml);
	}
	@Test 
	public void find(){
		User el=employeeService.find("zhang");
		System.out.println(el.getUserpass());
	}
	@Test 
	public void delete(){
		employeeService.delete("zhang");
	}
	@Test 
	public void list(){
		List<User> elList=employeeService.list();
		System.out.println(elList.size());
		for(User em:elList){
			System.out.println(em.getUserpass());
			System.out.println("--");
		}
	}
}
