package es.karenina.kwm.capa.dominio.recursos.datos.dao.gestores;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import es.karenina.kwm.capa.aplicacion.recursos.datos.dao.proveedores.jdbc.oracle.JdbcOracleDaoGenerico;
import es.karenina.kwm.capa.aplicacion.recursos.datos.interfaces.IDao;
import es.karenina.kwm.capa.aplicacion.resources.excepciones.datos.ExcepcionDatos;
import es.karenina.kwm.capa.dominio.bean.to.TituloValorTo;
import es.karenina.kwm.capa.dominio.recursos.datos.entidades.titulovalor.*;

/**
 * 
 * Gestor de acceso a datos de la tabla ETITULOVALOR
 *
 */
public class GestorAccesoTituloValor extends AGestorAccesoDatosGenerico <TituloValorPk, TituloValorCuerpo, EntidadTituloValor, IDao<TituloValorPk, TituloValorCuerpo, EntidadTituloValor>> {

  private static GestorAccesoTituloValor instance=null;
   
  /**
   * 
   * @return
   */
  public static final GestorAccesoTituloValor getInstance(){
    
    if (instance==null){
      try{
        IDao<TituloValorPk, TituloValorCuerpo, EntidadTituloValor> dao=new JdbcOracleDaoGenerico<TituloValorPk, TituloValorCuerpo, EntidadTituloValor>();
        instance=new GestorAccesoTituloValor(dao);
      }catch(Exception ex){
          System.exit(0);
        }
    }
    return instance;
  }

  /**
   * 
   * @param dao
   */
  private GestorAccesoTituloValor(IDao<TituloValorPk, TituloValorCuerpo, EntidadTituloValor> dao) {
    super(dao);
  }

  /////////////////////////////////////////////////////////////////////
  // BLOQUE DE M�TODOS DE ACCESO A BBDD QUE SE OCULTAN AL MODELO 
  // Estos m�todos no deben utilizarse desde fuera del paquete 
  // resources.data ya que independizan al modelo por 
  // medio del patr�n bridge de verse afectado por cambios en la 
  // tecnolog�a de acceso, almacenamiento y/o cambios en el mo- 
  // delo de datos. 
  /////////////////////////////////////////////////////////////////////
  @Override
  EntidadTituloValor findByPk(TituloValorPk pk, Class<EntidadTituloValor> value) throws ExcepcionDatos {
    return dao.findByPk(pk, value);
  }

  @Override
  List<EntidadTituloValor> find(Class<EntidadTituloValor> value) throws ExcepcionDatos {
    return dao.find(value);
  }

  @Override
  List<EntidadTituloValor> list(Class<EntidadTituloValor> value) throws ExcepcionDatos {
    return dao.list(value);
  }

  @Override
  void create(EntidadTituloValor entity) throws ExcepcionDatos {
    dao.create(entity);
  }

  @Override
  void update(EntidadTituloValor entity) throws ExcepcionDatos {
    dao.update(entity);
  }

  @Override
  void deleteByPk(TituloValorPk pk, Class<EntidadTituloValor> value) throws ExcepcionDatos {
    dao.deleteByPk(pk, value);
  }

  ////////////////////////////////////////////////////////////////////////
  // BLOQUE DE M�TODOS P�BLICOS QUE SE OFRECEN AL MODELO 
  // M�todos de la interfaz que media entre las necesidades
  // del modelo y los m�todos b�sicos de interacci�n con el repositorio
  // que ofrece la interfaz de acceso a datos. 
  ////////////////////////////////////////////////////////////////////////
  /**
   * 
   * @param idTituloValor
   * @return
   * @throws ExcepcionDatos
   */
  public TituloValorTo buscarTituloValorPorClave(Integer idTituloValor) throws ExcepcionDatos {
    TituloValorPk clave = new TituloValorPk(idTituloValor);
    EntidadTituloValor resultado = findByPk(clave, EntidadTituloValor.class);
    return entidadToBean(resultado);
  }

  /**
   * De momento este tipo de m�todos no est�n implementados
   * 
   * @param value
   * @return
   * @throws ExcepcionDatos
   */
  public List<EntidadTituloValor> buscarTituloValorPorCriterio() throws ExcepcionDatos {
    return new ArrayList<EntidadTituloValor>();
  }

  /**
   * Devuelve todas las entidades existentes en la tabla ETITULOVALOR
   * 
   * @return
   * @throws ExcepcionDatos
   */
  public List<EntidadTituloValor> listarTodos() throws ExcepcionDatos {
    return list(EntidadTituloValor.class);
  }

  /**
   * Crea la entidad correspondiente al bean recibido y lo inserta en
   * ETITULOVALOR
   * 
   * @param valor
   * @throws ExcepcionDatos
   */
  public void insertarTituloValor(TituloValorTo valor) throws ExcepcionDatos {
    EntidadTituloValor entidad = beanToEntidad(valor);
    create(entidad);
  }

