package Métier;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ConnexionDataBase.ConnexionDB;
///import jdk.internal.org.objectweb.asm.tree.TryCatchBlockNode;
public class Avion {
	
	private String NomAvion;
	private Double Autonomie;
	private String EtatAvion;
	private int CapaciteTotale;
	
	public Avion(String nomAvion , Double autonomie,String etatAvion,int capacitetotale) {
		
		this.setNomAvion(nomAvion);
	    this.setAutonomie(autonomie);
	    this.setEtatAvion(etatAvion);
	    this.setCapaciteTotale(capacitetotale);
			
		}

	public String getNomAvion() {
		return NomAvion;
	}
	public void setNomAvion(String nomAvion) {
		NomAvion = nomAvion;
	}
	public Double getAutonomie() {
		return Autonomie;
	}
	public void setAutonomie(Double autonomie) {
		Autonomie = autonomie;
	}
	public String getEtatAvion() {
		return EtatAvion;
	}
	public void setEtatAvion(String etatAvion) {
		EtatAvion = etatAvion;
	}
	public int getCapaciteTotale() {
		return CapaciteTotale;
	}
	public void setCapaciteTotale(int capaciteTotale) {
		CapaciteTotale = capaciteTotale;
	}
	
	
	public static void  ajouterAvion(Avion A) throws Exception {
		ConnexionDB conn= new ConnexionDB();
		PreparedStatement ps=conn.airportConnexion().prepareStatement("Insert into tavion(NomAvion,Autonomie,EtatAvion,CapaciteTotale) values (? , ? , ? , ?) ");
		ps.setString(1, A.getNomAvion());
		ps.setDouble(2, A.getAutonomie());
		ps.setString(3,A.getEtatAvion());
		ps.setInt(4,A.getCapaciteTotale());
		ps.executeUpdate();
	}
	

	public static void supprimerAvion(int ID_Avion) throws Exception {
		ConnexionDB conn= new ConnexionDB();
		PreparedStatement ps=conn.airportConnexion().prepareStatement("Delete from tavion where ID_Avion = ?");
		ps.setInt(1,ID_Avion);
		ps.executeUpdate();
		
	}
	
     public static void modiferEtateAvion(int ID_Avion,String newEtate)throws Exception{
    	 ConnexionDB conn= new ConnexionDB();
		PreparedStatement ps=conn.airportConnexion().prepareStatement("Update tavion set EtatAvion=? Where ID_Avion=?");
		ps.setString(1,newEtate);
		ps.setInt(2,ID_Avion);
		
		ps.executeUpdate();
		
	  }
     
 	public static String voirEtat(int ID_Avion) throws Exception {
 		ConnexionDB conn= new ConnexionDB();
		PreparedStatement ps=conn.airportConnexion().prepareStatement("Select EtatAvion from tavion where ID_Avion=?");
		ps.setInt(1, ID_Avion);
		ResultSet rs=ps.executeQuery();
		rs.next();
		return rs.getString("EtatAvion");
		
	}
 	// modifier etat Avion 
 	
public static void modifierEtatAvion(int ID_Avion,String chaine)throws Exception{
		
		ConnexionDB conn= new ConnexionDB();
		PreparedStatement ps=conn.airportConnexion().prepareStatement("Update tavion set EtatAvion=? Where ID_Avion=?");
		ps.setString(1,chaine);
		ps.setInt(2,ID_Avion);
		ps.executeUpdate();
		
	}
 	//@@@@@@@@@@@@@@@@
 	
	public static void ModifierAvion(Avion A , int idav) throws Exception {
		
		ConnexionDB conn= new ConnexionDB();
		PreparedStatement ps=conn.airportConnexion().prepareStatement("Update tavion set NomAvion=? , Autonomie=?, EtatAvion = ?, CapaciteTotale =?   WHERE ID_Avion=? ");
		ps.setString(1, A.getNomAvion());
		ps.setDouble(2, A.getAutonomie());
		ps.setString(3, A.getEtatAvion());
		ps.setInt(4, A.getCapaciteTotale());
		ps.setInt(5, idav);
		ps.executeUpdate();
		

	}
	// tester etat avion 
	
	public static void setEtatAvion() throws Exception, SQLException {
		ConnexionDB conn = new ConnexionDB();
		
		PreparedStatement ps3 = conn.airportConnexion().prepareStatement("select ID_Avion  ,DateArrivee from tvol");
		ResultSet rs3=ps3.executeQuery();
		
		
		while(rs3.next()) {
			
			PreparedStatement ps2=conn.airportConnexion().prepareStatement("Update tavion set EtatAvion='disponible' where ID_Avion=? and DATEDIFF( CURRENT_DATE,?)>0 ");
			ps2.setInt(1, rs3.getInt(1));
			ps2.setDate(2,rs3.getDate(2));
			//ps2.setDate(2,rw.getDate(1));
			try {
				ps2.executeUpdate();
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			
		}
		
		PreparedStatement ps = conn.airportConnexion().prepareStatement("select ID_Avion ,DateDepart ,DateArrivee from tvol");
		ResultSet rs=ps.executeQuery();
		
		while(rs.next()) {
			PreparedStatement ps2=conn.airportConnexion().prepareStatement("Update tavion set EtatAvion ='indisponible' where ID_Avion=? and  CURRENT_DATE between ? and ?");
			ps2.setInt(1, rs.getInt(1));
			//ps2.setDate(2,rw.getDate(1));
			ps2.setDate(2,rs.getDate(2));
			ps2.setDate(3,rs.getDate(3));
			try {
				ps2.executeUpdate();
			} catch(Exception e) {
				
			}
			
			
		}
		
		return;
	}
}
