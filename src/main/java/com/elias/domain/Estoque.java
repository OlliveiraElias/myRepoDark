package com.elias.domain;

import javax.persistence.*;

@Entity
public class Estoque extends AbstractDomain {
	
	@Column
	private String dsProduto;
	
	@Column
	private Integer qtEstoque;

	public String getDsProduto() {
		return dsProduto;
	}

	public void setDsProduto(String dsProduto) {
		this.dsProduto = dsProduto;
	}

	public Integer getQtEstoque() {
		return qtEstoque;
	}

	public void setQtEstoque(Integer qtEstoque) {
		this.qtEstoque = qtEstoque;
	}
	
}
