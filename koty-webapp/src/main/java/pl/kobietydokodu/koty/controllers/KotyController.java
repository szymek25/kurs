package pl.kobietydokodu.koty.controllers;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.UUID;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.fileupload.MultipartStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import pl.kobietydokodu.koty.domain.Photo;
import pl.kobietydokodu.koty.domain.Kot;
import pl.kobietydokodu.koty.dto.KotDTO;
import pl.kobietydokodu.koty.dto.ZabawkaDTO;
import pl.kobietydokodu.koty.services.DaoService;

@Controller
public class KotyController {

	@Autowired
	DaoService dao;
	
	
	@RequestMapping("/lista")
	public String listaKotow(Model model) {
		model.addAttribute("koty", dao.kotDao.findAll());
		return "lista";
	}
	
	@Secured({ "ROLE_USER" })
	@RequestMapping("/dodaj")
	public String dodajKota(HttpServletRequest request,  @ModelAttribute("kotDto") @Valid KotDTO kotDto, BindingResult result) {
		if (request.getMethod().equalsIgnoreCase("post") && !result.hasErrors()) {
			Kot kot = new Kot();
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
			try {
				kot.setDataUrodzenia(sdf.parse(kotDto.getDataUrodzenia()));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			kot.setImie(kotDto.getImie());
			kot.setImieOpiekuna(kotDto.getImieOpiekuna());
			kot.setWaga(kotDto.getWaga());
			dao.kotDao.save(kot);
			return "redirect:/lista";
		}
		return "dodaj";
	}
	
	@RequestMapping("/kot-{imie}")
	public String szczegolyKota(@PathVariable("imie") String imie, Model model) {
		model.addAttribute("kot", dao.kotDao.findByImie(imie));
		return "szczegoly";
	}
	
	final Logger log = Logger.getLogger(getClass().getName());
	
	@RequestMapping(value="/kot-{imie}/upload", method=RequestMethod.POST)
	public String handleFileUpload(@RequestParam("plik") MultipartFile file,@PathVariable("imie") String imie, Model model){
	    if (!file.isEmpty()) {
	    	try{
	    	//Usuwanie starego zdjecia
	    	Photo atachmentold = dao.atachmentDao.findBykot_imie(imie);
	    	dao.atachmentDao.delete(atachmentold);
	    	}
	    	catch (Exception e) {
	    		log.info("Nothing to delete");
	    	}
	        try {
	            UUID uuid = UUID.randomUUID();
	            String filename = "/home/pawel/uploads/upload_"+uuid.toString();
	            byte[] bytes = file.getBytes();
	            File fsFile = new File(filename);
	            fsFile.createNewFile();
	            BufferedOutputStream stream =
	                        new BufferedOutputStream(new FileOutputStream(fsFile));
	            stream.write(bytes);
	            stream.close();

	            Kot kot = new Kot();
	            kot = dao.kotDao.findByImie(imie);
	            
	            Photo atachment = new Photo();
	            
	            atachment.setUuid(filename);
	            atachment.setOrginalName(file.getOriginalFilename());
	            atachment.setSize(file.getSize());
	            atachment.setByteSize(file.getBytes());
	            atachment.setMimeType(file.getContentType());
	            atachment.setKot(kot);
	            
	            
	            dao.atachmentDao.save(atachment);

	            log.info("File {} has been successfully uploaded as {}");
	        } catch (Exception e) {
	            log.info("File has not been uploaded");
	        }
	    } else {
	        log.info("Uploaded file is empty");
	    }
	    return "redirect:/lista";
	}
	
	@Secured({ "ROLE_USER" })
	@RequestMapping("/kot-{imie}/dodajZdjecie")
	public String dodajZdjecie(HttpServletRequest request,  @ModelAttribute("kot")  @PathVariable("imie") String imie, Model model){
		model.addAttribute(dao.kotDao.findByImie(imie));
		
		return "dodajZdjecie";
	}
	
	@RequestMapping(value = "/kot-{imie}/pobierzZdjecie",method = RequestMethod.GET)
	public void pobierz(@PathVariable("imie") String imie,
	        HttpServletResponse response) throws IOException {

	    Photo attachment = new Photo();
	    attachment = dao.atachmentDao.findBykot_imie(imie);
	    FileInputStream inputStream = new FileInputStream(attachment.getUuid());

	    response.setContentType(attachment.getMimeType());
	    response.setContentLength((int) attachment.getSize());

	    String headerValue = String.format("attachment; filename=\"%s\"",
	                attachment.getOrginalName());
	    response.setHeader("Content-Disposition", headerValue);

	    OutputStream outStream = response.getOutputStream();

	    byte[] buffer = attachment.getByteSize();
	    int bytesRead = -1;
	    // czytamy w pętli po fragmencie, który następnie przepisujemy do strumienia wyjściowego
	    while ((bytesRead = inputStream.read(buffer)) != -1) {
	        outStream.write(buffer, 0, bytesRead);
	    }
	    inputStream.close();
	    outStream.close(); 
	}
}
