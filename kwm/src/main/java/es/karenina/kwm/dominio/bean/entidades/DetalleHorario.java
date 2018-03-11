package es.karenina.kwm.dominio.bean.entidades;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the DETALLE_HORARIO database table.
 * 
 */
@Entity
@Table(name="DETALLE_HORARIO")
@NamedQuery(name="DetalleHorario.findAll", query="SELECT d FROM DetalleHorario d")
public class DetalleHorario implements Serializable {
	private static final long serialVersionUID = 1L;
	private DetalleHorarioPK id;

	public DetalleHorario() {
	}


	@EmbeddedId
	public DetalleHorarioPK getId() {
		return this.id;
	}

	public void setId(DetalleHorarioPK id) {
		this.id = id;
	}

}