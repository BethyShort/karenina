package es.karenina.kwm.dominio.bean.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the TP_CONTRATOS database table.
 * 
 */
@Entity
@Table(name="TP_CONTRATOS")
@NamedQuery(name="TpContrato.findAll", query="SELECT t FROM TpContrato t")
public class TpContrato implements Serializable {
	private static final long serialVersionUID = 1L;
	private byte idTpContrato;
	private String descripcion;
	private List<Contrato> contratos;

	public TpContrato() {
	}


	@Id
	@SequenceGenerator(name="TP_CONTRATOS_IDTPCONTRATO_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TP_CONTRATOS_IDTPCONTRATO_GENERATOR")
	@Column(name="id_tp_contrato")
	public byte getIdTpContrato() {
		return this.idTpContrato;
	}

	public void setIdTpContrato(byte idTpContrato) {
		this.idTpContrato = idTpContrato;
	}


	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	//bi-directional many-to-one association to Contrato
	@OneToMany(mappedBy="tpContrato")
	public List<Contrato> getContratos() {
		return this.contratos;
	}

	public void setContratos(List<Contrato> contratos) {
		this.contratos = contratos;
	}

	public Contrato addContrato(Contrato contrato) {
		getContratos().add(contrato);
		contrato.setTpContrato(this);

		return contrato;
	}

	public Contrato removeContrato(Contrato contrato) {
		getContratos().remove(contrato);
		contrato.setTpContrato(null);

		return contrato;
	}

}