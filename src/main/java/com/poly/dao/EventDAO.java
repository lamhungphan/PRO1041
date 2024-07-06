/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.dao;

import com.poly.entity.Event;
import com.poly.utils.XJdbc;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author seastone01202
 */
public class EventDAO {

    private XJdbc databaseConnection;

    private static final String SELECT_ALL_EVENTS = "SELECT * FROM EVENTS";

    private static final String SELECT_BY_ID = "SELECT * FROM EVENTS WHERE USERID = ?";

    private static final String INSERT_EVENTS = "INSERT INTO EVENTS VALUES (?,?,?,?,?,?)";

    private static final String DELETE_EVENTS = "DELETE FROM EVENTS WHERE ID = ?";

    private static final String UPDATE_EVENTS = "UPDATE EVENTS SET USERID = ?, TITLE = ?, CONTENT = ?, STARTEDDATE = ?, ENDEDDATE = ?, ADDRESS = ? WHERE ID = ? ";

    public List<Event> selectAllEvent() {
        return selectAllBySQL(SELECT_ALL_EVENTS);
    }

    public List<Event> selectAllBySQL(String sql, Object... args) {
        List<Event> list = new ArrayList<>();
        ResultSet rs = null;
        try {
            rs = databaseConnection.query(sql, args);
            while (rs.next()) {
                Event entity = new Event();
                entity.setId(rs.getInt("ID"));
                entity.setAttendees(rs.getInt("USERID"));
                entity.setTitle(rs.getString("TITLE"));
                entity.setContent(rs.getString("CONTENT"));
                entity.setStartedDate(rs.getDate("STARTEDDATE"));
                entity.setEndedDate(rs.getDate("ENDEDDATE"));
                entity.setAddress(rs.getString("ADDRESS"));
                list.add(entity);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } finally {
            if (rs != null) {
                try {
                    rs.getStatement().getConnection().close();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
        return list;
    }

}
