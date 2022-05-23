	package Métier;
import java.beans.Statement;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import javax.sound.midi.SysexMessage;

import ConnexionDataBase.ConnexionDB;
	
	public class Admin {
		private String nomAdmin;
		private String prenomAdmin;
		private String loginAdmin;
		private String passwordAdmin;
		
		//Constructor
		
		public Admin(String nomAdmin, String prenomAdmin, String loginAdmin, String passwordAdmin) {
			super();
			this.nomAdmin = nomAdmin;
			this.prenomAdmin = prenomAdmin;
			this.loginAdmin = loginAdmin;
			this.passwordAdmin = passwordAdmin;
		}
		public Admin() {
			
		}
		//getters and setters
		
		public String getNomAdmin() {
			return nomAdmin;
		}
	
		public void setNomAdmin(String nomAdmin) {
			this.nomAdmin = nomAdmin;
		}
	
		public String getPrenomAdmin() {
			return prenomAdmin;
		}
	
		public void setPrenomAdmin(String prenomAdmin) {
			this.prenomAdmin = prenomAdmin;
		}
	
		public String getLoginAdmin() {
			return loginAdmin;
		}
	
		public void setLoginAdmin(String loginAdmin) {
			this.loginAdmin = loginAdmin;
		}
	
		public String getPassWordAdmin() {
			return passwordAdmin;
		}
	
		public void setPassWordAdmin(String passwordAdmin) {
			this.passwordAdmin = passwordAdmin;
		}
		
		//modification Admin
		
		public static boolean modificationAdmin(int Id, Admin Ad) throws Exception {
			
			ConnexionDB conn = new ConnexionDB();
			PreparedStatement ps =conn.airportConnexion().prepareStatement(" Update tadmin set NomAdmin=? , PrenomAdmin=? , LoginAdmin=? , PasswordAdmin=? Where ID_Admin=?  ");
			ps.setString(1, Ad.getNomAdmin());
			ps.setString(2, Ad.getPrenomAdmin());
			ps.setString(3, Ad.getLoginAdmin());
			ps.setString(4, Ad.getPassWordAdmin());
			ps.setInt(5, Id);
			ps.executeUpdate();
			if(ps.executeUpdate()!=0)
				return true;
			return false;
		}
		
		//ajouter un Admin
		
	public static void ajouterAdmin(Admin Ad) throws Exception {
			ConnexionDB conn = new ConnexionDB();
			
			PreparedStatement ps =conn.airportConnexion().prepareStatement("insert into tadmin(NomAdmin,PrenomAdmin,LoginAdmin,PasswordAdmin) values (?,?,?,?)");
			ps.setString(1, Ad.getNomAdmin());
			ps.setString(2, Ad.getPrenomAdmin());
			ps.setString(3, Ad.getLoginAdmin());
			ps.setString(4, Ad.getPassWordAdmin());
			ps.executeUpdate();
		}
	
		//supprimer un Admin
	
	public static boolean supprimerAdmin(int id) throws Exception {
		ConnexionDB conn = new ConnexionDB();
		PreparedStatement ps =conn.airportConnexion().prepareStatement("delete from tadmin where ID_Admin = ?");
		ps.setInt(1, id);
		//ps.executeUpdate();
		if(ps.executeUpdate()!=0)
			return true;
		return false;
	}
	
		//ajouter une categorie
	
	public static void ajouterCategorie(String categorie, double remise) throws Exception {
		ConnexionDB conn = new ConnexionDB();
		
		PreparedStatement ps =conn.airportConnexion().prepareStatement("insert into tcategorie(LibelleCategorie,RemiseCategorie) values (?,?)");
		ps.setString(1, categorie);
		ps.setDouble(2, remise);
		ps.executeUpdate();
	}
	
		//supprimer une categorie
	
	public static void supprimerCategorie(int idCat) throws Exception {
		ConnexionDB conn = new ConnexionDB();
		
		PreparedStatement ps =conn.airportConnexion().prepareStatement("delete from tcategorie where ID_Categorie = ?");
		ps.setInt(1, idCat);
		ps.executeUpdate();
	}
	
		//modifier une categorie
	
	public static void modifierCategorie(int idCatamodifier,String newLibelle, Double newRemise) throws Exception {
		ConnexionDB conn = new ConnexionDB();
		
		PreparedStatement ps =conn.airportConnexion().prepareStatement("update tcategorie set LibelleCategorie = ?, RemiseCategorie = ? where ID_Categorie = ? ");
		ps.setString(1, newLibelle);
		ps.setDouble(2, newRemise);
		ps.setInt(3, idCatamodifier);
		ps.executeUpdate();
	}
	
	//ajouter une classe
	
	public static void ajouterClasse(String newNomClasse, double newPrix_Km) throws Exception {
		ConnexionDB conn = new ConnexionDB();
		PreparedStatement ps =conn.airportConnexion().prepareStatement("insert into tclasse(NomClasse,PrixClasseKM) values (?,?)");
		ps.setString(1,newNomClasse);
		ps.setDouble(2, newPrix_Km);
		ps.executeUpdate();
	}
	
	//supprimer une classe
	
	public static void supprimerClasse(int idCla) throws Exception {
	ConnexionDB conn = new ConnexionDB();
	
	PreparedStatement ps =conn.airportConnexion().prepareStatement("delete from tclasse where ID_Classe = ?");
	ps.setInt(1, idCla);
	ps.executeUpdate();
	}
	
	//modifier une classe
	
	public static void modifierClasse(int idCla_amodifier,String newNom, Double newPrix_KM) throws Exception {
	ConnexionDB conn = new ConnexionDB();
	PreparedStatement ps =conn.airportConnexion().prepareStatement("update tclasse set NomClasse = ?, PrixClasseKM = ? where ID_Classe = ? ");
	ps.setString(1, newNom);
	ps.setDouble(2, newPrix_KM);
	ps.setInt(3, idCla_amodifier);
	ps.executeUpdate();
	}
	
	//ajouter avion par l'admin
	
	 public static void ajouterAvion(Avion A) throws Exception 
	  {
		  Avion.ajouterAvion(A);
	  }
	
	//modifier avion
	
	 public static void ModifierAvion(Avion av, int idAvion) throws Exception 
	  {
		  Avion.ModifierAvion(av, idAvion);
	  }
	  
	//supprimer avion
	
	 public static void supprimerAvion(int id) throws Exception 
	  {
		  Avion.supprimerAvion(id);
	  }
	
	//modifier etat avion 
	
	 public static void ModifierEtatAvion(int id , String Etat) throws Exception 
	  {
		  Avion.modiferEtateAvion(id, Etat);
	  }
	 
	//voir l'etat d'un avion 
		
		 public static void voirEtatAvion(int idAvion) throws Exception 
		  {
			  Avion.voirEtat(idAvion);
		  }
		 
		//ajouter trajet par l'admin
			
		 public static void ajouterTrajet(Trajet T) throws Exception 
		  {
			  Trajet.ajouterTrajet(T);
		  }
		 
		//supprimer Trajet par l'admin
			
		 public static void supprimerTrajet(int id) throws Exception 
		  {
			  Trajet.supprimerTrajet(id);
		  }
		 
		//modifier trajet par l'admin
			
		 public static void modifierTrajet( int id,Trajet T) throws Exception 
		  {
			  Trajet.modifierTrajet(id,T);
		  }
		 
		//ajouter un vol par l'admin
			
		 public static void ajouterVol(Vol V) throws Exception 
		  {
			  Vol.TestinsererVol(V);
		  }
		 
		//supprimer un Vol
		 
		 public static void supprimerVol(int id) throws Exception {
			 Vol.suppVol(id);
		 }
		 
	
// authentifiaction admin
	public static String authentification(String LoginAdmin, String PassWordAdmin) throws Exception {
		ConnexionDB con= new ConnexionDB() ;
		PreparedStatement stmt = con.airportConnexion().prepareStatement("select NomAdmin,PrenomAdmin from tadmin where LoginAdmin=? and PasswordAdmin=? ");
		stmt.setString(1,LoginAdmin);
		stmt.setString(2, PassWordAdmin);
		ResultSet rs = stmt.executeQuery();
		rs.next();
		if(rs.isFirst()) {
			return "Bienvenu L'administrateur "+rs.getString(1)+" "+rs.getString(2);
		}
		return "Login ou mot de passe Incorrect";		
	}
	
	//convetStringTime
	
	public static double convetStringToDouble(String str) {
		String heurString=str.substring(0,2);
		String minStrin=str.substring(5,7);
		//String heurString= str.charAt(0)+""+str.charAt(1);
		//String minStrin= str.charAt(5)+""+str.charAt(6);
		
		int heurs =Integer.parseInt(heurString);
		int minutes =Integer.parseInt(minStrin);
	
		return (double) Math.round(( heurs+ (double)minutes/60)*100)/100;
				
	}

	
	//Statistiques par trimestre
	
	public static Vector<String> tauxOccupationAvion(int idAvion, java.sql.Date date) throws Exception, SQLException  {
		Vector<String>  V = new Vector<>();
		date = Vol.dateDpart(date);
		double tauxOcc=0;
		int cp=0;
		ConnexionDB conn = new ConnexionDB();
		PreparedStatement ps =conn.airportConnexion().prepareStatement("select NomAvion,Autonomie,CapaciteTotale from tavion where ID_Avion =?  ");
		ps.setInt(1,idAvion);
		ResultSet rs = ps.executeQuery();
		rs.next();
		PreparedStatement ps1 =conn.airportConnexion().prepareStatement("select Duree from tvol where ID_Avion =? and DateDepart Between ? and DATE_ADD(?,interval +3 Month) and DateArrivee Between ? and DATE_ADD(?,interval +3 Month) "); 
		ps1.setInt(1, idAvion);
		ps1.setDate(2,date);
		ps1.setDate(3, date);
		ps1.setDate(4,date);
		ps1.setDate(5, date);
		ResultSet rs1 = ps1.executeQuery();
		while(rs1.next()) {
	    double dure =0;
		dure = convetStringToDouble(rs1.getString(1));
		tauxOcc = tauxOcc + dure;
		cp++;
		}		
		String t = tauxOcc+" Heures";
		V.add(rs.getString(1));
		V.add(""+rs.getDouble(2));
		V.add(""+rs.getInt(3));
		V.add(t);
	
		return V;
	}
	
		// la liste des vols dont le taux d’occupation est inférieur à un seuil fixé
	
	public static ArrayList<Vol> testVolTauxOccupation(double SeuilTAFixe) throws Exception
	{
		ConnexionDB conn = new ConnexionDB();
		ArrayList<Vol> AV = new ArrayList<>();
		java.sql.Statement st = conn.airportConnexion().createStatement();
	    ResultSet rs = st.executeQuery("SELECT * FROM tvol");
	    while(rs.next())
	    {
	    	if(convetStringToDouble(rs.getString("Duree"))<=SeuilTAFixe)
	    	{
	    		AV.add(new Vol(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getDate(4),rs.getDate(5),rs.getString(8),rs.getTime(6).getHours(),rs.getTime(6).getMinutes(),rs.getTime(7).getHours(),rs.getTime(7).getMinutes()));
	    	}
	    }
	    		return AV;	
	}
	
		
		//id Admin
		
		public static int  returnIdAdmin(String login) throws Exception
		{
			ConnexionDB conn = new ConnexionDB();
			PreparedStatement ps =conn.airportConnexion().prepareStatement(" SELECT ID_Admin FROM tadmin WHERE LoginAdmin=?");
			ps.setString(1, login);
			ResultSet rs = ps.executeQuery();
			rs.next();
			return rs.getInt("ID_Admin");
		}
	}
