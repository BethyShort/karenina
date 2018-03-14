package es.karenina.kwm.dominio.bean.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigInteger;


/**
 * The persistent class for the PERIODOS_VACACIONES database table.
 * 
 */
@Entity
@Table(name="PERIODOS_VACACIONES")
@NamedQuery(name="PeriodoVacacional.findAll", query="SELECT p FROM PeriodoVacacional p")
public class PeriodoVacacional implements Serializable {
	private static final long serialVersionUID = 1L;
	private PeriodoVacacionalPK id;
	private BigInteger fechaDesde;
	private BigInteger fechaHasta;
	private Vacacion vacacione;

	public PeriodoVacacional() {
	}


	@EmbeddedId
	public PeriodoVacacionalPK getId() {
		return this.id;
	}

	public void setId(PeriodoVacacionalPK id) {
		this.id = id;
	}


	@Column(name="fecha_desde")
	public BigInteger getFechaDesde() {
		return this.fechaDesde;
	}

	public void setFechaDesde(BigInteger fechaDesde) {
		this.fechaDesde = fechaDesde;
	}


	@Column(name="fecha_hasta")
	public BigInteger getFechaHasta() {
		return this.fechaHasta;
	}

	public void setFechaHasta(BigInteger fechaHasta) {
		this.fechaHasta = fechaHasta;
	}


	//bi-directional many-to-one association to Vacacion
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="ejercicio_fiscal", referencedColumnName="ejercicio_fiscal"),
		@JoinColumn(name="id_empleado", referencedColumnName="id_empleado"),
		@JoinColumn(name="id_tipo_ausencia", referencedColumnName="id_tipo_ausencia")
		})
	public Vacacion getVacacione() {
		return this.vacacione;
	}

	public void setVacacione(Vacacion vacacione) {
		this.vacacione = vacacione;
	}

}