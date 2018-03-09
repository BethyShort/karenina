package es.karenina.kwm.dominio.recursos.datos.interfaces;

import java.io.Serializable;
import java.util.Map;

/**
 *  Abstracci�n con la que se representar�n las entidades en la aplicaci�n
 *   
 *  TODAS LAS CLASES QUE IMPLEMENTEN ESTA INTERFAZ DEBEN IMPLEMENTAR EL CONSTRUCTOR
 *  POR DEFECTO YA QUE EN ALGUNOS PUNTOS SE INSTANCIAR� POR REFLEXI�N 
 *
 * @param <J>
 * @param <K>
 */
public interface IEntidad <J extends IEntidadPk, K extends IEntidadCuerpo> extends Serializable{
  
  /**
   * Devuelve la parte de clave primaria de la entidad
   * @return
   */
  public J getClave();
  
  /**
   * Devuelve bean con el resto de campos de la entidad que no son clave primaria
   * @return
   */
  public K getCuerpo();
  
  /**
   * Devuelve el conjunto de campos/valor que constituyen la entidad
   * @return
   */
  public Map<String, Object> getCampos();
  
  /**
   * Devuelve el nombre de la tabla en la que se almacena la entidad
   * @return
   */
  public String getNombreTabla();

 
}
