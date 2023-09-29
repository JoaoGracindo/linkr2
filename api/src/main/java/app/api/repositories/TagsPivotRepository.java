package app.api.repositories;

import app.api.models.TagsPivot;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TagsPivotRepository extends JpaRepository<TagsPivot, Integer> {
}
