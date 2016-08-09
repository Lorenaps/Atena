package br.com.tebd.atena.persistence.mysql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import br.com.tebd.atena.entity.Estado;
import br.com.tebd.atena.persistence.IEstadoDAO;

public class EstadoDAO implements IEstadoDAO{
	
	@Override
	public ArrayList<Estado> listarTodos() {
		String sql = "select * from atena.estado;";
        ArrayList<Estado> estados = new ArrayList<>();
        Estado estado;
        
        Conexao c = new Conexao();
        c.conectar(); 
	        try{
	            ResultSet result = c.processaConsulta(sql);
	            while (result.next()){
	                estado = new Estado();
	                estado.setId(result.getInt("ID_ESTADO"));
	                estado.setUf(result.getString("UF_ESTADO"));
	                estado.setNome(result.getString("NOME_ESTADO"));
	                estados.add(estado);
	            }
	            result.close();
	            return estados;
	        }catch (SQLException e){
	
	        }        
        return null;
	}
	
	@Override
	public Estado listarPorId(Estado estd) {
		String sql = "select * from atena.estado where ID_ESTADO = "
				+ estd.getId() + ";";
        Estado estado = new Estado();
        Conexao c = new Conexao();
        c.conectar(); 
	        try{
	            ResultSet result = c.processaConsulta(sql);
	            while (result.next()){
	                estado.setId(result.getInt("ID_ESTADO"));
	                estado.setUf(result.getString("UF_ESTADO"));
	                estado.setNome(result.getString("NOME_ESTADO"));
	            }
	            result.close();
	            return estado;
	        }catch (SQLException e){
	
	        }        
        return null;
	}

}
