package org.acme.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = {"org.acme.controllers",
        "org.acme.services",
        "org.acme.repositories",
        "org.acme.aspects"})
@EnableAspectJAutoProxy
public class ProjectConfig {
}
