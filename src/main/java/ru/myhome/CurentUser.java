package ru.myhome;

import java.util.List;

import ru.myhome.model.Person;
import ru.myhome.model.Workday;

public class CurentUser {

	private static Person person;
		
	public static Person get() {
		return person;
	}
	public static void set(Person p) {
		person = p;
	}
	public static int getId() {
		return person.getId();
	}
	
	public static String getFirstName() {
		return person.getFirstName();
	}

	public static String getLastName() {
		return person.getLastName();
	}

	public static String getPhone() {
		return person.getPhone();
	}

	public static int getRate() {
		return person.getRate();
	}

	public static List<Workday> getWorkdays() {
		return person.getWorkdays();
	}
	
	private CurentUser() {
	}
}
