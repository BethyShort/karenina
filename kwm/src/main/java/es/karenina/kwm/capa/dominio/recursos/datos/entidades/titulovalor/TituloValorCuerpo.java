package es.karenina.kwm.capa.dominio.recursos.datos.entidades.titulovalor;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import es.karenina.kwm.capa.aplicacion.recursos.datos.interfaces.IEntidadCuerpo;


/**
 * 
 * Objeto que encapsula todos los campos de la entidad que no forman parte de la clave
 *
 */
public class TituloValorCuerpo implements IEntidadCuerpo {

  private static final long serialVersionUID = -3649417970669224466L;
  
  private Number idSociedad;         
  private Number numOperacion;        
  private String codTipoValor; 
  private String serie; 
  private Number nominal;     
  private Number numTitulos;     
  private String codCotizacion;
  private Number fechaTitulo;       
  private String indActualizacion;
  private String emision; 
  private String textoLibre;
  private Number fecCap;         
  private Number usuCap;         
  private Number fecMod;         
  private Number usuMod;         
  
  /**
   * Constructor por defecto
   */
  public TituloValorCuerpo(){
  }
  
  @Override
  public Map<String, Object> getCampos() {
    Map<String, Object> resultado=new HashMap<String, Object>();
    resultado.put("IDSOCIEDAD", idSociedad);      
    resultado.put("NUMOPERACION", numOperacion);    
    resultado.put("CODTIPOVALOR", codTipoValor);
    resultado.put("SERIE",serie);           
    resultado.put("NOMINAL",nominal);         
    resultado.put("NUMTITULOS",numTitulos);      
    resultado.put("CODCOTIZACION",codCotizacion);   
    resultado.put("FECHATITULO",fechaTitulo);     
    resultado.put("INDACTUALIZACION",indActualizacion);
    resultado.put("EMISION",emision);         
    resultado.put("TEXTOLIBRE",textoLibre);      
    resultado.put("FECCAP",fecCap);          
    resultado.put("USUCAP",usuCap);          
    resultado.put("FECMOD",fecMod);          
    resultado.put("USUMOD",usuMod);          
    return resultado;
  }

  public Number getIdSociedad() {
    return idSociedad;
  }

  public Number getNumOperacion() {
    return numOperacion;
  }

  public String getCodTipoValor() {
    return codTipoValor;
  }

  public String getSerie() {
    return serie;
  }

  public Number getNominal() {
    return nominal;
  }

  public Number getNumTitulos() {
    return numTitulos;
  }

  public String getCodCotizacion() {
    return codCotizacion;
  }

  public Number getFechaTitulo() {
    return fechaTitulo;
  }

  public String getIndActualizacion() {
    return indActualizacion;
  }

  public String getEmision() {
    return emision;
  }

  public String getTextoLibre() {
    return textoLibre;
  }

  public Number getFecCap() {
    return fecCap;
  }

  public Number getUsuCap() {
    return usuCap;
  }

  public Number getFecMod() {
    return fecMod;
  }

  public Number getUsuMod() {
    return usuMod;
  }

  public void setIdSociedad(Number idSociedad) {
    this.idSociedad = idSociedad;
  }

  public void setNumOperacion(Number numOperacion) {
    this.numOperacion = numOperacion;
  }

  public void setCodTipoValor(String codTipoValor) {
    this.codTipoValor = codTipoValor;
  }

  public void setSerie(String serie) {
    this.serie = serie;
  }

  public void setNominal(Number nominal) {
    this.nominal = nominal;
  }

  public void setNumTitulos(Number numTitulos) {
    this.numTitulos = numTitulos;
  }

  public void setCodCotizacion(String codCotizacion) {
    this.codCotizacion = codCotizacion;
  }

  public void setFechaTitulo(Number fechaTitulo) {
    this.fechaTitulo = fechaTitulo;
  }

  public void setIndActualizacion(String indActualizacion) {
    this.indActualizacion = indActualizacion;
  }

  public void setEmision(String emision) {
    this.emision = emision;
  }

  public void setTextoLibre(String textoLibre) {
    this.textoLibre = textoLibre;
  }

  public void setFecCap(Number fecCap) {
    this.fecCap = fecCap;
  }

  public void setUsuCap(Number usuCap) {
    this.usuCap = usuCap;
  }

  public void setFecMod(Number fecMod) {
    this.fecMod = fecMod;
  }

  public void setUsuMod(Number usuMod) {
    this.usuMod = usuMod;
  }
}
