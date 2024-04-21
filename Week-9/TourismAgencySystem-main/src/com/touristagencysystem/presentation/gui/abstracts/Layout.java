package com.touristagencysystem.presentation.gui.abstracts;
import com.touristagencysystem.core.Config;
import javax.swing.*;
import javax.swing.table.TableColumn;

public abstract class Layout extends JFrame {
    public void setGUILayout(int width,int height){
        setSize(width,height);
        setLocationRelativeTo(null);
        //setLocation(Helper.screenCenterPoint("x",getSize()),Helper.screenCenterPoint("y",getSize()));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITLE);
        //setResizable(false);
        setVisible(true);
    }

    /*public static void setJTableColumnsWidth(JTable table, int... tableWidths) {
        for (int i = 0; i < table.getColumnModel().getColumnCount(); i++) {
            TableColumn column = table.getColumnModel().getColumn(i);
            column.setPreferredWidth(tableWidths[i]);
        }
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
    }*/

}
