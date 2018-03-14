package es.karenina.kwm.dominio.bean.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the TP_AUSENCIA database table.
 * 
 */
@Entity
@Table(name="TP_AUSENCIA")
@NamedQuery(name="TpAusencia.findAll", query="SELECT t FROM TpAusencia t")
public class TpAusencia implements Serializable {
	private static final long serialVersionUID = 1L;
	private byte idTipoAusencia;
	private String descripcion;
	private List<Ausencia> ausencias;
	private List<Vacacion> vacaciones;

	public TpAusencia() {
	}


	@Id
	@SequenceGenerator(name="TP_AUSENCIA_IDTIPOAUSENCIA_GENERATOR", sequenceName="TP_AUSENCIA ID_TIPO_AUSENCIA")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TP_AUSENCIA_IDTIPOAUSENCIA_GENERATOR")
	@Column(name="id_tipo_ausencia")
	public byte getIdTipoAusencia() {
		return this.idTipoAusencia;
	}

	public void setIdTipoAusencia(byte idTipoAusencia) {
		this.idTipoAusencia = idTipoAusencia;
	}


	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	//bi-directional many-to-one association to Ausencia
	@OneToMany(mappedBy="tpAusencia")
	public List<Ausencia> getAusencias() {
		return this.ausencias;
	}

	public void setAusencias(List<Ausencia> ausencias) {
		this.ausencias = ausencias;
	}

	public Ausencia addAusencia(Ausencia ausencia) {
		getAusencias().add(ausencia);
		ausencia.setTpAusencia(this);

		return ausencia;
	}

	public Ausencia removeAusencia(Ausencia ausencia) {
		getAusencias().remove(ausencia);
		ausencia.setTpAusencia(null);

		return ausencia;
	}


	//bi-directional many-to-one association to Vacacion
	@OneToMany(mappedBy="tpAusencia")
	public List<Vacacion> getVacaciones() {
		return this.vacaciones;
	}

	public void setVacaciones(List<Vacacion> vacaciones) {
		this.vacaciones = vacaciones;
	}

	public Vacacion addVacacione(Vacacion vacacione) {
		getVacaciones().add(vacacione);
		vacacione.setTpAusencia(this);

		return vacacione;
	}

	public Vacacion removeVacacione(Vacacion vacacione) {
		getVacaciones().remove(vacacione);
		vacacione.setTpAusencia(null);

		return vacacione;
	}

}