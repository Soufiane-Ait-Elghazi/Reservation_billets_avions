package Métier;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;

import ConnexionDataBase.ConnexionDB;


public class Reservation {
	private static int c=0;
	
	private String villeDepart;
	private String villeDarrivee;
	private Date dateDepart;
	private Date DateReservation;
	private int idClient;
	private int idVol;
	private int hours;
	private int minutes;
	private int secondes;
	private int  classeR;
	private String nomPersonne;
	private String prenomPersonne;
	private int  categoriePersonne;
	public Reservation(int idClient,int idVol ,String villeDepart, String villeDarrivee, Date dateDepart,
			  int hours, int minutes, int classeR,String nomPersonne, String prenomPersonne, int categoriePersonne) {
		super();
		this.idClient = idClient;
		
		this.idVol = idVol;
		this.villeDepart = villeDepart;
		this.villeDarrivee = villeDarrivee;
		this.dateDepart =dateDepart;
		this.DateReservation =new Date(System.currentTimeMillis());
		this.hours = hours;
		this.minutes = minutes;
		this.classeR = classeR;
		this.nomPersonne = nomPersonne;
		this.prenomPersonne = prenomPersonne;
		this.categoriePersonne = categoriePersonne;
	}
		
	public static int getC() {
			return c;
	}
	public static void setC(int c) {
			Reservation.c = c;
	
	}
	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}
	public int getIdVol() {
		return idVol;
	}

	public void setIdVol(int idVol) {
		this.idVol = idVol;
	}
	
	public String getVilleDepart() {
		return villeDepart;
	}

	public void setVilleDepart(String villeDepart) {
		this.villeDepart = villeDepart;
	}

	public String getVilleDarrivee() {
		return villeDarrivee;
	}
	

	public void setVilleDarrivee(String villeDarrivee) {
		this.villeDarrivee = villeDarrivee;
	}

	public Date getDateDepart() {
		return dateDepart;
	}

	public void setDateDepart(Date dateDepart) {
		this.dateDepart = dateDepart;
	}

	
	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

	public int getMinutes() {
		return minutes;
	}

	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}
	public int getClasseR() {
		return classeR;
	}

	public void setClasseR(int classeR) {
		this.classeR = classeR;
	}

	public String getNomPersonne() {
		return nomPersonne;
	}

	public void setNomPersonne(String nomPersonne) {
		this.nomPersonne = nomPersonne;
	}

	public String getprenomPersonne() {
		return prenomPersonne;
	}

	public void setprenomPersonne(String prenomPersonne) {
		this.prenomPersonne = prenomPersonne;
	}

	public int getCategorieReservation() {
		return categoriePersonne;
	}

	public void setCategorieReservation(int categorieReservation) {
		this.categoriePersonne = categorieReservation;
	}
	//@@@@@@@@@@@@@@@@@@@@@@@@@@@
	// Suppression d'une réservation sur la base de donnees
			public  static void supprimerReservation(int id) throws Exception 
			{
				
				ConnexionDB conn = new ConnexionDB();
				PreparedStatement ps=conn.airportConnexion().prepareStatement("DELETE FROM treservation WHERE ID_Reservation=?");
				ps.setInt(1, id);
				ps.executeUpdate();
				System.out.println("L'operation est bien effectué!");
				
			}
 
	// creation d'heurs sous la forme hh-mm-ss
	
			@SuppressWarnings("deprecation")
			public static java.sql.Timestamp MethodeTime( int heures, int minutes , int secondes)
			{
				java.util.Date dateinserer=new java.util.Date();
				dateinserer.setHours(heures);
				dateinserer.setMinutes(minutes);
				dateinserer.setSeconds(secondes);
				java.sql.Timestamp sqlTime=new java.sql.Timestamp(dateinserer.getTime());
				return sqlTime;
			}
	//@@@@@@@@@@@@@@@@@@@@@@@@@@@
			public static Date dateDpart( Date d) {
				 d.setMonth(d.getMonth()-1);
				 d.setYear(d.getYear()-1900);
				 return d;
			 }
			//@@@@@@@@@@@@@@@@@@@@@@@@@@@@
			// heures apres & avant 4 heures
			
			
			//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
			
			public static Time timestampToTime(java.sql.Timestamp T) {
				Time TT = new Time(T.getHours(),T.getMinutes(),0);
				return TT;
			}
			
			public static Date timestampToDate(java.sql.Timestamp T) {
				Date D = new Date(T.getYear(),T.getMonth(),T.getDay());
				return D;
			}
			
			//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
			
			// reserver 
			
		/*	public static Object faireReservation(String villeD, String villeAr, java.sql.Date  dateD, int HeurD, int MinutD, int classe,String nom,String prenom, int cat) throws Exception {
				dateD = (java.sql.Date) dateDpart(dateD);
				//Date DateDepart = new Date(dateD.getYear(),dateD.getMonth(),dateD.getDay());
				java.sql.Time heurdepar= timestampToTime(new Timestamp(2021, 07, 1, HeurD, MinutD,0, 0));
				ConnexionDB conn = new ConnexionDB();
				PreparedStatement ps = conn.airportConnexion().prepareStatement(" SELECT ID_Trajet from ttrajet where villeDepart =? and villeArrivee =? ");
				ps.setString(1, villeD);
				ps.setString(2, villeAr);
				ResultSet rs=ps.executeQuery();
				//verifie s'il y'a un trajet dans les Villes de depart et arrive entrer par le client
				if(rs.next()) {
					PreparedStatement ps1 = conn.airportConnexion().prepareStatement(" SELECT * from tvol where ID_Trajet = ?");			
					ps1.setInt(1, rs.getInt(1));
					ResultSet rs1 = ps1.executeQuery();
					if(rs1.next()) {
						if((Vol.checkdate(dateD, villeD, villeAr)).equals(dateD)) {
							//System.out.println("fait !!!");
							//si oui
							//verifie s'il y'a une vol dans l'heur depart entrer par le client
							if(Vol.CheckHourExact(rs1.getTime(6),dateD,rs.getInt(1)).equals(heurdepar)) {
								//System.out.println("test");
								Reservation R = new Reservation(c,rs1.getInt(1), villeD, villeAr,dateD,HeurD, MinutD,classe,nom,prenom,cat);
									ajouterReservationBD(R);
									return "Votre Réservation est bien effectuée";
							}
							else {
								
								return Vol.CheckHour(heurdepar, dateD, rs.getInt(1));
							}
						}
						else {
							return Vol.recherche(dateD, villeD, villeAr);
							
						}
					}
				}
					return "Vérifier les noms des Villes ou Pas des Vols dans ce trajet";
			}*/
			// reserver avec contraintes 
			//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
			
			public static Object faireReservation1(String villeD, String villeAr, java.sql.Date  dateD, int HeurD, int MinutD, int classe,String nom,String prenom, int cat) throws Exception {
				dateD = (java.sql.Date) dateDpart(dateD);
				//Date DateDepart = new Date(dateD.getYear(),dateD.getMonth(),dateD.getDay());
				java.sql.Time heurdepar= timestampToTime(new Timestamp(2021, 07, 1, HeurD, MinutD,0, 0));
				ConnexionDB conn = new ConnexionDB();
				PreparedStatement ps = conn.airportConnexion().prepareStatement(" SELECT ID_Trajet from ttrajet where villeDepart =? and villeArrivee =? ");
				ps.setString(1, villeD);
				ps.setString(2, villeAr);
				ResultSet rs=ps.executeQuery();
				//verifie s'il y'a un trajet dans les Villes de depart et arrive entrer par le client
				if(rs.next()) {
					PreparedStatement ps1 = conn.airportConnexion().prepareStatement(" SELECT * from tvol where ID_Trajet = ?");			
					ps1.setInt(1, rs.getInt(1));
					ResultSet rs1 = ps1.executeQuery();
					if(rs1.next()) {
						if((Vol.checkdate(dateD, villeD, villeAr)).equals(dateD)) {
							//System.out.println("fait !!!");
							//si oui
							//verifie s'il y'a une vol dans l'heur depart entrer par le client
							if(Vol.CheckHourExact(rs1.getTime(6),dateD,rs.getInt(1)).equals(heurdepar)) {
								//System.out.println("test");
								//Reservation R = new Reservation(c,rs1.getInt(1), villeD, villeAr,dateD,HeurD, MinutD,classe,nom,prenom,cat);
									//ajouterReservationBD(R);
								// tester la disponibilité de la place 
							
								ConcurrencePlaces cp= new ConcurrencePlaces(rs1.getInt(1),classe ,c,nom,prenom,cat);
								//cp.test();
									return cp.test();
							}
							
							else {
								
								return Vol.CheckHour(heurdepar, dateD, rs.getInt(1));
								
							
							}
						}
						else {
							return Vol.recherche(dateD, villeD, villeAr);
							
						}
					}
				}
					return "Désolé, nous n'avons trouvé aucun vol pour ce trajet";
					
			}
			//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	
	// modification d'une reservation 
			
			public static void modifierReservation(int idR_a_modifier,Reservation R ) throws Exception
			{
				
				ConnexionDB conn = new ConnexionDB();
				String sql="Update treservation set ID_Vol=? , VilleDepart=? , VilleArrivee=? , DateDepart=? , heureDepart=? , ID_Classe=?  , NomPersonne=?,PrenomPersonne=?,ID_Categorie=?, ID_Client=?, DateReservation=? WHERE ID_Reservation= ?; ";
				PreparedStatement ps=conn.airportConnexion().prepareStatement(sql);
				ps.setInt(1, R.idVol);
				ps.setString(2, R.getVilleDepart());			
				ps.setString(3, R.getVilleDarrivee());
                ps.setDate(4,(java.sql.Date)R.getDateDepart());
				ps.setTimestamp(5, Reservation.MethodeTime(R.getHours(), R.getMinutes(), 0));
				ps.setInt(6, R.getClasseR());
				ps.setString(7, R.getNomPersonne());
				ps.setString(8, R.getprenomPersonne());
				ps.setInt(9, R.getCategorieReservation());
				ps.setInt(10, R.idClient);
				ps.setDate(11,(java.sql.Date) new Date(System.currentTimeMillis()));
				ps.setInt(12, idR_a_modifier);
				System.err.println("tttttt");
				ps.executeUpdate();		
			}
			 // ajouter une reservation dans la bas de donnes.
			
	public static void ajouterReservationBD(Reservation R) throws Exception {
		ConnexionDB conn = new ConnexionDB();
		PreparedStatement pd=conn.airportConnexion().prepareStatement(" SELECT CURRENT_DATE ");
		ResultSet rf =pd.executeQuery();
		
		rf.next();
			String sql = "INSERT INTO treservation( ID_Client, ID_Vol, VilleDepart, VilleArrivee, DateDepart, heureDepart, ID_Classe, DateReservation, NomPersonne, PrenomPersonne,  ID_Categorie) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps=conn.airportConnexion().prepareStatement(sql);
			ps.setInt(1, R.getIdClient());
			ps.setInt(2, R.getIdVol());
			ps.setString(3, R.getVilleDepart());			
			ps.setString(4, R.getVilleDarrivee());
			ps.setDate(5, (java.sql.Date)R.getDateDepart());
			ps.setTime(6, Reservation.timestampToTime(MethodeTime(R.getHours(), R.getMinutes(), 0)));
			ps.setInt(7, R.getClasseR());
			ps.setDate(8, rf.getDate(1));
			ps.setString(9, R.getNomPersonne());
			ps.setString(10, R.getprenomPersonne());
			ps.setInt(11, R.getCategorieReservation());
			try {
				ps.executeUpdate();	
			} catch (Exception e) {
				// TODO: handle exception
			}
					
						}
			//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	
	// Supprimer les reservations passent deja une année
	
				public static void testDateReservation() throws Exception   
				{
					
					ConnexionDB conn = new ConnexionDB();
					PreparedStatement ps = conn.airportConnexion().prepareStatement(" SELECT ID_Reservation,DateReservation FROM treservation ");
					ResultSet rt=ps.executeQuery();
					while(rt.next()) 
					{
						PreparedStatement pw=conn.airportConnexion().prepareStatement(" SELECT CURRENT_DATE ");
						ResultSet rw =pw.executeQuery();
						rw.next();
						
						java.util.Date y=rt.getDate(2);
						java.util.Date u = y;
						u.setYear(y.getYear()+1);
					
						if(rw.getDate(1).compareTo(u)>=0) 
						{
							PreparedStatement pq=conn.airportConnexion().prepareStatement(" DELETE FROM treservation WHERE ID_Reservation=? ");
							pq.setInt(1, rt.getInt(1));
							pq.executeUpdate();
						}
					}
					}
				
					//  les reservations d'un client donne
				
				
	public static LinkedHashMap<Integer,ArrayList<String>> resClient(int idCleint) throws Exception {
		int i=0;
		LinkedHashMap<Integer,ArrayList<String>> HM = new LinkedHashMap<Integer,ArrayList<String>>();
					
					ConnexionDB conn = new ConnexionDB();
		 PreparedStatement st = conn.airportConnexion().prepareStatement("select NomPersonne, PrenomPersonne, VilleDepart, VilleArrivee, DateDepart, heureDepart, ID_Classe, ID_Categorie, DateReservation from  treservation where ID_Client = ? ");
		 st.setInt(1,idCleint);
		 ResultSet rs=st.executeQuery();
		 while(rs.next()) {
			 i++;
			 PreparedStatement st1 = conn.airportConnexion().prepareStatement("select NomClasse from tclasse where ID_Classe = ?");	
			 st1.setInt(1, rs.getInt(7));
			 ResultSet rs1 = st1.executeQuery();
			 rs1.next();
			 PreparedStatement st2 = conn.airportConnexion().prepareStatement("select LibelleCategorie from tcategorie where ID_Categorie = ?");
			 st2.setInt(1, rs.getInt(8));
			ResultSet rs2 = st2.executeQuery();
			rs2.next();
			ArrayList<String> liste_reservations = new ArrayList<String>();
			
			liste_reservations.add(rs.getString(1));
			liste_reservations.add(rs.getString(2));
			liste_reservations.add(rs.getString(3));
			liste_reservations.add(rs.getString(4));
			liste_reservations.add(rs.getString(5));
			liste_reservations.add(rs.getString(6));
			liste_reservations.add(rs1.getString(1));
			liste_reservations.add(rs2.getString(1));
			liste_reservations.add(rs.getString(9));
			HM.put(i, liste_reservations);
		
			
		 }
			return HM;
					  }	
	
			//to String
	
	
					public  String toString() {
						return "Reservation : villeDepart=" + villeDepart + ", villeDarrivee=" + villeDarrivee
								+ ", dateDepart=" + dateDepart + ", DateReservation=" + DateReservation + ", idClient="
								+ idClient + ", idVol=" + idVol + ", hours=" + hours + ", minutes=" + minutes
								+ ", secondes=" + secondes + ", classeR=" + classeR + ", nomPersonne=" + nomPersonne
								+ ", prenomPersonne=" + prenomPersonne + ", categoriePersonne=" + categoriePersonne
								+ "\n";
						
					}

						
}
