package jim.app.test.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString()
@Getter @Setter
public class SearchLogDto {
	private Long id;	
	private String keyword;	
	private long numberoftimes;
}
