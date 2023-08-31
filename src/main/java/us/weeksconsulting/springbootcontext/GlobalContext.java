package us.weeksconsulting.springbootcontext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GlobalContext {
    private final static Logger LOGGER = LoggerFactory.getLogger(GlobalContext.class);

    @Bean
    @Qualifier("globalContext")
    String getGlobalAppName(){    
        return "Global";
    };
}
