package cl.acabrera.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import cl.acabrera.modelDTO.BooksDTO;
import cl.acabrera.vo.BooksVO;
@Service
public class BooksServiceImpl implements BooksService {

	@Autowired
	private RestTemplate restTemplate;// se utiliza para obtener una resouesta
	
	@Override
	public BooksVO save(BooksDTO book) {
		String url="http://localhost:8081/api/books/v1";
		
		ResponseEntity<BooksVO> response = restTemplate.exchange(
				url, 										//ruta o url
				HttpMethod.POST,                 			//metodo 
				new HttpEntity<BooksDTO>(book),				//objeto o parametro necesario
				new ParameterizedTypeReference<BooksVO>() {} 	//retorno de la respuesta
				);
		return response.getBody();
		
	}

	@Override
	public BooksVO update(BooksDTO book) {
		String url="http://localhost:8081/api/books/v1";
		
		ResponseEntity<BooksVO> response = restTemplate.exchange(
				url, 										//ruta o url
				HttpMethod.PUT,                 			//metodo 
				new HttpEntity<BooksDTO>(book),				//objeto o parametro necesario
				new ParameterizedTypeReference<BooksVO>() {} 	//retorno de la respuesta
				);
		//response.getStatusCode();
		return response.getBody();
	}

	@Override
	public BooksVO delete(BooksDTO book) {
		String url="http://localhost:8081/api/books/v1";
		
		ResponseEntity<BooksVO> response = restTemplate.exchange(
				url, 										//ruta o url
				HttpMethod.DELETE,                 			//metodo 
				new HttpEntity<BooksDTO>(book),				//objeto o parametro necesario
				new ParameterizedTypeReference<BooksVO>() {} 	//retorno de la respuesta
				);
		//response.getStatusCode();
		return response.getBody();
		
	}

	@Override
	public BooksVO findAllByTitle(String titleTest) {
		String url="http://localhost:8081/api/books/v1/findAllByTitleContainingIgnoreCase/"+titleTest;
		ResponseEntity<BooksVO> response = restTemplate.exchange(
				url, //ruta o url
				HttpMethod.GET, //metodo 
				null, //objeto o parametro necesario
				new ParameterizedTypeReference<BooksVO>(){} //retorno de la respuesta
				);
		return response.getBody();	
	}

	@Override
	public BooksVO findAll() {
		ResponseEntity<BooksVO> response = restTemplate.exchange(
				"http://localhost:8081/api/books/v1/findAll", //ruta o url
				HttpMethod.GET, //metodo 
				null, //objeto o parametro necesario
				new ParameterizedTypeReference<BooksVO>(){} //retorno de la respuesta
				);
		return response.getBody();	
	}

	@Override
	public BooksVO findByIdBook(String id) {
		String url="http://localhost:8081/api/books/v1/findByIdBook/"+id;
		ResponseEntity<BooksVO> response = restTemplate.exchange(
				url, //ruta o url
				HttpMethod.GET, //metodo 
				null, //objeto o parametro necesario
				new ParameterizedTypeReference<BooksVO>(){} //retorno de la respuesta
				);
		return response.getBody();	
	}

}
