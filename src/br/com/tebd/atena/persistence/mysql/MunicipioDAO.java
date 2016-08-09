package br.com.tebd.atena.persistence.mysql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.tebd.atena.entity.Estado;
import br.com.tebd.atena.entity.Municipio;
import br.com.tebd.atena.persistence.IMunicipioDAO;

public class MunicipioDAO implements IMunicipioDAO{
	
	@Override
	public ArrayList<Municipio> listarMunicipiosPorEstado(Estado estado) {
		String sql = "select * from atena.municipio where ESTADO_ID_FK =" + 
						estado.getId() +";";
		ArrayList<Municipio> municipios = new ArrayList<>();
        Municipio municipio;
        Conexao c = new Conexao();
        c.conectar(); 
	        try{
	            ResultSet result = c.processaConsulta(sql);
	            while (result.next()){
	            	municipio = new Municipio();
	                municipio.setId(result.getInt("ID_MUNICIPIO"));
	                municipio.setUf(result.getString("UF_ESTADO"));
	                municipio.setNome(result.getString("NOME_MUNICIPIO"));
	                municipio.setEstado(estado);
	                municipios.add(municipio);
	            }
	            result.close();
	            return municipios;
	        }catch (SQLException e){
	
	        }        
        return null;
	}
	@Override
	public ArrayList<Municipio> listarTodos() {
		String sql = "select * from atena.municipio;";
        ArrayList<Municipio> municipios = new ArrayList<>();
        Municipio municipio;
        Conexao c = new Conexao();
        c.conectar(); 
	        try{
	            ResultSet result = c.processaConsulta(sql);
	            while (result.next()){
	                municipio = new Municipio();
	                municipio.setId(result.getInt("ID_MUNICIPIO"));
	                municipio.setUf(result.getString("UF_ESTADO"));
	                municipio.setNome(result.getString("NOME_MUNICIPIO"));
	                municipios.add(municipio);
	            }
	            result.close();
	            return municipios;
	        }catch (SQLException e){
	
	        }        
        return null;
	}
	@Override
	public Municipio listarPorId(Municipio munic) {
		String sql = "select * from atena.municipio where ID_MUNICIPIO = "
				+ munic.getId() + ";";
		//System.out.println("teste: "+ munic.getId());
        Municipio municipio = new Municipio();
        Conexao c = new Conexao();
        c.conectar(); 
	        try{
	            ResultSet result = c.processaConsulta(sql);
	            while (result.next()){
	                municipio.setId(result.getInt("ID_MUNICIPIO"));

	        		Estado estado = new Estado();
	        		int idEstado = result.getInt("ESTADO_ID_FK");
		            estado.setId(idEstado);
		            EstadoDAO eDAO = new EstadoDAO();

		            municipio.setEstado(eDAO.listarPorId(estado));

	                municipio.setUf(result.getString("UF_ESTADO"));
	                municipio.setNome(result.getString("NOME_MUNICIPIO"));
	        		System.out.println("teste:" + municipio.getNome());
	            }
	            result.close();
	            return municipio;
	        }catch (SQLException e){
	
	        }        
        return null;
	}

}
