import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

//CTRL + SHIFT + O pour générer les imports
public class GroupeDAO extends DAO<Groupe> {
  public GroupeDAO(Connection conn) {
    super(conn);
  }

  public boolean create(Groupe obj) {
    return false;
  }

  public boolean delete(Groupe obj) {
    return false;
  }
   
  public boolean update(Groupe obj) {
    return false;
  }

  public Groupe find(int id) {
	  Groupe classe = new Groupe();            
    try {
      ResultSet result = this.connect.createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE, 
        ResultSet.CONCUR_READ_ONLY
      ).executeQuery("SELECT * FROM classe WHERE cls_id = " + id); 

      if(result.first()){
        classe = new Groupe(id, result.getString("cls_nom"));

        result = this.connect.createStatement().executeQuery(
          "SELECT prof_id, prof_nom, prof_prenom from professeur " +
          "INNER JOIN j_mat_prof ON prof_id = jmp_prof_k " +
          "INNER JOIN j_cls_jmp ON jmp_id = jcm_jmp_k AND jcm_cls_k = " + id
        );

        EnseignantDAO profDao = new EnseignantDAO((Connection) this.connect);

        while(result.next())             
          classe.addProfesseur(profDao.find(result.getInt("prof_id")));

        EleveDAO eleveDao = new EleveDAO((Connection) this.connect);
        result = this.connect.createStatement().executeQuery(
          "SELECT elv_id, elv_nom, elv_prenom FROM eleve " +
          "INNER JOIN classe ON elv_cls_k = cls_id AND cls_id = " + id
        );

        while(result.next())
          classe.addEleve(eleveDao.find(result.getInt("elv_id")));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return classe;
  }
}