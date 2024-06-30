package tr.ogu.edu.school.schoolapp.dto;

import lombok.Data;

@Data
public class ActSeatDto {
	private Long id;
	private String line;
	private Integer no;
	private Long hallId; // New field for hallId
	private Long categoryId; // New field for categoryId
}
