package com.mediant.java.controller;

import com.mediant.java.model.InputForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;


@Controller
public class NumberMultiplicationController {

    /**
     * Create new inputForm object for empty from
     *
     * @return
     */
    @ModelAttribute("inputForm")
    public InputForm setupInputForm() {
        return new InputForm();
    }

    /**
     * Method to show the initial HTML form
     *
     * @return
     */
    @GetMapping("/showInputForm")
    public String showForm() {
        return "input-form";
    }

    /**
     * display calculations results
     *
     * @param inputForm
     * @param model
     * @return
     */
    @PostMapping("/showResults")
    public String calculate(@ModelAttribute("inputForm") InputForm inputForm, Model model) {
        List<InputForm> listValue = new ArrayList<>();
        if (inputForm.getNumber() > 50) {
            model.addAttribute("message", inputForm.getNumber() + " : Number should be less than 50");
            model.addAttribute("valueList", listValue);
        } else {
            for (int i = 0; i <= 10; i++) {
                InputForm value = new InputForm();
                value.setNumber(i * inputForm.getNumber());
                value.setResult(inputForm.getNumber() + " X " + i);
                listValue.add(value);
            }
            model.addAttribute("message", inputForm.getNumber());
            model.addAttribute("valueList", listValue);
        }
        return "result-form";
    }

}
