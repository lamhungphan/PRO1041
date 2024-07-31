/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.controller;

import com.poly.entity.User;
import com.poly.injection.MemberInjector;
import com.poly.services.MemberService;
import com.poly.utils.MsgBox;
import java.util.List;

/**
 *
 * @author Computer
 */
public class MemberController {

    MemberService memberService = MemberInjector.getInstance().getMemberService();

    // CRUD operations
    public void createUser(User user, String roleName) {
        User createdUser = memberService.save(user, roleName);
        if (createdUser != null) {
            MsgBox.alert(null, "Tạo thành viên thành công!");
        } else {
            MsgBox.alert(null, "Không thể tạo thành viên.");
        }
    }

    public User readUser(Integer id) {
        return memberService.findById(id);
    }

    public void updateUser(User user) {
        User updatedUser = memberService.update(user);
        if (updatedUser != null) {
            MsgBox.alert(null, "Cập nhật thành viên thành công!");
        } else {
            MsgBox.alert(null, "Không thể cập nhật thành viên.");
        }
    }

    public void deleteUser(Integer id) {
        User deletedUser = memberService.delete(id);
        if (deletedUser != null) {
            MsgBox.alert(null, "Xóa thành viên thành công!");
        } else {
            MsgBox.alert(null, "Không thể xóa người dùng.");
        }
    }

    public List<User> getAllUsers() {
        return memberService.findAll();
    }
}
