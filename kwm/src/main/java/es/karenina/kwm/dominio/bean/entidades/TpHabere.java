package es.karenina.kwm.dominio.bean.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the TP_HABERES database table.
 * 
 */
@Entity
@Table(name="TP_HABERES")
@NamedQuery(name="TpHabere.findAll", query="SELECT t FROM TpHabere t")
public class TpHabere implements Serializable {
	private static final long serialVersionUID = 1L;
	private byte idHaber;
	private String descripcion;
	private List<Habere> haberes;

	public TpHabere() {
	}


	@Id
	@SequenceGenerator(name="TP_HABERES_IDHABER_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TP_HABERES_IDHABER_GENERATOR")
	@Column(name="id_haber")
	public byte getIdHaber() {
		return this.idHaber;
	}

	public void setIdHaber(byte idHaber) {
		this.idHaber = idHaber;
	}


	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	//bi-directional many-to-one association to Habere
	@OneToMany(mappedBy="tpHabere")
	public List<Habere> getHaberes() {
		return this.haberes;
	}

	public void setHaberes(List<Habere> haberes) {
		this.haberes = haberes;
	}

	public Habere addHabere(Habere habere) {
		getHaberes().add(habere);
		habere.setTpHabere(this);

		return habere;
	}

	public Habere removeHabere(Habere habere) {
		getHaberes().remove(habere);
		habere.setTpHabere(null);

		return habere;
	}

}