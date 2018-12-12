package cn.com.yizhu.utils;

import redis.clients.jedis.Jedis;

public class RedisUtilsTest {

    public static void main(String[] args) {

        Jedis jedis = RedisUtils.getJedis("127.0.0.1");
        System.out.println(jedis.keys("*"));
    }
}
