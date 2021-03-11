package bg.softuni.musicdb.repository;

import bg.softuni.musicdb.model.entity.UserRoleEntity;
import bg.softuni.musicdb.model.entity.enums.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRoleEntity, Long> {

   Optional<UserRoleEntity> findByRole(UserRole role);
}
