package com.future.eshop.domain.product;


import com.fasterxml.jackson.annotation.JsonView;
import com.future.eshop.domain.general.base.entity.CommentBaseEntity;
import com.future.eshop.domain.user.EshopUser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product_comments")
public class ProductComments  extends CommentBaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long productCommentID;

    @Type(type = "text")
    @Column(name = "comment_text")
    private String commentText;

    @ManyToOne()
    @JoinColumn(name = "comment_writer_id")
    private EshopUser commentWriter;

    @OneToOne()
    @JoinColumn(name = "task_reply_id")
    private ProductComments taskReply;
//
//    @JsonIgnore
//    @Column(name = "task_reply_id")
//    private Long taskReplyID;

    @ManyToOne()
    @JoinColumn(name = "comment_replier_id")
    private EshopUser commentReplier;

    @ManyToOne()
    @JoinColumn(name = "product_id")
    private Product product;



}
