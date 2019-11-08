package ru.job4j.pojo;

public class College {
	public static void main(String[] args) {
		Student student = new Student();
		student.setFio("Иванов Иван Иванович");
		student.setGroup("ООП2019");
		student.setEntryDate("08.11.2019");

		System.out.println("Студент " + student.getFio() + " зачислен в группу " + student.getGroup() + ". " + student.getEntryDate());
	}
}
