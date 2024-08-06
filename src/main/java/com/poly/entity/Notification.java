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
public class Notification implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING) // Sử dụng EnumType.STRING để lưu trữ tên enum
    @Column(name = "title")
    private NotificationTitle title;

    @Enumerated(EnumType.STRING)
    @Column(name = "content")
    private NotificationContent content;

    @Column(name = "createdDate")
    private Date createdDate;

    @Column(name = "isActived")
    private Boolean isActived;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "eventId", referencedColumnName = "id")
    private Event eventId;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "userId", referencedColumnName = "id")
    private User userId;
}
