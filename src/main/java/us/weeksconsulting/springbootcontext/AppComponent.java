package us.weeksconsulting.springbootcontext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class AppComponent {
    private final static Logger LOGGER = LoggerFactory.getLogger(AppComponent.class);

    @Autowired
    @Qualifier("globalContext")
    String globalName;

    @Autowired
    @Qualifier("localContext")
    String localName;

    @EventListener(ApplicationReadyEvent.class)
    public void doSomethingAfterStartup() {
        LOGGER.info("Finished Startup");
        LOGGER.info("globalName: {}", globalName);
        LOGGER.info("localName: {}", localName);
    }
}
