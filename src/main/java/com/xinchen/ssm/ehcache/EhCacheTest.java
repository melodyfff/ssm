package com.xinchen.ssm.ehcache;

/**
 * Created by wow on 2016/11/2.
 */
public class EhCacheTest {
    public static void main(String[] args) {
        String test = "test";
        EhCacheManager.put("test",test);
        String s1 = EhCacheManager.get("test");
        String s2 = EhCacheManager.get("test");
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());


    }
}
