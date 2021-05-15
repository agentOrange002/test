package jim.app.test.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "posts")
public class PostEntity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 106604799181026088L;

	@Id
	@SequenceGenerator(name = "post_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "post_seq")
	private Long id;
	
	@Column(name="user_id",nullable = false)
	private String userId;
	
	@Column(name="title",nullable = false)
	private String title;
	
	@Column(name="body",nullable = false)
	private String body;
}
