/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;
import controleurv1.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.sql.*;
import java.lang.*;
import java.util.*;

/**
 *
 * @author arist
 */
public class InitialisationInformations {
    // TOUTES CES VARIABLES SOT UTILE POUR L'UTILISATEUR + L'ETUDIANT
    private String Email;
    private String password;
    private ArrayList<String> Contenant_info_utilisateur_bdd = new ArrayList();
    private ArrayList<String> Contenant_info_Etudiant_bdd = new ArrayList();
    private ArrayList<String> Contenant_info_Etudiant_bdd2 = new ArrayList();
    private ArrayList<String> Contenant_info_Etudiant_bdd3 = new ArrayList();
    private int ID;
    private String MotDePasse;
    private String Nom;
    private String Prenom;
    private int Droit;
    private String groupe;
    private String promotion;
    private int numero;
    private String nomTD;
    
    // TOUTES CES VARIABLES SOT UTILE POUR LE PROFESSEUR
    private ArrayList<String> Contenant_info_Etudiant_bdd4 = new ArrayList();
    private int ID_cours;
    private String cours;
    
    public InitialisationInformations(){};
    
    // utile pour l'enseignant
    public InitialisationInformations(String mail, String MDP)
    {
        Email = mail;
       password = MDP;
    }

    // utile pour Utilisateur
     public InitialisationInformations(String mail, String MDP,int ID,String Nom,String Prenom,int Droit)
    {
        Email = mail;
       password = MDP;
       this.MotDePasse = MotDePasse;
       this.ID = ID;
       this.Nom = Nom;
       this.Prenom = Prenom;
       this.Droit = Droit;
    }
    
     // utile pour Etudiant
     public InitialisationInformations(String Email,String MotDePasse,String groupe,String promotion,int numero)
     {
         this.Email = Email;
         password = MotDePasse;
         this.groupe = groupe;
         this.promotion = promotion;
         this.numero = numero;
     }
    
    //public void RechercherInfosPersonne(String Drroit){
        public void Rechercher_Infos_Utilisateur(){
        System.out.println("Zone Modèle : recherche des informations de la personne concernée");
        ResultSet result;
        try {
            System.out.println("connexion 3");
            System.out.println("3 ème façon d'afficher les données ");
      Class.forName("com.mysql.jdbc.Driver");
         
      String url = "jdbc:mysql://localhost:3306/planning";
      String user = "root";
      String passwd = "";
         
      Connection conn = DriverManager.getConnection(url, user, passwd);
         
      //Création d'un objet Statement
      Statement state = conn.createStatement();
      //L'objet ResultSet contient le résultat de la requête SQL
      
      result = state.executeQuery("SELECT * FROM Utilisateur WHERE EMail = '"+Email+"' AND PASSWD = '"+password+"' ");
      //On récupère les MetaData  
      ResultSetMetaData resultMeta = result.getMetaData();
         
      System.out.println("\n**********************************");
      //On affiche le nom des colonnes
      for(int i = 1; i <= resultMeta.getColumnCount(); i++)
        System.out.print("\t" + resultMeta.getColumnName(i).toUpperCase() + "\t *");
         
      System.out.println("\n**********************************");
         String recup;
      while(result.next()){         
        for(int i = 1; i <= resultMeta.getColumnCount(); i++)
        {
          System.out.println("zone de test 5 récupération des données des variables");
        recup = result.getObject(i).toString();
        Contenant_info_utilisateur_bdd.add(recup);
        System.out.println("contenu variables : " + recup);
        }
            
        System.out.println("\n---------------------------------");
        System.out.println("affichage des infos dans la liste");
       System.out.println("Boucle for");
        for(int i = 0 ; i < Contenant_info_utilisateur_bdd.size(); i++)
        {
         if(i==0){
             String inter = Contenant_info_utilisateur_bdd.get(i);
             int rrrresult = Integer.parseInt(inter);
             ID = rrrresult;
         }
         if(i==1){
             Email = Contenant_info_utilisateur_bdd.get(i);
         }
         if(i==2){
             MotDePasse = Contenant_info_utilisateur_bdd.get(i);
         }
         if(i==3){
             Nom = Contenant_info_utilisateur_bdd.get(i);
         }
         if(i==4){
             Prenom = Contenant_info_utilisateur_bdd.get(i);
         }
         if(i==5){
             String inter = Contenant_info_utilisateur_bdd.get(i);
             int rrrresult = Integer.parseInt(inter);
             Droit = rrrresult;
         }
        }
        System.out.println("la  vraie valeur de ID est : "+ID);
        System.out.println("la  vraie valeur de Mot de passe est : "+MotDePasse);
        System.out.println("la  vraie valeur de Email est : "+Email);
        System.out.println("la  vraie valeur de nom est : "+Nom);
        System.out.println("la  vraie valeur de Prenom est : "+Prenom);
        System.out.println("la  vraie valeur de droit est : "+Droit);
      
      }
      result.close();
      state.close();
         
        } catch (Exception e) {
          e.printStackTrace();
        }   
    }
    public int getID(){
        return ID;
    }
    public String getMotDePasse(){
        return MotDePasse;
    }
    public String getEmail(){
        return Email;
    }
    public String getNom(){
        return Nom;
    }
     public String getPrenom(){
        return Prenom;
    }
    public int getDroit(){
    return Droit;
    }
    
