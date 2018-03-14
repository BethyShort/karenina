package es.karenina.kwm.dominio.bean.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the TP_MESES database table.
 * 
 */
@Entity
@Table(name="TP_MESES")
@NamedQuery(name="TpMes.findAll", query="SELECT t FROM TpMes t")
public class TpMes implements Serializable {
	private static final long serialVersionUID = 1L;
	private byte idMes;
	private String descripcion;
	private List<Haber> haberes;

	public TpMes() {
	}


	@Id
	@SequenceGenerator(name="TP_MESES_IDMES_GENERATOR", sequenceName="TP_MESES ID_MES")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TP_MESES_IDMES_GENERATOR")
	@Column(name="id_mes")
	public byte getIdMes() {
		return this.idMes;
	}

	public void setIdMes(byte idMes) {
		this.idMes = idMes;
	}


	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	//bi-directional many-to-one association to Haber
	@OneToMany(mappedBy="tpMes")
	public List<Haber> getHaberes() {
		return this.haberes;
	}

	public void setHaberes(List<Haber> haberes) {
		this.haberes = haberes;
	}

	public Haber addHabere(Haber habere) {
		getHaberes().add(habere);
		habere.setTpMes(this);

		return habere;
	}

	public Haber removeHabere(Haber habere) {
		getHaberes().remove(habere);
		habere.setTpMes(null);

		return habere;
	}

}