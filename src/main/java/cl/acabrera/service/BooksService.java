package cl.acabrera.service;

import java.util.List;

import cl.acabrera.modelDTO.BooksDTO;

public interface BooksService {
	 void save(BooksDTO book);
	 void update(BooksDTO book);
	 void delete(BooksDTO book);
	 BooksDTO findByIdBook(String id);
	 List<BooksDTO> findAllByTitle(String titleTest);
	 List<BooksDTO> findAll();
}
