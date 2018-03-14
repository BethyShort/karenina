package es.karenina.kwm.dominio.bean.entidades;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the REL_CONTACTO_DIRECCIONES database table.
 * 
 */
@Entity
@Table(name="REL_CONTACTO_DIRECCIONES")
@NamedQuery(name="RelContactoDireccion.findAll", query="SELECT r FROM RelContactoDireccion r")
public class RelContactoDireccion implements Serializable {
	private static final long serialVersionUID = 1L;
	private RelContactoDireccionPK id;

	public RelContactoDireccion() {
	}


	@EmbeddedId
	public RelContactoDireccionPK getId() {
		return this.id;
	}

	public void setId(RelContactoDireccionPK id) {
		this.id = id;
	}

}