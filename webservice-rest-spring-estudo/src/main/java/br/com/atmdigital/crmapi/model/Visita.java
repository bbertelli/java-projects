package br.com.atmdigital.crmapi.model;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.atmdigital.crmapi.common.model.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="visita")
@Getter
@Setter
@AttributeOverride(name = "id", column = @Column(name = "id_visita"))
public class Visita extends AbstractEntity<Long> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Visita() {}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data_planejada")
	private Date dataPlanejada;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data_fechamento")
	private Date dataFechamento;
	
	@Column(name="contato_planejado")
	private Integer contatoPlanejado;
	
	@Column(name="contato_realizado")
	private Integer contatoRealizado;
	
	@Column(name="objetivos")
	private String objetivos;
	
	@Column(name="reporte")
	private String reporte;
	
	@Column(name="duracao")
	private String duracao;
	
	@Column(name="audio_gravado")
	private String audioGravado;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_cliente")
	private Cliente cliente;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_usuario")
	private Usuario usuario;

	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_situacao_visita")
	private SituacaoVisita situacaoVisita;
}
