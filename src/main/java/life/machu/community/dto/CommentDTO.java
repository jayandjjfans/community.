package life.machu.community.dto;

import life.machu.community.model.User;
import lombok.Data;

@Data
public class CommentDTO {

    private Long id;
    private Long parentId;
    private Integer type;
    private Long commentatar;
    private Long gmtCreate;
    private Long gmtModified;
    private Long likecount;
    private String content;
    private User user;


}
