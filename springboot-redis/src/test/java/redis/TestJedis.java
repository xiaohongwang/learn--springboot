//package redis;
//
//import org.junit.Test;
//import redis.clients.jedis.*;
//
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//
///**
// * Created by xiaohong on 2017/11/22.
// */
//public class TestJedis {
//    public static void main(String[] args){
//        Jedis jedis = new Jedis("192.168.26.133",6379);
//
//        //设置单个值
//        jedis.set("name","xiaoxiao");
//        System.out.println(jedis.get("name"));
//        jedis = new Jedis("192.168.26.133",6380);
//        System.out.println(jedis.get("name"));
//        jedis = new Jedis("192.168.26.133",6381);
//        System.out.println(jedis.get("name"));
//    }
//
//    @Test
//    public void test(){
//        //构建连接池配置信息
//        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
//        //设置最大连接数
//        jedisPoolConfig.setMaxTotal(200);
//
//        //构建连接池
//        JedisPool jedisPool = new JedisPool(jedisPoolConfig,"192.168.26.133",6380);
//
//        //从连接池中获取连接
//        Jedis jedis = jedisPool.getResource();
//
//        System.out.println(jedis.get("name"));
//
//        //将连接归还到连接池
//        jedisPool.returnResource(jedis);
//
//        //关闭连接
//        jedisPool.close();
//    }
//
//    @Test	//分片
//    public void shard(){
//
//        //构造各个节点链接信息，host和port
//        List<JedisShardInfo> infoList = new ArrayList<JedisShardInfo>();
//        JedisShardInfo info1 = new JedisShardInfo("192.168.26.133",6379);
//        //info1.setPassword("123456");
//        infoList.add(info1);
//        JedisShardInfo info2 = new JedisShardInfo("192.168.26.133",6380);
//        infoList.add(info2);
//        JedisShardInfo info3 = new JedisShardInfo("192.168.26.133",6381);
//        infoList.add(info3);
//        //分片jedis
//        JedisPoolConfig config = new JedisPoolConfig();
//        config.setMaxTotal(500);	//最大链接数
//        ShardedJedisPool pool = new ShardedJedisPool(config, infoList);
//        //ShardedJedis jedis = new ShardedJedis(infoList);
//        ShardedJedis jedis = pool.getResource();	//从pool中获取
//        for(int i=0;i<10;i++){
//            jedis.set("n"+i, "t"+i);
//        }
//        System.out.println(jedis.get("n9"));
//        jedis.close();
//    }
//
//    /*
//    Redis提供一定程度的可用性,可以在某个节点宕机或者不可达的情况下继续处理命令。
//     */
//    @Test
//    public void sentinel(){
//        Set<String> sentinels = new HashSet<String>();
//        sentinels.add(new HostAndPort("192.168.26.133",26379).toString());
//        sentinels.add(new HostAndPort("192.168.26.133",26380).toString());
//
//        //mymaster是在sentinel.conf中配置的名称
//        //sentinel monitor mymaster 192.168.26.133 6379 1
//        JedisSentinelPool pool = new JedisSentinelPool("mymaster", sentinels);
//        System.out.println("当前master：" + pool.getCurrentHostMaster());
//
//        Jedis jedis = pool.getResource();
//        jedis.set("name","xiaoxiao");
//        System.out.println(jedis.get("name"));
//        pool.returnResource(jedis);
//
//        pool.destroy();
//        System.out.println("ok");
//    }
//
//
//
//}
