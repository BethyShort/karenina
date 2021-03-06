package es.karenina.kwm.capa.aplicacion.recursos.datos.dao.proveedores.jdbc.oracle;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import es.karenina.kwm.capa.aplicacion.recursos.datos.interfaces.IDao;
import es.karenina.kwm.capa.aplicacion.recursos.datos.interfaces.IEntidad;
import es.karenina.kwm.capa.aplicacion.recursos.datos.interfaces.IEntidadPk;
import es.karenina.kwm.capa.aplicacion.resources.excepciones.datos.ExcepcionAccesoBBDD;
import es.karenina.kwm.capa.aplicacion.resources.excepciones.datos.ExcepcionDatos;
import es.karenina.kwm.capa.aplicacion.resources.excepciones.jee.ExcepcionJndi;


/**
 * 
 * Clase  
 *  
 * @param <J>
 * @param <K>
 * @param <L>
 */
public class JdbcOracleDaoGenerico <J extends IEntidadPk, L extends IEntidad<J>>  implements IDao<J,    L> {

  
  Connection conexion = null;
  PreparedStatement stmt = null;
  ResultSet rs = null;

  /**
   * 
   * @throws ExcepcionTecnicaAccesoRecursos
   * @throws ExcepcionTecnicaJNDI
   */
  public JdbcOracleDaoGenerico() throws ExcepcionAccesoBBDD,
  ExcepcionJndi {
    super();
  }  
  
  @Override
  public L findByPk(final J pk, Class<L> tipoEntidad) throws ExcepcionDatos {
    
    L entidad=null;


    return entidad;
  }

  @Override
  public List<L> find(Class<L> value) throws ExcepcionDatos {
    return null;
  }
  
  @Override
	public List<L> list(Class<L> value) throws ExcepcionDatos {

    List<L> resultado=new ArrayList<L>();

    return resultado;
  }

  @Override
	public void create(final L entidad)  throws ExcepcionDatos{
	  
  }

  @Override
	public void update(final L entidad) throws ExcepcionDatos {
	  
  }

  @Override
	public void deleteByPk(final J pk, Class<L> value)  throws ExcepcionDatos{}
  
  
  /**
   * Construye una query basada en los valores de la pk, no se tiene en cuenta 
   * ning�n otro valor.
   * 
   * @param pk
   * @param querySB
   * @ return List
   */
  private List<Object> crearCondicionConsultaSimple(J pk, StringBuilder querySB){
    List<Object> parametros=new ArrayList<Object>();
    return parametros;
  }
  
  /**
   * Construye una query basada en los valores de la pk, no se tiene en cuenta 
   * ning�n otro valor.
   * 
   * @param pk
   * @param querySB
   * @ return List
   */
  private List<Object> crearCondicionInsert(L entidad, StringBuilder querySB){
    List<Object> parametros=new ArrayList<Object>();
    
    return parametros;
  }
  
  
  /**
  * 
  * @param rs
  * @return
  * @throws SQLException
  * @throws ExcepcionTecnica
  */
 private List<L> convertirRSaListaEntidad(ResultSet rs, Class<L> tipo) throws SQLException, ExcepcionDatos {
   List<L> listaEntidad = new ArrayList <L> ();   
   return listaEntidad;
 }

  
 /**
  * Se instancia una entidad del tipo parametrizado y se rellena con los datos del
  * resultSet
  * 
  * @param rs
  * @param tipo
  * @return
  * @throws ExcepcionTecnica
  */
  private L resultSetToEntity(ResultSet rs, L entidad)throws ExcepcionDatos{
    
    return entidad;
  }
  
  private void asignarCampos(Serializable instancia, ResultSet rs) throws Exception {}
  
  private String obtenerCamposEntidad(Class<L> tipo) throws Exception {
    StringBuilder resultado=new StringBuilder();
    
    return resultado.toString();
  }


  /**
   * 
   * @param sentencia
   * @param parametros
   * @return
   */
  private ResultSet ejecutaConsulta(String sentencia, List<Object> parametros) throws ExcepcionDatos{
	  ResultSet rs=null;
     
    return rs;
  }
  /**
   * 
   * @param sentencia
   * @param parametros
   * @return
   */
  private void ejecutaUpdate(String sentencia, List<Object> parametros) throws ExcepcionDatos {}
}
