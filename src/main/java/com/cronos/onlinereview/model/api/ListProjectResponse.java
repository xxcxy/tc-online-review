package com.cronos.onlinereview.model.api;

import com.topcoder.management.deliverable.Deliverable;
import com.topcoder.management.project.Project;
import com.topcoder.management.project.ProjectCategory;
import com.topcoder.management.project.ProjectType;
import com.topcoder.project.phases.Phase;

import java.util.Date;

public class ListProjectResponse {
    private ProjectType[] projectTypes;
    private ProjectCategory[] projectCategories;
    private Deliverable[] allMyDeliverables;
    private Project[][] projects;
    private Phase[][][] phases;
    private Date[][] phaseEndDates;
    private Date[][] projectEndDates;
    private int[] typeCounts;
    private int[] categoryCounts;
    private int totalProjectsCount;
    private String[][] myRoles;

    public ProjectType[] getProjectTypes() {
        return projectTypes;
    }

    public ProjectCategory[] getProjectCategories() {
        return projectCategories;
    }

    public Deliverable[] getAllMyDeliverables() {
        return allMyDeliverables;
    }

    public Project[][] getProjects() {
        return projects;
    }

    public Phase[][][] getPhases() {
        return phases;
    }

    public Date[][] getPhaseEndDates() {
        return phaseEndDates;
    }

    public Date[][] getProjectEndDates() {
        return projectEndDates;
    }

    public int[] getTypeCounts() {
        return typeCounts;
    }

    public int[] getCategoryCounts() {
        return categoryCounts;
    }

    public int getTotalProjectsCount() {
        return totalProjectsCount;
    }

    public String[][] getMyRoles() {
        return myRoles;
    }

    public void setProjectTypes(ProjectType[] projectTypes) {
        this.projectTypes = projectTypes;
    }

    public void setProjectCategories(ProjectCategory[] projectCategories) {
        this.projectCategories = projectCategories;
    }

    public void setAllMyDeliverables(Deliverable[] allMyDeliverables) {
        this.allMyDeliverables = allMyDeliverables;
    }

    public void setProjects(Project[][] projects) {
        this.projects = projects;
    }

    public void setPhases(Phase[][][] phases) {
        this.phases = phases;
    }

    public void setPhaseEndDates(Date[][] phaseEndDates) {
        this.phaseEndDates = phaseEndDates;
    }

    public void setProjectEndDates(Date[][] projectEndDates) {
        this.projectEndDates = projectEndDates;
    }

    public void setTypeCounts(int[] typeCounts) {
        this.typeCounts = typeCounts;
    }

    public void setCategoryCounts(int[] categoryCounts) {
        this.categoryCounts = categoryCounts;
    }

    public void setTotalProjectsCount(int totalProjectsCount) {
        this.totalProjectsCount = totalProjectsCount;
    }

    public void setMyRoles(String[][] myRoles) {
        this.myRoles = myRoles;
    }
}
