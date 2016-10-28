package com.xinchen.ssm.json.demo.main;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.xinchen.ssm.json.demo.model.Group;
import com.xinchen.ssm.json.demo.model.User;
import com.xinchen.ssm.json.demo.model.Weibo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 这是关于FastJson的一个使用Demo，在Java环境下验证的；
 * 使用的时候可以参照这个例子进行回忆！
 * 备注：下面写的Json格式的数据"前面的\，意思是告诉编译器忽略掉它后面的"。
 * 后面定义有三个类：User、Group、Weibo
 * Created by ChenXin on 2016/10/13.
 */
public class DemoMain {
    public static void main(String[] args) {
        json2JsonObjectM1();    //xinchen
        json2BeanM2();          //Weibo{id='1234', city='艾泽拉斯'}
        json2JSONArrayM3();
        json2JavaBeanM4();
        bean2JsonM5();
        bean2JSONObjectM6();
        complexExampleM7();
        complexObject2JsonM8(); //{"id":1,"list":[{"id":2,"name":"user1"},{"id":3,"name":"user2"}],"name":"group"}
        complexMap2JsonM9();    //{1:"No.1",2:"No.2",3:[{"id":2,"name":"user1"},{"id":3,"name":"user2"}]}
    }

    //JSON ----->  JsonObject      Map获值
    private static void json2JsonObjectM1() {
        String s = "{\"name\":\"xinchen\"}";        //{"name":"xinchen"}
        JSONObject object = JSON.parseObject(s);
        System.out.println("JSON ------>  JsonObject:      " + object.get("name"));//xinchen
    }

    //JSON ------>   JavaBean        JSON文本中健名得与JAVABEAN字段一致
    private static void json2BeanM2() {
        String s = "{\"id\":\"1234\",\"city\":\"艾泽拉斯\"}";   //{"id":"1234","city":"艾泽拉斯"}
        Weibo weibo = JSON.parseObject(s, Weibo.class);
        System.out.println("JSON ------>   JavaBean:        " + weibo);//Weibo{id='1234', city='艾泽拉斯'}
    }

    //Map  ------>   JsonString
    private static void complexMap2JsonM9() {
        Group group = new Group();
        group.setId(1);
        group.setName("group");

        User user1 = new User();
        user1.setId(2);
        user1.setName("user1");

        User user2 = new User();
        user2.setId(3);
        user2.setName("user2");
        group.getList().add(user1);
        group.getList().add(user2);

        Map<Integer, Object> map = new HashMap<Integer, Object>();
        map.put(1, "No.1");
        map.put(2, "No.2");
        map.put(3, group.getList());

        String jsonString = JSON.toJSONString(map);
        System.out.println("Map  ------>   JsonString: " + jsonString);//{1:"No.1",2:"No.2",3:[{"id":2,"name":"user1"},{"id":3,"name":"user2"}]}
    }

    //Object  ------>   Json
    private static void complexObject2JsonM8() {
        Group group = new Group();
        group.setId(1);
        group.setName("group");

        User user1 = new User();
        user1.setId(2);
        user1.setName("user1");

        User user2 = new User();
        user2.setId(3);
        user2.setName("user2");

        group.getList().add(user1);
        group.getList().add(user2);

        String jsonString = JSON.toJSONString(group);
        System.out.println("Object  ------>   JsonString: " + jsonString);//{"id":1,"list":[{"id":2,"name":"user1"},{"id":3,"name":"user2"}],"name":"group"}
    }

    //JSONObject --->  JSONArray  ---> JavaBean
    private static void complexExampleM7() {
        String s = "{js:[{id:\"110000\",\"city\":\"北#001京市\"},{id:\"110000\",\"city\":\"北#002京市\"}"
                + ",{id:\"110000\",\"city\":\"北#002京市\"},{id:\"110000\",\"city\":\"北#002京市\"},"
                + "{id:\"110000\",\"city\":\"#006北#005京市\"},"
                + "{id:\"110000\",\"city\":\"北#002京市\"},"
                + "{id:\"110000\",\"city\":\"北#002京市\"},{id:\"120000\",\"city\":\"天#009津市\"}]}";

        JSONObject object = JSON.parseObject(s);

        Object jsonArray = object.get("js");
        System.out.println("JSONObject --->  JSONArray  ---> JavaBean:");
        System.out.println("jsonArray:" + jsonArray);
        //[{"city":"北#001京市","id":"110000"},
        // {"city":"北#002京市","id":"110000"},
        // {"city":"北#002京市","id":"110000"},
        // {"city":"北#002京市","id":"110000"},
        // {"city":"#006北#005京市","id":"110000"},
        // {"city":"北#002京市","id":"110000"},
        // {"city":"北#002京市","id":"110000"},
        // {"city":"天#009津市","id":"120000"}]
        List<Weibo> list = JSON.parseArray(jsonArray + "", Weibo.class);
        for (Weibo weibo : list) {
            System.out.println(weibo);
        }


    }
    //JavaBean --->   JSON
    private static void bean2JSONObjectM6(){
        Weibo weibo  = new Weibo("0373","洛阳");
        JSONObject json = (JSONObject) JSON.toJSON(weibo);
        System.out.println("JavaBean --->   JSON:"+json.toString());
    }
    //JSON --->   JaveBeanList
    private static void json2JavaBeanM4(){
        String s = "[{\"id\":\"0375\",\"city\":\"平顶山\"},{\"id\":\"0377\",\"city\":\"南阳\"}]";
        List<Weibo> list = JSON.parseArray(s, Weibo.class);
        for (Weibo weibo : list) {
            System.out.println("JSON --->   JaveBeanList:"+weibo);
        }
    }
    //JSON --->   JSONArray
    private static void json2JSONArrayM3(){
        String s = "[{\"id\":\"0375\",\"city\":\"平顶山\"},{\"id\":\"0377\",\"city\":\"南阳\"}]";
        //将JSON文本转换为JSONArray
        JSONArray array = JSON.parseArray(s);
        //这行必须写：必须加上+"";不然会报出类型强转异常！
        String str = array.get(1)+"";
        System.out.println(array.get(0));
        JSONObject object = JSON.parseObject(str);
        System.out.println(object.get("id"));
    }
    //Bean --->   JSON
    private static void bean2JsonM5(){
        Weibo weibo = new Weibo("123456", "上海");
        String string = JSON.toJSONString(weibo);
        System.out.println(string);
    }
}
