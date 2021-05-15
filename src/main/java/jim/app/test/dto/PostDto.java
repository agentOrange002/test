package jim.app.test.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString()
@Getter @Setter
public class PostDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4076523243874617648L;
	private Long id;
	private String userId;
	private String title;
	private String body;
}
