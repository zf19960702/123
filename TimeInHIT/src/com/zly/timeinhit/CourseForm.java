package com.zly.timeinhit;

public class CourseForm {
	String[] course;
	String[] courseList;
	public CourseForm()
	{
		course = new String[48];
        String[] week = {"Mon","Tue","Wed","Thu","Fri","Sat","Sun"};
        for(int i=0;i<=5;i++)
        {
        	course[8*i] = String.valueOf(i);
        	for(int j=1;j<=7;j++)
        	{
        		course[8*i+j] = "";
        	}
        }
        for(int i=0;i<7;i++)
        	course[i+1] = week[i];
        course[0] = "\\";
	}
	public String[] getCourseForm()
	{
		return course;
	}
	public void setCourse(int day,int time,String text)
	{
		course[8*time+day] = text;
	}
	public void setCourseList()
	{
		courseList = new String[] {"����","����","C����","Ӣ��","����","˼��"};
	}
	public String[] getCourseList()
	{
		return courseList;
	}
}
