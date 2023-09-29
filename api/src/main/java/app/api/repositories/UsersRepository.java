package app.api.repositories;

import app.api.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsersRepository extends JpaRepository<Users, Integer> {
    UserDetails findByEmail(String email);
}
