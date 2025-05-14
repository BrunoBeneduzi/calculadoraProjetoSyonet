package calculadora.operadores.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DivisaoService {
	private Scanner sc = new Scanner(System.in);
	private List<BigDecimal> listaDeNumeros = new ArrayList<>();
		
	protected void divide() {
		BigDecimal resultado = BigDecimal.ZERO;
		Boolean permitido = true;
		this.adicionaNumerosNaLista();
		
		BigDecimal recebePrimeiroNumero = listaDeNumeros.get(0);//faz a entrega do primeiro numero, para assim a multiplicação não ser 0
		
		resultado = recebePrimeiroNumero;
		
		this.listaDeNumeros.remove(0);
		
		for(BigDecimal divideTodos: listaDeNumeros) {
			try {
				resultado = resultado.divide(divideTodos,2, RoundingMode.HALF_UP);//permite 10 casas decimais e o half_up arredonda a numeração
			}catch(ArithmeticException e) {
				permitido = false;
			}
			
		}
		if(permitido) {
			System.out.println("A divisão de todos os numeros foi de -> "+ resultado);
		}else {
			System.out.println("Não é possivel fazer a divisão por ZERO");
		}
		listaDeNumeros.clear();
		resultado = BigDecimal.ZERO;
	}
	
	private List<BigDecimal> adicionaNumerosNaLista() {
		Boolean divisaoFinalizada = true;
		BigDecimal numeroBigDecimal = BigDecimal.ZERO;
		System.out.println("Digite os numeros e aperte enter para fazer a divisão, quando quiser parar de digitar e fazer a divisão de todos os numeros, digite (P)");
		
		do{
			System.out.print("-> ");
			String numeroString = sc.nextLine();
			
			if(numeroString.equalsIgnoreCase("p")) {
				divisaoFinalizada = false;
			}else {
				try {
					numeroBigDecimal = new BigDecimal(numeroString.replace(",", "."));//caso o usuario digite uma virgula, ela vai ser substituida por um PONTO, para não lançar uma exceção
					listaDeNumeros.add(numeroBigDecimal);
					divisaoFinalizada = true;
				}catch(NumberFormatException e) {
					System.out.println("Digite um numero valido");
				}
				
			}
			
		}while(divisaoFinalizada);
		
			return listaDeNumeros;
	}
}