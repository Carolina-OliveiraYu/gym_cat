package br.com.ibm.feminisbackend.repository;

import br.com.ibm.feminisbackend.entity.AuthenticateUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;



@Repository
public interface AuthenticateUserRepository extends JpaRepository<AuthenticateUser, Long> {

    @Query(value = "SELECT * FROM authenticate_user a WHERE a.username =:username AND a.password =:password", nativeQuery = true)
    AuthenticateUser getAuthenticateUser(@Param("username") String username, @Param("password") String password);
}
