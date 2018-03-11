package es.karenina.kwm.dominio.bean.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigInteger;
import java.util.List;


/**
 * The persistent class for the VACACIONES database table.
 * 
 */
@Entity
@Table(name="VACACIONES")
@NamedQuery(name="Vacacione.findAll", query="SELECT v FROM Vacacione v")
public class Vacacione implements Serializable {
	private static final long serialVersionUID = 1L;
	private VacacionePK id;
	private String diasDisfrutados;
	private String diasPermitidos;
	private BigInteger timestamp;
	private List<PeriodosVacacione> periodosVacaciones;
	private Empleado empleado;
	private TpAusencia tpAusencia;

	public Vacacione() {
	}


	@EmbeddedId
	public VacacionePK getId() {
		return this.id;
	}

	public void setId(VacacionePK id) {
		this.id = id;
	}


	@Column(name="dias_disfrutados")
	public String getDiasDisfrutados() {
		return this.diasDisfrutados;
	}

	public void setDiasDisfrutados(String diasDisfrutados) {
		this.diasDisfrutados = diasDisfrutados;
	}


	@Column(name="dias_permitidos")
	public String getDiasPermitidos() {
		return this.diasPermitidos;
	}

	public void setDiasPermitidos(String diasPermitidos) {
		this.diasPermitidos = diasPermitidos;
	}


	public BigInteger getTimestamp() {
		return this.timestamp;
	}

	public void setTimestamp(BigInteger timestamp) {
		this.timestamp = timestamp;
	}


	//bi-directional many-to-one association to PeriodosVacacione
	@OneToMany(mappedBy="vacacione")
	public List<PeriodosVacacione> getPeriodosVacaciones() {
		return this.periodosVacaciones;
	}

	public void setPeriodosVacaciones(List<PeriodosVacacione> periodosVacaciones) {
		this.periodosVacaciones = periodosVacaciones;
	}

	public PeriodosVacacione addPeriodosVacacione(PeriodosVacacione periodosVacacione) {
		getPeriodosVacaciones().add(periodosVacacione);
		periodosVacacione.setVacacione(this);

		return periodosVacacione;
	}

	public PeriodosVacacione removePeriodosVacacione(PeriodosVacacione periodosVacacione) {
		getPeriodosVacaciones().remove(periodosVacacione);
		periodosVacacione.setVacacione(null);

		return periodosVacacione;
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