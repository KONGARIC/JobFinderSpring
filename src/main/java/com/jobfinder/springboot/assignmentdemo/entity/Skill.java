package com.jobfinder.springboot.assignmentdemo.entity;



import lombok.Data;

import javax.persistence.*;



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

