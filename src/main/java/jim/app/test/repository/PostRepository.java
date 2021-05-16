package jim.app.test.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jim.app.test.entity.PostEntity;

@Repository
public interface PostRepository extends JpaRepository<PostEntity, Long> {
	List<PostEntity> findByUserIdOrderByIdAsc(String userId);
	List<PostEntity> findByUserId(String userId);
	
	/*
	 * List<PostEntity> findByUserIdAndTitleLikeInOrderByIdAsc(String
	 * userId,List<String> title); List<PostEntity>
	 * findByUserIdAndTitleLikeInOrderByIdDesc(String userId,List<String> title);
	 * List<PostEntity> findByTitleLikeInOrderByIdAsc(List<String> title);
	 * List<PostEntity> findByTitleLikeInOrderByIdDesc(List<String> title);
	 */
	
	List<PostEntity> findByTitleContainingOrderByIdAsc(String title);
	List<PostEntity> findByTitleContainingOrderByIdDesc(String title);
	List<PostEntity> findByUserIdAndTitleContainingOrderByIdAsc(String userId,String title);
	List<PostEntity> findByUserIdAndTitleContainingOrderByIdDesc(String userId,String title);
	
	long countByTitleIn(List<String> body);
	long countByBodyIn(List<String> body);	
}
