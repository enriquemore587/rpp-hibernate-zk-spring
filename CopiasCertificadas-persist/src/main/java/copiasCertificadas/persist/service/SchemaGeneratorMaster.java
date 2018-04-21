package copiasCertificadas.persist.service;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class SchemaGeneratorMaster {

	private Logger logger = LogManager.getLogger(SchemaGeneratorMaster.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SchemaGeneratorMaster sG = new SchemaGeneratorMaster();
		sG.createSchema();

	}
	public void createSchema() {
					try {
						logger.info("begin database schema creation =========================");			
						Configuration cfg = (new Configuration())
								//.configure("hibernateUsers.cfg.xml");
								.configure("hibernate.cfg.xml");
						SchemaExport schemaExport = new SchemaExport(cfg);
						schemaExport.create(true, true);
						//schemaExport.execute(true, true, true, true);			
						logger.info("end database schema creation ===========================");						
					} catch (Exception e) {
						e.printStackTrace();
					}
			}
}