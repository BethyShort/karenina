package es.karenina.kwm.capa.aplicacion.recursos.datos.entidades;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the HABERES database table.
 * 
 */
@Embeddable
public class HaberPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;
	private int idRemuneracion;
	private int idContrato;
	private int idEmpleado;
	private int idDocumento;
	private byte idMes;
	private byte idHaber;

	public HaberPK() {
	}

	@Column(name="id_remuneracion")
	public int getIdRemuneracion() {
		return this.idRemuneracion;
	}
	public void setIdRemuneracion(int idRemuneracion) {
		this.idRemuneracion = idRemuneracion;
	}

	@Column(name="id_contrato", insertable=false, updatable=false)
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

	@Column(name="id_documento", insertable=false, updatable=false)
	public int getIdDocumento() {
		return this.idDocumento;
	}
	public void setIdDocumento(int idDocumento) {
		this.idDocumento = idDocumento;
	}

	@Column(name="id_mes", insertable=false, updatable=false)
	public byte getIdMes() {
		return this.idMes;
	}
	public void setIdMes(byte idMes) {
		this.idMes = idMes;
	}

	@Column(name="id_haber", insertable=false, updatable=false)
	public byte getIdHaber() {
		return this.idHaber;
	}
	public void setIdHaber(byte idHaber) {
		this.idHaber = idHaber;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof HaberPK)) {
			return false;
		}
		HaberPK castOther = (HaberPK)other;
		return 
			(this.idRemuneracion == castOther.idRemuneracion)
			&& (this.idContrato == castOther.idContrato)
			&& (this.idEmpleado == castOther.idEmpleado)
			&& (this.idDocumento == castOther.idDocumento)
			&& (this.idMes == castOther.idMes)
			&& (this.idHaber == castOther.idHaber);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idRemuneracion;
		hash = hash * prime + this.idContrato;
		hash = hash * prime + this.idEmpleado;
		hash = hash * prime + this.idDocumento;
		hash = hash * prime + ((int) this.idMes);
		hash = hash * prime + ((int) this.idHaber);
		
		return hash;
	}
}