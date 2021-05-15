package jim.app.test.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jim.app.test.entity.PostEntity;

@Repository
public interface PostRepository extends JpaRepository<PostEntity, Long> {
	List<PostEntity> findByUserIdOrderByIdAsc(String userId);
	List<PostEntity> findByUserId(String userId);
	List<PostEntity> findByUserIdAndTitleInOrderByIdAsc(String userId,List<String> title);
	List<PostEntity> findByUserIdAndTitleInOrderByIdDesc(String userId,List<String> title);
	List<PostEntity> findByTitleInOrderByIdAsc(List<String> title);
	List<PostEntity> findByTitleInOrderByIdDesc(List<String> title);
	long countByTitleIn(List<String> body);
	long countByBodyIn(List<String> body);
}
