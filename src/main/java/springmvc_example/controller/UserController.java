package springmvc_example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import springmvc_example.model.User;
import springmvc_example.service.UserService;

@Controller
@RequestMapping(value = "/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public ModelAndView list(){
		ModelAndView model = new ModelAndView("user/list");
		model.addObject("listUser", this.userService.listUser());
		return model;
	}
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public ModelAndView add(){
		ModelAndView model = new ModelAndView("user/form");
		model.addObject("userForm", new User());
		
		return model;
	}
	
	@RequestMapping(value="/update/{id}", method=RequestMethod.GET)
	public ModelAndView update(@PathVariable("id") String id){
		ModelAndView model = new ModelAndView("user/form");
		model.addObject("userForm", this.userService.findUserById(id));
		
		return model;
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String save(@ModelAttribute("userForm") User user){
		if(user.getId() != null && !user.getId().trim().equals("")){
			this.userService.update(user);
		}else{
			this.userService.add(user);
		}
		return "redirect:/user/list";
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public String delete(@PathVariable("id") String id){
		User u = this.userService.findUserById(id);
		this.userService.delete(u);
		return "redirect:/user/list";
	}
	
}
