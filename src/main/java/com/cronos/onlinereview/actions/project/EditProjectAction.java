/*
 * Copyright (C) 2013 TopCoder Inc., All Rights Reserved.
 */
package com.cronos.onlinereview.actions.project;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import com.cronos.onlinereview.Constants;
import com.cronos.onlinereview.external.ExternalUser;
import com.cronos.onlinereview.model.ClientProject;
import com.cronos.onlinereview.model.CockpitProject;
import com.cronos.onlinereview.model.api.EditProjectResponse;
import com.cronos.onlinereview.model.api.ListProjectResponse;
import com.cronos.onlinereview.util.ActionsHelper;
import com.cronos.onlinereview.util.AuthorizationHelper;
import com.cronos.onlinereview.util.Comparators;
import com.cronos.onlinereview.util.ConfigHelper;
import com.cronos.onlinereview.util.CorrectnessCheckResult;
import com.cronos.onlinereview.util.LoggingHelper;
import com.cronos.onlinereview.util.LookupHelper;
import com.cronos.onlinereview.util.RestHelper;
import com.topcoder.management.phase.PhaseManager;
import com.topcoder.management.project.Prize;
import com.topcoder.management.project.PrizeType;
import com.topcoder.management.project.Project;
import com.topcoder.management.project.ProjectCategory;
import com.topcoder.management.resource.Resource;
import com.topcoder.management.resource.ResourceManager;
import com.topcoder.management.resource.search.ResourceFilterBuilder;
import com.topcoder.project.phases.Phase;
import com.topcoder.util.errorhandling.BaseException;
import org.apache.commons.lang3.StringUtils;

import static com.cronos.onlinereview.util.AuthorizationHelper.getLoggedInUserId;
import static com.cronos.onlinereview.util.RestHelper.REST_API_BASE_URL;
import static com.google.common.collect.Lists.newArrayList;


/**
 * This class is the struts action class which is used for rendering the editing existing project page.
 * <p>
 * Struts 2 Action objects are instantiated for each request, so there are no thread-safety issues.
 * </p>
 *
 * @author TCSASSEMBLER
 * @version 2.0
 */
public class EditProjectAction extends BaseProjectAction {
    /**
     * Represents the serial version id.
     */
    private static final long serialVersionUID = -2808910800788550966L;

