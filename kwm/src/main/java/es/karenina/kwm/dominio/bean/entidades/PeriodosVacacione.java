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
@NamedQuery(name="PeriodosVacacione.findAll", query="SELECT p FROM PeriodosVacacione p")
public class PeriodosVacacione implements Serializable {
	private static final long serialVersionUID = 1L;
	private PeriodosVacacionePK id;
	private BigInteger fechaDesde;
	private BigInteger fechaHasta;
	private Vacacione vacacione;

	public PeriodosVacacione() {
	}


	@EmbeddedId
	public PeriodosVacacionePK getId() {
		return this.id;
	}

	public void setId(PeriodosVacacionePK id) {
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


	//bi-directional many-to-one association to Vacacione
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="ejercicio_fiscal", referencedColumnName="ejercicio_fiscal"),
		@JoinColumn(name="id_empleado", referencedColumnName="id_empleado"),
		@JoinColumn(name="id_tipo_ausencia", referencedColumnName="id_tipo_ausencia")
		})
	public Vacacione getVacacione() {
		return this.vacacione;
	}

	public void setVacacione(Vacacione vacacione) {
		this.vacacione = vacacione;
	}

}