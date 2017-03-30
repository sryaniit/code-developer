package com.shopping.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shopping.dao.CategoryDAO;
import com.shopping.model.Category;


@Controller
public class CategoryController {
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	
	
	@RequestMapping(value = "/cat", method = RequestMethod.GET)
	public String listCategorys(Model model) {
		model.addAttribute("category", new Category());
		model.addAttribute("categoryList", this.categoryDAO.list());
		return "category";
    }
	
	//For add and update category both
	@RequestMapping(value= "/category/add", method = RequestMethod.POST)
	public String addCategory(@ModelAttribute("category") Category category){
		
	
			categoryDAO.saveOrUpdate(category);
		
		return "redirect:/cat";
		
	}
	
	@RequestMapping("category/remove/{id}")
    public String deleteCategory(@PathVariable("id") String id,ModelMap model) throws Exception{
		
       try {
		categoryDAO.delete(id);
		model.addAttribute("message","Successfully Removed");
	} catch (Exception e) {
		model.addAttribute("message",e.getMessage());
		e.printStackTrace();
	}
       //redirectAttrs.addFlashAttribute(arg0, arg1)
        return "redirect:/cat";
    }
	
	
	/*@RequestMapping({"home","/"})
	public ModelAndView onLoadHome(Model model)
	{
		model.addAttribute("category", new Category());
		model.addAttribute("categoryList", this.categoryDAO.list());
		//model.addAttribute("cartSize", this.cartDAO.list().size());
		ModelAndView mv=new ModelAndView("home");
		mv.addObject("clickedHome","true");
		return mv;
	}
	@RequestMapping("user")

	public ModelAndView onLoadUser(Model model)
	{
		model.addAttribute("category", new Category());
		model.addAttribute("categoryList", this.categoryDAO.list());
		//model.addAttribute("cartSize", this.cartDAO.list().size());
		ModelAndView mv=new ModelAndView("login");
		mv.addObject("clickedHome","true");
		return mv;
	}*/
    @RequestMapping("category/edit/{id}")
    public String editCategory(@PathVariable("id") String id, Model model){
    	System.out.println("editCategory");
        model.addAttribute("category", this.categoryDAO.get(id));
        model.addAttribute("listCategorys", this.categoryDAO.list());
        return "category";
    }
	}
