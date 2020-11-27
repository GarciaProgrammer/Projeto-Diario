package br.com.projetodiario.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.projetodiario.bean.Nota;
import br.com.projetodiario.cnn.ConnectionFactory;

public class NotasDAO {



	public static List<Nota> listaNotas() {
		List<Nota> listaRetorno = new ArrayList<Nota>();
		
		Connection cnn = ConnectionFactory.GetConnection();
		
		String query = "SELECT * FROM notas";
		
		try {
			PreparedStatement pStmt = cnn.prepareStatement(query);
			ResultSet rsNotas = pStmt.executeQuery();
			
			while (rsNotas.next()) {
			Nota nt = new Nota(rsNotas.getInt("id"), rsNotas.getString("assunto"), rsNotas.getString("dt"), rsNotas.getString("texto"));
			
			listaRetorno.add(nt);
			}
		rsNotas.clearWarnings();
		cnn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaRetorno;
	}

	public static int cadNota(Nota nt) {
		// TODO Auto-generated method stub
		return 0;
	}

	
}
