package com.lucasramos.jakenotes.shared;

import com.lucasramos.jakenotes.JakeNotesApplication;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.NestedTestConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

@ActiveProfiles("test")
@NestedTestConfiguration(NestedTestConfiguration.EnclosingConfiguration.OVERRIDE)
@ExtendWith(SpringExtension.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.MOCK,
        classes = JakeNotesApplication.class)
@WebAppConfiguration
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public abstract class JakeNotesIntegrationTest { }