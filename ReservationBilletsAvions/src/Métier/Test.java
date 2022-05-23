package Métier;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedHashMap;


//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.time.LocalDateTime;
//import java.sql.Date;
//import ConnexionDataBase.ConnexionDB;


public class Test {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws Exception {
		
		/*ConnexionDB c = new ConnexionDB() ;
		//c.airportConnexion();
		PreparedStatement pstmt = c.airportConnexion().prepareStatement("Select * from tclient ");
		pstmt.executeQuery();*/
		java.sql.Date sqlDate = new java.sql.Date(2020,12,12);
		//Client C = new Client("Bendir","Mohammed",sqlDate,"PA234355","A114550","mohammed","123123");
		//Client.ajouterClient(C);
		//System.out.println(Client.authentification("mustapha","123123"));
		
		Admin A = new Admin ("Bendir","med","root5","1234ASZ");
		//A.modificationAdmin(3, A);
		//Admin A = new Admin ("Hna","mustapha","root4","000999");
		//A.modificationAdmin(4, A);
		//Admin.ajouterAdmin(A);
		//Admin.supprimerAdmin(6);
		//Admin.ajouterCategorie("Etudiants", 0.6);
		//Admin.supprimerCategorie(4);
		//Admin.modifierCategorie(2,"Senior",0.25);
		//Admin.ajouterClasse("Busniss", 2.0);
		//Admin.supprimerClasse(4);
		//Admin.modifierClasse(2,"Economie", 1.5);
		//Client.modifierClient(2, C);
		//Admin.tauxOccupationAvion(2, new java.sql.Date(2021,06,27), new java.sql.Date(2021,07,03));
	//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ Si soufiane @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
		//Admin.ajouterTrajet("Rt","Ps",34.022405, -6.834543, 48.8566969,2.351461);
				//Trajet.SupprimerTrajet(12);
				//Avion A = new Avion("TEst",12000.0, 12.0,"disp", 5);
				//Avion.ajouterAvion(A);
				//Avion.SupprimerAvion(5);
				//System.out.println(Avion.voirEtat(5));
				//Avion.modiferEtateAvion(5, "WAlut");
				//Avion.ModifierAvion(A,5);
				//System.out.println(Vol.MethodeTime(15, 30,0));
				//Trajet.calDis();
		  
		       /*Dimension tailleEcran = java.awt.Toolkit.getDefaultToolkit().getScreenSize(); 
		        int hauteur = (int)tailleEcran.getHeight(); 
		        int largeur = (int)tailleEcran.getWidth();
		         System.out.println(hauteur    +"  "+ largeur);*/
				
				//System.out.println(Client.methode(5).toString());
				//Client C = new Client("Ait Aicha","Othmane",new Date(1998,5,12),"PA124578","PD124589", "othmane","123123");
				//Client.Inscription(C);
				//System.out.println(Client.connecter("soufiane","123123"));
				//System.out.println(Client.returnClient(4).toString());
				//System.out.println(Vol.methodeTime(15,37));
		
