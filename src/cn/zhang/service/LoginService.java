package cn.zhang.service;

import cn.zhang.bean.User;

/**
 * ��¼�����service
 * */
public interface LoginService {

	public User login(String username,String userMac,String proofRule);
	
}
