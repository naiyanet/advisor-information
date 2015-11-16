
package th.co.geniustree.intenship.advisor.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
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
import th.co.geniustree.intenship.advisor.model.FileUpload;
import th.co.geniustree.intenship.advisor.model.Information;
import th.co.geniustree.intenship.advisor.model.SearchData;
import th.co.geniustree.intenship.advisor.repo.InformationRepo;
import th.co.geniustree.intenship.advisor.service.InformationSearchService;

/**
 *
 * @author User
 */
@RestController
public class InformationController {

    @Autowired
    private InformationRepo informationRepo;

    @Autowired
    private InformationSearchService informationSearchService;

    @RequestMapping(value = "/getinformation", method = RequestMethod.GET)
    public Page<Information> getInformation(Pageable pageable) {
        return informationRepo.findAll(pageable);
    }

    @RequestMapping(value = "/saveinformation", method = RequestMethod.POST)
    public void saveInformation(@Validated @RequestBody Information information) {
        informationRepo.save(information);
    }

    @RequestMapping(value = "/deleteinformation", method = RequestMethod.POST)
    public void deleteInformation(@RequestBody Integer information) {
        informationRepo.delete(information);
    }

    @RequestMapping(value = "/searchinformation", method = RequestMethod.POST)
    private Page<Information> searchInformation(SearchData searchData, Pageable pageable) throws ParseException {
        String keyword = searchData.getKeyWord();
        String searchBy = searchData.getSearchBy();

        Page<Information> informations = null;
        if ("title".equals(searchBy)) {
            informations = informationSearchService.searchByTitle(keyword, pageable);
        }
        if ("startTime".equals(searchBy)) {
            DateFormat sim = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
            Date date = sim.parse(keyword);
            informations = informationSearchService.searchByStartTime(date, date, pageable);
        }
        return informations;
    }

    @RequestMapping(value = "/savefile", method = RequestMethod.POST)
    private FileUpload saveFile(MultipartRequest file) throws IOException {
        FileUpload fileUpload = new FileUpload();
        fileUpload.setName(file.getFile("files").getOriginalFilename());
        fileUpload.setMimeType(file.getFile("files").getContentType());
        fileUpload.setContent(file.getFile("files").getBytes());
        return fileUpload;

    }
    
    @RequestMapping(value = "/getfileinformation/{id}", method = RequestMethod.GET)
    public ResponseEntity<InputStreamResource> getFile(@PathVariable("id") FileUpload fileUpload) {
        ResponseEntity<InputStreamResource> body = ResponseEntity.ok().contentLength(fileUpload.getContent().length)
                .contentType(MediaType.parseMediaType(fileUpload.getMimeType()))
                .header("Content-Disposition", "attachment; filename=\"" + fileUpload.getName() + "\"")
                .body(new InputStreamResource(new ByteArrayInputStream(fileUpload.getContent())));
        return body;
    }

}
