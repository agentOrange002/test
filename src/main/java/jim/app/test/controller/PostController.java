package jim.app.test.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jim.app.test.dto.PostDto;
import jim.app.test.dto.SearchLogDto;
import jim.app.test.model.request.FirstTestModelRequest;
import jim.app.test.model.request.PostsModel;
import jim.app.test.model.request.SecondTestModelRequest;
import jim.app.test.model.response.CountModelResponse;
import jim.app.test.model.response.PostModelResponse;
import jim.app.test.model.response.SearchLogModelResponse;
import jim.app.test.service.PostService;
import jim.app.test.service.SearchLogService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping({ "/posts" })
public class PostController {
	
	private PostService postService;
	private SearchLogService searchlogService;
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public String savePosts(@RequestBody PostsModel posts) {
		postService.savePosts(posts);
		return "DONE!";
	}
	
	/*----------First Test EndPoint-------------*/
	@GetMapping(path="/first",produces = MediaType.APPLICATION_JSON_VALUE)	
	public List<PostModelResponse> firstTest(@RequestParam Optional<Boolean> ascending,@RequestBody FirstTestModelRequest request ) {		
		Boolean asc = false;
		if(ascending.isPresent()) {
			asc = ascending.get();
		}
		List<PostDto> dtoList = postService.firstEndpoint(asc,request);
		List<PostModelResponse> response = new ArrayList<PostModelResponse>();
		ModelMapper mapper = new ModelMapper();
		for(PostDto dto: dtoList) {
			response.add(mapper.map(dto, PostModelResponse.class));
		}
		return response;
	}
	
	/*----------Second Test EndPoint-------------*/
	@GetMapping(path="/second",produces = MediaType.APPLICATION_JSON_VALUE)	
	public CountModelResponse secondTest(@RequestParam String type,@RequestBody SecondTestModelRequest request){
		return postService.secondEndpoint(type,request);
	}
	
	/*----------Third Test EndPoint-------------*/
	@GetMapping(path="/third",produces = MediaType.APPLICATION_JSON_VALUE)	
	public List<SearchLogModelResponse> thirdTest(@RequestParam int top) {	
		List<SearchLogDto> dtoList = searchlogService.searchTop(top);
		List<SearchLogModelResponse> response = new ArrayList<SearchLogModelResponse>();
		ModelMapper mapper = new ModelMapper();
		for(SearchLogDto dto: dtoList) {
			response.add(mapper.map(dto, SearchLogModelResponse.class));
		}
		return response;
	}
	
}
