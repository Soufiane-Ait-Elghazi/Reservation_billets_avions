package Métier;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Vector;

import ConnexionDataBase.ConnexionDB;

public class Billet {
	private int IDResevation;
	private double PrixTotale;
	
	public Billet( int iDResevation, double prixTotale) {
		IDResevation = iDResevation;
		PrixTotale = prixTotale;
	}
	


	
	public int getIDResevation() {
		return IDResevation;
	}

	public void setIDResevation(int iDResevation) {
		IDResevation = iDResevation;
	}


	public double getPrixTotale() {
		return PrixTotale;
	}

	public void setPrixTotale(double prixTotale) {
		PrixTotale = prixTotale;
	}
	
	// billets d'un client donné
	
	public static LinkedHashMap<Integer,ArrayList<String>> EnsembleBillets(int id) throws Exception{
		int i=0;
		LinkedHashMap<Integer, ArrayList<String>> L = new LinkedHashMap<>();
		ConnexionDB conn = new ConnexionDB();
		PreparedStatement Billet1 =conn.airportConnexion().prepareStatement("SELECT ID_Reservation,NomPersonne,PrenomPersonne,VilleDepart,VilleArrivee,DateDepart,HeureDepart FROM treservation WHERE ID_Client=?");
		Billet1.setInt(1, id);
		ResultSet rs1 =  Billet1.executeQuery();
		while(rs1.next()) {
			
			ArrayList<String> liste = new ArrayList<String>();
			i++;
			PreparedStatement Billet =conn.airportConnexion().prepareStatement("SELECT Prix FROM tbillet  WHERE ID_Reservation=?");
			Billet.setInt(1, rs1.getInt(1));
			ResultSet rs = Billet.executeQuery();
			rs.next();
			liste.add(rs1.getString(2));
			liste.add(rs1.getString(3));
			liste.add(rs1.getString(4));
			liste.add(rs1.getString(5));
			liste.add(rs1.getDate(6).toString());
			liste.add(rs1.getTime(7).toString());
			liste.add(rs.getDouble(1)+" DHs");
		
			
			L.put(i, liste);
		}
		
		return L;
	}
	
	// prix d'un billet
	
	public static double prixBillet(int idReservation) throws SQLException, Exception {
		
		ConnexionDB conn = new ConnexionDB();
		PreparedStatement Billet =conn.airportConnexion().prepareStatement("select ID_Vol ,ID_Classe ,ID_Categorie from treservation where ID_Reservation = ?");
		Billet.setInt(1,idReservation);
		ResultSet rs = Billet.executeQuery();
		rs.next();
		PreparedStatement Classe =conn.airportConnexion().prepareStatement("select PrixClasseKM from tclasse where ID_Classe = ? ");
		Classe.setInt(1, rs.getInt(2));
		ResultSet rs1 = Classe.executeQuery();
		rs1.next();
		PreparedStatement Trajet =conn.airportConnexion().prepareStatement("select ID_Trajet from tvol where ID_Vol = ?");
		Trajet.setInt(1, rs.getInt(1));
		ResultSet rs3 = Trajet.executeQuery();
		rs3.next();
		PreparedStatement Dis =conn.airportConnexion().prepareStatement("select Distance from ttrajet where ID_Trajet = ?");
		Dis.setInt(1, rs3.getInt(1));
		ResultSet rs4 = Dis.executeQuery();
		rs4.next();
		PreparedStatement Catego =conn.airportConnexion().prepareStatement("select RemiseCategorie from tcategorie where ID_Categorie = ?");
		Catego.setInt(1, rs.getInt(3));
		ResultSet rs5 = Catego.executeQuery();
		rs5.next();
		//prix avant remise P1 = prixClasseKM * Distance
		double prix = rs1.getDouble(1) * rs4.getDouble(1);
		//prix apres remise est Prix = P1-P1*remise
		double remise = rs5.getDouble(1);
		
		  			return  (double)Math.round((prix-(prix*remise))*1000) / 1000;
		  			// Math.round pour nombre de chiffres apres la virgule 	
	}
	
	// genérer un billet aprés une reservation 
	
		public static void genererBillet(int ID_Reservation) throws Exception, SQLException {
			ConnexionDB conn = new ConnexionDB();
			PreparedStatement Billet =conn.airportConnexion().prepareStatement("insert into tbillet(ID_Reservation ,Prix) values (?,?)");
			Billet.setInt(1, ID_Reservation);
			Billet.setDouble(2, prixBillet(ID_Reservation));
			Billet.executeUpdate();
		}
		
	// chiffre D'affaire Client
		
		public static Vector chiffreAffaire(int idClien) throws SQLException, Exception {
	    	 Vector<String> vect = new Vector<String>();
	    	 double tot=0;
	    	 int nombreBillet=0;
	    	 ConnexionDB conn = new ConnexionDB();
	    	 PreparedStatement p =conn.airportConnexion().prepareStatement("select NomClient ,PrenomClient from tclient where ID_Client =?");
	    	 p.setInt(1, idClien);
	    	 ResultSet res= p.executeQuery();
	    	 res.next();
	    	 vect.add(res.getString(1));
	    	 vect.add(res.getString(2));
	    	 PreparedStatement ps =conn.airportConnexion().prepareStatement("select ID_Reservation from treservation where ID_Client =?");
	    	 ps.setInt(1, idClien);
	    	 ResultSet rs = ps.executeQuery();
	    	 while(rs.next()) {
	    	
	        	 PreparedStatement ps1 =conn.airportConnexion().prepareStatement("select Prix from tbillet where ID_reservation =? ");
	        	 ps1.setInt(1, rs.getInt(1));
	        	 ResultSet r= ps1.executeQuery();
	        	 while(r.next()) {
	        		 tot= tot+ r.getDouble(1);
	        		 nombreBillet++;
	        		 }
	    		 
	    	 }
	    	  vect.add(nombreBillet+" Billets");
	    	  vect.add(tot+" DHs");
	    	 
	    	 return vect;
	    	 
	     }
}
