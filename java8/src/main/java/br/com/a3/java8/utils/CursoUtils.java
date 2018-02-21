package br.com.a3.java8.utils;

import java.util.Arrays;
import java.util.List;

import br.com.a3.java8.pojo.Usuario;

public class CursoUtils {

	public static List<Usuario> listarUsuarios() {
		Usuario user1 = new Usuario("Felipe Assis", 150);
		Usuario user2 = new Usuario("Suellen Assis", 120);
		Usuario user3 = new Usuario("Isabelle Assis", 190);
		
		return Arrays.asList(user1, user2, user3);
	}

	public static void printSeparator() {
		System.out.println("----------------------------------------------------------------");
	}
}
