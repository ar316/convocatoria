package tienda.tienda.aplication.service.user;

public interface UserService {

  public void createUser(String name, String email);

  public void updateUser(String name, String email);

  public void deleteUser(String name);

  public void getUser(String name);

  public void getUsers();
}
