package copiasCertificadas.reports.enums;

import java.util.ArrayList;
import java.util.List;

public enum Acuse {
	_AVISO_SESION_(1,"/reportes/AvisosSesion.jasper"),
	_C_C_NOTARIO_F_(2,"/reportes/CC_NotarioFisico.jasper"),
	_C_C_NOTARIO_S_(3,"/reportes/copiaNotarioSesion.jasper"),
	_C_C_V_R_A_(4,"/reportes/VentanillaC_R_A.jasper"),
	_C_C_V_PI_(5,"/reportes/VentanillaCPI.jasper");

     private final String descripcion;
     private final int numero;
     static boolean bol=false;
     
     
     private Acuse(final int numero,final String descripcion) {
             this.descripcion = descripcion;
             this.numero = numero;
     }
     
     public String toString(){
             return descripcion;
     }
     
     public int getNumero(){                
             return numero;
     }
     
     public Integer[] todos(){
             return new Integer[]{1,3,5};
     }
     
     
     public static List<Acuse> getTipoCaracter(){
             List<Acuse> l=new ArrayList<Acuse>();
             for(Acuse c:values()){
                     l.add(c);
             }
             
             return l;
     }
     
     public static List<String> getAll(){
             List<String> list=new ArrayList<String>();
             for(Acuse c:values()){
                     list.add(c.descripcion);
                     }
             return list;
             }
     
     
     public static int logValue(String val) {
             int valor=0;
             for(Acuse c:values()){
                     if (c.descripcion==val) {
                             valor=c.numero;                                        
                             }
             }                
             return valor;        
     }
}
