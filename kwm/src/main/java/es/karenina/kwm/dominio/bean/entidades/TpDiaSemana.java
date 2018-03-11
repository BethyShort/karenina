package es.karenina.kwm.dominio.bean.entidades;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the TP_DIA_SEMANA database table.
 * 
 */
@Entity
@Table(name="TP_DIA_SEMANA")
@NamedQuery(name="TpDiaSemana.findAll", query="SELECT t FROM TpDiaSemana t")
public class TpDiaSemana implements Serializable {
	private static final long serialVersionUID = 1L;
	private byte idTipoDia;
	private String descripcion;

	public TpDiaSemana() {
	}


	@Id
	@SequenceGenerator(name="TP_DIA_SEMANA_IDTIPODIA_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TP_DIA_SEMANA_IDTIPODIA_GENERATOR")
	@Column(name="id_tipo_dia")
	public byte getIdTipoDia() {
		return this.idTipoDia;
	}

	public void setIdTipoDia(byte idTipoDia) {
		this.idTipoDia = idTipoDia;
	}


	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}