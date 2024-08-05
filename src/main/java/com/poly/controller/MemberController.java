package com.poly.controller;

import com.poly.constant.RoleConstant;
import com.poly.entity.User;
import com.poly.injection.MemberInjector;
import com.poly.services.MemberService;
import com.poly.utils.IOExcells;
import com.poly.utils.MsgBox;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MemberController {

    private final MemberService memberService = MemberInjector.getInstance().getMemberService();

    // CRUD operations
    public User createUser(User user, String roleName) {
        return memberService.save(user, roleName);
    }

    public User readUser(Integer id) {
        return memberService.findById(id);
    }

    public User updateUser(User user) {
        return memberService.update(user);
    }

    public User deleteUserById(Integer id) {
        return memberService.delete(id);
    }

    public User deleteUserByName(String name) {
        return memberService.findByFullname(name);
    }

    public List<User> getMembersByRole() {
            return memberService.findMembersByRole(RoleConstant.THANH_VIEN);
    }
    
    public void exportExcellAllMember(List<User> dataList){
        IOExcells.exportToExcelMember(dataList);
    }
    
    public List<User> importExcelMember() {
    List<User> savedUsers = new ArrayList<>();
    try {
        List<User> dataListFound = IOExcells.importToExcelMember();

        for (User entityExcelUser : dataListFound) {
            User savedUser = memberService.save(entityExcelUser, RoleConstant.THANH_VIEN);
            savedUsers.add(savedUser);
        }
    } catch (ParseException ex) {
        Logger.getLogger(MemberController.class.getName()).log(Level.SEVERE, "Error while importing members from Excel", ex);
        MsgBox.alert(null, "Lỗi khi nhập thành viên từ file Excel. Vui lòng kiểm tra lại.");
    }
    return savedUsers;
}

}
