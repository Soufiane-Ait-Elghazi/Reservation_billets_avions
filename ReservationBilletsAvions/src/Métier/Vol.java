package Métier;

import java.sql.Date;
import java.util.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;

import ConnexionDataBase.ConnexionDB;

public class Vol {
private int ID_Trajet;
private int ID_Avion;
private Date DateDepart;
private Date DateArrivee;
private String Duree;
private int hours;
private int minutes;
private int hours2;
private int minutes2;
private int idVol;
static boolean var=false;

public Vol(int iD_Trajet, int iD_Avion, Date dateDepart, Date dateArrivee, String duree, int hours, int minutes, int hours2, int minutes2) {
	
	this.setDateArrivee(dateDpart(dateArrivee));
	this.setDateDepart(dateDpart(dateDepart));
	this.setDuree(duree);
	this.setHours(hours);
	this.setID_Avion(iD_Avion);
	this.setID_Trajet(iD_Trajet);
	this.setMinutes(minutes);
	this.setHours2(hours2);
	this.setMinutes2(minutes2);
	
}

public Vol( int idVol,int iD_Trajet, int iD_Avion, Date dateDepart, Date dateArrivee, String duree,int hours, int minutes, int hours2, int minutes2) {
	
	this.idVol = idVol;
	this.DateArrivee = dateArrivee;
	this.DateDepart = dateDepart;
	this.Duree = duree;
	this.hours = hours;
	this.ID_Avion = iD_Avion;
	this.ID_Trajet = iD_Trajet;
	this.minutes = minutes;
	this.hours2 = hours2;
	this.minutes2 = minutes2;
	
}

public Vol(int iD_Trajet, Date dateDepart, Date dateArrivee, int hours, int minutes, int hours2, int minutes2, String duree) {
	
	this.setDateArrivee(dateDpart(dateArrivee));
	this.setDateDepart(dateDpart(dateDepart));
	this.setDuree(duree);
	this.setHours(hours);
	this.setID_Trajet(iD_Trajet);
	this.setMinutes(minutes);
	this.setHours2(hours2);
	this.setMinutes2(minutes2);
	
}

public Vol(int idT, int idavion, Date date, Date date2, int hd, int mind, int ha, int mina) {
	
	ID_Trajet = idT;
	ID_Avion = idavion;
	DateDepart = dateDpart(date) ;
	DateArrivee = dateDpart(date2);
	hours = hd;
	minutes = mind;
	hours2 = ha;
	minutes2 = mina;
	
}

public int getID_Trajet() {
	
	return ID_Trajet;
	
}


public void setID_Trajet(int iD_Trajet) {
	
	ID_Trajet =  iD_Trajet;
	
}


public int getID_Avion() {
	
	return ID_Avion;
	
}


public void setID_Avion(int iD_Avion) {
	
	ID_Avion = iD_Avion;
	
}

public Date getDateDepart() {
	
	return DateDepart;
	
}

public void setDateDepart(Date dateDepart) {
	
	DateDepart = dateDepart;
	
}

public Date getDateArrivee() {
	
	return DateArrivee;
	
}


public void setDateArrivee(Date dateArrivee) {
	
	DateArrivee = dateArrivee;
	
}

public String getDuree() {
	
	return Duree;
	
}


public void setDuree(String duree) {
	
	Duree = duree;
	
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

public int getHours2() {
	
	return hours2;
	
}


public void setHours2(int hours2) {
	
	this.hours2 = hours2;
	
}

public int getMinutes2() {
	
	return minutes2;
	
}

public void setMinutes2(int minutes2) {
	
	this.minutes2 = minutes2;
	
}
//toString

public String toString() {
	return "Vol "+idVol+" [ID_Trajet = " + ID_Trajet + ", ID_Avion = " + ID_Avion + ", DateDepart = " + DateDepart + ", DateArrivee = "
			+ DateArrivee + ", Duree = " + Duree + "]";
}


//////////
public static Date dateDpart( Date d) {
	 d.setMonth(d.getMonth()-1);
	 d.setYear(d.getYear()-1900);
	 return d;
}



/////////////
public static java.sql.Timestamp methodeTime( int heures, int minutes, int second)
{
	
	java.util.Date dateinserer=new java.util.Date();
	dateinserer.setHours(heures);
	dateinserer.setMinutes(minutes);
	dateinserer.setSeconds(0);
	java.sql.Timestamp sqlTime=new java.sql.Timestamp(dateinserer.getTime());
	return sqlTime;
	
}

public static ArrayList<Date> Concat(String Villed ,String VilleA) throws Exception{

	ArrayList<Date> a=new ArrayList<Date>();
	ConnexionDB conn = new ConnexionDB();
   PreparedStatement sn=conn.airportConnexion().prepareStatement("SELECT tvol.DateDepart  From tvol,ttrajet "
   		                                    + "where ttrajet.ID_Trajet=tvol.ID_Trajet  "
   		                                    + "and ttrajet.VilleDepart=? and ttrajet.VilleArrivee=?"
   		                                    + " order by tvol.DateDepart asc");
   sn.setString(1, Villed);
   sn.setString(2, VilleA);
   ResultSet rs=sn.executeQuery();
   
   while (rs.next()) 
   {
	   Date v=rs.getDate(1);
	   a.add(v);
   }
   return a;
   
}
public static java.sql.Date checkdate(java.sql.Date dateClient , String villiD,String VillA) throws Exception
{
	//dateClient = dateDpart(dateClient);
	Date attribut;
	ConnexionDB conn = new ConnexionDB();
    PreparedStatement sn=conn.airportConnexion().prepareStatement("select tvol.DateDepart "
    										+ "From tvol,ttrajet where "
    										+ "ttrajet.ID_Trajet=tvol.ID_Trajet "
    										+ "and ttrajet.VilleDepart=?"
    										+ " and ttrajet.VilleArrivee=? "
    										+ "and tvol.DateDepart=?");
    sn.setString(1, villiD);
    sn.setString(2, VillA);
    sn.setDate(3, (java.sql.Date) dateClient);
    
    ResultSet rs=sn.executeQuery();
    rs.next();
 
	if(rs.isFirst())
	{
		attribut= rs.getDate("DateDepart");
		return attribut;
	}
	else
	{
	    attribut=recherche(dateClient, villiD , VillA );
	    return attribut;
	    
	}
  }
public static Date recherche(java.util.Date  dateClient,String Villed ,String VilleA ) throws Exception
{
		ArrayList<Date> a=Concat( Villed , VilleA );
		Iterator c = a.iterator();
		 while (c.hasNext()) 
		    {
			 Date date =(Date)c.next();    
             if(date.compareTo(dateClient)>=0) 
              return date;
	        }
	 return null;
}
//@@@@@@@@@@@@@@@@@@@@@@@@@@@

public static String CalculerDuree(java.util.Date Arr,java.util.Date Dep) throws Exception
{
   SimpleDateFormat format = new SimpleDateFormat("yy/MM/dd HH:mm:ss");
    try {
      Date d1 = (Date) format.parse(Dep.toString());
      Date d2 = (Date) format.parse(Arr.toString());
    } catch (Exception e) {
        e.printStackTrace();
    }
	    long diff = Arr.getTime() - Dep.getTime();
	    //long diffSeconds = diff / 1000 % 60;
	    long diffMinutes = diff / (60 * 1000) % 60;
	    long diffHours = diff / (60 * 60 * 1000);
	    String str = diffHours+"";
	    String str1 = diffMinutes+"";
	    if(str.length()==1) {
	    	str = "0"+str;
	    if(str1.length()==1)
	    	str1 = "0"+str1;
	    }
	    else {
	    	if(str1.length()==1)
		    	str1 = "0"+str1;	
	    }
	    return str+" h "+str1+" min";
    
}
//@@@@@@@@@@@@@@@@@@@@@@@@@@
public static double CalculerDureetime(java.util.Date Arr,java.util.Date Dep) throws Exception
{
    SimpleDateFormat format = new SimpleDateFormat("yy/MM/dd HH:mm:ss");
    try {
      Date d1 = (Date) format.parse(Dep.toString());
      Date d2 = (Date) format.parse(Arr.toString());
    } catch (Exception e) {
        e.printStackTrace();
    }
	    long diff = Arr.getTime() - Dep.getTime();
	    //long diffSeconds = diff / 1000 % 60;
	    long diffMinutes = diff / (60 * 1000) % 60;
	    long diffHours = diff / (60 * 60 * 1000);
	    return (double)((diffHours*60)+diffMinutes)/60;
    
}
//@@@@@@@@@@@@@@@@@@@@@@@@@@
public static String  calDure(int idV) throws Exception
{
	
	 String dure="";
 	ConnexionDB conn = new ConnexionDB();
	   PreparedStatement ps=conn.airportConnexion().prepareStatement("select year(DateDepart),month(DateDepart),day(DateDepart),hour(heureDepart),minute(heureDepart),year(DateArrivee),month(DateArrivee),day(DateArrivee),hour(heureArrivee),minute(heureArrivee) from tvol where ID_Vol=?");
	   ps.setInt(1,idV);
	   ResultSet rs=ps.executeQuery();
	   //rs.next();
	  // System.out.println(new Date(rs.getInt(1)-1900,rs.getInt(2)-1,rs.getInt(3)));
	   while (rs.next()) 
	   {
	 dure = CalculerDuree(new java.util.Date(rs.getInt(6),rs.getInt(7),rs.getInt(8),rs.getInt(9),rs.getInt(10),00), new java.util.Date(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getInt(4),rs.getInt(5),00) );
	   }
	   PreparedStatement ps1=conn.airportConnexion().prepareStatement("update tvol  set Duree = ? where ID_Vol=?");
	   		ps1.setString(1,dure);
		   ps1.setInt(2,idV);
		   ps1.executeUpdate();
		   return dure;
		   
}
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
public static  ArrayList<Time> CheckHour( Time temps , java.sql.Date dateDep ,int id_trajet ) throws Exception
{
	//dateDep = dateDpart(dateDep);
	ArrayList<Time> timer = new ArrayList <Time> ();
	
	ConnexionDB conn = new ConnexionDB();
	/*PreparedStatement ps = conn.airportConnexion().prepareStatement(" SELECT heureDepart FROM tvol Where DateDepart=? AND ID_Trajet=? AND heureDepart=? ");
	ps.setDate(1, (java.sql.Date) dateDep);
	ps.setInt(2, id_trajet);
	ps.setTime(3, (java.sql.Time) temps );
	ResultSet rd = ps.executeQuery();
	//if(rd.next())
		timer.add(rd.getTime(1));
		var=true;*/
		
	PreparedStatement ps3 = conn.airportConnexion().prepareStatement(" SELECT heureDepart FROM tvol Where DateDepart=? AND ID_Trajet=? AND Hour(heureDepart) BETWEEN ? AND ? ");
 	ps3.setDate(1, (java.sql.Date) dateDep);
	ps3.setInt(2, id_trajet);
	ps3.setInt(3, temps.getHours()-4);
	ps3.setInt(4, temps.getHours()+4);
	ResultSet rs3 = ps3.executeQuery();
	rs3.next();
	while(!rs3.isAfterLast())
	{ 
		   timer.add(rs3.getTime(1));
		   rs3.next();
	} 
	return timer;
}
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

public static  java.sql.Time CheckHourExact( Time temps , Date dateDep ,int id_trajet ) throws Exception
{
	//dateDep = dateDpart(dateDep);
	ConnexionDB conn = new ConnexionDB();
	PreparedStatement ps = conn.airportConnexion().prepareStatement(" SELECT * FROM tvol Where DateDepart=? AND ID_Trajet=? AND heureDepart=? ");
	ps.setDate(1, (java.sql.Date) dateDep);
	ps.setInt(2, id_trajet);
	ps.setTime(3, temps);
		ResultSet rd = ps.executeQuery();
		rd.next();
		 return rd.getTime(6);
	
	}
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@


public static  ArrayList<Timestamp> CheckHour( java.sql.Timestamp temps , Date departure , int id ,int temps_A , int temps_B ) throws Exception
{
	ArrayList<java.sql.Timestamp > timer =new ArrayList <java.sql.Timestamp > ();
	
	ConnexionDB conn = new ConnexionDB();
	PreparedStatement ps = conn.airportConnexion().prepareStatement(" SELECT heureDepart FROM tvol Where DateDepart=? AND ID_Trajet=? AND heureDepart=? ");
	ps.setDate(1, (java.sql.Date) departure);
	ps.setInt(2, id);
	ps.setTimestamp(3, temps);
	
	ResultSet rd = ps.executeQuery();
	rd.next();
	
	if(rd.first()) 
	{
		timer.add(rd.getTimestamp(1));
		var=true;
	}
	else
	{
		
	PreparedStatement ps3 = conn.airportConnexion().prepareStatement(" SELECT heureDepart FROM tvol Where DateDepart=? AND ID_Trajet=? AND Hour(heureDepart) BETWEEN ? AND ? ");
 	ps3.setDate(1, (java.sql.Date) departure);
	ps3.setInt(2, id);
	ps3.setInt(3,temps_A);
	ps3.setInt(4,temps_B);
	ResultSet j=ps3.executeQuery();
	
	while(j.next()) 
	{
	   timer.add(j.getTimestamp(1));
	}
	
	}
	
	return timer;
}
//@@@@@@@@@@@@@@@@@@@@@@@@@

public static void suppVol(int id) throws Exception
{
	ConnexionDB conn = new ConnexionDB();
    PreparedStatement ps=conn.airportConnexion().prepareStatement("Delete from tvol WHERE ID_Vol=? " );
    ps.setInt(1, id);
    ps.executeUpdate();
    
}
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@
public java.sql.Timestamp MethodeTime( int heures, int minutes )
{
	
	java.util.Date dateinserer=new java.util.Date();
	dateinserer.setHours(heures);
	dateinserer.setMinutes(minutes);
	dateinserer.setSeconds(0);
	java.sql.Timestamp sqlTime=new java.sql.Timestamp(dateinserer.getTime());
	return sqlTime;
	
}


public static void TestinsererVol(Vol t) throws Exception
{
	   ArrayList<Avion> listAvion=new ArrayList<>();
	   ConnexionDB conn = new ConnexionDB();
       PreparedStatement ps=conn.airportConnexion().prepareStatement("select * from ttrajet where ID_Trajet=?" );
       ps.setInt(1,t.ID_Trajet );
       ResultSet rs=ps.executeQuery();
       rs.next();
       PreparedStatement ps1=conn.airportConnexion().prepareStatement("select * from tavion where Autonomie >=? and EtatAvion='disponible' " );
       ps1.setDouble(1,Trajet.CalculDistance(t.ID_Trajet));
       ResultSet rs1=ps1.executeQuery();
       rs.isFirst();
       PreparedStatement ps2=conn.airportConnexion().prepareStatement("select * from tavion  where Autonomie >=? and EtatAvion='disponible' and tavion.ID_Avion not in (select tvol.ID_Avion From tvol) " );
	   ps2.setDouble(1,Trajet.CalculDistance(t.ID_Trajet));
       ResultSet rs2=ps2.executeQuery();
       rs2.next();
       if(rs2.isFirst()) {
 
    		   PreparedStatement mp=conn.airportConnexion().prepareStatement(" SELECT CapaciteTotale FROM tavion WHERE ID_Avion=? ");
    		   mp.setInt(1, rs2.getInt(1));
    		   ResultSet mpr =mp.executeQuery();
    		   mpr.next();
        	   PreparedStatement ps3=conn.airportConnexion().prepareStatement("insert into tvol(ID_Trajet,ID_Avion,DateDepart,DateArrivee,heureDepart,heureArrivee,Duree) values(?,?,?,?,?,?,?)" );
        	   ps3.setInt(1,t.getID_Trajet());
        	   ps3.setInt(2,rs2.getInt(1));
        	   ps3.setDate(3,(java.sql.Date) t.DateDepart);
        	   ps3.setDate(4,(java.sql.Date) t.DateArrivee);
        	   ps3.setTimestamp(5,t.MethodeTime(t.getHours(), t.getMinutes()));
        	   ps3.setTimestamp(6,t.MethodeTime(t.getHours2(), t.getMinutes2()));
        	   ps3.setString(7,"0");
        	   ps3.executeUpdate();
        	   PreparedStatement psUpdate=conn.airportConnexion().prepareStatement("select ID_Vol from tvol tvol ORDER BY ID_vol DESC LIMIT 1");
        	   ResultSet rsUpdate = psUpdate.executeQuery();
        	   rsUpdate.next();
        	   PreparedStatement psUpdate1=conn.airportConnexion().prepareStatement("update tvol set Duree = ? where ID_Vol = ?");
        	   psUpdate1.setString(1,calDure(rsUpdate.getInt(1)));
        	   psUpdate1.setInt(2, rsUpdate.getInt(1));
        	   psUpdate1.executeUpdate();
        	   return;
    	       }
        //********************************************************
		PreparedStatement ps4=conn.airportConnexion().prepareStatement("SELECT tavion.ID_Avion from tavion WHERE  Autonomie>=? and EtatAvion='disponible' AND ID_Avion not in(select tvol.ID_Avion from tvol WHERE DateDepart=? AND DateArrivee=?)");
	    ps4.setDouble(1,Trajet.CalculDistance(t.ID_Trajet));
	    ps4.setDate(2,convertDate1(t.DateDepart));
 	    ps4.setDate(3,convertDate1(t.DateArrivee));
		ResultSet rs4=ps4.executeQuery();
		if(rs4.next())
		{
			   PreparedStatement mp1=conn.airportConnexion().prepareStatement(" SELECT CapaciteTotale FROM tavion WHERE ID_Avion=? ");
    		   mp1.setInt(1, rs4.getInt(1));
    		   ResultSet mpr1 =mp1.executeQuery();
    		   mpr1.next();
        	   PreparedStatement ps5=conn.airportConnexion().prepareStatement("insert into tvol(ID_Trajet,ID_Avion,DateDepart,DateArrivee,heureDepart,heureArrivee,Duree) values(?,?,?,?,?,?,?)" );
        			   ps5.setInt(1,t.ID_Trajet );
        			   ps5.setInt(2,rs4.getInt(1));
        			   ps5.setDate(3,convertDate1(t.DateDepart));
        			   ps5.setDate(4,convertDate1(t.DateArrivee));
        			   ps5.setTimestamp(5,t.MethodeTime(t.getHours(), t.getMinutes()));
    	        	   ps5.setTimestamp(6,t.MethodeTime(t.getHours2(), t.getMinutes2()));
        			   ps5.setString(7,"0");
        			   ps5.executeUpdate();
        			   PreparedStatement psUpdate1=conn.airportConnexion().prepareStatement("select ID_Vol from tvol tvol ORDER BY ID_vol DESC LIMIT 1");
                	   ResultSet rsUpdate1 = psUpdate1.executeQuery();
                	   rsUpdate1.next();
                	   PreparedStatement psUpdate2=conn.airportConnexion().prepareStatement("update tvol set Duree = ? where ID_Vol = ?");
                	   psUpdate1.setString(1,calDure(rsUpdate1.getInt(1)));
                	   psUpdate1.setInt(2, rsUpdate1.getInt(1));
                	   psUpdate1.executeUpdate();
        			   return ;
		}
      //*********************************************************
     PreparedStatement ps6=conn.airportConnexion().prepareStatement("select tvol.ID_Vol,tvol.ID_Trajet,tvol.ID_Avion,tvol.DateDepart,tvol.DateArrivee,tvol.heureDepart,tvol.heureArrivee,tvol.Duree from tvol,tavion where tvol.ID_Avion = tavion.ID_Avion and tvol.DateDepart = ? and tvol.DateArrivee = ?  and Autonomie >=? and EtatAvion='disponible' order by tvol.heureDepart  " );
    	  	   ps6.setDate(1,(java.sql.Date) t.DateDepart);
           ps6.setDate(2,(java.sql.Date) t.DateArrivee);
	       ps6.setDouble(3,Trajet.CalculDistance(t.ID_Trajet));
           ResultSet rs6=ps6.executeQuery(); 
          ArrayList<Vol> liste=new ArrayList<Vol>();
          while(rs6.next()) 
          {
        	   liste.add(new Vol(rs6.getInt(2),rs6.getInt(3),rs6.getDate(4),rs6.getDate(5),rs6.getString(8), rs6.getTime("heureDepart").getHours(),rs6.getTime("heureDepart").getMinutes(),rs6.getTime("heureArrivee").getHours(), rs6.getTime("heureArrivee").getMinutes()) );   
           }
           
           if(rs6.first()) {
           Vol var=liste.get(0);
           Vol bar=liste.get(liste.size()-1);
           if( (t.getHours2()+1) <= var.getHours() || (t.getHours() >=bar.getHours2()+1) ) {
        	   
        	   PreparedStatement mp2=conn.airportConnexion().prepareStatement(" SELECT NombrePlacesEco,NombrePlacesAff,NombrePlaces1ere FROM tavion WHERE ID_Avion=? ");
    		   mp2.setInt(1,var.getID_Avion());
    		   ResultSet mpr2 =mp2.executeQuery();
    		   mpr2.next();  
        	   PreparedStatement ps8=conn.airportConnexion().prepareStatement("insert into tvol(ID_Trajet,ID_Avion,DateDepart,DateArrivee,heureDepart,heureArrivee,Duree,CapaciteTotale) values(?,?,?,?,?,?,?,?,?,?)" );
        	   ps8.setInt(1,t.ID_Trajet );
        	   ps8.setInt(2,var.getID_Avion());
        	   ps8.setDate(3,(java.sql.Date) t.DateDepart);
        	   ps8.setDate(4,(java.sql.Date) t.DateArrivee);
			   ps8.setTimestamp(5,t.MethodeTime(t.getHours(), t.getMinutes()));
        	   ps8.setTimestamp(6,t.MethodeTime(t.getHours2(), t.getMinutes2()));
        	   ps8.setString(7, t.Duree);
        	   ps8.setInt(8, mpr2.getInt(1));
			   ps8.setInt(9, mpr2.getInt(2));
        	   ps8.setInt(10, mpr2.getInt(3));
        	   ps8.executeUpdate(); 
        	   return;
           }
           for(int i=1;i<liste.size()-1;i++) 
           { 
        	   if(t.getHours2()+1<=liste.get(i).getHours() && t.getHours()>=liste.get(i).getHours2()+1) 
        	   {
        		   PreparedStatement mp3=conn.airportConnexion().prepareStatement(" SELECT NombrePlacesEco,NombrePlacesAff,NombrePlaces1ere FROM tavion WHERE ID_Avion=? ");
	    		   mp3.setInt(1,var.getID_Avion());
	    		   ResultSet mpr3 =mp3.executeQuery();
	    		   mpr3.next();
	           PreparedStatement ps7=conn.airportConnexion().prepareStatement("insert into tvol(ID_Trajet,ID_Avion,DateDepart,DateArrivee,heureDepart,heureArrivee,Duree) values(?,?,?,?,?,?,?)" );
        	   ps7.setInt(1,t.ID_Trajet );
        	   ps7.setInt(2,var.getID_Avion());
        	   ps7.setDate(3,(java.sql.Date) t.DateDepart);
        	   ps7.setDate(4,(java.sql.Date) t.DateArrivee);
        	   ps7.setTimestamp(5,t.MethodeTime(t.getHours(), t.getMinutes()));
        	   ps7.setTimestamp(6,t.MethodeTime(t.getHours2(), t.getMinutes2()));
        	   ps7.setString(7, t.Duree);
        	   ps7.setInt(8, mpr3.getInt(1));
			   ps7.setInt(9, mpr3.getInt(2));
        	   ps7.setInt(10, mpr3.getInt(3));
        	   ps7.executeUpdate(); 
        	   return;
        	   }
           }
           }
       System.out.println("il faut ajouter une avion dans sa autonomie superieur ou egale a "+Trajet.CalculDistance(t.ID_Trajet)+"inserer un autre jour");
	}
	public static java.sql.Date convertDate1(java.util.Date date)
	   {
		  java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		   return sqlDate;
	   }
//@@@@@@@@@@@@@@@@@@@@@@@@@@@
	
	
	   public static void modifierVol(int idvol,Vol T) throws Exception {
	    	ConnexionDB conn = new ConnexionDB();
			PreparedStatement ps=conn.airportConnexion().prepareStatement("Update tvol set ID_Trajet=?, ID_Avion=? , DateDepart=?,DateArrivee=?,HeureDepart=?,HeureArrivee=?, Duree=?  WHERE ID_Vol=? ");
			ps.setInt(1,T.getID_Trajet());
			ps.setInt(2, T.getID_Avion());
		    ps.setDate(3,T.getDateDepart() );
			ps.setDate(4,T.getDateArrivee() );
			ps.setTime(5, new Time(T.getHours(),T.getMinutes(),0));
			ps.setTime(6,  new Time(T.getHours2(),T.getMinutes2(),0));
			ps.setString(7, "0");
			ps.setInt(8,idvol);
			ps.executeUpdate();
			PreparedStatement ps1=conn.airportConnexion().prepareStatement("Update tvol set Duree = ? where ID_Vol = ?");
			ps1.setString(1, calDure(idvol));
			ps1.setInt(2, idvol);
			ps1.executeUpdate();
			
		}
	//**************************fin Programme***************************
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
