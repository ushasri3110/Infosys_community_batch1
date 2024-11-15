package com.infosys.authentication.controller;

import com.infosys.authentication.dto.AdminDetailsDto;
import com.infosys.authentication.dto.ResidentDetailsDto;
import com.infosys.authentication.exception.RegistrationException;
import com.infosys.authentication.response.ApiResponse;
import com.infosys.authentication.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {

    @Autowired
    RegistrationService registrationService;

    @PostMapping("/admin-register/{jwt}")
    public ApiResponse adminRegistration(@PathVariable String jwt, @RequestBody AdminDetailsDto adminDetailsDto) throws RegistrationException {
        return registrationService.adminRegistration(adminDetailsDto,jwt);
    }

    @PostMapping("/resident-register/{jwt}")
    public ApiResponse residentRegistration(@PathVariable String jwt, @RequestBody ResidentDetailsDto residentDetailsDto) throws RegistrationException {
        return registrationService.residentRegistration(residentDetailsDto,jwt);
    }
}
