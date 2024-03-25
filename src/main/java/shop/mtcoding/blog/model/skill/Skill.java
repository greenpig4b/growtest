package shop.mtcoding.blog.model.skill;


import jakarta.persistence.*;
import lombok.*;
import shop.mtcoding.blog.model.comp.CompRequest;
import shop.mtcoding.blog.model.jobs.Jobs;
import shop.mtcoding.blog.model.resume.Resume;
import shop.mtcoding.blog.model.resume.ResumeResponse;

@NoArgsConstructor
@Table(name = "skill_tb")
@Data
@Entity
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;
    @Column(nullable = false) // 1: 유저, 2: 기업
    private Integer role;
    private String color;

    @ManyToOne(fetch = FetchType.LAZY)
    private Resume resume;

    @ManyToOne(fetch = FetchType.LAZY)
    private Jobs jobs;

    @Builder
    public Skill(Integer id, Resume resume, String name, Integer role, String color) {
        this.id = id;
        this.resume = resume;
        this.name = name;
        this.role = role;
        this.color = color;
    }

    public ResumeResponse.SkillDTO toDTO(){

        String colorClass = "";
        if (name.equals("Jquery")){
            colorClass = "badge bg-primary";
        }
        else if(name.equals("JavaScript")){
            colorClass = "badge bg-secondary";
        }
        else if(name.equals("Spring")){
            colorClass = "badge bg-success";
        }
        else if(name.equals("HTML/CSS")){
            colorClass = "badge bg-danger";
        }
        else if(name.equals("JSP")){
            colorClass = "badge bg-warning";
        }
        else if(name.equals("Java")){
            colorClass = "badge bg-info";
        }
        else if(name.equals("React")){
            colorClass = "badge bg-dark";
        }

        return ResumeResponse.SkillDTO.builder()
                .id(this.id)
                .name(this.name)
                .role(this.role)
                .color(colorClass)
                .build();
    }
}
