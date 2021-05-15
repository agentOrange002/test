package jim.app.test.service;

import java.util.List;

import jim.app.test.dto.PostDto;
import jim.app.test.model.request.FirstTestModelRequest;
import jim.app.test.model.request.PostsModel;
import jim.app.test.model.request.SecondTestModelRequest;
import jim.app.test.model.response.CountModelResponse;

public interface PostService {

	void savePosts(PostsModel posts);

	List<PostDto> firstEndpoint(Boolean ascending,FirstTestModelRequest request);

	CountModelResponse secondEndpoint(String type, SecondTestModelRequest request);

}
