package cn.zhang.bean;

/**
 * �û���
 * */
public class User {

	private String username; //�û���
	private String user_mac; //�û��ֻ���mac��ַ
	/*
	 * �û���Ȩ�ޣ������ܹ�ʹ����Щ����
	 * ���������صĸ�ʽ��{permission:"Ȩ��1��Ȩ��2";}
	 * */
	private String user_permission;
	
	public User(){}
	public User(String username, String user_mac,String user_permission) {
		super();
		this.username = username;
		this.user_mac = user_mac;
		this.user_permission = user_permission;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUser_mac() {
		return user_mac;
	}
	public void setUser_mac(String user_mac) {
		this.user_mac = user_mac;
	}
	public String getUser_permission() {
		return user_permission;
	}
	public void setUser_permission(String user_permission) {
		this.user_permission = user_permission;
	}
	
	
}
