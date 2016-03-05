package br.com.agenda.web.modelo;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Contato {

	private Long id;
	private String nome;
	private String email;
	private String endereco;
	private Calendar dataNascimento;

	public Contato() {
	}

	public Contato(String nome, String email, String endereco,
			Calendar dataNascimento) {
		this.nome = nome;
		this.email = email;
		this.endereco = endereco;
		this.dataNascimento = dataNascimento;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public Calendar getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getDataFormatada(){
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String dataFormat = sdf.format(getDataNascimento().getTime());
		return dataFormat;
	}

	@Override
	public String toString() {

		return "Contato [id=" + id + ", nome=" + nome + ", email=" + email
				+ ", endereco=" + endereco + ", dataNascimento="
				+  getDataFormatada() + "]";

	}

}
