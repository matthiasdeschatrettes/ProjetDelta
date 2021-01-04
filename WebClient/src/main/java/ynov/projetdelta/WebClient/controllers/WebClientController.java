package ynov.projetdelta.WebClient.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ynov.projetdelta.WebClient.model.Article;
import ynov.projetdelta.WebClient.model.Cate;
import ynov.projetdelta.WebClient.model.Com;
import ynov.projetdelta.WebClient.model.User;
import ynov.projetdelta.WebClient.repositories.ArticleProxy;
import ynov.projetdelta.WebClient.repositories.CateProxy;
import ynov.projetdelta.WebClient.repositories.ComProxy;
import ynov.projetdelta.WebClient.repositories.UserProxy;

@Controller
public class WebClientController {

	@Autowired
	private UserProxy userProxy;
	
	@Autowired
	private ComProxy comProxy;
	
	@Autowired
	private CateProxy cateProxy;
	
	@Autowired
	private ArticleProxy articleProxy;
	
	@GetMapping(value = {"/", "/{id}"})
	public String getHomePage(@PathVariable(name = "id", required = false) Integer id, Model model) {		
		
		Iterable<User> users = userProxy.getUsers();
		model.addAttribute("users", users);		
		int idToGet = 1;
		if(id != null) {
			idToGet = id;
		}
		Com com =comProxy.getCom(idToGet);
		model.addAttribute("commentaire", com);
		
		Cate cate =cateProxy.getCate(idToGet);
		model.addAttribute("catégorie", cate);
		
		Article article =articleProxy.getArticle(idToGet);
		model.addAttribute("article", article);
		
		return "homepage";
	}
	
	@GetMapping("/createUser")
	public String createUser(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "formCreateUser";
	}
	
	@GetMapping("/updateUser/{id}")
	public String updateUser(@PathVariable int id, Model model) {
		User user = userProxy.getUser(id);
		model.addAttribute("user", user);
		return "formUpdateUser";
	}	
	
	@PostMapping("/saveUser")
	public ModelAndView saveUser(@ModelAttribute User user) {
		if(user.getId() == null) {
			userProxy.createUser(user);
		} else {
			userProxy.updateUser(user);
		}
		return new ModelAndView("redirect:/");
	}

	@GetMapping("/deleteUser/{id}")
	public ModelAndView deleteUser(@PathVariable int id) {
		userProxy.deleteUser(id);
		return new ModelAndView("redirect:/");	
	}
	
}
