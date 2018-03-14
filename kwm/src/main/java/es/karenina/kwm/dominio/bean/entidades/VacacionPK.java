package es.karenina.kwm.dominio.bean.entidades;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the VACACIONES database table.
 * 
 */
@Embeddable
public class VacacionPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;
	private int idEmpleado;
	private byte idTipoAusencia;
	private short ejercicioFiscal;

	public VacacionPK() {
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

	@Column(name="ejercicio_fiscal")
	public short getEjercicioFiscal() {
		return this.ejercicioFiscal;
	}
	public void setEjercicioFiscal(short ejercicioFiscal) {
		this.ejercicioFiscal = ejercicioFiscal;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof VacacionPK)) {
			return false;
		}
		VacacionPK castOther = (VacacionPK)other;
		return 
			(this.idEmpleado == castOther.idEmpleado)
			&& (this.idTipoAusencia == castOther.idTipoAusencia)
			&& (this.ejercicioFiscal == castOther.ejercicioFiscal);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idEmpleado;
		hash = hash * prime + ((int) this.idTipoAusencia);
		hash = hash * prime + ((int) this.ejercicioFiscal);
		
		return hash;
	}
}