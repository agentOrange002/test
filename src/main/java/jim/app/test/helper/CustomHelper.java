package jim.app.test.helper;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import jim.app.test.entity.SearchLogEntity;
import jim.app.test.repository.SearchLogRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class CustomHelper {

	private SearchLogRepository searchlogRepository;
	
	@Transactional
	public void addupdateSearchLog(List<String> list) {
		for(String word: list) {
			checkKeyword(word);
		}
	}
	
	@Transactional
	public void checkKeyword(String word) {
		SearchLogEntity entity = searchlogRepository.findByKeyword(word);
		if(entity==null) {
			SearchLogEntity logentity = new SearchLogEntity();
			logentity.setKeyword(word);
			logentity.setNumberoftimes(1);
			searchlogRepository.save(logentity);
		}
		else {
			long count = entity.getNumberoftimes();			
			entity.setNumberoftimes(count+1);
			searchlogRepository.save(entity);
		}
	}
}
