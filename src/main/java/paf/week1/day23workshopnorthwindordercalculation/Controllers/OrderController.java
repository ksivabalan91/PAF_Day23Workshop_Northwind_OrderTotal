package paf.week1.day23workshopnorthwindordercalculation.Controllers;

import java.util.LinkedList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import paf.week1.day23workshopnorthwindordercalculation.Models.OrderTotal;
import paf.week1.day23workshopnorthwindordercalculation.Services.OrderService;

@Controller
public class OrderController {

    @Autowired
    private OrderService orderSvc;

    Logger logger = LoggerFactory.getLogger(getClass());

    @GetMapping(path="order/total", produces=MediaType.TEXT_HTML_VALUE)
    public String calculateTotal(@RequestParam int orderId, Model model){        
        
        try{
            logger.info("calculating order");
            List<OrderTotal> orders = orderSvc.calculateTotal(orderId);
            logger.info("Order list: %s".formatted(orders.toString()));
            
            logger.info("creating product list");
            List<String> productBought = new LinkedList<>();
            for(OrderTotal i: orders){
                productBought.add(i.getProductName());
            }
            logger.info("Product list: %s".formatted(productBought.toString()));
            
            logger.info("Adding to model");
            model.addAttribute("products", productBought);
            model.addAttribute("orders", orders.get(0));
            return "orderdetails";
        } catch(Exception ex){
            model.addAttribute("orderId",orderId);
            return "noorders";
        }
        
    }
    
}
