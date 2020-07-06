package config;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan("com.itcast.withoutxml")
@Import(JdbcConfig.class)
public class SpringConfig {

}
