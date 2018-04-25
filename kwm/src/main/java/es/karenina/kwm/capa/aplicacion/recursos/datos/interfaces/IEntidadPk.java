package es.karenina.kwm.capa.aplicacion.recursos.datos.interfaces;

import java.io.Serializable;
import java.util.Map;

/**
 * Interfaz gen�rica que representa las claves primarias de la aplicaci�n
 * 
 *  TODAS LAS CLASES QUE IMPLEMENTEN ESTA INTERFAZ DEBEN IMPLEMENTAR EL CONSTRUCTOR
 *  POR DEFECTO YA QUE EN ALGUNOS PUNTOS SE INSTANCIAR� POR REFLEXI�N 
 *
 */
public interface IEntidadPk extends Serializable {

  /**
   * Devuelve un map con el nombre y el valor de los campos que componen la clave
   * de la entidad
   * @return
   */
  public Map<String, Object> getCampos();
}
