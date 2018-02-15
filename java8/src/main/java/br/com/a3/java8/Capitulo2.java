package br.com.a3.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Capitulo2 {

	public static void main(String[] args) {
		Usuario user1 = new Usuario("Felipe Assis", 150);
		Usuario user2 = new Usuario("Suellen Assis", 120);
		Usuario user3 = new Usuario("Isabelle Assis", 190);
		
		List<Usuario> usuarios = Arrays.asList(user1, user2, user3);
		
//		for (Usuario u : usuarios) {
//			System.out.println(u.getNome());
//		}
		/*
		 * Utilizando uma classe que implemente a interface Consumer
		 */
		/*Mostrador mostrador = new Mostrador();
		usuarios.forEach(mostrador);*/
		
		/*
		 * Exemplo instanciando diretamente
		 */
//		usuarios.forEach(new Consumer<Usuario>() {
//			public void accept(Usuario u) {
//				System.out.println(u.getNome());
//			}
//		});
		
		/*
		 * Lambda
		 */
//		Consumer<Usuario> mostrador = (Usuario u) -> { System.out.println(u.getNome()); };
		Consumer<Usuario> mostrador = u -> { System.out.println(u.getNome()); };
		
		usuarios.forEach(u -> System.out.println(u.getNome()));
		usuarios.forEach(u -> u.tornaModerador());
		
//		new Thread(() -> {
//			for (int i = 0; i < 1000; i++) {
//				System.out.println(i);
//			}
//		}).start();
		
		// Exemplo de interface funcional própria
		Validador<String> validadorCEP = new Validador<String>() {
			
			@Override
			public boolean valida(String valor) {
				return valor.matches("[0-9]{5}-[0-9]{3}");
			}
		};
		
		Validador<String> validadorCEPLambda = valor -> {
			return valor.matches("[0-9]{5}-[0-9]{3}");
		};
		
		System.out.println(validadorCEPLambda.valida("81650-040"));
		
		Validador<String> outroValidadorCEPLambda = valor -> valor.matches("[0-9]{5}-[0-9]{3}");
		
		System.out.println(outroValidadorCEPLambda.valida("19905-520"));
	}
}
