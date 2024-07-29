/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.controller;

import com.poly.entity.User;
import com.poly.injection.UserInjector;
import com.poly.services.AuthorizationService;
import com.poly.services.UserService;
import com.poly.utils.ComponentManagement;
import com.poly.utils.MsgBox;
import com.poly.utils.NavigationButtons;
import com.poly.utils.XDate;
import com.poly.view.Login;
import com.poly.view.Main;
import com.toedter.calendar.JDateChooser;
import java.sql.Date;
import java.util.List;

import javax.swing.*;

/**
 *
 * @author Computer
 */
public class UserController {

    private AuthorizationService authorizationService = UserInjector.getInstance().getAuthorizationService();
    private UserService userService = UserInjector.getInstance().getUserService();
    private static final String[] GET_METHOD_NAME_USER = {"getId", "getFullname", "getEmail", "getPhone", "getBirthday", "getScore", "getAddress"};

    public void doLogin(User userRequest, Main mainFrame, Login loginFrame) {
        User loginedUser = userService.doLogin(userRequest);
        if (loginedUser == null) {
            MsgBox.alert(null, "Đăng nhập không thành công");
        } else {
            MsgBox.alert(null, "Đăng nhập thành công");
            loginFrame.dispose();
            showWorkspaceByRolename(loginedUser, mainFrame);
        }
    }

    public void dologout(JFrame mainFrame, Login loginFrame) {
        mainFrame.dispose();
        loginFrame.setVisible(true);
    }

    public void showWorkspaceByRolename(User userLogined, Main mainFrame) {
        JPanel eventPanel = mainFrame.getPnlEvent();
        JPanel adminPanel = mainFrame.getPnlAdmin();
        JPanel notificationPanel = mainFrame.getPnlNotification();
        JPanel memberPanel = mainFrame.getPnlUser();
        if (authorizationService.isAdmin(userLogined)) {
            mainFrame.setVisible(true);
        } else if (authorizationService.isEventManager(userLogined)) {
            mainFrame.setVisible(true);
            ComponentManagement.setEnabledRecursively(eventPanel, true);
            ComponentManagement.setEnabledRecursively(adminPanel, false);
            ComponentManagement.setEnabledRecursively(notificationPanel, false);
            ComponentManagement.setEnabledRecursively(memberPanel, false);

        } else if (authorizationService.isMember(userLogined)) {
            mainFrame.setVisible(true);
            ComponentManagement.setEnabledRecursively(eventPanel, false);
            ComponentManagement.setEnabledRecursively(adminPanel, false);
            ComponentManagement.setEnabledRecursively(notificationPanel, false);
            ComponentManagement.setEnabledRecursively(memberPanel, true);
        } else if (authorizationService.isAccoutant(userLogined)) {
            mainFrame.setVisible(true);
            ComponentManagement.setEnabledRecursively(eventPanel, false);
            ComponentManagement.setEnabledRecursively(adminPanel, false);
            ComponentManagement.setEnabledRecursively(notificationPanel, true);
            ComponentManagement.setEnabledRecursively(memberPanel, false);
        }
    }
     // CRUD operations
    public void createUser(User user, String roleName) {
        User createdUser = userService.save(user, roleName);
        if (createdUser != null) {
            MsgBox.alert(null, "Tạo người dùng thành công!");
        } else {
            MsgBox.alert(null, "Không thể tạo người dùng.");
        }
    }

    public User readUser(Integer id) {
        return userService.findById(id);
    }

    public void updateUser(User user) {
        User updatedUser = userService.update(user);
        if (updatedUser != null) {
            MsgBox.alert(null, "Cập nhật người dùng thành công!");
        } else {
            MsgBox.alert(null, "Không thể cập nhật người dùng.");
        }
    }

    public void deleteUser(Integer id) {
        User deletedUser = userService.delete(id);
        if (deletedUser != null) {
            MsgBox.alert(null, "Xóa người dùng thành công!");
        } else {
            MsgBox.alert(null, "Không thể xóa người dùng.");
        }
    }

    public List<User> getAllUsers() {
        return userService.findAll();
    }

    public void setAllDataUserToTable(JTable tblListUser) {
        ComponentManagement.fillDataTableComponent(getAllUsers(), tblListUser, GET_METHOD_NAME_USER);
    }

    public User responseUserById(Integer idUser) {
        return userService.findById(idUser);
    }

