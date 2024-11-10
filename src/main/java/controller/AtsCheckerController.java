package controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import models.ATSmodel;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import service.AtsCheckerService;

@RestController
@RequiredArgsConstructor
public class AtsCheckerController {

    private final AtsCheckerService atsCheckerService;

    @GetMapping("/checkResume")
    public ATSmodel generateAtsDetails() throws IOException{
        Path path = Paths.get("C://Users/an1anand/JUnit Testing/ResumeAtsChecker/Manu_Anand-CV.docx");
        String name = path.getFileName().toString();
        System.out.println(name);

        byte[] bytes = null;
        try {
            bytes = Files.readAllBytes(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        MultipartFile file = new MockMultipartFile(name, name, "application/pdf", bytes);

        String desc = "•\tDriving initiatives to improve the reliability and performance of global infrastructure and services. \n" +
                "•\tProactively working on preventing incidents and preparing feedbacks for engineering teams.\n" +
                "•\tDeployment of clusters in vCenter and bare metal servers for critical services. \n" +
                "•\tUsing automations to deploy and configure K8s clusters to host internal services to support global operations. \n" +
                "•\tDeveloping and maintaining tools in bash and Python to replace manual work.\n" +
                "•\tPerforming Advanced troubleshooting focused on Network, Linux, and Databases (MariaDB).\n" +
                "Mentoring New Hires and aspiring SMEs for various operational service transition\n";
        return atsCheckerService.generateAtsDetails(file, desc);
    }
}
