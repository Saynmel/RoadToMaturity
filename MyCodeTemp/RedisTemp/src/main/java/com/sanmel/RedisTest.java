package com.sanmel;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Tuple;

import java.util.*;

/**
 * @ Description:
 * @ Author: yanhao
 * @ Date: 2018/8/17 11:59
 **/
public class RedisTest {
    private Jedis jedis;

    /**
     * 连接redis服务器
     */
    public void connectRedis() {
        jedis = RedisUtil.getJedis();
    }

    /**
     * redis操作map集合
     */
    public void testMap() {
        //添加数据
        Map<String, String> map = new HashMap<String, String>();

        map.put("name", "yc");
        map.put("age", "22");
        map.put("qq", "1933108196");
        jedis.hmset("user", map);

        //取出users中的Name,执行结果:[minxr]-->注意结果是一个泛型的List
        //第一个参数是存入redis中map对象的key,后面跟的是放入map中对象的key,后面的key可以是多个，是可变的
        List<String> rsmap = jedis.hmget("user", "name", "age");
        System.out.println(rsmap);


        //删除map中的某个键值
//        jedis.hdel("user", "age");
//        System.out.println(jedis.hmget("user", "age"));//因为删除了，所以返回的是Null
//        System.out.println(jedis.hlen("user"));//返回key为user的键中存放的值的个数2
//        System.out.println(jedis.exists("user"));//是否存在key为user的记录，返回true
//        System.out.println(jedis.hkeys("user"));//返回map对象中的所有key
//        System.out.println(jedis.hvals("user"));//返回map对象中的所有value
//
//        Iterator<String> iter = jedis.hkeys("user").iterator();
//        while (iter.hasNext()) {
//            String key = iter.next();
//            System.out.println(key + ":" + jedis.hmget("user", key));
//        }
    }

    /**
     * redis操作List集合
     */
    public void testList() {
        //开始前，先移除所有的内容
        jedis.del("java framework");
        System.out.println(jedis.lrange("java framework", 0, -1));

        //先向key java framework 中存放三条数据
        jedis.lpush("java framework", "spring");
        jedis.lpush("java framework", "struts");
        jedis.lpush("java framework", "hibernate");

        //再取出所有数据jedis.lrange是按范围取出
        //第一个是key,第二个是起始位置，第三个是结束位置，jedis.llen获取长度 -1表示取得所有
        System.out.println(jedis.lrange("java framework", 0, -1));

        jedis.del("java framework");
        jedis.rpush("java framework", "spring");
        jedis.rpush("java framework", "struts");
        jedis.rpush("java framework", "hibernate");
        System.out.println(jedis.lrange("java framework", 0, -1));
    }


    /**
     * redis操作set集合
     */

    public void testSet() {

        //添加
        jedis.sadd("user", "liuling");
        jedis.sadd("user", "xinxin");
        jedis.sadd("user", "ling");
        jedis.sadd("user", "zhangxinxin");
        jedis.sadd("user", "who");

        //删除
        jedis.srem("user", "who");
        System.out.println(jedis.smembers("user"));//获取所有加入的value
        System.out.println(jedis.sismember("user", "who"));//判断who是否是user集合的元素
        System.out.println(jedis.srandmember("user"));
        System.out.println(jedis.scard("user"));//返回集合的元素个数
    }


    /**
     * redis排序
     */
    public void testSort() {
        //jedis 排序
        //注意，此处的rpush和lpush是List的操作。是一个双向链表（但从表现来看的)
        jedis.del("a");//先清除数据，再加入数据进行测试
        jedis.rpush("a", "1");
        jedis.lpush("a", "6");
        jedis.lpush("a", "3");
        jedis.lpush("a", "9");
        System.out.println(jedis.lrange("a", 0, -1));
        System.out.println(jedis.sort("a"));//[1,3,6,9] //输入排序后结果
        System.out.println(jedis.lrange("a", 0, -1));
    }


    public void testZSet() {
        jedis.del("zset");
        Map<String, Double> zset1 = new HashMap<String, Double>();
        zset1.put("1", 9D);
        zset1.put("2", 7D);
        zset1.put("3", 5D);
        zset1.put("4", 6D);
        zset1.put("5", 8D);
        jedis.zadd("zset", zset1);
        System.out.println(jedis.zrange("zset", 0, -1));

        //返回有序集合包含的成员数量
        System.out.println(jedis.zcard("zset"));

        //从有序集合里面移除给定的成员，并返回被移除成员的数量
        System.out.println(jedis.zrem("zset", "3"));
        System.out.println(jedis.zrange("zset", 0, -1));
        jedis.zadd("zset", 5D, "3");
        System.out.println(jedis.zrange("zset", 0, -1));

        //将member成员的分值加上score
//        System.out.println(jedis.zincrby("zset", 2, "5"));
//        System.out.println(jedis.zrange("zset", 0, -1));

        //返回分值介于min和max之间的成员数量，包括min和max在内
        System.out.println(jedis.zcount("zset", 6D, 8D));

        //返回成员member在有序集合中的排名，成员按照分值从小到大排列 从0开始
        System.out.println(jedis.zrank("zset", "4"));

        //返回成员member在有序集合中的排名，成员按照分值从大到小排列 从0开始
        System.out.println(jedis.zrevrank("zset", "4"));

        //返回成员member的分值
        System.out.println(jedis.zscore("zset", "4"));

        //返回分值介于min和max之间的成员，包括min和max在内
        System.out.println(jedis.zrangeByScore("zset", 6, 8));

        //返回分值介于min和max之间的成员对象，包括min和max在内
        Set<Tuple> sets = jedis.zrangeByScoreWithScores("zset", 6, 8);
        Iterator<Tuple> iterable = sets.iterator();
        while (iterable.hasNext()){
            Tuple tuple = iterable.next();
            System.out.println("Element:"+tuple.getElement()+", Score:"+tuple.getScore()+", BinaryElement:"+tuple.getBinaryElement());
        }


        Set<Integer> set = new HashSet<Integer>();

    }

    public static void main(String[] args) {
        RedisTest redisTest = new RedisTest();
        redisTest.connectRedis();
        //redisTest.testMap();
        redisTest.testZSet();
    }
}
