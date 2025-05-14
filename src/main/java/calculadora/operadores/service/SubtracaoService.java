package calculadora.operadores.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SubtracaoService {
	private Scanner sc = new Scanner(System.in);
	private List<BigDecimal> listaDeNumeros = new ArrayList<>();
	

	
	protected void subtrair() {
		BigDecimal resultado = BigDecimal.ZERO;
		BigDecimal recebePrimeiroNumero=  this.adicionaNumerosNaLista().get(0);//faz a entrega do primeiro numero, para assim a soma ser positiva
		
		resultado = recebePrimeiroNumero;
		
		this.listaDeNumeros.remove(0);
		
		for(BigDecimal subtraiTodos: listaDeNumeros) {
			
			resultado = resultado.subtract(subtraiTodos);
		}
		
		System.out.println("A subtração de todos os numeros foi de -> "+resultado);
		listaDeNumeros.clear();
		
	}
	
	private List<BigDecimal> adicionaNumerosNaLista() {
		Boolean subtracaoFinalizada = true;
		BigDecimal numeroBigDecimal = BigDecimal.ZERO;
		System.out.println("Digite os numeros e aperte enter para fazer a subtração, quando quiser parar de digitar e fazer a subtração de todos os numeros, digite (P)");
		
		do{
			System.out.print("-> ");
			String numeroString = sc.nextLine();
			
			if(numeroString.equalsIgnoreCase("p")) {
				subtracaoFinalizada = false;
			}else {
				
				try {
					numeroBigDecimal = new BigDecimal(numeroString.replace(",", "."));//caso o usuario digite uma virgula, ela vai ser substituida por um PONTO, para não lançar uma exceção
					listaDeNumeros.add(numeroBigDecimal);
				}catch(NumberFormatException e) {
					System.out.println("Digite um numero valido");
				}
				
			}
			
		}while(subtracaoFinalizada);
		
		
			
			return listaDeNumeros;
	}
	
}