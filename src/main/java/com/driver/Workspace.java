package com.driver;

import org.apache.commons.lang3.tuple.Pair;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Workspace extends Gmail{

    private ArrayList<Meeting> calendar; // Stores all the meetings

    public Workspace(String emailId) {
        // The inboxCapacity is equal to the maximum value an integer can store.

super(emailId,Integer.MAX_VALUE);
calendar=new ArrayList<>();

    }

    public void addMeeting(Meeting meeting){
        //add the meeting to calendar
calendar.add(meeting);
    }

    public int findMaxMeetings(){

        ArrayList<Meeting> m = new ArrayList<>();
        LocalTime time_limit ;


        // sorting using compartor class and without (compartor or comparable class)
        //  mycomparator mc = new mycomparator();
        //  Collections.sort(calendar,mc);
        Collections.sort(calendar,(m1,m2)->{
            return m1.getEndTime().compareTo(m2.getEndTime());
        });

        // Initially select first meeting.
        Meeting meet = calendar.get(0);
        m.add(meet);
        // time_limit to check whether new
        // meeting can be conducted or not.
        time_limit = calendar.get(0).getEndTime();

        // Check for all meeting whether it
        // can be selected or not.
        for (int i = 1; i < calendar.size(); i++) {
            if (calendar.get(i).getStartTime().compareTo(time_limit)>0) {

                // Add selected meeting to arraylist
                m.add(calendar.get(i));

                // Update time limit
                time_limit = calendar.get(i).getEndTime();
            }
        }

        return m.size();
    }
    static class mycomparator implements Comparator<Meeting>{
        @Override
        public int compare(Meeting m1,Meeting m2){
            if(m1.getStartTime().compareTo(m2.getEndTime())<0){
                return -1;
            }
            else if(m1.getEndTime().compareTo(m2.getEndTime())>0){
                return 1;
            }
            return 0;
        }
    }
}
