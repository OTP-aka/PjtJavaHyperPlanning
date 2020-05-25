
import java.sql.*;
/**
 *
 * @author Said
 */
public class main {
 static Connection cnx;
 static Statement st;
 static ResultSet rst;
  
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
    
        
                
          try{
              cnx=connecterDB(); 
              st=cnx.createStatement();
              rst=st.executeQuery("SELECT * FROM Cours");
              
              while(rst.next()){
                  System.out.print(rst.getInt("ID")+"\t");
                  System.out.print(rst.getString("NOM")+"\t");
                  System.out.println();
              }
          }catch(Exception ex){
              ex.printStackTrace();
          } 
     
    }   
    
    
  
    
    public static Connection  connecterDB(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver oki");
            String url="jdbc:mysql://localhost:8889/planning";
            String user="root";
            String password="ijNpkx38YxocpDMn";
           Connection cnx=DriverManager.getConnection(url,user,password);
            System.out.println("Connexion bien établie");
            return cnx;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
   
    /*public static void AjouterP(int id,String libelle,double prix,int quantite,String categorie,int id_f){
        try{
            String query="INSERT INTO tb_produit VALUES("+id+",'"+libelle+"',"+prix+","+quantite+",'"+categorie+"',"+id_f+")";
            cnx=connecterDB();
            st=cnx.createStatement();
            st.executeUpdate(query);
            System.out.println("Produit bine ajouté");
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        
        
    }
    */
   
   /* public static void SupprimerParID(int id){
        try{
           String query="DELETE FROM tb_produit WHERE id="+id; 
           cnx=connecterDB();
           st=cnx.createStatement();
           st.executeUpdate(query);
           System.out.println("Produit bien supprimé");
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    */
   
    public static void recherchePparLibelle(String Nom){
        try{
           String query="SELECT * FROM Enseignant WHERE libelle='"+Nom+"'"; 
           cnx=connecterDB();
           st=cnx.createStatement();
           rst= st.executeQuery(query);
           rst.last();
           int nbrRow = rst.getRow();
           if(nbrRow!=0){
               System.out.println("Produit trouve");
           }else{
                System.out.println("Produit non trouve");
               
           }
           
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        
    }
    
   /*public static void ModifierP(int id,String n_libelle,double n_prix,int n_qnt,String n_cat,int n_f ){
       try{
           String query="UPDATE tb_produit SET libelle='"+n_libelle
                   +"', prix="+n_prix
                   +", quantite="+n_qnt
                   +", cat='"+n_cat
                   +"', id_f="+n_f
                   +" WHERE id="+id;
           cnx=connecterDB();
           st=cnx.createStatement();
           st.executeUpdate(query);
           System.out.println("Produit bien modifié");
           
       }catch(SQLException e){
           System.out.println(e.getMessage());
       }
       */
       
       
   }
