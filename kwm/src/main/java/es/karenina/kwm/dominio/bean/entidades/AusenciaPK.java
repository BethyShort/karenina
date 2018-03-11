package es.karenina.kwm.dominio.bean.entidades;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the AUSENCIAS database table.
 * 
 */
@Embeddable
public class AusenciaPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;
	private int idAusencia;
	private int idEmpleado;
	private byte idTipoAusencia;

	public AusenciaPK() {
	}

	@Column(name="id_ausencia")
	public int getIdAusencia() {
		return this.idAusencia;
	}
	public void setIdAusencia(int idAusencia) {
		this.idAusencia = idAusencia;
	}

	@Column(name="id_empleado", insertable=false, updatable=false)
	public int getIdEmpleado() {
		return this.idEmpleado;
	}
	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	@Column(name="id_tipo_ausencia", insertable=false, updatable=false)
	public byte getIdTipoAusencia() {
		return this.idTipoAusencia;
	}
	public void setIdTipoAusencia(byte idTipoAusencia) {
		this.idTipoAusencia = idTipoAusencia;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof AusenciaPK)) {
			return false;
		}
		AusenciaPK castOther = (AusenciaPK)other;
		return 
			(this.idAusencia == castOther.idAusencia)
			&& (this.idEmpleado == castOther.idEmpleado)
			&& (this.idTipoAusencia == castOther.idTipoAusencia);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idAusencia;
		hash = hash * prime + this.idEmpleado;
		hash = hash * prime + ((int) this.idTipoAusencia);
		
		return hash;
	}
}