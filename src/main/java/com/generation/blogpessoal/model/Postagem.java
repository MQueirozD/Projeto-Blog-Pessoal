package com.generation.blogpessoal.model;
import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


//indica ao spring q o objeto vai ser uma tabela no banco de dados
@Entity
/*dar o nome da tabale a ser criada.
Sem ela a tabela é criada com o nome objeto*/
@Table(name = "tb_postagens")

public class Postagem {
	@Id //indica q o id da tabela vai sei chave primaria
	@GeneratedValue(strategy = GenerationType.IDENTITY)//seria o auto_increment do mysql 
	private Long id;
	
	//@NotBlank não deixar que o compo comece com espaço
	@NotBlank(message = "O atributo titulo é Obrigatorio!")
	@Size(min=5,max=1000, message = "O atributo título deve conter no mínimo 05 e no máximo 100 caracteres")
	private String titulo;
	
	//@NotNull não deixa que o o campo fica vazio
	@NotNull
	@NotBlank(message="O atributo texto é obrigatório!")
	@Size(min=10,max=1000, message = "O atributo texto deve conter no mínimo 10 e no máximo 100 caracteres")
	private String texto;
	
	@UpdateTimestamp
	//localDateTime = vai me passar o data e o horario automaticamente qnd for postar
	private LocalDateTime data;
	
	@ManyToOne
	@JsonIgnoreProperties("postagem")
	private Tema tema;
	
	@ManyToOne
	@JsonIgnoreProperties("postagem")
	private Usuario usuario;

	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}
	

	public Tema getTema() {
		return tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	

}
