package com.socialmedia.backend.controller;

import com.socialmedia.backend.model.User;
import com.socialmedia.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    @Autowired
    UserService userService;


    @GetMapping("/")
    List<User> getUser() {
        return userService.getUser();
    }

    @GetMapping("/{userName}")
    User getUserName(@PathVariable String userName) {
        return userService.findByUsername(userName);
    }

    @GetMapping("/getId/{username}")
    User getUserByUsername(@PathVariable String username) {
        return userService.getUserByUsername(username);

    }

    @GetMapping("/getUser/{userId}")
    User getUserById(@PathVariable Long userId) {
        return userService.getUserById(userId);
    }

    @PostMapping("/login")
    boolean validateUser(@RequestParam String username, @RequestParam String password, HttpSession httpSession) {
        boolean validated = userService.validateUser(username, password);
        if(!validated) return false;
        httpSession.setAttribute("Username",username);
        return true;
    }
    @GetMapping("/getSession")
    String getSession(HttpSession httpSession){
        String name = (String) httpSession.getAttribute("Username");
        if(name==null) return "noSession";
        return name;
    }
    @GetMapping("/logout")
    void endSession(HttpSession httpSession){httpSession.removeAttribute("UserName");}

    @PutMapping("/{userId}/post/{postId}")
    User addPost(@PathVariable Long userId, @PathVariable Long postId) {
        return userService.addPost(userId, postId);
    }

    @PutMapping("/{userId}/follow/{followingId}")
    User follow(@PathVariable Long userId, @PathVariable Long followingId) {
        return userService.follow(userId, followingId);
    }

    @PostMapping("{userId}/addProfilePicture/")
    String addProfilePicture(@PathVariable Long userId, @RequestParam("image") MultipartFile image) throws IOException {
        return userService.addProfilePicture(userId, image);
    }

    @GetMapping("{userId}/getProfilePicture/")
    @ResponseBody
    Void getProfilePicture(@PathVariable Long userId, HttpServletResponse response) throws IOException {
        String extension = userService.getUserById(userId).getProfilePictureExtension();
        response.setContentType("image/" + extension);
        response.setHeader("Content-Disposition", "attachment; filename=profile-picture");
        response.setHeader("Content-Transfer-Encoding", "Binary");
        try {
            BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());
            FileInputStream fis = new FileInputStream("C:/Users/ziadh/Desktop/ziad/project/pictures/" + userId + "." + extension);
            int len;
            byte[] buf = new byte[1024];
            while ((len = fis.read(buf)) > 0) {
                bos.write(buf, 0, len);
            }
            bos.close();
            response.flushBuffer();
        } catch (IOException e) {

        }
    return null;
    }
}
