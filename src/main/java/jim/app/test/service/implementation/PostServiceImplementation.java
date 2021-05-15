package jim.app.test.service.implementation;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import jim.app.test.dto.PostDto;
import jim.app.test.entity.PostEntity;
import jim.app.test.model.request.FirstTestModelRequest;
import jim.app.test.model.request.PostModelRequest;
import jim.app.test.model.request.PostsModel;
import jim.app.test.model.request.SecondTestModelRequest;
import jim.app.test.model.response.CountModelResponse;
import jim.app.test.repository.PostRepository;
import jim.app.test.service.PostService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PostServiceImplementation implements PostService {
	
	private PostRepository postRepository;
	
	@Override	
	public void savePosts(PostsModel posts) {
		for(PostModelRequest post: posts.getPosts()) {
			PostEntity entity = new PostEntity();
			entity.setUserId(post.getUserId());
			entity.setTitle(post.getTitle());
			entity.setBody(post.getBody());
			postRepository.save(entity);			
		}		
	}

	@Override
	public List<PostDto> firstEndpoint(Boolean ascending,FirstTestModelRequest request) {
		List<PostEntity> posts = new ArrayList<PostEntity>();
		if(request.getUserId()==null|request.getUserId()==""|request.getUserId().equals(null)|"".compareTo(request.getUserId()) == 0) {
			if(ascending) {
				posts = postRepository.findByTitleInOrderByIdAsc(request.getKeywords());
			}
			else {
				posts = postRepository.findByTitleInOrderByIdDesc(request.getKeywords());
			}
		}
		else {
			if(ascending) {
				posts = postRepository.findByUserIdAndTitleInOrderByIdAsc(request.getUserId(),request.getKeywords());
			}
			else {
				posts = postRepository.findByUserIdAndTitleInOrderByIdDesc(request.getUserId(),request.getKeywords());
			}
		}	
		
		ModelMapper mapper = new ModelMapper();
		List<PostDto> dtoList = new ArrayList<PostDto>();
		for(PostEntity post: posts) {
			dtoList.add(mapper.map(post, PostDto.class));
		}
		return dtoList;
	}

	@Override
	public CountModelResponse secondEndpoint(String type, SecondTestModelRequest request) {
		long count = 0;
		if(type.equals("title")) {
			count = postRepository.countByTitleIn(request.getKeywords());
		}
		else {
			count = postRepository.countByBodyIn(request.getKeywords());
		}
		CountModelResponse response = new CountModelResponse();
		response.setType(type);
		response.setCount(count);		
		return response;
	}

}
