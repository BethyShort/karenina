package es.karenina.kwm.dominio.bean.entidades;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the HORARIOS database table.
 * 
 */
@Embeddable
public class HorarioPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;
	private int idHorario;
	private int idEmpleado;
	private short ejercicioFiscal;
	private byte semana;

	public HorarioPK() {
	}

	@Column(name="id_horario")
	public int getIdHorario() {
		return this.idHorario;
	}
	public void setIdHorario(int idHorario) {
		this.idHorario = idHorario;
	}

	@Column(name="id_empleado", insertable=false, updatable=false)
	public int getIdEmpleado() {
		return this.idEmpleado;
	}
	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	@Column(name="ejercicio_fiscal")
	public short getEjercicioFiscal() {
		return this.ejercicioFiscal;
	}
	public void setEjercicioFiscal(short ejercicioFiscal) {
		this.ejercicioFiscal = ejercicioFiscal;
	}

	public byte getSemana() {
		return this.semana;
	}
	public void setSemana(byte semana) {
		this.semana = semana;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof HorarioPK)) {
			return false;
		}
		HorarioPK castOther = (HorarioPK)other;
		return 
			(this.idHorario == castOther.idHorario)
			&& (this.idEmpleado == castOther.idEmpleado)
			&& (this.ejercicioFiscal == castOther.ejercicioFiscal)
			&& (this.semana == castOther.semana);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idHorario;
		hash = hash * prime + this.idEmpleado;
		hash = hash * prime + ((int) this.ejercicioFiscal);
		hash = hash * prime + ((int) this.semana);
		
		return hash;
	}
}