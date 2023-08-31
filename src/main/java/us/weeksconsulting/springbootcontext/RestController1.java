package us.weeksconsulting.springbootcontext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestController1 {
    private final static Logger LOGGER = LoggerFactory.getLogger(AppContext2.class);

    @Autowired
    @Qualifier("globalContext")
    String globalName;

    @Autowired
    @Qualifier("localContext")
    String localName;

    @GetMapping("/name")
    public String getName() {
        LOGGER.info("getName");
        LOGGER.info("{}", SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        return String.format("<h1>globalContext: %s localContext: %s</h1>", globalName, localName);
    }
}
