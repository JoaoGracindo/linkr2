package app.api.repositories;

import app.api.models.Follows;
import org.springframework.data.jpa.repository.JpaRepository;


public interface FollowsRepository extends JpaRepository<Follows, Integer> {
}