  /**
   * Actualiza la entidad de ETITULOVALOR con los valores del bean recibido
   * 
   * @param valor
   * @throws ExcepcionDatos
   */
  public void actualizarTituloValor(TituloValorTo valor) throws ExcepcionDatos {
    EntidadTituloValor entidad = beanToEntidad(valor);
    update(entidad);
  }

  /**
   * 
   * @param idTitulo
   * @throws ExcepcionDatos
   */
  public void borrarTitulo(Integer idTitulo) throws ExcepcionDatos {
    TituloValorPk clave = new TituloValorPk(idTitulo);
    deleteByPk(clave, EntidadTituloValor.class);
  }

  ////////////////////////////////////////////////////////////////////////////////
  // BLOQUE DE M�TODOS DE TRANSFORMACI�N ENTRE CAPA DE MODEL Y ACCESO A DATOS
  ///////////////////////////////////////////////////////////////////////////////
  /**
   * Transforma una entidad t�tulo valor a su bean de negocio correspondiente
   * 
   * @param entidad
   * @return
   */
  private TituloValorTo entidadToBean(EntidadTituloValor entidad) {
    TituloValorTo to = new TituloValorTo();
    TituloValorPk clave = entidad.getClave();
    TituloValorCuerpo cuerpo = entidad.getCuerpo();

    if (clave.getIdTituloValor() != null)
      to.setIdTituloValor(clave.getIdTituloValor().intValue());

    if (cuerpo.getIdSociedad() != null)
      to.setIdSociedad(cuerpo.getIdSociedad().longValue());

    if (cuerpo.getNumOperacion() != null)
      to.setNumOperacion(cuerpo.getNumOperacion().longValue());

    if (cuerpo.getCodTipoValor() != null)
      to.setCodTipoValor(new Byte(cuerpo.getCodTipoValor()));

    if (cuerpo.getSerie() != null)
      to.setSerie(cuerpo.getSerie().toCharArray()[0]);

    if (cuerpo.getNominal() != null)
      to.setNominal(new BigDecimal(cuerpo.getNominal().toString()));

    if (cuerpo.getNumTitulos() != null)
      to.setNumTitulos(new BigDecimal(cuerpo.getNumTitulos().toString()));

    if (cuerpo.getCodCotizacion() != null)
      to.setCodCotizacion(new Byte(cuerpo.getCodCotizacion()));

    if (cuerpo.getFechaTitulo() != null)
      to.setFechaTitulo(cuerpo.getFechaTitulo().longValue());

    if (cuerpo.getIndActualizacion() != null)
      to.setIndActualizacion(new Byte(cuerpo.getIndActualizacion()));

    if (cuerpo.getEmision() != null)
      to.setEmision(cuerpo.getEmision());

    if (cuerpo.getTextoLibre() != null)
      to.setTextoLibre(cuerpo.getTextoLibre());

    if (cuerpo.getFecCap() != null)
      to.setFecCap(cuerpo.getFecCap().longValue());

    if (cuerpo.getUsuCap() != null)
      to.setUsuCap(cuerpo.getUsuCap().longValue());

    if (cuerpo.getFecMod() != null)
      to.setFecMod(cuerpo.getFecMod().longValue());

    if (cuerpo.getUsuMod() != null)
      to.setUsuMod(cuerpo.getUsuMod().longValue());

    return to;
  }

  /**
   * Transforma un bean titulo valor de negocio a la entidad correspondiente
   * 
   * @param to
   * @return
   */
  private EntidadTituloValor beanToEntidad(TituloValorTo to) {
    TituloValorPk clave = new TituloValorPk(to.getIdTituloValor());
    TituloValorCuerpo cuerpo = new TituloValorCuerpo();
    EntidadTituloValor entidad;

    cuerpo.setIdSociedad(to.getIdSociedad());
    cuerpo.setNumOperacion(to.getNumOperacion());
    cuerpo.setCodTipoValor(to.getCodTipoValor().toString());
    cuerpo.setSerie(String.valueOf(to.getSerie()));
    cuerpo.setNominal(to.getNominal());
    cuerpo.setNumTitulos(to.getNumTitulos());
    cuerpo.setCodCotizacion(to.getCodCotizacion().toString());
    cuerpo.setFechaTitulo(to.getFechaTitulo());
    cuerpo.setIndActualizacion(to.getIndActualizacion().toString());
    cuerpo.setEmision(to.getEmision());
    cuerpo.setTextoLibre(to.getTextoLibre());
    cuerpo.setFecCap(to.getFecCap());
    cuerpo.setUsuCap(to.getUsuCap());
    cuerpo.setFecMod(to.getFecMod());
    cuerpo.setUsuMod(to.getUsuMod());

    entidad = new EntidadTituloValor(clave, cuerpo);
    return entidad;
  }
}
