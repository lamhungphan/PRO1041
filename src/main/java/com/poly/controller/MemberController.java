/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.controller;

import com.mysql.cj.Constants;
import com.poly.constant.RoleConstant;
import com.poly.entity.Role;
import com.poly.entity.User;
import com.poly.injection.MemberInjector;
import com.poly.injection.UserInjector;
import com.poly.services.AuthorizationService;
import com.poly.services.MemberService;
import com.poly.services.RoleService;
import com.poly.services.UserService;
import com.poly.utils.InputFields;
import com.poly.utils.MsgBox;
import com.poly.utils.RegExInputFields;
import com.poly.view.Main;
import com.toedter.calendar.JDateChooser;

import java.sql.Date;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 * @author Computer
 */
public class MemberController extends UserController {

    private final String[] GET_METHOD_NAME_USER = {"getId", "getFullname", "getEmail", "getPhone", "getBirthday", "getScore", "getAddress"};
    private List<User> listAllUser = getAllMembers();
    private RoleService roleService = UserInjector.getInstance().getRoleService();
    private MemberService memberService = MemberInjector.getInstance().getMemberService();


    // CRUD operations
    public void createdMember(User model) {
        User createdMember = memberService.save(model, RoleConstant.THANH_VIEN);
        if (createdMember != null) {
            MsgBox.alert(null, "Tạo thành viên thành công!");
        } else {
            MsgBox.alert(null, "Không thể tạo thành viên.");
        }
    }

    public User readMember(Integer id) {
        return memberService.findById(id);
    }

    public void updateMember(User model) {
        User updatedUser = memberService.update(model);
        if (updatedUser != null) {
            MsgBox.alert(null, "Cập nhật thành viên thành công!");
        } else {
            MsgBox.alert(null, "Không thể cập nhật thành viên.");
        }
    }

    public void deleteUserById(Integer id) {
        User deletedMember = memberService.delete(id);
        if (deletedMember != null) {
            MsgBox.alert(null, "Xóa thành viên thành công!");
        } else {
            MsgBox.alert(null, "Không thể xóa người dùng.");
        }
    }

    public void deleteUserByName(String name) {
        User deletedMember = memberService.findByFullname(name);
        if (deletedMember != null) {
            MsgBox.alert(null, "Xóa thành viên thành công!");
        } else {
            MsgBox.alert(null, "Không thể xóa người dùng.");
        }
    }

    public List<User> getAllMembers() {
        return memberService.findAll();
    }


}
