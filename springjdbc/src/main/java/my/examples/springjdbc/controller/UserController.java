package my.examples.springjdbc.controller;

import my.examples.springjdbc.dto.User;
import my.examples.springjdbc.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;


import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserController {
    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //  @RequestMapping(method=GET, path="/test") 와 같은 것
    @GetMapping("/test")
    public String main(
            @RequestParam(name = "page", required = false, defaultValue = "1") int page, Model model){
        List<User> users = userService.getUsers(page);
        model.addAttribute("users", users);
        return "test"; // view name

    }

    @GetMapping("/login")
    public String login() {
        return "loginform";
    }

    @GetMapping("/join")
    public String joinform() {
        return "joinform";
    }

    @PostMapping("/join")
    public String join(@RequestParam(name = "name") String name,
                       @RequestParam(name = "nickname") String nickname,
                       @RequestParam(name = "email") String email,
                       @RequestParam(name = "passwd") String passwd,
                        @RequestParam(name= "passwdCheck") String passwdCheck
//                      ,
//                       @RequestHeader(name = "accept") String accept,
//                       HttpSession session
                        ) {

        // 값에 검증.
        Assert.hasLength(name, "이름을 입력하세요.");
        if (name == null || name.length() <= 1)
            throw new IllegalArgumentException("이름을 입력하세요.");

        Assert.isTrue(true, "비밀번호가 다릅니다.");
        if (!passwd.equals(passwdCheck))
            throw new IllegalArgumentException("비밀번호가 다릅니다.");

        PasswordEncoder passwordEncoder =
                PasswordEncoderFactories.createDelegatingPasswordEncoder();

        // 암호화 하는 코드
        String encodePasswd = passwordEncoder.encode(passwd);

        User user = new User();
        user.setName(name);
        user.setPasswd(encodePasswd);
        user.setNickname(nickname);
        user.setEmail(email);

        userService.addUser(user);

        return "redirect:/login";

    }
}

