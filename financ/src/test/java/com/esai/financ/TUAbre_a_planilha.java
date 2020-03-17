package com.esai.financ;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.esai.financ.model.AnaliseDosDados;
import com.esai.financ.model.ObtemDados;

class TUAbre_a_planilha {

	@Test
	void ct01_abre_planilha_com_sucesso() {
		
		ObtemDados od = new ObtemDados();
		String path = "E:\\20201s_temp\\20201s_scfinanc\\planilhaExtrato.xls";
		String sheet = "plan1";
		od.identificaArquivoExcel(path,sheet);
	
		
	}
	@Test
	void ct02_abre_planilha_com_endereco_invalido() {
		try {
		ObtemDados od = new ObtemDados();
		String path = "D:\\20201s_temp\\20201s_scfinanc\\planilhaExtrato1.xls";
		String sheet = "plan1";
		od.identificaArquivoExcel(path,sheet);
		}catch(Exception e) {
			assertEquals ("O sistema não pode encontrar o caminho especificado",e.getMessage().substring(53, 104));
			
		}
	
		
	}
	@Test
	public void ct03_contaQuantidadeDeLinhas() {
		ObtemDados od = new ObtemDados();
		//linha - coluna 0 data, descricao, docto, situacao, credito, debito, saldo
		String data = od.getCellData(7,0);//linha, coluna
		String descricao = od.getCellData(7,0);//linha, coluna
		assertTrue (data.toString().trim().equals("02/03/2020"));
	}
	
	@Test
	public void ct05_obtemLinha() {
		ObtemDados od = new ObtemDados();
		AnaliseDosDados ad = new AnaliseDosDados();
		ad.agrupaPorCategoria(od.carregaDados());
		
	}
}
