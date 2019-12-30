package net.crunchdroid.dao;

import net.crunchdroid.model.user.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {

    AppUser findByUserName(String userName);

    @Query(value = "SELECT * FROM APP_USER  WHERE USER_NAME  not like %?1% ", nativeQuery = true)
    List<AppUser> getAllWithoutme(String username);
}
