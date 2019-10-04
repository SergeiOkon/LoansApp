package com.lending;

import com.lending.dao.DBConnector;
import com.lending.model.loans.TargetLoan;
import com.lending.service.FilterService;
import com.lending.service.UserViewService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

@Configuration
@ComponentScan("com.lending")
public class Config {

    @Bean
    public TargetLoan targetLoan() {
        return new TargetLoan();
    }

    @Bean
    public FilterService filterService() {
        return new FilterService();
    }

    @Bean
    public UserViewService userViewService() {
        return new UserViewService();
    }

    @Bean
    public App app() {
        return new App();
    }
}