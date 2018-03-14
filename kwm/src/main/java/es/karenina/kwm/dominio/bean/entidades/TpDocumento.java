package es.karenina.kwm.dominio.bean.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the TP_DOCUMENTO database table.
 * 
 */
@Entity
@Table(name="TP_DOCUMENTO")
@NamedQuery(name="TpDocumento.findAll", query="SELECT t FROM TpDocumento t")
public class TpDocumento implements Serializable {
	private static final long serialVersionUID = 1L;
	private byte idTpDocumento;
	private String descripcion;
	private List<Documento> documentos;

	public TpDocumento() {
	}


	@Id
	@SequenceGenerator(name="TP_DOCUMENTO_IDTPDOCUMENTO_GENERATOR", sequenceName="TP_DOCUMENTO ID_TP_DOCUMENTO")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TP_DOCUMENTO_IDTPDOCUMENTO_GENERATOR")
	@Column(name="id_tp_documento")
	public byte getIdTpDocumento() {
		return this.idTpDocumento;
	}

	public void setIdTpDocumento(byte idTpDocumento) {
		this.idTpDocumento = idTpDocumento;
	}


	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	//bi-directional many-to-one association to Documento
	@OneToMany(mappedBy="tpDocumento")
	public List<Documento> getDocumentos() {
		return this.documentos;
	}

	public void setDocumentos(List<Documento> documentos) {
		this.documentos = documentos;
	}

	public Documento addDocumento(Documento documento) {
		getDocumentos().add(documento);
		documento.setTpDocumento(this);

		return documento;
	}

	public Documento removeDocumento(Documento documento) {
		getDocumentos().remove(documento);
		documento.setTpDocumento(null);

		return documento;
	}

}