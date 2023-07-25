package dev.clement.wine.repository;

import dev.clement.wine.entity.Client;
import dev.clement.wine.entity.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

}
