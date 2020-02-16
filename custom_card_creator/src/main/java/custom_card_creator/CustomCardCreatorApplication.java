package custom_card_creator;
/**
 * 
 * @author Jaidev K
 *
 */
import java.sql.*;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
public class CustomCardCreatorApplication extends Application<CustomCardCreatorConfiguration> {
	public static void main (String [] args) throws Exception {
		//database connection
		try (Connection conn = DriverManager.getConnection("jdbc:mariadb://localhost/", "jbhatnagar", null)){
			//create a statement
			try(Statement stmt = conn.createStatement()){
				//execute a query
				try(ResultSet rs = stmt.executeQuery("SELECT 'Hello World'")){
					//position result to first
					rs.first();
					System.out.println(rs.getString(1)); //result is 'Hello World!'
				}
			}
		}
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
