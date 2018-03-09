package es.karenina.kwm.dominio.recursos.datos.dao.gestores;


import java.util.List;

import app.excepciones.datos.ExcepcionDatos;
import es.karenina.kwm.dominio.recursos.datos.interfaces.IDao;
import es.karenina.kwm.dominio.recursos.datos.interfaces.IEntidad;
import es.karenina.kwm.dominio.recursos.datos.interfaces.IEntidadCuerpo;
import es.karenina.kwm.dominio.recursos.datos.interfaces.IEntidadPk;

/**
 * 
 * Implementación Genérica de un servicio de acceso a datos. Define el de gestor 
 * de acceso a datos con el que va a trabajar
 * 
 *  Además parametriza el tipo de entidad con la que va a trabajar el servicio.
 *  Mientras que el gestor de acceso a datos sería generico para todos los servicios
 *  y dependiente de una tecnología, bien de acceso a datos, bien de almacenamiento,
 *  habrá tantos servicios como tablas en el modelo de negocio.
 *
 * @param <J> <J extends IEntidadPk>     Clave primaria de la tabla
 * @param <K> <K extends IEntidadCuerpo> Resto de campos de la tabla
 * @param <L> <L extends IEntidad>       Entidad de la tabla
 * @param <M> <M extends IDao>           Gestor de acceso a datos especializado
 */
public abstract class AGestorAccesoDatosGenerico <J extends IEntidadPk, K extends IEntidadCuerpo, L extends IEntidad<J,K>, M extends IDao<J,K,L>>{
 
  //solo las clases que hereden el gestor de acceso a datos podr�n acceder al atributo.
	protected M dao;
	
	/**
	 * Define el constructor por defecto que debe tener cualquier Servicio. 
	 * 
	 * @param value Gestor de acceso a datos 
	 */
	AGestorAccesoDatosGenerico(M value) {
		dao=value;
	}

  /**
   * Devuelve la entidad encontrada al buscar por clave primaria.
   * @param pk
   * @param value
   * @return
   */
  abstract L findByPk(final J pk, Class<L> value) throws ExcepcionDatos;

  /**
   * Devuelve una lista con todas los registros que cumplan un criterio de búsqueda
   * @param value
   * @return
   */
  abstract List<L> find(Class<L> value) throws ExcepcionDatos;
  
   /**
   * Devuelve la lista de todas las entidades existentes en una determinada tabla
   * 
   * @param value
   * @return
   */
  abstract List<L> list(Class<L> value) throws ExcepcionDatos;


  /**
   * Crea un registro en la tabla con la entidad recibida como argumento 
   * @param entity
   */
  abstract void create(final L entity) throws ExcepcionDatos;

  /**
   * Actualizar en la tabla los valores de la entidad recibida como argumento
   * @param entity
   * @return
   */
  abstract void update(final L entity) throws ExcepcionDatos;

  /**
   * Borra de la tabla la entidad con la clave recibida como argumento
   *  
   * @param pk
   * @param value
   * @throws ExcepcionTecnica
   */
  abstract void deleteByPk(final J pk, Class<L> value) throws ExcepcionDatos;
  

}