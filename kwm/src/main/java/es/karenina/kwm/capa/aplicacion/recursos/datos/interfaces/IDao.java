package es.karenina.kwm.capa.aplicacion.recursos.datos.interfaces;

import java.util.List;

import es.karenina.kwm.capa.aplicacion.resources.excepciones.datos.ExcepcionDatos;

/**
 * Interfaz de definición de los Data Access Object de la aplicación
 *
 * @param <J>
 * @param <K>
 * @param <L>
 */
public interface IDao<J extends IEntidadPk, L extends IEntidad<J>> {

    /**
     * Devuelve la entidad encontrada al buscar por clave primaria.
     * 
     * @param pk
     * @param value
     * @return
     */
    L findByPk(final J pk, Class<L> value) throws ExcepcionDatos;

    /**
     * Devuelve una lista con todas los registros que cumplan un criterio de
     * búsqueda
     * 
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
     * 
     * @param entity
     */
    void create(final L entity) throws ExcepcionDatos;

    /**
     * Actualizar en la tabla los valores de la entidad recibida como argumento
     * 
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