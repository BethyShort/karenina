package es.karenina.kwm.dominio.bean.entidades;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the DIRECCIONES database table.
 * 
 */
@Entity
@Table(name="DIRECCIONES")
@NamedQuery(name="Direccion.findAll", query="SELECT d FROM Direccion d")
public class Direccion implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idDireccion;
	private String bloque;
	private String calle;
	private String ciudad;
	private String codigoPostal;
	private short planta;
	private short portal;
	private String puerta;
	private TpPais tpPais;
	private TpProvincia tpProvincia;

	public Direccion() {
	}


	@Id
	@SequenceGenerator(name="DIRECCIONES_IDDIRECCION_GENERATOR", sequenceName="DIRECCIONES ID_DIRECCION")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="DIRECCIONES_IDDIRECCION_GENERATOR")
	@Column(name="id_direccion")
	public int getIdDireccion() {
		return this.idDireccion;
	}

	public void setIdDireccion(int idDireccion) {
		this.idDireccion = idDireccion;
	}


	public String getBloque() {
		return this.bloque;
	}

	public void setBloque(String bloque) {
		this.bloque = bloque;
	}


	public String getCalle() {
		return this.calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}


	public String getCiudad() {
		return this.ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}


	@Column(name="codigo_postal")
	public String getCodigoPostal() {
		return this.codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}


	public short getPlanta() {
		return this.planta;
	}

	public void setPlanta(short planta) {
		this.planta = planta;
	}


	public short getPortal() {
		return this.portal;
	}

	public void setPortal(short portal) {
		this.portal = portal;
	}


	public String getPuerta() {
		return this.puerta;
	}

	public void setPuerta(String puerta) {
		this.puerta = puerta;
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


	//bi-directional many-to-one association to TpProvincia
	@ManyToOne
	@JoinColumn(name="id_provincia")
	public TpProvincia getTpProvincia() {
		return this.tpProvincia;
	}

	public void setTpProvincia(TpProvincia tpProvincia) {
		this.tpProvincia = tpProvincia;
	}

}