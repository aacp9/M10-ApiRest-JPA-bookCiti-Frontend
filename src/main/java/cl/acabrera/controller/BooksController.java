package cl.acabrera.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cl.acabrera.modelDTO.BooksDTO;
import cl.acabrera.service.BooksService;
import cl.acabrera.vo.BooksVO;

@Controller
public class BooksController {

	private static final Logger log = LoggerFactory.getLogger(BooksDTO.class);

	
	@Autowired
	private BooksService booksService;
	
	
	@GetMapping({"/","/home"})
	public ModelAndView home(@RequestParam(defaultValue="")String busqueda) {//@RequestParam cuando es un solo parámetro
		
		ModelAndView modelAndView = new ModelAndView();
	
		//usamos operador ternario si noy datos en la variable busqueda, se muestran todos
		modelAndView.addObject("VO", (busqueda.isEmpty())?booksService.findAll():booksService.findAllByTitle(busqueda));
		
		modelAndView.setViewName("home");//redirigimos al home.jsp

		return modelAndView;
	}
	
	@GetMapping("/agregarForm")
	public String agregarForm(Model model) {
		return "agregar"; //redirimos al /agregar del controlador
	}

	
	//SAVE
	@PostMapping("/agregar")
	public ModelAndView agregar(@ModelAttribute BooksDTO book, RedirectAttributes ra) {//@ModelAttibute cuando es un objeto
		
		BooksVO respuestaServicio = booksService.save(book);
		ra.addFlashAttribute("mensaje",respuestaServicio.getMensaje());

		if (respuestaServicio.getCodigo().equals("0")) {
			return new ModelAndView("redirect:/home");
		} else {
			return new ModelAndView("redirect:/agregarForm");
		}
	}

	@GetMapping("/editarForm")
	public ModelAndView editarForm(Model model,@RequestParam String idBook, RedirectAttributes ra) {
		//Integer id = (Integer.parseInt(idBook));

		BooksVO respuestaServicio = new BooksVO();
		respuestaServicio.setMensaje("No se pudo cargar la vista de edición, intente nuevamente.");
		try {
			respuestaServicio=booksService.findByIdBook(idBook);
			model.addAttribute("mensaje", respuestaServicio.getMensaje());
			model.addAttribute("VO", respuestaServicio.getBooks().get(0));
			return new ModelAndView("editar");
		} catch (Exception e) {
			log.error("Error en BooksController editar", e);
		}
		ra.addFlashAttribute("mensaje",respuestaServicio.getMensaje());
		respuestaServicio=booksService.findAll();	
		return new ModelAndView("redirect:/home");
	}


	//UPDATE
	@PostMapping("/editar")
	public ModelAndView editar(@ModelAttribute BooksDTO book, RedirectAttributes ra) {

		BooksVO respuestaServicio = booksService.update(book);
		ra.addFlashAttribute("mensaje", respuestaServicio.getMensaje());
		if (respuestaServicio.getCodigo().equals("0")) {
			return new ModelAndView("redirect:/home");
		} else {
			return new ModelAndView("redirect:/editarForm");
		}
		
	}
	
	
	//DELETE
	@GetMapping("/eliminar")
	public ModelAndView eliminar(Model model, @RequestParam String idBook, RedirectAttributes ra) {
		BooksVO respuestaServicio = new BooksVO();
		respuestaServicio.setMensaje("No se pudo eliminar el libro, intente nuevamente.");
		try {
			BooksDTO eliminado=new BooksDTO();
			eliminado.setIdBook(idBook);
			respuestaServicio=booksService.delete(eliminado);
			ra.addFlashAttribute("mensaje", respuestaServicio.getMensaje());
			return new ModelAndView("redirect:/home");
		} catch (Exception e) {
			log.error("Error en BooksController eliminar", e);
		}
		ra.addFlashAttribute("mensaje", respuestaServicio.getMensaje());
		respuestaServicio=booksService.findAll();
		ra.addAttribute("VO", respuestaServicio);
		return new ModelAndView("redirect:/home");
	}

	
}
