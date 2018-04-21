package copiasCertificadas.reports.dao;

public interface AcuseDAO {
	public byte[] acuseReporteAvisos(Long id);
	public byte[] busquedaAcuse(Long id);
	public byte[] acuseReporteCC_sesion(Long id);
	public byte[] acuseReporteCC_Representante(Long id);
	public byte[] acuseReporteCC_PI(Long id);
	public byte[] acuseReporteCC_NF(Long id);
}
