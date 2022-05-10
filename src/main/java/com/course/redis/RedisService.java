package com.course.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import static com.course.util.JSONUtil.beanToString;
import static com.course.util.JSONUtil.stringToBean;


/**
 * @Describe: 类描述
 * @Author: tyf
 * @CreateTime: 2022/4/15
 **/
@Service
public class RedisService {

    @Autowired
    JedisPool jedisPool;


    public <T> T get(KeyPrefix prefix, String key, Class<T> clazz) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            String realKey = prefix.getPrefix() + key;
            T ret = stringToBean(jedis.get(realKey), clazz);
            return ret;
        } finally {
            returnToPool(jedis);
        }

    }

    /**
     * 设置单个对象
     *
     * @param prefix
     * @param key
     * @param value
     * @param <T>
     * @return
     */
    public <T> boolean set(KeyPrefix prefix, String key, T value) {
        Jedis jedis = null;
        try {
            int time = prefix.expireSecond();
            jedis = jedisPool.getResource();
            String str = beanToString(value);
            String realKey = prefix.getPrefix() + key;
            if (time <= 0) {
                jedis.set(realKey, str);
            } else {
                jedis.psetex(realKey, time * 1000, str);
            }
            return true;
        } finally {
            returnToPool(jedis);
        }
    }


    /**
     * 删除redis缓存数据
     *
     * @param prefix
     * @param key
     * @return
     */
    public boolean remove(KeyPrefix prefix, String key) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            //生成真正的key
            String realKey = prefix.getPrefix() + key;
            return jedis.del(realKey) > 0;
        } finally {
            returnToPool(jedis);
        }
    }

    /**
     * 判断key是否存在
     */
    public <T> boolean exists(KeyPrefix prefix, String key) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            //生成真正的key
            String realKey = prefix.getPrefix() + key;
            return jedis.exists(realKey);
        } finally {
            returnToPool(jedis);
        }
    }

    /**
     * 增加值
     */
    public <T> Long incr(KeyPrefix prefix, String key) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            //生成真正的key
            String realKey = prefix.getPrefix() + key;
            return jedis.incr(realKey);
        } finally {
            returnToPool(jedis);
        }
    }

    /**
     * 减少值
     */
    public <T> Long decr(KeyPrefix prefix, String key) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            //生成真正的key
            String realKey = prefix.getPrefix() + key;
            return jedis.decr(realKey);
        } finally {
            returnToPool(jedis);
        }
    }


    private void returnToPool(Jedis jedis) {
        if (jedis != null) {
            jedis.close();
        }
    }


}
