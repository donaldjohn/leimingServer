package cn.zhang.bean;

/**
 * �û�������Ʊ�ֻ���ڸı��е�username���ܽ�����ӵ�user����
 * */
public class UserControl {

	private String userName; //�û���
	private String userPermission;
	
	public UserControl(){}
	public UserControl(String userName, String userPermission) {
		super();
		this.userName = userName;
		this.userPermission = userPermission;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPermission() {
		return userPermission;
	}
	public void setUserPermission(String userPermission) {
		this.userPermission = userPermission;
	}
	
	
}
