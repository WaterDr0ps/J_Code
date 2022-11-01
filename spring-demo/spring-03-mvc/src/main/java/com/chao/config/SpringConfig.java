package com.chao.config;

import org.springframework.context.annotation.*;
import org.springframework.stereotype.Controller;

/**
 * @author Eliot
 */
@Configuration
@ComponentScan(value="com.chao",
        excludeFilters = @ComponentScan.Filter(
                type = FilterType.ANNOTATION,
                classes = Controller.class
        )
)
@Import({JdbcConfig.class,MybatisConfig.class})
@PropertySource("classpath:jdbc.properties")
public class SpringConfig {
}
