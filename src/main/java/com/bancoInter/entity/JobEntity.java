package com.bancoInter.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name= "JOB")
public class JobEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="ID")
	@GeneratedValue
	private Long id ;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="ACTIVE")
	private boolean active;
	
	@OneToMany(mappedBy = "JOB", targetEntity = ParentJobEntity.class, fetch = FetchType.LAZY)
	private List<ParentJobEntity> parentJobs;
	
	@OneToMany(mappedBy = "JOB", targetEntity = TaskEntity.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<TaskEntity> tasks;
	
//constructor
	public JobEntity(Long id, String name, boolean active, List<ParentJobEntity> parentJobs, List<TaskEntity> tasks) {
		super();
		this.id = id;
		this.name = name;
		this.active = active;
		this.parentJobs = parentJobs;
		this.tasks = tasks;
	}
	
	public JobEntity() {
		super();
	}

//gets e sets
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

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public List<ParentJobEntity> getParentJobs() {
		return parentJobs;
	}

	public void setParentJobs(List<ParentJobEntity> parentJobs) {
		this.parentJobs = parentJobs;
	}

	public List<TaskEntity> getTasks() {
		return tasks;
	}

	public void setTasks(List<TaskEntity> tasks) {
		this.tasks = tasks;
	}

//hashcode e equals
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (active ? 1231 : 1237);
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((parentJobs == null) ? 0 : parentJobs.hashCode());
		result = prime * result + ((tasks == null) ? 0 : tasks.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		JobEntity other = (JobEntity) obj;
		if (active != other.active)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (parentJobs == null) {
			if (other.parentJobs != null)
				return false;
		} else if (!parentJobs.equals(other.parentJobs))
			return false;
		if (tasks == null) {
			if (other.tasks != null)
				return false;
		} else if (!tasks.equals(other.tasks))
			return false;
		return true;
	}
}
