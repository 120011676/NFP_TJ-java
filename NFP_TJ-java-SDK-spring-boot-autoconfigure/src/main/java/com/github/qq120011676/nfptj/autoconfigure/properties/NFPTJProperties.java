package com.github.qq120011676.nfptj.autoconfigure.properties;

import com.github.qq120011676.nfptj.config.NFPTJConfig;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.boot.context.properties.ConfigurationProperties;

@EqualsAndHashCode(callSuper = true)
@Data
@ConfigurationProperties(prefix = "nfp.tj")
public class NFPTJProperties extends NFPTJConfig {
}
