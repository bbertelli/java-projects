package br.com.atmdigital.crmapi.security;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class AuthenticationHelper {

	private Long id;
	
	private String name;
	
	private String token;

	private Long funcao;
	
	public AuthenticationHelper(Long id,  String name , String token, Long funcao) {
		this.id = id;
		this.token = token;
		this.name = name;
		this.funcao = funcao;
	}
	
}
