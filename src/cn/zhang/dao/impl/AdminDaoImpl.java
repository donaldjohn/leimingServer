package cn.zhang.dao.impl;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.zhang.dao.AdminDao;

@Service
@Transactional
public class AdminDaoImpl implements AdminDao {
    
    @Resource SessionFactory factory;

    /**
     * ��¼У��
     * @param loginName
     * @param password
     * @return
     */
    public boolean checkLogin(String loginName,String password) {
        String sql="select count(*) from Admin as a where a.loginName=:loginName and a.password=:password";//ʹ�������������Ƽ�ʹ�ã��׶���
        Query query=factory.getCurrentSession().createSQLQuery(sql);
        query.setString("loginName", loginName);
        query.setString("password", password);
        
        int count=((Number)query.uniqueResult()).intValue();//��ȡ��¼�������ݲ�ͬ�汾Hibernateд��
        return count>0;
    }
}
