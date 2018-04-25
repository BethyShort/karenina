package es.karenina.kwm.capa.aplicacion.recursos.datos.entidades;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the CONTACTOS database table.
 * 
 */
@Entity
@Table(name="CONTACTOS")
@NamedQuery(name="Contacto.findAll", query="SELECT c FROM Contacto c")
public class Contacto implements Serializable {
	private static final long serialVersionUID = 1L;
	private ContactoPK id;
	private String descripcion;
	private Empleado empleado;
	private TpContacto tpContacto;

	public Contacto() {
	}


	@EmbeddedId
	public ContactoPK getId() {
		return this.id;
	}

	public void setId(ContactoPK id) {
		this.id = id;
	}


	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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


	//bi-directional many-to-one association to TpContacto
	@ManyToOne
	@JoinColumn(name="tipo_contacto")
	public TpContacto getTpContacto() {
		return this.tpContacto;
	}

	public void setTpContacto(TpContacto tpContacto) {
		this.tpContacto = tpContacto;
	}

}