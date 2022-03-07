package com.example.readxml.resource;


import com.example.readxml.FreemarkerConfig;
import com.example.readxml.ReadXmlApplication;
import com.example.readxml.model.Employee;
import com.example.readxml.model.Profile;
import com.example.readxml.service.ProfileService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.http.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfig;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/profile")
public class ProfileResource {

    private final ProfileService profileService;

    public ProfileResource(ProfileService profileService)
    {
        this.profileService = profileService;
    }

    @GetMapping("/connect")
    public ModelAndView connectToApp(Model model) throws IOException, TemplateException {
        List<Profile> profiles = profileService.findProfiles();

        RestTemplate restTemplate = new RestTemplate();

        ObjectMapper ow = new ObjectMapper();
        String requestJson = ow.writeValueAsString(profiles.get(0));

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> entity = new HttpEntity<String>(requestJson,headers);
        String response = restTemplate.postForObject("http://localhost:8081/connectToDb",entity,String.class);

        Employee[] e = ow.readValue(response, Employee[].class);


        Map<String,Object> params = new HashMap<>();
        params.put("employees",e);

        Writer file = new FileWriter(new File("hello-freemarker.html"));
        Template template = FreemarkerConfig.getConfig().getTemplate("index.ftl");
        template.process(params, file);
        file.flush();
        file.close();


        return new ModelAndView("index",params);
    }

    @GetMapping("/add")
    public ResponseEntity<Integer> getAllEmployees() throws IOException {
        InputStream is = ReadXmlApplication.class.getClassLoader().getResourceAsStream("data/file.xml");

        XmlMapper xmlMapper = new XmlMapper();

        List<Profile> profiles = xmlMapper.readValue(is, new TypeReference<List<Profile>>() {
        });

        for (Profile pr : profiles) {

            profileService.addProfile(pr);
        }

        return new ResponseEntity<>(null,HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Profile>> getAllProfiles()
    {
        List<Profile> profiles = profileService.findProfiles();
        return new ResponseEntity<>(profiles, HttpStatus.OK);
    }


}
