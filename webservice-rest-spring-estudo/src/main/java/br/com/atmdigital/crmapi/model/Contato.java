package br.com.atmdigital.crmapi.model;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.atmdigital.crmapi.common.model.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="contato")
@Getter
@Setter
@AttributeOverride(name = "id", column = @Column(name = "id_contato"))
public class Contato extends AbstractEntity<Long> {

	private static final long serialVersionUID = 1L;
	
	public Contato() {}
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_cliente")
	private Cliente cliente;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="apelido")
	private String apelido;
	
	@Column(name="funcao")
	private String funcao;
	
	@Column(name="fone")
	private String fone;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="aniversario")
	private Date aniversario;
	
	@Column(name="email")
	private String email;
	
	@Column(name="observacao")
	private String observacao;
	
	@Column(name="ativo")
	private int ativo;
	
	@Column(name="cadastro_incompleto")
	private Integer cadastroIncompleto;
}
