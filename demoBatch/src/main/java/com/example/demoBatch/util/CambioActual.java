package com.example.demoBatch.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;

import org.json.JSONException;
import org.json.JSONObject;

public class CambioActual {

	String tipoCambio = "";

	public CambioActual() {
	}

	public CambioActual(String tipoCambio) {
		this.tipoCambio = tipoCambio;
	}

	public String getTipoCambio() {
		return tipoCambio;
	}

	public void setTipoCambio(String tipoCambio) {
		this.tipoCambio = tipoCambio;
	}

	private static String readAll(Reader rd) throws IOException {
		StringBuilder sb = new StringBuilder();
		int cp;
		while ((cp = rd.read()) != -1) {
			sb.append((char) cp);
		}
		return sb.toString();
	}

	public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
		InputStream is = new URL(url).openStream();
		try {
			BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
			String jsonText = readAll(rd);
			JSONObject json = new JSONObject(jsonText);
			return json;
		} finally {
			is.close();
		}
	}

	public String obtenerJSON() throws JSONException, IOException {
		JSONObject json = readJsonFromUrl("http://free.currencyconverterapi.com/api/v5/convert?q=USD_PEN&compact=y");
//		System.out.println(json.toString());
//		System.out.println(json.get("USD_PEN"));
		JSONObject json1 = (JSONObject) json.get("USD_PEN");
		String tipoCambio = "" + (json1.get("val"));
		return tipoCambio;
	}

	public String valor() {
		try {
			tipoCambio = obtenerJSON();
		} catch (JSONException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return tipoCambio;
	}

	// public static void main(String[] args) throws IOException, JSONException {
	// // System.out.println(dolarEnSoles());
	// }

}
