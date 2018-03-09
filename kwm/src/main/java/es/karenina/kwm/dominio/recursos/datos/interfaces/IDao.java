package es.karenina.kwm.dominio.recursos.datos.interfaces;

import java.util.List;

import app.excepciones.datos.ExcepcionDatos;


/**
 * Interfaz de definici�n de los Data Access Object de la aplicaci�n 
 *
 * @param <J>
 * @param <K>
 * @param <L>
 */
public interface IDao <J extends IEntidadPk, K extends IEntidadCuerpo, L extends IEntidad<J ,K>>  {

  /**
   * Devuelve la entidad encontrada al buscar por clave primaria.
   * @param pk
   * @param value
   * @return
   */
	L findByPk(final J pk, Class<L> value) throws ExcepcionDatos;

	/**
	 * Devuelve una lista con todas los registros que cumplan un criterio de b�squeda
	 * @param value
	 * @return
	 */
	List<L> find(Class<L> value) throws ExcepcionDatos;
	
	 /**
   * Devuelve la lista de todas las entidades existentes en una determinada tabla
   * 
   * @param value
   * @return
   */
  List<L> list(Class<L> value) throws ExcepcionDatos;


	/**
	 * Crea un registro en la tabla con la entidad recibida como argumento 
	 * @param entity
	 */
	void create(final L entity) throws ExcepcionDatos;

	/**
	 * Actualizar en la tabla los valores de la entidad recibida como argumento
	 * @param entity
	 * @return
	 */
	void update(final L entity) throws ExcepcionDatos;

	/**
	 * Borra de la tabla la entidad con la clave recibida como argumento
	 *  
	 * @param pk
	 * @param value
	 * @throws ExcepcionTecnica
	 */
	void deleteByPk(final J pk, Class<L> value) throws ExcepcionDatos;
	
}