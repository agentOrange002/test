package jim.app.test.service.implementation;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import jim.app.test.dto.SearchLogDto;
import jim.app.test.entity.SearchLogEntity;
import jim.app.test.repository.SearchLogRepository;
import jim.app.test.service.SearchLogService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SearchLogServiceImplementation implements SearchLogService {	
	private SearchLogRepository searchlogRepository;

	@Override
	public List<SearchLogDto> searchTop(int top) {
		Pageable sortedByPriceDesc = 
				  PageRequest.of(0, top, Sort.by("numberoftimes").descending());
		Page<SearchLogEntity> list = searchlogRepository.findAll(sortedByPriceDesc);
		List<SearchLogDto> dtoList = new ArrayList<SearchLogDto>();
		ModelMapper mapper = new ModelMapper();
		for(SearchLogEntity entity : list) {
			dtoList.add(mapper.map(entity, SearchLogDto.class));
		}
		return dtoList;
	}

}
