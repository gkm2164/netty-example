package co.gyeongmin.girlnetty.ex9;

import redis.embedded.RedisExecProvider;
import redis.embedded.RedisServer;
import redis.embedded.util.Architecture;
import redis.embedded.util.OS;

import java.io.IOException;

/**
 * Created by USER on 2016-04-21.
 */
public class RedisRunner {
    public static void main(String[] args) throws IOException {
        RedisExecProvider customProvider = RedisExecProvider.defaultProvider()
                .override(OS.WINDOWS, Architecture.x86_64, "D:\\redis-2.8.19\\redis-server.exe");
        RedisServer redisServer = RedisServer.builder()
                .redisExecProvider(customProvider)
                .port(6379)
                .configFile("D:\\redis-2.8.19\\redis.conf")
                .build();
        //RedisServer redisServer = new RedisServer(customProvider, 6379);
        redisServer.start();

        redisServer.stop();
    }
}
