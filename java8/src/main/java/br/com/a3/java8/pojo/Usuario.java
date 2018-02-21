package br.com.a3.java8.pojo;

public class Usuario {

	private String nome;
	private int pontos;
	private boolean moderador;

	public Usuario() {
		
	}

	public Usuario(String nome) {
		this.nome = nome;
	}

	public Usuario(String nome, int pontos) {
		this.nome = nome;
		this.pontos = pontos;
		this.moderador = false;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getPontos() {
		return pontos;
	}

	public void setPontos(int pontos) {
		this.pontos = pontos;
	}

	public void tornaModerador() {
		this.moderador = true;
	}

	public boolean isModerador() {
		return moderador;
	}

	@Override
	public String toString() {
		return "Usuário: " + nome;
	}
}
