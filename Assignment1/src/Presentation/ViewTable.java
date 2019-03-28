package Presentation;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class ViewTable {
    private JFrame jFrame = new JFrame("View All");
    private JPanel jPanel = new JPanel();
    private DefaultTableModel model;
    private JTable jTable;
    private List<Object> objects;
    private List<String> columns;
    private int colCount;


    public ViewTable(List<Object> objects, int colCount) {
        this.objects = objects;
        this.colCount = colCount;
        jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.Y_AXIS));
        model = new DefaultTableModel(0, colCount);
        jTable = new JTable(model);
        setTable();
        jPanel.add(new JScrollPane(jTable));
        jFrame.add(jPanel);
        jFrame.setVisible(true);
        jFrame.pack();
    }


    private void addElement(Object object) {
        Object[] element = new Object[colCount];
        int i = -1;
        for (Field field : object.getClass().getDeclaredFields()) {
            try {
                field.setAccessible(true);
                Object val = field.get(object);
                i ++;
                element[i] = val;

            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        model.addRow(element);
    }




    public void setTable() {
        for (int i = model.getRowCount() - 1; i >= 0; i --) {
            model.removeRow(i);
        }
        Object object;
        if (!objects.isEmpty()) {
            object = objects.get(0);
        } else return;
        columns = new ArrayList<>();
        for (Field field : object.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            columns.add(field.getName());
        }
        for (int i = 0; i < colCount; i ++) {
            jTable.getTableHeader().getColumnModel().getColumn(i).setHeaderValue(columns.get(i));
        }
        objects.forEach(this::addElement);
    }
}
