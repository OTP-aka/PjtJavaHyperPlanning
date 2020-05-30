/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;
import controleurv1.*;
import java.sql.*;
import java.lang.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.time.*;
import static jdk.nashorn.internal.objects.NativeDate.getTime;

/**
 *
 * @author arist
 */
public class EmploiDuTempsEtudiant {
    private String Email;
    private String password;
    private ArrayList<String> Contenant_info_Emp_Etudiant_bdd = new ArrayList();
    
    public EmploiDuTempsEtudiant(String mail, String MDP)
    {
        Email = mail;
       password = MDP;
    }
    /*
    public void Afficher_Emploi_du_temps()
    {
         String recup;
        System.out.println("Zone Modèle : Zone de recherche Etudiant --> affichage de l'emploi du temps");
        ResultSet result;
        try {
        System.out.println("test 1");
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/planning";
        String user = "root";
        String passwd = "";
        System.out.println("test 2");
        //System.out.println("la valeur de Email est : "+ Email);
        Connection conn = DriverManager.getConnection(url, user, passwd);
System.out.println("test 3");
        //Création d'un objet Statement
        Statement state = conn.createStatement();
        result = state.executeQuery("SELECT seance.*  FROM Goupe,seance_groupe,seance WHERE Groupe.ID = seance_groupe.ID_Groupe AND seance_groupe.ID_Seance = seance.ID ");// Groupe.ID='"+ID_du_groupe+"'  à définrir !!!!
       ResultSetMetaData resultMeta = result.getMetaData();
       
       System.out.println("\n**********************************");
      //On affiche le nom des colonnes
      for(int i = 1; i <= resultMeta.getColumnCount(); i++)
        System.out.print("\t" + resultMeta.getColumnName(i).toUpperCase() + "\t *");
         
      System.out.println("\n**********************************");
       
        }catch (Exception e) {
        e.printStackTrace();
      } 
    }
    */
    public void Afficher_Emploi_du_temps(){
        ResultSet result;
        ResultSet result_time;
        String recup;
        //java.util.Date aujourdhui = new java.util.Date.Date();
        java.util.Date aujourdhui=new java.util.Date();
        try {
            System.out.println("Zone Modèle : Zone de recherche Etudiant --> affichage de l'emploi du temps");
      Class.forName("com.mysql.jdbc.Driver");
         
      String url = "jdbc:mysql://localhost:3306/planning";
      String user = "root";
      String passwd = "";
      Connection conn = DriverManager.getConnection(url, user, passwd);
         
      //Création d'un objet Statement
      Statement state = conn.createStatement();
      Statement state2 = conn.createStatement();
        result = state.executeQuery("SELECT seance.*  FROM groupe,seance_groupes,seance WHERE groupe.ID = seance_groupes.ID_Groupe AND seance_groupes.ID_Seance = seance.ID  ");// Groupe.ID='"+ID_du_groupe+"'  à définrir !!!!
     // result_time = state2.executeQuery("SELECT CONVERT(HEURE_DEBUT, String)");
//result = state.executeQuery("SELECT * FROM Utilisateur WHERE EMail = '"+Email+"' AND PASSWD = '"+password+"' ");
      ResultSetMetaData resultMeta = result.getMetaData();
     System.out.println("\n**********************************");
      //On affiche le nom des colonnes
      for(int i = 1; i <= resultMeta.getColumnCount(); i++)
        System.out.print("\t" + resultMeta.getColumnName(i).toUpperCase() + "\t *");
         
      System.out.println("\n**********************************");
      SimpleDateFormat formater = new SimpleDateFormat("h:mm a");
       System.out.println(formater.format(aujourdhui));
       
      while(result.next()){  
          //for(int i = 1; i <= resultMeta.getColumnCount(); i++)
        for(int i = 1; i <= 4; i++)
        {
          System.out.println("zone de test 5 récupération des données des variables");
          if(i== 4){
              String id = result.getString(4); 
            //// Time tc = result.getTime("HEURE_DEBUT");
            //System.out.println(tc);
            //Timestamp date;
            //date = result.getTimestamp(4);
           // date = result.getTimestamp("HEURE_DEBUT");
           // System.out.println("la valeur de date est : "+ date);
            //CONVERT(tc, String);
           // String s = getTimestamp("HEURE_DEBUT");
           // s = getDateTime(i);
           java.util.Date Marche_batard = new java.util.Date();
           SimpleDateFormat tarace = new SimpleDateFormat("hh:mm:ss");
           String strDate = tarace.format(Marche_batard);
           System.out.println("Date Format with MM/dd/yyyy : "+strDate); 
         }
          /*
          if(i==3){
            Time tempo;
            tempo = result.getTime(i);
            System.out.println("l'haure de début est : " + tempo);
            formater = new SimpleDateFormat("h:mm a");
            //recup = result.getTime(formater.format(aujourdhui)).toString();
            recup = tempo.toString();
            System.out.println("la valeur de reup est : " + recup);
             SimpleDateFormat formate = null;
            }
        */
          /*
            if(i==4){
               // SimpleDateFormat 
               formater = new SimpleDateFormat("h:mm a");
                 //System.out.println(formater.format(aujourdhui));
                Time tempo;
                tempo = result.getTime(i);
                 System.out.println("l'haure de début est : " + tempo);
                 //tempo = convertToDate(result.getString(tempo));
                 //tempo = Convert.ToString(result.getTime(i));
                 recup = tempo.toString();
                System.out.println("la valeur de reup est : " + recup);
            }*/
          /*
          if(i==4){
              //TmpDate = "15.00";
              //Timestamp MonTemps = new Timestamp(Long.parseLong(TmpDate));
               //java.util.Date d = new java.util.Date();
              // d= java.util.getTime(i);
             // datetime.time t = new datetime();
             SimpleDateFormat formate = null;
             formate = new SimpleDateFormat("h:mm a");
             System.out.println(formate.format(i));
             String rrrrecup = formate.format(getTime(i));
             System.out.println("l'ehreu est :" + rrrrecup );
                 //System.out.println(formater.format(aujourdhui));
                 System.out.println("DEUXIEME ESSAI");
                 java.util.Date aujour = new java.util.Date();
                 formate = new SimpleDateFormat("h:mm a");
                System.out.println(formate.format(i));
          }
          */
        recup = result.getObject(i).toString();
       // recup = (String) result.getObject(i);
        
       Contenant_info_Emp_Etudiant_bdd .add(recup);
        System.out.println("contenu variables : " + recup);
        }
          /*  
        System.out.println("\n---------------------------------");
        System.out.println("affichage des infos dans la liste");
       System.out.println("Boucle for");
        for(int i = 0 ; i < Contenant_info_Emp_Etudiant_bdd .size(); i++)
        {
        System.out.println("inside the boucle");
        // pour le temps utiliser ça : Time tc = convertToDate(res.getString("time"));
        }
        */
          for(String e:Contenant_info_Emp_Etudiant_bdd)
          {
              System.out.println("la valeur de l'info est : " + e);
        //System.out.println(e);
          }
        
      }
      
      
      
      result.close();
      state.close();
         
    }catch (Exception e) {
        e.printStackTrace();
      } 
    }
    
}
