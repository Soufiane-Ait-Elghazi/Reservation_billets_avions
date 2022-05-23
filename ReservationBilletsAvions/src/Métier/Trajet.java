package Métier;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ConnexionDataBase.ConnexionDB;

public class Trajet {
	
	
	private String VilleDepart;
	private String VilleArrivee;
    private static Double LatitudeVilleDepart;
    private static Double LongitudeVilleDepart;
    private static Double LatitudeVilleArrivee;
    private static Double LongitudeVilleArrivee;
    private double distance;
    
    public Trajet(String villeDepart, String villeArrivee, double latitudeVilleDepart, double longitudeVilleDepart,double latitudeVilleArrivee, double longitudeVilleArrivee) {
    	
    	this.setLatitudeVilleArrivee(latitudeVilleArrivee);
    	this.setLatitudeVilleDepart(latitudeVilleDepart);
    	this.setLongitudeVilleArrivee(longitudeVilleArrivee);
    	this.setLongitudeVilleDepart(longitudeVilleDepart);
    	this.setVilleArrivee(villeArrivee);
    	this.setVilleDepart(villeDepart);
    	this.distance= this.CalculDistance(latitudeVilleDepart, longitudeVilleDepart, latitudeVilleArrivee, longitudeVilleArrivee);
    	}
    

	public String getVilleDepart() {
		return VilleDepart;
	}
	public void setVilleDepart(String villeDepart) {
		VilleDepart = villeDepart;
	}
	public String getVilleArrivee() {
		return VilleArrivee;
	}
	public void setVilleArrivee(String villeArrivee) {
		VilleArrivee = villeArrivee;
	}
	public static Double getLatitudeVilleDepart() {
		return LatitudeVilleDepart;
	}
	public static void setLatitudeVilleDepart(Double latitudeVilleDepart) {
		LatitudeVilleDepart = latitudeVilleDepart;
	}
	public static Double getLongitudeVilleDepart() {
		return LongitudeVilleDepart;
	}
	public static void setLongitudeVilleDepart(Double longitudeVilleDepart) {
		LongitudeVilleDepart = longitudeVilleDepart;
	}
	public static Double getLatitudeVilleArrivee() {
		return LatitudeVilleArrivee;
	}
	public static void setLatitudeVilleArrivee(Double latitudeVilleArrivee) {
		LatitudeVilleArrivee = latitudeVilleArrivee;
	}
	public static Double getLongitudeVilleArrivee() {
		return LongitudeVilleArrivee;
	}
	public static void setLongitudeVilleArrivee(Double longitudeVilleArrivee) {
		LongitudeVilleArrivee = longitudeVilleArrivee;
	}
	public double getDistance() {
		return distance;
	}
	public void setDistance(double distance) {
		this.distance = distance;
	}
    
	public static void  ajouterTrajet(Trajet T) throws Exception {
		ConnexionDB conn = new ConnexionDB();
		PreparedStatement ps = conn.airportConnexion().prepareStatement("Insert into ttrajet(VilleDepart,LatitudeVilleDepart,LongitudeVilleDepart,VilleArrivee,LatitudeVilleArrivee,LongitudeVilleArrivee,Distance) values(? , ? , ? , ? , ? , ? , ?) ");
		ps.setString(1, T.VilleDepart);
		ps.setDouble(2, T.LatitudeVilleDepart);
		ps.setDouble(3, T.LongitudeVilleDepart);
		ps.setString(4,T.VilleArrivee);
		ps.setDouble(5, T.LatitudeVilleArrivee);
		ps.setDouble(6, T.LongitudeVilleArrivee);
		ps.setDouble(7, 0);
		//Trajet.CalculDistance(T.LatitudeVilleDepart,T.LongitudeVilleDepart,T.LatitudeVilleArrivee,T.LongitudeVilleArrivee)
		ps.executeUpdate();
		PreparedStatement pst = conn.airportConnexion().prepareStatement("select MAX(ID_Trajet) from ttrajet");
		ResultSet r = pst.executeQuery();
		r.next();
		PreparedStatement ps1 = conn.airportConnexion().prepareStatement("Update ttrajet set Distance = ? where ID_Trajet = ?");
		ps1.setDouble(1,CalculDistance(r.getInt(1)));
		ps1.setInt(2, r.getInt(1));
		ps1.executeUpdate();
		
	}
	
   public Trajet() {}
		
	       private static double DEGtoRAD(double deg) {
		      return (deg * Math.PI / 180.0);
		    }

		    private static double RADtoDEG(double rad) {
		      return (rad * 180.0 / Math.PI);
		    }
		    
		  
		    public static void supprimerTrajet(int iD_Trajet) throws Exception{
		    	ConnexionDB conn = new ConnexionDB();
				PreparedStatement ps=conn.airportConnexion().prepareStatement("Delete From ttrajet where ID_Trajet=?");
				ps.setInt(1,iD_Trajet);
				ps.executeUpdate();
				}
		    
