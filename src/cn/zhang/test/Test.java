package cn.zhang.test;

import org.json.JSONException;
import org.json.JSONObject;

public class Test{

	@org.junit.Test
	public void TestJsonObject(){
		try {
			JSONObject ob = new JSONObject("111");  //�ᱨ���,��ʽ����
			System.out.println(ob.get("loginState"));
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

}
