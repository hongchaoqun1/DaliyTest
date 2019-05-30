import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author hongcq
 * @Description TODO
 * @date 2019/5/7 10:44
 * @ClassName app
 */

@ComponentScan(basePackages = {"controller", "service"})
@MapperScan("dao")
@SpringBootApplication
@Configuration
@EnableCaching
public class app {
    public static void main(String[] args){
        SpringApplication.run(app.class,args);
    }
}
