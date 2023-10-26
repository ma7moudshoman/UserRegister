package UserRegistration.User.Controller;

import UserRegistration.User.Model.User;
import UserRegistration.User.Repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserRepo userRepo;

// Get   localhost:8080/register
    @GetMapping("/register")
    public String getregpage(@ModelAttribute("user") User user){
        return "Register";
    }
@PostMapping("/register")
    public String saveUser(@ModelAttribute ("user") User user, Model model){
        model.addAttribute("message" ,"Submitted Success");
        userRepo.save(user);
        return "Register";
}
@GetMapping("/users")
    public String users(Model model){
    List<User> list=userRepo.findAll();
    model.addAttribute("user", list);
    return "user";
}

}
