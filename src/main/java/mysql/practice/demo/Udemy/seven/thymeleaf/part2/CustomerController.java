package mysql.practice.demo.Udemy.seven.thymeleaf.part2;

import jakarta.validation.Valid;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController  {

@InitBinder
public  void  initBinder(WebDataBinder dataBinder ){
    StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
    dataBinder.registerCustomEditor(String.class, stringTrimmerEditor );
}


    @GetMapping("/thyme/")
    public  String showForm(Model model ){
        model.addAttribute("customer", new Customer());
        return "customer-form";
    }

    @PostMapping("/processForm")
    public  String processForm(
            @Valid @ModelAttribute("customer") Customer theCustomer,
            BindingResult theBindingResult
    ){
        System.out.println("my result ....."+theCustomer.getFirstName()+"...................."+ theCustomer.getLastName()+"...."+ theCustomer.getPostalCode()+"....");
        System.out.println();
        System.out.println();
        System.out.println("Bindimng result + "+ theBindingResult.toString());
        System.out.println();
        System.out.println();
        System.out.println();
        if(theBindingResult.hasErrors()){
            return "customer-form";
        }else {
            return "customer-confirmation";
        }
    }

}
