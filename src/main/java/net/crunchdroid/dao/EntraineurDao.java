package net.crunchdroid.dao;

import net.crunchdroid.model.Entraineur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntraineurDao extends JpaRepository<Entraineur, Long> {
}
