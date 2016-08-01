package java8;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

/**
 *
 * @author tiago
 *
 **/
public class OrdenaStrings {

	public static void main(String[] args) {

		List<String> palavras = Arrays.asList("Java", "Programação", "WEB", "Código");

		// Collections.sort(palavras,comparador);
		/*
		 * O método sort não existia antes na interface List, nem nas suas mães
		 * (Collection e Iterable) A adição deste método na Interface List foi
		 * possível graças ao novo recurso do Java 8, o default method. Com o
		 * default method, você pode utilizar o código implementado na
		 * interface, caso você assim deseje. Imprementação do método sort na
		 * Interface List: default void sort(Comparator<? super E> c) {
		 * Collections.sort(this, c); }
		 */
		
		palavras.sort((String s1, String s2) -> Integer.compare(s1.length(), s2.length()));

		System.out.println(palavras);

		/*
		 * for (String p : palavras) { System.out.println(p); }
		 */

		// outro default method
		/*
		 * Inteface Iterable
		 *
		 * default void forEach(Consumer<? super T> action) {
		 * Objects.requireNonNull(action); for (T t : this) { action.accept(t);
		 * } }
		 */
	/*	palavras.forEach((String s) -> {
			System.out.println(s);
		});
*/
		// caso o método receba apenas um parâmetro é possível remover os parênteses
		// e como o método possui apenas um statement é possível também remover as chaves
		palavras.forEach( palavra -> System.out.println(palavra) ); 
	}
}
