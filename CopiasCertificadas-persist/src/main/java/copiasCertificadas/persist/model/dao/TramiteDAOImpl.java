package copiasCertificadas.persist.model.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;

import copiasCertificadas.persist.model.domain.ventanilla.BeanAvisosNotariales;
import copiasCertificadas.persist.model.domain.ventanilla.BeanCopiasCertificadas;
import copiasCertificadas.persist.model.domain.ventanilla.CP_NotarioSesion;
import copiasCertificadas.persist.model.domain.ventanilla.CopiasCertificadasNotario;
import copiasCertificadas.persist.model.domain.ventanilla.avisos.bandeja.BeanAvisosBandejaProtocolo;
import copiasCertificadas.persist.model.domain.ventanilla.avisos.bandeja.BeanAvisosNotarialesBandeja;
import copiasCertificadas.persist.model.domain.ventanilla.bitacora.Bitacora;
import copiasCertificadas.persist.model.domain.ventanilla.copias.bandeja.BeanCopiasBandeja;
import copiasCertificadas.persist.model.domain.ventanilla.seguimiento.SeguimientoTramite;
import copiasCertificadas.persist.model.domain.ventanilla.tramite.Tramite;
import copiasCertificadas.persist.service.HibernateUtil;



public class TramiteDAOImpl implements TramiteDAO{
	Logger LOG = Logger.getLogger(TramiteDAOImpl.class.getName());
	
	public Tramite saveUpdate(Tramite tramite) {
		boolean flag = false;
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		
		try {
			session.beginTransaction();
			session.saveOrUpdate(tramite);
			session.getTransaction().commit();
			flag = true;
			
		} catch (Exception e) {
			LOG.log(Level.SEVERE, e.getMessage());
			session.getTransaction().rollback();
			return null;
		}
		session.close();
		return tramite;
	}
	
	public boolean update(Tramite tramite) {
		boolean flag = false;
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		
		try {
			session.beginTransaction();
			session.update(tramite);
			LOG.log(Level.INFO, "actualizado");
			session.getTransaction().commit();
			flag = true;
			
			
		} catch (Exception e) {
			LOG.log(Level.SEVERE, e.getMessage());
			LOG.log(Level.INFO, "no no no no no no no no no");
			session.getTransaction().rollback();
			
		}
		session.close();
		return flag;
	}
	public boolean delate(Tramite tramite) {
		boolean flag = false;
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		
		try {
			session.beginTransaction();
			session.delete(tramite);
			LOG.log(Level.INFO, "borrado");
			session.getTransaction().commit();
			flag = true;
			
			
		} catch (Exception e) {
			LOG.log(Level.SEVERE, e.getMessage());
			LOG.log(Level.INFO, "no no no no no no no no no");
			session.getTransaction().rollback();
			
		}
		session.close();
		return flag;
	}
	
	
	public List<BeanCopiasCertificadas> listaTramitesCP() {
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		List<BeanCopiasCertificadas> lista = new ArrayList<BeanCopiasCertificadas>();
		
		List<Object[]> listaObj = null;
		
		try {
			listaObj = (List<Object[]>) session.createCriteria(SeguimientoTramite.class, "SeguimientoTramite")
					.createCriteria("SeguimientoTramite.tramite", "tramite")
					
					//.add(Restrictions.eq("bitacora.status", "PRESENTADO"))
					
					//.createCriteria("tramite.listaSeguimientos", "ls")
					
					.createCriteria("tramite.copiaCertificada", "copiaCertificada")
					
					.setProjection(Projections.projectionList()
							 
							.add(Projections.property("tramite.folio"))
							.add(Projections.property("SeguimientoTramite.status"))							
							.add(Projections.property("SeguimientoTramite.status_gestion"))
							.add(Projections.property("copiaCertificada.modalidad"))
							
							).list();
			
			
			
			
			
			for (Object[] objects : listaObj) {
				LOG.log(Level.INFO, objects[0]+"****"+ 
						objects[1].toString()+"****"+ 
						objects[2]+"****"+ 
						objects[3].toString()+"\n");

				
				
				for (BeanCopiasCertificadas obj : lista) {
					if (obj.getFolio().toString().equals(objects[0].toString())) {
						lista.remove(obj);
						break;
					}
				}
				
				lista.add(new BeanCopiasCertificadas(
						objects[0].toString(), 
						objects[1].toString(), 
						objects[2].toString(), 
						objects[3].toString()));
			}
			
			session.close();		
		} catch (Exception e) {
			e.printStackTrace();
			session.close();
			LOG.log(Level.INFO, e.getMessage());
		}
		return lista;
	}
	
