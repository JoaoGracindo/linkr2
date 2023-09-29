package app.api.repositories;

import app.api.models.Reposts;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RepostsRepository extends JpaRepository<Reposts, Integer> {
}
