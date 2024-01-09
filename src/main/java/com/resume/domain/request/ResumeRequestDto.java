package com.resume.domain.request;

import com.resume.domain.entity.Education;
import com.resume.domain.entity.Work;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Resume RequestDto
 */
@Getter
@Setter
public class ResumeRequestDto implements RequestDto{

    private String firstname;
    private String lastname;
    private String title;
    private String street;
    private String city;
    private String state;
    private String phone;
    private String website;
    private String mail;
    private String objective;
    private List<Work> work;
    private List<Education> edu;
    private List<String> achievements;
    private List<String> skills;

    /**
     *  this method checks is Required Fields Available
     * @return True/False
     */
    @Override
    public boolean isRequiredFieldsAvailable() {
        return isNonEmpty(firstname) && isNonEmpty(lastname) && isNonEmpty(title);
    }
}
