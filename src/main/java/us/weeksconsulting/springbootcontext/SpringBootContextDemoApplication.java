package us.weeksconsulting.springbootcontext;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.boot.SpringApplication;

@EnableAutoConfiguration
@Import({ GlobalContext.class })
public class SpringBootContextDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootContextDemoApplication.class, args);
    }
}
