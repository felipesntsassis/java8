package br.com.a3.java8;

import java.util.function.Consumer;

import br.com.a3.java8.pojo.Usuario;

public class Mostrador implements Consumer<Usuario> {

	public void accept(Usuario u) {
		System.out.println(u.getNome());
	}

}
