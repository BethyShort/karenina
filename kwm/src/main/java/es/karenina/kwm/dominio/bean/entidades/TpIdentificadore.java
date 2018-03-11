package es.karenina.kwm.dominio.bean.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the TP_IDENTIFICADORES database table.
 * 
 */
@Entity
@Table(name="TP_IDENTIFICADORES")
@NamedQuery(name="TpIdentificadore.findAll", query="SELECT t FROM TpIdentificadore t")
public class TpIdentificadore implements Serializable {
	private static final long serialVersionUID = 1L;
	private byte idTipoIdentificador;
	private String descripcion;
	private List<IdentificadoresFiscale> identificadoresFiscales;

	public TpIdentificadore() {
	}


	@Id
	@SequenceGenerator(name="TP_IDENTIFICADORES_IDTIPOIDENTIFICADOR_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TP_IDENTIFICADORES_IDTIPOIDENTIFICADOR_GENERATOR")
	@Column(name="id_tipo_identificador")
	public byte getIdTipoIdentificador() {
		return this.idTipoIdentificador;
	}

	public void setIdTipoIdentificador(byte idTipoIdentificador) {
		this.idTipoIdentificador = idTipoIdentificador;
	}


	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	//bi-directional many-to-one association to IdentificadoresFiscale
	@OneToMany(mappedBy="tpIdentificadore")
	public List<IdentificadoresFiscale> getIdentificadoresFiscales() {
		return this.identificadoresFiscales;
	}

	public void setIdentificadoresFiscales(List<IdentificadoresFiscale> identificadoresFiscales) {
		this.identificadoresFiscales = identificadoresFiscales;
	}

	public IdentificadoresFiscale addIdentificadoresFiscale(IdentificadoresFiscale identificadoresFiscale) {
		getIdentificadoresFiscales().add(identificadoresFiscale);
		identificadoresFiscale.setTpIdentificadore(this);

		return identificadoresFiscale;
	}

	public IdentificadoresFiscale removeIdentificadoresFiscale(IdentificadoresFiscale identificadoresFiscale) {
		getIdentificadoresFiscales().remove(identificadoresFiscale);
		identificadoresFiscale.setTpIdentificadore(null);

		return identificadoresFiscale;
	}

}