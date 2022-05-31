package cl.acabrera.modelDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BooksDTO {
	private String idBook;
	private String title;
	private String author;
	private String location;


}
