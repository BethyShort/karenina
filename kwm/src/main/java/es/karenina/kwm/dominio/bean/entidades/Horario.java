package es.karenina.kwm.dominio.bean.entidades;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the HORARIOS database table.
 * 
 */
@Entity
@Table(name="HORARIOS")
@NamedQuery(name="Horario.findAll", query="SELECT h FROM Horario h")
public class Horario implements Serializable {
	private static final long serialVersionUID = 1L;
	private HorarioPK id;
	private byte activo;
	private Empleado empleado;

	public Horario() {
	}


	@EmbeddedId
	public HorarioPK getId() {
		return this.id;
	}

	public void setId(HorarioPK id) {
		this.id = id;
	}


	public byte getActivo() {
		return this.activo;
	}

	public void setActivo(byte activo) {
		this.activo = activo;
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

}