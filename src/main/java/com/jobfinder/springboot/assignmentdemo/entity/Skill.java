package com.jobfinder.springboot.assignmentdemo.entity;



import lombok.Data;

import javax.persistence.*;

import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "skills")
@Data
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;


    public Skill(int id) {
        this.id = id;
    }






    @Column(name = "skill")
//    @NotEmpty(message = "please enter skill")
    private String skill;


    public Skill(String skill) {
        this.skill = skill;
    }

    public Skill() {}





    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }







    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }
}



//
//@Entity
//@Table(name = "skills")
//@Data
//public class Skill {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
//    private int id;
//
//
//    public Skill(int id) {
//        this.id = id;
//    }
////    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE})
////    @JoinColumn(name = "job_id")
//    private int job;
//
//
//
//
//    @Column(name = "skill")
//    @NotEmpty(message = "please enter skill")
//    private String skill;
//
//
//    public int getJob() {
//        return job;
//    }
//
//    public void setJob(int job) {
//        this.job = job;
//    }
//
//    public Skill() {}
//
//    public Skill(int id, int jobId, String skill) {
//        this.id = id;
//
//        this.skill = skill;
//    }
//
//    public Skill(int jobId, String skill) {
//
//        this.skill = skill;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//
//
//
//
//
//
//    public String getSkill() {
//        return skill;
//    }
//
//    public void setSkill(String skill) {
//        this.skill = skill;
//    }
//}
