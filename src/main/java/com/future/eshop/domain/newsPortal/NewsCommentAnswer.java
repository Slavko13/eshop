package com.future.eshop.domain.newsPortal;

import com.future.eshop.domain.general.CommentBaseEntity;
import com.future.eshop.domain.user.EshopUser;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Table(name = "news_comment_answer")
@Entity
public class NewsCommentAnswer extends CommentBaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer newsCommentAnswerID;

    @JoinColumn(name = "news_comment_id")
    @ManyToOne(cascade = CascadeType.PERSIST, targetEntity = NewsComment.class)
    private NewsComment newsComment;

    @JoinColumn(name = "user_id")
    @ManyToOne(cascade = CascadeType.PERSIST, targetEntity = EshopUser.class)
    private EshopUser eshopUser;



}
