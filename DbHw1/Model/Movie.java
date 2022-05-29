package com.demo.DbHw1.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.*;
import java.util.Date;


@AllArgsConstructor @NoArgsConstructor
@Data @Entity
public class Movie {

    @Id
    @NotEmpty(message = "ID is required")
    @Size(min = 3, message = "ID have to be more than 3 character long")
    private String id;

    @NotEmpty(message = "Name is required")
    @Size(min = 2, message = "Name have to be more than 2 character long")
    @Column(name ="Name", nullable = false, unique = true)
    private String name;

    @NotEmpty(message = "genre is required")
    @Pattern(regexp = "(Drama | Action| Comedy)", message = "genre Can only have these values (Drama, Action , Comedy)")
    private String genre;

    @NotNull(message = "rating is required")
    @Positive(message = "rating has to be a number")
    @Range(min = 1, max = 5, message = "rating must be between 1 - 5")
    private Integer rating;


    @NotNull(message = "duration is required")
    @Positive(message = "rating has to be a number")
    //@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    //@DateTimeFormat
    @Size(min = 60, message = "duration must be more than 60")
    private Integer duration;


    @NotNull(message = "launchDate is required")
    //@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd")
    //@DateTimeFormat
    private Date launchDate;

}

