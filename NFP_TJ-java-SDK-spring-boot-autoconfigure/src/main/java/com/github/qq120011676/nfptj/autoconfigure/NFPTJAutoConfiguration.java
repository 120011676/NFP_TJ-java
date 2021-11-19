package com.github.qq120011676.nfptj.autoconfigure;

import com.github.qq120011676.nfptj.NFPTJ;
import com.github.qq120011676.nfptj.autoconfigure.properties.NFPTJProperties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

@Configuration
@ConditionalOnClass(NFPTJ.class)
@EnableConfigurationProperties(NFPTJProperties.class)
public class NFPTJAutoConfiguration {
    @Resource
    private NFPTJProperties nfptjProperties;

    @Bean
    @ConditionalOnMissingBean(NFPTJ.class)
    public NFPTJ nfptj() {
        return new NFPTJ(nfptjProperties);
    }

}
