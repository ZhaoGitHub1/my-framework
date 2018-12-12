package cn.com.yizhu.utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Redis工具类
 */
public class RedisUtils {

    public static JedisPoolConfig jedisPoolConfig;
    public static JedisPool jedisPool;

    static {
        jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(10);
        jedisPoolConfig.setMaxWaitMillis(1000);
    }

    /**
     * 从连接池获取指定host的jedis客户端，端口为默认值6379
     * @param host
     * @return
     */
    public static Jedis getJedis(String host){
        jedisPool = new JedisPool(jedisPoolConfig, host);
        return jedisPool.getResource();
    }


}
