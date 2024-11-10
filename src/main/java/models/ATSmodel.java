package models;

import java.util.Set;

import lombok.Data;
@Data
public class ATSmodel {
    private Set<String> totalKeywords;
    private Set<String> unMatchedKeywords;
    private String matchPercentage;

}
