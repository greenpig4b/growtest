package shop.mtcoding.blog.model.resume;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import shop.mtcoding.blog.model.apply.Apply;
import shop.mtcoding.blog.model.jobs.Jobs;
import shop.mtcoding.blog.model.offer.Offer;
import shop.mtcoding.blog.model.scrap.Scrap;
import shop.mtcoding.blog.model.skill.Skill;
import shop.mtcoding.blog.model.user.User;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class ResumeResponse {

    @Data
    @Builder
    public static class ResumeDTO{
        private Integer id;
        private UserDTO user;
        private String title;
        private String area;
        private String edu;
        private String career;
        private String introduce;
        private String portLink;
        private List<SkillDTO> skillList;
//        private List<Apply> applyList = new ArrayList<>();
//
//        private List<Scrap> scrapList = new ArrayList<>();
//
//        private List<Offer> offerList = new ArrayList<>();

        private Timestamp createdAt;
    }

    @Data
    @Builder
    public static class UserDTO{
        private Integer id;
        private String email;
        private String myName;
        private String phone;
        private String address;
        private Date birth;
        private String businessNumber;
        private String photo;
        private String compName;
        private String homepage;
        private Integer role;
        private Timestamp createdAt;
        private String imgFileName;
    }

    @Data
    @Builder
    public static class SkillDTO{
        private Integer id;
        private String name;
        private Integer role;
        private String color;
    }
}
