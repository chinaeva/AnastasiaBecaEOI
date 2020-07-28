package es.eoi.mundobancario.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "CUENTAS")
public class Cuenta {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer num_cuenta;
	
	@Column
	private String alias;
	@Column
	private Double saldo;
	
	@ManyToOne
	@JoinColumn(name="ID_CLIENTE", referencedColumnName="id")
	private Cliente cliente;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="cuenta")
	private List<Movimiento> movimientos;
	
	@ManyToOne
	@JoinColumn(name="ID_TIPO", referencedColumnName="id")
	private TipoMovimiento tipo;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="cuenta")
	private List<Prestamo> prestamos;
	
	

}
