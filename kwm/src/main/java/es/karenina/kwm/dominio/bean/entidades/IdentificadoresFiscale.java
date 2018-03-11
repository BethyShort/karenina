package es.karenina.kwm.dominio.bean.entidades;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the IDENTIFICADORES_FISCALES database table.
 * 
 */
@Entity
@Table(name="IDENTIFICADORES_FISCALES")
@NamedQuery(name="IdentificadoresFiscale.findAll", query="SELECT i FROM IdentificadoresFiscale i")
public class IdentificadoresFiscale implements Serializable {
	private static final long serialVersionUID = 1L;
	private IdentificadoresFiscalePK id;
	private Empleado empleado;
	private TpIdentificadore tpIdentificadore;

	public IdentificadoresFiscale() {
	}


	@EmbeddedId
	public IdentificadoresFiscalePK getId() {
		return this.id;
	}

	public void setId(IdentificadoresFiscalePK id) {
		this.id = id;
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


	//bi-directional many-to-one association to TpIdentificadore
	@ManyToOne
	@JoinColumn(name="id_tipo_identificador")
	public TpIdentificadore getTpIdentificadore() {
		return this.tpIdentificadore;
	}

	public void setTpIdentificadore(TpIdentificadore tpIdentificadore) {
		this.tpIdentificadore = tpIdentificadore;
	}

}