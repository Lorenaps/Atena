package br.com.tebd.atena.persistence.mysql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.tebd.atena.entity.AreaConhecimento;
import br.com.tebd.atena.entity.instituicao;
import br.com.tebd.atena.entity.Instituicao;
import br.com.tebd.atena.persistence.IInstituicaoDAO;

public class InstituicaoDAO implements IInstituicaoDAO{
	
	@Override
	public ArrayList<Instituicao> listarTodas() {
		String sql = "select * from atena.instituicao";
        ArrayList<Instituicao> instituicoes = new ArrayList<>();
        Instituicao instituicao = new Instituicao();
	    Conexao c = new Conexao();
	    c.conectar(); 
	        try{
	            ResultSet result = c.processaConsulta(sql);
	            while (result.next()){
	                instituicao = new Instituicao();
	                instituicao.setId(result.getInt("ID_instituicao"));
	                instituicao.setNome(result.getString("NOME_instituicao"));
	                instituicao.setDataInicio(result.getDate("DATA_INI_instituicao"));
	                instituicao.setDataFinal(result.getDate("DATA_FIN_instituicao"));
	                instituicao.setDataInicioSubmissaoArtigos(result.getDate("DATA_INI_SUBMISSAO_ARTIGOS"));
	                instituicao.setDataFinalSubmissaoArtigos(result.getDate("DATA_FIN_SUBMISSAO_ARTIGOS"));
	                instituicoes.add(instituicao);

	            }
	            result.close();
	            return instituicoes;
	        }catch (SQLException e){
	
	        }        
	    return null;
	}

}
