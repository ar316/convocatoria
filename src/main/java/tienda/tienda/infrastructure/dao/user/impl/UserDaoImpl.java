package tienda.tienda.infrastructure.dao.user.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import tienda.tienda.infrastructure.dao.user.UserDao;

@Repository
@RequiredArgsConstructor
public class UserDaoImpl implements UserDao {


  @Override
  public void createUser(String name, String email) {}

  @Override
  public void updateUser(String name, String email) {}

  @Override
  public void deleteUser(String name) {}

  @Override
  public void getUser(String name) {}

  @Override
  public void getUsers() {}
}
