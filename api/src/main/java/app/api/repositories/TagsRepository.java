package app.api.repositories;

import app.api.models.Tags;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TagsRepository extends JpaRepository<Tags, Integer> {
}
