package es.karenina.kwm.capa.aplicacion.recursos.datos.entidades;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the IDENTIFICADORES_FISCALES database table.
 * 
 */
@Embeddable
public class IdentificadorFiscalPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;
	private String idIdentificador;
	private int idEmpleado;

	public IdentificadorFiscalPK() {
	}

	@Column(name="id_identificador")
	public String getIdIdentificador() {
		return this.idIdentificador;
	}
	public void setIdIdentificador(String idIdentificador) {
		this.idIdentificador = idIdentificador;
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
		if (!(other instanceof IdentificadorFiscalPK)) {
			return false;
		}
		IdentificadorFiscalPK castOther = (IdentificadorFiscalPK)other;
		return 
			this.idIdentificador.equals(castOther.idIdentificador)
			&& (this.idEmpleado == castOther.idEmpleado);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idIdentificador.hashCode();
		hash = hash * prime + this.idEmpleado;
		
		return hash;
	}
}