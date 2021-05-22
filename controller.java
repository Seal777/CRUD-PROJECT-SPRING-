package codejava;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class controller {
	
	@Autowired	
	private productDAO dao;
	
	@RequestMapping("/")
	public String viewHomepage(Model model)
	{
		List<product> listproduct=dao.list();
		model.addAttribute("listproduct",listproduct);
		return "index";
	}

	@RequestMapping("/new")
	public String showNewform(Model model)
	{
		product pro=new product();
		model.addAttribute("pro",pro);
		return "new_form";
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String save(@ModelAttribute("pro") product pro) {
		  dao.save(pro);
		  
		  return "redirect:/";
	}
	
	@RequestMapping("/edit/{id}")
	public ModelAndView showEditForm(@PathVariable(name="id") int id)
	{
		 ModelAndView mav=new  ModelAndView("edit_form");
		 product p=dao.get(id);
		 mav.addObject("p",p);
		 
		 return mav;
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String update(@ModelAttribute("pro") product pro) {
		  dao.update(pro);
		  
		  return "redirect:/";
	}
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable(name="id") int id)
	{
		 dao.delete(id);
		 
		 return "redirect:/";
	}
	
	
	
	@RequestMapping("/sort_form")
	public String viewHpage(Model model)
	{
		List<product> listproduct1=dao.list1();
		model.addAttribute("listproduct1",listproduct1);
		return "sort_form";
	}
	
	
	
}
