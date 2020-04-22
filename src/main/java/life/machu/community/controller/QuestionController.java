package life.machu.community.controller;

import life.machu.community.dto.CommentCreateDTO;
import life.machu.community.dto.CommentDTO;
import life.machu.community.dto.QuestionDTO;
import life.machu.community.service.CommentService;
import life.machu.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class QuestionController {
    @Autowired
    private QuestionService questionService;
    @Autowired
    private CommentService commentService;

    @GetMapping("/question/{id}")
    public String question(@PathVariable(name = "id")Long id, Model model){
        QuestionDTO questionDTO=questionService.getById(id);
        List<CommentDTO> comments=commentService.listByQuestionId(id);
        questionService.incView(id);
        model.addAttribute("question",questionDTO);
        model.addAttribute("comments",comments);
        return "question";
    }
}
