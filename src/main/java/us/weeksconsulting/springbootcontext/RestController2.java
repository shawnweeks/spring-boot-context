package us.weeksconsulting.springbootcontext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest2")
public class RestController2 {
    private final static Logger LOGGER = LoggerFactory.getLogger(AppContext1.class);
    
    @Autowired
    @Qualifier("globalContext")
    String globalName;

    @Autowired
    @Qualifier("localContext")
    String localName;

    @GetMapping("/name")
    public String getName() {
        LOGGER.info("getName");
        return String.format("<globalContext: %s localContext: %s>", globalName, localName);
    }
}
