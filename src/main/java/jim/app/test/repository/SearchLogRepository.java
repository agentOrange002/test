package jim.app.test.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import jim.app.test.entity.SearchLogEntity;

@Repository
public interface SearchLogRepository extends PagingAndSortingRepository<SearchLogEntity, Long> {
	SearchLogEntity findByKeyword(String keyword);
	
}
