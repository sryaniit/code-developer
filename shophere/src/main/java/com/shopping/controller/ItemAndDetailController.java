package com.shopping.controller;

import com.shopping.model.Item;
import com.shopping.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.List;


/*
 * This controller is used to show all Items and item detail page.
 */
@Controller
@RequestMapping("/shopping")
public class ItemAndDetailController {

    @Autowired
    private ItemService itemService;
    /*
     * getAllItems method is used to show all items those are into the system
     */
    @RequestMapping("/allItems")
    public String getAllItems(Model model) {
        List<Item> items = itemService.getItemList();
        model.addAttribute("items", items);

        return "home";
    }
    /*
     * viewItem method is used to show items detail page
     */
    @RequestMapping("/showitem/{itemId}")
    public String viewItem(@PathVariable int itemId, Model model) throws IOException {
    	System.out.println("in show");
    	Item items=itemService.getItemById(itemId);
        model.addAttribute("item", items);

        return "showItem";
    }
    /*
     * getItemByCategory method is called when user wants to get items by category.
     */
    @RequestMapping("/itemList")
    public String getItemByCategory(@RequestParam("searchCondition") String searchCondition, Model model) {
        List<Item> items = itemService.getItemList();
        model.addAttribute("items", items);
        model.addAttribute("searchCondition", searchCondition);

        return "listitem";
    }
}
