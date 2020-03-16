package com.esai.financ.model;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AnaliseDosDados {
	
	public ArrayList carregaDados() {
		
		
		
		return null;
		
	}
	
	
	
	/*
     * Procurar e Retornar e-mails que estão localizados em uma String.
     *
     *   regex - Qual o pattern do que deseja procurar, no exemplo é um e-mail.
     *   text - Texto que contém os valores a serem localizados.
     *   return Uma String com os e-mails.
     */
    public static String getEmailInText(String regex, String text) {      
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
