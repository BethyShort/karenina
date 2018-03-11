package es.karenina.kwm.dominio.bean.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the TP_PAISES database table.
 * 
 */
@Entity
@Table(name="TP_PAISES")
@NamedQuery(name="TpPais.findAll", query="SELECT t FROM TpPais t")
public class TpPais implements Serializable {
	private static final long serialVersionUID = 1L;
	private short idPais;
	private String descripcion;
	private List<Direccione> direcciones;
	private List<TpProvincia> tpProvincias;

	public TpPais() {
	}


	@Id
	@SequenceGenerator(name="TP_PAISES_IDPAIS_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TP_PAISES_IDPAIS_GENERATOR")
	@Column(name="id_pais")
	public short getIdPais() {
		return this.idPais;
	}

	public void setIdPais(short idPais) {
		this.idPais = idPais;
	}


	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	//bi-directional many-to-one association to Direccione
	@OneToMany(mappedBy="tpPais")
	public List<Direccione> getDirecciones() {
		return this.direcciones;
	}

	public void setDirecciones(List<Direccione> direcciones) {
		this.direcciones = direcciones;
	}

	public Direccione addDireccione(Direccione direccione) {
		getDirecciones().add(direccione);
		direccione.setTpPais(this);

		return direccione;
	}

	public Direccione removeDireccione(Direccione direccione) {
		getDirecciones().remove(direccione);
		direccione.setTpPais(null);

		return direccione;
	}


	//bi-directional many-to-one association to TpProvincia
	@OneToMany(mappedBy="tpPais")
	public List<TpProvincia> getTpProvincias() {
		return this.tpProvincias;
	}

	public void setTpProvincias(List<TpProvincia> tpProvincias) {
		this.tpProvincias = tpProvincias;
	}

	public TpProvincia addTpProvincia(TpProvincia tpProvincia) {
		getTpProvincias().add(tpProvincia);
		tpProvincia.setTpPais(this);

		return tpProvincia;
	}

	public TpProvincia removeTpProvincia(TpProvincia tpProvincia) {
		getTpProvincias().remove(tpProvincia);
		tpProvincia.setTpPais(null);

		return tpProvincia;
	}

}