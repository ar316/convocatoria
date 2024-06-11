package tienda.tienda.aplication.service.user.impl;

import org.springframework.transaction.annotation.Transactional;
import tienda.tienda.aplication.service.user.UserService;

public class UserSeviceImpl implements UserService {


  @Override
  @Transactional
  public void createUser(String name, String email) {}

  @Override
  @Transactional
  public void updateUser(String name, String email) {}

  @Override
  @Transactional
  public void deleteUser(String name) {}

  @Override
  public void getUser(String name) {}

  @Override
  public void getUsers() {}
}
