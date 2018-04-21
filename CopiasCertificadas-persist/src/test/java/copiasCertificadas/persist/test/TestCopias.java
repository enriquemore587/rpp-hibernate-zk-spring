package copiasCertificadas.persist.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;



import copiasCertificadas.persist.model.dao.TramiteDAO;
import copiasCertificadas.persist.model.dao.TramiteDAOImpl;
import copiasCertificadas.persist.model.domain.enums.ModalidadCopias;
import copiasCertificadas.persist.model.domain.enums.Status;
import copiasCertificadas.persist.model.domain.enums.TipoSolicitante;
import copiasCertificadas.persist.model.domain.ventanilla.bitacora.Bitacora;
import copiasCertificadas.persist.model.domain.ventanilla.copias.CopiaCertificada;
import copiasCertificadas.persist.model.domain.ventanilla.copias.Domicilio;
import copiasCertificadas.persist.model.domain.ventanilla.copias.PersonaFisica;
import copiasCertificadas.persist.model.domain.ventanilla.copias.Representante_legal;
import copiasCertificadas.persist.model.domain.ventanilla.instrumento.Instrumento;
import copiasCertificadas.persist.model.domain.ventanilla.pagos.Pagos;
import copiasCertificadas.persist.model.domain.ventanilla.seguimiento.SeguimientoTramite;
import copiasCertificadas.persist.model.domain.ventanilla.tramite.Tramite;

public class TestCopias {
	
	public static void main(String[] args) {
		TestCopias testCopias = new TestCopias();
		
		testCopias.altaApoderado();
		testCopias.altaPersonaFisica();
	}
	
	TramiteDAO tramiteDAO;
	
