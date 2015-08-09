package cn.zhang.service;

import cn.zhang.bean.Title;
import net.sf.json.JSONObject;


public interface TitleService {

    /**
     * ��ȡbeanList
     * @param type
     */
    JSONObject getList(String type) throws Exception ;
    /**
     * ��ȡbeanList
     * @param type
     */
    JSONObject getList(String type, int start, int number) throws Exception ;
    
    /**
     * count�ϸ�list����������
     * @param type
     * @return
     * @throws Exception
     */
    int countList(String type) throws Exception;
    
    /**
     * ��ȡһ����¼
     * @param id
     * @return
     * @throws Exception
     */
    Title getOne (Integer id) throws Exception ;
    
    /**
     * ɾ������
     * @param ids
     * @return
     * @throws Exception
     */
    public JSONObject delete(String[] ids);
    
    /**
     * �޸�һ��
     * @param title
     * @return
     * @throws Exception
     */
    public JSONObject update(Title title);
    
    /**
     * ����һ��
     * @param title
     * @return
     * @throws Exception
     */
    public JSONObject addOne(Title title);

}
