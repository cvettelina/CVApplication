/*
 * $Id$
 *
 * Copyright 2013 Moneybookers Ltd. All Rights Reserved.
 * MONEYBOOKERS PROPRIETARY/CONFIDENTIAL. For internal use only.
 */

package cvPackage;

import java.util.Date;
import java.util.GregorianCalendar;

/*
 * Application class represents the CV format
 */
public class Application {
    private PersonalInformation personalInfo;
    private String previousExperience;
    private String education;
    private String applicationPosition;
    private Date submissionDate;

    public Application(PersonalInformation personalInfo, String previousExperience, String education, String applicationPosition) {
        super();
        this.personalInfo = personalInfo;
        this.previousExperience = previousExperience;
        this.education = education;
        this.applicationPosition = applicationPosition;
        this.submissionDate = new GregorianCalendar().getTime();
    }

    public Application() {
        // TODO Auto-generated constructor stub
    }

    public PersonalInformation getPersonalInfo() {
        return personalInfo;
    }

    public void setPersonalInfo(PersonalInformation personalInfo) {
        this.personalInfo = personalInfo;
    }

    public String getPreviousExperience() {
        return previousExperience;
    }

    public void setPreviousExperience(String previousExperience) {
        this.previousExperience = previousExperience;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getApplicationPosition() {
        return applicationPosition;
    }

    public void setApplicationPosition(String applicationPosition) {
        this.applicationPosition = applicationPosition;
    }

    public Date getSubmissionDate() {
        return submissionDate;
    }

    @Override
    public String toString() {
        return "{\n\t personalInfo: " + personalInfo + ",\n\t previousExperience: " + previousExperience + ",\n\t education:"
                + education + ",\n\t applicationPosition: "
                + applicationPosition + ",\n\t submissionDate: " + submissionDate + "\n }";
    }

}
