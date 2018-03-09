package by.bsac.tcs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class WebServerApplication {

  public static void main(String[] args) {
    SpringApplication.run(WebServerApplication.class, args);
  }

  @Bean
  public Logger logger() {
    return LoggerFactory.getLogger("application");
  }
}
