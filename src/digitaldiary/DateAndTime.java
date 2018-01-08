/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package digitaldiary;

/**
 *
 * @author surbhit
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;
public class DateAndTime
{
     String stringTime;
     int hour, minute, second;
     String hHour = "";
     String mMinute = "";
     String sSecond = ""; 
     int date;
     int month;
     String mnth;
     public void setStringTime(String time)
     {
       stringTime = time;
     } 
     DateAndTime()
     {
         Timer t=new Timer(1000, new ActionListener()
         {
              @Override
             public void actionPerformed(ActionEvent e) 
             {
                 doit();
                
             }
         });
         t.start();
     }

    String getDay()
    {
        Calendar a=Calendar.getInstance();
        int dayN=a.get(Calendar.DAY_OF_WEEK);
         date=a.get(Calendar.DAY_OF_MONTH);
         month=a.get(Calendar.MONTH);
         
         switch(month)
         {
             case 0:mnth="Jan";
             break;
             case 1:mnth="Feb";
             break;
             case 2:mnth="Mar";
             break;
             case 3:mnth="Apr";
             break;
             case 4:mnth="May";
             break;
             case 5:mnth="Jun";
             break;
             case 6:mnth="Jul";
             break;
             case 7:mnth="Aug";
             break;
             case 8:mnth="Sept";
             break;
             case 9:mnth="Oct";
             break;
             case 10:mnth="Nov";
             break;
             case 11:mnth="Dec";
             break;
        }
         
         
       
        if(dayN==1)
            return "Sunday";
        else if(dayN==2)
            return "Monday";
        else if(dayN==3)
            return "Tuesday";
        else if(dayN==4)
            return "Wednesday";
        else if(dayN==5)
            return "Thursday";
        else if(dayN==6)
            return "Friday";
        else if(dayN==7)
            return "Saturday";
        else
            return "Something wrong";
    }
    void doit()
    {
         Calendar rite = Calendar.getInstance();
          hour = rite.get(Calendar.HOUR_OF_DAY);
          minute = rite.get(Calendar.MINUTE);
          second = rite.get(Calendar.SECOND);
          if (hour < 10)
            {
              this.hHour = "0"; 
            } 
          if (hour >= 10)
            {
              this.hHour = "";
            } 
          if (minute < 10)
            {
              this.mMinute = "0";
            } 
          if (minute >= 10)
            {
              this.mMinute = "";
            }
          if (second < 10)
            {
              this.sSecond = "0";
            }
          if (second >= 10)
            {
              this.sSecond = "";
            } 
          String d=getDay()+" "+mnth+" "+date+", "+hHour + hour + ":" + mMinute+ minute + ":" + sSecond + second;
          
          NoteMaker.timeLabel.setText(d);
    }
}
