package br.com.atmdigital.crmapi.model;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.atmdigital.crmapi.common.model.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="situacao_relacionamento")
@Getter
@Setter
@AttributeOverride(name = "id", column = @Column(name = "id_situacao_relacionamento"))
public class SituacaoRelacionamento extends AbstractEntity<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public SituacaoRelacionamento() {}
	
	@Column(name="descricao")
	private String descricao;
}
