package cn.zhang.service;

import java.util.List;

import cn.zhang.bean.User;

/**
 * �ṩ��Employee��service�Ľӿڹ���
 * */
public interface UserService {

		public void save(User employee);
		public void update(User employee);
		public User find(String username);
		//ʹ�ö�̬����
		public void delete(String ...usernames);
		public List<User> list(); 
}
