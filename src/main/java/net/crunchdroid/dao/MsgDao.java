package net.crunchdroid.dao;

import net.crunchdroid.model.Msg;
import net.crunchdroid.model.user.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MsgDao extends JpaRepository<Msg, Long> {
    List<Msg> findAllByDestination(AppUser destination);

    List<Msg> findAllBySource(AppUser destination);
}
