package cn.zhang.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.zhang.bean.User;
import cn.zhang.bean.UserControl;
import cn.zhang.dao.UserDao;

@Service
@Transactional
public class UserDaoImpl implements UserDao {

	@Resource SessionFactory factory;
	public void save(User user) {
		//�־û�����
		factory.getCurrentSession().persist(user);//�ڲ���ʵ���ǵ��õ�save����
	}

	public void update(User user) {
		factory.getCurrentSession().merge(user);//����Ӧ����saveOrupdate()����
	}
	//���ĳһ�������ز���Ҫʹ��������й�����ô�������ø�
	//�����Ĵ������������������
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public User find(String username,String userMac,String proofRule) {
	    String hql="from User as user where user.userName=:userName and user.userMac=:userMac "
	    		+ "and user.proofRule=:proofRule";//ʹ�������������Ƽ�ʹ�ã��׶���
	    Query query=factory.getCurrentSession().createQuery(hql);
	    query.setString("userName", username);
	    query.setString("userMac", userMac);
	    query.setString("proofRule", proofRule);
	    List<User> userList = query.list();
	    if( userList.size() > 0 ){
	    	return userList.get(0);
	    }
    	return null;
	}
	//���ض�Ӧusername������
	public UserControl find_usercontrol(String username){
		String hql="from UserControl as usercontrol where usercontrol.userName=:userName ";//ʹ�������������Ƽ�ʹ�ã��׶���
	    Query query=factory.getCurrentSession().createQuery(hql);
	    query.setString("userName", username);
	    List<UserControl> userList = query.list();
	    if( userList.size() > 0 ){
	    	return userList.get(0);
	    }
		return null;
	}
	
	public void delete(String... ids) {
			for(String id:ids){
				factory.getCurrentSession().delete(factory.getCurrentSession().load(User.class, id));
			}
	}


}
