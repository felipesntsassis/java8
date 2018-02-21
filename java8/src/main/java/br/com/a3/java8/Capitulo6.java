package br.com.a3.java8;

import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

import br.com.a3.java8.pojo.Usuario;
import br.com.a3.java8.utils.CursoUtils;

public class Capitulo6 {

	public static void main(String[] args) {
		compondoComparators();
		referenciandoMetodos();
		referenciandoConstrutores();
	}

	private static void referenciandoMetodos() {
		Usuario felipe = new Usuario("Felipe Assis", 50);
		Runnable bloco = felipe::tornaModerador;
		bloco.run();
		
		List<Usuario> usuarios = CursoUtils.listarUsuarios();
//		Era assim no Java 7
		for (Usuario u : usuarios) {
			System.out.println(u);
		}
		
//		Agora no Java 8
		usuarios.forEach(System.out::println);
	}

	@SuppressWarnings("unused")
	private static void compondoComparators() {
		List<Usuario> usuarios = CursoUtils.listarUsuarios();
		
//		usuarios.sort(Comparator.comparingInt(u -> u.getPontos()));
		usuarios.sort(Comparator.comparingInt(Usuario::getPontos));
		usuarios.forEach(u -> System.out.println(u.getNome()));
		
		CursoUtils.printSeparator();
		Comparator<Usuario> c = Comparator.comparingInt(Usuario::getPontos).thenComparing(Usuario::getNome);
		usuarios.forEach(u -> System.out.println(u.getNome()));
		
		CursoUtils.printSeparator();
		usuarios.sort(Comparator.comparingInt(Usuario::getPontos).thenComparing(Usuario::getNome));
		usuarios.forEach(u -> System.out.println(u.getNome()));
		
		CursoUtils.printSeparator();
		usuarios.sort(Comparator.comparingInt(Usuario::getPontos).thenComparing(Usuario::getNome).reversed());
		usuarios.forEach(u -> System.out.println(u.getNome()));
	}

	@SuppressWarnings("unused")
	private static void referenciandoConstrutores() {
//		Não funciona! Assim como em expressões lambda, precisamos guardar o resultado em uma interface funcional!
//		Usuario felipe = Usuario::new;
		Supplier<Usuario> criadorDeUsuarios = Usuario::new; 
		Usuario novo = criadorDeUsuarios.get();
		
		Function<String, Usuario> factoryUsuarios = Usuario::new;
		Usuario felipe = factoryUsuarios.apply("Felipe Assis");
		Usuario suellen = factoryUsuarios.apply("Suellen Assis");
		Usuario isabelle = factoryUsuarios.apply("Isabelle Assis");
		
		BiFunction<String, Integer, Usuario> factoryUsuarios2 = Usuario::new;
		Usuario felipeAssis= factoryUsuarios2.apply("Felipe Assis", 50);
		Usuario suellenAssis = factoryUsuarios2.apply("Suellen Assis", 150);
		Usuario isabelleAssis = factoryUsuarios2.apply("Isabelle Assis", 300);
	}

}