	private void altaApoderado() {
		Tramite tramite = new Tramite();
			
			CopiaCertificada copiaCertificada = new CopiaCertificada();
			
					PersonaFisica personaFisica = new PersonaFisica();
						personaFisica.setNombre("nombre test");
						personaFisica.setPaterno("paterno test");
						personaFisica.setMaterno("materno test");
						personaFisica.setTipoIdentificacion("tipoIdentificacion test");
						personaFisica.setFolioIdentificacion("folioIdentificacion test");
						
				copiaCertificada.setPersonaFisica(personaFisica);
			
					Domicilio domicilio = new Domicilio();
						domicilio.setCalle("Calle Test");
						domicilio.setNum_ext("num_ext test");
						domicilio.setNum_int("num_int test");
						domicilio.setColonia("colonia test");
						domicilio.setDelegacion("delegacion test");
						domicilio.setCodigo_postal("codigo_postal Test");
						domicilio.setEmail("email test");
						domicilio.setTelefono("telefono test");
						
				copiaCertificada.setDomicilio(domicilio);
				
					Representante_legal representante_legal = new Representante_legal();
						representante_legal.setNombre("nombre test");
						representante_legal.setPaterno("paterno test");
						representante_legal.setMaterno("materno test");
						representante_legal.setIdentificacion_oficial("identificacion_oficial test");
						representante_legal.setFolioIdentificacion("folioIdentificacion test");
						representante_legal.setNum_escritura_poliza_exp(0);
						representante_legal.setFechaEscrituraPolizaExp(new Date());
						representante_legal.setNombre_notario_corredor_juez("nombre_notario_corredor_juez");
						representante_legal.setEntidad_federativa("entidad_federativa");
						representante_legal.setNom_notaria_correduria_juzgado(0);
				
				copiaCertificada.setRepresentante_legal(representante_legal);
				copiaCertificada.setModalidad(ModalidadCopias.EXPED_COPIA_CERTIFICADA_INSTRUMENTO_NOTARIAL.toString());
			
			tramite.setCopiaCertificada(copiaCertificada);
			
			
				List<Instrumento> listaInstrumento = new ArrayList<Instrumento>();
					
					Instrumento instrumento = new Instrumento();
						instrumento.setNum_notaria(0);
						instrumento.setNombre_notario("nombre_notario test");
						instrumento.setPaterno_notario("paterno_notario");
						instrumento.setMaterno_notario("materno_notario");
						instrumento.setNum_notario(0);
						instrumento.setFecha_otorgamiento(new Date());
						instrumento.setNum_instrumento(0);
						instrumento.setVolumen("volumen test");
						instrumento.setNum_suplente(0);
						instrumento.setNum_asociado(0);
						instrumento.setTramite(tramite);
						
					listaInstrumento.add(instrumento);
					
			tramite.setListaInstrumento(listaInstrumento);
			
			tramite.setTipoSolicitante(TipoSolicitante.obtenerSting(6));
			
			List<Pagos> listaPagos = new ArrayList<Pagos>();
				Pagos pagos = new Pagos();
					pagos.setFecha_pago(new Date());
					pagos.setImporte(0.0);
					pagos.setLinea_captura("linea_captura test");
					pagos.setTramite(tramite);
				
				listaPagos.add(pagos);			
			
			tramite.setListaPagos(listaPagos);
			
			List<Bitacora> listaBitacora = new ArrayList<Bitacora>();
				Bitacora bitacora = new Bitacora();
					bitacora.setArea_origen("area_origen Ventanilla test");
					bitacora.setArea_turnado("area_turnado Acervo test");
					bitacora.setObservaciones("observaciones test");
					bitacora.setStatus(Status._ENTREGADO.getTipo());
					bitacora.setUsuario("usuario test");
					bitacora.setTramite(tramite);
				
				listaBitacora.add(bitacora);
			
			tramite.setListaBitacora(listaBitacora);
			
			List<SeguimientoTramite> listaSeguimientos = new ArrayList<SeguimientoTramite>();
				SeguimientoTramite seguimientoTramite = new SeguimientoTramite();
					seguimientoTramite.setDescripcion("TRAMITE PRECAPTURADO Y PASADO POR VENTANILLA");
					seguimientoTramite.setObservaciones("observaciones test");
					seguimientoTramite.setStatus("status test");
					seguimientoTramite.setStatus_gestion("status_gestion test");
					seguimientoTramite.setStatusDesc_gestion("statusDesc_gestion");
					seguimientoTramite.setTramite(tramite);
			listaSeguimientos.add(seguimientoTramite);
			tramite.setListaSeguimientos(listaSeguimientos);
			System.out.println(
					listaSeguimientos.get(0).
					getDescripcion());
			tramite.setFolio("VUCCYT - " + TipoSolicitante._REPRESENTANTE_LEGAL.getDescripcion());
			tramite.setFecha_recepcion(new Date());
			tramiteDAO = new TramiteDAOImpl();			
			
			tramite = tramiteDAO.saveUpdate(tramite);
			if (tramite!=null) {
				System.out.println("correcta persistencia de tramite - --------------------------------");
			}else{
				System.out.println("mala persistencia de tramite x xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
			}
	}
	
	private void altaPersonaFisica() {
		Tramite tramite = new Tramite();
			
			CopiaCertificada copiaCertificada = new CopiaCertificada();
			
					PersonaFisica personaFisica = new PersonaFisica();
						personaFisica.setNombre("nombre test");
						personaFisica.setPaterno("paterno test");
						personaFisica.setMaterno("materno test");
						personaFisica.setTipoIdentificacion("tipoIdentificacion test");
						personaFisica.setFolioIdentificacion("folioIdentificacion test");
						
				copiaCertificada.setPersonaFisica(personaFisica);
			
					Domicilio domicilio = new Domicilio();
						domicilio.setCalle("Calle Test");
						domicilio.setNum_ext("num_ext test");
						domicilio.setNum_int("num_int test");
						domicilio.setColonia("colonia test");
						domicilio.setDelegacion("delegacion test");
						domicilio.setCodigo_postal("codigo_postal Test");
						domicilio.setEmail("email test");
						domicilio.setTelefono("telefono test");
						
				copiaCertificada.setDomicilio(domicilio);
				
				copiaCertificada.setModalidad(ModalidadCopias.EXPED_TESTIMONIO_EFECTOS_INSCRIPCION_INSTRUMENTO_NOTARIAL.toString());
			
			tramite.setCopiaCertificada(copiaCertificada);
			
				List<Instrumento> listaInstrumento = new ArrayList<Instrumento>();
					
					Instrumento instrumento = new Instrumento();
						instrumento.setNum_notaria(0);
						instrumento.setNombre_notario("nombre_notario test");
						instrumento.setPaterno_notario("paterno_notario");
						instrumento.setMaterno_notario("materno_notario");
						instrumento.setNum_notario(0);
						instrumento.setFecha_otorgamiento(new Date());
						instrumento.setNum_instrumento(0);
						instrumento.setVolumen("volumen test");
						instrumento.setNum_suplente(0);
						instrumento.setNum_asociado(0);
						instrumento.setTramite(tramite);
						
					listaInstrumento.add(instrumento);
					
			tramite.setListaInstrumento(listaInstrumento);
			
			tramite.setTipoSolicitante(TipoSolicitante.obtenerSting(3));
			
			List<Pagos> listaPagos = new ArrayList<Pagos>();
				Pagos pagos = new Pagos();
					pagos.setFecha_pago(new Date());
					pagos.setImporte(0.0);
					pagos.setLinea_captura("linea_captura test");
					pagos.setTramite(tramite);
				
				listaPagos.add(pagos);			
			
			tramite.setListaPagos(listaPagos);
			
			List<Bitacora> listaBitacora = new ArrayList<Bitacora>();
				Bitacora bitacora = new Bitacora();
					bitacora.setArea_origen("area_origen Ventanilla test");
					bitacora.setArea_turnado("area_turnado Acervo test");
					bitacora.setObservaciones("observaciones test");
					bitacora.setStatus(Status._ENTREGADO.getTipo());
					bitacora.setUsuario("usuario test");
					bitacora.setTramite(tramite);
				
				listaBitacora.add(bitacora);
			
			tramite.setListaBitacora(listaBitacora);
			
			List<SeguimientoTramite> listaSeguimientos = new ArrayList<SeguimientoTramite>();
				SeguimientoTramite seguimientoTramite = new SeguimientoTramite();
					seguimientoTramite.setDescripcion("TRAMITE PRECAPTURADO Y PASADO POR VENTANILLA");
					seguimientoTramite.setObservaciones("observaciones test");
					seguimientoTramite.setStatus("status test");
					seguimientoTramite.setStatus_gestion("status_gestion test");
					seguimientoTramite.setStatusDesc_gestion("statusDesc_gestion");
					seguimientoTramite.setTramite(tramite);
			listaSeguimientos.add(seguimientoTramite);
			tramite.setListaSeguimientos(listaSeguimientos);
			
			tramiteDAO = new TramiteDAOImpl();			
			tramite.setFolio("VUCCYT - " + TipoSolicitante._PARTICULAR.getDescripcion());
			tramite.setFecha_recepcion(new Date());
			tramite = tramiteDAO.saveUpdate(tramite);
			if (tramite!=null) {
				System.out.println("correcta persistencia de tramite - --------------------------------");
			}else{
				System.out.println("mala persistencia de tramite x xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
			}
	}
}
