package es.karenina.kwm.dominio.bean.to;

import java.math.BigDecimal;

/**
 * Bean que representa los t�tulos valor en el negocio.
 *
 */
public class TituloValorTo {
  
  private Integer idTituloValor;
  private Long idSociedad;         
  private Long numOperacion;        
  private Byte codTipoValor; 
  private char serie; 
  private BigDecimal nominal;     
  private BigDecimal numTitulos;     
  private Byte codCotizacion;
  private Long fechaTitulo;       
  private Byte indActualizacion;
  private String emision; 
  private String textoLibre;
  private Long fecCap;         
  private Long usuCap;         
  private Long fecMod;         
  private Long usuMod;

  /**
   * Constructor por defecto. 
   */
  public TituloValorTo(){    
    idTituloValor=0;
    idSociedad=0L;         
    numOperacion=0L;        
    codTipoValor=0; 
    serie=' '; 
    nominal=BigDecimal.ZERO;     
    numTitulos=BigDecimal.ZERO;     
    codCotizacion=0;
    fechaTitulo=0L;       
    indActualizacion=0;
    emision=""; 
    textoLibre="";
    fecCap=0L;         
    usuCap=0L;         
    fecMod=0L;         
    usuMod=0L;
  }


  /**
   * Constructor copia de la entidad
   * @param value
   */
  public TituloValorTo(TituloValorTo value){
    
    idTituloValor=value.getIdTituloValor();
    idSociedad=value.getIdSociedad();
    numOperacion=value.getNumOperacion();
    codTipoValor=value.getCodTipoValor();
    serie=value.getSerie();
    nominal=value.getNominal();
    numTitulos=value.getNumTitulos();
    codCotizacion=value.getCodCotizacion();
    fechaTitulo=value.getFechaTitulo();
    indActualizacion=value.getIndActualizacion();
    emision=value.getEmision();
    textoLibre=value.getTextoLibre();
    fecCap=value.getFecCap();
    usuCap=value.getUsuCap();
    fecMod=value.getFecMod();
    usuMod=value.getUsuMod();
  }
  
  public Integer getIdTituloValor() {
    return idTituloValor;
  }
  public Long getIdSociedad() {
    return idSociedad;
  }
  public Long getNumOperacion() {
    return numOperacion;
  }
  public Byte getCodTipoValor() {
    return codTipoValor;
  }
  public char getSerie() {
    return serie;
  }
  public BigDecimal getNominal() {
    return nominal;
  }
  public BigDecimal getNumTitulos() {
    return numTitulos;
  }
  public Byte getCodCotizacion() {
    return codCotizacion;
  }
  public Long getFechaTitulo() {
    return fechaTitulo;
  }
  public Byte getIndActualizacion() {
    return indActualizacion;
  }
  public String getEmision() {
    return emision;
  }
  public String getTextoLibre() {
    return textoLibre;
  }
  public Long getFecCap() {
    return fecCap;
  }
  public Long getUsuCap() {
    return usuCap;
  }
  public Long getFecMod() {
    return fecMod;
  }
  public Long getUsuMod() {
    return usuMod;
  }
  
  public void setIdTituloValor(Integer idTituloValor) {
    this.idTituloValor = idTituloValor;
  }
  public void setIdSociedad(Long idSociedad) {
    this.idSociedad = idSociedad;
  }
  public void setNumOperacion(Long numOperacion) {
    this.numOperacion = numOperacion;
  }
  public void setCodTipoValor(Byte codTipoValor) {
    this.codTipoValor = codTipoValor;
  }
  public void setSerie(char serie) {
    this.serie = serie;
  }
  public void setNominal(BigDecimal nominal) {
    this.nominal = nominal;
  }
  public void setNumTitulos(BigDecimal numTitulos) {
    this.numTitulos = numTitulos;
  }
  public void setCodCotizacion(Byte codCotizacion) {
    this.codCotizacion = codCotizacion;
  }
  public void setFechaTitulo(Long fechaTitulo) {
    this.fechaTitulo = fechaTitulo;
  }
  public void setIndActualizacion(Byte indActualizacion) {
    this.indActualizacion = indActualizacion;
  }
  public void setEmision(String emision) {
    this.emision = emision;
  }
  public void setTextoLibre(String textoLibre) {
    this.textoLibre = textoLibre;
  }
  public void setFecCap(Long fecCap) {
    this.fecCap = fecCap;
  }
  public void setUsuCap(Long usuCap) {
    this.usuCap = usuCap;
  }
  public void setFecMod(Long fecMod) {
    this.fecMod = fecMod;
  }
  public void setUsuMod(Long usuMod) {
    this.usuMod = usuMod;
  }        
}
