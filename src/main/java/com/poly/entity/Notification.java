package com.poly.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Date;

@Table
@Entity(name = "Notifications")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Notification implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name = "createdDate")
    private Date createdDate;

    @Column(name = "updateDate")
    private Date updatedDate;

    @Column(name = "request")
    private String request;

    @Column(name = "reply")
    private String reply;

    @Column(name = "isActived")
    private Boolean isActived;

    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName = "id")
    private User userId;
}
