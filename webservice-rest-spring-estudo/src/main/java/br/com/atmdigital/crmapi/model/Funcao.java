package br.com.atmdigital.crmapi.model;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.atmdigital.crmapi.common.model.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="funcao")
@Getter
@Setter
@AttributeOverride(name = "id", column = @Column(name = "id_funcao"))
public class Funcao extends AbstractEntity<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Funcao() {}
	
	@Column(name="descricao")
	private String descricao;
}
