package es.karenina.kwm.dominio.bean.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the TP_PROVINCIAS database table.
 * 
 */
@Entity
@Table(name="TP_PROVINCIAS")
@NamedQuery(name="TpProvincia.findAll", query="SELECT t FROM TpProvincia t")
public class TpProvincia implements Serializable {
	private static final long serialVersionUID = 1L;
	private short idProvincia;
	private List<Direccione> direcciones;
	private TpPais tpPais;

	public TpProvincia() {
	}


	@Id
	@SequenceGenerator(name="TP_PROVINCIAS_IDPROVINCIA_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TP_PROVINCIAS_IDPROVINCIA_GENERATOR")
	@Column(name="id_provincia")
	public short getIdProvincia() {
		return this.idProvincia;
	}

	public void setIdProvincia(short idProvincia) {
		this.idProvincia = idProvincia;
	}


	//bi-directional many-to-one association to Direccione
	@OneToMany(mappedBy="tpProvincia")
	public List<Direccione> getDirecciones() {
		return this.direcciones;
	}

	public void setDirecciones(List<Direccione> direcciones) {
		this.direcciones = direcciones;
	}

	public Direccione addDireccione(Direccione direccione) {
		getDirecciones().add(direccione);
		direccione.setTpProvincia(this);

		return direccione;
	}

	public Direccione removeDireccione(Direccione direccione) {
		getDirecciones().remove(direccione);
		direccione.setTpProvincia(null);

		return direccione;
	}


	//bi-directional many-to-one association to TpPais
	@ManyToOne
	@JoinColumn(name="id_pais")
	public TpPais getTpPais() {
		return this.tpPais;
	}

	public void setTpPais(TpPais tpPais) {
		this.tpPais = tpPais;
	}

}