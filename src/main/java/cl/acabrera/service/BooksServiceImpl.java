package cl.acabrera.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import cl.acabrera.modelDTO.BooksDTO;
@Service
public class BooksServiceImpl implements BooksService {

	@Autowired
	private RestTemplate restTemplate;// se utiliza para obtener una resouesta
	
	@Override
	public void save(BooksDTO book) {
		String url="http://localhost:8081/api/books/v1";
		
		ResponseEntity<Void> response = restTemplate.exchange(
				url, 										//ruta o url
				HttpMethod.POST,                 			//metodo 
				new HttpEntity<BooksDTO>(book),				//objeto o parametro necesario
				new ParameterizedTypeReference<Void>() {} 	//retorno de la respuesta
				);
		response.getStatusCode();
		
	}

	@Override
	public void update(BooksDTO book) {
		String url="http://localhost:8081/api/books/v1";
		
		ResponseEntity<Void> response = restTemplate.exchange(
				url, 										//ruta o url
				HttpMethod.PUT,                 			//metodo 
				new HttpEntity<BooksDTO>(book),				//objeto o parametro necesario
				new ParameterizedTypeReference<Void>() {} 	//retorno de la respuesta
				);
		response.getStatusCode();
		
	}

	@Override
	public void delete(BooksDTO book) {
		String url="http://localhost:8081/api/books/v1";
		
		ResponseEntity<Void> response = restTemplate.exchange(
				url, 										//ruta o url
				HttpMethod.DELETE,                 			//metodo 
				new HttpEntity<BooksDTO>(book),				//objeto o parametro necesario
				new ParameterizedTypeReference<Void>() {} 	//retorno de la respuesta
				);
		response.getStatusCode();
		
		
	}

	@Override
	public List<BooksDTO> findAllByTitle(String titleTest) {
		String url="http://localhost:8081/api/books/v1/findAllByTitleContainingIgnoreCase/"+titleTest;
		ResponseEntity<List<BooksDTO>> response = restTemplate.exchange(
				url, //ruta o url
				HttpMethod.GET, //metodo 
				null, //objeto o parametro necesario
				new ParameterizedTypeReference<List<BooksDTO>>(){} //retorno de la respuesta
				);
		return response.getBody();	
	}

	@Override
	public List<BooksDTO> findAll() {
		ResponseEntity<List<BooksDTO>> response = restTemplate.exchange(
				"http://localhost:8081/api/books/v1/findAll", //ruta o url
				HttpMethod.GET, //metodo 
				null, //objeto o parametro necesario
				new ParameterizedTypeReference<List<BooksDTO>>(){} //retorno de la respuesta
				);
		return response.getBody();	
	}

	@Override
	public BooksDTO findByIdBook(String id) {
		String url="http://localhost:8081/api/books/v1/findByIdBook/"+id;
		ResponseEntity<BooksDTO> response = restTemplate.exchange(
				url, //ruta o url
				HttpMethod.GET, //metodo 
				null, //objeto o parametro necesario
				new ParameterizedTypeReference<BooksDTO>(){} //retorno de la respuesta
				);
		return response.getBody();	
	}

}
