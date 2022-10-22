package by.epam.ivanchenko;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("by.epam.ivanchenko")
@PropertySource("classpath:musicPlayer.properties")
public class SpringConfig {

}
