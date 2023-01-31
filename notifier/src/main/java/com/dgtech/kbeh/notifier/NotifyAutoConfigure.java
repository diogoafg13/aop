package com.dgtech.kbeh.notifier;

import com.dgtech.kbeh.notifier.aop.NotifyAOP;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass(NotifyAOP.class)
public class NotifyAutoConfigure {

    @Bean
    public NotifyAOP notifier(){
        return new NotifyAOP();
    }
}
