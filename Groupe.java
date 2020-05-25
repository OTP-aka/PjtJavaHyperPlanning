import java.util.HashSet;
import java.util.Set;

public class Groupe {
  //ID
  private int id = 0;
  //Nom du professeur
  private String nom = "";
  //Liste des professeurs
  private Set<Enseignant> listProfesseur = new HashSet<Enseignant>();
  //Liste des élèves
  private Set<Eleve> listEleve = new HashSet<Eleve>();

  public Groupe(int id, String nom) {
    this.id = id;
    this.nom = nom;
  }
  public Groupe(){}

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public Set<Enseignant> getListProfesseur() {
    return listProfesseur;
  }

  public void setListProfesseur(Set<Enseignant> listProfesseur) {
    this.listProfesseur = listProfesseur;
  }

  public void addProfesseur(Enseignant prof) {
    if(!listProfesseur.contains(prof))
      listProfesseur.add(prof);
  }

  public void removeProfesseur(Enseignant prof ) {
    this.listProfesseur.remove(prof);
  }

  public Set<Eleve> getListEleve() {
    return listEleve;
  }

  public void setListEleve(Set<Eleve> listEleve) {
    this.listEleve = listEleve;
  }

  //Ajoute un élève à la classe
  public void addEleve(Eleve eleve){
    if(!this.listEleve.contains(eleve))
      this.listEleve.add(eleve);
  }

  //Retire un élève de la classe
  public void removeEleve(Eleve eleve){
    this.listEleve.remove(eleve);
  }

  public boolean equals(Groupe cls){
    return this.getId() == cls.getId();
  }   
}
