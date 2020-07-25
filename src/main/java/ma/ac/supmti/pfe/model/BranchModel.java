package ma.ac.supmti.pfe.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name = "branch")
public class BranchModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false)
	private String name;

	@OneToMany(mappedBy = "branch", fetch = FetchType.LAZY)
	private List<ClassModel> classes;

	@OneToMany(mappedBy = "branch", fetch = FetchType.LAZY)
	private List<ModuleModel> modules;

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

	public List<ClassModel> getClasses() {
		return classes;
	}

	public void setClasses(List<ClassModel> classes) {
		this.classes = classes;
	}

	public List<ModuleModel> getModules() {
		return modules;
	}

	public void setModules(List<ModuleModel> modules) {
		this.modules = modules;
	}

}
