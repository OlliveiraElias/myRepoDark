package com.elias.domain;

import java.io.*;

import javax.persistence.*;

@MappedSuperclass
public abstract class AbstractDomain implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
}
