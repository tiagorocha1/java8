package java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

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
		

		Optional<Curso> optionalCurso = cursos.stream()
			.filter(c -> c.getAlunos() >= 100)
			.findAny();
		
		cursos.stream()
				.filter(c -> c.getAlunos() >= 100)
				.findAny()
				.ifPresent(c -> System.out.println(c.getNome()));
			
			

	}

}
