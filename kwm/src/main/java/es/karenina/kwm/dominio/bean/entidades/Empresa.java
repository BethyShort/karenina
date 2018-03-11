package es.karenina.kwm.dominio.bean.entidades;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the EMPRESA database table.
 * 
 */
@Entity
@Table(name="EMPRESA")
@NamedQuery(name="Empresa.findAll", query="SELECT e FROM Empresa e")
public class Empresa implements Serializable {
	private static final long serialVersionUID = 1L;
	private EmpresaPK id;

	public Empresa() {
	}


	@EmbeddedId
	public EmpresaPK getId() {
		return this.id;
	}

	public void setId(EmpresaPK id) {
		this.id = id;
	}

}