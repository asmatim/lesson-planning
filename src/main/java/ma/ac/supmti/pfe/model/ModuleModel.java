package ma.ac.supmti.pfe.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity(name = "module")
public class ModuleModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false)
	private String name;

	@ManyToOne
	private BranchModel branch;

	@OneToMany(mappedBy = "module", fetch = FetchType.LAZY)
	private List<SubjectModel> subjects;

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

	public BranchModel getBranch() {
		return branch;
	}

	public void setBranch(BranchModel branch) {
		this.branch = branch;
	}

	public List<SubjectModel> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<SubjectModel> subjects) {
		this.subjects = subjects;
	}
	
}
