package com.opm.common.session;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * Created by kfzx-liuyz1 on 2016/11/15.
 */
@Configuration
@EnableRedisHttpSession
public class SessionConfig {
}
