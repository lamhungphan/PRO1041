/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.poly.controller;

import com.poly.entity.Event;
import com.poly.entity.User;
import com.poly.injection.EventInjector;
import com.poly.injection.UserInjector;
import com.poly.services.EventService;
import com.poly.services.UserService;
import com.poly.utils.ComponentManagement;
import com.poly.utils.InputFields;
import com.poly.utils.MsgBox;
import com.toedter.calendar.JDateChooser;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Computer
 */
public class EventController {
<<<<<<< HEAD
     EventService eventService = EventInjector.getInstance().getEventService();
=======
>>>>>>> 472f6e34b1cfe68108d989a524619abb71b83b4d

    EventService eventService = EventInjector.getInstance().getEventService();
    UserService userService = UserInjector.getInstance().getUserService();
    private List<Event> listAllEvent = getAllEvents();
    private final String[] GET_METHOD_NAME_EVENT = {"getId", "getUser", "getTitle", "getContent", "getStartedDate", "getEndedDate", "getLocation"};

    public void createEvent(Event event, String nameUserManager) {
        Event createdEvent = eventService.save(event, nameUserManager);
        if (createdEvent != null) {
            MsgBox.alert(null, "Tạo sự kiện thành công!");
        } else {
            MsgBox.alert(null, "Không thể tạo sự kiện.");
        }
    }

    public Event readEvent(Integer id) {
        return eventService.findById(id);
    }

    public void updateEvent(Event event) {
        Event updatedEvent = eventService.update(event);
        if (updatedEvent != null) {
            MsgBox.alert(null, "Cập nhật sự kiện thành công!");
        } else {
            MsgBox.alert(null, "Không thể cập nhật sự kiện.");
        }
    }

    public void deleteEvent(Integer id) {
        Event deletedEvent = eventService.delete(id);
        if (deletedEvent != null) {
            MsgBox.alert(null, "Xóa sự kiện thành công!");
        } else {
            MsgBox.alert(null, "Không thể xóa sự kiện.");
        }
    }

    public List<Event> getAllEvents() {
        return eventService.findAll();
    }

    public void setAllDataUserToTable(JTable tblListEvent) {
        List<Event> listEvent = new ArrayList<>();
        for (Event event : listAllEvent) {
            listEvent.add(event);
        }
//    ComponentManagement.fillDataTableComponent (getAllEvents(), tblListEvent, GET_METHOD_NAME_EVENT);
        fillTableEvent(tblListEvent, listEvent);
    }
    
    private void fillTableEvent(JTable tblListEvent, List<Event> eventTo) {
        DefaultTableModel model = (DefaultTableModel) tblListEvent.getModel();
        model.setRowCount(0);
        try {
            for (Event entity : eventTo) {
                Object[] row = {
                    entity.getId(),
                    entity.getUser().getFullname(),
                    entity.getTitle(),
                    entity.getContent(),
                    entity.getStartedDate(),
                    entity.getEndedDate(),
                    entity.getLocation()
                };
                model.addRow(row);
            }
        } 
        catch (Exception e) {
            MsgBox.alert(null, "Lỗi truy vấn dữ liệu!");
        }
    }
    
