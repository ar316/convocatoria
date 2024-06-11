package tienda.tienda.infrastructure.dao.user;

public interface UserDao {

  void createUser(String name, String email);

  void updateUser(String name, String email);

   void deleteUser(String name);

   void getUser(String name);

   void getUsers();
}
