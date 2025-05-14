package calculadora.operadores.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MultiplicacaoService {
	private Scanner sc = new Scanner(System.in);
	private List<BigDecimal> listaDeNumeros = new ArrayList<>();
	private BigDecimal resultado = BigDecimal.ZERO;
	private Boolean multiplicacaoFinalizada = true;
	
	protected void multiplica() {
		this.adicionaNumerosNaLista();
		
		BigDecimal recebePrimeiroNumero = listaDeNumeros.get(0);//faz a entrega do primeiro numero, para assim a multiplicação não ser 0
		
		resultado = recebePrimeiroNumero;
		
		this.listaDeNumeros.remove(0);
		
		for(BigDecimal multiplicaTodos: listaDeNumeros) {
			this.resultado = this.resultado.multiply(multiplicaTodos);
		}
		
		System.out.println("A multiplicação foi de -> "+ this.resultado);
		listaDeNumeros.clear();
		this.resultado = BigDecimal.ZERO;
	}
	
	private List<BigDecimal> adicionaNumerosNaLista() {
		BigDecimal numeroBigDecimal = BigDecimal.ZERO;
		System.out.println("Digite os numeros e aperte enter para fazer a multiplicação, quando quiser parar de digitar e fazer a multiplicação de todos os numeros, digite (P)");
		
		do{
			System.out.print("-> ");
			String numeroString = sc.nextLine();
			
			if(numeroString.equalsIgnoreCase("p")) {
				multiplicacaoFinalizada = false;
			}else {
				try {
					numeroBigDecimal = new BigDecimal(numeroString.replace(",", "."));//caso o usuario digite uma virgula, ela vai ser substituida por um PONTO, para não lançar uma exceção
					listaDeNumeros.add(numeroBigDecimal);
				}catch(NumberFormatException e) {
					System.out.println("Digite um numero valido");
				}	
			}
			
		}while(multiplicacaoFinalizada);
			return listaDeNumeros;
	}
}