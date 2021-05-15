package jim.app.test.model.response;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PostModelResponse {
	private Long id;
	private String userId;
	private String title;
	private String body;
}
