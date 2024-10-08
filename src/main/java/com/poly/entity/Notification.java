package com.poly.entity;

import com.poly.utils.NotificationContent;
import com.poly.utils.NotificationTitle;
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
public class Notification implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(name = "title")
    private NotificationTitle title;

    @Enumerated(EnumType.STRING)
    @Column(name = "content")
    private NotificationContent content;

    @Column(name = "createdDate")
    private Date createdDate;

    @Column(name = "isActived")
    private Boolean isActived;

    @Column(name = "userFullname")
    private String userFullname;

    @Column(name = "eventTitle")
    private String eventTitle;
}
