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

		//Collections.sort(palavras,comparador);
		/*
		 O método sort não existia antes na interface List, nem nas suas mães (Collection e Iterable)
		 A adição deste método na Interface List foi possível graças ao novo recurso do Java 8, o default method.
		 Com o default method, você pode utilizar o código implementado na interface, caso você assim deseje.
		 Imprementação do método sort na Interface List:
			 default void sort(Comparator<? super E> c) {
	        	Collections.sort(this, c);
	    	 }
		 */
		palavras.sort(new Comparator<String>() {

			 public int compare(String s1, String s2) {
			        if(s1.length() < s2.length()) 
			            return -1;
			        if(s1.length() > s2.length()) 
			            return 1;
			        return 0;
			 }
		});
		
		System.out.println(palavras);
		
		/*for (String p : palavras) {
			System.out.println(p);
		}*/
		
		//outro default method
		/*
		 Inteface Iterable
		 *
			default void forEach(Consumer<? super T> action) {
		        Objects.requireNonNull(action);
		        for (T t : this) {
		            action.accept(t);
		        }
		    }
		 */
		palavras.forEach(new Consumer<String>() {

			public void accept(String s) {
				
				System.out.println(s);
			}
		});
	}
}