				//System.out.println(Vol.Concat("Agadir","Madrid").toString());
        		//java.sql.Date R1=java.sql.Date.valueOf("2021-06-10");
				//System.out.println(Vol.checkdate(R1, "Agadir", "Madrid"));
				//System.out.println(Vol.recherche(R1, "Agadir", "Madrid"));
				//System.out.println(Vol.CalculerDureetime(new Time(21,10,00), new Time(16,30,00)));
				/*@SuppressWarnings("deprecation")
				java.util.Date dateStart = new java.util.Date(2021,04,05,00,35,00);
				@SuppressWarnings("deprecation")
				java.util.Date dateStop = new java.util.Date(2021,04,06,06,30,00);
				System.out.println(Vol.CalculerDuree(dateStop, dateStart));*/
				//Vol.calDure(13) ;
		//Reservation R = new Reservation(1,1,"Rabat","London",new Date(2021,06,27),20,25,2,"Hna","Mustapha",3);
		//Reservation.modifierReservation(1, R);
		//Reservation.ajouterReservationBD(R);
		//Reservation.testDateReservation();
		//System.out.println(Reservation.resClient(1).toString());
		//Vol.CheckHour(null, sqlDate, 0, 0, 0);
		Vol  V = new  Vol(11, 3, new Date(2021, 07,06), new Date(2021, 07, 06),"0",06, 45, 10, 35);
		//Vol.TestinsererVol(V);
	     //Trajet trajet = new Trajet("Rabat", "London", 33.9715904, -6.8498129, 51.5073509, -0.1277583);
	     //System.out.println(Trajet.CalculDistance(trajet));
	    // System.out.println(Trajet.CalculDistance(1));
	    // System.out.println(trajet.getDistance());
	     //Trajet.mettreAjourDis();
		//System.out.println(Reservation.chercherTest(new Date(2021,06,01), "Rabat", "London",Vol.methodeTimse(15, 30, 0)).get(1));
		//System.out.println(Reservation.resClient(1));
		//System.out.println(Vol.CheckHour(new Time(15, 00, 00),new java.sql.Date(2021,06,06),3));
		//System.out.println(Vol.CheckHourExact(new Time(19, 00, 00),new java.sql.Date(2021,06,06),3));
		 //System.out.println(new java.sql.Date(2021,06,06)) ;
		//System.out.println(new Timestamp(2021, 07, 02, 13, 30,00 , 00));
		//System.out.println(Client.returnIdClient("Med"));
		//Object O = Reservation.faireReservation("pas","Casablanca",new Date(2021,06,03), 11, 45,2,"bendir","med", 1);
		/*if (O instanceof String) {
			System.out.println(O);	
		}*/
		//System.out.println(Vol.checkdate(new Date(2021,06,04),"Paris", "Casablanca"));///
		//System.out.println(Vol.CheckHourExact(new Time(12,45,00), new Date(2021,06,04), 2));
		//System.out.println(Vol.CheckHourExact(new Time(12,00,00), new Date(2021,06,04), 2));
		/* Date dateDep = new Date(2021,06,9);
		 Date dateDep1 = new Date(2021,06,9);
		System.out.println(dateDep.equals(dateDep1));*/
		//System.out.println(Vol.checkdate(new Date(2021,06,04), "Paris", "Casablanca"));
		//System.out.println(Vol.CheckHour(new Time(11,45,0),new Date(2021,06,04), 2));
		//System.out.println(Admin.tauxOccupationAvion(3, new Date(2021,5,4)));
		//System.out.println(Admin.dateApresTrimistre(new Date(2021,5,4))+" "+new Date(2021,5,4));
		//System.out.println(Admin.dateCopie(new Date(2021-1900,5-1,6)));
		//System.out.println(Admin.convetStringToDouble("09 h 06 min"));
		//System.out.println(Admin.tauxOccupationAvion(2, new Date(2021,6,4)));
		//System.out.println(Admin.dateApresTrimistre(new java.sql.Date(2021,5,4)));
			/*ArrayList<Vol> VL = Admin.testVolTauxOccupation(10.5);
			for(Vol v : VL) {
				System.out.println(v.toString());
			}*/
		//Avion.setEtatAvion();
		//System.out.println(Billet.prixBillet(1));
		//Billet.genererBillet(1);
		//ArrayList<String> Ar = Reservation.resClient(1);
		/*LinkedHashMap<Integer,ArrayList<String>> F = Reservation.resClient(1);
		for(int i=1; i<= F.size();i++) {
			System.out.println(F.get(i));
		}*/
		//System.out.println(Billet.EnsembleBillets(1));
		//System.out.println(Client.testAncMotDePasse(2, "123123"));
		//java.sql.Date d = new Date(2021,6,1);
		//System.out.println(d);
		//System.out.println(Admin.tauxOccupationAvion(1, d));
		//System.out.println(Admin.convetStringToDouble("09 h 55 min"));
		//Vol.modifierVol(13, new Vol(4,6,new java.sql.Date(2021,6,1),new java.sql.Date(2021,6,1),11,45,13,50));
		//Vol.calDure(13);
		//System.out.println(Vol.CalculerDuree(new java.sql.Date(2021-1900,6-1,2),new java.sql.Date(2021-1900,6-1,1) ));
		//Avion.setEtatAvion();
		/*System.out.println(Vol.calDure(12));
		System.out.println(Vol.calDure(11));
		System.out.println(Vol.calDure(7));*/
	
	}
	
	
}
