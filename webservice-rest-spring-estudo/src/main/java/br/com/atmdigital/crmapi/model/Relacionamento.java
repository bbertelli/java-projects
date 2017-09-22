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
@Table(name="relacionamento")
@Getter
@Setter
@AttributeOverride(name = "id", column = @Column(name = "id_relacionamento"))
public class Relacionamento extends AbstractEntity<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Relacionamento() {}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data_ultimo_followup")
	private Date dataUltimoFollowUp;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data_proximo_followup")
	private Date dataProximoFollowUp;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_cliente")
	private Cliente cliente;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_usuario")
	private Usuario usuario;

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_contato")
	private Contato contato;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_situacao_relacionamento")
	private SituacaoRelacionamento situacaoRelacionamento;

}