package com.esai.financ.model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * Objetivo - abrir a planilha ler uma celula e escrever em uma celula As
 * celulas no arquivo excel devem estar no formato String
 * 
 * @author Hp
 *
 */
public class ObtemDados {

	private static HSSFSheet ExcelWSheet;
	private static HSSFWorkbook ExcelWBook;
	private static HSSFCell Cell;
	private static HSSFRow Row;

	/**
	 * este metodo configura o caminho para abrir o arquivo Excel
	 * 
	 * @param Path
	 * @param SheetName - nome da pasta
	 * @throws Exception
	 */
	public static void identificaArquivoExcel(String Path, String SheetName) {
		try {
			// Abre o arquivo Excel
			//System.out.println("Path = " + Path + " Sheet= " + SheetName);
			FileInputStream ExcelFile = new FileInputStream(Path);

			// Acessa a planilha de dados
			ExcelWBook = new HSSFWorkbook(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet(SheetName);

		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	/**
	 * Este metodo le os dados de teste de uma celula do Excel passando como
	 * parametro linha x coluna, retorna o conteudo da celula como um String
	 * 
	 * @param RowNum - linha
	 * @param ColNum - coluna
	 * @return - conteudo da celula
	 * @throws Exception
	 */

	public static String getCellData(int RowNum, int ColNum) {

		try {
			Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
			String CellData = String.valueOf(Cell.getStringCellValue());
			return CellData;
		} catch (Exception e) {
			return "";
		}
	}
	
	public static ArrayList<TransacaoFinanceira> carregaDados() {
		ArrayList<TransacaoFinanceira> extrato = new ArrayList<TransacaoFinanceira>();
		TransacaoFinanceira tf;
		int linha = 7;
		while(getCellData(linha, 0) != "") {
			String data = getCellData(linha, 0);// linha, coluna
			String desc = getCellData(linha, 1);// linha, coluna
			String docto = getCellData(linha, 2);// linha, coluna
			String situa = getCellData(linha, 3);// linha, coluna
			BigDecimal cred = new BigDecimal(0);
			BigDecimal deb = new BigDecimal(0);
			BigDecimal sal = new BigDecimal(0);
			if ((getCellData(linha, 4) != "")) {
				cred = recuperaString(getCellData(linha, 4));
			}
			
			if (getCellData(linha, 5) != "") {
				deb = recuperaString(getCellData(linha, 5));
			}
			if (getCellData(linha, 6) != "") {
				sal = recuperaString(getCellData(linha, 6));
			}

			tf = new TransacaoFinanceira(data, desc, docto, situa, cred, deb, sal);
			extrato.add(tf);
			linha = linha +1;
		}
		return extrato;

	}
    public void mostra(ArrayList<TransacaoFinanceira> extrato) {
    	
    	for (TransacaoFinanceira tf : extrato) {
    		System.out.println(tf);
    	}
    }
	/**
	 * transforma valor monetario string para bigdecimal
	 * 
	 * @param str
	 * @return
	 */
	public static BigDecimal recuperaString(String str) {
		str = str.replace(".", "");
		str = str.replace(",", ".");
		str = str.trim();

		return new BigDecimal(str);
	}

	/**
	 * transforma valor monetario string para decimal
	 */
	public void converte() {
		Locale Local = new Locale("pt", "BR");

		// Number pra string
		double value = 2637.64;
		DecimalFormat df = new DecimalFormat("#,##0.00", new DecimalFormatSymbols(Local));
		String s = df.format(value);
		System.out.println(s);// imprime 2.637,64

		// Contrário
		String number = "2.637,64";
		try {
			System.out.println(df.parseObject(number)); // vai retornar um double, 2637.64
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

}