    private String executeApi(String pid) {
        Set<String> roles = (Set<String>) request.getAttribute("roles");
        String role = "";
        if (roles != null) {
            role = StringUtils.join(roles, ",");
        }
        Map<String, String> param = new HashMap<>();
        param.put("userId", String.valueOf(getLoggedInUserId(request)));
        param.put("role", role);
        EditProjectResponse data = RestHelper.get(REST_API_BASE_URL + "/projects/" + pid, param, EditProjectResponse.class);

        // Place all collected data into the request as attributes
        request.setAttribute("arePhaseDependenciesEditable", data.getArePhaseDependenciesEditable());
        request.setAttribute("newProject", data.getNewProject());
        request.setAttribute("isAdmin", data.getAdmin());
        request.setAttribute("projectStatuses", data.getProjectStatuses());
        request.setAttribute("projectTypes", data.getProjectTypes());
        request.setAttribute("projectCategories", data.getProjectCategories());
        request.setAttribute("project", data.getProject());
        request.setAttribute("resourceRoles", data.getResourceRoles());
        request.setAttribute("disabledResourceRoles", data.getDisabledResourceRoles());
        request.setAttribute("allowedResourceRoles", data.getAllowedResourceRoles());
        request.setAttribute("phaseTypes", data.getPhaseTypes());
        request.setAttribute("screeningScorecards", data.getScreeningScorecards());
        request.setAttribute("reviewScorecards", data.getReviewScorecards());
        request.setAttribute("approvalScorecards", data.getApprovalScorecards());
        request.setAttribute("postMortemScorecards", data.getPostMortemScorecards());
        request.setAttribute("specificationReviewScorecards", data.getSpecificationReviewScorecards());
        request.setAttribute("checkpointScreeningScorecards", data.getCheckpointScreeningScorecards());
        request.setAttribute("checkpointReviewScorecards", data.getCheckpointReviewScorecards());
        request.setAttribute("iterativeReviewScorecards", data.getIterativeReviewScorecards());
        request.setAttribute("defaultScorecards", data.getDefaultScorecards());
        request.setAttribute("phaseTemplateNames", data.getPhaseTemplateNames());
        request.setAttribute("trueSubmitters", data.getTrueSubmitters());
        request.setAttribute("trueReviewers", data.getTrueReviewers());
        request.setAttribute("resourcePaid", data.getResourcePaid());
        request.setAttribute("phaseGroupIndexes", data.getPhaseGroupIndexes());
        request.setAttribute("phaseGroups", data.getPhaseGroups());
        request.setAttribute("activeTabIdx", data.getActiveTabIdx());
        request.setAttribute("isManager", data.getManager());
        request.setAttribute("isAllowedToPerformScreening", data.getAllowedToPerformScreening());
        request.setAttribute("isAllowedToPerformCheckpointScreening", data.getAllowedToPerformCheckpointScreening());
        request.setAttribute("isAllowedToPerformCheckpointReview", data.getAllowedToPerformCheckpointReview());
        request.setAttribute("isAllowedToViewScreening", data.getAllowedToViewScreening());
        request.setAttribute("isAllowedToViewCheckpointScreening", data.getAllowedToViewCheckpointScreening());
        request.setAttribute("isAllowedToViewCheckpointReview", data.getAllowedToViewCheckpointReview());
        request.setAttribute("isAllowedToUploadTC", data.getAllowedToUploadTC());
        request.setAttribute("isAllowedToPerformAggregation", data.getAllowedToPerformAggregation());
        request.setAttribute("isAllowedToPerformAggregationReview", data.getAllowedToPerformAggregationReview());
        request.setAttribute("isAllowedToUploadFF", data.getAllowedToUploadFF());
        request.setAttribute("isAllowedToPerformFinalReview", data.getAllowedToPerformFinalReview());
        request.setAttribute("canEditContestPrize", data.getCanEditContestPrize());
        request.setAttribute("isAllowedToPerformApproval", data.getAllowedToPerformApproval());
        request.setAttribute("isAllowedToPerformPortMortemReview", data.getAllowedToPerformPortMortemReview());
        request.setAttribute("canEditCheckpointPrize", data.getCanEditCheckpointPrize());
        request.setAttribute("allowCockpitProjectEdit", data.getAllowCockpitProjectEdit());
        request.setAttribute("allowBillingEdit", data.getAllowBillingEdit());
        request.setAttribute("allPayments", data.getAllPayments());
        request.setAttribute("billingProjects", data.getBillingProjects());
        request.setAttribute("cockpitProjects", data.getCockpitProjects());
        for (Map.Entry<String, String> kv: data.getModelValues().entrySet()) {
            setModelValue(kv.getKey(), kv.getValue());
        }
        for (Map.Entry<String, ArrayList<String>> kv: data.getModelArrayValues().entrySet()) {
            for (int i = 0; i < kv.getValue().size(); i++) {
                setModelValue(kv.getKey(), i + 1, kv.getValue().get(i));
            }
        }
        return Constants.SUCCESS_FORWARD_NAME;
    }

    /**
     * This method is an implementation of &quot;Edit Project&quot; Struts Action defined for this
     * assembly, which is supposed to fetch lists of project types and categories from the database
     * and pass it to the JSP page to use it for populating appropriate drop down lists. It is also
     * supposed to retrieve the project to be edited and to populate the form with appropriate
     * values.
     *
     * @return &quot;success&quot; result that forwards to the /jsp/editProject.jsp page (as
     *         defined in struts.xml file) in the case of successful processing,
     *         &quot;notAuthorized&quot; forward in the case of user not being authorized to perform
     *         the action.
     * @throws BaseException
     *             when any error happens while processing in TCS components.
     */
    public String execute() throws BaseException {
        LoggingHelper.logAction(request);

        // Verify that certain requirements are met before processing with the Action
        CorrectnessCheckResult verification = ActionsHelper.checkForCorrectProjectId(this, request,
                Constants.EDIT_PROJECT_DETAILS_PERM_NAME, false);

        // If any error has occurred, return action forward contained in the result bean
        if (!verification.isSuccessful()) {
            return verification.getResult();
        }

        if (ActionsHelper.usingApi(request)) {
            return executeApi(request.getParameter("pid"));
        }

        setEditProjectFormData(request, verification);

        // Populate the form with project properties
        populateProjectForm(request, verification.getProject());

        return Constants.SUCCESS_FORWARD_NAME;
    }

