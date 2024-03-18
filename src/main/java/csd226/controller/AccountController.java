package csd226.controller;

import csd226.data.Account;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AccountController {
    @PostMapping("/signup")
   public ResponseEntity<String> createAccount(@RequestBody Account signUpFormData){
        return ResponseEntity.ok("createAccount() : "+signUpFormData.getEmail());
    }
    @GetMapping("/signin")
    public ResponseEntity<String> getSignin(){ // map a URL to a method
        String s="<form hx-post=\"/signin\" hx-target=\"this\" hx-swap=\"outerHTML\">" +
                "    <div>" +
                "        <label>First Name</label>" +
                "        <input type=\"text\" name=\"firstname\" value=\"Joe\">" +
                "    </div>" +
                "    <div class=\"form-group\">" +
                "        <label>Last Name</label>" +
                "        <input type=\"text\" name=\"lastname\" value=\"Blow\">" +
                "    </div>" +
                "    <div class=\"form-group\">" +
                "        <label>Email Address</label>" +
                "        <input type=\"email\" name=\"email\" value=\"joe@blow.com\">" +
                "    </div>" +
                "    <div class=\"form-group\">" +
                "        <label>Password</label>" +
                "        <input type=\"password\" name=\"password\" value=\"xxxxx\">" +
                "    </div>" +
                "    <div class=\"form-group\">" +
                "        <label>Confirm Password</label>" +
                "        <input type=\"password\" name=\"confirmPassword\" value=\"xxxxx\">" +
                "    </div>" +
                "    <button class=\"btn\">Submit</button>" +
                "    <button class=\"btn\" hx-get=\"/signin\">Cancel</button>" +
                "</form>";
        return ResponseEntity.ok(s);
    }




    // just here for reference: call it with http://localhost:8080/signup2?email=f.c@g.c
    @GetMapping("/signup2")
    @ResponseBody
    public String createAccount2(@RequestParam String email) {
        return "email: " + email;
    }
}
