package jim.app.test.service;

import java.util.List;

import jim.app.test.dto.SearchLogDto;

public interface SearchLogService {
	List<SearchLogDto> searchTop(int top);
}
