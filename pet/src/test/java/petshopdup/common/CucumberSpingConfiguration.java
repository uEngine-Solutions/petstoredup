package petshopdup.common;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import petshopdup.PetApplication;

@CucumberContextConfiguration
@SpringBootTest(classes = { PetApplication.class })
public class CucumberSpingConfiguration {}
