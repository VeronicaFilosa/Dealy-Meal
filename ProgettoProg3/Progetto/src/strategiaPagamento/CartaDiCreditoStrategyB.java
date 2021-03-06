package strategiaPagamento;
import java.sql.SQLException;
import classidb.Database;

/******************************************************************************
 * Questa classe definisce la strategia di pagamento di tipo Carta di credito *
 ******************************************************************************/
public class CartaDiCreditoStrategyB implements StrategiaPagamento {
	
	/*Questo metodo implementa la strategia di pagamento di tipo carta di credito: inserisce una tupla nella tabella pagamento con la tipologia di
	* carta = Carta di credito.*/
	@Override
	public void pagamento(float costo, int numeroCarta,int numeroPrenotati,int orarioP ,String username, int idMenuP, int idBibita){
	
		Database D = Database.getIstance();
		
		try{
			  	Class.forName("com.mysql.jdbc.Driver");
	            D.stmt = D.conn.createStatement();
	            D.stmt.executeUpdate("INSERT INTO `dbristorante`.`pagamento` (`tipologiaCarta`, `importo`,`numCarta`,`numeroPrenotati`,`orarioPrenotazione`,`usernameCl`,`idMenuP`, `idAggiunta`) VALUES ('Carta Di Credito', '"+costo+"', '"+numeroCarta+"','"+numeroPrenotati+"', '"+orarioP+"', '"+username+"', '"+idMenuP+"', '"+idBibita+"')" );                    	
	            
		}catch(ClassNotFoundException e) {
	        	System.out.println(e);
	    }
	    catch(SQLException e)
	    {
	        	System.out.println(e);
	    }
	}

}
