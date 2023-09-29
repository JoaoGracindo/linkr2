package app.api.repositories;

import app.api.models.Comments;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CommentsRepository extends JpaRepository<Comments, Integer> {
}
