package custom_card_creator;
/**
 * 
 * @author Jaidev K
 *
 */
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
public class CustomCardCreatorApplication extends Application<CustomCardCreatorConfiguration> {
	public static void main (String [] args) throws Exception {
		new CustomCardCreatorApplication().run(args);
	}

	public void initialize (Bootstrap<CustomCardCreatorConfiguration> bootstrap) {
		//used to configure aspects of the application required before the application is run, like bundles, configuration source providers, etc.
		
	}
	
	@Override
	public void run(CustomCardCreatorConfiguration configuration, Environment environment) throws Exception {
		//nothing yet
		
	}
	
	
}
