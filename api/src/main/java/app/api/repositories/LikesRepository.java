package app.api.repositories;

import app.api.models.Likes;
import org.springframework.data.jpa.repository.JpaRepository;


public interface LikesRepository extends JpaRepository<Likes, Integer> {
}
