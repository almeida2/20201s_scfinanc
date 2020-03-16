package com.esai.financ.model;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
/**
 * Objetivo - abrir a planilha ler uma celula e escrever em uma celula
 * As celulas no arquivo excel devem estar no formato String
 * @author Hp
 *
 */
public class ObtemDados {

	private static HSSFSheet ExcelWSheet;
	private static HSSFWorkbook ExcelWBook;
	private static XSSFCell Cell;
	private static XSSFRow Row;
	
	
	/**
	 * este metodo configura o caminho para abrir o arquivo Excel 
	 * @param Path
	 * @param SheetName - nome da pasta
	 * @throws Exception
	 */
	public static void identificaArquivoExcel(String Path, String SheetName) {
		try {
			// Abre o arquivo Excel
			System.out.println("Path = " + Path + " Sheet= " + SheetName);
			FileInputStream ExcelFile = new FileInputStream(Path);

			// Acessa a planilha de dados
			ExcelWBook = new HSSFWorkbook(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet(SheetName);

		} catch (Exception e) {
			System.out.println("erro no metodo setExcelFile = " + e.getMessage());
			throw new RuntimeException (e.getMessage());
		}
	}
}
