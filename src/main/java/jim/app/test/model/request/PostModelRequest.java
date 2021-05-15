package jim.app.test.model.request;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PostModelRequest {
	private Long id;
	private String userId;
	private String title;
	private String body;
}
