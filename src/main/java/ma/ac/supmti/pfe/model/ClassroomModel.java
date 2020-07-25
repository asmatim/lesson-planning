package ma.ac.supmti.pfe.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name = "classroom")
public class ClassroomModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private String name;
	
	@Column
	private Integer capacity;
	
	@OneToMany(mappedBy = "classroom", fetch = FetchType.LAZY)
	private List<LessonModel> lessons;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCapacity() {
		return capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

	public List<LessonModel> getLessons() {
		return lessons;
	}

	public void setLessons(List<LessonModel> lessons) {
		this.lessons = lessons;
	}

}
