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
public class MemberController {

    private final String[] GET_METHOD_NAME_USER = {"getId", "getFullname", "getEmail", "getPhone", "getBirthday", "getScore", "getAddress"};
    private List<User> listAllUser = getAllMembers();
    private RoleService roleService = UserInjector.getInstance().getRoleService();
    private Main mainForm = new Main();
    private MemberService memberService = MemberInjector.getInstance().getMemberService();
    private JTextField memberName = mainForm.getTxtNameMember();
    private JTextField email = mainForm.getTxtEmailMemBer();
    private JTextField phone = mainForm.getTxtPhoneMember();
    private JDateChooser birthday = mainForm.getDcBirthdayMember();
    private JTextField address = mainForm.getTxtAddressMember();
    private JRadioButton male = mainForm.getRdoMaleMember();
    private JRadioButton female = mainForm.getRdoFemaleMember();
    private JComboBox<String> rateCore = mainForm.getCboRateMember();


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

    public void deleteUser(Integer id) {
        User deletedMember = memberService.delete(id);
        if (deletedMember != null) {
            MsgBox.alert(null, "Xóa thành viên thành công!");
        } else {
            MsgBox.alert(null, "Không thể xóa người dùng.");
        }
    }

    public List<User> getAllMembers() {
        return memberService.findAll();
    }

    public User getFormUser(User memberForm) {

        String fullname = RegExInputFields.getCheckNameMember(memberName);
        memberForm.setFullname(fullname);

        String memberEmail = RegExInputFields.getCheckEmail(email);
        memberForm.setUsername(memberEmail);

        String memberPhone = RegExInputFields.getCheckPhoneMember(phone);
        memberForm.setPhone(memberEmail);

        String addressMember = RegExInputFields.getCheckAddress(address);
        memberForm.setAddress(addressMember);

        Boolean gender = InputFields.getSelectedRadiobutton(male, female);
        memberForm.setSex(gender);

        Date birthdate = InputFields.getDatetoDateSQL(birthday);
        memberForm.setBirthday(birthdate);

        String rateMembers = InputFields.getComboBoxString(rateCore);
        memberForm.setRate(rateMembers);

        return memberForm;
    }

    public void setFormUser(User memberForm) {
        memberName.setText(memberForm.getFullname());
        email.setText(memberForm.getUsername());
        phone.setText(memberForm.getPhone());
        address.setText(memberForm.getAddress());

        if (memberForm.getSex() != null) {
            if (memberForm.getSex()) {
                male.setSelected(true);
                female.setSelected(false);
            } else {
                male.setSelected(false);
                female.setSelected(true);
            }
        }

        if (memberForm.getBirthday() != null) {
            birthday.setDate(new java.util.Date(memberForm.getBirthday().getTime()));
        } else {
            birthday.setDate(null);
        }

        rateCore.setSelectedItem(memberForm.getRate());
    }
}
