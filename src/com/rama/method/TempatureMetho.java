package com.rama.method;

public class TempatureMetho {
	public static String FarToCel(double F) {
		double C = (F - 32) * (5 / 9);
		String Cel = String.valueOf(C);
		return Cel;
	}

	public static String FarToKal(double F) {
		double C = (F - 32) * (5 / 9) + 273.15;
		String Cel = String.valueOf(C);
		return Cel;
	}

	public static String FaToFa(double F) {
		String Cel = String.valueOf(F);
		return Cel;
	}

	public static String CelToFar(double C) {
		double F = (1.8 * C) + 32;
		String Far = String.valueOf(F);
		return Far;
	}

	public static String CelToKal(double C) {
		double K = C + 273.15;
		String kal = String.valueOf(K);
		return kal;
	}

	public static String CelToCel(double C) {
		String kal = String.valueOf(C);
		return kal;
	}

	public static String KalToFar(double K) {
		double F = (K - 273.15) * (9 / 5) + 32;
		String Far = String.valueOf(F);
		return Far;
	}

	public static String KalToCel(double K) {
		double F = K - 273.15;
		String Far = String.valueOf(F);
		return Far;
	}

	public static String KalToKal(double K) {
		String Far = String.valueOf(K);
		return Far;
	}

}
