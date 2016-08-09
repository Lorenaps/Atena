package br.com.tebd.atena.persistence.mysql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.tebd.atena.entity.AreaConhecimento;
import br.com.tebd.atena.entity.Congresso;
import br.com.tebd.atena.entity.Municipio;
import br.com.tebd.atena.entity.Participante;
import br.com.tebd.atena.persistence.IParticipanteDAO;

public class ParticipanteDAO implements IParticipanteDAO{
	
	@Override
	public boolean salvarParticipante(Participante p){
		String sql;
	       
        sql = "insert into atena.participante values("
		        + p.getId() + ","
		        + "'" + p.getNome() + "',"
		        + "'" + p.getTelefone() + "',"
		        + "'" + p.getEmail() + "',"
		        + "'" + p.getEndereco() + "',"
		        + "'" + p.getCpf() + "',"
		        + p.getNumInscricao() + ","
		        + p.isRevisor() + ","
		        + p.getMunicipio().getId()+ ","
		        + p.getCongresso().getId()+");";

        
        System.out.println(sql);
        Conexao c = new Conexao();
        c.conectar();
        int insert = c.processaInclusao(sql);
        if(insert > 0){
            return true;
        }
        return false;            
    }
    
	@Override
    public boolean alterarParticipante(Participante p){
        String sql;
       
        sql = "update atena.participante set "
		        + ", NOME_PARTICIPANTE='" + p.getNome() + "'"
		        + ", TEL_PARTICIPANTE='" + p.getTelefone() + "'"
		        + ", EMAIL_PARTICIPANTE='" + p.getEmail() + "'"
		        + ", ENDERECO_PARTICIPANTE='" + p.getEndereco() + "'"
		        + ", CPF_PARTICIPANTE='" + p.getCpf() + "'"
		        + ", REVISOR_PARTICIPANTE =" + p.isRevisor()  
		        + ", MUNICIPIO_ID_FK =" + p.getMunicipio().getId()          
		        + " where NUM_INSCRICAO_PARTICIPANTE =" + p.getNumInscricao() +";";
         
        Conexao c = new Conexao();
        c.conectar();
        int update = c.processaInclusao(sql);
        if(update > 0){
            return true;
        }
        return false;                
    }
    
    @Override
    public ArrayList<Participante> listarTodos() {
		String sql = "select * from atena.participante;";
        ArrayList<Participante> participantes = new ArrayList<>();
        Participante participante = new Participante();
        Conexao c = new Conexao();
        c.conectar(); 
	        try{
	            ResultSet result = c.processaConsulta(sql);
	            while (result.next()){
	            	participante.setId(result.getInt("ID_PARTICIPANTE_PK"));
					participante.setNome(result.getString("NOME_PARTICIPANTE"));
					participante.setTelefone(result.getString("TEL_PARTICIPANTE"));
					participante.setEmail(result.getString("TEL_PARTICIPANTE"));
					participante.setEndereco(result.getString("ENDERECO_PARTICIPANTE"));
					participante.setCpf(result.getString("CPF_PARTICIPANTE"));
					participante.setNumInscricao(result.getInt("NUM_INSCRICAO_PARTICIPANTE"));
					participante.setRevisor(result.getBoolean("REVISOR_PARTICIPANTE"));
					
					MunicipioDAO mDAO = new MunicipioDAO();
					CongressoDAO cDAO = new CongressoDAO();
					
					Municipio m = new Municipio();
					Congresso co = new Congresso();
					
					m.setId(result.getInt("MUNICIPIO_ID_FK"));
					co.setId(result.getInt("MUNICIPIO_ID_FK"));

					m = mDAO.listarPorId(m);
					co = cDAO.listarTodos();
					
					participante.setMunicipio(m);
					participante.setCongresso(co);
					
					participantes.add(participante);
	            }
	            result.close();
	            return participantes;
	        }catch (SQLException e){
	
	        }        
        return null;
	}
	@Override
	public Participante buscarParticipantePorNumInscricao(String numInscricao){
		String sql = "select * from atena.participante where NUM_INSCRICAO_PARTICIPANTE = "
				+ numInscricao +";";
		Participante participante = new Participante();    
		Conexao c = new Conexao();
	    c.conectar(); 
        try{
            ResultSet result = c.processaConsulta(sql);
            while (result.next()){
            	participante.setId(result.getInt("ID_PARTICIPANTE_PK"));
				participante.setNome(result.getString("NOME_PARTICIPANTE"));
				participante.setTelefone(result.getString("TEL_PARTICIPANTE"));
				participante.setEmail(result.getString("TEL_PARTICIPANTE"));
				participante.setEndereco(result.getString("ENDERECO_PARTICIPANTE"));
				participante.setCpf(result.getString("CPF_PARTICIPANTE"));
				participante.setNumInscricao(result.getInt("NUM_INSCRICAO_PARTICIPANTE"));
				participante.setRevisor(result.getBoolean("REVISOR_PARTICIPANTE"));
				
				MunicipioDAO mDAO = new MunicipioDAO();
				CongressoDAO cDAO = new CongressoDAO();
				
				Municipio m = new Municipio();
				Congresso co = new Congresso();
				
				m.setId(result.getInt("MUNICIPIO_ID_FK"));
				co.setId(result.getInt("CONGRESSO_ID_FK"));

				m = mDAO.listarPorId(m);
				co = cDAO.listarTodos();
				
				participante.setMunicipio(m);
				participante.setCongresso(co);
            }
            result.close();
            return participante;
        }catch (SQLException e){

        }        
    return null;
	}

	@Override
	public Participante buscarParticipantePorCPF(String cpf) {
		// TODO Auto-generated method stub
		return null;
	}


}
