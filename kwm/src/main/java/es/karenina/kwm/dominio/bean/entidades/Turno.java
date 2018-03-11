package es.karenina.kwm.dominio.bean.entidades;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the TURNOS database table.
 * 
 */
@Entity
@Table(name="TURNOS")
@NamedQuery(name="Turno.findAll", query="SELECT t FROM Turno t")
public class Turno implements Serializable {
	private static final long serialVersionUID = 1L;
	private byte idTurno;
	private String descripcion;
	private short horaFinalizacion;
	private short horaInicio;

	public Turno() {
	}


	@Id
	@SequenceGenerator(name="TURNOS_IDTURNO_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TURNOS_IDTURNO_GENERATOR")
	@Column(name="id_turno")
	public byte getIdTurno() {
		return this.idTurno;
	}

	public void setIdTurno(byte idTurno) {
		this.idTurno = idTurno;
	}


	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	@Column(name="hora_finalizacion")
	public short getHoraFinalizacion() {
		return this.horaFinalizacion;
	}

	public void setHoraFinalizacion(short horaFinalizacion) {
		this.horaFinalizacion = horaFinalizacion;
	}


	@Column(name="hora_inicio")
	public short getHoraInicio() {
		return this.horaInicio;
	}

	public void setHoraInicio(short horaInicio) {
		this.horaInicio = horaInicio;
	}

}