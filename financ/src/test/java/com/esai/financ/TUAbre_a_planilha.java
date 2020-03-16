package com.esai.financ;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.esai.financ.model.ObtemDados;

class TUAbre_a_planilha {

	@Test
	void ct01_abre_planilha_com_sucesso() {
		
		ObtemDados od = new ObtemDados();
		String path = "D:\\20201s_temp\\20201s_scfinanc\\planilhaExtrato.xls";
		String sheet = "plan1";
		od.identificaArquivoExcel(path,sheet);
	
		
	}

}
