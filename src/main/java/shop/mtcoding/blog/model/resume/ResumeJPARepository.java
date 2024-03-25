package shop.mtcoding.blog.model.resume;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ResumeJPARepository extends JpaRepository<Resume, Integer> {

}
