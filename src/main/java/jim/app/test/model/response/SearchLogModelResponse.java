package jim.app.test.model.response;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class SearchLogModelResponse {
	private Long id;
	private String keyword;
	private long numberoftimes;
}
