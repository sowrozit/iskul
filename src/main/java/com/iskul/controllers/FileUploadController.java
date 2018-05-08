package com.iskul.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

/**
 * Created by Sowrozit on 5/5/2017.
 */

@Controller
public class FileUploadController {


    @RequestMapping("/manage/adminTeacher/uploadform")
    public ModelAndView uploadForm(){
        return new ModelAndView("uploadform");
    }

    @RequestMapping(value="/manage/adminTeacher/savefile",method= RequestMethod.POST)
    public ModelAndView saveimage( @RequestParam CommonsMultipartFile file,HttpSession session) throws Exception{

        ServletContext context = session.getServletContext();
        String filename = file.getOriginalFilename();
        byte[] bytes = file.getBytes();
        BufferedOutputStream stream =new BufferedOutputStream(new FileOutputStream(
                new File("E:\\images\\" + File.separator + filename)));
        stream.write(bytes);
        stream.flush();
        stream.close();

        return new ModelAndView("uploadform","filesuccess","File successfully saved!");
    }
}
