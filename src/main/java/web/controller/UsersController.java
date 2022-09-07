package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller
@RequestMapping("/")
public class UsersController {
    private final UserService userService;

   public UsersController(UserService userService) {
        this.userService = userService;
    }

   @GetMapping
   public String getAllUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "allUsers";
    }

   @GetMapping("/new")
   public String addUser(Model model) {
        model.addAttribute("user", new User());
        return "addUser";
   }

   @PostMapping()
   public String createUser(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/";
   }

   @GetMapping("/{id}/edit")
   public String edit(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userService.getById(id));
        return "edit";
   }

   @PatchMapping("/{id}")
   public String update(@ModelAttribute("user") User user, @PathVariable("id") long id) {
        userService.update(id, user);
        return "redirect:/";
   }

   @DeleteMapping("/{id}")
   public String delete(@PathVariable("id") long id) {
        userService.delete(id);
        return "redirect:/";
   }
}