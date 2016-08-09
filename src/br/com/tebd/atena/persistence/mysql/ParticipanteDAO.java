package br.com.tebd.atena.persistence.mysql;

public class ParticipanteDAO {
	
	public boolean inserir(Bebida bebida){
        String sql1, sql2;
         
        sql1 = "select max(codProduto) from delivery.produto where tipoProduto='BEBIDA'";

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
    
    public boolean deletarBebida(Bebida b){
        String sql;
        int tipo;
        
        sql = "delete from delivery.bebida where codBebida_produto ="+b.getCodigo()+";";
        Banco banco = new Banco();
        banco.conectar();
        
        int exclusao = banco.processaInclusao(sql);
        if(exclusao > 0){
            return true;
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
    
    //Retorna todos os dados debebida
    public ArrayList<Bebida> consultar(){
    
        String sql = "select * from delivery.produto P inner join delivery.bebida B on P.codProduto = B.codBebida_Produto;";
        ArrayList<Bebida> bebidas = new ArrayList<>();
        Bebida bebida;
        
        Banco b = new Banco();
        b.conectar();
        
        try{
            ResultSet result = b.processaConsulta(sql);
        
            while (result.next()){
                bebida = new Bebida();
                bebida.setNome(result.getString("nomeProduto"));
                bebida.setCodigo(result.getInt("codProduto"));
                bebida.setFornecedor(result.getString("fornecedor"));
                bebida.setTamanho(result.getString("tamanhoProduto"));
                bebida.setTipo(result.getString("tipoProduto"));
                bebida.setPreco(result.getDouble("valorProduto"));
                bebidas.add(bebida);
            }
            result.close();
            return bebidas;
        }catch (SQLException e){

        }        
        return null;
    }
    
    public Bebida consultarBebida(int cod){
    
        String sql = "select * from delivery.produto P inner join delivery.bebida B on P.codProduto = B.codBebida_Produto where codProduto="+cod+";";
        Bebida bebida = new Bebida();
        
        Banco b = new Banco();
        b.conectar();
        
        try{
            ResultSet result = b.processaConsulta(sql);
        
            while (result.next()){
                bebida = new Bebida();
                bebida.setNome(result.getString("nomeProduto"));
                bebida.setCodigo(result.getInt("codProduto"));
                bebida.setFornecedor(result.getString("fornecedor"));
                bebida.setTamanho(result.getString("tamanhoProduto"));
                bebida.setTipo(result.getString("tipoProduto"));
                bebida.setPreco(result.getDouble("valorProduto"));
            }
            result.close();
            return bebida;
        }catch (SQLException e){

        }        
        return null;
    }

}
