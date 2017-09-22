package br.com.atmdigital.crmapi.model;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.atmdigital.crmapi.common.model.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="cliente_usuario")
@Getter
@Setter
@AttributeOverride(name = "id", column = @Column(name = "id_cliente_usuario"))
public class ClienteUsuario extends AbstractEntity<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ClienteUsuario() {}
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_cliente")
	private Cliente cliente;
		
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_usuario")
	private Usuario usuario;
	
	@Column(name="favorito")
	private Integer favorito;
}
