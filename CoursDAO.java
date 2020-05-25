import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class CoursDAO extends DAO<Cours> {
  public CoursDAO(Connection conn) {
    super(conn);
  }

  public boolean create(Cours obj) {
    return false;
  }

  public boolean delete(Cours obj) {
    return false;
  }

  public boolean update(Cours obj) {
    return false;
  }

  public Cours find(int id) {
    Cours matiere = new Cours();  

    try {
      ResultSet result = this.connect.createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE, 
        ResultSet.CONCUR_READ_ONLY
      ).executeQuery("SELECT * FROM matiere WHERE mat_id = " + id);
        if(result.first())
          matiere = new Cours(id, result.getString("mat_nom"));         
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return matiere;
  }
}
