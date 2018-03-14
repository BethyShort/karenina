package es.karenina.kwm.dominio.bean.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the EMPLEADOS database table.
 * 
 */
@Entity
@Table(name="EMPLEADOS")
@NamedQuery(name="Empleado.findAll", query="SELECT e FROM Empleado e")
public class Empleado implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idEmpleado;
	private String apellido1;
	private String apellido2;
	private String nombre;
	private List<Ausencia> ausencias;
	private List<Contacto> contactos;
	private List<Contrato> contratos;
	private List<Horario> horarios;
	private List<IdentificadorFiscal> identificadoresFiscales;
	private List<Vacacion> vacaciones;

	public Empleado() {
	}


	@Id
	@SequenceGenerator(name="EMPLEADOS_IDEMPLEADO_GENERATOR", sequenceName="EMPLEADOS ID_EMPLEADO")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EMPLEADOS_IDEMPLEADO_GENERATOR")
	@Column(name="id_empleado")
	public int getIdEmpleado() {
		return this.idEmpleado;
	}

	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}


	public String getApellido1() {
		return this.apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}


	public String getApellido2() {
		return this.apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}


	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	//bi-directional many-to-one association to Ausencia
	@OneToMany(mappedBy="empleado")
	public List<Ausencia> getAusencias() {
		return this.ausencias;
	}

	public void setAusencias(List<Ausencia> ausencias) {
		this.ausencias = ausencias;
	}

	public Ausencia addAusencia(Ausencia ausencia) {
		getAusencias().add(ausencia);
		ausencia.setEmpleado(this);

		return ausencia;
	}

	public Ausencia removeAusencia(Ausencia ausencia) {
		getAusencias().remove(ausencia);
		ausencia.setEmpleado(null);

		return ausencia;
	}


	//bi-directional many-to-one association to Contacto
	@OneToMany(mappedBy="empleado")
	public List<Contacto> getContactos() {
		return this.contactos;
	}

	public void setContactos(List<Contacto> contactos) {
		this.contactos = contactos;
	}

	public Contacto addContacto(Contacto contacto) {
		getContactos().add(contacto);
		contacto.setEmpleado(this);

		return contacto;
	}

	public Contacto removeContacto(Contacto contacto) {
		getContactos().remove(contacto);
		contacto.setEmpleado(null);

		return contacto;
	}


	//bi-directional many-to-one association to Contrato
	@OneToMany(mappedBy="empleado")
	public List<Contrato> getContratos() {
		return this.contratos;
	}

	public void setContratos(List<Contrato> contratos) {
		this.contratos = contratos;
	}

	public Contrato addContrato(Contrato contrato) {
		getContratos().add(contrato);
		contrato.setEmpleado(this);

		return contrato;
	}

	public Contrato removeContrato(Contrato contrato) {
		getContratos().remove(contrato);
		contrato.setEmpleado(null);

		return contrato;
	}


	//bi-directional many-to-one association to Horario
	@OneToMany(mappedBy="empleado")
	public List<Horario> getHorarios() {
		return this.horarios;
	}

	public void setHorarios(List<Horario> horarios) {
		this.horarios = horarios;
	}

	public Horario addHorario(Horario horario) {
		getHorarios().add(horario);
		horario.setEmpleado(this);

		return horario;
	}

	public Horario removeHorario(Horario horario) {
		getHorarios().remove(horario);
		horario.setEmpleado(null);

		return horario;
	}


	//bi-directional many-to-one association to IdentificadorFiscal
	@OneToMany(mappedBy="empleado")
	public List<IdentificadorFiscal> getIdentificadoresFiscales() {
		return this.identificadoresFiscales;
	}

	public void setIdentificadoresFiscales(List<IdentificadorFiscal> identificadoresFiscales) {
		this.identificadoresFiscales = identificadoresFiscales;
	}

	public IdentificadorFiscal addIdentificadoresFiscale(IdentificadorFiscal identificadoresFiscale) {
		getIdentificadoresFiscales().add(identificadoresFiscale);
		identificadoresFiscale.setEmpleado(this);

		return identificadoresFiscale;
	}

	public IdentificadorFiscal removeIdentificadoresFiscale(IdentificadorFiscal identificadoresFiscale) {
		getIdentificadoresFiscales().remove(identificadoresFiscale);
		identificadoresFiscale.setEmpleado(null);

		return identificadoresFiscale;
	}


	//bi-directional many-to-one association to Vacacion
	@OneToMany(mappedBy="empleado")
	public List<Vacacion> getVacaciones() {
		return this.vacaciones;
	}

	public void setVacaciones(List<Vacacion> vacaciones) {
		this.vacaciones = vacaciones;
	}

	public Vacacion addVacacione(Vacacion vacacione) {
		getVacaciones().add(vacacione);
		vacacione.setEmpleado(this);

		return vacacione;
	}

	public Vacacion removeVacacione(Vacacion vacacione) {
		getVacaciones().remove(vacacione);
		vacacione.setEmpleado(null);

		return vacacione;
	}

}