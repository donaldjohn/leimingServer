package cn.zhang.bean;

/**
 * �û���
 * */
public class User {

	private String userName; //�û���
	private String userMac; //�û��ֻ���mac��ַ
	/*
	 * �û���Ȩ�ޣ������ܹ�ʹ����Щ����
	 * ���������صĸ�ʽ��{permission:"Ȩ��1��Ȩ��2";}
	 * */
	private String userPermission;
	/*
	 * ��֤������Ϊ�û�����mac��ַ���п��ܱ�α�죬����������
	 * ��ע���ʱ��ͻ���и����û�����mac��ַ����һ���й����string
	 * Ȼ���ڵ�¼�İ�ͬ���Ĺ�����ݴ��ݹ������û�����mac��������stringȻ��
	 * �����ݿ��еıȶԣ��Ѵﵽ��֤��Ŀ��
	 * */
	private String proofRule; 
	
	public User(){}
	public User(String userName, String userMac,String userPermission,String proofRule) {
		super();
		this.userName = userName;
		this.userMac = userMac;
		this.userPermission = userPermission;
		this.proofRule = proofRule;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserMac() {
		return userMac;
	}
	public void setUserMac(String userMac) {
		this.userMac = userMac;
	}
	public String getUserPermission() {
		return userPermission;
	}
	public void setUserPermission(String userPermission) {
		this.userPermission = userPermission;
	}
	public String getProofRule() {
		return proofRule;
	}
	public void setProofRule(String proofRule) {
		this.proofRule = proofRule;
	}
	
	
	
}
