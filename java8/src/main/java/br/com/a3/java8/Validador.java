package br.com.a3.java8;

@FunctionalInterface
public interface Validador<T> {

	boolean valida(T t);

}
