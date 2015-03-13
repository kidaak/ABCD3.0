package cu.uci.abcd.domain.common;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import cu.uci.abcd.domain.management.library.Worker;

@Entity
@Table(name = "dperson", schema = "abcd")
@PrimaryKeyJoinColumn(name = "person_id")
@DiscriminatorValue(value = "PERSON")
@Inheritance(strategy = InheritanceType.JOINED)
public class Person extends TangibleActor {
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	@Column(name = "birth_date")
	private Date birthDate;
	@Column(name = "dni")
	private String DNI;
	@Column(name = "gender")
	@Enumerated(EnumType.STRING)
	private Gender gender;
	@Column(name = "nationality")
	private String nationality;
	@OneToMany(mappedBy = "personWorker", cascade = CascadeType.ALL)
	private List<Worker> workerRole;

	public Person() {
		super();
		workerRole = new ArrayList<>();
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public List<Worker> getWorkerRole() {
		return workerRole;
	}

	public void setWorkerRole(List<Worker> workerRole) {
		this.workerRole = workerRole;
	}

}
