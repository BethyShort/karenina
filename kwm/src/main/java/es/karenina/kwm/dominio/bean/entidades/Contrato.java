package es.karenina.kwm.dominio.bean.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigInteger;
import java.util.List;


/**
 * The persistent class for the CONTRATO database table.
 * 
 */
@Entity
@Table(name="CONTRATO")
@NamedQuery(name="Contrato.findAll", query="SELECT c FROM Contrato c")
public class Contrato implements Serializable {
	private static final long serialVersionUID = 1L;
	private ContratoPK id;
	private byte activo;
	private BigInteger fechaFinalizacion;
	private BigInteger fechaInicio;
	private Empleado empleado;
	private TpContrato tpContrato;
	private List<Habere> haberes;

	public Contrato() {
	}


	@EmbeddedId
	public ContratoPK getId() {
		return this.id;
	}

	public void setId(ContratoPK id) {
		this.id = id;
	}


	public byte getActivo() {
		return this.activo;
	}

	public void setActivo(byte activo) {
		this.activo = activo;
	}


	@Column(name="fecha_finalizacion")
	public BigInteger getFechaFinalizacion() {
		return this.fechaFinalizacion;
	}

	public void setFechaFinalizacion(BigInteger fechaFinalizacion) {
		this.fechaFinalizacion = fechaFinalizacion;
	}


	@Column(name="fecha_inicio")
	public BigInteger getFechaInicio() {
		return this.fechaInicio;
	}

	public void setFechaInicio(BigInteger fechaInicio) {
		this.fechaInicio = fechaInicio;
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


	//bi-directional many-to-one association to TpContrato
	@ManyToOne
	@JoinColumn(name="id_tp_contrato")
	public TpContrato getTpContrato() {
		return this.tpContrato;
	}

	public void setTpContrato(TpContrato tpContrato) {
		this.tpContrato = tpContrato;
	}


	//bi-directional many-to-one association to Habere
	@OneToMany(mappedBy="contrato")
	public List<Habere> getHaberes() {
		return this.haberes;
	}

	public void setHaberes(List<Habere> haberes) {
		this.haberes = haberes;
	}

	public Habere addHabere(Habere habere) {
		getHaberes().add(habere);
		habere.setContrato(this);

		return habere;
	}

	public Habere removeHabere(Habere habere) {
		getHaberes().remove(habere);
		habere.setContrato(null);

		return habere;
	}

}