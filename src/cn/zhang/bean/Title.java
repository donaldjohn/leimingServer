package cn.zhang.bean;

import java.util.Date;
import sun.security.ec.ECKeyFactory;
/**
 * ��Ŀ�ʹ���
 * 
 * @author ZhangYaxu
 * @date 2015��8��5��
 */
public class Title{
    private Integer id;
    private String type;
    private String title;
    private String content;
    private Date operateTime;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(Date operateTime) {
        this.operateTime = operateTime;
    }
}
