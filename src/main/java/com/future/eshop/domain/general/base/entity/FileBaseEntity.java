package com.future.eshop.domain.general.base.entity;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;


@MappedSuperclass
@Data
public abstract class FileBaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "original_file_name")
    private String originalFileName;

    @Column(name = "file_size")
    private long fileSize;

    @Column(name = "file_bucket_name")
    private String fileBucketName;

    private String description;

    @Column(name = "file_format")
    private String fileFormat;

    @Column(name = "upload_date")
    private Date uploadDate;

    private Boolean isDeleted;


}
