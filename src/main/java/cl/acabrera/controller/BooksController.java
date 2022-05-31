package cl.acabrera.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cl.acabrera.modelDTO.BooksDTO;
import cl.acabrera.service.BooksService;

@Controller
public class BooksController {

	@Autowired
	private BooksService booksService;
	
	
	@GetMapping({"/","/home"})
	public ModelAndView home(@RequestParam(defaultValue="")String busqueda) {//@RequestParam cuando es un solo parámetro
		
		ModelAndView modelAndView = new ModelAndView();
	
		//usamos operador ternario si noy datos en la variable busqueda, se muestran todos
		modelAndView.addObject("books", (busqueda.isEmpty())?booksService.findAll():booksService.findAllByTitle(busqueda));
//		modelAndView.addObject("books", booksService.findAll());
		
		//System.out.println(booksService.findAll().toString());
		
		modelAndView.setViewName("home");

		return modelAndView;
	}
	
	@GetMapping("/agregarForm")
	public String agregarForm(Model model) {
		return "agregar";
	}

	
	//SAVE
	@PostMapping("/agregar")
	public ModelAndView agregar(@ModelAttribute BooksDTO book) {//@ModelAttibute cuando es un objeto
		
		ModelAndView modelAndView = new ModelAndView();
		
		booksService.save(book);

		modelAndView.addObject("books", booksService.findAll());
		
		return new ModelAndView("redirect:/home");
		
	}

	@GetMapping("/editarForm")
	public ModelAndView editarForm(@RequestParam String idBook) {
		//Integer id = (Integer.parseInt(idBook));

		ModelAndView modelAndView = new ModelAndView();
		
		
		modelAndView.addObject("books", booksService.findByIdBook(idBook));
		
		modelAndView.setViewName("editar");//redirige a la página.jsp

		return modelAndView; //realiza la acción
		
		//return new ModelAndView("editar");
		
	}


	//UPDATE
	@PostMapping("/editar")
	public ModelAndView editar(@ModelAttribute BooksDTO book) {
		
		ModelAndView modelAndView = new ModelAndView();
		
		booksService.update(book);

		modelAndView.addObject("books", booksService.findAll());
		
		return new ModelAndView("redirect:/home");
		
	}
	
	
	//DELETE
	@GetMapping("/eliminar")
	public ModelAndView eliminar(@RequestParam String idBook) {

		ModelAndView modelAndView = new ModelAndView();
		
		BooksDTO booksAEliminar=new BooksDTO();
		booksAEliminar.setIdBook(idBook);
		
		booksService.delete(booksAEliminar);

		modelAndView.addObject("books", booksService.findAll());

		//return modelAndView;
		
		return new ModelAndView("redirect:/home");
	}

	
}
