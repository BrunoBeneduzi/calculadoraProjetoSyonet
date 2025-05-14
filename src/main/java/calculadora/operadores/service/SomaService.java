package calculadora.operadores.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SomaService {
	private Scanner sc = new Scanner(System.in);
	private List<BigDecimal> listaDeNumeros = new ArrayList<>();
	private BigDecimal resultado = BigDecimal.ZERO;
	private Boolean somaFinalizada = true;

	
	protected void somar() {
		
		for(BigDecimal somaTodos: this.adicionaNumerosNaLista()) {
			this.resultado = this.resultado.add(somaTodos);
		}
		
		System.out.println("A soma foi de -> "+ this.resultado);
		listaDeNumeros.clear();//caso o usuario não encerre o programa, a variavel ficaria com os numeros salvos, então aqui ele limpa para garantir que os numeros não sejam usados novamente
		this.resultado = BigDecimal.ZERO;
	}
	
	private List<BigDecimal> adicionaNumerosNaLista() {
		BigDecimal numeroBigDecimal = BigDecimal.ZERO;
		System.out.println("Digite os numeros e aperte enter para fazer a soma, quando quiser parar de digitar e fazer a soma de todos os numeros, digite (P)");
		
		do{
			
			System.out.print("-> ");
			String numeroString = sc.nextLine();
			
			if(numeroString.equalsIgnoreCase("p")) {
				somaFinalizada = false;
			}else {
				
				try {
					numeroBigDecimal = new BigDecimal(numeroString.replace(",", "."));//caso o usuario digite uma virgula, ela vai ser substituida por um PONTO, para não lançar uma exceção
					listaDeNumeros.add(numeroBigDecimal);
				}catch(NumberFormatException e) {
					System.out.println("Digite um numero valido");
				}
			}
			
		}while(somaFinalizada);
		
		
			
			return listaDeNumeros;
	}
	
}