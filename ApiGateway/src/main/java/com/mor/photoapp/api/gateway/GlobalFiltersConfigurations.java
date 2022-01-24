package com.mor.photoapp.api.gateway;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import reactor.core.publisher.Mono;

/*
@Configuration annotation indicates that a class declares one or more @Bean methods
and may be processed by the Spring container to generate bean definitions
and service requests for those beans at runtime.
 */
@Configuration
public class GlobalFiltersConfigurations {

    Logger logger = LoggerFactory.getLogger(GlobalFiltersConfigurations.class);

    /*
    @Bean annotation tells that a method produces a bean to be managed by the Spring container.
     */
    @Bean

    /*
    defines the sorting order of an annotated component or bean.
     */
    @Order(2)
    public GlobalFilter secondFilter() {
        return (exchange, chain) -> {
            logger.info("second pre-filter ...");
            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
                logger.info("second post-filter ...");
            }));
        };
    }

    @Bean
    @Order(1)
    public GlobalFilter thirdFilter() {
        return (exchange, chain) -> {
            logger.info("third pre-filter ...");
            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
                logger.info("third post-filter ...");
            }));
        };
    }
}
