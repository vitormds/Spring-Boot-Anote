package com.anote.api;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.anote.api.viewDTO.FeedbackViewModel;
import com.anote.mail.*;
import javax.validation.ValidationException;


@RestController
@RequestMapping("/api/feedback")
@CrossOrigin
public class FeedbackController {
    private FeedbackSender feedbackSender;

    public FeedbackController(FeedbackSender feedbackSender) {
        this.feedbackSender = feedbackSender;
    }

    @PostMapping
    public void sendFeedback(@RequestBody FeedbackViewModel feedbackViewModel,
                             BindingResult bindingResult){
    	System.out.print(feedbackViewModel);
        if(bindingResult.hasErrors()){
            throw new ValidationException("Erro nos comentários; não conseigo enviar");
        }

        this.feedbackSender.sendFeedback(
        		
        		feedbackViewModel.getName(),
                feedbackViewModel.getEmail(),
                feedbackViewModel.getFeedback());
    }
}
