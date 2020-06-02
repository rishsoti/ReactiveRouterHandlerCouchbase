package com.example.demo;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;
@Data
@Builder
@AllArgsConstructor
@org.springframework.data.couchbase.core.mapping.Document
@ToString
public class Student {
 
 @Id
 private String id;
 private String firstName;
 private String lastName;
 
}