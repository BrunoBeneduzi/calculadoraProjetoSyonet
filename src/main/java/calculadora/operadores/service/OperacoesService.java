package calculadora.operadores.service;

public class OperacoesService {
	private SomaService soma = new SomaService();
	private SubtracaoService subtracao = new SubtracaoService();
	private MultiplicacaoService multiplicacao = new MultiplicacaoService();
	private DivisaoService divisao = new DivisaoService();
	
	public void soma() {
		soma.somar();
	}
	
	public void subtrair() {
		subtracao.subtrair();
	}
	
	public void multiplicacao() {
		multiplicacao.multiplica();
	}
	
	public void dividir() {
		divisao.divide();
	}
}