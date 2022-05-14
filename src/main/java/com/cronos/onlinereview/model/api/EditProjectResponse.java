package com.cronos.onlinereview.model.api;

import com.cronos.onlinereview.model.ClientProject;
import com.cronos.onlinereview.model.CockpitProject;
import com.cronos.onlinereview.model.DefaultScorecard;
import com.cronos.onlinereview.model.PhaseGroup;
import com.topcoder.management.payment.ProjectPayment;
import com.topcoder.management.project.Project;
import com.topcoder.management.project.ProjectCategory;
import com.topcoder.management.project.ProjectStatus;
import com.topcoder.management.project.ProjectType;
import com.topcoder.management.resource.ResourceRole;
import com.topcoder.management.scorecard.data.Scorecard;
import com.topcoder.project.phases.PhaseType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class EditProjectResponse {
    private Boolean arePhaseDependenciesEditable;
    private Boolean newProject;
    private Boolean isAdmin;
    private ProjectStatus[] projectStatuses;
    private ProjectType[] projectTypes;
    private ProjectCategory[] projectCategories;
    private Project project;
    private Map<String, String> modelValues;
    private Map<String, ArrayList<String>> modelArrayValues;
    private ResourceRole[] resourceRoles;
    private Set<String> disabledResourceRoles;
    private List<ResourceRole> allowedResourceRoles;
    private PhaseType[] phaseTypes;
    private Scorecard[] screeningScorecards;
    private Scorecard[] reviewScorecards;
    private Scorecard[] approvalScorecards;
    private Scorecard[] postMortemScorecards;
    private Scorecard[] specificationReviewScorecards;
    private Scorecard[] checkpointScreeningScorecards;
    private Scorecard[] checkpointReviewScorecards;
    private Scorecard[] iterativeReviewScorecards;
    private List<DefaultScorecard> defaultScorecards;
    private List<String> phaseTemplateNames;
    private Map<Integer, Boolean> trueSubmitters;
    private Map<Integer, Boolean> trueReviewers;
    private Map<Long, Boolean> resourcePaid;
    private int[] phaseGroupIndexes;
    private PhaseGroup[] phaseGroups;
    private Integer activeTabIdx;
    private Boolean isManager;
    private Boolean isAllowedToPerformScreening;
    private Boolean isAllowedToPerformCheckpointScreening;
    private Boolean isAllowedToPerformCheckpointReview;
    private Boolean isAllowedToViewScreening;
    private Boolean isAllowedToViewCheckpointScreening;
    private Boolean isAllowedToViewCheckpointReview;
    private Boolean isAllowedToUploadTC;
    private Boolean isAllowedToPerformAggregation;
    private Boolean isAllowedToPerformAggregationReview;
    private Boolean isAllowedToUploadFF;
    private Boolean isAllowedToPerformFinalReview;
    private Boolean isAllowedToPerformApproval;
    private Boolean isAllowedToPerformPortMortemReview;
    private Boolean canEditContestPrize;
    private Boolean canEditCheckpointPrize;
    private Boolean allowCockpitProjectEdit;
    private Boolean allowBillingEdit;
    private List<ProjectPayment> allPayments;
    private List<ClientProject> billingProjects;
    private List<CockpitProject> cockpitProjects;

    public void set(String key, Object value) {
        if (modelValues == null) {
            modelValues = new HashMap<>();
        }
        if (value != null) {
            modelValues.put(key, value.toString());
        }
    }

    public void set(String key, int index, Object value) {
        if (modelArrayValues == null) {
            modelArrayValues = new HashMap<>();
        }
        if (!modelArrayValues.containsKey(key)) {
            modelArrayValues.put(key, new ArrayList<>());
        }
        if (value != null) {
            if (index > modelArrayValues.get(key).size()) {
                modelArrayValues.get(key).add(value.toString());
            } else {
                modelArrayValues.get(key).add(index, value.toString());
            }
        }
    }

    public void setArePhaseDependenciesEditable(Boolean arePhaseDependenciesEditable) {
        this.arePhaseDependenciesEditable = arePhaseDependenciesEditable;
    }

    public void setNewProject(Boolean newProject) {
        this.newProject = newProject;
    }

    public void setIsAdmin(Boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public void setProjectStatuses(ProjectStatus[] projectStatuses) {
        this.projectStatuses = projectStatuses;
    }

    public void setProjectTypes(ProjectType[] projectTypes) {
        this.projectTypes = projectTypes;
    }

    public void setProjectCategories(ProjectCategory[] projectCategories) {
        this.projectCategories = projectCategories;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public void setModelValues(Map<String, String> modelValues) {
        this.modelValues = modelValues;
    }

    public void setModelArrayValues(Map<String, ArrayList<String>> modelArrayValues) {
        this.modelArrayValues = modelArrayValues;
    }

    public void setResourceRoles(ResourceRole[] resourceRoles) {
        this.resourceRoles = resourceRoles;
    }

    public void setDisabledResourceRoles(Set<String> disabledResourceRoles) {
        this.disabledResourceRoles = disabledResourceRoles;
    }

    public void setAllowedResourceRoles(List<ResourceRole> allowedResourceRoles) {
        this.allowedResourceRoles = allowedResourceRoles;
    }

    public void setPhaseTypes(PhaseType[] phaseTypes) {
        this.phaseTypes = phaseTypes;
    }

    public void setScreeningScorecards(Scorecard[] screeningScorecards) {
        this.screeningScorecards = screeningScorecards;
    }

    public void setReviewScorecards(Scorecard[] reviewScorecards) {
        this.reviewScorecards = reviewScorecards;
    }

    public void setApprovalScorecards(Scorecard[] approvalScorecards) {
        this.approvalScorecards = approvalScorecards;
    }

    public void setPostMortemScorecards(Scorecard[] postMortemScorecards) {
        this.postMortemScorecards = postMortemScorecards;
    }

    public void setSpecificationReviewScorecards(Scorecard[] specificationReviewScorecards) {
        this.specificationReviewScorecards = specificationReviewScorecards;
    }

    public void setCheckpointScreeningScorecards(Scorecard[] checkpointScreeningScorecards) {
        this.checkpointScreeningScorecards = checkpointScreeningScorecards;
    }

    public void setCheckpointReviewScorecards(Scorecard[] checkpointReviewScorecards) {
        this.checkpointReviewScorecards = checkpointReviewScorecards;
    }

    public void setIterativeReviewScorecards(Scorecard[] iterativeReviewScorecards) {
        this.iterativeReviewScorecards = iterativeReviewScorecards;
    }

    public void setDefaultScorecards(List<DefaultScorecard> defaultScorecards) {
        this.defaultScorecards = defaultScorecards;
    }

    public void setPhaseTemplateNames(List<String> phaseTemplateNames) {
        this.phaseTemplateNames = phaseTemplateNames;
    }

    public void setTrueSubmitters(Map<Integer, Boolean> trueSubmitters) {
        this.trueSubmitters = trueSubmitters;
    }

    public void setTrueReviewers(Map<Integer, Boolean> trueReviewers) {
        this.trueReviewers = trueReviewers;
    }

    public void setResourcePaid(Map<Long, Boolean> resourcePaid) {
        this.resourcePaid = resourcePaid;
    }

    public void setPhaseGroupIndexes(int[] phaseGroupIndexes) {
        this.phaseGroupIndexes = phaseGroupIndexes;
    }

    public void setPhaseGroups(PhaseGroup[] phaseGroups) {
        this.phaseGroups = phaseGroups;
    }

    public void setActiveTabIdx(Integer activeTabIdx) {
        this.activeTabIdx = activeTabIdx;
    }

    public void setIsManager(Boolean manager) {
        isManager = manager;
    }

    public void setIsAllowedToPerformScreening(Boolean allowedToPerformScreening) {
        isAllowedToPerformScreening = allowedToPerformScreening;
    }

    public void setIsAllowedToPerformCheckpointScreening(Boolean allowedToPerformCheckpointScreening) {
        isAllowedToPerformCheckpointScreening = allowedToPerformCheckpointScreening;
    }

    public void setIsAllowedToPerformCheckpointReview(Boolean allowedToPerformCheckpointReview) {
        isAllowedToPerformCheckpointReview = allowedToPerformCheckpointReview;
    }

    public void setIsAllowedToViewScreening(Boolean allowedToViewScreening) {
        isAllowedToViewScreening = allowedToViewScreening;
    }

    public void setIsAllowedToViewCheckpointScreening(Boolean allowedToViewCheckpointScreening) {
        isAllowedToViewCheckpointScreening = allowedToViewCheckpointScreening;
    }

    public void setIsAllowedToViewCheckpointReview(Boolean allowedToViewCheckpointReview) {
        isAllowedToViewCheckpointReview = allowedToViewCheckpointReview;
    }

    public void setIsAllowedToUploadTC(Boolean allowedToUploadTC) {
        isAllowedToUploadTC = allowedToUploadTC;
    }

    public void setIsAllowedToPerformAggregation(Boolean allowedToPerformAggregation) {
        isAllowedToPerformAggregation = allowedToPerformAggregation;
    }

    public void setIsAllowedToPerformAggregationReview(Boolean allowedToPerformAggregationReview) {
        isAllowedToPerformAggregationReview = allowedToPerformAggregationReview;
    }

    public void setIsAllowedToUploadFF(Boolean allowedToUploadFF) {
        isAllowedToUploadFF = allowedToUploadFF;
    }

    public void setIsAllowedToPerformFinalReview(Boolean allowedToPerformFinalReview) {
        isAllowedToPerformFinalReview = allowedToPerformFinalReview;
    }

    public void setIsAllowedToPerformApproval(Boolean allowedToPerformApproval) {
        isAllowedToPerformApproval = allowedToPerformApproval;
    }

    public void setIsAllowedToPerformPortMortemReview(Boolean allowedToPerformPortMortemReview) {
        isAllowedToPerformPortMortemReview = allowedToPerformPortMortemReview;
    }

    public void setCanEditContestPrize(Boolean canEditContestPrize) {
        this.canEditContestPrize = canEditContestPrize;
    }

    public void setCanEditCheckpointPrize(Boolean canEditCheckpointPrize) {
        this.canEditCheckpointPrize = canEditCheckpointPrize;
    }

    public void setAllowCockpitProjectEdit(Boolean allowCockpitProjectEdit) {
        this.allowCockpitProjectEdit = allowCockpitProjectEdit;
    }

    public void setAllowBillingEdit(Boolean allowBillingEdit) {
        this.allowBillingEdit = allowBillingEdit;
    }

    public void setAllPayments(List<ProjectPayment> allPayments) {
        this.allPayments = allPayments;
    }

    public void setBillingProjects(List<ClientProject> billingProjects) {
        this.billingProjects = billingProjects;
    }

    public void setCockpitProjects(List<CockpitProject> cockpitProjects) {
        this.cockpitProjects = cockpitProjects;
    }

    public Boolean getArePhaseDependenciesEditable() {
        return arePhaseDependenciesEditable;
    }

    public Boolean getNewProject() {
        return newProject;
    }

    public Boolean getAdmin() {
        return isAdmin;
    }

    public ProjectStatus[] getProjectStatuses() {
        return projectStatuses;
    }

    public ProjectType[] getProjectTypes() {
        return projectTypes;
    }

    public ProjectCategory[] getProjectCategories() {
        return projectCategories;
    }

    public Project getProject() {
        return project;
    }

    public Map<String, String> getModelValues() {
        return modelValues;
    }

    public Map<String, ArrayList<String>> getModelArrayValues() {
        return modelArrayValues;
    }

    public ResourceRole[] getResourceRoles() {
        return resourceRoles;
    }

    public Set<String> getDisabledResourceRoles() {
        return disabledResourceRoles;
    }

    public List<ResourceRole> getAllowedResourceRoles() {
        return allowedResourceRoles;
    }

    public PhaseType[] getPhaseTypes() {
        return phaseTypes;
    }

    public Scorecard[] getScreeningScorecards() {
        return screeningScorecards;
    }

    public Scorecard[] getReviewScorecards() {
        return reviewScorecards;
    }

    public Scorecard[] getApprovalScorecards() {
        return approvalScorecards;
    }

    public Scorecard[] getPostMortemScorecards() {
        return postMortemScorecards;
    }

    public Scorecard[] getSpecificationReviewScorecards() {
        return specificationReviewScorecards;
    }

    public Scorecard[] getCheckpointScreeningScorecards() {
        return checkpointScreeningScorecards;
    }

    public Scorecard[] getCheckpointReviewScorecards() {
        return checkpointReviewScorecards;
    }

    public Scorecard[] getIterativeReviewScorecards() {
        return iterativeReviewScorecards;
    }

    public List<DefaultScorecard> getDefaultScorecards() {
        return defaultScorecards;
    }

    public List<String> getPhaseTemplateNames() {
        return phaseTemplateNames;
    }

    public Map<Integer, Boolean> getTrueSubmitters() {
        return trueSubmitters;
    }

    public Map<Integer, Boolean> getTrueReviewers() {
        return trueReviewers;
    }

    public Map<Long, Boolean> getResourcePaid() {
        return resourcePaid;
    }

    public int[] getPhaseGroupIndexes() {
        return phaseGroupIndexes;
    }

    public PhaseGroup[] getPhaseGroups() {
        return phaseGroups;
    }

    public Integer getActiveTabIdx() {
        return activeTabIdx;
    }

    public Boolean getManager() {
        return isManager;
    }

    public Boolean getAllowedToPerformScreening() {
        return isAllowedToPerformScreening;
    }

    public Boolean getAllowedToPerformCheckpointScreening() {
        return isAllowedToPerformCheckpointScreening;
    }

    public Boolean getAllowedToPerformCheckpointReview() {
        return isAllowedToPerformCheckpointReview;
    }

    public Boolean getAllowedToViewScreening() {
        return isAllowedToViewScreening;
    }

    public Boolean getAllowedToViewCheckpointScreening() {
        return isAllowedToViewCheckpointScreening;
    }

    public Boolean getAllowedToViewCheckpointReview() {
        return isAllowedToViewCheckpointReview;
    }

    public Boolean getAllowedToUploadTC() {
        return isAllowedToUploadTC;
    }

    public Boolean getAllowedToPerformAggregation() {
        return isAllowedToPerformAggregation;
    }

    public Boolean getAllowedToPerformAggregationReview() {
        return isAllowedToPerformAggregationReview;
    }

    public Boolean getAllowedToUploadFF() {
        return isAllowedToUploadFF;
    }

    public Boolean getAllowedToPerformFinalReview() {
        return isAllowedToPerformFinalReview;
    }

    public Boolean getAllowedToPerformApproval() {
        return isAllowedToPerformApproval;
    }

    public Boolean getAllowedToPerformPortMortemReview() {
        return isAllowedToPerformPortMortemReview;
    }

    public Boolean getCanEditContestPrize() {
        return canEditContestPrize;
    }

    public Boolean getCanEditCheckpointPrize() {
        return canEditCheckpointPrize;
    }

    public Boolean getAllowCockpitProjectEdit() {
        return allowCockpitProjectEdit;
    }

    public Boolean getAllowBillingEdit() {
        return allowBillingEdit;
    }

    public List<ProjectPayment> getAllPayments() {
        return allPayments;
    }

    public List<ClientProject> getBillingProjects() {
        return billingProjects;
    }

    public List<CockpitProject> getCockpitProjects() {
        return cockpitProjects;
    }
}
