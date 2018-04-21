package copiasCertificadas.persist.service;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class ServiceLocator {
	
	private static final ServiceLocator INSTANCE;
	private ApplicationContext coreContext;
	private static Logger logger=Logger.getLogger(ServiceLocator.class);
	
	static{
		INSTANCE = new ServiceLocator();
	}
	
	public static synchronized ServiceLocator instance(){
		return INSTANCE;
	}
	
	public ApplicationContext getContext(){
		if(coreContext==null){
			coreContext=new ClassPathXmlApplicationContext(
					getConfigLocations()
					,getDbContext());
		}
		return coreContext;
	}
	
	protected ApplicationContext getDbContext(){
		return new ClassPathXmlApplicationContext(
				new String[]{
				"classpath:/applicationContext-hibernate.xml", 		// DB configuration
				}
				);
	}

	protected String[] getConfigLocations() {
        return new String[] {                
        		//"classpath:/applicationContext-db.xml", 		// DB configuration
                //"classpath:/applicationContext-dao.xml", 	   	// Main DAO container
                //"classpath*:/applicationContext-hibernate.xml"//, 	// Services for modules
                			  
            };
    }
	
	

	
	public static JdbcTemplate getMySQL(){		
		return (JdbcTemplate)instance().getContext().getBean("MySQL");
	}
	
	
	
	
	
}
