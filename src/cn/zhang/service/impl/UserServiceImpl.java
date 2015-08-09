package cn.zhang.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.zhang.bean.User;
import cn.zhang.bean.UserControl;
import cn.zhang.dao.UserDao;
import cn.zhang.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Resource  
	private UserDao userDao;

	//�û�ע��
	@Override
    public String register(String username, String userMac, String proofRule) {
		//�ȴ�userControl���л�ȡ��ǰusername�Ƿ����ע����ʸ�
		UserControl usercontrol = userDao.find_usercontrol(username);
		if( usercontrol!=null ){
			//˵���û����Ʊ����и��û������Խ���ע��
			User user = new User(username,userMac,usercontrol.getUserPermission(),proofRule);
		    userDao.save(user);
		}else{
			return "2"; //��ʾע��ʧ�ܣ�û���ʸ�ע��
		}
		return "1"; //��ʾע��ɹ�
		
	}
	
	
}
