

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

//CTRL + SHIFT + O pour générer les imports
public class EnseignantDAO extends DAO<Enseignant> {
  public EnseignantDAO(Connection conn) {
    super(conn);
  }

  public boolean create(Enseignant obj) {
    return false;
  }

  public boolean delete(Enseignant obj) {
    return false;
  }

  public boolean update(Enseignant obj) {
    return false;
  }
   
  public Enseignant find(int id) {
	  Enseignant professeur = new Enseignant();            
    try {
      ResultSet result = this.connect.createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE, 
        ResultSet.CONCUR_READ_ONLY
      ).executeQuery(
        "SELECT * FROM professeur "+
        "LEFT JOIN j_mat_prof ON jmp_prof_k = prof_id " + 
        "AND prof_id = "+ id +
        " INNER JOIN matiere ON jmp_mat_k = mat_id"
      );
      if(result.first()){
        professeur = new Enseignant(id, result.getString("prof_nom"), result.getString("prof_prenom"));
        result.beforeFirst();
        CoursDAO matDao = new CoursDAO((Connection) this.connect);
            
        while(result.next())
          professeur.addMatiere(matDao.find(result.getInt("mat_id")));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return professeur;
  }
}
