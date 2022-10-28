package br.com.db.ingressos.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(value = "br.com.db.ingressos.repository.impl", considerNestedRepositories = true)
public class JpaConfig {
}
