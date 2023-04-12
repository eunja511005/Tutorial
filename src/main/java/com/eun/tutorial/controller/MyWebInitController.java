package com.eun.tutorial.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tika.Tika;
import org.apache.tika.mime.MediaType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.util.MimeTypeUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.eun.tutorial.dto.UserInfoDTO;
import com.eun.tutorial.dto.ZthhFileAttachDTO;
import com.eun.tutorial.service.UserService;
import com.eun.tutorial.service.ZthhFileAttachService;
import com.eun.tutorial.service.user.UserDetailsImpl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;

@Slf4j
@RequiredArgsConstructor
@Controller
public class MyWebInitController {
	
	private static final Logger logger = LoggerFactory.getLogger(MyWebInitController.class);
	private final UserService userService;
	private final ZthhFileAttachService zthhFileAttachService;
	
    @Value("${spring.servlet.multipart.location}")
    private String multiPathPath;
	
	@Autowired private BCryptPasswordEncoder passwordEncoder; // 시큐리티에서 빈(Bean) 생성할 예정
	
	@GetMapping("/signinInit")
    public ModelAndView signinInit() {
		logger.debug("request url : /signinInit");
		
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("signin");

        return modelAndView;
    }
	
	@GetMapping("/joinInit")
    public ModelAndView joinInit() {
		logger.debug("request url : /joinInit");
		
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("join2");

        return modelAndView;
    }
	
    @PostMapping("/join")
    public @ResponseBody Map<String, Object> join(MultipartHttpServletRequest multipartFiles, UserInfoDTO userInfoDTO) throws IOException {
    	logger.debug("request url : /join");
    	
    	Map<String, Object> res = new HashMap<>();
    	
    	Iterator<String> fileNames = multipartFiles.getFileNames();
        MultipartFile file = null;
        String fileName = "";
        String mediaTypeString = "";
        int seq = 0;
        while (fileNames.hasNext()) {
        		seq++;
                fileName = fileNames.next();
                log.info("requestFile {} ", fileName);

                file = multipartFiles.getFile(fileName);

                LocalDateTime now = LocalDateTime.now();
                DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");
                String current_date = now.format(dateTimeFormatter);

                String originalFileExtension;
                String contentType = file.getContentType();
                if (ObjectUtils.isEmpty(contentType)) {
                	res.put("result", "Could not upload the file: " + file.getOriginalFilename() + "!");
                	return res;
                } else {
                	String mimeType = new Tika().detect(file.getInputStream()); //where 'file' is a File object or InputStream of the uploaded file
                	MediaType mediaType = MediaType.parse(mimeType);
                	mediaTypeString = mediaType.getType() + "/" + mediaType.getSubtype();

                	if(!mediaTypeString.equals("image/jpeg") && !mediaTypeString.equals("image/png") && !mediaTypeString.equals("image/gif")) {
                		res.put("result", "You can upload file's media type of image/jpeg, image/png");
                		return res;
                	}
                    log.info("tikaMimeType {} : "+mimeType);
                    originalFileExtension = MimeTypeUtils.parseMimeType(mimeType).getSubtype();
                    originalFileExtension = "."+originalFileExtension;
                    log.info("originalFileExtension {} : "+originalFileExtension);
                }
                String new_file_name = current_date + "/" + System.nanoTime() + originalFileExtension;
                File newFile = new File(multiPathPath + new_file_name);
                if (!newFile.exists()) {
                    boolean wasSuccessful = newFile.mkdirs();
                }

                file.transferTo(newFile);

                log.info("Uploaded the file successfully: " + file.getOriginalFilename());
                log.info("new file name: " + new_file_name);
                userInfoDTO.setPicture(new_file_name);
                
                ZthhFileAttachDTO zthhFileAttachDTO = ZthhFileAttachDTO.builder()
									                				.prefix("user_attach_")
									                				.sequence(seq)
									                				.originalFileName(file.getOriginalFilename())
									                				.fileName(new_file_name)
									                				.fileType(mediaTypeString)
									                				.fileSize(file.getSize())
									                				.filePath(multiPathPath + new_file_name)
									                				.createId(userInfoDTO.getUsername())
									                				.updateId(userInfoDTO.getUsername())
									                				.build();
                				
                zthhFileAttachService.save(zthhFileAttachDTO);
                
//                CustomOAuth2User customOAuth2User = null;
//                if(SecurityContextHolder.getContext().getAuthentication().getPrincipal()!=null){
//                    if(SecurityContextHolder.getContext().getAuthentication().getPrincipal() instanceof CustomOAuth2User){
//                        customOAuth2User = (CustomOAuth2User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//                    }
//                }
//
//                ImageEntity imageEntity = ImageEntity.builder()
//                                                .title((String)param.get("title"))
//                                                .description((String)param.get("description"))
//                                                .imagePath("/user-photos/" + new_file_name)
//                                                .userImagePath(customOAuth2User.getPicture())
//                                                .build();
//
//                imageService.save(imageEntity);
    	
        }
    	
    	
		userService.addUser(userInfoDTO);
		
		
        res.put("result", "registe success");
        res.put("redirectUrl", "/signinInit");
		return res;
	}
    
//    @GetMapping("/signout")
//    public String logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        if (auth != null) {
//            new SecurityContextLogoutHandler().logout(request, response, auth);
//        }
//        
//        HttpSession session = request.getSession(false);
//        if (session != null) {
//            session.invalidate();
//        }
//        
//        return "redirect:/signout"; // spring security에서 제공하는 로그 아웃 기능 호출
//    }
}
