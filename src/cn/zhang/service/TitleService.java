package cn.zhang.service;

import org.json.JSONException;
import org.json.JSONObject;

public interface TitleService {

    /**
     * ��ȡbeanList
     * @param type
     */
    JSONObject getList(String type) throws Exception ;

}
