/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package digitaldiary;

import java.awt.Color;
import java.awt.Component;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author aks
 */
class TableCellRenderer extends DefaultTableCellRenderer
{
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,boolean selected, boolean focused, int row, int column)
    {
        super.getTableCellRendererComponent(table, value, selected, focused, row, column);
        if(column==0 ||  column==6)
        {
            setBackground(new Color(255,220,220));
        }
        else
        {
            setBackground(new Color(255, 255, 255));
        }
        if(value!=null)
        {
            if(Integer.parseInt(value.toString())== CalUI.realDay && CalUI.currentMonth == CalUI.realMonth && CalUI.currentYear == CalUI.realYear)
            {
                setBackground(new Color(220,220,255));
            }
            else if((new File("specialEventsLog.dat")).exists() || true)
            {
                try
                {
                    BufferedReader br=new BufferedReader(new FileReader("specialEventsLog.dat"));
                    String str="";
                    while((str=br.readLine())!=null)
                    {
                        String date=str.substring(str.lastIndexOf("#")+1, str.lastIndexOf("*")).trim();
                        String month=str.substring(str.lastIndexOf("*")+1, str.lastIndexOf("~")).trim();
                        String year=str.substring(str.lastIndexOf("~")+1, str.lastIndexOf(".")).trim();
                        int d=Integer.parseInt(date);
                        int m=Integer.parseInt(month);
                        int y=Integer.parseInt(year);
                        if(Integer.parseInt(value.toString())== d && CalUI.currentMonth == m && CalUI.currentYear == y)
                        {
                            System.out.println(""+Integer.parseInt(value.toString())+" "+d);
                            System.out.println(""+CalUI.currentMonth+" "+m);
                            System.out.println(""+CalUI.currentYear+" "+y);
                            setBackground(new Color(144,246,139));
                        }
                    }
                }catch(Exception e){
                    
                }
            }
        }
        setBorder(null);
        setForeground(Color.black);
        return this;
    }
}
 