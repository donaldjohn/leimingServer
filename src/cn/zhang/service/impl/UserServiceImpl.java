package cn.zhang.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.zhang.bean.User;
import cn.zhang.service.UserService;

/**
 * EmployeeService�ӿڵ�ʵ���࣬���������ʵ����Ӧ�Ĳ���
 * ͬʱ����ʹ�õ���ɨ���ע��ķ�ʽ���н�bean����spring����
 * ��������Ҫ��������ע��
 * */
//ֻҪ����ע����ôspring��ɨ�赽�����ʱ�򣬾ͻὫ����ཻ��spring�����ˣ�����spring������
//��һ���ģ�Ĭ�ϵ�bean�����ƾ��Ǹ���ļ�д��Ҳ�����������EmployeeServiceImpl
@Service
//��������ķ�����Ҫ������������,������������ע�������
@Transactional
public class UserServiceImpl implements UserService {

	/*
	 * ���Ҫ���ж����ݿ�Ĳ����������Ҫ��ȡsqlsession���󣬶���ȡsqlsession������
	 * ��Ҫ��ȡsqlsessionFactor�ж�����ô���Ǿ�Ҫע��sqlsession������
	 * */
	//����ʹ��ע��ķ�ʽ����sessionFactory����ע�����
	@Resource SessionFactory factory;
	public void save(User employee) {
		/*factory.openSession();
		������ֿ���һ���µ�session����������spring�����õ�aop���������
		�Լ��ǻ��Լ�����һ��session�ģ�����������½�һ���Ļ�����ôԭ��spring���������
		��������session�Ͳ�������
		��ô������εõ�spring��������ʱ������session��*/
		
		/*
		 * ������������ǻ�ȡspring��������ʱ������session����
			ȷ������ʵ��spring����������session�½��е�
		*/
		//�־û�����
		factory.getCurrentSession().persist(employee);//�ڲ���ʵ���ǵ��õ�save����
	}

	public void update(User employee) {
		factory.getCurrentSession().merge(employee);//����Ӧ����saveOrupdate()����
	}
	//���ĳһ�������ز���Ҫʹ��������й�����ô�������ø�
	//�����Ĵ������������������
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public User find(String username) {
		return (User) factory.getCurrentSession().get(User.class, username);
	}

	@SuppressWarnings("unchecked")
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<User> list() {
		//����һ����ѯ����
		//����ע���ǵ��õ�createQuery����������һ����createSQLQuery������޷��Զ�ת��Ϊʵ������Employee��
		//���������������createQuery�����ܹ�ֱ��ת��Ϊʵ������
		return factory.getCurrentSession().createQuery("from Employee").list();
	}

	public void delete(String... usernames) {
			for(String username:usernames){
				factory.getCurrentSession().delete(factory.getCurrentSession().load(User.class, username));
			}
	}
}