    /**
     * This method populates the specified LazyValidatorForm with the values
     * taken from the specified Project.
     *
     * @param request
     *            the request to be processed
     * @param project
     *            the project to take the data from
     * @throws BaseException if any error
     */
    @SuppressWarnings("unchecked")
    protected void populateProjectForm(HttpServletRequest request, Project project) throws BaseException {
        // Populate project id
        getModel().set("pid", project.getId());

        // Populate project name
        populateProjectFormProperty(String.class, "project_name", project, "Project Name");

        // Populate project type
        Long projectTypeId = project.getProjectCategory().getProjectType().getId();
        getModel().set("project_type", projectTypeId);

        // Populate project category
        Long projectCategoryId = project.getProjectCategory().getId();
        getModel().set("project_category", projectCategoryId);

        // Populate project category
        Long projectStatusId = project.getProjectStatus().getId();
        getModel().set("status", projectStatusId);

        // Populate project forum id
        populateProjectFormProperty(Long.class, "forum_id", project, "Developer Forum ID");

        // Populate project component id
        populateProjectFormProperty(Long.class, "component_id", project, "Component ID");
        // Populate project external reference id
        populateProjectFormProperty(Long.class, "external_reference_id", project, "External Reference ID");
        // Populate project dr points
        populateProjectFormProperty(Double.class, "dr_points", project, "DR points");

        // since Online Review Update - Add Project Dropdown v1.0
        // Populate project billing project
        populateProjectFormProperty(Long.class, "billing_project", project, "Billing Project");
        getModel().set("cockpit_project", project.getTcDirectProjectId());

        // Populate project autopilot option
        getModel().set("autopilot", "On".equals(project.getProperty("Autopilot Option")));
        // Populate project status notification option
        getModel().set("email_notifications", "On".equals(project.getProperty("Status Notification")));
        // Populate project timeline notification option
        getModel().set("timeline_notifications", "On".equals(project.getProperty("Timeline Notification")));
        // Populate project Digital Run option
        getModel().set("digital_run_flag", "On".equals(project.getProperty("Digital Run Flag")));
        // Populate project's 'do not rate this project' option
        // Note, this property is inverse by its meaning in project and form
        getModel().set("no_rate_project", !("Yes".equals(project.getProperty("Rated"))));

        // Populate project SVN module
        populateProjectFormProperty(String.class, "SVN_module", project, "SVN Module");
        // Populate project notes
        populateProjectFormProperty(String.class, "notes", project, "Notes");

        // Obtain Resource Manager instance
        ResourceManager resourceManager = ActionsHelper.createResourceManager();

        // Retrieve the list of the resources associated with the project
        Resource[] resources =
            resourceManager.searchResources(ResourceFilterBuilder.createProjectIdFilter(project.getId()));
        // Get an array of external users for the corresponding resources
        ExternalUser[] externalUsers =
            ActionsHelper.getExternalUsersForResources(ActionsHelper.createUserRetrieval(request), resources);

        // Populate form with resources data
        for (int i = 0; i < resources.length; ++i) {
            getModel().set("resources_id", i + 1, resources[i].getId());
            getModel().set("resources_action", i + 1, "update");

            getModel().set("resources_role", i + 1, resources[i].getResourceRole().getId());
            getModel().set("resources_phase", i + 1, "loaded_" + resources[i].getPhase());
            getModel().set("resources_name", i + 1, externalUsers[i].getHandle());
        }

        // Populate project prizes to form
        List<Prize> prizes = project.getPrizes();

        if (prizes != null) {
            PrizeType contestPrize = LookupHelper.getPrizeType(Constants.CONTEST_PRIZE_TYPE_NAME);
            PrizeType checkpointPrize = LookupHelper.getPrizeType(Constants.CHECKPOINT_PRIZE_TYPE_NAME);

            for (Prize prize : prizes) {
                if (prize.getPrizeType().getId() == contestPrize.getId()) {
                    getModel().set("contest_prizes_amount", prize.getPlace() - 1, String.valueOf(prize.getPrizeAmount()));
                    getModel().set("contest_prizes_num", prize.getPlace() - 1, prize.getNumberOfSubmissions());
                } else if (prize.getPrizeType().getId() == checkpointPrize.getId()) {
                    getModel().set("checkpoint_prizes_amount", prize.getPlace() - 1, String.valueOf(prize.getPrizeAmount()));
                    getModel().set("checkpoint_prizes_num", prize.getPlace() - 1, prize.getNumberOfSubmissions());
                }
            }
        }

        // Obtain Phase Manager instance
        PhaseManager phaseManager = ActionsHelper.createPhaseManager(false);

        // Retrieve project phases
        Phase[] phases = ActionsHelper.getPhasesForProject(phaseManager, project);
        // Sort project phases
        Arrays.sort(phases, new Comparators.ProjectPhaseComparer());

        setEditProjectPhasesData(phases, false);
        setEditProjectRequestAttributes(request, project, resources, externalUsers, phases);

        // Populate last modification timestamp
        getModel().set("last_modification_time", ActionsHelper.getLastModificationTime(project, phases).getTime());

        boolean isAdmin = AuthorizationHelper.hasUserRole(request, Constants.MANAGER_ROLE_NAME)
            || AuthorizationHelper.hasUserRole(request, Constants.COCKPIT_PROJECT_USER_ROLE_NAME)
            || AuthorizationHelper.hasUserRole(request, Constants.GLOBAL_MANAGER_ROLE_NAME);
        request.setAttribute("isAdmin", isAdmin);

        // start BUGR 4039 - Check whether the billing project id is in the user's allowed billing projects list
        List<ClientProject> availableClientProjects = ActionsHelper.getClientProjects(request);
        Long currentClientProjectId = (Long) getModel().get("billing_project");
        boolean inList = false;

        if (currentClientProjectId == null) {
            // no billing project yet, allow set
            inList = true;
        } else {
            for (ClientProject cp : availableClientProjects) {
                if (cp.getId() == currentClientProjectId) {
                    inList = true;

                    break;
                }
            }
        }

        request.setAttribute("allowBillingEdit", isAdmin && inList);

        // end BUG-4039
        List<CockpitProject> availableCockpitProjects = ActionsHelper.getCockpitProjects(request);
        Long currentCockpitProjectId = (Long) getModel().get("cockpit_project");
        inList = false;

        if (currentCockpitProjectId == null) {
            inList = true;
        } else {
            for (CockpitProject cockpitProject : availableCockpitProjects) {
                if (cockpitProject.getId() == currentCockpitProjectId) {
                    inList = true;

                    break;
                }
            }
        }

        request.setAttribute("allowCockpitProjectEdit", isAdmin && inList);
    }

