package es.karenina.kwm.dominio.bean.entidades;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the IDENTIFICADORES_FISCALES database table.
 * 
 */
@Entity
@Table(name="IDENTIFICADORES_FISCALES")
@NamedQuery(name="IdentificadorFiscal.findAll", query="SELECT i FROM IdentificadorFiscal i")
public class IdentificadorFiscal implements Serializable {
	private static final long serialVersionUID = 1L;
	private IdentificadorFiscalPK id;
	private Empleado empleado;
	private TpIdentificador tpIdentificadore;

	public IdentificadorFiscal() {
	}


	@EmbeddedId
	public IdentificadorFiscalPK getId() {
		return this.id;
	}

	public void setId(IdentificadorFiscalPK id) {
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


	//bi-directional many-to-one association to TpIdentificador
	@ManyToOne
	@JoinColumn(name="id_tipo_identificador")
	public TpIdentificador getTpIdentificadore() {
		return this.tpIdentificadore;
	}

	public void setTpIdentificadore(TpIdentificador tpIdentificadore) {
		this.tpIdentificadore = tpIdentificadore;
	}

}