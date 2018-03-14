package es.karenina.kwm.dominio.bean.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the DOCUMENTOS database table.
 * 
 */
@Entity
@Table(name="DOCUMENTOS")
@NamedQuery(name="Documento.findAll", query="SELECT d FROM Documento d")
public class Documento implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idDocumento;
	private String descripcion;
	private String documento;
	private TpDocumento tpDocumento;
	private List<Haber> haberes;

	public Documento() {
	}


	@Id
	@SequenceGenerator(name="DOCUMENTOS_IDDOCUMENTO_GENERATOR", sequenceName="DOCUMENTOS ID_DOCUMENTO")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="DOCUMENTOS_IDDOCUMENTO_GENERATOR")
	@Column(name="id_documento")
	public int getIdDocumento() {
		return this.idDocumento;
	}

	public void setIdDocumento(int idDocumento) {
		this.idDocumento = idDocumento;
	}


	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public String getDocumento() {
		return this.documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}


	//bi-directional many-to-one association to TpDocumento
	@ManyToOne
	@JoinColumn(name="id_tp_documento")
	public TpDocumento getTpDocumento() {
		return this.tpDocumento;
	}

	public void setTpDocumento(TpDocumento tpDocumento) {
		this.tpDocumento = tpDocumento;
	}


	//bi-directional many-to-one association to Haber
	@OneToMany(mappedBy="documento")
	public List<Haber> getHaberes() {
		return this.haberes;
	}

	public void setHaberes(List<Haber> haberes) {
		this.haberes = haberes;
	}

	public Haber addHabere(Haber habere) {
		getHaberes().add(habere);
		habere.setDocumento(this);

		return habere;
	}

	public Haber removeHabere(Haber habere) {
		getHaberes().remove(habere);
		habere.setDocumento(null);

		return habere;
	}

}