    public void findUserIdToTableClicked(
            JTable tblListUser, 
            Integer row, 
            JTextField idField,
            JTextField txtNameMember,
            JTextField txtPhoneMember, 
            JTextField txtEmailMemBer, 
            JTextField txtAddressMember, 
            JDateChooser dcBirthdayMember, 
            JRadioButton rdoMale, 
            JRadioButton rdoFemale, 
            JComboBox cboRateMember){
        String idFound = String.valueOf(tblListUser.getValueAt(row, 0));
        User userFindOut = userService.findById(Integer.valueOf(idFound));
        setTextFromTableToForm(userFindOut,idField, txtNameMember, txtPhoneMember, txtEmailMemBer, txtAddressMember, dcBirthdayMember, rdoMale, rdoFemale, cboRateMember);
    }

    public void setTextFromTableToForm(
            User entityResponse, 
            JTextField idField,
            JTextField txtNameMember,
            JTextField txtPhoneMember,
            JTextField txtEmailMemBer,
            JTextField txtAddressMember,
            JDateChooser dcBirthdayMember,
            JRadioButton rdoMale,
            JRadioButton rdoFemale,
            JComboBox cboRateMember){
        idField.setText(String.valueOf(entityResponse.getId()));
        txtNameMember.setText(entityResponse.getFullname());
        txtPhoneMember.setText(entityResponse.getPhone());
        txtEmailMemBer.setText(entityResponse.getEmail());
        txtAddressMember.setText(entityResponse.getAddress());
        dcBirthdayMember.setDate(entityResponse.getBirthday());
        cboRateMember.setSelectedIndex(entityResponse.getScore());
        if (entityResponse.getSex()) {
            rdoMale.setSelected(true);
        } else {
            rdoFemale.setSelected(true);
        }
    }

    public void setFormUserPanelByButton(List<User> members, int index,String buttonDirection ,JTextField txtNameMember,
            JTextField txtPhoneMember,
            JTextField txtEmailMemBer,
            JTextField txtAddressMember,
            JDateChooser dcBirthdayMember,
            JRadioButton rdoMale,
                                         JRadioButton rdoFemale,
                                         JComboBox cboRateMember) {
        int sizeOfList = members.size();

        if (members == null) {
            MsgBox.alert(null, "không có danh sách để hiển thị");
            return;
        }
        User currentMember = members.get(index);
        NavigationButtons.navButtonInForm(buttonDirection, sizeOfList, index);
        setTextFromTableToForm(currentMember, txtNameMember, txtPhoneMember, txtEmailMemBer, txtAddressMember, dcBirthdayMember, rdoMale, rdoFemale, cboRateMember);
 }
    public void setClearForm(
            JTextField idField,
            JTextField txtNameMember,
            JTextField txtPhoneMember,
            JTextField txtEmailMemBer,
            JTextField txtAddressMember,
            JDateChooser dcBirthdayMember,
            JRadioButton rdoMale,
            JRadioButton rdoFemale,
            JComboBox cboRateMember){
        idField.setText("");
        txtNameMember.setText("");
        txtPhoneMember.setText("");
        txtEmailMemBer.setText("");
        txtAddressMember.setText("");
        dcBirthdayMember.setDate(null);
        rdoMale.setSelected(false);
        rdoFemale.setSelected(false);
        cboRateMember.setSelectedIndex(0);
    }

    public void createMemberToForm(
            JTextField idField,
            JTextField txtNameMember,
            JTextField txtPhoneMember,
            JTextField txtEmailMemBer,
            JTextField txtAddressMember,
            JDateChooser dcBirthdayMember,
            JRadioButton rdoMale,
            JRadioButton rdoFemale,
            JComboBox cboRateMember){
        try {
            String testIdNotNull = idField.getText();
//            if(testIdNotNull.equals(null)){
            User userRequest = new User();
            userRequest.setFullname(txtNameMember.getText());
            userRequest.setPhone(txtPhoneMember.getText());
            userRequest.setEmail(txtEmailMemBer.getText());
            userRequest.setAddress(txtAddressMember.getText());
            Date changeDate = new Date((dcBirthdayMember.getDate().getTime()));
            userRequest.setBirthday(changeDate);
            try {
                userRequest.setSex(rdoMale.isSelected());
            } catch (Exception e) {
                userRequest.setSex(rdoFemale.isSelected());
            }
            userRequest.setScore(cboRateMember.getSelectedIndex());
            userService.save(userRequest, "Thành viên");
                System.out.println("Luu thanh cong");
//        }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteMemBerToForm(JTextField idField){
        try {
            Integer idMemberDelete = Integer.valueOf(idField.getText());
            userService.delete(idMemberDelete);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
//    public static void main(String[] args) {
//        UserController controller = new UserController();
//    }
}
