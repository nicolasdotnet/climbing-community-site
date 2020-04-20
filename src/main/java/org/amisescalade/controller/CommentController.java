package org.amisescalade.controller;

import java.util.List;
import java.util.logging.Level;

import org.amisescalade.entity.Spot;
import org.amisescalade.entity.User;
import org.amisescalade.entity.Comment;
import org.amisescalade.services.ISpotService;
import org.amisescalade.services.IUserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.amisescalade.services.ICommentService;

@Controller
@Transactional
public class CommentController {

    private final Logger log = LogManager.getLogger(CommentController.class);

    @Autowired
    private ICommentService iCommentService;

    @Autowired
    private ISpotService iSpotService;

    @Autowired
    private IUserService iUserService;

    @Autowired
    private IInputValidator inputValidator;

    private String errorMessage;

    public String getErrorMessage() {
        return errorMessage;
    }

    // comment list page by spot
    @GetMapping("/user/spot/{id}/comments")
    public String showAllComments(@PathVariable("id") int id, Model model, final RedirectAttributes redirectAttributes) {

        log.debug("showAllComments()");

        Spot spotFind = null;
        try {
            spotFind = iSpotService.getSpot(Long.valueOf(id));
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(CommentController.class.getName()).log(Level.SEVERE, null, ex);
        }

        List<Comment> comments = null;

        try {
            comments = iCommentService.getAllCommentBySpot(spotFind);
        } catch (Exception e) {

            this.errorMessage = e.getMessage();
        }

        System.out.println("le post marche !! comment");

        model.addAttribute("comments", comments);
        model.addAttribute("spot", spotFind);
        model.addAttribute("spotId", Math.toIntExact(spotFind.getSpotId()));
        model.addAttribute("spotCommentForm", new Comment());

        return "/comment/list";

    }

    // show add spotcomment form :
    @GetMapping("/user/spot/{id}/comments/add")
    public String showAddCommentForm(@PathVariable("id") int id, Model model) {

        log.debug("showAddCommentForm()");
        model.addAttribute("spotCommentForm", new Comment());
        model.addAttribute("spotId", id);

        return "/comment/addform";

    }

    // save comment
    @PostMapping("/user/commentSave/{id}")
    public String saveComment(@ModelAttribute("spotCommentForm") Comment Comment, @PathVariable("id") int id, final RedirectAttributes redirectAttributes) {

        System.out.println("le post marche !! spotCommentForm : ");

        Spot spotFind = null;
        try {
            spotFind = iSpotService.getSpot(Long.valueOf(id));
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(CommentController.class.getName()).log(Level.SEVERE, null, ex);
        }

        User author = null;

        try {

// author par défault
            author = iUserService.getUser(2L);
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(CommentController.class.getName()).log(Level.SEVERE, null, ex);
        }

        Comment spotCommentSave = null;

        try {
            spotCommentSave = iCommentService.register(Comment.getCommentBody(), author, spotFind);
        } catch (Exception e) {

            this.errorMessage = e.getMessage();
        }

        redirectAttributes.addFlashAttribute("msg", "Full succès ! ");

        return "redirect:/user/spot/" + id + "/comments";

    }

    // show comment
    @GetMapping("/user/comment/{id}")
    public String showComment(@PathVariable("id") Long id, Model model) {

        log.debug("showComment() id: {}", id);

        System.out.println("showComment() id: {}" + id);

//        Sector sectorFind = iSectorController.displaySector(Long.valueOf(id));
        Comment commentFind = null;

        try {
            commentFind = iCommentService.getComment(Long.valueOf(id));
        } catch (Exception e) {

            this.errorMessage = e.getMessage();
        };

        model.addAttribute("commentFind", commentFind);
        model.addAttribute("spotCommentForm", new Comment());

        System.out.println("commentSpot() id: {}" + commentFind.getCommentId());

        return "/comment/show";

    }

    //delette Comment
    @PostMapping("/user/comment/{id}/delete")
    public String deleteComment(@PathVariable("id") int id, final RedirectAttributes redirectAttributes) {

        log.debug("deleteComment() id: {}", id);

        System.out.println("deleteComment() id: {}" + id);

        Comment comment = null;

        try {
            comment = iCommentService.getComment(Long.valueOf(id));
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(CommentController.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            iCommentService.delete(Long.valueOf(id));
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(CommentController.class.getName()).log(Level.SEVERE, null, ex);
        }

        redirectAttributes.addFlashAttribute("msg", "delete");

        return "redirect:/user/spot/" + comment.getSpot().getSpotId() + "/comments";

    }

    // show update Comment form :
    @GetMapping("/user/comment/{id}/update")
    public String showUpdateCommentForm(@PathVariable("id") int id, Model model) {

        log.debug("showUpdateCommentForm() : {}", id);

        Comment spotCommentFind = null;

        try {
            spotCommentFind = iCommentService.getComment(Long.valueOf(id));

        } catch (Exception e) {

            this.errorMessage = e.getMessage();
        }

        model.addAttribute("spotCommentFind", spotCommentFind);

        return "/comment/updateform";

    }

    //update Comment
    @PostMapping("/user/commentUpdate")
    public String updateComment(@ModelAttribute("spotCommentFind") Comment spotComment, final RedirectAttributes redirectAttributes) {

        log.debug("updateComment()");

        System.out.println("updateComment()");

        Comment spotCommentFind = null;

        try {

            spotCommentFind = iCommentService.edit(spotComment);
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(CommentController.class.getName()).log(Level.SEVERE, null, ex);
        }

        redirectAttributes.addFlashAttribute("msg", "delete");

        return "redirect:/user/spot/" + Math.toIntExact(spotCommentFind.getSpot().getSpotId()) + "/comments";

    }
}
