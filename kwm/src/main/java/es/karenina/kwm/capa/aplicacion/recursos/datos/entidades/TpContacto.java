package es.karenina.kwm.capa.aplicacion.recursos.datos.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the TP_CONTACTOS database table.
 * 
 */
@Entity
@Table(name="TP_CONTACTOS")
@NamedQuery(name="TpContacto.findAll", query="SELECT t FROM TpContacto t")
public class TpContacto implements Serializable {
	private static final long serialVersionUID = 1L;
	private byte tipoContacto;
	private String descripcion;
	private List<Contacto> contactos;

	public TpContacto() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="tipo_contacto")
	public byte getTipoContacto() {
		return this.tipoContacto;
	}

	public void setTipoContacto(byte tipoContacto) {
		this.tipoContacto = tipoContacto;
	}


	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	//bi-directional many-to-one association to Contacto
	@OneToMany(mappedBy="tpContacto")
	public List<Contacto> getContactos() {
		return this.contactos;
	}

	public void setContactos(List<Contacto> contactos) {
		this.contactos = contactos;
	}

	public Contacto addContacto(Contacto contacto) {
		getContactos().add(contacto);
		contacto.setTpContacto(this);

		return contacto;
	}

	public Contacto removeContacto(Contacto contacto) {
		getContactos().remove(contacto);
		contacto.setTpContacto(null);

		return contacto;
	}

}