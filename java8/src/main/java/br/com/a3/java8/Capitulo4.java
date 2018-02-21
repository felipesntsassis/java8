package br.com.a3.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import br.com.a3.java8.pojo.Usuario;

public class Capitulo4 {

	public static void main(String[] args) {
		Usuario user1 = new Usuario("Felipe Assis", 150);
		Usuario user2 = new Usuario("Suellen Assis", 120);
		Usuario user3 = new Usuario("Isabelle Assis", 190);
		
		List<Usuario> usuarios = Arrays.asList(user1, user2, user3);
		Consumer<Usuario> mostraMensagem = u -> System.out.println("antes de imprimir os nomes");
		Consumer<Usuario> imprimeNome = u -> System.out.println(u.getNome());
		
		usuarios.forEach(mostraMensagem.andThen(imprimeNome));
		
		/*Predicate<Usuario> predicado = new Predicate<Usuario>() {
			@Override
			public boolean test(Usuario u) {
				return u.getPontos() > 160;
			}
		};*/
		
		usuarios.removeIf(u -> u.getPontos() > 160);
		usuarios.forEach(u -> System.out.println(u));
	}

}
