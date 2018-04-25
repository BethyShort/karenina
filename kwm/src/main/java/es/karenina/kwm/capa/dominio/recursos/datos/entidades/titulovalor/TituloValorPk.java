package es.karenina.kwm.capa.dominio.recursos.datos.entidades.titulovalor;


import java.util.HashMap;
import java.util.Map;

import es.karenina.kwm.capa.aplicacion.recursos.datos.interfaces.IEntidadPk;

/**
 * 
 * Objeto que encapsula todos los campos de la entidad que forman parte de la clave
 *
 */
public class TituloValorPk implements IEntidadPk{

  private Number idTituloValor;
  private static final long serialVersionUID = -6863255913428079046L;

  
  /**
   * 
   * @param idTitulo
   */
  public TituloValorPk(){
    idTituloValor=new Integer(0);
  }
  
  
  /**
   * 
   * @param idTitulo
   */
  public TituloValorPk(Integer idTitulo){
    idTituloValor=idTitulo;
  }
  
  @Override
  public Map<String, Object> getCampos() {
    Map<String, Object> campos=new HashMap<String, Object>();
    campos.put("IDTITULOVALOR", idTituloValor);
    return campos;
  }


  public Number getIdTituloValor() {
    return idTituloValor;
  }


  public void setIdTituloValor(Number idTituloValor) {
    this.idTituloValor = idTituloValor;
  }
}