	public List<BeanCopiasCertificadas> listaTramitesCPByFolio(String folio) {
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		List<BeanCopiasCertificadas> lista = new ArrayList<BeanCopiasCertificadas>();
		
		List<Object[]> listaObj = null;
		
		try {
			listaObj = (List<Object[]>) session.createCriteria(Bitacora.class, "bitacora")
					.createCriteria("bitacora.tramite", "tramite").add(Restrictions.eq("tramite.folio", folio))
					.createCriteria("tramite.listaSeguimientos", "ls")
					.createCriteria("tramite.copiaCertificada", "copiaCertificada")
					
					.setProjection(Projections.projectionList()
							.add(Projections.property("tramite.folio"))
							.add(Projections.property("bitacora.status"))
							.add(Projections.property("ls.status_gestion"))
							.add(Projections.property("copiaCertificada.modalidad"))
							).list();
			session.close();
			
			for (Object[] objects : listaObj) {
				LOG.log(Level.SEVERE, objects[0]+"-"+ 
						objects[1].toString()+"-"+ 
						objects[2]+"-"+ 
						objects[3].toString()+"-");
				
				lista.add(new BeanCopiasCertificadas(
						objects[0].toString(), 
						objects[1].toString(), 
						objects[2].toString(), 
						objects[3].toString()));
				
			}
			
								
		} catch (Exception e) {
			e.printStackTrace();
			session.close();
			LOG.log(Level.INFO, e.getMessage());
		}
		return lista;
	}
	
	
	
	
	public List<CopiasCertificadasNotario> listaTramitesCPNotarioByName(String nombre, String paterno, String materno) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		List<CopiasCertificadasNotario> lista = new ArrayList<CopiasCertificadasNotario>();
		List<Object[]> listaObj = null;
		
