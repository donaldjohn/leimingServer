package cn.zhang.service;

import cn.zhang.bean.UserControl;
import net.sf.json.JSONObject;


public interface UserControlService {

    /**
     * ��ȡbeanList
     * @param type
     */
    JSONObject getList(int start, int number) throws Exception ;
    
    /**
     * count�ϸ�list����������
     * @return
     * @throws Exception
     */
    int countList() throws Exception;
    
    /**
     * ��ȡһ����¼
     * @param id
     * @return
     * @throws Exception
     */
    UserControl getOne (String userName) throws Exception ;
    
    /**
     * ɾ������
     * @param userNames
     * @return
     * @throws Exception
     */
    public JSONObject delete(String[] userNames);
    
    /**
     * �޸�һ��
     * @param userControl
     * @return
     * @throws Exception
     */
    public JSONObject update(UserControl userControl);
    
    /**
     * ����һ��
     * @param userControl
     * @return
     * @throws Exception
     */
    public JSONObject addOne(UserControl userControl);

}
