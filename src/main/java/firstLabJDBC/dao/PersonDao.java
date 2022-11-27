package firstLabJDBC.dao;

import firstLabJDBC.model.Person;
import firstLabJDBC.utils.ConnectionAgent;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDao {


    private Connection openConnection() throws SQLException {
        return ConnectionAgent.getNewConnection();
    }


    public List<Person> findAll()  {
        List<Person> personList = new ArrayList<>();

        try {
            Statement statement = openConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("select * from person");

            while (resultSet.next()) {

                Person person = new Person();
                person.setId(resultSet.getInt("id"));
                person.setName(resultSet.getString("name"));
                person.setAge(resultSet.getInt("age"));

                personList.add(person);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return personList;
    }


    public Person findById(int id) {
        Person person;
        try {
            PreparedStatement preparedStatement = openConnection().prepareStatement("select * from person where id =?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();

            person = new Person();
            person.setId(resultSet.getInt("id"));
            person.setName(resultSet.getString("name"));
            person.setAge(resultSet.getInt("age"));

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return person;
    }


    public Person findByName(String name) {
        Person person;
        try {
            PreparedStatement preparedStatement = openConnection().prepareStatement("select * from person where name =?");
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();

            person = new Person();
            person.setId(resultSet.getInt("id"));
            person.setName(resultSet.getString("name"));
            person.setAge(resultSet.getInt("age"));

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return person;
    }

}