    // UTILE POUR L ETUDIANT UNIQUEMENT
    public int getNumero(){
        return numero;
    }
    //inutilisée
    public String getgroupe(){
        return groupe;
    }
    public String getNomTd(){
        return nomTD;
    }
    public String getPromotion(){
        return promotion;
    }
     // FIN UTILE POUR L ETUDIANT UNIQUEMENT
    
    // UTILE POUR LE PROFESSEUR UNIQUEMENT
    //inutilisée
    public int getIDCours()
    {
        return ID_cours;
    }
    public String getCours()
    {
        return cours;
    }
    
     public void Rechercher_infos_complementaire_Etudiant2()
    {
        String recup;
        System.out.println("Zone Modèle : Zone de recherche Etudiant --> récupération de de son numéro");
        ResultSet result;
        try {
            System.out.println("connexion 8");
            System.out.println("8 ème façon d'afficher les données ");
      Class.forName("com.mysql.jdbc.Driver");
         
      String url = "jdbc:mysql://localhost:3306/planning";
      String user = "root";
      String passwd = "";
      System.out.println("la valeur de Email est : "+ Email);
      Connection conn = DriverManager.getConnection(url, user, passwd);
         
      //Création d'un objet Statement
      Statement state = conn.createStatement();
      //      result = state.executeQuery("SELECT etudiant.NUMERO, etudiant.ID_groupe,etudiant.ID_Utilisateur FROM Utilisateur,Etudiant WHERE Utilisateur.EMail = '"+Email+"' AND utilisateur.PASSWD = '"+password+"' AND Utilisateur.ID = Etudiant.ID_Utilisateur");
      result = state.executeQuery("SELECT etudiant.NUMERO, etudiant.ID_groupe,etudiant.ID_Utilisateur FROM Utilisateur,Etudiant WHERE Utilisateur.EMail = '"+Email+"' AND utilisateur.PASSWD = '"+password+"' AND Utilisateur.ID = Etudiant.ID_Utilisateur");
     ResultSetMetaData resultMeta = result.getMetaData();
       System.out.println("\n**********************************");
      //On affiche le nom des colonnes
      for(int i = 1; i <= resultMeta.getColumnCount(); i++)
      {
        System.out.print("\t" + resultMeta.getColumnName(i).toUpperCase() + "\t *");
      }
      System.out.println("\n**********************************");
      
      while(result.next()){         
        for(int i = 1; i <= resultMeta.getColumnCount(); i++)
        {
          System.out.println("zone de test 5 récupération des données des variables");
        recup = result.getObject(i).toString();
        Contenant_info_Etudiant_bdd.add(recup);
        System.out.println("contenu variables : " + recup);
        }
            
        System.out.println("\n---------------------------------");
        System.out.println("affichage des infos dans la liste");
       System.out.println("Boucle for");
        for(int i = 0 ; i < Contenant_info_Etudiant_bdd.size(); i++)
        {
         if(i==0){
              String inter = Contenant_info_Etudiant_bdd.get(i);
             int rrrresult = Integer.parseInt(inter);
             numero  = rrrresult; 
          }
          if(i==1){
              groupe = Contenant_info_Etudiant_bdd.get(i);
          }
        }
        /*System.out.println("\n");
        System.out.println("le numéro de l'étudiant est : "+numero);
        System.out.println("le groupe de l'étudiant est : "+groupe);
        System.out.println("\n");*/
      }
      System.out.println("Zone Modèle : Zone de recherche Etudiant --> récupération de de son groupe");
      Statement state2 = conn.createStatement();
      result = state2.executeQuery("SELECT groupe.ID, groupe.Nom, groupe.ID_Promotion FROM Groupe,Etudiant WHERE  Etudiant.numero = '"+numero+"' AND Groupe.ID = Etudiant.ID_Groupe");
     ResultSetMetaData resultMeta2 = result.getMetaData();
     System.out.println("\n**********************************");
      for(int i = 1; i <= resultMeta2.getColumnCount(); i++)
      {
        System.out.print("\t" + resultMeta2.getColumnName(i).toUpperCase() + "\t *");
      }
      System.out.println("\n**********************************");
      while(result.next()){         
        for(int i = 1; i <= resultMeta.getColumnCount(); i++)
        {
          System.out.println("zone de test 8 récupération des données des variables");
        recup = result.getObject(i).toString();
        Contenant_info_Etudiant_bdd2.add(recup);
        System.out.println("contenu variables : " + recup);
        }
            
        System.out.println("\n---------------------------------");
        System.out.println("affichage des infos dans la liste");
       System.out.println("Boucle for");
        for(int i = 0 ; i < Contenant_info_Etudiant_bdd2.size(); i++)
        {
          if(i==1){
              nomTD = Contenant_info_Etudiant_bdd2.get(i);
          }
        }
      }
      System.out.println("Zone Modèle : Zone de recherche Etudiant --> récupération de de sa promotion");
      state2 = conn.createStatement();
      result = state2.executeQuery("SELECT promotion.ID, promotion.nom FROM Groupe,promotion,etudiant WHERE Etudiant.numero = '"+numero+"' AND Etudiant.ID_Groupe = Groupe.ID AND Groupe.ID_Promotion = promotion.ID");
        resultMeta2 = result.getMetaData();
        System.out.println("\n**********************************");
        for(int i = 1; i <= resultMeta2.getColumnCount(); i++)
      {
        System.out.print("\t" + resultMeta2.getColumnName(i).toUpperCase() + "\t *");
      }
        System.out.println("\n**********************************");
        String recup3;
        while(result.next()){         
        for(int i = 1; i <= resultMeta2.getColumnCount(); i++)
        {
          System.out.println("zone de test 8 récupération des données des variables");
        recup3 = result.getObject(i).toString();
        Contenant_info_Etudiant_bdd3.add(recup3);
        System.out.println("contenu variables : " + recup3);
        }
            
        System.out.println("\n---------------------------------");
        System.out.println("affichage des infos dans la liste");
       System.out.println("Boucle for");
        for(int i = 0 ; i < Contenant_info_Etudiant_bdd3.size(); i++)
        {
          if(i==1){
             promotion = Contenant_info_Etudiant_bdd3.get(i);
          }
        }
      }
        }catch (Exception e) {
        e.printStackTrace();
      } 
        System.out.println("\n");
        System.out.println("le numéro de l'étudiant est : "+numero);
        System.out.println("le groupe de l'étudiant est : "+groupe);
        System.out.println("le TD de l'étudiant est : "+nomTD);
        System.out.println("la promotion de l'étudiant est : "+promotion);
        System.out.println("\n");
        
        //System.out.println("Zone Modèle : Zone de recherche Etudiant --> récupération de de son groupe");
    }
     public void Rechercher_infos_Enseignant()
     {
         String recup;
        System.out.println("Zone Modèle : Zone de recherche Enseignant --> récupération de de sa matière enseignée");
        ResultSet result;
        try {
            System.out.println("connexion 9");
            System.out.println("9 ème façon d'afficher les données ");
        Class.forName("com.mysql.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3306/planning";
        String user = "root";
        String passwd = "";
        //System.out.println("la valeur de Email est : "+ Email);
        Connection conn = DriverManager.getConnection(url, user, passwd);

        //Création d'un objet Statement
        Statement state = conn.createStatement();
        //      result = state.executeQuery("SELECT etudiant.NUMERO, etudiant.ID_groupe,etudiant.ID_Utilisateur FROM Utilisateur,Etudiant WHERE Utilisateur.EMail = '"+Email+"' AND utilisateur.PASSWD = '"+password+"' AND Utilisateur.ID = Etudiant.ID_Utilisateur");
        result = state.executeQuery("SELECT Cours.ID,Cours.Nom FROM Utilisateur,Enseignant,Cours WHERE Utilisateur.ID = Enseignant.ID_Utilisateur AND Enseignant.ID_Cours = Cours.ID ");//AND Utilisateur.EMail = '"+Email+"'
       ResultSetMetaData resultMeta = result.getMetaData();
          
      System.out.println("\n**********************************");
      //On affiche le nom des colonnes
      for(int i = 1; i <= resultMeta.getColumnCount(); i++)
        System.out.print("\t" + resultMeta.getColumnName(i).toUpperCase() + "\t *");
         
      System.out.println("\n**********************************");
      while(result.next()){         
        for(int i = 1; i <= resultMeta.getColumnCount(); i++)
        {
          System.out.println("zone de test 5 récupération des données des variables");
        recup = result.getObject(i).toString();
        Contenant_info_Etudiant_bdd4.add(recup);
        System.out.println("contenu variables : " + recup);
        }
            
        System.out.println("\n---------------------------------");
        System.out.println("affichage des infos dans la liste");
        for(int i = 0 ; i < Contenant_info_Etudiant_bdd4.size(); i++)
        {
         if(i==0){
              String inter = Contenant_info_Etudiant_bdd4.get(i);
             int rrrresult = Integer.parseInt(inter);
             ID_cours  = rrrresult; 
          }
          if(i==1){
              cours = Contenant_info_Etudiant_bdd4.get(i);
          }
        }
      }
       
        }catch (Exception e) {
        e.printStackTrace();
      } 
        System.out.println("\n");
        System.out.println("l'id du cours du professeur est : "+ID_cours);
        System.out.println("le cours du professeur est : "+cours);
        //System.out.println("\n");
     }
    
}
