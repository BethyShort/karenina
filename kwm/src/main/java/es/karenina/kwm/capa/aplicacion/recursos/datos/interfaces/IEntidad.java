package es.karenina.kwm.capa.aplicacion.recursos.datos.interfaces;

import java.io.Serializable;
import java.util.Map;

/**
 *  Abstracción con la que se representarán las entidades en la aplicación
 *   
 *  TODAS LAS CLASES QUE IMPLEMENTEN ESTA INTERFAZ DEBEN IMPLEMENTAR EL CONSTRUCTOR
 *  POR DEFECTO YA QUE EN ALGUNOS PUNTOS SE INSTANCIARÁ POR REFLEXIÓN 
 *
 * @param <J>
 * @param <K>
 */
public interface IEntidad <J extends IEntidadPk> extends Serializable{
  
  /**
   * Devuelve la parte de clave primaria de la entidad
   * @return
   */
  public J getClave();
  
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
