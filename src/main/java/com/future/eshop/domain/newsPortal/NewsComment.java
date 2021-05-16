package com.future.eshop.domain.newsPortal;


import com.future.eshop.domain.general.CommentBaseEntity;
import com.future.eshop.domain.product.Product;
import com.future.eshop.domain.user.EshopUser;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@Table(name = "news_comment")
@Entity
public class NewsComment extends CommentBaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer newsCommentID;

    @OneToMany(mappedBy = "newsComment")
    private List<NewsCommentAnswer> newsCommentAnswers;



}
