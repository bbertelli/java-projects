package br.com.atmdigital.crmapi.common.model;

import java.io.Serializable;

public interface IIdentified<ID> extends Serializable {

	public ID getId();

	public void setId(ID id);
}
