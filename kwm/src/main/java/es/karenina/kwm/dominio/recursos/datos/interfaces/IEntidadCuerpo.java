package es.karenina.kwm.dominio.recursos.datos.interfaces;

import java.io.Serializable;
import java.util.Map;

/**
 * 
 * Representa el conjunto de campos de una entidad que no forman parte de la clave
 * primaria
 * 
 *  TODAS LAS CLASES QUE IMPLEMENTEN ESTA INTERFAZ DEBEN IMPLEMENTAR EL CONSTRUCTOR
 *  POR DEFECTO YA QUE EN ALGUNOS PUNTOS SE INSTANCIAR� POR REFLEXI�N 
 *
 */
public interface IEntidadCuerpo extends Serializable {
  
  /**
   * Devuelve un map con todos los cmapos de la entidad que no forman parte de 
   * la clave.
   * 
   * @return
   */
  public Map<String, Object> getCampos();
}
