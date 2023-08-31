package us.weeksconsulting.springbootcontext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({
        RestController2.class
})
public class AppContext2 {
    private final static Logger LOGGER = LoggerFactory.getLogger(AppContext2.class);

    @Bean
    @Qualifier("localContext")
    String getAppName() {
        return "App2";
    };
}
