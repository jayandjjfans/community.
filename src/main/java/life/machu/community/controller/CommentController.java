package life.machu.community.controller;

import life.machu.community.dto.CommentDTO;
import life.machu.community.dto.ResultDTO;
import life.machu.community.exception.CustomizeErrorCode;
import life.machu.community.mapper.CommentMapper;
import life.machu.community.model.Comment;
import life.machu.community.model.User;
import life.machu.community.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;
    @ResponseBody
    @RequestMapping(value ="/comment",method = RequestMethod.POST)
    public Object post(@RequestBody CommentDTO commentDTO, HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        if (user==null){
            return ResultDTO.errorOf(CustomizeErrorCode.NO_LOGIN);
        }

        Comment comment = new Comment();
        comment.setParentId(commentDTO.getParentId());
        comment.setContent(commentDTO.getContent());
        comment.setType(commentDTO.getType());
        comment.setGmtModified(System.currentTimeMillis());
        comment.setGmtCreate(System.currentTimeMillis());
        comment.setCommentatar(user.getId());
        comment.setLikecount(0L);
        commentService.insert(comment);
        return ResultDTO.okOf();
    }
}