    public void createEventToForm(
            JTextField txtIdEvent,
            JTextField txtUserIdEvent,
            JTextField txtTitleEvent,
            JTextField txtAddressEvent,
            JDateChooser dcStartedDateEvent,
            JDateChooser dcEndedDateEvent,
            JTextArea txtContentEvent){
        try {
            Event eventRequest = new Event();
            User userRequest = new User();
            userRequest.setId(Integer.valueOf(txtUserIdEvent.getText()));
            System.out.println("Qua duoc chua ?");
            eventRequest.setUser(userRequest);
            eventRequest.setTitle(InputFields.getTextFieldtoString(txtTitleEvent));
            eventRequest.setLocation(InputFields.getTextFieldtoString(txtAddressEvent));
            eventRequest.setStartedDate(InputFields.getDateSQL(dcStartedDateEvent.getDate()));
            eventRequest.setEndedDate(InputFields.getDateSQL(dcEndedDateEvent.getDate()));
            eventRequest.setContent(InputFields.getTextAreatoString(txtContentEvent));
            eventService.save(eventRequest, "haithach");
            MsgBox.alert(null, "Tạo Mới Thành Công!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void findEventToTableClicked(
            JTable tblListEvent,
            Integer row,
            JTextField txtIdEvent,
            JTextField txtUserIdEvent,
            JTextField txtTitleEvent,
            JTextField txtAddressEvent,
            JDateChooser dcStartedDateEvent,
            JDateChooser dcEndedDateEvent,
            JTextArea txtContentEvent) {
        String idFound = String.valueOf(tblListEvent.getValueAt(row, 0));
        Event eventFindOut = eventService.findById(Integer.valueOf(idFound));
        setTextFromTableToForm(eventFindOut, txtIdEvent, txtUserIdEvent, txtTitleEvent, txtAddressEvent, dcStartedDateEvent, dcEndedDateEvent, txtContentEvent);
    }
    
    public void setTextFromTableToForm(
            Event eventResponse,
            JTextField txtIdEvent,
            JTextField txtUserIdEvent,
            JTextField txtTitleEvent,
            JTextField txtAddressEvent,
            JDateChooser dcStartedDateEvent,
            JDateChooser dcEndedDateEvent,
            JTextArea txtContentEvent) {
        txtIdEvent.setText(String.valueOf(eventResponse.getId()));
        txtUserIdEvent.setText(String.valueOf(eventResponse.getUser().getId()));
        txtTitleEvent.setText(eventResponse.getTitle());
        txtContentEvent.setText(eventResponse.getContent());
        txtAddressEvent.setText(eventResponse.getLocation());
        dcStartedDateEvent.setDate(eventResponse.getStartedDate());
        dcEndedDateEvent.setDate(eventResponse.getEndedDate());
    }
    
    public void setClearForm(
            JTextField txtIdEvent,
            JTextField txtUserIdEvent,
            JTextField txtTitleEvent,
            JTextField txtAddressEvent,
            JDateChooser dcStartedDateEvent,
            JDateChooser dcEndedDateEvent,
            JTextArea txtContentEvent) {
        txtIdEvent.setText("");
        txtUserIdEvent.setText("");
        txtTitleEvent.setText("");
        txtAddressEvent.setText("");
        txtContentEvent.setText("");
        dcStartedDateEvent.setDate(null);
        dcEndedDateEvent.setDate(null);
    }
    
    public void deleteEventToForm(JTextField txtIdEvent) {
        try {
            eventService.delete(InputFields.getTextFieldtoInteger(txtIdEvent));
            MsgBox.alert(null, "Xoá Thành Công!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void updateEventToForm(
            JTextField txtIdEvent,
            JTextField txtUserIdEvent,
            JTextField txtTitleEvent,
            JTextField txtAddressEvent,
            JDateChooser dcStartedDateEvent,
            JDateChooser dcEndedDateEvent,
            JTextArea txtContentEvent){
        try {
            User userRequest = new User();
            userRequest.setId(InputFields.getTextFieldtoInteger(txtUserIdEvent));
            Event eventRequest = new Event();
            eventRequest.setId(InputFields.getTextFieldtoInteger(txtIdEvent));
            eventRequest.setUser(userRequest);
            eventRequest.setTitle(InputFields.getTextFieldtoString(txtTitleEvent));
            eventRequest.setContent(InputFields.getTextAreatoString(txtContentEvent));
            eventRequest.setStartedDate(InputFields.getDateSQL(dcStartedDateEvent.getDate()));
            eventRequest.setEndedDate(InputFields.getDateSQL(dcEndedDateEvent.getDate()));
            eventRequest.setLocation(InputFields.getTextFieldtoString(txtAddressEvent));
            eventService.update(eventRequest);
            MsgBox.alert(null, "Cập nhật Thành Công!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
