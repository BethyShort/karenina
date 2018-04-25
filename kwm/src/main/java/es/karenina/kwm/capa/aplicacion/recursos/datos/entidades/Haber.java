package es.karenina.kwm.capa.aplicacion.recursos.datos.entidades;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the HABERES database table.
 * 
 */
@Entity
@Table(name="HABERES")
@NamedQuery(name="Haber.findAll", query="SELECT h FROM Haber h")
public class Haber implements Serializable {
	private static final long serialVersionUID = 1L;
	private HaberPK id;
	private String ejercicioFiscal;
	private TpHaber tpHabere;
	private TpMes tpMes;
	private Contrato contrato;
	private Documento documento;

	public Haber() {
	}


	@EmbeddedId
	public HaberPK getId() {
		return this.id;
	}

	public void setId(HaberPK id) {
		this.id = id;
	}


	@Column(name="ejercicio_fiscal")
	public String getEjercicioFiscal() {
		return this.ejercicioFiscal;
	}

	public void setEjercicioFiscal(String ejercicioFiscal) {
		this.ejercicioFiscal = ejercicioFiscal;
	}


	//bi-directional many-to-one association to TpHaber
	@ManyToOne
	@JoinColumn(name="id_haber")
	public TpHaber getTpHabere() {
		return this.tpHabere;
	}

	public void setTpHabere(TpHaber tpHabere) {
		this.tpHabere = tpHabere;
	}


	//bi-directional many-to-one association to TpMes
	@ManyToOne
	@JoinColumn(name="id_mes")
	public TpMes getTpMes() {
		return this.tpMes;
	}

	public void setTpMes(TpMes tpMes) {
		this.tpMes = tpMes;
	}


	//bi-directional many-to-one association to Contrato
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="id_contrato", referencedColumnName="id_contrato"),
		@JoinColumn(name="id_empleado", referencedColumnName="id_empleado")
		})
	public Contrato getContrato() {
		return this.contrato;
	}

	public void setContrato(Contrato contrato) {
		this.contrato = contrato;
	}


	//bi-directional many-to-one association to Documento
	@ManyToOne
	@JoinColumn(name="id_documento")
	public Documento getDocumento() {
		return this.documento;
	}

	public void setDocumento(Documento documento) {
		this.documento = documento;
	}

}