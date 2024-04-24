package com.touristagencysystem.presentation.gui.abstracts;
import com.touristagencysystem.core.Config;
import javax.swing.*;
import javax.swing.table.TableColumn;

public abstract class Layout extends JFrame {
    public void setGUILayout(int width,int height){
        setSize(width,height);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITLE);
        setVisible(true);
    }
}
