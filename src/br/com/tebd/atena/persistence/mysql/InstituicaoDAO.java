package br.com.tebd.atena.persistence.mysql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.tebd.atena.entity.AreaConhecimento;
import br.com.tebd.atena.entity.CategoriaAdmInstituicao;
import br.com.tebd.atena.entity.Instituicao;
import br.com.tebd.atena.entity.Municipio;
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
	                instituicao.setId(result.getInt("ID_INSTITUICAO"));
	                instituicao.setNome(result.getString("NOME_INSTITUICAO"));
	                instituicao.setEndereco(result.getString("ENDERECO_INSTITUICAO"));
	                instituicao.setCategoriaAdm(result.getInt("CATEGORIA_ADM_INSTITUICAO"));
	                instituicao.setSigla(result.getString("SIGLA_INSTITUICAO"));
	                
	                Municipio m = new Municipio();
	                m.setId(result.getInt("MUNICIPIO_ID_FK"));
	                //MunicipioDAO mDao = new MunicipioDAO(); erro
	                //instituicao.setMunicipio(mDao.listarPorId(m));
	                instituicoes.add(instituicao);
	            }
	            result.close();
	            return instituicoes;
	        }catch (SQLException e){
	
	        }        
	    return null;
	}

}
