package copiasCertificadas.persist.model.dao;

import java.util.List;

import copiasCertificadas.persist.model.domain.ventanilla.BeanAvisosNotariales;
import copiasCertificadas.persist.model.domain.ventanilla.BeanCopiasCertificadas;
import copiasCertificadas.persist.model.domain.ventanilla.CP_NotarioSesion;
import copiasCertificadas.persist.model.domain.ventanilla.CopiasCertificadasNotario;
import copiasCertificadas.persist.model.domain.ventanilla.avisos.bandeja.BeanAvisosBandejaProtocolo;
import copiasCertificadas.persist.model.domain.ventanilla.avisos.bandeja.BeanAvisosNotarialesBandeja;
import copiasCertificadas.persist.model.domain.ventanilla.copias.bandeja.BeanCopiasBandeja;
import copiasCertificadas.persist.model.domain.ventanilla.tramite.Tramite;

public interface TramiteDAO {
	
	public Tramite saveUpdate(Tramite tramite);
	
	public boolean update(Tramite tramite);
	
	public boolean delate(Tramite tramite);
	
	public Tramite getTramiteById(Long id);
		
	public List<CopiasCertificadasNotario> listaTramitesCPNotarioByName(String nombre, String paterno, String materno);
	
	public List<CP_NotarioSesion> getallCPByNumNotario(Integer num);
	
	public List<CP_NotarioSesion> getallCPByModalidad(Integer num, String modalidad);
	
	public List<BeanCopiasCertificadas> getallCPByModalidad(String modalidad);
	
	public List<CP_NotarioSesion> getallCPByStatusNumNotario(Integer num, String status);
	
	public List<BeanCopiasCertificadas> getallCPByStatus(String status);
	
	public List<BeanCopiasCertificadas> listaTramitesCP();
	
	public List<BeanCopiasCertificadas> listaTramitesCPByFolio(String folio);
	
	public List<BeanAvisosNotariales> getAllAvisosByNumNotario(Integer id);
	
	public List<BeanAvisosNotariales> getAllAvisosByFolioTramite(String folio, Integer num);
	
	public List<BeanAvisosNotariales> getAllAvisosByModalidad(String modalidad, Integer num);
	
	public List<BeanAvisosNotarialesBandeja> getAllAvisosBandeja(Integer numNotario);
	
	public List<BeanAvisosBandejaProtocolo> getAllAvisosXCompletar();
	
	public List<BeanAvisosBandejaProtocolo> getAllAvisosCompletados();
	
	public List<BeanCopiasBandeja> getAllCopiasBandeja(Integer numNotario);
	
	public List<BeanAvisosBandejaProtocolo> getAvisoPresentadoByFolioTramite(String folio);
	
	public List<BeanAvisosBandejaProtocolo> getAvisoCompletadodoByFolioTramite(String folio);
}
