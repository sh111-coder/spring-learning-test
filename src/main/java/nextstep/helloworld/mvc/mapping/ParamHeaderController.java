package nextstep.helloworld.mvc.mapping;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/param-header")
public class ParamHeaderController {

    @GetMapping("/message")
    public ResponseEntity<String> message() {
        return ResponseEntity.ok().body("message");
    }

    @GetMapping(value = "/message", params = "name")
    public ResponseEntity<String> messageForParam(@RequestParam("name") String msg) {
        return ResponseEntity.ok().body(msg);
    }

    @GetMapping(value = "/message", headers = "HEADER")
    public ResponseEntity<String> messageForHeader(@RequestHeader("HEADER") String msg) {
        return ResponseEntity.ok().body(msg);
    }
}
