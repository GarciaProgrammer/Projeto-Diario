package br.com.projetodiario.model;

import java.io.Serializable;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import br.com.projetodiario.bean.Nota;
import br.com.projetodiario.dao.NotasDAO;

public class NotasModel implements Serializable {
	public static final long SerialVersionUID = 1l;

	public static List<Nota> getListaNotas() {
		return NotasDAO.listaNotas();
	}

	public static int cadNota(String assunto, String dtNota, String texto) throws ParseException {
		Nota nt = new Nota();
		nt.setAssunto(assunto);
		nt.setTexto(texto);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date data = format.parse(dtNota);
		String dtFormatada = format.format(data);
		
		
		return 0;
	}
	
	

}
