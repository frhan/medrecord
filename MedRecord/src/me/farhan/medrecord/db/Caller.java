package me.farhan.medrecord.db;


public class Caller 
{
	public Caller(int id,String name,String relation,String phone1,String phone2) 
	{
		this.id = id;
		this.name = name;
		this.relationship = relation;
		this.phone1 = phone1;
		this.phone2 = phone2;
	}
	public Caller(String name,String relation,String phone1,String phone2) 
	{
		this(-1,name,relation,phone1,phone2);
	}
	
	public Caller() 
	{
		this.id = -1;
		this.name = "";
		this.relationship = "";
		this.phone1 = "";
		this.phone2 = "";
		this.birthDay = "";	
	}
	
	public int id;
	public String name;
	public String relationship;
	public String birthDay;
	public String phone1;
	public String phone2;

}
