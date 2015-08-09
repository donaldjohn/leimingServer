package cn.zhang.service.impl;

import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Service;

import cn.zhang.bean.Title;
import cn.zhang.dao.TitleDao;
import cn.zhang.service.TitleService;

@Service
public class TitleServiceImpl implements TitleService {
    
    @Resource
    private TitleDao titleDao;

    @Override
    public JSONObject getList(String type) throws Exception {
        //DAO����
        List<Title> list=titleDao.getList(type);
        JSONObject json=new JSONObject();
        if (list.size()<=0) {
            json.put("state", 3); //3����û�ж�Ӧ���͵�����
            return json;
        }
        json.put("rows", list);
        json.put("state", 1); //1���������ݳɹ�
        return json;
    }
    
    @Override
    public JSONObject getList(String type, int start, int number)
            throws Exception {
      //DAO����
        List<Title> list=titleDao.getList(type, start, number);
        int total=titleDao.count(type);
        JSONObject json=new JSONObject();
        if (list.size()<=0) {
            json.put("state", 3); //3����û�ж�Ӧ���͵�����
            return json;
        }
        json.put("rows", list);
        json.put("total", total);
        json.put("state", 1); //1���������ݳɹ�
        return json;
    }
    
    @Override
    public int countList(String type) throws Exception {
        return titleDao.count(type);
    }

    @Override
    public Title getOne(Integer id) throws Exception {
        return titleDao.getOne(id);
    }

    @Override
    public JSONObject delete(String[] ids){
        JSONObject json=new JSONObject();
        try {
            titleDao.delete(ids);
            json.put("state", 1); //1���������ݳɹ�
        } catch (Exception e) {
            json.put("state", 0); //0ʧ��
            return json;
        }
        return json;
    }

    @Override
    public JSONObject update(Title title){
        JSONObject json=new JSONObject();
        try {
            titleDao.update(title);
            json.put("state", 1); //1���������ݳɹ�
        } catch (Exception e) {
            json.put("state", 0); //0ʧ��
            return json;
        }
        return json;
    }

}
