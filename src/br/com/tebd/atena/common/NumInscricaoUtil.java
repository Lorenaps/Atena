package br.com.tebd.atena.common;

import java.util.Random;

public class NumInscricaoUtil {
	public static Integer gerarNumInscricao(){
		Random r = new Random();
		int Low = 90000;
		int High = 100000;
		int Result = r.nextInt(High-Low) + Low;
		return new Integer(Result);
	}
}
