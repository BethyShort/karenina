package es.karenina.kwm.dominio.bean.entidades;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the CONTACTOS database table.
 * 
 */
@Embeddable
public class ContactoPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;
	private int idContacto;
	private int idEmpleado;

	public ContactoPK() {
	}

	@Column(name="id_contacto")
	public int getIdContacto() {
		return this.idContacto;
	}
	public void setIdContacto(int idContacto) {
		this.idContacto = idContacto;
	}

	@Column(name="id_empleado", insertable=false, updatable=false)
	public int getIdEmpleado() {
		return this.idEmpleado;
	}
	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ContactoPK)) {
			return false;
		}
		ContactoPK castOther = (ContactoPK)other;
		return 
			(this.idContacto == castOther.idContacto)
			&& (this.idEmpleado == castOther.idEmpleado);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idContacto;
		hash = hash * prime + this.idEmpleado;
		
		return hash;
	}
}