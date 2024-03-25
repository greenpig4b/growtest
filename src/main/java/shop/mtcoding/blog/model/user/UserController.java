package shop.mtcoding.blog.model.user;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import shop.mtcoding.blog.model.jobs.JobResponse;
import shop.mtcoding.blog.model.jobs.JobsRepository;
import shop.mtcoding.blog.model.resume.Resume;
import shop.mtcoding.blog.model.resume.ResumeResponse;
import shop.mtcoding.blog.model.resume.ResumeService;
import shop.mtcoding.blog.model.skill.Skill;
import shop.mtcoding.blog.model.skill.SkillRepository;

import java.util.List;


@RequiredArgsConstructor
@Controller
public class UserController {
    private final UserService userService;
    private final HttpSession session;
    private final ResumeService resumeService;

    @GetMapping("/")
    public String index(HttpServletRequest request) {
        List<ResumeResponse.ResumeDTO> resumes = resumeService.findAll();
        request.setAttribute("resumeList",resumes);

        return "index";
    }

    @GetMapping("/api/user/username-same-check")
    public String usernameSameCheck() {
        return null;
    }

    @PostMapping("/user/join")
    public String join() {
        return "redirect:/";
    }

    @DeleteMapping("/user/{id}")
    public String delete (){
        return "redirect:/";
    }


    @PostMapping("/user/login")
    public String login(UserRequest.LoginDTO reqDTO) {
        User user = userService.login(reqDTO);
        session.setAttribute("sessionUser", user);
        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout() {
        return "redirect:/";
    }
    @GetMapping("/user/join-form")
    public String joinForm() {
        return "/user/join-form";
    }

    @GetMapping("/user/login-form")
    public String loginForm() {
        return "/user/login-form";
    }

    @GetMapping("/user/{id}/apply")
    public String offer(@PathVariable Integer id) {
        return "/user/apply";
    }

    @GetMapping("/user/{id}/scrap")
    public String scrap(@PathVariable Integer id) {
        return "/user/scrap";
    }

    @PutMapping("/user/{id}")
    public String updateForm(@PathVariable Integer id) {

        return "redirect:/user/"+ id +"/user-home";
    }
    @GetMapping("/user/{id}/update-form")
    public String updateForm(@PathVariable int id) {

        return "/user/update-form";
    }

    @GetMapping("/user/{id}/user-home")
    public String userHome(@PathVariable Integer id) {

        return "/user/user-home";
    }

    // 이미지업로드용
    @PostMapping("/user/profile-upload")
    public String profileUpload() {

        return "redirect:/user/profile-update-form";
    }
    @GetMapping("/user/profile-update-form")
    public String profileUpdateForm(HttpServletRequest request) {
        return "/user/profile-update-form";
    }

}
