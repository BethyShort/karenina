package es.karenina.kwm.aplicacion.recursos.datos.dao.proveedores.jdbc.oracle;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import app.excepciones.datos.ExcepcionDatos;
import es.karenina.kwm.dominio.recursos.datos.interfaces.IEntidad;
import es.karenina.kwm.dominio.recursos.datos.interfaces.IEntidadCuerpo;
import es.karenina.kwm.dominio.recursos.datos.interfaces.IEntidadPk;


/**
 * 
 * Define la abstracci�n Entidad que se va a utilizar en el acceso a datos. Debe
 * estar par�metrizada por dos objetos serializables como exige la interfaz que
 * implementa.
 * 
 * El primero de ellos, el campo parametrizado con la interfaz IEntidadPk
 * representar� la clave primaria de la tabla que representa la entidad.
 * 
 * El segundo de los campos parametrizados IEntidadCuerpo representa el resto de
 * campos de la tabla que no forman parte de la clave primaria
 *
 * @param <J>
 *          <J extends IEntidadPk>
 * @param <K>
 *          <K extends IEntidadCuerpo>
 */
class EntidadJdbcOracle<J extends IEntidadPk, K extends IEntidadCuerpo> implements IEntidad<J, K> {

  private static final long serialVersionUID = 1L;
  private J clave;
  private K cuerpo;
  private String nombreTabla;
  private transient Map<String, Object> values = null;

  /**
   * Constructor de la clase. Cualquier entidad debe estar implementada por su
   * clave y cuerpo
   * 
   * @param entityPk
   * @param entityBody
   */
  EntidadJdbcOracle(J entityPk, K entityBody, String nombreTabla)throws ExcepcionDatos {
    if (entityBody== null || entityPk==null){
      throw new ExcepcionDatos();
    }
    
    clave = entityPk;
    cuerpo = entityBody;
    this.nombreTabla = nombreTabla;
  }

  /**
   * Devuelve el atributo "clave" de la entidad
   */
  @Override
  public final J getClave() {
    return clave;
  }

  /**
   * Devuelve el atributo "cuerpo" de la entidad
   */
  @Override
  public final K getCuerpo() {
    return cuerpo;
  }

  static long getSerialversionuid() {
    return serialVersionUID;
  }

  /**
   * Devuelve un map con los campos y valores que componen el cuerpo y la clave
   * de la entidad.
   * 
   * OJO!!! No se est� comprobando que se haya declarado un campo con el mismo
   * nombre en la clave y en el cuerpo. Si esto ocurriese, por un lado,
   * conceptualmente se habr�a implementado una entidad err�nea, y por otro a
   * nivel pr�ctico, en el resultado generado, a ese campo solo se le asignar�a
   * el valor del "cuerpo" de la entidad, que es lo �ltimo que se recorre por
   * reflexi�n.
   * 
   * @return
   */
  @Override
  public Map<String, Object> getCampos() {

    Map<String, Object> camposClave = obtenerCampos(clave);

    // se obtienen los pares nombre/valor del cuerpo
    Map<String, Object> restoCampos = obtenerCampos(cuerpo);

    // se genera el resultado
    restoCampos.putAll(camposClave);
    values = restoCampos;
    return values;
  }

  /**
   * Se recorre por reflexi�n el objeto de tipo serializable recibido.
   * 
   * Como no se distingue entre campos protegidos, privados o p�blicos, se
   * marcan como accesibles. As� que el resultado es una representaci�n de los
   * atributos de la clase, independientemente de sus modificadores de
   * visibilidad
   * 
   * @param value
   * @return
   */
  private Map<String, Object> obtenerCampos(Serializable value) {
    Map<String, Object> resultado = new HashMap<String, Object>();

    // se obtienen los campos de la entidad y se recorren
    Field[] campos = clave.getClass().getDeclaredFields();
    for (Field campo : campos) {
      boolean incluir = true;
      Object valor = null;
      String nombre = campo.getName();

      if (!"serialVersionUID".equalsIgnoreCase(nombre)) {
        try {
          campo.setAccessible(true);
          valor = campo.get(value);
        } catch (IllegalArgumentException e) {
          incluir = false;
        } catch (IllegalAccessException e) {
          incluir = false;
        }

        if (valor != null && incluir)
          resultado.put(nombre, valor);
      }
    }
    return resultado;
  }

  @Override
  public String getNombreTabla() {
    return nombreTabla;
  }
}
