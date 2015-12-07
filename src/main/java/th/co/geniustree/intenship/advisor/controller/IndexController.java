/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.co.geniustree.intenship.advisor.controller;

import java.io.ByteArrayInputStream;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import th.co.geniustree.intenship.advisor.model.FileUpload;

/**
 *
 * @author BestKung
 */
@RestController
public class IndexController {
    
    
     @RequestMapping(value = "/teacher/{id}", method = RequestMethod.GET)
    public ResponseEntity<InputStreamResource> getFileTeacher(@PathVariable("id") FileUpload uploadFile) {
        ResponseEntity<InputStreamResource> body = ResponseEntity.ok().contentLength(uploadFile.getContent().length)
                .contentType(MediaType.parseMediaType(uploadFile.getMimeType()))
                .header("Content-Disposition", "attachment; filename=\""+ uploadFile.getName()+"\"")
                .body(new InputStreamResource(new ByteArrayInputStream(uploadFile.getContent())));
        return body;
    }
    
     @RequestMapping(value = "/student/{id}", method = RequestMethod.GET)
    public ResponseEntity<InputStreamResource> getFileStudent(@PathVariable("id") FileUpload uploadFile) {
        ResponseEntity<InputStreamResource> body = ResponseEntity.ok().contentLength(uploadFile.getContent().length)
                .contentType(MediaType.parseMediaType(uploadFile.getMimeType()))
                .header("Content-Disposition", "attachment; filename=\""+ uploadFile.getName()+"\"")
                .body(new InputStreamResource(new ByteArrayInputStream(uploadFile.getContent())));
        return body;
    }
    
     @RequestMapping(value = "/parent/{id}", method = RequestMethod.GET)
    public ResponseEntity<InputStreamResource> getFileParent(@PathVariable("id") FileUpload uploadFile) {
        ResponseEntity<InputStreamResource> body = ResponseEntity.ok().contentLength(uploadFile.getContent().length)
                .contentType(MediaType.parseMediaType(uploadFile.getMimeType()))
                .header("Content-Disposition", "attachment; filename=\""+ uploadFile.getName()+"\"")
                .body(new InputStreamResource(new ByteArrayInputStream(uploadFile.getContent())));
        return body;
    }
}
