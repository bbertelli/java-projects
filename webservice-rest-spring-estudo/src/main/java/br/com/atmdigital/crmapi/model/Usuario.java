package br.com.atmdigital.crmapi.model;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.atmdigital.crmapi.common.model.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="usuario")
@Getter
@Setter
@AttributeOverride(name = "id", column = @Column(name = "id_usuario"))
public class Usuario extends AbstractEntity<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Usuario() {}
	
	public Usuario(Long id) {
		this.id = id;
	}
	
	@Column(name="usuario")
	private String usuario;
	
	@JsonIgnore
	@Column(name="senha")
	private String senha;
	
	@Column(name="token")
	private String token;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="ativo")
	private Integer ativo;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_funcao")
	private Funcao idFuncao;
}
