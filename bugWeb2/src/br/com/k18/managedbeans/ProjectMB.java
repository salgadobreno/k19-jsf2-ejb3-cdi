package br.com.k18.managedbeans;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.k18.entities.Project;
import br.com.k18.sessionbeans.ProjectRepository;

@Named
@RequestScoped
public class ProjectMB {
	
	@Inject
	private ProjectRepository projectRepository;
	
	private Project project = new Project();
	
	private List<Project> projects;
	
	public void save(){
		if (this.getProject().getId() == null){
			this.projectRepository.add(this.getProject());
		} else {
			this.projectRepository.edit(this.getProject());
		}
		this.project = new Project();
		this.setProjects(null);
	}
	
	public void delete(Long id){
		this.projectRepository.removeById(id);
		this.setProjects(null);
	}
	
	public void prepareEdit(Long id){
		this.project = this.projectRepository.findById(id);
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public List<Project> getProjects() {
		if (this.projects == null) {
			this.projects = this.projectRepository.findAll();
		}
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}
	
	

}
