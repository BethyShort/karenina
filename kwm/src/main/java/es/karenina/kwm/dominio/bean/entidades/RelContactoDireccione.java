package es.karenina.kwm.dominio.bean.entidades;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the REL_CONTACTO_DIRECCIONES database table.
 * 
 */
@Entity
@Table(name="REL_CONTACTO_DIRECCIONES")
@NamedQuery(name="RelContactoDireccione.findAll", query="SELECT r FROM RelContactoDireccione r")
public class RelContactoDireccione implements Serializable {
	private static final long serialVersionUID = 1L;
	private RelContactoDireccionePK id;

	public RelContactoDireccione() {
	}


	@EmbeddedId
	public RelContactoDireccionePK getId() {
		return this.id;
	}

	public void setId(RelContactoDireccionePK id) {
		this.id = id;
	}

}