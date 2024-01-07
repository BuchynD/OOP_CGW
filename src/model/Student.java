package model;

import java.time.LocalDate;

import view.DlgStudent;
import view.IDlg;

public class Student extends AnyData {
	private float avgScore;
	private LocalDate birthDate;
	
	public Student(String name, float avgScore,
			LocalDate birthDate) {
		this.name = name;
		this.avgScore = avgScore;
		this.birthDate = birthDate;
	}

	public float getAvgScore() {
		return avgScore;
	}

	public void setAvgScore(float avgScore) {
		this.avgScore = avgScore;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public IDlg getDialog() {
		return new DlgStudent();
	}

	@Override
	public IDlg getSonDialog() {
		// TODO Auto-generated method stub
		return null;
	}
}
