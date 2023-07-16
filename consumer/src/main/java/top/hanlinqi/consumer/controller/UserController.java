package top.hanlinqi.consumer.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

/**
 * @program: UserController
 * @description:
 * @author: hanLinQi
 * @create: 2023-03-08 14:28
 **/
@RestController
public class UserController {

    @GetMapping("/get")
    public ResponseEntity<String> pullRpcService(@PathParam("name") String name) {
        return ResponseEntity.ok(name);
    }
}
