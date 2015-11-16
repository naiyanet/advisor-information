/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.co.geniustree.intenship.advisor.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartRequest;
import th.co.geniustree.intenship.advisor.model.Advise;
import th.co.geniustree.intenship.advisor.model.FileUpload;
import th.co.geniustree.intenship.advisor.repo.AdviseRepo;

/**
 *
 * @author User
 */
@RestController
public class AdviseController {
    @Autowired
    private AdviseRepo adviseRepo;
    
    @RequestMapping(value = "/getadvisee",method = RequestMethod.GET)
    public Page<Advise> getAdvise(Pageable pageable){
        return adviseRepo.findAll(pageable);
    }
    
    @RequestMapping(value = "/saveadvise" , method = RequestMethod.POST)
    public void saveAdvise(@Validated @RequestBody Advise advise){
        adviseRepo.save(advise);
    }
    
    @RequestMapping(value = "/deleteadvise",method = RequestMethod.POST)
    public void deleteAdvise(@RequestBody Advise advise){
        adviseRepo.delete(advise);
    }
    
    @RequestMapping(value = "/savefileadvise", method = RequestMethod.POST)
    private FileUpload saveFile(MultipartRequest file) throws IOException {
        FileUpload fileUpload = new FileUpload();
        fileUpload.setName(file.getFile("files").getOriginalFilename());
        fileUpload.setMimeType(file.getFile("files").getContentType());
        fileUpload.setContent(file.getFile("files").getBytes());
        return fileUpload;

    }
    
    @RequestMapping(value = "/getfileadvise/{id}", method = RequestMethod.GET)
    public ResponseEntity<InputStreamResource> getFile(@PathVariable("id") FileUpload fileUpload) {
        ResponseEntity<InputStreamResource> body = ResponseEntity.ok().contentLength(fileUpload.getContent().length)
                .contentType(MediaType.parseMediaType(fileUpload.getMimeType()))
                .header("Content-Disposition", "attachment; filename=\"" + fileUpload.getName() + "\"")
                .body(new InputStreamResource(new ByteArrayInputStream(fileUpload.getContent())));
        return body;
    }
}
