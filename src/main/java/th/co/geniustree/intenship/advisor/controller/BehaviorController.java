
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
import th.co.geniustree.intenship.advisor.model.Behavior;
import th.co.geniustree.intenship.advisor.model.FileUpload;
import th.co.geniustree.intenship.advisor.model.SearchData;
import th.co.geniustree.intenship.advisor.model.Student;
import th.co.geniustree.intenship.advisor.repo.BehaviorRepo;
import th.co.geniustree.intenship.advisor.service.BehaviorSearchService;
import th.co.geniustree.intenship.advisor.service.StudentSearchService;

/**
 *
 * @author User
 */
@RestController
public class BehaviorController {
    @Autowired
    private BehaviorRepo behaviorRepo;
    @Autowired
    private BehaviorSearchService behaviorSearchService;
    @Autowired
    private StudentSearchService studentSearchService;
    
//    @RequestMapping(value = "/getbehavior",method = RequestMethod.POST)
//    public Page<Behavior> getBehavior (@RequestBody SearchData searchData,Pageable pageable){
//        String searchBy = searchData.getSearchBy();
//        String keyword = searchData.getKeyWord();
//        Page<Behavior> behaviors = null;
//        if("Teacher".equals(searchBy)){
//            behaviors = behaviorSearchService.searchNameStudentBehavior(keyword, pageable);
//        }else{
//            behaviors = behaviorSearchService.searchNameStudentBehavior(keyword, pageable);
//        }
//        return behaviors;
//    }
    
    @RequestMapping(value = "/savebehavior",method = RequestMethod.POST)
    public void saveBehavior (@Validated @RequestBody Behavior behavior){
        behaviorRepo.save(behavior);
    }
    
    @RequestMapping(value = "/deletebehavior",method = RequestMethod.POST)
    public void deleteBehavior (@RequestBody Behavior behavior){
        behaviorRepo.delete(behavior.getId());
    }
    
    @RequestMapping(value = "/savefilebehavior", method = RequestMethod.POST)
    private FileUpload saveFile(MultipartRequest file) throws IOException {
        FileUpload fileUpload = new FileUpload();
        fileUpload.setName(file.getFile("files").getOriginalFilename());
        fileUpload.setMimeType(file.getFile("files").getContentType());
        fileUpload.setContent(file.getFile("files").getBytes());
        return fileUpload;

    }
    
    @RequestMapping(value = "/getfilebehavior/{id}", method = RequestMethod.GET)
    public ResponseEntity<InputStreamResource> getFile(@PathVariable("id") FileUpload fileUpload) {
        ResponseEntity<InputStreamResource> body = ResponseEntity.ok().contentLength(fileUpload.getContent().length)
                .contentType(MediaType.parseMediaType(fileUpload.getMimeType()))
                .header("Content-Disposition", "attachment; filename=\"" + fileUpload.getName() + "\"")
                .body(new InputStreamResource(new ByteArrayInputStream(fileUpload.getContent())));
        return body;
    }
    
    @RequestMapping(value = "/searchStudentInBehavior",method = RequestMethod.POST)
    public Page<Behavior> searchStudent(@RequestBody String keyword,Pageable pageable){
        return behaviorSearchService.searchNameStudentBehavior(keyword, pageable);
    }

     @RequestMapping(value = "/getidteacher" , method = RequestMethod.POST)
    public Page<Student> getStudentOfTeacher(@RequestBody Integer keyword, Pageable pageable) {
        System.out.println("------------------------------------------>"+keyword);
        Page<Student> students = studentSearchService.searchStudentByTeacher(keyword, pageable);
        return students;
    }
    
    @RequestMapping(value = "/getbehavior",method = RequestMethod.POST)
    public Page<Behavior> getBehavior (@RequestBody Integer id,Pageable pageable){
         Page<Behavior> behaviors = null;
         
         behaviors = behaviorSearchService.searchTeacherId(id, pageable);
         
//        if("Teacher".equals(searchBy)){
//           
//        }else{
//            
//        }
        return behaviors;
    }
}
