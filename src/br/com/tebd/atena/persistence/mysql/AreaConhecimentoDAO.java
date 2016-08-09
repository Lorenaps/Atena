package br.com.tebd.atena.persistence.mysql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.tebd.atena.entity.AreaConhecimento;
import br.com.tebd.atena.persistence.IAreaConhecimentoDAO;

public class AreaConhecimentoDAO implements IAreaConhecimentoDAO {

	@Override
	public ArrayList<AreaConhecimento> listarTodas() {
		String sql = "select * from atena.area_conhecimento;";
        ArrayList<AreaConhecimento> areas = new ArrayList<>();
        AreaConhecimento area = new AreaConhecimento();
        Conexao c = new Conexao();
        c.conectar(); 
	        try{
	            ResultSet result = c.processaConsulta(sql);
	            while (result.next()){
	                area = new AreaConhecimento();
	                area.setId(result.getInt("ID_AREA_CONHECIMENTO"));
	                area.setNome(result.getString("NOME_AREA_CONHECIMENTO"));
	                area.setCodigo(result.getString("COD_AREA_CONHECIMENTO"));
	                areas.add(area);
	            }
	            result.close();
	            return areas;
	        }catch (SQLException e){
	
	        }        
        return null;
	}
	
	public AreaConhecimento listarPorId(Integer id){
	String sql = "select * from atena.area_conhecimento where ID_AREA_CONHECIMENTO ="
			+ id +";";
    AreaConhecimento area = new AreaConhecimento();
    Conexao c = new Conexao();
    c.conectar(); 
        try{
            ResultSet result = c.processaConsulta(sql);
            while (result.next()){
                area = new AreaConhecimento();
                area.setId(result.getInt("ID_AREA_CONHECIMENTO"));
                area.setNome(result.getString("NOME_AREA_CONHECIMENTO"));
                area.setCodigo(result.getString("COD_AREA_CONHECIMENTO"));
            }
            result.close();
            return area;
        }catch (SQLException e){

        }        
    return null;
	}
	
}
