package br.blog.tiagorocha;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

public class ApiDeDatas {
	
public static void main(String[] args) {		
		
		System.out.println("Data atual: ");
		LocalDate hoje = LocalDate.now();		
		System.out.println(hoje);
		
		System.out.println("Data do meu nascimento:");
		LocalDate dataNascimento = LocalDate.of(1987,Month.SEPTEMBER,19);
		System.out.println(dataNascimento);
		
		System.out.println("Minha idade: ");
		int idade = hoje.getYear() - dataNascimento.getYear();
		System.out.println(idade);
		
		
		/*Periodos*/
		System.out.println("==============================");
		Period periodo = Period.between(hoje, dataNascimento);
		System.out.println(periodo);
		System.out.println(periodo.getYears());
		System.out.println(periodo.getMonths());
		System.out.println(periodo.getDays());
		
		/*Incrementando e decrementando suas datas*/
		System.out.println("==============================");
		System.out.println(hoje.minusYears(1));
		System.out.println(hoje.minusMonths(4));
		System.out.println(hoje.minusDays(2));

		System.out.println(hoje.plusYears(1));
		System.out.println(hoje.plusMonths(4));
		System.out.println(hoje.plusDays(2));
		
		//toda a API de datas é imutável. Ela nunca vai alterar a data original.
		System.out.println("==============================");
		System.out.println(dataNascimento);
		System.out.println(dataNascimento.plusYears(1));
		System.out.println(dataNascimento);
		
		System.out.println("Agora da certo :) ");
		LocalDate dataNascimentoMaisUmAno = dataNascimento.plusYears(1);
		System.out.println(dataNascimentoMaisUmAno);
		
		/*Formatando datas*/
		System.out.println("==============================");
		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String valorFormatado = hoje.format(formatador);
		System.out.println(valorFormatado);
		
		/*Trabalhando com medidas de tempo*/
		System.out.println("==============================");
		DateTimeFormatter formatadorComHoras = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss");
		LocalDateTime agora = LocalDateTime.now();
		System.out.println(agora.format(formatadorComHoras));
		
		/*Lidando com modelos mais específicos*/
		System.out.println("==============================");
		YearMonth anoEMes = YearMonth.of(2015, Month.JANUARY);
		System.out.println(anoEMes);
		LocalTime intervalo = LocalTime.of(12, 30);
		System.out.println(intervalo);

	}

}