    /**
     * This method populates as single property of the project form by the value taken from the
     * specified Project instance.
     *
     * @param type
     *            the type of form property to be populated
     * @param formProperty
     *            the name of form property to be populated
     * @param project
     *            the project to take the value of property of
     * @param projectProperty
     *            the name of project property to take the value of
     */
    private void populateProjectFormProperty(Class<?> type,
        String formProperty, Project project, String projectProperty) {
        String value = (String) project.getProperty(projectProperty);
        if (value != null) {
            if (type == String.class) {
                getModel().set(formProperty, value);
            } else if (type == Boolean.class) {
                getModel().set(formProperty, Boolean.valueOf(value.compareToIgnoreCase("Yes") == 0));
            } else if (type == Long.class) {
                getModel().set(formProperty, Long.valueOf(value));
            } else if (type == Integer.class) {
                getModel().set(formProperty, Integer.valueOf(value));
            } else if (type == Double.class) {
                getModel().set(formProperty, Double.valueOf(value));
            }
        }

    }

    private void setModelValue(String key, String value) {
        Class type = getModel().getDynaClass().getDynaProperty(key).getType();
        if (value != null) {
            if (type == String.class) {
                getModel().set(key, value);
            } else if (type == Boolean.class) {
                getModel().set(key, Boolean.valueOf(value.equalsIgnoreCase("true")));
            } else if (type == Long.class) {
                getModel().set(key, Long.valueOf(value));
            } else if (type == Integer.class) {
                getModel().set(key, Integer.valueOf(value));
            } else if (type == Double.class) {
                getModel().set(key, Double.valueOf(value));
            }
        }
    }

    private void setModelValue(String key, int index, String value) {
        Class type = getModel().getDynaClass().getDynaProperty(key).getContentType();
        if (value != null) {
            if (type == String.class) {
                getModel().set(key, index, value);
            } else if (type == Boolean.class) {
                getModel().set(key, index, Boolean.valueOf(value.equalsIgnoreCase("true")));
            } else if (type == Long.class) {
                getModel().set(key, index, Long.valueOf(value));
            } else if (type == Integer.class) {
                getModel().set(key, index, Integer.valueOf(value));
            } else if (type == Double.class) {
                getModel().set(key, index, Double.valueOf(value));
            }
        }
    }
}
