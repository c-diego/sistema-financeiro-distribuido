package br.edu.utfpr.td.tsi.transaction;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class LeitorArquivo {

	public List<Transacao> lerArquivo() {
		List<Transacao> transacoes = new ArrayList<Transacao>();
		try {
			Reader leitorArquivo = new FileReader("transacoes.csv");
			CSVFormat configCSV = CSVFormat.Builder.create().setHeader("codigo", "cedente", "pagador", "valor", "vencimento").setSkipHeaderRecord(true).build();
			CSVParser interpretadorCSV = configCSV.parse(leitorArquivo);
			List<CSVRecord> records = interpretadorCSV.getRecords();
			
			for (CSVRecord record : records) {
			    String codigo = record.get("codigo");
			    String cedente = record.get("cedente");
			    String pagador = record.get("pagador");
			    Double valor = Double.valueOf(record.get("valor"));	
			    String vencimento = record.get("vencimento");
			    
			    Transacao t = new Transacao(codigo, cedente, pagador, valor, vencimento);
			    transacoes.add(t);
			       
			}	
		} catch (IOException e) {
			System.out.println("Erro ao abrir arquivo CSV");
		}
		return transacoes;
	}
}
