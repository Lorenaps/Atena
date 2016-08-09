package br.com.tebd.atena.persistence.mysql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.tebd.atena.entity.AreaConhecimento;
import br.com.tebd.atena.entity.Congresso;
import br.com.tebd.atena.entity.Municipio;
import br.com.tebd.atena.entity.Participante;

public class ParticipanteDAO {
	
	public boolean inserir(Bebida bebida){
        String sql;
         
        sql1 = "insert into delivery.bebida(codBebida_Produto, fornecedor) values ("
                +bebida.getCodigo()+",'"+bebida.getFornecedor()+"');";
        Banco b = new Banco();
        
        try{
            b.conectar();

            ResultSet result = b.processaConsulta(sql1);

            while (result.next()){
                int cod = result.getInt("max(codProduto)");
                bebida.setCodigo(cod);
            }
            
            sql2 = "insert into delivery.bebida(codBebida_Produto, fornecedor) values ("
                   +bebida.getCodigo()+",'"+bebida.getFornecedor()+"');";
            
            int inclusao = b.processaInclusao(sql2);
            if (inclusao>0)
                return true;

        }catch(Exception e){
            return false;
        }
        
        return false;
    }
    
    public boolean alterarBebida(Bebida b){
        String sql;
       
        sql = "update delivery.bebida set fornecedor='"+b.getFornecedor()+"' where codBebida_Produto ="+b.getCodigo()+";";
        Banco banco = new Banco();
        banco.conectar();
        
        int update = banco.processaInclusao(sql);
        if(update > 0){
            return true;
        }
        return false;                
    }
    
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
	
	public Participante listarPorId(Participante p){
	String sql = "select * from atena.participante where ID_PARTICIPANTE = "
			+ p.getNumInscricao()+";";
	Participante participante = new Participante();    
	Conexao c = new Conexao();
    c.conectar(); 
        try{
            ResultSet result = c.processaConsulta(sql);
            while (result.next()){
ID_PARTICIPANTE_PK, NOME_PARTICIPANTE, TEL_PARTICIPANTE, EMAIL_PARTICIPANTE, 
ENDERECO_PARTICIPANTE, CPF_PARTICIPANTE, NUM_INSCRICAO_PARTICIPANTE, 
REVISOR_PARTICIPANTE, MUNICIPIO_ID_FK, CONGRESSO_ID_FK 


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
				Congresso c = new Congresso();
				
				m.setId(result.getInt("MUNICIPIO_ID_FK"));
				c.setId(result.getInt("MUNICIPIO_ID_FK"));



            }
            result.close();
            return area;
        }catch (SQLException e){

        }        
    return null;
	}


}
