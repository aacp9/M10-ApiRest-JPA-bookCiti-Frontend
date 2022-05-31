package cl.acabrera.vo;

import java.util.List;

import cl.acabrera.modelDTO.BooksDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper=true)//valida que el objeto que se espera sea el correcto
public class BooksVO extends GenericVO {
	List<BooksDTO> books;

	//generar constructor de la superclase, queda marcada solo la segunda opción
	//además a este constructor se le agrego una lista de books
	public BooksVO(List<BooksDTO> books, String mensaje, String codigo) {
		super(mensaje, codigo);
		
		this.books=books;
	}
}
