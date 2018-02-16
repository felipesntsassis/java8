package br.com.a3.java8;

public class Capitulo3 {

	public static void main(String[] args) {
		Runnable o = () -> {
			System.out.println("O que sou? Que lambda?");
		};
		
		System.out.println(o);
		System.out.println(o.getClass());
		
		
		final int numero = 5;
		new Thread(() -> {
			System.out.println(numero);
		}).start();
	}
}
