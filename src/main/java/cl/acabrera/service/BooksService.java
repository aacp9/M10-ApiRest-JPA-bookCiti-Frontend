package cl.acabrera.service;

import cl.acabrera.modelDTO.BooksDTO;
import cl.acabrera.vo.BooksVO;

public interface BooksService {
	public BooksVO save(BooksDTO book);
	public BooksVO update(BooksDTO book);
	public BooksVO delete(BooksDTO book);
	public BooksVO findAllByTitle(String titleTest);
	public BooksVO findAll();
	public BooksVO findByIdBook(String id);
}
