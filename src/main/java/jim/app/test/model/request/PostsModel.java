package jim.app.test.model.request;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PostsModel {
	private List<PostModelRequest> posts;
}
