package br.blog.tiagorocha;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
*
*@author tiago
*
**/

class Curso {
    private String nome;
    private int alunos;

    public Curso(String nome, int alunos) {
    	this.nome = nome;
    	this.alunos = alunos;
	}

    public String getNome() {
    	return nome;
    }

    public int getAlunos() {
    	return alunos;
    }
    
    @Override
    public String toString() {
    	return this.nome;
    }
}

public class ExemploCursos {
	
	public static void main(String[] args) {
		
		List<Curso> cursos = new ArrayList<Curso>();
		cursos.add(new Curso("Python",45));
		cursos.add(new Curso("JavaScript", 150));
		cursos.add(new Curso("Java 8", 113));
		cursos.add(new Curso("C", 55));
		
		cursos.sort(Comparator.comparing(Curso::getAlunos));
		
		System.out.println("Cursos com pelo menos 100 alunos matriculados:");
		
		cursos.stream()
			.filter( c -> c.getAlunos() >= 100)
			.forEach(c -> System.out.println(c.getNome()));
		
		int sum = cursos.stream()
			.filter(c -> c.getAlunos() >= 100)
			.mapToInt(Curso::getAlunos)
			.sum();	
		
		OptionalDouble media = cursos.stream()
									.filter(c -> c.getAlunos() >= 100)
									.mapToInt(Curso::getAlunos)
									.average();	
		
		System.out.println("**********************");
		System.out.println("Total de Alunos: "+sum);
		

		/*Optional<Curso> optionalCurso = cursos.stream()
											.filter(c -> c.getAlunos() >= 100)
											.findAny();
		
		Curso curso = optionalCurso.orElse(null);
		
		curso.ifPresent(c -> System.out.println(c.getNome()));
		*/
		
		cursos.stream()
				.filter(c -> c.getAlunos() >= 100)
				.findAny()
				.ifPresent(c -> System.out.println(c.getNome()));
		
		List<Curso> listCursos = cursos.stream()
			 	.filter(c -> c.getAlunos() >= 100)
			 	.collect(Collectors.toList());
		
		System.out.println(listCursos);
		
		cursos.parallelStream()
		 	.filter(c -> c.getAlunos() >= 100)
		 	.collect(Collectors.toMap(
		 				c -> c.getNome(), 
		 				c -> c.getAlunos()))
		 	.forEach((nome,alunos) -> System.out.println(nome+" tem "+alunos+" alunos"));				

	}

}
