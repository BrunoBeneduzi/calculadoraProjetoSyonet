package calculadora.operadores.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SomaService {
	private Scanner sc = new Scanner(System.in);
	private List<BigDecimal> listaDeNumeros = new ArrayList<>();
	private BigDecimal resultado = BigDecimal.ZERO;
	private Boolean somaFinalizada = false;

	
	protected void somar() {
		
		for(BigDecimal somaTodos: this.adicionaNumerosNaLista()) {
			this.resultado = this.resultado.add(somaTodos);
		}
		
		System.out.println("A soma de todos os numeros foi de -> "+ this.resultado);
		listaDeNumeros.clear();
		this.resultado = BigDecimal.ZERO;
	}
	
	private List<BigDecimal> adicionaNumerosNaLista() {
		BigDecimal numeroBigDecimal = BigDecimal.ZERO;
		System.out.println("Digite os numeros e aperte enter para fazer a soma, quando quiser parar de digitar e fazer a ssoma de todos os numeros, digite (P)");
		
		do{
			System.out.print("-> ");
			String numeroString = sc.nextLine();
			
			if(numeroString.equalsIgnoreCase("p")) {
				somaFinalizada = false;
			}else {
				somaFinalizada = true;
				
				numeroBigDecimal = new BigDecimal(numeroString.replace(",", "."));//caso o usuario digite uma virgula, ela vai ser substituida por um PONTO, para não lançar uma exceção
				
				listaDeNumeros.add(numeroBigDecimal);
			}
			
		}while(somaFinalizada);
		
		
			
			return listaDeNumeros;
	}
	
}