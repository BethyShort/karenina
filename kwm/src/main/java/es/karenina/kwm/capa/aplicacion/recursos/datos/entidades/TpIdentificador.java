package es.karenina.kwm.capa.aplicacion.recursos.datos.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the TP_IDENTIFICADORES database table.
 * 
 */
@Entity
@Table(name="TP_IDENTIFICADORES")
@NamedQuery(name="TpIdentificador.findAll", query="SELECT t FROM TpIdentificador t")
public class TpIdentificador implements Serializable {
	private static final long serialVersionUID = 1L;
	private byte idTipoIdentificador;
	private String descripcion;
	private List<IdentificadorFiscal> identificadoresFiscales;

	public TpIdentificador() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
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


	//bi-directional many-to-one association to IdentificadorFiscal
	@OneToMany(mappedBy="tpIdentificadore")
	public List<IdentificadorFiscal> getIdentificadoresFiscales() {
		return this.identificadoresFiscales;
	}

	public void setIdentificadoresFiscales(List<IdentificadorFiscal> identificadoresFiscales) {
		this.identificadoresFiscales = identificadoresFiscales;
	}

	public IdentificadorFiscal addIdentificadoresFiscale(IdentificadorFiscal identificadoresFiscale) {
		getIdentificadoresFiscales().add(identificadoresFiscale);
		identificadoresFiscale.setTpIdentificadore(this);

		return identificadoresFiscale;
	}

	public IdentificadorFiscal removeIdentificadoresFiscale(IdentificadorFiscal identificadoresFiscale) {
		getIdentificadoresFiscales().remove(identificadoresFiscale);
		identificadoresFiscale.setTpIdentificadore(null);

		return identificadoresFiscale;
	}

}