package calculadora.menu;


import java.util.Scanner;

import calculadora.operadores.service.OperacoesService;


public class CalculadoraMenu {
	private Scanner sc = new Scanner(System.in);
	private OperacoesService operacao = new OperacoesService();
	
	public void menu() {
		int escolha = 0;
		do {
			System.out.print("Digite qual operação deseja fazer"+"\n1 - Soma"+"\n2 - Subtração"+"\n3 - Divisão"+"\n4 - Multiplicação"+"\n5 - Finalizar programa"+ "\n-> ");
			
			escolha = sc.nextInt();
			System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------");
			switch(escolha) {
				case 1:
					operacao.soma();
					break;
				case 2:
					operacao.subtrair();
					break;
				case 3:
					operacao.dividir();
					break;
				case 4:
					operacao.multiplicacao();
					break;
				case 5:
					break;
				default:
					System.out.println("Numero invalido");
			}
			
			System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------");
		}while(escolha != 5);
		System.out.println("Programa finalizado");
	}
}