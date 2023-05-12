package com.unesa.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Departamento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idpto;
	private String nome;
	
	@OneToMany(mappedBy = "departamento")
	private Set<Funcionario> funcionarios;
	
	public Departamento() {}

	public Integer getIdpto() {
		return idpto;
	}

	public void setIdpto(Integer idpto) {
		this.idpto = idpto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Set<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(Set<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}
	
	
}
