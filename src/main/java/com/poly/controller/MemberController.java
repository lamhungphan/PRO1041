package com.poly.controller;

import com.poly.constant.RoleConstant;
import com.poly.entity.User;
import com.poly.injection.MemberInjector;
import com.poly.services.MemberService;
import com.poly.utils.IOExcells;
import com.poly.utils.MsgBox;
import java.util.ArrayList;
import java.util.List;

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
    
    
}
