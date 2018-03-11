package es.karenina.kwm.dominio.bean.entidades;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the CONTRATO database table.
 * 
 */
@Embeddable
public class ContratoPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;
	private int idContrato;
	private int idEmpleado;

	public ContratoPK() {
	}

	@Column(name="id_contrato")
	public int getIdContrato() {
		return this.idContrato;
	}
	public void setIdContrato(int idContrato) {
		this.idContrato = idContrato;
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
		if (!(other instanceof ContratoPK)) {
			return false;
		}
		ContratoPK castOther = (ContratoPK)other;
		return 
			(this.idContrato == castOther.idContrato)
			&& (this.idEmpleado == castOther.idEmpleado);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idContrato;
		hash = hash * prime + this.idEmpleado;
		
		return hash;
	}
}