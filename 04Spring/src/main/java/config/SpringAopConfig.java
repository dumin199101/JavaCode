package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan("aop1.anno")
@EnableAspectJAutoProxy
@Import(JdbcConfig.class)
public class SpringAopConfig {

}
