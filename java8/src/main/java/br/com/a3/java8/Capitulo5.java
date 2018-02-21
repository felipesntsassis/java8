package br.com.a3.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

import br.com.a3.java8.pojo.Usuario;
import br.com.a3.java8.utils.CursoUtils;

public class Capitulo5 {

	public static void main(String[] args) {
		List<Usuario> usuarios = CursoUtils.listarUsuarios();
		
//		Comparator<Usuario> comparator = (u1, u2) -> u1.getNome().compareTo(u2.getNome());
//		Collections.sort(usuarios, comparator);
		// Outra forma
		// FIXME: Utilizar String.CASE_INSENSITIVE_ORDER previne erros de null pointer 
		//Collections.sort(usuarios, (u1, u2) -> String.CASE_INSENSITIVE_ORDER.compare(u1.getNome(), u2.getNome()));
		// Usando métodos estáticos da  interface funcional Comparator
		Comparator<Usuario> comparator = Comparator.comparing(u -> u.getNome());
		usuarios.sort(comparator);
		
		usuarios.forEach(u -> System.out.println(u.getNome()));
		
		List<String> palavras = Arrays.asList("Casa do Código", "Alura", "Caelum");
		//Collections.sort(palavras);
		palavras.sort(Comparator.naturalOrder());
		palavras.sort(Comparator.reverseOrder());
		palavras.forEach(palavra -> System.out.println(palavra));
		
		Function<Usuario, String> extrairNome = u -> u.getNome();
		Comparator<Usuario> fnComparator = Comparator.comparing(extrairNome);
		usuarios.sort(fnComparator);
		usuarios.forEach(u -> System.out.println(u.getNome()));
		
		Function<Usuario, Integer> extrairPontos = u -> u.getPontos();
		Comparator<Usuario> pontosComparator = Comparator.comparing(extrairPontos);
		usuarios.sort(pontosComparator);
	}

	public void printSeparator() {
		System.out.println("---------------------------------------");
	}
}
