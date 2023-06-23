package br.edu.utfpr.td.tsi.consumer;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Transacao {

	private String codigo;
	private String cedente;
	private String pagador;
	private Double valor;
	private String vencimento;

}
