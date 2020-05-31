package br.com.caelum.correios.soap;

import java.math.BigDecimal;
import java.util.List;

public class TesteClienteCorreios {

	public static void main(String[] args) {
		CalcPrecoPrazoWSSoap cliente = new CalcPrecoPrazoWS().getCalcPrecoPrazoWSSoap();
		
		String nCdEmpresa = "";
		String sDsSenha = "";
		String nCdServico = "40010"; // sedex
		String sCepOrigem = "04101300"; //Caelum SP
		String sCepDestino = "20040030"; // Caelum RJ
		String nVlPeso = "3";
		int nCdFormato = 1; // 1 é caixa ou pacote
		BigDecimal nVlComprimento = new BigDecimal(20);
		BigDecimal nVlAltura = new BigDecimal(10);
		BigDecimal nVlLargura = new BigDecimal(15);
		BigDecimal nVlDiametro = new BigDecimal(10);
		String sCdMaoPropria = "N";
		BigDecimal nVlValorDeclarado = BigDecimal.ZERO;
		String sCdAvisoRecebimento = "N";
		
		CResultado resultado = cliente.calcPrecoPrazo(nCdEmpresa, sDsSenha, nCdServico, sCepOrigem, sCepDestino, nVlPeso
				, nCdFormato, nVlComprimento, nVlAltura, nVlLargura, nVlDiametro, sCdMaoPropria
				, nVlValorDeclarado, sCdAvisoRecebimento);
		
		ArrayOfCServico servicos = resultado.getServicos();
		List<CServico> cServico = servicos.getCServico();
		for (CServico cServico2 : cServico) {
			System.out.println("Frete para "+sCepDestino+" é de "+cServico2.getValor());
		}
	}

}
