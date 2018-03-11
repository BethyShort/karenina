package es.karenina.kwm.dominio.bean.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigInteger;


/**
 * The persistent class for the AUSENCIAS database table.
 * 
 */
@Entity
@Table(name="AUSENCIAS")
@NamedQuery(name="Ausencia.findAll", query="SELECT a FROM Ausencia a")
public class Ausencia implements Serializable {
	private static final long serialVersionUID = 1L;
	private AusenciaPK id;
	private BigInteger fechaDesde;
	private BigInteger fechaHasta;
	private String observaciones;
	private Empleado empleado;
	private TpAusencia tpAusencia;

	public Ausencia() {
	}


	@EmbeddedId
	public AusenciaPK getId() {
		return this.id;
	}

	public void setId(AusenciaPK id) {
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


	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}


	//bi-directional many-to-one association to Empleado
	@ManyToOne
	@JoinColumn(name="id_empleado")
	public Empleado getEmpleado() {
		return this.empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}


	//bi-directional many-to-one association to TpAusencia
	@ManyToOne
	@JoinColumn(name="id_tipo_ausencia")
	public TpAusencia getTpAusencia() {
		return this.tpAusencia;
	}

	public void setTpAusencia(TpAusencia tpAusencia) {
		this.tpAusencia = tpAusencia;
	}

}