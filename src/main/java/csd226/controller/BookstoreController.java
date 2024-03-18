package csd226.controller;

import csd226.data.Content;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class BookstoreController {

    @GetMapping("/publiccontent")
    public ResponseEntity<String> getPublicContent(){// map a URL to a method
        String signingForm = getsigningForm();
        String content = " Welcome to the Bookstore";
        String combinedContent = signingForm + content;
        return ResponseEntity.ok(combinedContent);
    }
    @GetMapping("/about")
    public ResponseEntity<String> getAbout(){ // map a URL to a method
        return ResponseEntity.ok("getAbout() : About");
    }
    @GetMapping("/publiccontent2")
    public Content getPublicContent2(){ // map a URL to a method
        return new Content("some content");
    }


    private String getsigningForm() {

        return "<form hx-post=\"/signin\" hx-target=\"this\" hx-swap=\"outerHTML\">\n" +
                "  <div>\n" +
                "    <label>First Name</label>\n" +
                "    <input type=\"text\" name=\"firstname\" value=\"Prajwol\">\n" +
                "  </div>\n" +
                "  <div class=\"form-group\">\n" +
                "    <label>Last Name</label>\n" +
                "    <input type=\"text\" name=\"lastname\" value=\"GC\">\n" +
                "  </div>\n" +
                "  <div class=\"form-group\">\n" +
                "    <label>Email Address</label>\n" +
                "    <input type=\"email\" name=\"email\" value=\"prajwol@gc.com\">\n" +
                "  </div>\n" +
                "  <div class=\"form-group\">\n" +
                "    <label>Password</label>\n" +
                "    <input type=\"email\" name=\"password\" value=\"prajwol@gc.com\">\n" +
                "  </div>\n" +
                "  <button class=\"btn\">Submit</button>\n" +
                "  <button class=\"btn\" hx-get=\"/signin\">Cancel</button>\n" +
                "</form>";

    }

}
