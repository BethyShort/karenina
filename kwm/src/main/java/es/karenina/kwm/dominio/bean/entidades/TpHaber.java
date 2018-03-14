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
@NamedQuery(name="TpHaber.findAll", query="SELECT t FROM TpHaber t")
public class TpHaber implements Serializable {
	private static final long serialVersionUID = 1L;
	private byte idHaber;
	private String descripcion;
	private List<Haber> haberes;

	public TpHaber() {
	}


	@Id
	@SequenceGenerator(name="TP_HABERES_IDHABER_GENERATOR", sequenceName="TP_HABERES ID_HABER")
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


	//bi-directional many-to-one association to Haber
	@OneToMany(mappedBy="tpHabere")
	public List<Haber> getHaberes() {
		return this.haberes;
	}

	public void setHaberes(List<Haber> haberes) {
		this.haberes = haberes;
	}

	public Haber addHabere(Haber habere) {
		getHaberes().add(habere);
		habere.setTpHabere(this);

		return habere;
	}

	public Haber removeHabere(Haber habere) {
		getHaberes().remove(habere);
		habere.setTpHabere(null);

		return habere;
	}

}