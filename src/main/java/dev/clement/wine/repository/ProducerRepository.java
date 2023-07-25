package dev.clement.wine.repository;

import dev.clement.wine.entity.Site;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProducerRepository extends JpaRepository<Site, Integer> {

}
