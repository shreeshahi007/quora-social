package com.teamtwo.quora.quorasocial.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import java.util.List;

@Data
@Document
public class BusinessProfile {
    @Id
    private String businessId;
    private String businessEmail;
    private String businessName;
    private List<String> businessCategory;
    private String businessDescription;
    private List<String> teams;
}
