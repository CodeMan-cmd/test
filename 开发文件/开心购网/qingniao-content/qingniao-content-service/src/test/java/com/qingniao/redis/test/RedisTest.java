package com.qingniao.redis.test;

import java.util.HashSet;
import java.util.Set;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

public class RedisTest {

	public static void main(String[] args) {
		Set<HostAndPort> nodes = new HashSet<>();
		nodes.add(new HostAndPort("192.168.128.128", 7001));
		nodes.add(new HostAndPort("192.168.128.128", 7002));
		nodes.add(new HostAndPort("192.168.128.128", 7003));
		nodes.add(new HostAndPort("192.168.128.128", 7004));
		nodes.add(new HostAndPort("192.168.128.128", 7005));
		nodes.add(new HostAndPort("192.168.128.128", 7006));
		JedisCluster jedisCluster = new JedisCluster(nodes);
		// 第二步：直接使用JedisCluster对象操作redis。在系统中单例存在。
		jedisCluster.set("hello", "100");
		String result = jedisCluster.get("hello");
		// 第三步：打印结果
		System.out.println(result);
		// 第四步：系统关闭前，关闭JedisCluster对象。
		jedisCluster.close();
		
		

	}
}
