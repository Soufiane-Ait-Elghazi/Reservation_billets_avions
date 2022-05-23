package Métier;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ConnexionDataBase.ConnexionDB;

public class Client {
	private String nomClient;
	private String prenomClient;
	private String dateNaissance;
	private String cinClient;
	private String numPassPort;
	private String loginClient;
	private String passWordClient;
	
	
	//Constructor
	
	public Client(String nomClient, String prenomClient, String dateNaissance, String cinClient,
			String numPassPort, String loginClient, String passWordClient) {
		
		super();
		this.nomClient = nomClient;
		this.prenomClient = prenomClient;
		this.dateNaissance = dateNaissance;
		this.cinClient = cinClient;
		this.numPassPort = numPassPort;
		this.loginClient = loginClient;
		this.passWordClient = passWordClient;
	}

	//getters and setters
	
	public String getNomClient() {
		return nomClient;
	}

	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}

	public String getPrenomClient() {
		return prenomClient;
	}

	public void setPrenomClient(String prenomClient) {
		this.prenomClient = prenomClient;
	}


	public String getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(String dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getCinClient() {
		return cinClient;
	}


	public void setCinClient(String cinClient) {
		this.cinClient = cinClient;
	}

	public String getNumPassPort() {
		return numPassPort;
	}

	public void setNumPassPort(String numPassPort) {
		this.numPassPort = numPassPort;
	}

	public String getLoginClient() {
		return loginClient;
	}

	public void setLoginClient(String loginClient) {
		this.loginClient = loginClient;
	}

	public String getPassWordClient() {
		return passWordClient;
	}

	public void setPassWordClient(String passWordClient) {
		this.passWordClient = passWordClient;
	}
	
	//ajouter client
	
	public static void  ajouterClient(Client C) throws Exception {
		ConnexionDB conn = new ConnexionDB();
		PreparedStatement ps= conn.airportConnexion().prepareStatement("Insert into tclient(NomClient,PrenomClient,DateNaissance,CINClient,NumPasseport,LoginClient,PassWordClient) values (?,?,?,?,?,?,?)");
		ps.setString(1,C.getNomClient());
		ps.setString(2,C.getPrenomClient());
		ps.setString(3,C.getDateNaissance());
		ps.setString(4,C.getCinClient());
		ps.setString(5,C.getNumPassPort());
		ps.setString(6,C.getLoginClient());
		ps.setString(7,C.getPassWordClient());
		ps.executeUpdate();
	}
	
	//connection
	
public static String authentification(String LoginClient, String PassWordClient) throws Exception {
		ConnexionDB con= new ConnexionDB() ;
		PreparedStatement stmt = con.airportConnexion().prepareStatement("select NomClient,PrenomClient from tclient where LoginClient=? and PasswordClient=? ");
		stmt.setString(1,LoginClient);
		stmt.setString(2, PassWordClient);
		ResultSet rs = stmt.executeQuery();
		rs.next();
		if(rs.isFirst()) {
			return "Bienvenu "+rs.getString(1)+" "+rs.getString(2);
		}
		return "Login ou mot de passe Incorrect";		
		
	}
	
	//modification compte

public static void  modifierClient(int IdClamodifier,Client newC) throws Exception {
	ConnexionDB conn = new ConnexionDB();
	PreparedStatement ps= conn.airportConnexion().prepareStatement("update tclient set NomClient=?,PrenomClient=?,DateNaissance=?,CINClient=?,NumPasseport=?,LoginClient=?,PassWordClient=? where ID_Client =?");
	ps.setString(1,newC.getNomClient());
	ps.setString(2,newC.getPrenomClient());
	ps.setString(3,newC.getDateNaissance());
	ps.setString(4,newC.getCinClient());
	ps.setString(5,newC.getNumPassPort());
	ps.setString(6,newC.getLoginClient());
	ps.setString(7,newC.getPassWordClient());
	ps.setInt(8,IdClamodifier);
	ps.executeUpdate();
}

//
public static int  returnIdClient(String login ) throws Exception
{
	ConnexionDB conn = new ConnexionDB();
	PreparedStatement ps =conn.airportConnexion().prepareStatement(" SELECT ID_Client FROM tclient WHERE LoginClient=? ");
	ps.setString(1, login);
	ResultSet rs = ps.executeQuery();
	rs.next();
	return rs.getInt("ID_Client");
}
// verifier auncien mot de passe 

public static int testAncMotDePasse(int id, String ancine) throws Exception {
	ConnexionDB conn = new ConnexionDB();
	PreparedStatement ps =conn.airportConnexion().prepareStatement(" SELECT PasswordClient FROM tclient WHERE ID_Client=? ");
	ps.setInt(1, id);
	ResultSet s = ps.executeQuery();
	s.next();
	if(s.getString(1).equals(ancine))
		return 1;
	else return 0;
}
	
	
	
}
