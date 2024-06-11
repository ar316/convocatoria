package tienda.tienda.infrastructure.dao.user;

import org.springframework.data.jpa.repository.JpaRepository;
import tienda.tienda.domain.model.User;

public interface UserRepository extends JpaRepository<User, Long> {}
