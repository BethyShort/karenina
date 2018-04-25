package es.karenina.kwm.capa.dominio.recursos.datos.entidades.titulovalor;

import java.util.Map;

import es.karenina.kwm.capa.aplicacion.recursos.datos.interfaces.IEntidad;


/**
 * 
 *  Entidades de la tabla ETITULOVALOR
 *
 */
public class EntidadTituloValor implements IEntidad<TituloValorPk, TituloValorCuerpo>{

  private static final long serialVersionUID = -736444752449331873L;
  private TituloValorPk clave;
  private TituloValorCuerpo cuerpo;
  
  /**
   * Constructor por defecto
   */
  public EntidadTituloValor(){
    clave=new TituloValorPk();
    cuerpo=new TituloValorCuerpo();
  }
  
  /**
   * Construcotr de la clase
   * @param pk
   * @param cuerpo
   */
  public EntidadTituloValor(TituloValorPk pk, TituloValorCuerpo cuerpo){
    this.clave=pk;
    this.cuerpo=cuerpo;
  }

  @Override
  public TituloValorPk getClave() {
    return clave;
  }

  @Override
  public TituloValorCuerpo getCuerpo() {
    return cuerpo;
  }


  @Override
  public String getNombreTabla() {
    return "ETITULOVALOR";
  }

  @Override
  public Map<String, Object> getCampos() {
    Map<String, Object> camposClave=clave.getCampos();
    Map<String, Object> camposCuerpo=cuerpo.getCampos();
        
    camposCuerpo.putAll(camposClave);
       
    return camposCuerpo;
  }

}
