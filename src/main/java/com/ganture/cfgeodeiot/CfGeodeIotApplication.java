package com.ganture.cfgeodeiot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Cloud Foundry, Geode IoT scratch app
 * 
 * Geode is not implemented and the locator and server cannot be implemented in a single process.
 * 
 * The behavior is implemented via a circular buffer/evicting queue
 * 
 * The circular buffer is use to restrict the number of values held
 * 
 * @author <a href="mailto:markcrowley@gmail.com">Mark Crowley</a>
 */
@SpringBootApplication
@EnableAutoConfiguration
public class CfGeodeIotApplication implements WebMvcConfigurer {

  public static void main(String[] args) {
    SpringApplication.run(CfGeodeIotApplication.class, args);
  }

}
