package model.usuario;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import model.Endereco;


@Entity
@Inheritance(strategy=InheritanceType.JOINED) 
@Table(name="usuario")
public class Usuario implements Serializable{
	
	public int id;
	public String nome;
	public String cpf;
	public Endereco endereco;
	public String senha;
	public String login;
	public Date dataCriacao;
	public String email;
	public String sexo;
	
	@Transient
	public TipoUsuario tipoUsuario;
	

	public Usuario(){}
	
	public Usuario(String nome, String cpf, Endereco endereco, String senha, String login, String telefone, String sexo) {
		this.nome = nome;
		this.cpf = cpf;
		this.endereco = endereco;
		this.senha = senha;
		this.login = login;
		this.dataCriacao = new Date();
		this.email = telefone;
		this.sexo = sexo;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="idUsuario", nullable=false)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name="nome", nullable=false)
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Column(name="cpf", nullable=false)
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	@ManyToOne(cascade={CascadeType.MERGE, CascadeType.PERSIST})
	@JoinColumn(name="fk_idEndereco",nullable=false)
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	@Column(name="senha", nullable=false)
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	@Column(name="login", nullable=false)
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}
	
	@Column(name="email", nullable=false)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@Column(name="sexo", nullable=false)
	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	@Column(name="dataCriacao", nullable=false)
	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	
	@Transient
	public TipoUsuario getTipoUsuario(){
		return tipoUsuario;
	}

	public void setTipoUsuario(TipoUsuario tipoUsuario){
		this.tipoUsuario = tipoUsuario;
	}
}
