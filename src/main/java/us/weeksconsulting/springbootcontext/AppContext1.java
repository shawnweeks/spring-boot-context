package us.weeksconsulting.springbootcontext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({
        AppComponent.class
})
public class AppContext1 {
    private final static Logger LOGGER = LoggerFactory.getLogger(AppContext1.class);

    @Bean
    @Qualifier("localContext")
    String getAppName() {        
        return "App1";
    };
}
