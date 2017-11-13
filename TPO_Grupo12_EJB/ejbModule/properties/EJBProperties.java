package properties;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@Singleton
@Startup

public class EJBProperties {
	 Properties properties;
	 
	    @PostConstruct
	    public void init() {
	         InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("configOH.properties");
	 
	            properties = new Properties();
	            System.out.println("InputStream is: " + inputStream);
	            try {
					properties.load(inputStream);
				} catch (IOException e) {
					e.printStackTrace();
				}
	            System.out.println("Read Properties."+properties);
	       }

		public Properties getProperties() {
			return properties;
		}
	    
	    
	    
	
		
}
