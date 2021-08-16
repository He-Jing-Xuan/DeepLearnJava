package com.he.spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackageClasses = {com.he.spring.service.IBuy.class})
@EnableAspectJAutoProxy(proxyTargetClass = false)
public class AppConfig {
}