		try {
			listaObj = (List<Object[]>) session.createCriteria(Bitacora.class, "bitacora")
					.createCriteria("bitacora.tramite", "tramite")
					.createCriteria("tramite.copiaCertificada", "copiaCertificada")
					.createCriteria("copiaCertificada.representante_legal", "representante_legal")
															.add(Restrictions.eq("representante_legal.nombre", nombre))
															.add(Restrictions.eq("representante_legal.paterno", paterno))
															.add(Restrictions.eq("representante_legal.materno", materno))
					.setProjection(Projections.projectionList()
							.add(Projections.property("tramite.id"))
							.add(Projections.property("tramite.folio"))
							.add(Projections.property("tramite.creado"))
							.add(Projections.property("bitacora.status"))
							.add(Projections.property("copiaCertificada.modalidad"))
							).list();
			session.close();
			
			for (Object[] objects : listaObj) {
				LOG.log(Level.SEVERE, (Long) objects[0]+"-"+ 
						objects[1].toString()+"-"+ 
						(Date) objects[2]+"-"+ 
						objects[3].toString()+"-"+ 
						objects[4].toString());
				
				lista.add(new CopiasCertificadasNotario(
						(Long) objects[0], 
						objects[1].toString(), 
						(Date) objects[2], 
						objects[3].toString(), 
						objects[4].toString()));
				
			}
			
								
		} catch (Exception e) {
			e.printStackTrace();
			session.close();
			LOG.log(Level.INFO, e.getMessage());
		}
		return lista;
	}
	public List<CP_NotarioSesion> getallCPByNumNotario(Integer num) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		
		List<Object []> list1;
		List<CP_NotarioSesion> listCP = new ArrayList<CP_NotarioSesion>();
		
		list1 = (List<Object[]>) session.createCriteria(Bitacora.class, "b")
				.createCriteria("b.tramite", "t").add(Restrictions.eq("t.id_fedatario", num))
				.createCriteria("t.copiaCertificada", "cp")
				.setProjection(Projections.projectionList()
						.add(Projections.property("t.folio"))
						.add(Projections.property("cp.modalidad"))
						.add(Projections.property("b.status"))
						.add(Projections.property("t.creado"))
					).list();
		
		for (Object[] obj : list1) {
			listCP.add(new CP_NotarioSesion(
					obj[0].toString(), 
					obj[1].toString(), 
					obj[2].toString(), 
					(Date)obj[3]));
		}
		return listCP;
	}
	public List<CP_NotarioSesion> getallCPByModalidad(Integer num, String modalidad){
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		
		List<Object []> list1;
		List<CP_NotarioSesion> listCP = new ArrayList<CP_NotarioSesion>();
		
		try {
			list1 = (List<Object[]>) session.createCriteria(Bitacora.class, "b")
					.createCriteria("b.tramite", "t").add(Restrictions.eq("t.id_fedatario", num))
					.createCriteria("t.copiaCertificada", "cp").add(Restrictions.eq("cp.modalidad", modalidad))
					.setProjection(Projections.projectionList()
							.add(Projections.property("t.folio"))
							.add(Projections.property("cp.modalidad"))
							.add(Projections.property("b.status"))
							.add(Projections.property("t.creado"))
						).list();
			
			for (Object[] obj : list1) {
				listCP.add(new CP_NotarioSesion(
						obj[0].toString(), 
						obj[1].toString(), 
						obj[2].toString(), 
						(Date)obj[3]));
			}
			session.close();
		} catch (Exception e) {
			session.close();
			e.printStackTrace();
		}
		return listCP;
	}
	public List<CP_NotarioSesion> getallCPByStatusNumNotario(Integer num, String status) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		
		List<Object []> list1;
		List<CP_NotarioSesion> listCP = new ArrayList<CP_NotarioSesion>();
		
		try {
			list1 = (List<Object[]>) session.createCriteria(Bitacora.class, "b").add(Restrictions.eq("b.status", status))
					.createCriteria("b.tramite", "t").add(Restrictions.eq("t.id_fedatario", num))
					.createCriteria("t.copiaCertificada", "cp")
					.setProjection(Projections.projectionList()
							.add(Projections.property("t.folio"))
							.add(Projections.property("cp.modalidad"))
							.add(Projections.property("b.status"))
							.add(Projections.property("t.creado"))
						).list();
			
			for (Object[] obj : list1) {
				listCP.add(new CP_NotarioSesion(
						obj[0].toString(), 
						obj[1].toString(), 
						obj[2].toString(), 
						(Date)obj[3]));
			}
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
			session.close();
		}
		return listCP;
	}
	
	public List<BeanCopiasCertificadas> getallCPByStatus(String status) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		
		List<Object []> listaObj;
		List<BeanCopiasCertificadas> listCP = new ArrayList<BeanCopiasCertificadas>();
		try {

			listaObj = (List<Object[]>) session.createCriteria(Bitacora.class, "bitacora").add(Restrictions.eq("bitacora.status", status))
					.createCriteria("bitacora.tramite", "tramite")
					.createCriteria("tramite.listaSeguimientos", "ls")
					.createCriteria("tramite.copiaCertificada", "copiaCertificada")
					
					.setProjection(Projections.projectionList()
							.add(Projections.property("tramite.folio"))
							.add(Projections.property("bitacora.status"))							
							.add(Projections.property("ls.status_gestion"))
							.add(Projections.property("copiaCertificada.modalidad"))
							).list();
			
			
			for (Object[] objects : listaObj) {
				LOG.log(Level.SEVERE, objects[0]+"-"+ 
						objects[1].toString()+"-"+ 
						objects[2]+"-"+ 
						objects[3].toString()+"-");
				
				listCP.add(new BeanCopiasCertificadas(
						objects[0].toString(), 
						objects[1].toString(), 
						objects[2].toString(), 
						objects[3].toString()));
				
			}
			session.close();
		} catch (Exception e) {
			session.close();
			e.printStackTrace();
		}
		
		return listCP;
	}


	public List<BeanCopiasCertificadas> getallCPByModalidad(String modalidad){
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		List<Object []> listaObj;
		List<BeanCopiasCertificadas> listCP = new ArrayList<BeanCopiasCertificadas>();
		try {
			
			listaObj = (List<Object[]>) session.createCriteria(Bitacora.class, "bitacora")
					.createCriteria("bitacora.tramite", "tramite")
					.createCriteria("tramite.listaSeguimientos", "ls")
					.createCriteria("tramite.copiaCertificada", "copiaCertificada").add(Restrictions.eq("copiaCertificada.modalidad", modalidad))
					
					.setProjection(Projections.projectionList()
							.add(Projections.property("tramite.folio"))
							.add(Projections.property("bitacora.status"))							
							.add(Projections.property("ls.status_gestion"))
							.add(Projections.property("copiaCertificada.modalidad"))
							).list();
			
			
			for (Object[] objects : listaObj) {
				LOG.log(Level.SEVERE, objects[0]+"-"+ 
						objects[1].toString()+"-"+ 
						objects[2]+"-"+ 
						objects[3].toString()+"-");
				
				listCP.add(new BeanCopiasCertificadas(
						objects[0].toString(), 
						objects[1].toString(), 
						objects[2].toString(), 
						objects[3].toString()));
				
			}
			session.close();
		} catch (Exception e) {
			session.close();
		}
		
		return listCP;
	}
	
	
	
	
	public List<BeanAvisosNotariales> getAllAvisosByNumNotario(Integer id){
		List<BeanAvisosNotariales> endList = new ArrayList<BeanAvisosNotariales>();
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		
		List<Object []> listaObj;
		
		try {
			listaObj = (List<Object[]>) session.createCriteria(Bitacora.class, "bitacora")
					.createCriteria("bitacora.tramite", "tramite").add(Restrictions.eq("tramite.id_fedatario", id))
					.createCriteria("tramite.avisosNotariales", "avisosNotariales")
					
					.setProjection(Projections.projectionList()
							.add(Projections.property("tramite.folio"))
							.add(Projections.property("avisosNotariales.modalidad"))
							.add(Projections.property("avisosNotariales.preDescripcionAviso"))
							.add(Projections.property("bitacora.status"))	
							).list();
			session.close();
			
			
			for (Object[] objects : listaObj) {
				LOG.log(Level.SEVERE, objects[0]+"-"+ 
						objects[1].toString()+"-"+ 
						objects[2]+"-"+ 
						objects[3].toString()+"-");
				
				endList.add(new BeanAvisosNotariales(
						objects[0].toString(), 
						objects[1].toString(), 
						objects[2].toString(), 
						objects[3].toString()));
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			LOG.log(Level.SEVERE, "no se puede CREAR LA PROJECCION");
			session.close();
		}
				
		
		return endList;
	}
	
	
	public List<BeanAvisosNotariales> getAllAvisosByFolioTramite(String folio, Integer num){
		List<BeanAvisosNotariales> endList = new ArrayList<BeanAvisosNotariales>();
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		
		List<Object []> listaObj;
		
		try {
			listaObj = (List<Object[]>) session.createCriteria(Bitacora.class, "bitacora")
					.createCriteria("bitacora.tramite", "tramite").add(Restrictions.eq("tramite.folio", folio)).add(Restrictions.eq("tramite.id_fedatario", num))
					.createCriteria("tramite.avisosNotariales", "avisosNotariales")
					
					.setProjection(Projections.projectionList()
							.add(Projections.property("tramite.folio"))
							.add(Projections.property("avisosNotariales.modalidad"))
							.add(Projections.property("avisosNotariales.preDescripcionAviso"))
							.add(Projections.property("bitacora.status"))	
							).list();
			session.close();
			
			
			for (Object[] objects : listaObj) {
				LOG.log(Level.SEVERE, objects[0]+"-"+ 
						objects[1].toString()+"-"+ 
						objects[2]+"-"+ 
						objects[3].toString()+"-");
				
				endList.add(new BeanAvisosNotariales(
						objects[0].toString(), 
						objects[1].toString(), 
						objects[2].toString(), 
						objects[3].toString()));
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			LOG.log(Level.SEVERE, "no se puede CREAR LA PROJECCION");
			session.close();
		}
				
		
		return endList;
	}
	
	public List<BeanAvisosNotariales> getAllAvisosByModalidad(String modalidad, Integer num){
		List<BeanAvisosNotariales> endList = new ArrayList<BeanAvisosNotariales>();
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		
		List<Object []> listaObj;
		
		try {
			listaObj = (List<Object[]>) session.createCriteria(Bitacora.class, "bitacora")
					.createCriteria("bitacora.tramite", "tramite").add(Restrictions.eq("tramite.id_fedatario", num))
					.createCriteria("tramite.avisosNotariales", "avisosNotariales").add(Restrictions.eq("avisosNotariales.modalidad", modalidad))
					
					.setProjection(Projections.projectionList()
							.add(Projections.property("tramite.folio"))
							.add(Projections.property("avisosNotariales.modalidad"))
							.add(Projections.property("avisosNotariales.preDescripcionAviso"))
							.add(Projections.property("bitacora.status"))	
							).list();
			session.close();
			
			
			for (Object[] objects : listaObj) {
				LOG.log(Level.SEVERE, objects[0]+"-"+ 
						objects[1].toString()+"-"+ 
						objects[2]+"-"+ 
						objects[3].toString()+"-");
				
				endList.add(new BeanAvisosNotariales(
						objects[0].toString(), 
						objects[1].toString(), 
						objects[2].toString(), 
						objects[3].toString()));
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			LOG.log(Level.SEVERE, "no se puede CREAR LA PROJECCION");
			session.close();
		}
				
		
		return endList;
	}
	public static void main(String[] args) {

		TramiteDAOImpl tramiteDAOImpl = new TramiteDAOImpl();
		
		List<BeanAvisosNotarialesBandeja> l = tramiteDAOImpl.getAllAvisosBandeja(21);
		
		for (BeanAvisosNotarialesBandeja obj : l) {
			System.out.println(obj.getFolio());
			System.out.println(obj.getEstatus());
			System.out.println("********************************");
		}
		
	}
	public List<BeanAvisosNotarialesBandeja> getAllAvisosBandeja(Integer numNotario){
		SessionFactory sessionFactory = new HibernateUtil().getSessionFactory();
		Session session = sessionFactory.openSession();
		
		List<BeanAvisosNotarialesBandeja> endLista = new ArrayList<BeanAvisosNotarialesBandeja>();
		
		List<Object []> lista;
		
		try {
			Criteria criteria =	 session.createCriteria(Bitacora.class,"bitacora")
					.createCriteria("bitacora.tramite", "tramite")
					.add(Restrictions.eq("tramite.id_fedatario", numNotario))
//					.add(Restrictions.and(Restrictions.sizeGe("tramite.listaBitacora", 3)))
					//.add(Restrictions.and(Restrictions.eq("bitacora.status", "POR PRESENTAR")))
					//.add(Restrictions.or(Restrictions.eq("bitacora.status", "PRESENTADO")))
//					.add(Restrictions.and(Restrictions.eq("bitacora.status", "POR PRESENTAR")))
					.createCriteria("tramite.avisosNotariales", "avisosNotariales")
					
					.setProjection(Projections.projectionList()
							.add(Projections.property("tramite.id"))
							.add(Projections.property("tramite.folio"))
							.add(Projections.property("tramite.creado"))
							.add(Projections.property("avisosNotariales.modalidad"))
							.add(Projections.property("bitacora.status"))
							);
			
			lista = (List<Object[]>) criteria.addOrder(Order.asc("tramite.id") ).list();
			
			
			for (Object[] objects : lista) {
				if (objects[4].toString().equals("PRESENTADO") || objects[4].toString().equals("COMPLETADO")) {
					endLista = this.eliminaAviso((Long) objects[0], endLista);
				}
				endLista.add(new BeanAvisosNotarialesBandeja((Long) objects[0], objects[1].toString(), (Date) objects[2], objects[3].toString(), objects[4].toString()));
			}
			
			session.close();
		} catch (Exception e) {
			session.close();
			e.getMessage();
			LOG.log(Level.SEVERE, "Projection's error ....... ");
		}
		
		return endLista;
	}
	
	private List<BeanAvisosNotarialesBandeja> eliminaAviso(Long id, List<BeanAvisosNotarialesBandeja> lista) {
		
		List<BeanAvisosNotarialesBandeja> endLista = new ArrayList<BeanAvisosNotarialesBandeja>();
		
		for (BeanAvisosNotarialesBandeja obj : lista) {
			if (obj.getId() != id) {
				endLista.add(obj);
			}
		}
		
		return endLista;
	}
	
	public List<BeanAvisosBandejaProtocolo> getAllAvisosXCompletar(){
		SessionFactory sessionFactory = new HibernateUtil().getSessionFactory();
		Session session = sessionFactory.openSession();
		
		List<BeanAvisosBandejaProtocolo> endLista = new ArrayList<BeanAvisosBandejaProtocolo>();
		
		List<Object []> lista;
		
		try {
			Criteria criteria =	 session.createCriteria(Bitacora.class,"bitacora")
					.createCriteria("bitacora.tramite", "tramite")
					.add(Restrictions.sizeEq("tramite.listaBitacora", 2))
					.add(Restrictions.and(Restrictions.eq("bitacora.status", "PRESENTADO")))
					.createCriteria("tramite.avisosNotariales", "avisosNotariales")
					.setProjection(Projections.projectionList()
							
							.add(Projections.property("tramite.id"))
							.add(Projections.property("tramite.folio"))
							.add(Projections.property("tramite.creado"))
							.add(Projections.property("avisosNotariales.modalidad"))
							.add(Projections.property("bitacora.status"))
							.add(Projections.property("tramite.id_fedatario"))
							);
			
			lista = (List<Object[]>) criteria.addOrder(Order.asc("tramite.id") ).list();
			
			
			for (Object[] objects : lista) {
				endLista.add(
						new BeanAvisosBandejaProtocolo((Long) objects[0], (Integer) objects[5], objects[1].toString(), (Date) objects[2], objects[3].toString(), objects[4].toString()));
			}
			session.close();
		} catch (Exception e) {
			session.close();
			e.getMessage();
			LOG.log(Level.SEVERE, "Projection's error ....... ");
		}
		
		return endLista;
	}
	
	public List<BeanAvisosBandejaProtocolo> getAllAvisosCompletados(){
		SessionFactory sessionFactory = new HibernateUtil().getSessionFactory();
		Session session = sessionFactory.openSession();
		
		List<BeanAvisosBandejaProtocolo> endLista = new ArrayList<BeanAvisosBandejaProtocolo>();
		
		List<Object []> lista;
		
		try {
			Criteria criteria =	 session.createCriteria(Bitacora.class,"bitacora").add(Restrictions.eq("bitacora.status", "COMPLETADO"))
					.createCriteria("bitacora.tramite", "tramite")
					.add(Restrictions.sizeEq("tramite.listaBitacora", 3))
					.createCriteria("tramite.avisosNotariales", "avisosNotariales")
//					.add(Restrictions.and(Restrictions.eq("avisosNotariales.modalidad", "AVISO : : APERTURA Y CIERRE")))
					.setProjection(Projections.projectionList()
							.add(Projections.property("tramite.id"))
							.add(Projections.property("tramite.folio"))
							.add(Projections.property("tramite.creado"))
							.add(Projections.property("avisosNotariales.modalidad"))
							.add(Projections.property("bitacora.status"))
							.add(Projections.property("tramite.id_fedatario"))
							);
			
			lista = (List<Object[]>) criteria.addOrder(Order.asc("tramite.id") ).list();
			
			
			for (Object[] objects : lista) {
				endLista.add(
						new BeanAvisosBandejaProtocolo((Long) objects[0], (Integer) objects[5], objects[1].toString(), (Date) objects[2], objects[3].toString(), objects[4].toString()));
			}
			session.close();
		} catch (Exception e) {
			session.close();
			e.getMessage();
			LOG.log(Level.SEVERE, "Projection's error ....... ");
		}
		
		return endLista;
	}
	
	
	
	
	
	///*/*/*
	public List<BeanCopiasBandeja> getAllCopiasBandeja(Integer numNotario){
		SessionFactory sessionFactory = new HibernateUtil().getSessionFactory();
		Session session = sessionFactory.openSession();
		
		List<BeanCopiasBandeja> endLista = new ArrayList<BeanCopiasBandeja>();
		
		List<Object []> lista;
		
		try {
			Criteria criteria =	 session.createCriteria(Bitacora.class,"bitacora")
					.createCriteria("bitacora.tramite", "tramite").add(Restrictions.eq("tramite.id_fedatario", numNotario))
					.createCriteria("tramite.copiaCertificada", "cp")
					
					.setProjection(Projections.projectionList()
							.add(Projections.property("tramite.id"))
							.add(Projections.property("tramite.folio"))
							.add(Projections.property("tramite.creado"))
							.add(Projections.property("cp.modalidad"))
							.add(Projections.property("bitacora.status"))
							);
			
			lista = (List<Object[]>) criteria.addOrder(Order.asc("tramite.id") ).list();
			
			
			for (Object[] objects : lista) {
				if (objects[4].toString().equals("PRESENTADO")) {
					endLista = this.eliminaCopia((Long) objects[0], endLista);
				}
				endLista.add(new BeanCopiasBandeja((Long) objects[0], objects[1].toString(), (Date) objects[2], objects[3].toString(), objects[4].toString()));
			}
			
			session.close();
		} catch (Exception e) {
			session.close();
			e.getMessage();
			LOG.log(Level.SEVERE, "Projection's error ....... ");
		}
		
		return endLista;
	}
	
	private List<BeanCopiasBandeja> eliminaCopia(Long id, List<BeanCopiasBandeja> lista) {
		
		List<BeanCopiasBandeja> endLista = new ArrayList<BeanCopiasBandeja>();
		
		for (BeanCopiasBandeja obj : lista) {
			if (obj.getId() != id) {
				endLista.add(obj);
			}
		}
		
		return endLista;
	}
	
	public List<BeanAvisosBandejaProtocolo> getAvisoPresentadoByFolioTramite(String folio) {
		
		SessionFactory sessionFactory = new HibernateUtil().getSessionFactory();
		Session session = sessionFactory.openSession();
		
		List<BeanAvisosBandejaProtocolo> endLista = new ArrayList<BeanAvisosBandejaProtocolo>();
		
		List<Object []> lista;
		
		try {
			Criteria criteria =	 session.createCriteria(Bitacora.class,"bitacora")
						.add(Restrictions.eq("bitacora.status", "PRESENTADO"))
					.createCriteria("bitacora.tramite", "tramite")
						.add(Restrictions.eq("tramite.folio", folio))
						.add(Restrictions.sizeEq("tramite.listaBitacora", 2))
					.createCriteria("tramite.avisosNotariales", "avisosNotariales")
					.setProjection(Projections.projectionList()
							.add(Projections.property("tramite.id"))
							.add(Projections.property("tramite.folio"))
							.add(Projections.property("tramite.creado"))
							.add(Projections.property("avisosNotariales.modalidad"))
							.add(Projections.property("bitacora.status"))
							.add(Projections.property("tramite.id_fedatario"))
							);
			
			lista = (List<Object[]>) criteria.addOrder(Order.asc("tramite.id") ).list();
			
			
			for (Object[] objects : lista) {
				
				endLista.add(
						new BeanAvisosBandejaProtocolo((Long) objects[0], (Integer) objects[5], objects[1].toString(), (Date) objects[2], objects[3].toString(), objects[4].toString()));
			}
			session.close();
		} catch (Exception e) {
			session.close();
			e.getMessage();
			LOG.log(Level.SEVERE, "Projection's error ....... ");
		}
		
		return endLista;
	}
	public List<BeanAvisosBandejaProtocolo> getAvisoCompletadodoByFolioTramite(String folio) {
		
		SessionFactory sessionFactory = new HibernateUtil().getSessionFactory();
		Session session = sessionFactory.openSession();
		
		List<BeanAvisosBandejaProtocolo> endLista = new ArrayList<BeanAvisosBandejaProtocolo>();
		
		List<Object []> lista;
		
		try {
			Criteria criteria =	 session.createCriteria(Bitacora.class,"bitacora").add(Restrictions.eq("bitacora.status", "COMPLETADO"))
					.createCriteria("bitacora.tramite", "tramite").add(Restrictions.eq("tramite.folio", folio))
					.createCriteria("tramite.avisosNotariales", "avisosNotariales")
					.setProjection(Projections.projectionList()
							.add(Projections.property("tramite.id"))
							.add(Projections.property("tramite.folio"))
							.add(Projections.property("tramite.creado"))
							.add(Projections.property("avisosNotariales.modalidad"))
							.add(Projections.property("bitacora.status"))
							.add(Projections.property("tramite.id_fedatario"))
							);
			
			lista = (List<Object[]>) criteria.addOrder(Order.asc("tramite.id") ).list();
			
			
			for (Object[] objects : lista) {
				
				endLista.add(
						new BeanAvisosBandejaProtocolo((Long) objects[0], (Integer) objects[5], objects[1].toString(), (Date) objects[2], objects[3].toString(), objects[4].toString()));
			}
			session.close();
		} catch (Exception e) {
			session.close();
			e.getMessage();
			LOG.log(Level.SEVERE, "Projection's error ....... ");
		}
		
		return endLista;
	}
	


	public Tramite getTramiteById(Long id) {
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Tramite tramite = null;
		try {
			Criteria criteria =  session.createCriteria(Tramite.class)
					.add(Restrictions.eq("id", id))
					.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
			
			tramite = (Tramite) criteria.uniqueResult();
			System.out.println(tramite.getId());
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
			session.close();
		}
		
		return tramite;
	}
}