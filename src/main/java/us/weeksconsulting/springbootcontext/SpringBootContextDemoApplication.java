package us.weeksconsulting.springbootcontext;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import static org.springframework.boot.WebApplicationType.NONE;

@SpringBootApplication
public class SpringBootContextDemoApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder()
				.sources(GlobalContext.class).web(NONE)
				.child(AppContext1.class).web(NONE)
				.child(AppContext2.class).web(NONE)
				.run(args);
	}

}
