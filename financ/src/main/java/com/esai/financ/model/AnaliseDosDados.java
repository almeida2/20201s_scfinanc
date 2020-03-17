package com.esai.financ.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AnaliseDosDados {
	/**
	 * Analise dos gastos
	 * @param extrato
	 */
	public void agrupaPorCategoria(ArrayList<TransacaoFinanceira> extrato) {
		BigDecimal lanche = new BigDecimal(0);
		BigDecimal faxina = new BigDecimal(0);
		BigDecimal cc = new BigDecimal(0);
		BigDecimal iof = new BigDecimal(0);
		BigDecimal gas = new BigDecimal(0);
		BigDecimal ted = new BigDecimal(0);
		for (TransacaoFinanceira tf : extrato) {
			
			if(obtemCategoriaNoTexto("PADRELA",tf.descricao))
				lanche = tf.getDebito().add(lanche);
			if(obtemCategoriaNoTexto("PAO DE ACUCAR",tf.descricao))
				lanche = tf.getDebito().add(lanche);
			if(obtemCategoriaNoTexto("MC DONALDS",tf.descricao))
				lanche = tf.getDebito().add(lanche);
			if(obtemCategoriaNoTexto("LUCIANE APARECIDA PEREIRA",tf.descricao))
				faxina = tf.getDebito().add(faxina);
			//cartao de credito
			if(obtemCategoriaNoTexto("CARTAO CREDITO",tf.descricao))
				cc = tf.getDebito().add(cc);
			if(obtemCategoriaNoTexto("PORTO SEGURO CARTOES",tf.descricao))
				cc = tf.getDebito().add(cc);
			if(obtemCategoriaNoTexto("BANCO ITAUCARD",tf.descricao))
				cc = tf.getDebito().add(cc);
			
			if(obtemCategoriaNoTexto("IOF",tf.descricao))
				iof = tf.getDebito().add(iof);
			if(obtemCategoriaNoTexto("PAG.CentroAutom",tf.descricao))
				gas = tf.getDebito().add(gas);
			if(obtemCategoriaNoTexto("AUTO POSTO RAMA",tf.descricao))
				gas = tf.getDebito().add(gas);
			
			if(obtemCategoriaNoTexto("TED",tf.descricao))
				ted = tf.getDebito().add(ted);
    	}
		System.out.println("Despesa periodo =>"  + extrato.get(0).getData() + " a " + extrato.get(extrato.size()-2).getData() );
		
		System.out.println("Lanche => " + lanche.toString());
		System.out.println("Faxina => " + faxina.toString());
		System.out.println("Cart Credito => " + cc.toString());
		System.out.println("Gasolina => " + gas.toString());
		System.out.println("TED => " + ted.toString());
		System.out.println("IOF => " + iof.toString());
		
		
	}
	
	
	
	/*
     * Procurar e Retornar e-mails que estão localizados em uma String.
     *
     *   regex - Qual o pattern do que deseja procurar, no exemplo é um e-mail.
     *   text - Texto que contém os valores a serem localizados.
     *   return Uma String com os e-mails.
     */
    public static boolean obtemCategoriaNoTexto(String regex, String text) {      
              Pattern pattern = Pattern.compile(regex);
              Matcher matcher = pattern.matcher(text);
           
              return matcher.find();
            
    }
    /*
     * Procurar e Retornar e-mails que estão localizados em uma String.
     *
     *   regex - Qual o pattern do que deseja procurar, no exemplo é um e-mail.
     *   text - Texto que contém os valores a serem localizados.
     *   return Uma String com os e-mails.
     */
    public static String obtemCategoriaNoTexto2(String regex, String text) {      
              if (text==null || regex==null || regex.isEmpty() || text.isEmpty()) {
                        return "";
              }
              Pattern pattern = Pattern.compile(regex);
              Matcher matcher = pattern.matcher(text);
              String listaEmail = "";
              while (matcher.find()) {
                        listaEmail += matcher.group() + " ";
              }
              // Removendo o último espaço
              return listaEmail.trim();
    }
}
