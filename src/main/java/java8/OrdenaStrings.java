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

	/*
	 * O método sort não existia antes na interface List, nem nas suas mães (Collection e Iterable).
	 * A adição deste método na Interface List foi possível graças ao novo recurso do Java 8, o default method.
	 * Com o default method, você pode utilizar o código implementado na interface, caso você assim deseje. 
	 * 
	 * Implementação do método sort na Interface List:
	 *  
	 *	 default void sort(Comparator<? super E> c) {
	 * 		Collections.sort(this, c); 
	 *	}
	 *
	 * Inteface Iterable
	 *
	 * default void forEach(Consumer<? super T> action) {
	 * 		Objects.requireNonNull(action); for (T t : this) { action.accept(t);
	 * } }
	 */

	
	public static void main(String[] args) {

		List<String> palavras = Arrays.asList("Java", "Programação", "WEB", "Código");

		//Lambda
		palavras.sort(Comparator.comparing(s -> s.length()));

		System.out.println(palavras);

		//Method References 
		palavras.forEach(System.out::println);
	}
}
