package kg.megacom.students.repositories;

import kg.megacom.students.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "update students set title = ?2 where id = ?1", nativeQuery = true)
    void update(@Param("id") Long id, @Param("title") String title);

//    @Query(value = "select * from students where is_deleted = false ", nativeQuery = true)
    List<Student> findAllByIsDeletedIsFalse();

}
