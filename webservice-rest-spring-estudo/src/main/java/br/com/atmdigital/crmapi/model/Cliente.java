package br.com.atmdigital.crmapi.model;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.atmdigital.crmapi.common.model.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="cliente")
@Getter
@Setter
@AttributeOverride(name = "id", column = @Column(name = "id_cliente"))
public class Cliente extends AbstractEntity<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Cliente() {}
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="cnpj")
	private String cnpj;
	
	@Column(name="classificacao")
	private Integer classificacao;
	
	@Column(name="segmento")
	private String segmento;
	
	@Column(name="endereco")
	private String endereco;
	
	@Column(name="cidade")
	private String cidade;
	
	@Column(name="estado")
	private String estado;
	
	@Column(name="pais")
	private String pais;
	
	@Column(name="atrasos")
	private Integer atrasos;
	
	@Column(name="valor_atrasos")
	private Float valorAtrasos;
	
	@Column(name="contato_padrao")
	private Integer contatoPadrao;
	
	@Column(name="ativo")
	private Integer ativo;
	
	@Column(name="cadastro_incompleto")
	private Integer cadastroIncompleto;
}
