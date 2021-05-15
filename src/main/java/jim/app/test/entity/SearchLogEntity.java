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
@Table(name = "searchlogs")
public class SearchLogEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3795414669443792628L;

	@Id
	@SequenceGenerator(name = "searchlog_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "searchlog_seq")
	private Long id;
	
	@Column(name="keyword",nullable = false)
	private String keyword;
	
	@Column(name="numberoftimes")
	private long numberoftimes;
}
