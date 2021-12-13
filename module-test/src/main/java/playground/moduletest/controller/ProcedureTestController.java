package playground.moduletest.controller;

import lombok.extern.java.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import playground.moduletest.model.Jamong;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/requestObject")
public class ProcedureTestController {

    private static final Logger logger = LoggerFactory.getLogger(ProcedureTestController.class);

    @RequestMapping(method=RequestMethod.POST)
    @ResponseBody
    public String simpleWithObject(@ModelAttribute Jamong jamong) {
        System.out.println("jamong.getName() = " + jamong.getName());
        System.out.println("jamong.getAge() = " + jamong.getAge());
        //필요한 로직 처리
        return jamong.getName() + jamong.getAge();
    }

    @RequestMapping(value="/serialize", method=RequestMethod.POST)
    @ResponseBody
    public String serialize(Jamong jamong) {
        System.out.println("jamong.getName() = " + jamong.getName());
        System.out.println("jamong.getAge() = " + jamong.getAge());
        //필요한 로직 처리
        return jamong.getName() + jamong.getAge();
    }
}
