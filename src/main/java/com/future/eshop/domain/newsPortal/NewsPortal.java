package com.future.eshop.domain.newsPortal;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;

@Data
@Table(name = "news_portal")
@Entity
public class NewsPortal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer newsPortalID;

    private String title;

    @Column(name = "news_body")
    @Type(type = "text")
    private String newsBody;

    @Column(name = "news_type")
    @Enumerated(value = EnumType.STRING)
    private NewsType newsType;

    @Column(name = "public_date")
    private Date publicDate;

    @Column(name = "edit_date")
    private Date editDate;


}
