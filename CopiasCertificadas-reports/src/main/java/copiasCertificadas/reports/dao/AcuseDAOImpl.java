package copiasCertificadas.reports.dao;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Restrictions;

import copiasCertificadas.persist.model.domain.ventanilla.tramite.Tramite;
import copiasCertificadas.persist.service.HibernateUtil;
import copiasCertificadas.persist.service.ServiceLocator;
import copiasCertificadas.reports.enums.Acuse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperRunManager;

public class AcuseDAOImpl implements AcuseDAO {

	public byte[] acuseReporteAvisos(Long id) {
		System.out.println("ID A IMPRIMIR: " + id);
        DataSource ds = ServiceLocator.getMySQL().getDataSource();
        byte[] bytesReporte = null;        
                try {
                        /*
                         BufferedImage image = ImageIO.read(getClass().getResource("/images/IMAGE.png"));
                         parameters.put("logo", image );
                         */
                        Connection conn =  ds.getConnection();
                        final Map params = new HashMap();
                        params.put("id", id);
                        
                        
                        //IMAGENES
                        
//                        InputStream header=getClass().getResourceAsStream(AcuseEM.LOGOCDMX.toString());
//                        params.put("LOGO",header);
//                        
//                        InputStream pie = getClass().getResourceAsStream(AcuseEM.LOGOPIE.toString());
//                        params.put("LOGO_PIE", pie);
                        
                        //path para subreportes
                        
                        //params.put("PATH",getClass().getResource(EnumReportsEM.PATHSUBPRESENTACION.toString()).toString());
                        
                        
                        //path Reporte Principal
                        InputStream is=getClass().getResourceAsStream(Acuse._AVISO_SESION_.toString());
                        
                        
                        bytesReporte = JasperRunManager.runReportToPdf(is,params, conn);
                        
                        
        } catch (JRException ex) {
            ex.printStackTrace();
        } catch (SQLException e) {                        
                        e.printStackTrace();
                }
                return bytesReporte;
	}
	public byte[] acuseReporteCC_sesion(Long id) {
		System.out.println("ID A IMPRIMIR: " + id);
        DataSource ds = ServiceLocator.getMySQL().getDataSource();
        byte[] bytesReporte = null;        
        try {

                Connection conn =  ds.getConnection();
                final Map params = new HashMap();
                params.put("id", id);
                
                
                InputStream is=getClass().getResourceAsStream(Acuse._C_C_NOTARIO_S_.toString());
                
                
                bytesReporte = JasperRunManager.runReportToPdf(is,params, conn);
                
        } catch (JRException ex) {
            ex.printStackTrace();
        } catch (SQLException e) {                        
                        e.printStackTrace();
                }
                return bytesReporte;
	}
	
	public byte[] acuseReporteCC_Representante(Long id) {
		System.out.println("ID A IMPRIMIR: " + id);
        DataSource ds = ServiceLocator.getMySQL().getDataSource();
        byte[] bytesReporte = null;        
        try {

                Connection conn =  ds.getConnection();
                final Map params = new HashMap();
                params.put("id", id);
                
                
                InputStream is=getClass().getResourceAsStream(Acuse._C_C_V_R_A_.toString());
                
                
                bytesReporte = JasperRunManager.runReportToPdf(is,params, conn);
                
        } catch (JRException ex) {
            ex.printStackTrace();
        } catch (SQLException e) {                        
                        e.printStackTrace();
                }
                return bytesReporte;
	}
	public byte[] acuseReporteCC_PI(Long id) {
		System.out.println("ID A IMPRIMIR: " + id);
        DataSource ds = ServiceLocator.getMySQL().getDataSource();
        byte[] bytesReporte = null;        
        try {

                Connection conn =  ds.getConnection();
                final Map params = new HashMap();
                params.put("id", id);
                
                
                InputStream is=getClass().getResourceAsStream(Acuse._C_C_V_PI_.toString());
                
                
                bytesReporte = JasperRunManager.runReportToPdf(is,params, conn);
                
        } catch (JRException ex) {
            ex.printStackTrace();
        } catch (SQLException e) {                        
                        e.printStackTrace();
                }
                return bytesReporte;
	}
	public byte[] acuseReporteCC_NF(Long id) {
		System.out.println("ID A IMPRIMIR: " + id);
        DataSource ds = ServiceLocator.getMySQL().getDataSource();
        byte[] bytesReporte = null;        
        try {

                Connection conn =  ds.getConnection();
                final Map params = new HashMap();
                params.put("id", id);
                
                
                InputStream is=getClass().getResourceAsStream(Acuse._C_C_NOTARIO_S_.toString());
                
                
                bytesReporte = JasperRunManager.runReportToPdf(is,params, conn);
                
        } catch (JRException ex) {
            ex.printStackTrace();
        } catch (SQLException e) {                        
                        e.printStackTrace();
                }
                return bytesReporte;
	}
	
	public static void main(String[] args) {
		AcuseDAOImpl test = new AcuseDAOImpl();
		
		byte[] bytes = null;
		
		bytes = test.acuseReporteAvisos(2l);
		
		System.out.println("Reporte : "+bytes);
		
		OutputStream out;
        try {
            out = new FileOutputStream("c:\\pdf/acuse.pdf");
            out.write(bytes);
            out.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AcuseDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AcuseDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
	}

	public byte[] busquedaAcuse(Long id) {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			Session session = sessionFactory.openSession();
			Tramite tramite=new Tramite();
			try {
				
				Criteria criteria = session.createCriteria(Tramite.class)
						.add(Restrictions.eq("id", id))
						.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
				
				tramite = (Tramite) criteria.uniqueResult();
				
				session.close();
				
			} catch (RuntimeException e) {
				// TODO: handle exception
				e.printStackTrace();
				session.close();
			}
		return tramite.getAcuse();
	}

	
	
}
