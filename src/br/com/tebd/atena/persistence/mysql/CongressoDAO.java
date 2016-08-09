package br.com.tebd.atena.persistence.mysql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.tebd.atena.entity.AreaConhecimento;
import br.com.tebd.atena.entity.Congresso;
import br.com.tebd.atena.persistence.ICongressoDAO;

public class CongressoDAO implements ICongressoDAO{
	
	@Override
	public Congresso listarTodos() {
		String sql = "select * from atena.congresso;";
		AreaConhecimentoDAO acDAO = new AreaConhecimentoDAO();
		AreaConhecimento ac = new AreaConhecimento();
	    Congresso congresso = new Congresso();
	    Conexao c = new Conexao();
	    c.conectar(); 
	        try{
	            ResultSet result = c.processaConsulta(sql);
	            while (result.next()){
	                congresso.setId(result.getInt("ID_CONGRESSO"));
	                congresso.setNome(result.getString("NOME_CONGRESSO"));
	                congresso.setDataInicio(result.getDate("DATA_INI_CONGRESSO"));
	                congresso.setDataFinal(result.getDate("DATA_FIN_CONGRESSO"));
	                congresso.setDataInicioSubmissaoArtigos(result.getDate("DATA_INI_SUBMISSAO_ARTIGOS"));
	                congresso.setDataFinalSubmissaoArtigos(result.getDate("DATA_FIN_SUBMISSAO_ARTIGOS"));
	        		int id = result.getInt("AREA_CONHECIMENTO_ID_FK");
	                ac = acDAO.listarPorId(id);
	                congresso.setAreaConhecimento(ac);
	            }
	            result.close();
	            return congresso;
	        }catch (SQLException e){
	
	        }        
	    return null;
	}

}
