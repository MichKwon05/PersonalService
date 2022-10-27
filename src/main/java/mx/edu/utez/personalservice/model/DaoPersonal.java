package mx.edu.utez.personalservice.model;

import mx.edu.utez.personalservice.utils.MySQL;
import mx.edu.utez.personalservice.utils.Response;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoPersonal implements Repository{
     Connection conn;
    PreparedStatement ps;
    ResultSet rs;
    MySQL mysql = new MySQL();

    @Override
    public List<BeanPersonal> findAll() {
        List<BeanPersonal> personal = new ArrayList<>();
        BeanPersonal person = null;
        BeanPosition position = null;
        try {
            conn = mysql.getConnection();
            String query = "SELECT pe.*, po.description FROM personal pe"+
                    "JOIN position po ON pe.position_id = po.id;";
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();

            ///lo que esta en la bd
            while(rs.next()){
                person = new BeanPersonal();
                position = new BeanPosition();
                person.setId(rs.getLong("id"));
                person.setName(rs.getString("name"));
                person.setSurname(rs.getString("lastname"));
                person.setBirthday(rs.getString("birthday"));
                position.setPosition(rs.getString("position"));
                position.setDescription(rs.getString("description"));

            }


        }catch (SQLException e){
            Logger.getLogger(DaoPersonal.class.getName())
                    .log(Level.SEVERE, "Error -> findAll"+ e.getMessage());
        }finally {
            mysql.close(conn, ps, rs);
        }
        return null;
    }

    @Override
    public Response findById(Long id) {
        return null;
    }

    @Override
    public Response save(Object object) {
        Response<BeanPersonal> response= new Response<>();
        try {
            conn = mysql.getConnection();
            String query = "INSERT INTO personal (name, surname, lastname"+
                    "birthday, salary, position_id) VALUES (?,?,?,?,?,?)";
            ps = conn.prepareStatement(query);
            ps.setString(1, object.getName());
        }catch (SQLException e){
            Logger.getLogger(DaoPersonal.class.getName())
                    .log(Level.SEVERE, "Error -> findAll"+ e.getMessage());
        }finally {
            mysql.close(conn, ps, rs);
        }
        return null;
    }

    @Override
    public Response update(Object object) {
        return null;
    }

    @Override
    public Response save(BeanPersonal object) {
        return null;
    }

    @Override
    public Response update(BeanPersonal object) {
        return null;
    }

    @Override
    public Response delete(Long id) {
        return null;
    }

}