		    public static void modifierTrajet(int id,Trajet T) throws Exception {
		    	ConnexionDB conn = new ConnexionDB();
				PreparedStatement ps=conn.airportConnexion().prepareStatement("Update ttrajet set VilleDepart=?, LatitudeVilleDepart=?, LongitudeVilleDepart=?, VilleArrivee=?, LatitudeVilleArrivee =?, LongitudeVilleArrivee =?, Distance=?  WHERE ID_Trajet=? ");
				ps.setString(1,T.getVilleDepart());
				ps.setDouble(2, T.getLatitudeVilleDepart());
				ps.setDouble(3, T.getLongitudeVilleDepart());
				ps.setString(4, T.getVilleArrivee());
				ps.setDouble(5, T.getLatitudeVilleArrivee());
				ps.setDouble(6, T.getLongitudeVilleArrivee());
				ps.setDouble(7, T.CalculDistance(T.getLatitudeVilleDepart(), T.getLongitudeVilleDepart(), T.getLatitudeVilleArrivee(), T.getLongitudeVilleArrivee()));
				ps.setInt(8, id);

				ps.executeUpdate();
				
			}
		    
     public static double CalculDistance(double lat1, double lon1, double lat2, double lon2) {
      double dist = Math.acos( Math.sin(DEGtoRAD(lat1)) * Math.sin(DEGtoRAD(lat2)) + Math.cos(DEGtoRAD(lat1)) * Math.cos(DEGtoRAD(lat2)) * Math.cos(DEGtoRAD(lon1 - lon2)) );
      dist = RADtoDEG(dist);
      dist = dist * 111.3;
      return dist;
     }
      
	    public static void  calDis(int idTrajet) throws Exception
	   {
	    	ConnexionDB conn = new ConnexionDB();
		   PreparedStatement ps=conn.airportConnexion().prepareStatement("update ttrajet  set Distance = ? where ID_Trajet=?");
			   ps.setDouble(1,CalculDistance(idTrajet));
			   ps.setInt(2,idTrajet);
			   ps.executeUpdate();
	   }
	    //@@@@@@@@@@@@@@@@@@@@
	    public static void  mettreAjourDis() throws Exception
		   {
		    	ConnexionDB conn = new ConnexionDB();
		    	 PreparedStatement ps1=conn.airportConnexion().prepareStatement("select ID_Trajet from ttrajet ");
		    	 ResultSet rs = ps1.executeQuery();
		    	 while(rs.next()) {
			   PreparedStatement ps=conn.airportConnexion().prepareStatement("update ttrajet  set Distance = ? where ID_Trajet=?");
				   ps.setDouble(1,CalculDistance(rs.getInt(1)));
				   ps.setInt(2,rs.getInt(1));
				   ps.executeUpdate();
				   }
		   }
	    //@@@@@@@@@@@@@@@@@@@@
	    
	    /*
	     *INSERT INTO `ttrajet` (`VilleDepart`, `LatitudeVilleDepart`, `LongitudeVilleDepart`, `VilleArrivee`, `LatitudeVilleArrivee`, `LongitudeVilleArrivee`, `Distance`) VALUES
('Casablanca', 	33.520593, 	-7.568060, 'New York', 40.712784, 	-74.005941, 0),
('Rabat', 33.9715904, -6.8498129, 'Algerie', 28.033886, 1.659626, 0),
('Settet', 33.0010300, -7.6166200, 'Errachidia', 31.9314000, -4.4266300, 0),
('Bruxelle',50.8504500, 4.3487800, 'Laayoune', 25.443590, -13.174035, 0),
('Istanbul', 41.049022, 29.031372, 'Tokyo', 35.689487, 139.691706, 0),
('Meknes',33.895000, -5.554722, 'Dubai', 25.0657000, 55.1712800, 0)*/
		   
     public static double CalculDistance(Trajet T) {
         double dist = Math.acos( Math.sin(DEGtoRAD(T.getLatitudeVilleDepart())) * Math.sin(DEGtoRAD(T.getLatitudeVilleArrivee())) + Math.cos(DEGtoRAD(T.getLatitudeVilleDepart())) * Math.cos(DEGtoRAD(T.getLatitudeVilleArrivee())) * Math.cos(DEGtoRAD(T.getLongitudeVilleDepart() - T.getLongitudeVilleArrivee())) );
         dist = RADtoDEG(dist);
         dist = dist * 111.3;
         return dist;
         
        } 
   //@@@@@@@@@@@@@@@@
     public static double CalculDistance(int idTrajet) throws SQLException, Exception {
    	 ConnexionDB conn = new ConnexionDB();
    	 PreparedStatement ps=conn.airportConnexion().prepareStatement("select * from ttrajet where ID_Trajet=?");
    	 ps.setInt(1, idTrajet);
    	 ResultSet rs = ps.executeQuery();
    	 rs.next();
         double dist = Math.acos( Math.sin(DEGtoRAD(rs.getDouble(3))) * Math.sin(DEGtoRAD(rs.getDouble(6))) + Math.cos(DEGtoRAD(rs.getDouble(3))) * Math.cos(DEGtoRAD(rs.getDouble(6))) * Math.cos(DEGtoRAD(rs.getDouble(4) - rs.getDouble(7))));
         dist = RADtoDEG(dist);
         dist = dist * 111.3;
         return (double) Math.round(dist * 100) / 100;
        } 
     //@@@@@@@@@@@@@@@
    
}

