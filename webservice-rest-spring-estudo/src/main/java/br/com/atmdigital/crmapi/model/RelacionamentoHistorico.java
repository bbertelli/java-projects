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
@Table(name="relacionamento_historico")
@Getter
@Setter
@AttributeOverride(name = "id", column = @Column(name = "id_relacionamento_historico"))
public class RelacionamentoHistorico extends AbstractEntity<Long>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data")
	private Date data;
	
	@Column(name="observacao")
	private String observacao;	
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_relacionamento")
	private Relacionamento relacionamento;

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_cliente")
	private Cliente cliente;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_usuario")
	private Usuario usuario;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_contato")
	private Contato contato;
}
