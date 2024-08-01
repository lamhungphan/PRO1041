package com.poly.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import java.sql.Date;
 import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "fullname")
    private String fullname;

    @Column(name = "address")
    private String address;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @Column(name = "birthday")
    private Date birthday;

    @Column(name = "sex")
    private Boolean sex;

    @Column(name = "createdDate")
    private Date createdDate;

    @Column(name = "updatedDate")
    private Date updatedDate;

    @Column(name = "isActived")
    private Boolean isActived;
    
    @Column(name = "score")
    private String score;

    @ManyToOne
    @JoinColumn(name = "roleId", referencedColumnName = "id")
    private Role role;
}
