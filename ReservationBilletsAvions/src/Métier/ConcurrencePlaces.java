package Métier;

import java.sql.*;

import ConnexionDataBase.ConnexionDB;

public class ConcurrencePlaces 
{
	 static int idVol;     //idvol
	 static int idClasse;    //classe
	 static int idcli;    //idclient
	 static String nompersonne;
	 static String prenompersonne;
	 static  int idCateg;
	 
	
	public ConcurrencePlaces(int idvol,int idclas,int idclient,String nm,String pm,int idcatg)
	{
		

		this.idVol=idvol;
		this.idClasse=idclas;
		this.idCateg=idcatg;
		this.idcli=idclient;
		this.nompersonne=nm;
		this.prenompersonne=pm;
		
		
		
		
	}
	
	public  synchronized String test() throws SQLException, Exception{
		
			ConnexionDB conn = new ConnexionDB();
			PreparedStatement ps =conn.airportConnexion().prepareStatement(" SELECT ID_Avion From tvol Where ID_Vol=?  ");
			ps.setInt(1,  this.idVol);
			ResultSet idAv =ps.executeQuery();
			idAv.next();
			
			if(this.idClasse==1) {
				PreparedStatement p =conn.airportConnexion().prepareStatement(" SELECT nombreCap From tcapacite Where ID_Avion =? and ID_Classe= 1 ");
				p.setInt(1,idAv.getInt(1));
				ResultSet nbPl =p.executeQuery();
				nbPl.next();
				
				if(nbPl.getInt(1)>0) {
					System.out.println("vous avez le droit de reserver");
					
					// les infos du vol donné
					PreparedStatement ps1 =conn.airportConnexion().prepareStatement(" SELECT ID_Trajet,DateDepart,heureDepart,DateArrivee FROM tvol WHERE ID_Vol=? ");
					ps1.setInt(1,this.idVol);
					ResultSet rt = ps1.executeQuery();
					rt.next();
					// recupereré les villes 
					PreparedStatement pj =conn.airportConnexion().prepareStatement(" SELECT VilleDepart,VilleArrivee From ttrajet WHERE ID_Trajet=? ");
					pj.setInt(1, rt.getInt(1));
					ResultSet rj = pj.executeQuery();
					rj.next();
					
					PreparedStatement pw=conn.airportConnexion().prepareStatement(" SELECT CURRENT_DATE ");
					ResultSet rw =pw.executeQuery();
					rw.next();
					System.err.println(this.idClasse+"   "+this.idCateg+"  "+this.idcli+"  "+this.idVol);
					Reservation.ajouterReservationBD(new Reservation(this.idcli, this.idVol, rj.getString(1), rj.getString(2), rt.getDate(2), rt.getTime(3).getHours(),rt.getTime(3).getMinutes(), this.idClasse, this.nompersonne, this.prenompersonne, this.idCateg));
					// generer billet
					PreparedStatement b = conn.airportConnexion().prepareStatement("select MAX(ID_Reservation) from treservation");
					ResultSet y = b.executeQuery();
					y.next();
					Billet.genererBillet(y.getInt(1));
					
					
						 
					
					//update nombre de place du 1er classe 
					PreparedStatement pd=conn.airportConnexion().prepareStatement(" Update tcapacite set nombreCap=nombreCap-1 WHERE ID_avion =? and ID_Classe=1" );
					pd.setInt(1,idAv.getInt(1) );
					pd.executeUpdate();
					return   "La réservation est bien effectuée ";
					
					
					
				}
				else 
					return "Désolé.Cette Classe est pleine, ressayer avec une autre classe.";
				}
				

			
			else if(this.idClasse==2) {
				PreparedStatement p =conn.airportConnexion().prepareStatement(" SELECT nombreCap From tcapacite Where ID_Avion =? and ID_Classe=2  ");
				p.setInt(1,idAv.getInt(1));
				ResultSet nbPl =p.executeQuery();
				nbPl.next();
				
				if(nbPl.getInt(1)>0) {
					System.out.println("vous avez le droit de reserver");
					
					// les infos du vol donné
					PreparedStatement ps1 =conn.airportConnexion().prepareStatement(" SELECT ID_Trajet,DateDepart,heureDepart,DateArrivee FROM tvol WHERE ID_Vol=? ");
					ps1.setInt(1,this.idVol);
					ResultSet rt = ps1.executeQuery();
					rt.next();
					// recupereré les villes 
					PreparedStatement pj =conn.airportConnexion().prepareStatement(" SELECT VilleDepart,VilleArrivee From ttrajet WHERE ID_Trajet=? ");
					pj.setInt(1, rt.getInt(1));
					ResultSet rj = pj.executeQuery();
					rj.next();
					
					PreparedStatement pw=conn.airportConnexion().prepareStatement(" SELECT CURRENT_DATE ");
					ResultSet rw =pw.executeQuery();
					rw.next();
					System.err.println(this.idClasse+"   "+this.idCateg+"  "+this.idcli+"  "+this.idVol);
					Reservation.ajouterReservationBD(new Reservation(this.idcli, this.idVol, rj.getString(1), rj.getString(2), rt.getDate(2), rt.getTime(3).getHours(),rt.getTime(3).getMinutes(), this.idClasse, this.nompersonne, this.prenompersonne, this.idCateg));
					// generer billet
					PreparedStatement b = conn.airportConnexion().prepareStatement("select MAX(ID_Reservation) from treservation");
					ResultSet y = b.executeQuery();
					y.next();
					Billet.genererBillet(y.getInt(1));
					
					
						 
					
					//update nombre de place du 1er classe 
					PreparedStatement pd=conn.airportConnexion().prepareStatement(" Update tcapacite set nombreCap=nombreCap-1 WHERE ID_avion =? and ID_Classe=2" );
					pd.setInt(1,idAv.getInt(1) );
					pd.executeUpdate();
					return "La réservation est bien effectuée ";
					
					
					
				}
				else 
					return "Désolé.Cette Classe est pleine, ressayer avec une autre classe.";
			}
			else if(this.idClasse==3) {
				PreparedStatement p =conn.airportConnexion().prepareStatement(" SELECT nombreCap From tcapacite Where ID_Avion =? and ID_Classe= 3  ");
				p.setInt(1,idAv.getInt(1));
				ResultSet nbPl =p.executeQuery();
				nbPl.next();
				
				if(nbPl.getInt(1)>0) {
					System.out.println("vous avez le droit de reserver");
					
					// les infos du vol donné
					PreparedStatement ps1 =conn.airportConnexion().prepareStatement(" SELECT ID_Trajet,DateDepart,heureDepart,DateArrivee FROM tvol WHERE ID_Vol=? ");
					ps1.setInt(1,this.idVol);
					ResultSet rt = ps1.executeQuery();
					rt.next(); 
					PreparedStatement pj =conn.airportConnexion().prepareStatement(" SELECT VilleDepart,VilleArrivee From ttrajet WHERE ID_Trajet=? ");
					pj.setInt(1, rt.getInt(1));
					ResultSet rj = pj.executeQuery();
					rj.next();
					
					PreparedStatement pw=conn.airportConnexion().prepareStatement(" SELECT CURRENT_DATE ");
					ResultSet rw =pw.executeQuery();
					rw.next();
					System.err.println(this.idClasse+"   "+this.idCateg+"  "+this.idcli+"  "+this.idVol);
					Reservation.ajouterReservationBD(new Reservation(this.idcli, this.idVol, rj.getString(1), rj.getString(2), rt.getDate(2), rt.getTime(3).getHours(),rt.getTime(3).getMinutes(), this.idClasse, this.nompersonne, this.prenompersonne, this.idCateg));
					// generer billet
					PreparedStatement b = conn.airportConnexion().prepareStatement("select MAX(ID_Reservation) from treservation");
					ResultSet y = b.executeQuery();
					y.next();
					Billet.genererBillet(y.getInt(1));
					
					PreparedStatement pd=conn.airportConnexion().prepareStatement(" Update tcapacite set nombreCap=nombreCap-1 WHERE ID_avion =? and ID_Classe=3" );
					pd.setInt(1,idAv.getInt(1) );
					pd.executeUpdate();
					
				
					
					return"La réservation est bien effectuée ";
					
				}
				else 
					 return "Désolé.Cette Classe est pleine, ressayer avec une autre classe" ;
			}
			else 
				return "ERROR";
		  
			
		

	}


	

}