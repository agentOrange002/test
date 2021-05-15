package jim.app.test.model.request;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class FirstTestModelRequest {
	private String userId;	
	private List<String> keywords;
}
