package com.marceltessarini.lojavirtual.rs.utils;

import org.apache.commons.lang3.StringUtils;

/**
 * Utilitários para converter String em números.
 * 
 * @author <a href="mailto:marceltessarini@gmail.com">Marcel Tessarini</a>
 *
 */
public final class ConverterNumberUtils {

	private ConverterNumberUtils() {
		
	}
	
	/**
	 * Converte a string em long.
	 * 
	 * @param str string para ser convertida.
	 * @return long se a string representa um long ou null se a conversão falhar.
	 */
	public static Long toLongOrNull(String str) {
		if (StringUtils.isNotBlank(str)) {
			try {
				return Long.valueOf(str);
			} catch (Exception e) {
				// faz nada!
			}
		}
		return null;
	}
	
}
