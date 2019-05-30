package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

/**
 * @author hongcq
 * @Description TODO
 * @date 2019/5/14 11:11
 * @ClassName MultipartResolverConfig
 */

@Configuration
public class MultipartResolverConfig {

    @Bean(name = "multipartResolver")
    public MultipartResolver multipartResolver(){
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
        resolver.setDefaultEncoding("UTF-8");
        resolver.setMaxUploadSize(5242880);
        return resolver;
    }
}
